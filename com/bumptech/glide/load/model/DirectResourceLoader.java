package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.IOException;
import java.io.InputStream;

public final class DirectResourceLoader<DataT> implements ModelLoader<Integer, DataT> {
    private final Context context;
    private final ResourceOpener<DataT> resourceOpener;

    private interface ResourceOpener<DataT> {
        void close(DataT datat) throws IOException;

        Class<DataT> getDataClass();

        DataT open(Resources.Theme theme, Resources resources, int i);
    }

    public static ModelLoaderFactory<Integer, InputStream> inputStreamFactory(Context context2) {
        return new InputStreamFactory(context2);
    }

    public static ModelLoaderFactory<Integer, AssetFileDescriptor> assetFileDescriptorFactory(Context context2) {
        return new AssetFileDescriptorFactory(context2);
    }

    public static ModelLoaderFactory<Integer, Drawable> drawableFactory(Context context2) {
        return new DrawableFactory(context2);
    }

    DirectResourceLoader(Context context2, ResourceOpener<DataT> resourceOpener2) {
        this.context = context2.getApplicationContext();
        this.resourceOpener = resourceOpener2;
    }

    public ModelLoader.LoadData<DataT> buildLoadData(Integer resourceId, int width, int height, Options options) {
        Resources resources;
        Resources.Theme theme = (Resources.Theme) options.get(ResourceDrawableDecoder.THEME);
        if (Build.VERSION.SDK_INT < 21 || theme == null) {
            resources = this.context.getResources();
        } else {
            resources = theme.getResources();
        }
        return new ModelLoader.LoadData<>(new ObjectKey(resourceId), new ResourceDataFetcher(theme, resources, this.resourceOpener, resourceId.intValue()));
    }

    public boolean handles(Integer integer) {
        return true;
    }

    private static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor>, ResourceOpener<AssetFileDescriptor> {
        private final Context context;

        AssetFileDescriptorFactory(Context context2) {
            this.context = context2;
        }

        public AssetFileDescriptor open(Resources.Theme theme, Resources resources, int resourceId) {
            return resources.openRawResourceFd(resourceId);
        }

        public void close(AssetFileDescriptor data) throws IOException {
            data.close();
        }

        public Class<AssetFileDescriptor> getDataClass() {
            return AssetFileDescriptor.class;
        }

        public ModelLoader<Integer, AssetFileDescriptor> build(MultiModelLoaderFactory multiFactory) {
            return new DirectResourceLoader(this.context, this);
        }

        public void teardown() {
        }
    }

    private static final class InputStreamFactory implements ModelLoaderFactory<Integer, InputStream>, ResourceOpener<InputStream> {
        private final Context context;

        InputStreamFactory(Context context2) {
            this.context = context2;
        }

        public ModelLoader<Integer, InputStream> build(MultiModelLoaderFactory multiFactory) {
            return new DirectResourceLoader(this.context, this);
        }

        public InputStream open(Resources.Theme theme, Resources resources, int resourceId) {
            return resources.openRawResource(resourceId);
        }

        public void close(InputStream data) throws IOException {
            data.close();
        }

        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }

        public void teardown() {
        }
    }

    private static final class DrawableFactory implements ModelLoaderFactory<Integer, Drawable>, ResourceOpener<Drawable> {
        private final Context context;

        DrawableFactory(Context context2) {
            this.context = context2;
        }

        public Drawable open(Resources.Theme theme, Resources resources, int resourceId) {
            return DrawableDecoderCompat.getDrawable(this.context, resourceId, theme);
        }

        public void close(Drawable data) throws IOException {
        }

        public Class<Drawable> getDataClass() {
            return Drawable.class;
        }

        public ModelLoader<Integer, Drawable> build(MultiModelLoaderFactory multiFactory) {
            return new DirectResourceLoader(this.context, this);
        }

        public void teardown() {
        }
    }

    private static final class ResourceDataFetcher<DataT> implements DataFetcher<DataT> {
        private DataT data;
        private final int resourceId;
        private final ResourceOpener<DataT> resourceOpener;
        private final Resources resources;
        private final Resources.Theme theme;

        ResourceDataFetcher(Resources.Theme theme2, Resources resources2, ResourceOpener<DataT> resourceOpener2, int resourceId2) {
            this.theme = theme2;
            this.resources = resources2;
            this.resourceOpener = resourceOpener2;
            this.resourceId = resourceId2;
        }

        public void loadData(Priority priority, DataFetcher.DataCallback<? super DataT> callback) {
            try {
                DataT open = this.resourceOpener.open(this.theme, this.resources, this.resourceId);
                this.data = open;
                callback.onDataReady(open);
            } catch (Resources.NotFoundException e) {
                callback.onLoadFailed(e);
            }
        }

        public void cleanup() {
            DataT local = this.data;
            if (local != null) {
                try {
                    this.resourceOpener.close(local);
                } catch (IOException e) {
                }
            }
        }

        public void cancel() {
        }

        public Class<DataT> getDataClass() {
            return this.resourceOpener.getDataClass();
        }

        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }
}
