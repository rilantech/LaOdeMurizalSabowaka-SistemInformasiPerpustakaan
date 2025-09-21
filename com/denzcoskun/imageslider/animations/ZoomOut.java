package com.denzcoskun.imageslider.animations;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/denzcoskun/imageslider/animations/ZoomOut;", "Landroidx/viewpager/widget/ViewPager$PageTransformer;", "()V", "MIN_ALPHA", "", "MIN_SCALE", "transformPage", "", "view", "Landroid/view/View;", "position", "imageslider_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ZoomOut.kt */
public final class ZoomOut implements ViewPager.PageTransformer {
    private final float MIN_ALPHA = 0.5f;
    private final float MIN_SCALE = 0.85f;

    public void transformPage(View view, float position) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();
        if (position < ((float) -1)) {
            view.setAlpha(0.0f);
            return;
        }
        float f = (float) 1;
        if (position <= f) {
            float scaleFactor = Math.max(this.MIN_SCALE, f - Math.abs(position));
            float f2 = (float) 2;
            float vertMargin = (((float) pageHeight) * (f - scaleFactor)) / f2;
            float horzMargin = (((float) pageWidth) * (f - scaleFactor)) / f2;
            if (position < ((float) 0)) {
                view.setTranslationX(horzMargin - (vertMargin / f2));
            } else {
                view.setTranslationX((-horzMargin) + (vertMargin / f2));
            }
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            float f3 = this.MIN_ALPHA;
            float f4 = this.MIN_SCALE;
            view.setAlpha(f3 + (((scaleFactor - f4) / (f - f4)) * (f - f3)));
            return;
        }
        view.setAlpha(0.0f);
    }
}
