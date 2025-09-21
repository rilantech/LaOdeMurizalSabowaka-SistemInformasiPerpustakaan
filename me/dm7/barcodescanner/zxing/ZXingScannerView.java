package me.dm7.barcodescanner.zxing;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import me.dm7.barcodescanner.core.BarcodeScannerView;
import me.dm7.barcodescanner.core.DisplayUtils;

public class ZXingScannerView extends BarcodeScannerView {
    public static final List<BarcodeFormat> ALL_FORMATS;
    private static final String TAG = "ZXingScannerView";
    private List<BarcodeFormat> mFormats;
    private MultiFormatReader mMultiFormatReader;
    /* access modifiers changed from: private */
    public ResultHandler mResultHandler;

    public interface ResultHandler {
        void handleResult(Result result);
    }

    static {
        ArrayList arrayList = new ArrayList();
        ALL_FORMATS = arrayList;
        arrayList.add(BarcodeFormat.AZTEC);
        arrayList.add(BarcodeFormat.CODABAR);
        arrayList.add(BarcodeFormat.CODE_39);
        arrayList.add(BarcodeFormat.CODE_93);
        arrayList.add(BarcodeFormat.CODE_128);
        arrayList.add(BarcodeFormat.DATA_MATRIX);
        arrayList.add(BarcodeFormat.EAN_8);
        arrayList.add(BarcodeFormat.EAN_13);
        arrayList.add(BarcodeFormat.ITF);
        arrayList.add(BarcodeFormat.MAXICODE);
        arrayList.add(BarcodeFormat.PDF_417);
        arrayList.add(BarcodeFormat.QR_CODE);
        arrayList.add(BarcodeFormat.RSS_14);
        arrayList.add(BarcodeFormat.RSS_EXPANDED);
        arrayList.add(BarcodeFormat.UPC_A);
        arrayList.add(BarcodeFormat.UPC_E);
        arrayList.add(BarcodeFormat.UPC_EAN_EXTENSION);
    }

    public ZXingScannerView(Context context) {
        super(context);
        initMultiFormatReader();
    }

    public ZXingScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initMultiFormatReader();
    }

    public void setFormats(List<BarcodeFormat> formats) {
        this.mFormats = formats;
        initMultiFormatReader();
    }

    public void setResultHandler(ResultHandler resultHandler) {
        this.mResultHandler = resultHandler;
    }

    public Collection<BarcodeFormat> getFormats() {
        List<BarcodeFormat> list = this.mFormats;
        if (list == null) {
            return ALL_FORMATS;
        }
        return list;
    }

    private void initMultiFormatReader() {
        Map<DecodeHintType, Object> hints = new EnumMap<>(DecodeHintType.class);
        hints.put(DecodeHintType.POSSIBLE_FORMATS, getFormats());
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.mMultiFormatReader = multiFormatReader;
        multiFormatReader.setHints(hints);
    }

    public void onPreviewFrame(byte[] data, Camera camera) {
        Result rawResult;
        MultiFormatReader multiFormatReader;
        MultiFormatReader multiFormatReader2;
        if (this.mResultHandler != null) {
            try {
                Camera.Size size = camera.getParameters().getPreviewSize();
                int width = size.width;
                int height = size.height;
                if (DisplayUtils.getScreenOrientation(getContext()) == 1) {
                    int rotationCount = getRotationCount();
                    if (rotationCount == 1 || rotationCount == 3) {
                        int tmp = width;
                        width = height;
                        height = tmp;
                    }
                    data = getRotatedData(data, camera);
                }
                rawResult = null;
                PlanarYUVLuminanceSource source = buildLuminanceSource(data, width, height);
                if (source != null) {
                    rawResult = this.mMultiFormatReader.decodeWithState(new BinaryBitmap(new HybridBinarizer(source)));
                    multiFormatReader = this.mMultiFormatReader;
                    multiFormatReader.reset();
                    if (rawResult == null) {
                        rawResult = this.mMultiFormatReader.decodeWithState(new BinaryBitmap(new HybridBinarizer(source.invert())));
                        multiFormatReader2 = this.mMultiFormatReader;
                        multiFormatReader2.reset();
                    }
                }
            } catch (NotFoundException e) {
                multiFormatReader2 = this.mMultiFormatReader;
            } catch (ReaderException e2) {
                multiFormatReader = this.mMultiFormatReader;
            } catch (NullPointerException e3) {
                multiFormatReader = this.mMultiFormatReader;
            } catch (ArrayIndexOutOfBoundsException e4) {
                multiFormatReader = this.mMultiFormatReader;
            } catch (RuntimeException e5) {
                Log.e(TAG, e5.toString(), e5);
                return;
            } catch (Throwable th) {
                this.mMultiFormatReader.reset();
                throw th;
            }
            final Result finalRawResult = rawResult;
            if (finalRawResult != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        ResultHandler tmpResultHandler = ZXingScannerView.this.mResultHandler;
                        ResultHandler unused = ZXingScannerView.this.mResultHandler = null;
                        ZXingScannerView.this.stopCameraPreview();
                        if (tmpResultHandler != null) {
                            tmpResultHandler.handleResult(finalRawResult);
                        }
                    }
                });
            } else {
                camera.setOneShotPreviewCallback(this);
            }
        }
    }

    public void resumeCameraPreview(ResultHandler resultHandler) {
        this.mResultHandler = resultHandler;
        super.resumeCameraPreview();
    }

    public PlanarYUVLuminanceSource buildLuminanceSource(byte[] data, int width, int height) {
        Rect rect = getFramingRectInPreview(width, height);
        if (rect == null) {
            return null;
        }
        try {
            return new PlanarYUVLuminanceSource(data, width, height, rect.left, rect.top, rect.width(), rect.height(), false);
        } catch (Exception e) {
            return null;
        }
    }
}
