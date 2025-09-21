package cn.pedant.SweetAlert;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pnikosis.materialishprogress.ProgressWheel;
import java.util.List;

public class SweetAlertDialog extends Dialog implements View.OnClickListener {
    public static final int BUTTON_CANCEL = -2;
    public static final int BUTTON_CONFIRM = -1;
    public static final int CUSTOM_IMAGE_TYPE = 4;
    public static boolean DARK_STYLE = false;
    public static final int ERROR_TYPE = 1;
    public static final int NORMAL_TYPE = 0;
    public static final int PROGRESS_TYPE = 5;
    public static final int SUCCESS_TYPE = 2;
    public static final int WARNING_TYPE = 3;
    private int contentTextSize;
    private final float defStrokeWidth;
    private int mAlertType;
    private LinearLayout mButtonsContainer;
    private Button mCancelButton;
    private Integer mCancelButtonBackgroundColor;
    private Integer mCancelButtonTextColor;
    private OnSweetClickListener mCancelClickListener;
    private String mCancelText;
    /* access modifiers changed from: private */
    public boolean mCloseFromCancel;
    private Button mConfirmButton;
    private Integer mConfirmButtonBackgroundColor;
    private Integer mConfirmButtonTextColor;
    private OnSweetClickListener mConfirmClickListener;
    private String mConfirmText;
    private String mContentText;
    private TextView mContentTextView;
    private ImageView mCustomImage;
    private Drawable mCustomImgDrawable;
    private View mCustomView;
    private FrameLayout mCustomViewContainer;
    /* access modifiers changed from: private */
    public View mDialogView;
    private FrameLayout mErrorFrame;
    private Animation mErrorInAnim;
    private ImageView mErrorX;
    private AnimationSet mErrorXInAnim;
    private boolean mHideConfirmButton;
    /* access modifiers changed from: private */
    public boolean mHideKeyBoardOnDismiss;
    private AnimationSet mModalInAnim;
    private AnimationSet mModalOutAnim;
    private Button mNeutralButton;
    private Integer mNeutralButtonBackgroundColor;
    private Integer mNeutralButtonTextColor;
    private OnSweetClickListener mNeutralClickListener;
    private String mNeutralText;
    private Animation mOverlayOutAnim;
    private FrameLayout mProgressFrame;
    private ProgressHelper mProgressHelper;
    private boolean mShowCancel;
    private boolean mShowContent;
    private Animation mSuccessBowAnim;
    private FrameLayout mSuccessFrame;
    private AnimationSet mSuccessLayoutAnimSet;
    private View mSuccessLeftMask;
    private View mSuccessRightMask;
    private SuccessTickView mSuccessTick;
    private String mTitleText;
    private TextView mTitleTextView;
    private FrameLayout mWarningFrame;
    private float strokeWidth;

    public interface OnSweetClickListener {
        void onClick(SweetAlertDialog sweetAlertDialog);
    }

    public SweetAlertDialog hideConfirmButton() {
        this.mHideConfirmButton = true;
        return this;
    }

