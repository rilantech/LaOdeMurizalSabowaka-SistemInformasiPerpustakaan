package com.denzcoskun.imageslider.animations;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/denzcoskun/imageslider/animations/FidgetSpinner;", "Landroidx/viewpager/widget/ViewPager$PageTransformer;", "()V", "transformPage", "", "view", "Landroid/view/View;", "position", "", "imageslider_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FidgetSpinner.kt */
public final class FidgetSpinner implements ViewPager.PageTransformer {
    public void transformPage(View view, float position) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        view.setTranslationX((-position) * ((float) view.getWidth()));
        if (((double) Math.abs(position)) < 0.5d) {
            view.setVisibility(0);
            float f = (float) 1;
            view.setScaleX(f - Math.abs(position));
            view.setScaleY(f - Math.abs(position));
        } else if (((double) Math.abs(position)) > 0.5d) {
            view.setVisibility(8);
        }
        if (position < ((float) -1)) {
            view.setAlpha(0.0f);
        } else if (position <= ((float) 0)) {
            view.setAlpha(1.0f);
            view.setRotation(((float) 36000) * Math.abs(position) * Math.abs(position) * Math.abs(position) * Math.abs(position) * Math.abs(position) * Math.abs(position) * Math.abs(position));
        } else if (position <= ((float) 1)) {
            view.setAlpha(1.0f);
            view.setRotation(((float) -36000) * Math.abs(position) * Math.abs(position) * Math.abs(position) * Math.abs(position) * Math.abs(position) * Math.abs(position) * Math.abs(position));
        } else {
            view.setAlpha(0.0f);
        }
    }
}
