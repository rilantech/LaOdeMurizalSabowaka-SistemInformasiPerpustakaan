package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private final int itemHeight;
    private boolean itemHorizontalTranslationEnabled;
    private int[] tempChildWidths = new int[5];

    public BottomNavigationMenuView(Context context) {
        super(context);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
        params.gravity = 17;
        setLayoutParams(params);
        Resources res = getResources();
        this.inactiveItemMaxWidth = res.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = res.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = res.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = res.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
        this.itemHeight = res.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r22, int r23) {
        /*
            r21 = this;
            r0 = r21
            androidx.appcompat.view.menu.MenuBuilder r1 = r21.getMenu()
            int r2 = android.view.View.MeasureSpec.getSize(r22)
            java.util.ArrayList r3 = r1.getVisibleItems()
            int r3 = r3.size()
            int r4 = r21.getChildCount()
            int r5 = r0.itemHeight
            r6 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r6)
            int r7 = r21.getLabelVisibilityMode()
            boolean r7 = r0.isShifting(r7, r3)
            r9 = 8
            if (r7 == 0) goto L_0x00c3
            boolean r7 = r21.isItemHorizontalTranslationEnabled()
            if (r7 == 0) goto L_0x00c0
            int r7 = r21.getSelectedItemPosition()
            android.view.View r7 = r0.getChildAt(r7)
            int r11 = r0.activeItemMinWidth
            int r12 = r7.getVisibility()
            if (r12 == r9) goto L_0x0053
            int r12 = r0.activeItemMaxWidth
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
            int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r13)
            r7.measure(r12, r5)
            int r12 = r7.getMeasuredWidth()
            int r11 = java.lang.Math.max(r11, r12)
        L_0x0053:
            int r12 = r7.getVisibility()
            if (r12 == r9) goto L_0x005b
            r12 = 1
            goto L_0x005c
        L_0x005b:
            r12 = 0
        L_0x005c:
            int r12 = r3 - r12
            int r13 = r0.inactiveItemMinWidth
            int r13 = r13 * r12
            int r13 = r2 - r13
            int r14 = r0.activeItemMaxWidth
            int r14 = java.lang.Math.min(r11, r14)
            int r14 = java.lang.Math.min(r13, r14)
            int r15 = r2 - r14
            if (r12 != 0) goto L_0x0074
            r16 = 1
            goto L_0x0076
        L_0x0074:
            r16 = r12
        L_0x0076:
            int r15 = r15 / r16
            int r6 = r0.inactiveItemMaxWidth
            int r6 = java.lang.Math.min(r15, r6)
            int r17 = r2 - r14
            int r18 = r6 * r12
            int r17 = r17 - r18
            r18 = 0
            r8 = r18
        L_0x0088:
            if (r8 >= r4) goto L_0x00bf
            android.view.View r19 = r0.getChildAt(r8)
            int r10 = r19.getVisibility()
            if (r10 == r9) goto L_0x00b3
            int[] r10 = r0.tempChildWidths
            int r9 = r21.getSelectedItemPosition()
            if (r8 != r9) goto L_0x009e
            r9 = r14
            goto L_0x009f
        L_0x009e:
            r9 = r6
        L_0x009f:
            r10[r8] = r9
            if (r17 <= 0) goto L_0x00b0
            int[] r9 = r0.tempChildWidths
            r10 = r9[r8]
            r20 = 1
            int r10 = r10 + 1
            r9[r8] = r10
            int r17 = r17 + -1
            goto L_0x00ba
        L_0x00b0:
            r20 = 1
            goto L_0x00ba
        L_0x00b3:
            r20 = 1
            int[] r9 = r0.tempChildWidths
            r10 = 0
            r9[r8] = r10
        L_0x00ba:
            int r8 = r8 + 1
            r9 = 8
            goto L_0x0088
        L_0x00bf:
            goto L_0x00fb
        L_0x00c0:
            r20 = 1
            goto L_0x00c5
        L_0x00c3:
            r20 = 1
        L_0x00c5:
            if (r3 != 0) goto L_0x00ca
            r10 = r20
            goto L_0x00cb
        L_0x00ca:
            r10 = r3
        L_0x00cb:
            int r6 = r2 / r10
            int r7 = r0.activeItemMaxWidth
            int r7 = java.lang.Math.min(r6, r7)
            int r8 = r7 * r3
            int r8 = r2 - r8
            r9 = 0
        L_0x00d8:
            if (r9 >= r4) goto L_0x00fb
            android.view.View r10 = r0.getChildAt(r9)
            int r10 = r10.getVisibility()
            r11 = 8
            if (r10 == r11) goto L_0x00f3
            int[] r10 = r0.tempChildWidths
            r10[r9] = r7
            if (r8 <= 0) goto L_0x00f8
            int r11 = r7 + 1
            r10[r9] = r11
            int r8 = r8 + -1
            goto L_0x00f8
        L_0x00f3:
            int[] r10 = r0.tempChildWidths
            r11 = 0
            r10[r9] = r11
        L_0x00f8:
            int r9 = r9 + 1
            goto L_0x00d8
        L_0x00fb:
            r6 = 0
            r7 = 0
        L_0x00fd:
            if (r7 >= r4) goto L_0x012b
            android.view.View r8 = r0.getChildAt(r7)
            int r9 = r8.getVisibility()
            r10 = 8
            if (r9 != r10) goto L_0x010c
            goto L_0x0128
        L_0x010c:
            int[] r9 = r0.tempChildWidths
            r9 = r9[r7]
            r11 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r11)
            r8.measure(r9, r5)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            int r11 = r8.getMeasuredWidth()
            r9.width = r11
            int r11 = r8.getMeasuredWidth()
            int r6 = r6 + r11
        L_0x0128:
            int r7 = r7 + 1
            goto L_0x00fd
        L_0x012b:
            r7 = 1073741824(0x40000000, float:2.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r8 = 0
            int r7 = android.view.View.resolveSizeAndState(r6, r7, r8)
            int r9 = r0.itemHeight
            int r8 = android.view.View.resolveSizeAndState(r9, r5, r8)
            r0.setMeasuredDimension(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomnavigation.BottomNavigationMenuView.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int count = getChildCount();
        int width = right - left;
        int height = bottom - top;
        int used = 0;
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    child.layout((width - used) - child.getMeasuredWidth(), 0, width - used, height);
                } else {
                    child.layout(used, 0, child.getMeasuredWidth() + used, height);
                }
                used += child.getMeasuredWidth();
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean itemHorizontalTranslationEnabled2) {
        this.itemHorizontalTranslationEnabled = itemHorizontalTranslationEnabled2;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    /* access modifiers changed from: protected */
    public NavigationBarItemView createNavigationBarItemView(Context context) {
        return new BottomNavigationItemView(context);
    }
}
