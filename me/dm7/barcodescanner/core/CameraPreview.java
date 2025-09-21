package me.dm7.barcodescanner.core;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.List;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "CameraPreview";
    Camera.AutoFocusCallback autoFocusCB = new Camera.AutoFocusCallback() {
        public void onAutoFocus(boolean success, Camera camera) {
            CameraPreview.this.scheduleAutoFocus();
        }
    };
    private Runnable doAutoFocus = new Runnable() {
        public void run() {
            if (CameraPreview.this.mCameraWrapper != null && CameraPreview.this.mPreviewing && CameraPreview.this.mAutoFocus && CameraPreview.this.mSurfaceCreated) {
                CameraPreview.this.safeAutoFocus();
            }
        }
    };
    private float mAspectTolerance = 0.1f;
    /* access modifiers changed from: private */
    public boolean mAutoFocus = true;
    private Handler mAutoFocusHandler;
    /* access modifiers changed from: private */
    public CameraWrapper mCameraWrapper;
    private Camera.PreviewCallback mPreviewCallback;
    /* access modifiers changed from: private */
    public boolean mPreviewing = true;
    private boolean mShouldScaleToFill = true;
    /* access modifiers changed from: private */
    public boolean mSurfaceCreated = false;

    public CameraPreview(Context context, CameraWrapper cameraWrapper, Camera.PreviewCallback previewCallback) {
        super(context);
        init(cameraWrapper, previewCallback);
    }

    public CameraPreview(Context context, AttributeSet attrs, CameraWrapper cameraWrapper, Camera.PreviewCallback previewCallback) {
        super(context, attrs);
        init(cameraWrapper, previewCallback);
    }

    public void init(CameraWrapper cameraWrapper, Camera.PreviewCallback previewCallback) {
        setCamera(cameraWrapper, previewCallback);
        this.mAutoFocusHandler = new Handler();
        getHolder().addCallback(this);
        getHolder().setType(3);
    }

    public void setCamera(CameraWrapper cameraWrapper, Camera.PreviewCallback previewCallback) {
        this.mCameraWrapper = cameraWrapper;
        this.mPreviewCallback = previewCallback;
    }

    public void setShouldScaleToFill(boolean scaleToFill) {
        this.mShouldScaleToFill = scaleToFill;
    }

    public void setAspectTolerance(float aspectTolerance) {
        this.mAspectTolerance = aspectTolerance;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceCreated = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder.getSurface() != null) {
            stopCameraPreview();
            showCameraPreview();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mSurfaceCreated = false;
        stopCameraPreview();
    }

    public void showCameraPreview() {
        if (this.mCameraWrapper != null) {
            try {
                getHolder().addCallback(this);
                this.mPreviewing = true;
                setupCameraParameters();
                this.mCameraWrapper.mCamera.setPreviewDisplay(getHolder());
                this.mCameraWrapper.mCamera.setDisplayOrientation(getDisplayOrientation());
                this.mCameraWrapper.mCamera.setOneShotPreviewCallback(this.mPreviewCallback);
                this.mCameraWrapper.mCamera.startPreview();
                if (!this.mAutoFocus) {
                    return;
                }
                if (this.mSurfaceCreated) {
                    safeAutoFocus();
                } else {
                    scheduleAutoFocus();
                }
            } catch (Exception e) {
                Log.e(TAG, e.toString(), e);
            }
        }
    }

    public void safeAutoFocus() {
        try {
            this.mCameraWrapper.mCamera.autoFocus(this.autoFocusCB);
        } catch (RuntimeException e) {
            scheduleAutoFocus();
        }
    }

    public void stopCameraPreview() {
        if (this.mCameraWrapper != null) {
            try {
                this.mPreviewing = false;
                getHolder().removeCallback(this);
                this.mCameraWrapper.mCamera.cancelAutoFocus();
                this.mCameraWrapper.mCamera.setOneShotPreviewCallback((Camera.PreviewCallback) null);
                this.mCameraWrapper.mCamera.stopPreview();
            } catch (Exception e) {
                Log.e(TAG, e.toString(), e);
            }
        }
    }

    public void setupCameraParameters() {
        Camera.Size optimalSize = getOptimalPreviewSize();
        Camera.Parameters parameters = this.mCameraWrapper.mCamera.getParameters();
        parameters.setPreviewSize(optimalSize.width, optimalSize.height);
        this.mCameraWrapper.mCamera.setParameters(parameters);
        adjustViewSize(optimalSize);
    }

    private void adjustViewSize(Camera.Size cameraSize) {
        Point previewSize = convertSizeToLandscapeOrientation(new Point(getWidth(), getHeight()));
        float cameraRatio = ((float) cameraSize.width) / ((float) cameraSize.height);
        if (((float) previewSize.x) / ((float) previewSize.y) > cameraRatio) {
            setViewSize((int) (((float) previewSize.y) * cameraRatio), previewSize.y);
        } else {
            setViewSize(previewSize.x, (int) (((float) previewSize.x) / cameraRatio));
        }
    }

    private Point convertSizeToLandscapeOrientation(Point size) {
        if (getDisplayOrientation() % 180 == 0) {
            return size;
        }
        return new Point(size.y, size.x);
    }

    private void setViewSize(int width, int height) {
        int tmpHeight;
        int tmpWidth;
        float compensation;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (getDisplayOrientation() % 180 == 0) {
            tmpWidth = width;
            tmpHeight = height;
        } else {
            tmpWidth = height;
            tmpHeight = width;
        }
        if (this.mShouldScaleToFill) {
            float ratioWidth = ((float) ((View) getParent()).getWidth()) / ((float) tmpWidth);
            float ratioHeight = ((float) ((View) getParent()).getHeight()) / ((float) tmpHeight);
            if (ratioWidth > ratioHeight) {
                compensation = ratioWidth;
            } else {
                compensation = ratioHeight;
            }
            tmpWidth = Math.round(((float) tmpWidth) * compensation);
            tmpHeight = Math.round(((float) tmpHeight) * compensation);
        }
        layoutParams.width = tmpWidth;
        layoutParams.height = tmpHeight;
        setLayoutParams(layoutParams);
    }

    public int getDisplayOrientation() {
        if (this.mCameraWrapper == null) {
            return 0;
        }
        Camera.CameraInfo info = new Camera.CameraInfo();
        if (this.mCameraWrapper.mCameraId == -1) {
            Camera.getCameraInfo(0, info);
        } else {
            Camera.getCameraInfo(this.mCameraWrapper.mCameraId, info);
        }
        int degrees = 0;
        switch (((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
            case 0:
                degrees = 0;
                break;
            case 1:
                degrees = 90;
                break;
            case 2:
                degrees = 180;
                break;
            case 3:
                degrees = 270;
                break;
        }
        if (info.facing == 1) {
            return (360 - ((info.orientation + degrees) % 360)) % 360;
        }
        return ((info.orientation - degrees) + 360) % 360;
    }

    private Camera.Size getOptimalPreviewSize() {
        int h;
        int w;
        CameraWrapper cameraWrapper = this.mCameraWrapper;
        if (cameraWrapper == null) {
            return null;
        }
        List<Camera.Size> sizes = cameraWrapper.mCamera.getParameters().getSupportedPreviewSizes();
        int w2 = getWidth();
        int h2 = getHeight();
        if (DisplayUtils.getScreenOrientation(getContext()) == 1) {
            int portraitWidth = h2;
            h2 = w2;
            w2 = portraitWidth;
        }
        double targetRatio = ((double) w) / ((double) h);
        if (sizes == null) {
            return null;
        }
        Camera.Size optimalSize = null;
        double minDiff = Double.MAX_VALUE;
        int targetHeight = h;
        for (Camera.Size size : sizes) {
            int w3 = w;
            int h3 = h;
            if (Math.abs((((double) size.width) / ((double) size.height)) - targetRatio) > ((double) this.mAspectTolerance)) {
                w = w3;
                h = h3;
            } else {
                if (((double) Math.abs(size.height - targetHeight)) < minDiff) {
                    optimalSize = size;
                    minDiff = (double) Math.abs(size.height - targetHeight);
                }
                w = w3;
                h = h3;
            }
        }
        int i = h;
        if (optimalSize == null) {
            double minDiff2 = Double.MAX_VALUE;
            for (Camera.Size size2 : sizes) {
                if (((double) Math.abs(size2.height - targetHeight)) < minDiff2) {
                    optimalSize = size2;
                    minDiff2 = (double) Math.abs(size2.height - targetHeight);
                }
            }
            double d = minDiff2;
        }
        return optimalSize;
    }

    public void setAutoFocus(boolean state) {
        if (this.mCameraWrapper != null && this.mPreviewing && state != this.mAutoFocus) {
            this.mAutoFocus = state;
            if (!state) {
                Log.v(TAG, "Cancelling autofocus");
                this.mCameraWrapper.mCamera.cancelAutoFocus();
            } else if (this.mSurfaceCreated) {
                Log.v(TAG, "Starting autofocus");
                safeAutoFocus();
            } else {
                scheduleAutoFocus();
            }
        }
    }

    /* access modifiers changed from: private */
    public void scheduleAutoFocus() {
        this.mAutoFocusHandler.postDelayed(this.doAutoFocus, 1000);
    }
}
