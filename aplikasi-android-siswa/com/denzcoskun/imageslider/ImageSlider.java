package com.denzcoskun.imageslider;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.denzcoskun.imageslider.adapters.ViewPagerAdapter;
import com.denzcoskun.imageslider.animations.BackgroundToForeground;
import com.denzcoskun.imageslider.animations.CubeIn;
import com.denzcoskun.imageslider.animations.CubeOut;
import com.denzcoskun.imageslider.animations.DepthSlide;
import com.denzcoskun.imageslider.animations.FidgetSpinner;
import com.denzcoskun.imageslider.animations.FlipHorizontal;
import com.denzcoskun.imageslider.animations.FlipVertical;
import com.denzcoskun.imageslider.animations.ForegroundToBackground;
import com.denzcoskun.imageslider.animations.Gate;
import com.denzcoskun.imageslider.animations.RotateDown;
import com.denzcoskun.imageslider.animations.RotateUp;
import com.denzcoskun.imageslider.animations.Toss;
import com.denzcoskun.imageslider.animations.ZoomIn;
import com.denzcoskun.imageslider.animations.ZoomOut;
import com.denzcoskun.imageslider.constants.AnimationTypes;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemChangeListener;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.interfaces.TouchListener;
import com.denzcoskun.imageslider.models.SlideModel;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010+\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0016\u0010.\u001a\u00020-2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\u0014\u00102\u001a\u00020-2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100J \u00102\u001a\u00020-2\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\n\b\u0002\u00103\u001a\u0004\u0018\u000104J\u000e\u00105\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u00106\u001a\u00020-2\u0006\u00107\u001a\u000208J\u000e\u00109\u001a\u00020-2\u0006\u0010:\u001a\u00020;J\u000e\u0010<\u001a\u00020-2\u0006\u0010$\u001a\u00020%J\u0010\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020\u0007H\u0002J\u0010\u0010?\u001a\u00020-2\b\b\u0002\u0010@\u001a\u00020\u000eJ\u0006\u0010A\u001a\u00020-J\u0012\u0010B\u001a\u00020-*\u00020(2\u0006\u0010C\u001a\u00020DR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/denzcoskun/imageslider/ImageSlider;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autoCycle", "", "cornerRadius", "currentPage", "delay", "", "dots", "", "Landroid/widget/ImageView;", "[Landroid/widget/ImageView;", "errorImage", "imageCount", "indicatorAlign", "", "itemChangeListener", "Lcom/denzcoskun/imageslider/interfaces/ItemChangeListener;", "noDots", "pagerDots", "Landroid/widget/LinearLayout;", "period", "placeholder", "selectedDot", "swipeTimer", "Ljava/util/Timer;", "textAlign", "textColor", "titleBackground", "touchListener", "Lcom/denzcoskun/imageslider/interfaces/TouchListener;", "unselectedDot", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "viewPagerAdapter", "Lcom/denzcoskun/imageslider/adapters/ViewPagerAdapter;", "getGravityFromAlign", "scheduleTimer", "", "setAdapter", "imageList", "", "Lcom/denzcoskun/imageslider/models/SlideModel;", "setImageList", "scaleType", "Lcom/denzcoskun/imageslider/constants/ScaleTypes;", "setItemChangeListener", "setItemClickListener", "itemClickListener", "Lcom/denzcoskun/imageslider/interfaces/ItemClickListener;", "setSlideAnimation", "animationType", "Lcom/denzcoskun/imageslider/constants/AnimationTypes;", "setTouchListener", "setupDots", "size", "startSliding", "changeablePeriod", "stopSliding", "setViewPageScroller", "viewPageScroller", "Lcom/denzcoskun/imageslider/ViewPagerScroller;", "imageslider_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ImageSlider.kt */
public final class ImageSlider extends RelativeLayout {
    private boolean autoCycle;
    private int cornerRadius;
    /* access modifiers changed from: private */
    public int currentPage;
    private long delay;
    /* access modifiers changed from: private */
    public ImageView[] dots;
    private int errorImage;
    /* access modifiers changed from: private */
    public int imageCount;
    private String indicatorAlign;
    /* access modifiers changed from: private */
    public ItemChangeListener itemChangeListener;
    private boolean noDots;
    private LinearLayout pagerDots;
    private long period;
    private int placeholder;
    /* access modifiers changed from: private */
    public int selectedDot;
    private Timer swipeTimer;
    private String textAlign;
    private String textColor;
    private int titleBackground;
    private TouchListener touchListener;
    /* access modifiers changed from: private */
    public int unselectedDot;
    /* access modifiers changed from: private */
    public ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnimationTypes.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AnimationTypes.ZOOM_IN.ordinal()] = 1;
            iArr[AnimationTypes.ZOOM_OUT.ordinal()] = 2;
            iArr[AnimationTypes.DEPTH_SLIDE.ordinal()] = 3;
            iArr[AnimationTypes.CUBE_IN.ordinal()] = 4;
            iArr[AnimationTypes.CUBE_OUT.ordinal()] = 5;
            iArr[AnimationTypes.FLIP_HORIZONTAL.ordinal()] = 6;
            iArr[AnimationTypes.FLIP_VERTICAL.ordinal()] = 7;
            iArr[AnimationTypes.ROTATE_UP.ordinal()] = 8;
            iArr[AnimationTypes.ROTATE_DOWN.ordinal()] = 9;
            iArr[AnimationTypes.FOREGROUND_TO_BACKGROUND.ordinal()] = 10;
            iArr[AnimationTypes.BACKGROUND_TO_FOREGROUND.ordinal()] = 11;
            iArr[AnimationTypes.TOSS.ordinal()] = 12;
            iArr[AnimationTypes.GATE.ordinal()] = 13;
        }
    }

    public ImageSlider(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public ImageSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageSlider(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.textAlign = "LEFT";
        this.indicatorAlign = "CENTER";
        this.swipeTimer = new Timer();
        this.textColor = "#FFFFFF";
        LayoutInflater.from(getContext()).inflate(R.layout.image_slider, this, true);
        this.viewPager = (ViewPager) findViewById(R.id.view_pager);
        this.pagerDots = (LinearLayout) findViewById(R.id.pager_dots);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ImageSlider, defStyleAttr, defStyleAttr);
        this.cornerRadius = typedArray.getInt(R.styleable.ImageSlider_iss_corner_radius, 1);
        this.period = (long) typedArray.getInt(R.styleable.ImageSlider_iss_period, 1000);
        this.delay = (long) typedArray.getInt(R.styleable.ImageSlider_iss_delay, 1000);
        this.autoCycle = typedArray.getBoolean(R.styleable.ImageSlider_iss_auto_cycle, false);
        this.placeholder = typedArray.getResourceId(R.styleable.ImageSlider_iss_placeholder, R.drawable.default_loading);
        this.errorImage = typedArray.getResourceId(R.styleable.ImageSlider_iss_error_image, R.drawable.default_error);
        this.selectedDot = typedArray.getResourceId(R.styleable.ImageSlider_iss_selected_dot, R.drawable.default_selected_dot);
        this.unselectedDot = typedArray.getResourceId(R.styleable.ImageSlider_iss_unselected_dot, R.drawable.default_unselected_dot);
        this.titleBackground = typedArray.getResourceId(R.styleable.ImageSlider_iss_title_background, R.drawable.default_gradient);
        this.noDots = typedArray.getBoolean(R.styleable.ImageSlider_iss_no_dots, false);
        if (typedArray.getString(R.styleable.ImageSlider_iss_text_align) != null) {
            String string = typedArray.getString(R.styleable.ImageSlider_iss_text_align);
            if (string == null) {
                Intrinsics.throwNpe();
            }
            this.textAlign = string;
        }
        if (typedArray.getString(R.styleable.ImageSlider_iss_indicator_align) != null) {
            String string2 = typedArray.getString(R.styleable.ImageSlider_iss_indicator_align);
            if (string2 == null) {
                Intrinsics.throwNpe();
            }
            this.indicatorAlign = string2;
        }
        if (typedArray.getString(R.styleable.ImageSlider_iss_text_color) != null) {
            String string3 = typedArray.getString(R.styleable.ImageSlider_iss_text_color);
            if (string3 == null) {
                Intrinsics.throwNpe();
            }
            this.textColor = string3;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ImageSlider(android.content.Context r1, android.util.AttributeSet r2, int r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 2
            if (r5 == 0) goto L_0x0008
            r2 = 0
            r5 = r2
            android.util.AttributeSet r5 = (android.util.AttributeSet) r5
        L_0x0008:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x000d
            r3 = 0
        L_0x000d:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.denzcoskun.imageslider.ImageSlider.<init>(android.content.Context, android.util.AttributeSet, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final void setImageList(List<SlideModel> imageList) {
        Intrinsics.checkParameterIsNotNull(imageList, "imageList");
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        this.viewPagerAdapter = new ViewPagerAdapter(context, imageList, this.cornerRadius, this.errorImage, this.placeholder, this.titleBackground, this.textAlign, this.textColor);
        setAdapter(imageList);
    }

    public static /* synthetic */ void setImageList$default(ImageSlider imageSlider, List list, ScaleTypes scaleTypes, int i, Object obj) {
        if ((i & 2) != 0) {
            scaleTypes = null;
            ScaleTypes scaleTypes2 = null;
        }
        imageSlider.setImageList(list, scaleTypes);
    }

    public final void setImageList(List<SlideModel> imageList, ScaleTypes scaleType) {
        Intrinsics.checkParameterIsNotNull(imageList, "imageList");
        this.viewPagerAdapter = new ViewPagerAdapter(getContext(), imageList, this.cornerRadius, this.errorImage, this.placeholder, this.titleBackground, scaleType, this.textAlign, this.textColor);
        setAdapter(imageList);
    }

    private final void setAdapter(List<SlideModel> imageList) {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwNpe();
        }
        viewPager2.setAdapter(this.viewPagerAdapter);
        this.imageCount = imageList.size();
        if (!imageList.isEmpty()) {
            if (!this.noDots) {
                setupDots(imageList.size());
            }
            if (this.autoCycle) {
                startSliding$default(this, 0, 1, (Object) null);
            }
        }
    }

    public final void setSlideAnimation(AnimationTypes animationType) {
        Intrinsics.checkParameterIsNotNull(animationType, "animationType");
        switch (WhenMappings.$EnumSwitchMapping$0[animationType.ordinal()]) {
            case 1:
                ViewPager viewPager2 = this.viewPager;
                if (viewPager2 == null) {
                    Intrinsics.throwNpe();
                }
                viewPager2.setPageTransformer(true, new ZoomIn());
                return;
            case 2:
                ViewPager viewPager3 = this.viewPager;
                if (viewPager3 == null) {
                    Intrinsics.throwNpe();
                }
                viewPager3.setPageTransformer(true, new ZoomOut());
                return;
            case 3:
                ViewPager viewPager4 = this.viewPager;
                if (viewPager4 == null) {
                    Intrinsics.throwNpe();
                }
                viewPager4.setPageTransformer(true, new DepthSlide());
                return;
            case 4:
                ViewPager viewPager5 = this.viewPager;
                if (viewPager5 == null) {
                    Intrinsics.throwNpe();
                }
                viewPager5.setPageTransformer(true, new CubeIn());
                return;
            case 5:
                ViewPager viewPager6 = this.viewPager;
                if (viewPager6 == null) {
                    Intrinsics.throwNpe();
                }
                viewPager6.setPageTransformer(true, new CubeOut());
                return;
            case 6:
                ViewPager viewPager7 = this.viewPager;
                if (viewPager7 == null) {
                    Intrinsics.throwNpe();
                }
                viewPager7.setPageTransformer(true, new FlipHorizontal());
                return;
            case 7:
                ViewPager viewPager8 = this.viewPager;
                if (viewPager8 == null) {
                    Intrinsics.throwNpe();
                }
                viewPager8.setPageTransformer(true, new FlipVertical());
                return;
            case 8:
                ViewPager viewPager9 = this.viewPager;
                if (viewPager9 == null) {
                    Intrinsics.throwNpe();
                }
                viewPager9.setPageTransformer(true, new RotateUp());
                return;
            case 9:
                ViewPager viewPager10 = this.viewPager;
                if (viewPager10 == null) {
                    Intrinsics.throwNpe();
                }
                viewPager10.setPageTransformer(true, new RotateDown());
                return;
            case 10:
                ViewPager viewPager11 = this.viewPager;
                if (viewPager11 == null) {
                    Intrinsics.throwNpe();
                }
                viewPager11.setPageTransformer(true, new ForegroundToBackground());
                return;
            case 11:
                ViewPager viewPager12 = this.viewPager;
                if (viewPager12 == null) {
                    Intrinsics.throwNpe();
                }
                viewPager12.setPageTransformer(true, new BackgroundToForeground());
                return;
            case 12:
                ViewPager viewPager13 = this.viewPager;
                if (viewPager13 == null) {
                    Intrinsics.throwNpe();
                }
                viewPager13.setPageTransformer(true, new Toss());
                return;
            case 13:
                ViewPager viewPager14 = this.viewPager;
                if (viewPager14 == null) {
                    Intrinsics.throwNpe();
                }
                viewPager14.setPageTransformer(true, new Gate());
                return;
            default:
                ViewPager viewPager15 = this.viewPager;
                if (viewPager15 == null) {
                    Intrinsics.throwNpe();
                }
                viewPager15.setPageTransformer(true, new FidgetSpinner());
                return;
        }
    }

    private final void setupDots(int size) {
        LinearLayout linearLayout = this.pagerDots;
        if (linearLayout == null) {
            Intrinsics.throwNpe();
        }
        linearLayout.setGravity(getGravityFromAlign(this.indicatorAlign));
        LinearLayout linearLayout2 = this.pagerDots;
        if (linearLayout2 == null) {
            Intrinsics.throwNpe();
        }
        linearLayout2.removeAllViews();
        this.dots = new ImageView[size];
        for (int i = 0; i < size; i++) {
            ImageView[] imageViewArr = this.dots;
            if (imageViewArr == null) {
                Intrinsics.throwNpe();
            }
            imageViewArr[i] = new ImageView(getContext());
            ImageView[] imageViewArr2 = this.dots;
            if (imageViewArr2 == null) {
                Intrinsics.throwNpe();
            }
            ImageView imageView = imageViewArr2[i];
            if (imageView == null) {
                Intrinsics.throwNpe();
            }
            imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), this.unselectedDot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, -2);
            params.setMargins(8, 0, 8, 0);
            LinearLayout linearLayout3 = this.pagerDots;
            if (linearLayout3 == null) {
                Intrinsics.throwNpe();
            }
            ImageView[] imageViewArr3 = this.dots;
            if (imageViewArr3 == null) {
                Intrinsics.throwNpe();
            }
            linearLayout3.addView(imageViewArr3[i], params);
        }
        ImageView[] imageViewArr4 = this.dots;
        if (imageViewArr4 == null) {
            Intrinsics.throwNpe();
        }
        ImageView imageView2 = imageViewArr4[0];
        if (imageView2 == null) {
            Intrinsics.throwNpe();
        }
        imageView2.setImageDrawable(ContextCompat.getDrawable(getContext(), this.selectedDot));
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwNpe();
        }
        viewPager2.addOnPageChangeListener(new ImageSlider$setupDots$1(this));
    }

    public static /* synthetic */ void startSliding$default(ImageSlider imageSlider, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = imageSlider.period;
        }
        imageSlider.startSliding(j);
    }

    public final void startSliding(long changeablePeriod) {
        stopSliding();
        scheduleTimer(changeablePeriod);
    }

    public final void stopSliding() {
        this.swipeTimer.cancel();
        this.swipeTimer.purge();
    }

    private final void scheduleTimer(long period2) {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwNpe();
        }
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        setViewPageScroller(viewPager2, new ViewPagerScroller(context));
        Timer timer = new Timer();
        this.swipeTimer = timer;
        timer.schedule(new ImageSlider$scheduleTimer$1(new Handler(), new ImageSlider$scheduleTimer$update$1(this)), this.delay, period2);
    }

    public final void setViewPageScroller(ViewPager $this$setViewPageScroller, ViewPagerScroller viewPageScroller) {
        Intrinsics.checkParameterIsNotNull($this$setViewPageScroller, "$this$setViewPageScroller");
        Intrinsics.checkParameterIsNotNull(viewPageScroller, "viewPageScroller");
        try {
            Field mScroller = ViewPager.class.getDeclaredField("mScroller");
            Intrinsics.checkExpressionValueIsNotNull(mScroller, "ViewPager::class.java.ge…eclaredField(\"mScroller\")");
            mScroller.setAccessible(true);
            mScroller.set($this$setViewPageScroller, viewPageScroller);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
        }
    }

    public final void setItemClickListener(ItemClickListener itemClickListener) {
        Intrinsics.checkParameterIsNotNull(itemClickListener, "itemClickListener");
        ViewPagerAdapter viewPagerAdapter2 = this.viewPagerAdapter;
        if (viewPagerAdapter2 != null) {
            viewPagerAdapter2.setItemClickListener(itemClickListener);
        }
    }

    public final void setItemChangeListener(ItemChangeListener itemChangeListener2) {
        Intrinsics.checkParameterIsNotNull(itemChangeListener2, "itemChangeListener");
        this.itemChangeListener = itemChangeListener2;
    }

    public final void setTouchListener(TouchListener touchListener2) {
        Intrinsics.checkParameterIsNotNull(touchListener2, "touchListener");
        this.touchListener = touchListener2;
        ViewPagerAdapter viewPagerAdapter2 = this.viewPagerAdapter;
        if (viewPagerAdapter2 == null) {
            Intrinsics.throwNpe();
        }
        viewPagerAdapter2.setTouchListener(touchListener2);
    }

    public final int getGravityFromAlign(String textAlign2) {
        Intrinsics.checkParameterIsNotNull(textAlign2, "textAlign");
        switch (textAlign2.hashCode()) {
            case 2332679:
                if (textAlign2.equals("LEFT")) {
                    return 3;
                }
                break;
            case 77974012:
                if (textAlign2.equals("RIGHT")) {
                    return 5;
                }
                break;
        }
        return 17;
    }
}
