package com.denzcoskun.imageslider.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.interfaces.TouchListener;
import com.denzcoskun.imageslider.models.SlideModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001BM\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fBW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u0012J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\bH\u0016J\u000e\u0010$\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010%\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0016J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\"H\u0016J\u000e\u0010+\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/denzcoskun/imageslider/adapters/ViewPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "context", "Landroid/content/Context;", "imageList", "", "Lcom/denzcoskun/imageslider/models/SlideModel;", "radius", "", "errorImage", "placeholder", "titleBackground", "textAlign", "", "textColor", "(Landroid/content/Context;Ljava/util/List;IIIILjava/lang/String;Ljava/lang/String;)V", "scaleType", "Lcom/denzcoskun/imageslider/constants/ScaleTypes;", "(Landroid/content/Context;Ljava/util/List;IIIILcom/denzcoskun/imageslider/constants/ScaleTypes;Ljava/lang/String;Ljava/lang/String;)V", "currentTouchTime", "", "itemClickListener", "Lcom/denzcoskun/imageslider/interfaces/ItemClickListener;", "lastTouchTime", "layoutInflater", "Landroid/view/LayoutInflater;", "touchListener", "Lcom/denzcoskun/imageslider/interfaces/TouchListener;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "object", "", "getCount", "getGravityFromAlign", "instantiateItem", "Landroid/view/View;", "isViewFromObject", "", "view", "obj", "setItemClickListener", "setTouchListener", "imageslider_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ViewPagerAdapter.kt */
public final class ViewPagerAdapter extends PagerAdapter {
    /* access modifiers changed from: private */
    public long currentTouchTime;
    private int errorImage;
    private List<SlideModel> imageList;
    /* access modifiers changed from: private */
    public ItemClickListener itemClickListener;
    /* access modifiers changed from: private */
    public long lastTouchTime;
    private LayoutInflater layoutInflater;
    private int placeholder;
    private int radius;
    private ScaleTypes scaleType;
    private String textAlign;
    private String textColor;
    private int titleBackground;
    /* access modifiers changed from: private */
    public TouchListener touchListener;

    public ViewPagerAdapter(Context context, List<SlideModel> imageList2, int radius2, int errorImage2, int placeholder2, int titleBackground2, ScaleTypes scaleType2, String textAlign2, String textColor2) {
        Intrinsics.checkParameterIsNotNull(imageList2, "imageList");
        Intrinsics.checkParameterIsNotNull(textAlign2, "textAlign");
        Intrinsics.checkParameterIsNotNull(textColor2, "textColor");
        this.radius = radius2;
        this.errorImage = errorImage2;
        this.placeholder = placeholder2;
        this.titleBackground = titleBackground2;
        this.scaleType = scaleType2;
        this.textAlign = textAlign2;
        this.textColor = textColor2;
        this.imageList = imageList2;
        if (context == null) {
            Intrinsics.throwNpe();
        }
        this.layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewPagerAdapter(Context context, List<SlideModel> imageList2, int radius2, int errorImage2, int placeholder2, int titleBackground2, String textAlign2, String textColor2) {
        this(context, imageList2, radius2, errorImage2, placeholder2, titleBackground2, (ScaleTypes) null, textAlign2, textColor2);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(imageList2, "imageList");
        Intrinsics.checkParameterIsNotNull(textAlign2, "textAlign");
        Intrinsics.checkParameterIsNotNull(textColor2, "textColor");
    }

    public boolean isViewFromObject(View view, Object obj) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(obj, "obj");
        return Intrinsics.areEqual((Object) view, obj);
    }