    public SweetAlertDialog(Context context) {
        this(context, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SweetAlertDialog(Context context, int alertType) {
        super(context, DARK_STYLE ? R.style.alert_dialog_dark : R.style.alert_dialog_light);
        this.mHideConfirmButton = false;
        this.mHideKeyBoardOnDismiss = true;
        this.contentTextSize = 0;
        this.strokeWidth = 0.0f;
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        float dimension = getContext().getResources().getDimension(R.dimen.buttons_stroke_width);
        this.defStrokeWidth = dimension;
        this.strokeWidth = dimension;
        this.mProgressHelper = new ProgressHelper(context);
        this.mAlertType = alertType;
        this.mErrorInAnim = OptAnimationLoader.loadAnimation(getContext(), R.anim.error_frame_in);
        this.mErrorXInAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> childAnims = this.mErrorXInAnim.getAnimations();
            int idx = 0;
            while (idx < childAnims.size() && !(childAnims.get(idx) instanceof AlphaAnimation)) {
                idx++;
            }
            if (idx < childAnims.size()) {
                childAnims.remove(idx);
            }
        }
        this.mSuccessBowAnim = OptAnimationLoader.loadAnimation(getContext(), R.anim.success_bow_roate);
        this.mSuccessLayoutAnimSet = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.success_mask_layout);
        this.mModalInAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.modal_in);
        AnimationSet animationSet = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.modal_out);
        this.mModalOutAnim = animationSet;
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                SweetAlertDialog.this.mDialogView.setVisibility(8);
                if (SweetAlertDialog.this.mHideKeyBoardOnDismiss) {
                    SweetAlertDialog.this.hideSoftKeyboard();
                }
                SweetAlertDialog.this.mDialogView.post(new Runnable() {
                    public void run() {
                        if (SweetAlertDialog.this.mCloseFromCancel) {
                            AnonymousClass1.super.cancel();
                        } else {
                            AnonymousClass1.super.dismiss();
                        }
                    }
                });
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        AnonymousClass2 r0 = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float interpolatedTime, Transformation t) {
                WindowManager.LayoutParams wlp = SweetAlertDialog.this.getWindow().getAttributes();
                wlp.alpha = 1.0f - interpolatedTime;
                SweetAlertDialog.this.getWindow().setAttributes(wlp);
            }
        };
        this.mOverlayOutAnim = r0;
        r0.setDuration(120);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog);
        this.mDialogView = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(R.id.title_text);
        this.mContentTextView = (TextView) findViewById(R.id.content_text);
        this.mCustomViewContainer = (FrameLayout) findViewById(R.id.custom_view_container);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.error_frame);
        this.mErrorFrame = frameLayout;
        this.mErrorX = (ImageView) frameLayout.findViewById(R.id.error_x);
        this.mSuccessFrame = (FrameLayout) findViewById(R.id.success_frame);
        this.mProgressFrame = (FrameLayout) findViewById(R.id.progress_dialog);
        this.mSuccessTick = (SuccessTickView) this.mSuccessFrame.findViewById(R.id.success_tick);
        this.mSuccessLeftMask = this.mSuccessFrame.findViewById(R.id.mask_left);
        this.mSuccessRightMask = this.mSuccessFrame.findViewById(R.id.mask_right);
        this.mCustomImage = (ImageView) findViewById(R.id.custom_image);
        this.mWarningFrame = (FrameLayout) findViewById(R.id.warning_frame);
        this.mButtonsContainer = (LinearLayout) findViewById(R.id.buttons_container);
        Button button = (Button) findViewById(R.id.confirm_button);
        this.mConfirmButton = button;
        button.setOnClickListener(this);
        this.mConfirmButton.setOnTouchListener(Constants.FOCUS_TOUCH_LISTENER);
        Button button2 = (Button) findViewById(R.id.cancel_button);
        this.mCancelButton = button2;
        button2.setOnClickListener(this);
        this.mCancelButton.setOnTouchListener(Constants.FOCUS_TOUCH_LISTENER);
        Button button3 = (Button) findViewById(R.id.neutral_button);
        this.mNeutralButton = button3;
        button3.setOnClickListener(this);
        this.mNeutralButton.setOnTouchListener(Constants.FOCUS_TOUCH_LISTENER);
        this.mProgressHelper.setProgressWheel((ProgressWheel) findViewById(R.id.progressWheel));
        setTitleText(this.mTitleText);
        setContentText(this.mContentText);
        setCustomView(this.mCustomView);
        setCancelText(this.mCancelText);
        setConfirmText(this.mConfirmText);
        setNeutralText(this.mNeutralText);
        applyStroke();
        setConfirmButtonBackgroundColor(this.mConfirmButtonBackgroundColor);
        setConfirmButtonTextColor(this.mConfirmButtonTextColor);
        setCancelButtonBackgroundColor(this.mCancelButtonBackgroundColor);
        setCancelButtonTextColor(this.mCancelButtonTextColor);
        setNeutralButtonBackgroundColor(this.mNeutralButtonBackgroundColor);
        setNeutralButtonTextColor(this.mNeutralButtonTextColor);
        changeAlertType(this.mAlertType, true);
    }

    private void restore() {
        int i = 8;
        this.mCustomImage.setVisibility(8);
        this.mErrorFrame.setVisibility(8);
        this.mSuccessFrame.setVisibility(8);
        this.mWarningFrame.setVisibility(8);
        this.mProgressFrame.setVisibility(8);
        Button button = this.mConfirmButton;
        if (!this.mHideConfirmButton) {
            i = 0;
        }
        button.setVisibility(i);
        adjustButtonContainerVisibility();
        this.mConfirmButton.setBackgroundResource(R.drawable.green_button_background);
        this.mErrorFrame.clearAnimation();
        this.mErrorX.clearAnimation();
        this.mSuccessTick.clearAnimation();
        this.mSuccessLeftMask.clearAnimation();
        this.mSuccessRightMask.clearAnimation();
    }

    private void adjustButtonContainerVisibility() {
        boolean showButtonsContainer = false;
        int i = 0;
        while (true) {
            if (i >= this.mButtonsContainer.getChildCount()) {
                break;
            }
            View view = this.mButtonsContainer.getChildAt(i);
            if ((view instanceof Button) && view.getVisibility() == 0) {
                showButtonsContainer = true;
                break;
            }
            i++;
        }
        this.mButtonsContainer.setVisibility(showButtonsContainer ? 0 : 8);
    }

    private void playAnimation() {
        int i = this.mAlertType;
        if (i == 1) {
            this.mErrorFrame.startAnimation(this.mErrorInAnim);
            this.mErrorX.startAnimation(this.mErrorXInAnim);
        } else if (i == 2) {
            this.mSuccessTick.startTickAnim();
            this.mSuccessRightMask.startAnimation(this.mSuccessBowAnim);
        }
    }

    private void changeAlertType(int alertType, boolean fromCreate) {
        this.mAlertType = alertType;
        if (this.mDialogView != null) {
            if (!fromCreate) {
                restore();
            }
            this.mConfirmButton.setVisibility(this.mHideConfirmButton ? 8 : 0);
            switch (this.mAlertType) {
                case 1:
                    this.mErrorFrame.setVisibility(0);
                    break;
                case 2:
                    this.mSuccessFrame.setVisibility(0);
                    this.mSuccessLeftMask.startAnimation(this.mSuccessLayoutAnimSet.getAnimations().get(0));
                    this.mSuccessRightMask.startAnimation(this.mSuccessLayoutAnimSet.getAnimations().get(1));
                    break;
                case 3:
                    this.mWarningFrame.setVisibility(0);
                    break;
                case 4:
                    setCustomImage(this.mCustomImgDrawable);
                    break;
                case 5:
                    this.mProgressFrame.setVisibility(0);
                    this.mConfirmButton.setVisibility(8);
                    break;
            }
            adjustButtonContainerVisibility();
            if (!fromCreate) {
                playAnimation();
            }
        }
    }

    public int getAlertType() {
        return this.mAlertType;
    }

    public void changeAlertType(int alertType) {
        changeAlertType(alertType, false);
    }

    public String getTitleText() {
        return this.mTitleText;
    }

    public SweetAlertDialog setTitleText(String text) {
        this.mTitleText = text;
        if (!(this.mTitleTextView == null || text == null)) {
            if (text.isEmpty()) {
                this.mTitleTextView.setVisibility(8);
            } else {
                this.mTitleTextView.setVisibility(0);
                this.mTitleTextView.setText(Html.fromHtml(this.mTitleText));
            }
        }
        return this;
    }

    public SweetAlertDialog setTitleText(int resId) {
        return setTitleText(getContext().getResources().getString(resId));
    }

    public SweetAlertDialog setCustomImage(Drawable drawable) {
        this.mCustomImgDrawable = drawable;
        ImageView imageView = this.mCustomImage;
        if (!(imageView == null || drawable == null)) {
            imageView.setVisibility(0);
            this.mCustomImage.setImageDrawable(this.mCustomImgDrawable);
        }
        return this;
    }

    public SweetAlertDialog setCustomImage(int resourceId) {
        return setCustomImage(getContext().getResources().getDrawable(resourceId));
    }

    public String getContentText() {
        return this.mContentText;
    }

    public SweetAlertDialog setContentText(String text) {
        this.mContentText = text;
        if (!(this.mContentTextView == null || text == null)) {
            showContentText(true);
            int i = this.contentTextSize;
            if (i != 0) {
                this.mContentTextView.setTextSize(0, (float) spToPx((float) i, getContext()));
            }
            this.mContentTextView.setText(Html.fromHtml(this.mContentText));
            this.mContentTextView.setVisibility(0);
            this.mCustomViewContainer.setVisibility(8);
        }
        return this;
    }

    public static int spToPx(float sp, Context context) {
        return (int) TypedValue.applyDimension(2, sp, context.getResources().getDisplayMetrics());
    }

    public SweetAlertDialog setStrokeWidth(float width) {
        this.strokeWidth = (float) spToPx(width, getContext());
        return this;
    }

    private void applyStroke() {
        if (Float.compare(this.defStrokeWidth, this.strokeWidth) != 0) {
            Resources r = getContext().getResources();
            setButtonBackgroundColor(this.mConfirmButton, Integer.valueOf(r.getColor(R.color.main_green_color)));
            setButtonBackgroundColor(this.mNeutralButton, Integer.valueOf(r.getColor(R.color.main_disabled_color)));
            setButtonBackgroundColor(this.mCancelButton, Integer.valueOf(r.getColor(R.color.red_btn_bg_color)));
        }
    }

    public boolean isShowCancelButton() {
        return this.mShowCancel;
    }

    public SweetAlertDialog showCancelButton(boolean isShow) {
        this.mShowCancel = isShow;
        Button button = this.mCancelButton;
        if (button != null) {
            button.setVisibility(isShow ? 0 : 8);
        }
        return this;
    }

    public boolean isShowContentText() {
        return this.mShowContent;
    }

    public SweetAlertDialog showContentText(boolean isShow) {
        this.mShowContent = isShow;
        TextView textView = this.mContentTextView;
        if (textView != null) {
            textView.setVisibility(isShow ? 0 : 8);
        }
        return this;
    }

    public String getCancelText() {
        return this.mCancelText;
    }

    public SweetAlertDialog setCancelText(String text) {
        this.mCancelText = text;
        if (!(this.mCancelButton == null || text == null)) {
            showCancelButton(true);
            this.mCancelButton.setText(this.mCancelText);
        }
        return this;
    }

    public String getConfirmText() {
        return this.mConfirmText;
    }

    public SweetAlertDialog setConfirmText(String text) {
        this.mConfirmText = text;
        Button button = this.mConfirmButton;
        if (!(button == null || text == null)) {
            button.setText(text);
        }
        return this;
    }

    public SweetAlertDialog setConfirmButtonBackgroundColor(Integer color) {
        this.mConfirmButtonBackgroundColor = color;
        setButtonBackgroundColor(this.mConfirmButton, color);
        return this;
    }

    public Integer getConfirmButtonBackgroundColor() {
        return this.mConfirmButtonBackgroundColor;
    }

    public SweetAlertDialog setNeutralButtonBackgroundColor(Integer color) {
        this.mNeutralButtonBackgroundColor = color;
        setButtonBackgroundColor(this.mNeutralButton, color);
        return this;
    }

    public Integer getNeutralButtonBackgroundColor() {
        return this.mNeutralButtonBackgroundColor;
    }

    public SweetAlertDialog setCancelButtonBackgroundColor(Integer color) {
        this.mCancelButtonBackgroundColor = color;
        setButtonBackgroundColor(this.mCancelButton, color);
        return this;
    }

    public Integer getCancelButtonBackgroundColor() {
        return this.mCancelButtonBackgroundColor;
    }

    private void setButtonBackgroundColor(Button btn, Integer color) {
        Drawable[] drawableItems;
        if (btn != null && color != null && (drawableItems = ViewUtils.getDrawable(btn)) != null) {
            GradientDrawable gradientDrawableUnChecked = (GradientDrawable) drawableItems[1];
            gradientDrawableUnChecked.setColor(color.intValue());
            gradientDrawableUnChecked.setStroke((int) this.strokeWidth, genStrokeColor(color.intValue()));
        }
    }

    private int genStrokeColor(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] = hsv[2] * 0.7f;
        return Color.HSVToColor(hsv);
    }

    public SweetAlertDialog setConfirmButtonTextColor(Integer color) {
        this.mConfirmButtonTextColor = color;
        Button button = this.mConfirmButton;
        if (!(button == null || color == null)) {
            button.setTextColor(color.intValue());
        }
        return this;
    }

    public Integer getConfirmButtonTextColor() {
        return this.mConfirmButtonTextColor;
    }

    public SweetAlertDialog setNeutralButtonTextColor(Integer color) {
        this.mNeutralButtonTextColor = color;
        Button button = this.mNeutralButton;
        if (!(button == null || color == null)) {
            button.setTextColor(color.intValue());
        }
        return this;
    }

    public Integer getNeutralButtonTextColor() {
        return this.mNeutralButtonTextColor;
    }

    public SweetAlertDialog setCancelButtonTextColor(Integer color) {
        this.mCancelButtonTextColor = color;
        Button button = this.mCancelButton;
        if (!(button == null || color == null)) {
            button.setTextColor(color.intValue());
        }
        return this;
    }

    public Integer getCancelButtonTextColor() {
        return this.mCancelButtonTextColor;
    }

    public SweetAlertDialog setCancelClickListener(OnSweetClickListener listener) {
        this.mCancelClickListener = listener;
        return this;
    }

    public SweetAlertDialog setConfirmClickListener(OnSweetClickListener listener) {
        this.mConfirmClickListener = listener;
        return this;
    }

    public SweetAlertDialog setNeutralText(String text) {
        this.mNeutralText = text;
        if (!(this.mNeutralButton == null || text == null || text.isEmpty())) {
            this.mNeutralButton.setVisibility(0);
            this.mNeutralButton.setText(this.mNeutralText);
        }
        return this;
    }

    public SweetAlertDialog setNeutralClickListener(OnSweetClickListener listener) {
        this.mNeutralClickListener = listener;
        return this;
    }

    public void setTitle(CharSequence title) {
        setTitleText(title.toString());
    }

    public void setTitle(int titleId) {
        setTitleText(getContext().getResources().getString(titleId));
    }

    public Button getButton(int buttonType) {
        switch (buttonType) {
            case -3:
                return this.mNeutralButton;
            case -2:
                return this.mCancelButton;
            default:
                return this.mConfirmButton;
        }
    }

    public SweetAlertDialog setConfirmButton(String text, OnSweetClickListener listener) {
        setConfirmText(text);
        setConfirmClickListener(listener);
        return this;
    }

    public SweetAlertDialog setConfirmButton(int resId, OnSweetClickListener listener) {
        setConfirmButton(getContext().getResources().getString(resId), listener);
        return this;
    }

    public SweetAlertDialog setCancelButton(String text, OnSweetClickListener listener) {
        setCancelText(text);
        setCancelClickListener(listener);
        return this;
    }

    public SweetAlertDialog setCancelButton(int resId, OnSweetClickListener listener) {
        setCancelButton(getContext().getResources().getString(resId), listener);
        return this;
    }

    public SweetAlertDialog setNeutralButton(String text, OnSweetClickListener listener) {
        setNeutralText(text);
        setNeutralClickListener(listener);
        return this;
    }

    public SweetAlertDialog setNeutralButton(int resId, OnSweetClickListener listener) {
        setNeutralButton(getContext().getResources().getString(resId), listener);
        return this;
    }

    public SweetAlertDialog setContentTextSize(int value) {
        this.contentTextSize = value;
        return this;
    }

    public int getContentTextSize() {
        return this.contentTextSize;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.mDialogView.startAnimation(this.mModalInAnim);
        playAnimation();
    }

    public SweetAlertDialog setCustomView(View view) {
        FrameLayout frameLayout;
        this.mCustomView = view;
        if (!(view == null || (frameLayout = this.mCustomViewContainer) == null)) {
            frameLayout.addView(view);
            this.mCustomViewContainer.setVisibility(0);
            this.mContentTextView.setVisibility(8);
        }
        return this;
    }

    public void cancel() {
        dismissWithAnimation(true);
    }

    public void dismissWithAnimation() {
        dismissWithAnimation(false);
    }

    private void dismissWithAnimation(boolean fromCancel) {
        this.mCloseFromCancel = fromCancel;
        ((ViewGroup) this.mDialogView).getChildAt(0).startAnimation(this.mOverlayOutAnim);
        this.mDialogView.startAnimation(this.mModalOutAnim);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.cancel_button) {
            OnSweetClickListener onSweetClickListener = this.mCancelClickListener;
            if (onSweetClickListener != null) {
                onSweetClickListener.onClick(this);
            } else {
                dismissWithAnimation();
            }
        } else if (v.getId() == R.id.confirm_button) {
            OnSweetClickListener onSweetClickListener2 = this.mConfirmClickListener;
            if (onSweetClickListener2 != null) {
                onSweetClickListener2.onClick(this);
            } else {
                dismissWithAnimation();
            }
        } else if (v.getId() == R.id.neutral_button) {
            OnSweetClickListener onSweetClickListener3 = this.mNeutralClickListener;
            if (onSweetClickListener3 != null) {
                onSweetClickListener3.onClick(this);
            } else {
                dismissWithAnimation();
            }
        }
    }

    public ProgressHelper getProgressHelper() {
        return this.mProgressHelper;
    }

    public SweetAlertDialog setHideKeyBoardOnDismiss(boolean hide) {
        this.mHideKeyBoardOnDismiss = hide;
        return this;
    }

    public boolean isHideKeyBoardOnDismiss() {
        return this.mHideKeyBoardOnDismiss;
    }

    /* access modifiers changed from: private */
    public void hideSoftKeyboard() {
        InputMethodManager inputMethodManager;
        Activity activity = getOwnerActivity();
        if (activity != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null && activity.getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }
}
