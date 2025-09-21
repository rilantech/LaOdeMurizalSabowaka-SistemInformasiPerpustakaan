package me.dm7.barcodescanner.core;

import android.hardware.Camera;
import java.util.List;
import kotlinx.coroutines.DebugKt;

public class CameraUtils {
    public static Camera getCameraInstance() {
        return getCameraInstance(getDefaultCameraId());
    }

    public static int getDefaultCameraId() {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int defaultCameraId = -1;
        for (int i = 0; i < numberOfCameras; i++) {
            defaultCameraId = i;
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                return i;
            }
        }
        return defaultCameraId;
    }

    public static Camera getCameraInstance(int cameraId) {
        if (cameraId != -1) {
            return Camera.open(cameraId);
        }
        try {
            return Camera.open();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isFlashSupported(Camera camera) {
        List<String> supportedFlashModes;
        if (camera == null) {
            return false;
        }
        Camera.Parameters parameters = camera.getParameters();
        if (parameters.getFlashMode() != null && (supportedFlashModes = parameters.getSupportedFlashModes()) != null && !supportedFlashModes.isEmpty() && (supportedFlashModes.size() != 1 || !supportedFlashModes.get(0).equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF))) {
            return true;
        }
        return false;
    }
}