    public int getCount() {
        List<SlideModel> list = this.imageList;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return list.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0142, code lost:
        if (r5.get(r15).getScaleType() == com.denzcoskun.imageslider.constants.ScaleTypes.FIT) goto L_0x0144;
     */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0180  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View instantiateItem(android.view.ViewGroup r14, int r15) {
        /*
            r13 = this;
            java.lang.String r0 = "container"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r0)
            android.view.LayoutInflater r0 = r13.layoutInflater
            if (r0 != 0) goto L_0x000c
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x000c:
            int r1 = com.denzcoskun.imageslider.R.layout.pager_row
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r14, r2)
            int r1 = com.denzcoskun.imageslider.R.id.image_view
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            int r2 = com.denzcoskun.imageslider.R.id.linear_layout
            android.view.View r2 = r0.findViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            int r3 = com.denzcoskun.imageslider.R.id.text_view
            android.view.View r3 = r0.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r4 = r13.textColor
            int r4 = android.graphics.Color.parseColor(r4)
            r3.setTextColor(r4)
            java.util.List<com.denzcoskun.imageslider.models.SlideModel> r4 = r13.imageList
            if (r4 != 0) goto L_0x003b
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x003b:
            java.lang.Object r4 = r4.get(r15)
            com.denzcoskun.imageslider.models.SlideModel r4 = (com.denzcoskun.imageslider.models.SlideModel) r4
            java.lang.String r4 = r4.getTitle()
            java.lang.String r5 = "linearLayout"
            if (r4 == 0) goto L_0x0080
            java.lang.String r4 = "textView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            java.util.List<com.denzcoskun.imageslider.models.SlideModel> r4 = r13.imageList
            if (r4 != 0) goto L_0x0056
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0056:
            java.lang.Object r4 = r4.get(r15)
            com.denzcoskun.imageslider.models.SlideModel r4 = (com.denzcoskun.imageslider.models.SlideModel) r4
            java.lang.String r4 = r4.getTitle()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            int r4 = r13.titleBackground
            r2.setBackgroundResource(r4)
            java.lang.String r4 = r13.textAlign
            int r4 = r13.getGravityFromAlign(r4)
            r3.setGravity(r4)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            java.lang.String r4 = r13.textAlign
            int r4 = r13.getGravityFromAlign(r4)
            r2.setGravity(r4)
            goto L_0x0087
        L_0x0080:
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            r4 = 4
            r2.setVisibility(r4)
        L_0x0087:
            java.util.List<com.denzcoskun.imageslider.models.SlideModel> r4 = r13.imageList
            if (r4 != 0) goto L_0x008f
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x008f:
            java.lang.Object r4 = r4.get(r15)
            com.denzcoskun.imageslider.models.SlideModel r4 = (com.denzcoskun.imageslider.models.SlideModel) r4
            java.lang.String r4 = r4.getImageUrl()
            if (r4 != 0) goto L_0x00be
            com.squareup.picasso.Picasso r4 = com.squareup.picasso.Picasso.get()
            java.util.List<com.denzcoskun.imageslider.models.SlideModel> r5 = r13.imageList
            if (r5 != 0) goto L_0x00a6
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00a6:
            java.lang.Object r5 = r5.get(r15)
            com.denzcoskun.imageslider.models.SlideModel r5 = (com.denzcoskun.imageslider.models.SlideModel) r5
            java.lang.Integer r5 = r5.getImagePath()
            if (r5 != 0) goto L_0x00b5
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00b5:
            int r5 = r5.intValue()
            com.squareup.picasso.RequestCreator r4 = r4.load((int) r5)
            goto L_0x00dc
        L_0x00be:
            com.squareup.picasso.Picasso r4 = com.squareup.picasso.Picasso.get()
            java.util.List<com.denzcoskun.imageslider.models.SlideModel> r5 = r13.imageList
            if (r5 != 0) goto L_0x00c9
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00c9:
            java.lang.Object r5 = r5.get(r15)
            com.denzcoskun.imageslider.models.SlideModel r5 = (com.denzcoskun.imageslider.models.SlideModel) r5
            java.lang.String r5 = r5.getImageUrl()
            if (r5 != 0) goto L_0x00d8
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00d8:
            com.squareup.picasso.RequestCreator r4 = r4.load((java.lang.String) r5)
        L_0x00dc:
            com.denzcoskun.imageslider.constants.ScaleTypes r5 = r13.scaleType
            if (r5 == 0) goto L_0x00e5
            com.denzcoskun.imageslider.constants.ScaleTypes r6 = com.denzcoskun.imageslider.constants.ScaleTypes.CENTER_CROP
            if (r5 == r6) goto L_0x00fa
        L_0x00e5:
            java.util.List<com.denzcoskun.imageslider.models.SlideModel> r5 = r13.imageList
            if (r5 != 0) goto L_0x00ec
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00ec:
            java.lang.Object r5 = r5.get(r15)
            com.denzcoskun.imageslider.models.SlideModel r5 = (com.denzcoskun.imageslider.models.SlideModel) r5
            com.denzcoskun.imageslider.constants.ScaleTypes r5 = r5.getScaleType()
            com.denzcoskun.imageslider.constants.ScaleTypes r6 = com.denzcoskun.imageslider.constants.ScaleTypes.CENTER_CROP
            if (r5 != r6) goto L_0x0102
        L_0x00fa:
            com.squareup.picasso.RequestCreator r5 = r4.fit()
            r5.centerCrop()
            goto L_0x0147
        L_0x0102:
            com.denzcoskun.imageslider.constants.ScaleTypes r5 = r13.scaleType
            if (r5 == 0) goto L_0x010a
            com.denzcoskun.imageslider.constants.ScaleTypes r6 = com.denzcoskun.imageslider.constants.ScaleTypes.CENTER_INSIDE
            if (r5 == r6) goto L_0x011f
        L_0x010a:
            java.util.List<com.denzcoskun.imageslider.models.SlideModel> r5 = r13.imageList
            if (r5 != 0) goto L_0x0111
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0111:
            java.lang.Object r5 = r5.get(r15)
            com.denzcoskun.imageslider.models.SlideModel r5 = (com.denzcoskun.imageslider.models.SlideModel) r5
            com.denzcoskun.imageslider.constants.ScaleTypes r5 = r5.getScaleType()
            com.denzcoskun.imageslider.constants.ScaleTypes r6 = com.denzcoskun.imageslider.constants.ScaleTypes.CENTER_INSIDE
            if (r5 != r6) goto L_0x0127
        L_0x011f:
            com.squareup.picasso.RequestCreator r5 = r4.fit()
            r5.centerInside()
            goto L_0x0147
        L_0x0127:
            com.denzcoskun.imageslider.constants.ScaleTypes r5 = r13.scaleType
            if (r5 == 0) goto L_0x012f
            com.denzcoskun.imageslider.constants.ScaleTypes r6 = com.denzcoskun.imageslider.constants.ScaleTypes.FIT
            if (r5 == r6) goto L_0x0144
        L_0x012f:
            java.util.List<com.denzcoskun.imageslider.models.SlideModel> r5 = r13.imageList
            if (r5 != 0) goto L_0x0136
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0136:
            java.lang.Object r5 = r5.get(r15)
            com.denzcoskun.imageslider.models.SlideModel r5 = (com.denzcoskun.imageslider.models.SlideModel) r5
            com.denzcoskun.imageslider.constants.ScaleTypes r5 = r5.getScaleType()
            com.denzcoskun.imageslider.constants.ScaleTypes r6 = com.denzcoskun.imageslider.constants.ScaleTypes.FIT
            if (r5 != r6) goto L_0x0147
        L_0x0144:
            r4.fit()
        L_0x0147:
            com.denzcoskun.imageslider.transformation.RoundedTransformation r5 = new com.denzcoskun.imageslider.transformation.RoundedTransformation
            int r8 = r13.radius
            r9 = 0
            r10 = 0
            r11 = 4
            r12 = 0
            r7 = r5
            r7.<init>(r8, r9, r10, r11, r12)
            com.squareup.picasso.Transformation r5 = (com.squareup.picasso.Transformation) r5
            com.squareup.picasso.RequestCreator r5 = r4.transform((com.squareup.picasso.Transformation) r5)
            int r6 = r13.placeholder
            com.squareup.picasso.RequestCreator r5 = r5.placeholder((int) r6)
            int r6 = r13.errorImage
            com.squareup.picasso.RequestCreator r5 = r5.error((int) r6)
            r5.into((android.widget.ImageView) r1)
            r14.addView(r0)
            com.denzcoskun.imageslider.adapters.ViewPagerAdapter$instantiateItem$1 r5 = new com.denzcoskun.imageslider.adapters.ViewPagerAdapter$instantiateItem$1
            r5.<init>(r13, r15)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r1.setOnClickListener(r5)
            com.denzcoskun.imageslider.interfaces.TouchListener r5 = r13.touchListener
            if (r5 == 0) goto L_0x018f
            if (r1 != 0) goto L_0x0185
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0185:
            com.denzcoskun.imageslider.adapters.ViewPagerAdapter$instantiateItem$2 r5 = new com.denzcoskun.imageslider.adapters.ViewPagerAdapter$instantiateItem$2
            r5.<init>(r13, r15)
            android.view.View$OnTouchListener r5 = (android.view.View.OnTouchListener) r5
            r1.setOnTouchListener(r5)
        L_0x018f:
            java.lang.String r5 = "itemView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.denzcoskun.imageslider.adapters.ViewPagerAdapter.instantiateItem(android.view.ViewGroup, int):android.view.View");
    }

    public final int getGravityFromAlign(String textAlign2) {
        Intrinsics.checkParameterIsNotNull(textAlign2, "textAlign");
        switch (textAlign2.hashCode()) {
            case 77974012:
                if (textAlign2.equals("RIGHT")) {
                    return 5;
                }
                break;
            case 1984282709:
                if (textAlign2.equals("CENTER")) {
                    return 17;
                }
                break;
        }
        return 3;
    }

    public final void setItemClickListener(ItemClickListener itemClickListener2) {
        Intrinsics.checkParameterIsNotNull(itemClickListener2, "itemClickListener");
        this.itemClickListener = itemClickListener2;
    }

    public final void setTouchListener(TouchListener touchListener2) {
        Intrinsics.checkParameterIsNotNull(touchListener2, "touchListener");
        this.touchListener = touchListener2;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(object, "object");
        container.removeView((RelativeLayout) object);
    }
}
