package cn.pedant.SweetAlert;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

public class Constants {
    public static final View.OnTouchListener FOCUS_TOUCH_LISTENER = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            Drawable drawable = v.getBackground();
            switch (event.getAction()) {
                case 0:
                case 11:
                    drawable.setColorFilter(536870912, PorterDuff.Mode.SRC_ATOP);
                    v.invalidate();
                    return false;
                case 1:
                case 3:
                    drawable.clearColorFilter();
                    v.invalidate();
                    return false;
                default:
                    return false;
            }
        }
    };
}
