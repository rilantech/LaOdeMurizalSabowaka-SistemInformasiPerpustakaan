package me.dm7.barcodescanner.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import kotlinx.coroutines.DebugKt;

public abstract class BarcodeScannerView extends FrameLayout implements Camera.PreviewCallback {
    private float mAspectTolerance = 0.1f;
    private boolean mAutofocusState = true;
    private float mBorderAlpha = 1.0f;
    private int mBorderColor = getResources().getColor(R.color.viewfinder_border);
    private int mBorderLength = getResources().getInteger(R.integer.viewfinder_border_length);
    private int mBorderWidth = getResources().getInteger(R.integer.viewfinder_border_width);
    private CameraHandlerThread mCameraHandlerThread;
    private CameraWrapper mCameraWrapper;
    private int mCornerRadius = 0;
    private Boolean mFlashState;
    private Rect mFramingRectInPreview;
    private boolean mIsLaserEnabled = true;
    private int mLaserColor = getResources().getColor(R.color.viewfinder_laser);
    private int mMaskColor = getResources().getColor(R.color.viewfinder_mask);
    private CameraPreview mPreview;
    private boolean mRoundedCorner = false;
    private boolean mShouldScaleToFill = true;
    private boolean mSquaredFinder = false;
    private int mViewFinderOffset = 0;
    private IViewFinder mViewFinderView;

    public BarcodeScannerView(Context context) {
        super(context);
        init();
    }

