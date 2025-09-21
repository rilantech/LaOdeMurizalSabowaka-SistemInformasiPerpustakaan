package com.denzcoskun.imageslider.constants;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/denzcoskun/imageslider/constants/AnimationTypes;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "ZOOM_IN", "ZOOM_OUT", "DEPTH_SLIDE", "CUBE_IN", "CUBE_OUT", "FLIP_HORIZONTAL", "FLIP_VERTICAL", "FOREGROUND_TO_BACKGROUND", "BACKGROUND_TO_FOREGROUND", "ROTATE_UP", "ROTATE_DOWN", "GATE", "TOSS", "FIDGET_SPINNER", "imageslider_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: AnimationTypes.kt */
public enum AnimationTypes {
    ZOOM_IN("ZoomIn"),
    ZOOM_OUT("ZoomOut"),
    DEPTH_SLIDE("DepthSlide"),
    CUBE_IN("CubeIn"),
    CUBE_OUT("CubeOut"),
    FLIP_HORIZONTAL("FlipHorizontal"),
    FLIP_VERTICAL("FlipVertical"),
    FOREGROUND_TO_BACKGROUND("ForegroundToBackground"),
    BACKGROUND_TO_FOREGROUND("BackgroundToForeground"),
    ROTATE_UP("RotateUp"),
    ROTATE_DOWN("Rotate_Down"),
    GATE("Gate"),
    TOSS("Toss"),
    FIDGET_SPINNER("FidgetSpinner");

    private AnimationTypes(String value) {
    }
}
