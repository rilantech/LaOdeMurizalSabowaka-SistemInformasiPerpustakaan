package com.bumptech.glide;

import android.content.Context;
import androidx.tracing.Trace;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.util.GlideSuppliers;
import java.util.List;

final class RegistryFactory {
    private RegistryFactory() {
    }

    static GlideSuppliers.GlideSupplier<Registry> lazilyCreateAndInitializeRegistry(final Glide glide, final List<GlideModule> manifestModules, final AppGlideModule annotationGeneratedModule) {
        return new GlideSuppliers.GlideSupplier<Registry>() {
            private boolean isInitializing;

            public Registry get() {
                if (!this.isInitializing) {
                    Trace.beginSection("Glide registry");
                    this.isInitializing = true;
                    try {
                        return RegistryFactory.createAndInitRegistry(Glide.this, manifestModules, annotationGeneratedModule);
                    } finally {
                        this.isInitializing = false;
                        Trace.endSection();
                    }
                } else {
                    throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
                }
            }
        };
    }

    static Registry createAndInitRegistry(Glide glide, List<GlideModule> manifestModules, AppGlideModule annotationGeneratedModule) {
        BitmapPool bitmapPool = glide.getBitmapPool();
        ArrayPool arrayPool = glide.getArrayPool();
        Context context = glide.getGlideContext().getApplicationContext();
        GlideExperiments experiments = glide.getGlideContext().getExperiments();
        Registry registry = new Registry();
        initializeDefaults(context, registry, bitmapPool, arrayPool, experiments);
        initializeModules(context, glide, registry, manifestModules, annotationGeneratedModule);
        return registry;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0402  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void initializeDefaults(android.content.Context r26, com.bumptech.glide.Registry r27, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r28, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r29, com.bumptech.glide.GlideExperiments r30) {
        /*
            r0 = r26
            r1 = r27
            r2 = r28
            r3 = r29
            java.lang.Class<byte[]> r4 = byte[].class
            com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser r5 = new com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser
            r5.<init>()
            r1.register((com.bumptech.glide.load.ImageHeaderParser) r5)
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 27
            if (r5 < r6) goto L_0x0020
            com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser r5 = new com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser
            r5.<init>()
            r1.register((com.bumptech.glide.load.ImageHeaderParser) r5)
        L_0x0020:
            android.content.res.Resources r5 = r26.getResources()
            java.util.List r6 = r27.getImageHeaderParsers()
            com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder r7 = new com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder
            r7.<init>(r0, r6, r2, r3)
            com.bumptech.glide.load.ResourceDecoder r8 = com.bumptech.glide.load.resource.bitmap.VideoDecoder.parcel(r28)
            com.bumptech.glide.load.resource.bitmap.Downsampler r9 = new com.bumptech.glide.load.resource.bitmap.Downsampler
            java.util.List r10 = r27.getImageHeaderParsers()
            android.util.DisplayMetrics r11 = r5.getDisplayMetrics()
            r9.<init>(r10, r11, r2, r3)
            int r10 = android.os.Build.VERSION.SDK_INT
            r11 = 28
            if (r10 < r11) goto L_0x005a
            java.lang.Class<com.bumptech.glide.GlideBuilder$EnableImageDecoderForBitmaps> r10 = com.bumptech.glide.GlideBuilder.EnableImageDecoderForBitmaps.class
            r12 = r30
            boolean r10 = r12.isEnabled(r10)
            if (r10 == 0) goto L_0x005c
            com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder r10 = new com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder
            r10.<init>()
            com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder r13 = new com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder
            r13.<init>()
            goto L_0x0067
        L_0x005a:
            r12 = r30
        L_0x005c:
            com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder r10 = new com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder
            r10.<init>(r9)
            r13 = r10
            com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder r10 = new com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder
            r10.<init>(r9, r3)
        L_0x0067:
            int r14 = android.os.Build.VERSION.SDK_INT
            java.lang.String r15 = "Animation"
            if (r14 < r11) goto L_0x0083
            java.lang.Class<java.io.InputStream> r11 = java.io.InputStream.class
            java.lang.Class<android.graphics.drawable.Drawable> r14 = android.graphics.drawable.Drawable.class
            com.bumptech.glide.load.ResourceDecoder r12 = com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder.streamDecoder(r6, r3)
            r1.append(r15, r11, r14, r12)
            java.lang.Class<java.nio.ByteBuffer> r11 = java.nio.ByteBuffer.class
            java.lang.Class<android.graphics.drawable.Drawable> r12 = android.graphics.drawable.Drawable.class
            com.bumptech.glide.load.ResourceDecoder r14 = com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder.byteBufferDecoder(r6, r3)
            r1.append(r15, r11, r12, r14)
        L_0x0083:
            com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder r11 = new com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder
            r11.<init>(r0)
            com.bumptech.glide.load.resource.bitmap.BitmapEncoder r12 = new com.bumptech.glide.load.resource.bitmap.BitmapEncoder
            r12.<init>(r3)
            com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder r14 = new com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder
            r14.<init>()
            com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder r16 = new com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder
            r16.<init>()
            r17 = r16
            r16 = r14
            android.content.ContentResolver r14 = r26.getContentResolver()
            r18 = r4
            java.lang.Class<java.nio.ByteBuffer> r4 = java.nio.ByteBuffer.class
            r19 = r14
            com.bumptech.glide.load.model.ByteBufferEncoder r14 = new com.bumptech.glide.load.model.ByteBufferEncoder
            r14.<init>()
            com.bumptech.glide.Registry r4 = r1.append(r4, r14)
            java.lang.Class<java.io.InputStream> r14 = java.io.InputStream.class
            com.bumptech.glide.load.model.StreamEncoder r0 = new com.bumptech.glide.load.model.StreamEncoder
            r0.<init>(r3)
            com.bumptech.glide.Registry r0 = r4.append(r14, r0)
            java.lang.Class<java.nio.ByteBuffer> r4 = java.nio.ByteBuffer.class
            java.lang.Class<android.graphics.Bitmap> r14 = android.graphics.Bitmap.class
            r20 = r11
            java.lang.String r11 = "Bitmap"
            com.bumptech.glide.Registry r0 = r0.append(r11, r4, r14, r13)
            java.lang.Class<java.io.InputStream> r4 = java.io.InputStream.class
            java.lang.Class<android.graphics.Bitmap> r14 = android.graphics.Bitmap.class
            r0.append(r11, r4, r14, r10)
            boolean r0 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.isSupported()
            if (r0 == 0) goto L_0x00de
            java.lang.Class<android.os.ParcelFileDescriptor> r0 = android.os.ParcelFileDescriptor.class
            java.lang.Class<android.graphics.Bitmap> r4 = android.graphics.Bitmap.class
            com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder r14 = new com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder
            r14.<init>(r9)
            r1.append(r11, r0, r4, r14)
        L_0x00de:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 16
            if (r0 < r4) goto L_0x00ef
            java.lang.Class<android.content.res.AssetFileDescriptor> r0 = android.content.res.AssetFileDescriptor.class
            java.lang.Class<android.graphics.Bitmap> r4 = android.graphics.Bitmap.class
            com.bumptech.glide.load.ResourceDecoder r14 = com.bumptech.glide.load.resource.bitmap.VideoDecoder.asset(r28)
            r1.append(r11, r0, r4, r14)
        L_0x00ef:
            java.lang.Class<android.os.ParcelFileDescriptor> r0 = android.os.ParcelFileDescriptor.class
            java.lang.Class<android.graphics.Bitmap> r4 = android.graphics.Bitmap.class
            com.bumptech.glide.Registry r0 = r1.append(r11, r0, r4, r8)
            java.lang.Class<android.graphics.Bitmap> r4 = android.graphics.Bitmap.class
            java.lang.Class<android.graphics.Bitmap> r14 = android.graphics.Bitmap.class
            r21 = r9
            com.bumptech.glide.load.model.UnitModelLoader$Factory r9 = com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()
            com.bumptech.glide.Registry r0 = r0.append(r4, r14, r9)
            java.lang.Class<android.graphics.Bitmap> r4 = android.graphics.Bitmap.class
            java.lang.Class<android.graphics.Bitmap> r9 = android.graphics.Bitmap.class
            com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder r14 = new com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder
            r14.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r11, r4, r9, r14)
            java.lang.Class<android.graphics.Bitmap> r4 = android.graphics.Bitmap.class
            com.bumptech.glide.Registry r0 = r0.append(r4, r12)
            java.lang.Class<java.nio.ByteBuffer> r4 = java.nio.ByteBuffer.class
            java.lang.Class<android.graphics.drawable.BitmapDrawable> r9 = android.graphics.drawable.BitmapDrawable.class
            com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder r14 = new com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder
            r14.<init>((android.content.res.Resources) r5, r13)
            r22 = r13
            java.lang.String r13 = "BitmapDrawable"
            com.bumptech.glide.Registry r0 = r0.append(r13, r4, r9, r14)
            java.lang.Class<java.io.InputStream> r4 = java.io.InputStream.class
            java.lang.Class<android.graphics.drawable.BitmapDrawable> r9 = android.graphics.drawable.BitmapDrawable.class
            com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder r14 = new com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder
            r14.<init>((android.content.res.Resources) r5, r10)
            com.bumptech.glide.Registry r0 = r0.append(r13, r4, r9, r14)
            java.lang.Class<android.os.ParcelFileDescriptor> r4 = android.os.ParcelFileDescriptor.class
            java.lang.Class<android.graphics.drawable.BitmapDrawable> r9 = android.graphics.drawable.BitmapDrawable.class
            com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder r14 = new com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder
            r14.<init>((android.content.res.Resources) r5, r8)
            com.bumptech.glide.Registry r0 = r0.append(r13, r4, r9, r14)
            java.lang.Class<android.graphics.drawable.BitmapDrawable> r4 = android.graphics.drawable.BitmapDrawable.class
            com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder r9 = new com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder
            r9.<init>(r2, r12)
            com.bumptech.glide.Registry r0 = r0.append(r4, r9)
            java.lang.Class<java.io.InputStream> r4 = java.io.InputStream.class
            java.lang.Class<com.bumptech.glide.load.resource.gif.GifDrawable> r9 = com.bumptech.glide.load.resource.gif.GifDrawable.class
            com.bumptech.glide.load.resource.gif.StreamGifDecoder r13 = new com.bumptech.glide.load.resource.gif.StreamGifDecoder
            r13.<init>(r6, r7, r3)
            com.bumptech.glide.Registry r0 = r0.append(r15, r4, r9, r13)
            java.lang.Class<java.nio.ByteBuffer> r4 = java.nio.ByteBuffer.class
            java.lang.Class<com.bumptech.glide.load.resource.gif.GifDrawable> r9 = com.bumptech.glide.load.resource.gif.GifDrawable.class
            com.bumptech.glide.Registry r0 = r0.append(r15, r4, r9, r7)
            java.lang.Class<com.bumptech.glide.load.resource.gif.GifDrawable> r4 = com.bumptech.glide.load.resource.gif.GifDrawable.class
            com.bumptech.glide.load.resource.gif.GifDrawableEncoder r9 = new com.bumptech.glide.load.resource.gif.GifDrawableEncoder
            r9.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r4, r9)
            java.lang.Class<com.bumptech.glide.gifdecoder.GifDecoder> r4 = com.bumptech.glide.gifdecoder.GifDecoder.class
            java.lang.Class<com.bumptech.glide.gifdecoder.GifDecoder> r9 = com.bumptech.glide.gifdecoder.GifDecoder.class
            com.bumptech.glide.load.model.UnitModelLoader$Factory r13 = com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()
            com.bumptech.glide.Registry r0 = r0.append(r4, r9, r13)
            java.lang.Class<com.bumptech.glide.gifdecoder.GifDecoder> r4 = com.bumptech.glide.gifdecoder.GifDecoder.class
            java.lang.Class<android.graphics.Bitmap> r9 = android.graphics.Bitmap.class
            com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder r13 = new com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder
            r13.<init>(r2)
            com.bumptech.glide.Registry r0 = r0.append(r11, r4, r9, r13)
            java.lang.Class<android.net.Uri> r4 = android.net.Uri.class
            java.lang.Class<android.graphics.drawable.Drawable> r9 = android.graphics.drawable.Drawable.class
            r11 = r20
            com.bumptech.glide.Registry r0 = r0.append(r4, r9, r11)
            java.lang.Class<android.net.Uri> r4 = android.net.Uri.class
            java.lang.Class<android.graphics.Bitmap> r9 = android.graphics.Bitmap.class
            com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder r13 = new com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder
            r13.<init>(r11, r2)
            com.bumptech.glide.Registry r0 = r0.append(r4, r9, r13)
            com.bumptech.glide.load.resource.bytes.ByteBufferRewinder$Factory r4 = new com.bumptech.glide.load.resource.bytes.ByteBufferRewinder$Factory
            r4.<init>()
            com.bumptech.glide.Registry r0 = r0.register((com.bumptech.glide.load.data.DataRewinder.Factory<?>) r4)
            java.lang.Class<java.io.File> r4 = java.io.File.class
            java.lang.Class<java.nio.ByteBuffer> r9 = java.nio.ByteBuffer.class
            com.bumptech.glide.load.model.ByteBufferFileLoader$Factory r13 = new com.bumptech.glide.load.model.ByteBufferFileLoader$Factory
            r13.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r4, r9, r13)
            java.lang.Class<java.io.File> r4 = java.io.File.class
            java.lang.Class<java.io.InputStream> r9 = java.io.InputStream.class
            com.bumptech.glide.load.model.FileLoader$StreamFactory r13 = new com.bumptech.glide.load.model.FileLoader$StreamFactory
            r13.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r4, r9, r13)
            java.lang.Class<java.io.File> r4 = java.io.File.class
            java.lang.Class<java.io.File> r9 = java.io.File.class
            com.bumptech.glide.load.resource.file.FileDecoder r13 = new com.bumptech.glide.load.resource.file.FileDecoder
            r13.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r4, r9, r13)
            java.lang.Class<java.io.File> r4 = java.io.File.class
            java.lang.Class<android.os.ParcelFileDescriptor> r9 = android.os.ParcelFileDescriptor.class
            com.bumptech.glide.load.model.FileLoader$FileDescriptorFactory r13 = new com.bumptech.glide.load.model.FileLoader$FileDescriptorFactory
            r13.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r4, r9, r13)
            java.lang.Class<java.io.File> r4 = java.io.File.class
            java.lang.Class<java.io.File> r9 = java.io.File.class
            com.bumptech.glide.load.model.UnitModelLoader$Factory r13 = com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()
            com.bumptech.glide.Registry r0 = r0.append(r4, r9, r13)
            com.bumptech.glide.load.data.InputStreamRewinder$Factory r4 = new com.bumptech.glide.load.data.InputStreamRewinder$Factory
            r4.<init>(r3)
            r0.register((com.bumptech.glide.load.data.DataRewinder.Factory<?>) r4)
            boolean r0 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.isSupported()
            if (r0 == 0) goto L_0x01fd
            com.bumptech.glide.load.data.ParcelFileDescriptorRewinder$Factory r0 = new com.bumptech.glide.load.data.ParcelFileDescriptorRewinder$Factory
            r0.<init>()
            r1.register((com.bumptech.glide.load.data.DataRewinder.Factory<?>) r0)
        L_0x01fd:
            com.bumptech.glide.load.model.ModelLoaderFactory r0 = com.bumptech.glide.load.model.DirectResourceLoader.inputStreamFactory(r26)
            com.bumptech.glide.load.model.ModelLoaderFactory r4 = com.bumptech.glide.load.model.DirectResourceLoader.assetFileDescriptorFactory(r26)
            com.bumptech.glide.load.model.ModelLoaderFactory r9 = com.bumptech.glide.load.model.DirectResourceLoader.drawableFactory(r26)
            java.lang.Class r13 = java.lang.Integer.TYPE
            java.lang.Class<java.io.InputStream> r14 = java.io.InputStream.class
            com.bumptech.glide.Registry r13 = r1.append(r13, r14, r0)
            java.lang.Class<java.lang.Integer> r14 = java.lang.Integer.class
            java.lang.Class<java.io.InputStream> r15 = java.io.InputStream.class
            com.bumptech.glide.Registry r13 = r13.append(r14, r15, r0)
            java.lang.Class r14 = java.lang.Integer.TYPE
            java.lang.Class<android.content.res.AssetFileDescriptor> r15 = android.content.res.AssetFileDescriptor.class
            com.bumptech.glide.Registry r13 = r13.append(r14, r15, r4)
            java.lang.Class<java.lang.Integer> r14 = java.lang.Integer.class
            java.lang.Class<android.content.res.AssetFileDescriptor> r15 = android.content.res.AssetFileDescriptor.class
            com.bumptech.glide.Registry r13 = r13.append(r14, r15, r4)
            java.lang.Class r14 = java.lang.Integer.TYPE
            java.lang.Class<android.graphics.drawable.Drawable> r15 = android.graphics.drawable.Drawable.class
            com.bumptech.glide.Registry r13 = r13.append(r14, r15, r9)
            java.lang.Class<java.lang.Integer> r14 = java.lang.Integer.class
            java.lang.Class<android.graphics.drawable.Drawable> r15 = android.graphics.drawable.Drawable.class
            com.bumptech.glide.Registry r13 = r13.append(r14, r15, r9)
            java.lang.Class<android.net.Uri> r14 = android.net.Uri.class
            java.lang.Class<java.io.InputStream> r15 = java.io.InputStream.class
            r20 = r0
            com.bumptech.glide.load.model.ModelLoaderFactory r0 = com.bumptech.glide.load.model.ResourceUriLoader.newStreamFactory(r26)
            com.bumptech.glide.Registry r0 = r13.append(r14, r15, r0)
            java.lang.Class<android.net.Uri> r13 = android.net.Uri.class
            java.lang.Class<android.content.res.AssetFileDescriptor> r14 = android.content.res.AssetFileDescriptor.class
            com.bumptech.glide.load.model.ModelLoaderFactory r15 = com.bumptech.glide.load.model.ResourceUriLoader.newAssetFileDescriptorFactory(r26)
            r0.append(r13, r14, r15)
            com.bumptech.glide.load.model.ResourceLoader$UriFactory r0 = new com.bumptech.glide.load.model.ResourceLoader$UriFactory
            r0.<init>(r5)
            com.bumptech.glide.load.model.ResourceLoader$AssetFileDescriptorFactory r13 = new com.bumptech.glide.load.model.ResourceLoader$AssetFileDescriptorFactory
            r13.<init>(r5)
            com.bumptech.glide.load.model.ResourceLoader$StreamFactory r14 = new com.bumptech.glide.load.model.ResourceLoader$StreamFactory
            r14.<init>(r5)
            java.lang.Class<java.lang.Integer> r15 = java.lang.Integer.class
            java.lang.Class<android.net.Uri> r3 = android.net.Uri.class
            com.bumptech.glide.Registry r3 = r1.append(r15, r3, r0)
            java.lang.Class r15 = java.lang.Integer.TYPE
            r23 = r4
            java.lang.Class<android.net.Uri> r4 = android.net.Uri.class
            com.bumptech.glide.Registry r3 = r3.append(r15, r4, r0)
            java.lang.Class<java.lang.Integer> r4 = java.lang.Integer.class
            java.lang.Class<android.content.res.AssetFileDescriptor> r15 = android.content.res.AssetFileDescriptor.class
            com.bumptech.glide.Registry r3 = r3.append(r4, r15, r13)
            java.lang.Class r4 = java.lang.Integer.TYPE
            java.lang.Class<android.content.res.AssetFileDescriptor> r15 = android.content.res.AssetFileDescriptor.class
            com.bumptech.glide.Registry r3 = r3.append(r4, r15, r13)
            java.lang.Class<java.lang.Integer> r4 = java.lang.Integer.class
            java.lang.Class<java.io.InputStream> r15 = java.io.InputStream.class
            com.bumptech.glide.Registry r3 = r3.append(r4, r15, r14)
            java.lang.Class r4 = java.lang.Integer.TYPE
            java.lang.Class<java.io.InputStream> r15 = java.io.InputStream.class
            r3.append(r4, r15, r14)
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            java.lang.Class<java.io.InputStream> r4 = java.io.InputStream.class
            com.bumptech.glide.load.model.DataUrlLoader$StreamFactory r15 = new com.bumptech.glide.load.model.DataUrlLoader$StreamFactory
            r15.<init>()
            com.bumptech.glide.Registry r3 = r1.append(r3, r4, r15)
            java.lang.Class<android.net.Uri> r4 = android.net.Uri.class
            java.lang.Class<java.io.InputStream> r15 = java.io.InputStream.class
            r24 = r0
            com.bumptech.glide.load.model.DataUrlLoader$StreamFactory r0 = new com.bumptech.glide.load.model.DataUrlLoader$StreamFactory
            r0.<init>()
            com.bumptech.glide.Registry r0 = r3.append(r4, r15, r0)
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            java.lang.Class<java.io.InputStream> r4 = java.io.InputStream.class
            com.bumptech.glide.load.model.StringLoader$StreamFactory r15 = new com.bumptech.glide.load.model.StringLoader$StreamFactory
            r15.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r3, r4, r15)
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            java.lang.Class<android.os.ParcelFileDescriptor> r4 = android.os.ParcelFileDescriptor.class
            com.bumptech.glide.load.model.StringLoader$FileDescriptorFactory r15 = new com.bumptech.glide.load.model.StringLoader$FileDescriptorFactory
            r15.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r3, r4, r15)
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            java.lang.Class<android.content.res.AssetFileDescriptor> r4 = android.content.res.AssetFileDescriptor.class
            com.bumptech.glide.load.model.StringLoader$AssetFileDescriptorFactory r15 = new com.bumptech.glide.load.model.StringLoader$AssetFileDescriptorFactory
            r15.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r3, r4, r15)
            java.lang.Class<android.net.Uri> r3 = android.net.Uri.class
            java.lang.Class<java.io.InputStream> r4 = java.io.InputStream.class
            com.bumptech.glide.load.model.AssetUriLoader$StreamFactory r15 = new com.bumptech.glide.load.model.AssetUriLoader$StreamFactory
            r25 = r6
            android.content.res.AssetManager r6 = r26.getAssets()
            r15.<init>(r6)
            com.bumptech.glide.Registry r0 = r0.append(r3, r4, r15)
            java.lang.Class<android.net.Uri> r3 = android.net.Uri.class
            java.lang.Class<android.content.res.AssetFileDescriptor> r4 = android.content.res.AssetFileDescriptor.class
            com.bumptech.glide.load.model.AssetUriLoader$FileDescriptorFactory r6 = new com.bumptech.glide.load.model.AssetUriLoader$FileDescriptorFactory
            android.content.res.AssetManager r15 = r26.getAssets()
            r6.<init>(r15)
            com.bumptech.glide.Registry r0 = r0.append(r3, r4, r6)
            java.lang.Class<android.net.Uri> r3 = android.net.Uri.class
            java.lang.Class<java.io.InputStream> r4 = java.io.InputStream.class
            com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader$Factory r6 = new com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader$Factory
            r15 = r26
            r6.<init>(r15)
            com.bumptech.glide.Registry r0 = r0.append(r3, r4, r6)
            java.lang.Class<android.net.Uri> r3 = android.net.Uri.class
            java.lang.Class<java.io.InputStream> r4 = java.io.InputStream.class
            com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader$Factory r6 = new com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader$Factory
            r6.<init>(r15)
            r0.append(r3, r4, r6)
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            if (r0 < r3) goto L_0x0335
            java.lang.Class<android.net.Uri> r0 = android.net.Uri.class
            java.lang.Class<java.io.InputStream> r3 = java.io.InputStream.class
            com.bumptech.glide.load.model.stream.QMediaStoreUriLoader$InputStreamFactory r4 = new com.bumptech.glide.load.model.stream.QMediaStoreUriLoader$InputStreamFactory
            r4.<init>(r15)
            r1.append(r0, r3, r4)
            java.lang.Class<android.net.Uri> r0 = android.net.Uri.class
            java.lang.Class<android.os.ParcelFileDescriptor> r3 = android.os.ParcelFileDescriptor.class
            com.bumptech.glide.load.model.stream.QMediaStoreUriLoader$FileDescriptorFactory r4 = new com.bumptech.glide.load.model.stream.QMediaStoreUriLoader$FileDescriptorFactory
            r4.<init>(r15)
            r1.append(r0, r3, r4)
        L_0x0335:
            java.lang.Class<android.net.Uri> r0 = android.net.Uri.class
            java.lang.Class<java.io.InputStream> r3 = java.io.InputStream.class
            com.bumptech.glide.load.model.UriLoader$StreamFactory r4 = new com.bumptech.glide.load.model.UriLoader$StreamFactory
            r6 = r19
            r4.<init>(r6)
            com.bumptech.glide.Registry r0 = r1.append(r0, r3, r4)
            java.lang.Class<android.net.Uri> r3 = android.net.Uri.class
            java.lang.Class<android.os.ParcelFileDescriptor> r4 = android.os.ParcelFileDescriptor.class
            r19 = r7
            com.bumptech.glide.load.model.UriLoader$FileDescriptorFactory r7 = new com.bumptech.glide.load.model.UriLoader$FileDescriptorFactory
            r7.<init>(r6)
            com.bumptech.glide.Registry r0 = r0.append(r3, r4, r7)
            java.lang.Class<android.net.Uri> r3 = android.net.Uri.class
            java.lang.Class<android.content.res.AssetFileDescriptor> r4 = android.content.res.AssetFileDescriptor.class
            com.bumptech.glide.load.model.UriLoader$AssetFileDescriptorFactory r7 = new com.bumptech.glide.load.model.UriLoader$AssetFileDescriptorFactory
            r7.<init>(r6)
            com.bumptech.glide.Registry r0 = r0.append(r3, r4, r7)
            java.lang.Class<android.net.Uri> r3 = android.net.Uri.class
            java.lang.Class<java.io.InputStream> r4 = java.io.InputStream.class
            com.bumptech.glide.load.model.UrlUriLoader$StreamFactory r7 = new com.bumptech.glide.load.model.UrlUriLoader$StreamFactory
            r7.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r3, r4, r7)
            java.lang.Class<java.net.URL> r3 = java.net.URL.class
            java.lang.Class<java.io.InputStream> r4 = java.io.InputStream.class
            com.bumptech.glide.load.model.stream.UrlLoader$StreamFactory r7 = new com.bumptech.glide.load.model.stream.UrlLoader$StreamFactory
            r7.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r3, r4, r7)
            java.lang.Class<android.net.Uri> r3 = android.net.Uri.class
            java.lang.Class<java.io.File> r4 = java.io.File.class
            com.bumptech.glide.load.model.MediaStoreFileLoader$Factory r7 = new com.bumptech.glide.load.model.MediaStoreFileLoader$Factory
            r7.<init>(r15)
            com.bumptech.glide.Registry r0 = r0.append(r3, r4, r7)
            java.lang.Class<com.bumptech.glide.load.model.GlideUrl> r3 = com.bumptech.glide.load.model.GlideUrl.class
            java.lang.Class<java.io.InputStream> r4 = java.io.InputStream.class
            com.bumptech.glide.load.model.stream.HttpGlideUrlLoader$Factory r7 = new com.bumptech.glide.load.model.stream.HttpGlideUrlLoader$Factory
            r7.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r3, r4, r7)
            java.lang.Class<java.nio.ByteBuffer> r3 = java.nio.ByteBuffer.class
            com.bumptech.glide.load.model.ByteArrayLoader$ByteBufferFactory r4 = new com.bumptech.glide.load.model.ByteArrayLoader$ByteBufferFactory
            r4.<init>()
            r7 = r18
            com.bumptech.glide.Registry r0 = r0.append(r7, r3, r4)
            java.lang.Class<java.io.InputStream> r3 = java.io.InputStream.class
            com.bumptech.glide.load.model.ByteArrayLoader$StreamFactory r4 = new com.bumptech.glide.load.model.ByteArrayLoader$StreamFactory
            r4.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r7, r3, r4)
            java.lang.Class<android.net.Uri> r3 = android.net.Uri.class
            java.lang.Class<android.net.Uri> r4 = android.net.Uri.class
            r18 = r6
            com.bumptech.glide.load.model.UnitModelLoader$Factory r6 = com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()
            com.bumptech.glide.Registry r0 = r0.append(r3, r4, r6)
            java.lang.Class<android.graphics.drawable.Drawable> r3 = android.graphics.drawable.Drawable.class
            java.lang.Class<android.graphics.drawable.Drawable> r4 = android.graphics.drawable.Drawable.class
            com.bumptech.glide.load.model.UnitModelLoader$Factory r6 = com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()
            com.bumptech.glide.Registry r0 = r0.append(r3, r4, r6)
            java.lang.Class<android.graphics.drawable.Drawable> r3 = android.graphics.drawable.Drawable.class
            java.lang.Class<android.graphics.drawable.Drawable> r4 = android.graphics.drawable.Drawable.class
            com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder r6 = new com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder
            r6.<init>()
            com.bumptech.glide.Registry r0 = r0.append(r3, r4, r6)
            java.lang.Class<android.graphics.Bitmap> r3 = android.graphics.Bitmap.class
            java.lang.Class<android.graphics.drawable.BitmapDrawable> r4 = android.graphics.drawable.BitmapDrawable.class
            com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder r6 = new com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder
            r6.<init>((android.content.res.Resources) r5)
            com.bumptech.glide.Registry r0 = r0.register(r3, r4, r6)
            java.lang.Class<android.graphics.Bitmap> r3 = android.graphics.Bitmap.class
            r4 = r16
            com.bumptech.glide.Registry r0 = r0.register(r3, r7, r4)
            java.lang.Class<android.graphics.drawable.Drawable> r3 = android.graphics.drawable.Drawable.class
            com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder r6 = new com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder
            r16 = r8
            r8 = r17
            r6.<init>(r2, r4, r8)
            com.bumptech.glide.Registry r0 = r0.register(r3, r7, r6)
            java.lang.Class<com.bumptech.glide.load.resource.gif.GifDrawable> r3 = com.bumptech.glide.load.resource.gif.GifDrawable.class
            r0.register(r3, r7, r8)
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r0 < r3) goto L_0x041a
            com.bumptech.glide.load.ResourceDecoder r0 = com.bumptech.glide.load.resource.bitmap.VideoDecoder.byteBuffer(r28)
            java.lang.Class<java.nio.ByteBuffer> r3 = java.nio.ByteBuffer.class
            java.lang.Class<android.graphics.Bitmap> r6 = android.graphics.Bitmap.class
            r1.append(r3, r6, r0)
            java.lang.Class<java.nio.ByteBuffer> r3 = java.nio.ByteBuffer.class
            java.lang.Class<android.graphics.drawable.BitmapDrawable> r6 = android.graphics.drawable.BitmapDrawable.class
            com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder r7 = new com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder
            r7.<init>((android.content.res.Resources) r5, r0)
            r1.append(r3, r6, r7)
        L_0x041a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.RegistryFactory.initializeDefaults(android.content.Context, com.bumptech.glide.Registry, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool, com.bumptech.glide.GlideExperiments):void");
    }

    private static void initializeModules(Context context, Glide glide, Registry registry, List<GlideModule> manifestModules, AppGlideModule annotationGeneratedModule) {
        for (GlideModule module : manifestModules) {
            try {
                module.registerComponents(context, glide, registry);
            } catch (AbstractMethodError e) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + module.getClass().getName(), e);
            }
        }
        if (annotationGeneratedModule != null) {
            annotationGeneratedModule.registerComponents(context, glide, registry);
        }
    }
}