    /* JADX INFO: finally extract failed */
    public BarcodeScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray a = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BarcodeScannerView, 0, 0);
        try {
            setShouldScaleToFill(a.getBoolean(R.styleable.BarcodeScannerView_shouldScaleToFill, true));
            this.mIsLaserEnabled = a.getBoolean(R.styleable.BarcodeScannerView_laserEnabled, this.mIsLaserEnabled);
            this.mLaserColor = a.getColor(R.styleable.BarcodeScannerView_laserColor, this.mLaserColor);
            this.mBorderColor = a.getColor(R.styleable.BarcodeScannerView_borderColor, this.mBorderColor);
            this.mMaskColor = a.getColor(R.styleable.BarcodeScannerView_maskColor, this.mMaskColor);
            this.mBorderWidth = a.getDimensionPixelSize(R.styleable.BarcodeScannerView_borderWidth, this.mBorderWidth);
            this.mBorderLength = a.getDimensionPixelSize(R.styleable.BarcodeScannerView_borderLength, this.mBorderLength);
            this.mRoundedCorner = a.getBoolean(R.styleable.BarcodeScannerView_roundedCorner, this.mRoundedCorner);
            this.mCornerRadius = a.getDimensionPixelSize(R.styleable.BarcodeScannerView_cornerRadius, this.mCornerRadius);
            this.mSquaredFinder = a.getBoolean(R.styleable.BarcodeScannerView_squaredFinder, this.mSquaredFinder);
            this.mBorderAlpha = a.getFloat(R.styleable.BarcodeScannerView_borderAlpha, this.mBorderAlpha);
            this.mViewFinderOffset = a.getDimensionPixelSize(R.styleable.BarcodeScannerView_finderOffset, this.mViewFinderOffset);
            a.recycle();
            init();
        } catch (Throwable th) {
            a.recycle();
            throw th;
        }
    }

    private void init() {
        this.mViewFinderView = createViewFinderView(getContext());
    }

    public final void setupLayout(CameraWrapper cameraWrapper) {
        removeAllViews();
        CameraPreview cameraPreview = new CameraPreview(getContext(), cameraWrapper, this);
        this.mPreview = cameraPreview;
        cameraPreview.setAspectTolerance(this.mAspectTolerance);
        this.mPreview.setShouldScaleToFill(this.mShouldScaleToFill);
        if (!this.mShouldScaleToFill) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setGravity(17);
            relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            relativeLayout.addView(this.mPreview);
            addView(relativeLayout);
        } else {
            addView(this.mPreview);
        }
        IViewFinder iViewFinder = this.mViewFinderView;
        if (iViewFinder instanceof View) {
            addView((View) iViewFinder);
            return;
        }
        throw new IllegalArgumentException("IViewFinder object returned by 'createViewFinderView()' should be instance of android.view.View");
    }

    /* access modifiers changed from: protected */
    public IViewFinder createViewFinderView(Context context) {
        ViewFinderView viewFinderView = new ViewFinderView(context);
        viewFinderView.setBorderColor(this.mBorderColor);
        viewFinderView.setLaserColor(this.mLaserColor);
        viewFinderView.setLaserEnabled(this.mIsLaserEnabled);
        viewFinderView.setBorderStrokeWidth(this.mBorderWidth);
        viewFinderView.setBorderLineLength(this.mBorderLength);
        viewFinderView.setMaskColor(this.mMaskColor);
        viewFinderView.setBorderCornerRounded(this.mRoundedCorner);
        viewFinderView.setBorderCornerRadius(this.mCornerRadius);
        viewFinderView.setSquareViewFinder(this.mSquaredFinder);
        viewFinderView.setViewFinderOffset(this.mViewFinderOffset);
        return viewFinderView;
    }

    public void setLaserColor(int laserColor) {
        this.mLaserColor = laserColor;
        this.mViewFinderView.setLaserColor(laserColor);
        this.mViewFinderView.setupViewFinder();
    }

    public void setMaskColor(int maskColor) {
        this.mMaskColor = maskColor;
        this.mViewFinderView.setMaskColor(maskColor);
        this.mViewFinderView.setupViewFinder();
    }

    public void setBorderColor(int borderColor) {
        this.mBorderColor = borderColor;
        this.mViewFinderView.setBorderColor(borderColor);
        this.mViewFinderView.setupViewFinder();
    }

    public void setBorderStrokeWidth(int borderStrokeWidth) {
        this.mBorderWidth = borderStrokeWidth;
        this.mViewFinderView.setBorderStrokeWidth(borderStrokeWidth);
        this.mViewFinderView.setupViewFinder();
    }

    public void setBorderLineLength(int borderLineLength) {
        this.mBorderLength = borderLineLength;
        this.mViewFinderView.setBorderLineLength(borderLineLength);
        this.mViewFinderView.setupViewFinder();
    }

    public void setLaserEnabled(boolean isLaserEnabled) {
        this.mIsLaserEnabled = isLaserEnabled;
        this.mViewFinderView.setLaserEnabled(isLaserEnabled);
        this.mViewFinderView.setupViewFinder();
    }

    public void setIsBorderCornerRounded(boolean isBorderCornerRounded) {
        this.mRoundedCorner = isBorderCornerRounded;
        this.mViewFinderView.setBorderCornerRounded(isBorderCornerRounded);
        this.mViewFinderView.setupViewFinder();
    }

    public void setBorderCornerRadius(int borderCornerRadius) {
        this.mCornerRadius = borderCornerRadius;
        this.mViewFinderView.setBorderCornerRadius(borderCornerRadius);
        this.mViewFinderView.setupViewFinder();
    }

    public void setSquareViewFinder(boolean isSquareViewFinder) {
        this.mSquaredFinder = isSquareViewFinder;
        this.mViewFinderView.setSquareViewFinder(isSquareViewFinder);
        this.mViewFinderView.setupViewFinder();
    }

    public void setBorderAlpha(float borderAlpha) {
        this.mBorderAlpha = borderAlpha;
        this.mViewFinderView.setBorderAlpha(borderAlpha);
        this.mViewFinderView.setupViewFinder();
    }

    public void startCamera(int cameraId) {
        if (this.mCameraHandlerThread == null) {
            this.mCameraHandlerThread = new CameraHandlerThread(this);
        }
        this.mCameraHandlerThread.startCamera(cameraId);
    }

    public void setupCameraPreview(CameraWrapper cameraWrapper) {
        this.mCameraWrapper = cameraWrapper;
        if (cameraWrapper != null) {
            setupLayout(cameraWrapper);
            this.mViewFinderView.setupViewFinder();
            Boolean bool = this.mFlashState;
            if (bool != null) {
                setFlash(bool.booleanValue());
            }
            setAutoFocus(this.mAutofocusState);
        }
    }

    public void startCamera() {
        startCamera(CameraUtils.getDefaultCameraId());
    }

    public void stopCamera() {
        if (this.mCameraWrapper != null) {
            this.mPreview.stopCameraPreview();
            this.mPreview.setCamera((CameraWrapper) null, (Camera.PreviewCallback) null);
            this.mCameraWrapper.mCamera.release();
            this.mCameraWrapper = null;
        }
        CameraHandlerThread cameraHandlerThread = this.mCameraHandlerThread;
        if (cameraHandlerThread != null) {
            cameraHandlerThread.quit();
            this.mCameraHandlerThread = null;
        }
    }

    public void stopCameraPreview() {
        CameraPreview cameraPreview = this.mPreview;
        if (cameraPreview != null) {
            cameraPreview.stopCameraPreview();
        }
    }

    /* access modifiers changed from: protected */
    public void resumeCameraPreview() {
        CameraPreview cameraPreview = this.mPreview;
        if (cameraPreview != null) {
            cameraPreview.showCameraPreview();
        }
    }

    public synchronized Rect getFramingRectInPreview(int previewWidth, int previewHeight) {
        if (this.mFramingRectInPreview == null) {
            Rect framingRect = this.mViewFinderView.getFramingRect();
            int viewFinderViewWidth = this.mViewFinderView.getWidth();
            int viewFinderViewHeight = this.mViewFinderView.getHeight();
            if (!(framingRect == null || viewFinderViewWidth == 0)) {
                if (viewFinderViewHeight != 0) {
                    Rect rect = new Rect(framingRect);
                    if (previewWidth < viewFinderViewWidth) {
                        rect.left = (rect.left * previewWidth) / viewFinderViewWidth;
                        rect.right = (rect.right * previewWidth) / viewFinderViewWidth;
                    }
                    if (previewHeight < viewFinderViewHeight) {
                        rect.top = (rect.top * previewHeight) / viewFinderViewHeight;
                        rect.bottom = (rect.bottom * previewHeight) / viewFinderViewHeight;
                    }
                    this.mFramingRectInPreview = rect;
                }
            }
            return null;
        }
        return this.mFramingRectInPreview;
    }

    public void setFlash(boolean flag) {
        this.mFlashState = Boolean.valueOf(flag);
        CameraWrapper cameraWrapper = this.mCameraWrapper;
        if (cameraWrapper != null && CameraUtils.isFlashSupported(cameraWrapper.mCamera)) {
            Camera.Parameters parameters = this.mCameraWrapper.mCamera.getParameters();
            if (flag) {
                if (!parameters.getFlashMode().equals("torch")) {
                    parameters.setFlashMode("torch");
                } else {
                    return;
                }
            } else if (!parameters.getFlashMode().equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else {
                return;
            }
            this.mCameraWrapper.mCamera.setParameters(parameters);
        }
    }

    public boolean getFlash() {
        CameraWrapper cameraWrapper = this.mCameraWrapper;
        if (cameraWrapper == null || !CameraUtils.isFlashSupported(cameraWrapper.mCamera) || !this.mCameraWrapper.mCamera.getParameters().getFlashMode().equals("torch")) {
            return false;
        }
        return true;
    }

    public void toggleFlash() {
        CameraWrapper cameraWrapper = this.mCameraWrapper;
        if (cameraWrapper != null && CameraUtils.isFlashSupported(cameraWrapper.mCamera)) {
            Camera.Parameters parameters = this.mCameraWrapper.mCamera.getParameters();
            if (parameters.getFlashMode().equals("torch")) {
                parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else {
                parameters.setFlashMode("torch");
            }
            this.mCameraWrapper.mCamera.setParameters(parameters);
        }
    }

    public void setAutoFocus(boolean state) {
        this.mAutofocusState = state;
        CameraPreview cameraPreview = this.mPreview;
        if (cameraPreview != null) {
            cameraPreview.setAutoFocus(state);
        }
    }

    public void setShouldScaleToFill(boolean shouldScaleToFill) {
        this.mShouldScaleToFill = shouldScaleToFill;
    }

    public void setAspectTolerance(float aspectTolerance) {
        this.mAspectTolerance = aspectTolerance;
    }

    public byte[] getRotatedData(byte[] data, Camera camera) {
        Camera.Size size = camera.getParameters().getPreviewSize();
        int width = size.width;
        int height = size.height;
        int rotationCount = getRotationCount();
        if (rotationCount == 1 || rotationCount == 3) {
            for (int i = 0; i < rotationCount; i++) {
                byte[] rotatedData = new byte[data.length];
                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        rotatedData[(((x * height) + height) - y) - 1] = data[(y * width) + x];
                    }
                }
                data = rotatedData;
                int tmp = width;
                width = height;
                height = tmp;
            }
        }
        return data;
    }

    public int getRotationCount() {
        return this.mPreview.getDisplayOrientation() / 90;
    }
}
