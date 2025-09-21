package com.bumptech.glide.load.resource.drawable;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.DefaultOnHeaderDecodedListener;
import com.bumptech.glide.util.ByteBufferUtil;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class AnimatedImageDecoder {
    private final ArrayPool arrayPool;
    private final List<ImageHeaderParser> imageHeaderParsers;

    public static ResourceDecoder<InputStream, Drawable> streamDecoder(List<ImageHeaderParser> imageHeaderParsers2, ArrayPool arrayPool2) {
        return new StreamAnimatedImageDecoder(new AnimatedImageDecoder(imageHeaderParsers2, arrayPool2));
    }

    public static ResourceDecoder<ByteBuffer, Drawable> byteBufferDecoder(List<ImageHeaderParser> imageHeaderParsers2, ArrayPool arrayPool2) {
        return new ByteBufferAnimatedImageDecoder(new AnimatedImageDecoder(imageHeaderParsers2, arrayPool2));
    }

    private AnimatedImageDecoder(List<ImageHeaderParser> imageHeaderParsers2, ArrayPool arrayPool2) {
        this.imageHeaderParsers = imageHeaderParsers2;
        this.arrayPool = arrayPool2;
    }

    /* access modifiers changed from: package-private */
    public boolean handles(ByteBuffer byteBuffer) throws IOException {
        return isHandled(ImageHeaderParserUtils.getType(this.imageHeaderParsers, byteBuffer));
    }

    /* access modifiers changed from: package-private */
    public boolean handles(InputStream is) throws IOException {
        return isHandled(ImageHeaderParserUtils.getType(this.imageHeaderParsers, is, this.arrayPool));
    }

    private boolean isHandled(ImageHeaderParser.ImageType imageType) {
        return imageType == ImageHeaderParser.ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageType == ImageHeaderParser.ImageType.ANIMATED_AVIF);
    }

    /* access modifiers changed from: package-private */
    public Resource<Drawable> decode(ImageDecoder.Source source, int width, int height, Options options) throws IOException {
        Drawable decoded = ImageDecoder.decodeDrawable(source, new DefaultOnHeaderDecodedListener(width, height, options));
        if (decoded instanceof AnimatedImageDrawable) {
            return new AnimatedImageDrawableResource((AnimatedImageDrawable) decoded);
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + decoded);
    }

    private static final class AnimatedImageDrawableResource implements Resource<Drawable> {
        private static final int ESTIMATED_NUMBER_OF_FRAMES = 2;
        private final AnimatedImageDrawable imageDrawable;

        AnimatedImageDrawableResource(AnimatedImageDrawable imageDrawable2) {
            this.imageDrawable = imageDrawable2;
        }

        public Class<Drawable> getResourceClass() {
            return Drawable.class;
        }

        public AnimatedImageDrawable get() {
            return this.imageDrawable;
        }

        public int getSize() {
            return this.imageDrawable.getIntrinsicWidth() * this.imageDrawable.getIntrinsicHeight() * Util.getBytesPerPixel(Bitmap.Config.ARGB_8888) * 2;
        }

        public void recycle() {
            this.imageDrawable.stop();
            this.imageDrawable.clearAnimationCallbacks();
        }
    }

    private static final class StreamAnimatedImageDecoder implements ResourceDecoder<InputStream, Drawable> {
        private final AnimatedImageDecoder delegate;

        StreamAnimatedImageDecoder(AnimatedImageDecoder delegate2) {
            this.delegate = delegate2;
        }

        public boolean handles(InputStream source, Options options) throws IOException {
            return this.delegate.handles(source);
        }

        public Resource<Drawable> decode(InputStream is, int width, int height, Options options) throws IOException {
            return this.delegate.decode(ImageDecoder.createSource(ByteBufferUtil.fromStream(is)), width, height, options);
        }
    }

    private static final class ByteBufferAnimatedImageDecoder implements ResourceDecoder<ByteBuffer, Drawable> {
        private final AnimatedImageDecoder delegate;

        ByteBufferAnimatedImageDecoder(AnimatedImageDecoder delegate2) {
            this.delegate = delegate2;
        }

        public boolean handles(ByteBuffer source, Options options) throws IOException {
            return this.delegate.handles(source);
        }

        public Resource<Drawable> decode(ByteBuffer byteBuffer, int width, int height, Options options) throws IOException {
            return this.delegate.decode(ImageDecoder.createSource(byteBuffer), width, height, options);
        }
    }
}
