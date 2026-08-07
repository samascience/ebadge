package com.yalantis.ucrop;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.BlendModeCompat;
import com.luck.picture.lib.R$anim;
import com.luck.picture.lib.R$color;
import com.luck.picture.lib.R$dimen;
import com.luck.picture.lib.R$drawable;
import com.luck.picture.lib.R$id;
import com.luck.picture.lib.R$layout;
import com.luck.picture.lib.R$menu;
import com.luck.picture.lib.R$string;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import defpackage.a22;
import defpackage.bi;
import defpackage.bk;
import defpackage.f53;
import defpackage.ll2;
import defpackage.mm2;
import defpackage.o53;
import defpackage.q30;
import defpackage.s11;
import defpackage.s12;
import defpackage.sc;
import defpackage.v8;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class UCropActivity extends AppCompatActivity {
    public static final Bitmap.CompressFormat R = Bitmap.CompressFormat.JPEG;
    private TextView F;
    protected View G;
    private f53 H;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private String a;
    protected int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    protected boolean l;
    protected RelativeLayout n;
    private UCropView o;
    private GestureCropImageView p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private OverlayView f316q;
    private ViewGroup r;
    private ViewGroup s;
    private ViewGroup t;
    private ViewGroup u;
    private ViewGroup v;
    private ViewGroup w;
    private TextView z;
    private boolean m = true;
    private List x = new ArrayList();
    private List y = new ArrayList();
    private Bitmap.CompressFormat I = R;
    private int J = 90;
    private int[] K = {1, 2, 3};
    private TransformImageView.b P = new a();
    private final View.OnClickListener Q = new g();

    class a implements TransformImageView.b {
        a() {
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void a(float f) {
            UCropActivity.this.f0(f);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void b() {
            UCropActivity.this.o.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropActivity uCropActivity = UCropActivity.this;
            uCropActivity.G.setClickable(!uCropActivity.Z());
            UCropActivity.this.m = false;
            UCropActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void c(Exception exc) {
            UCropActivity.this.k0(exc);
            UCropActivity.this.onBackPressed();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void d(float f) {
            UCropActivity.this.m0(f);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.p.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).r(view.isSelected()));
            UCropActivity.this.p.z();
            if (view.isSelected()) {
                return;
            }
            for (ViewGroup viewGroup : UCropActivity.this.x) {
                viewGroup.setSelected(viewGroup == view);
            }
        }
    }

    class c implements HorizontalProgressWheelView.a {
        c() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void a() {
            UCropActivity.this.p.z();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void b(float f, float f2) {
            UCropActivity.this.p.x(f / 42.0f);
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void c() {
            UCropActivity.this.p.t();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.c0();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.d0(90);
        }
    }

    class f implements HorizontalProgressWheelView.a {
        f() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void a() {
            UCropActivity.this.p.z();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void b(float f, float f2) {
            if (f > 0.0f) {
                UCropActivity.this.p.C(UCropActivity.this.p.getCurrentScale() + (f * ((UCropActivity.this.p.getMaxScale() - UCropActivity.this.p.getMinScale()) / 15000.0f)));
            } else {
                UCropActivity.this.p.E(UCropActivity.this.p.getCurrentScale() + (f * ((UCropActivity.this.p.getMaxScale() - UCropActivity.this.p.getMinScale()) / 15000.0f)));
            }
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void c() {
            UCropActivity.this.p.t();
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                return;
            }
            UCropActivity.this.o0(view.getId());
        }
    }

    class h implements bi {
        h() {
        }

        @Override // defpackage.bi
        public void a(Uri uri, int i, int i2, int i3, int i4) {
            UCropActivity uCropActivity = UCropActivity.this;
            uCropActivity.l0(uri, uCropActivity.p.getTargetAspectRatio(), i, i2, i3, i4);
            if (UCropActivity.this.V() instanceof PictureMultiCuttingActivity) {
                return;
            }
            UCropActivity.this.onBackPressed();
        }

        @Override // defpackage.bi
        public void b(Throwable th) {
            UCropActivity.this.k0(th);
            UCropActivity.this.onBackPressed();
        }
    }

    static {
        androidx.appcompat.app.c.I(true);
    }

    private void R(int i) {
        o53.a((ViewGroup) findViewById(R$id.ucrop_photobox), this.H);
        this.t.findViewById(R$id.text_view_scale).setVisibility(i == R$id.state_scale ? 0 : 8);
        this.r.findViewById(R$id.text_view_crop).setVisibility(i == R$id.state_aspect_ratio ? 0 : 8);
        this.s.findViewById(R$id.text_view_rotate).setVisibility(i == R$id.state_rotate ? 0 : 8);
    }

    private void W(Intent intent) {
        this.O = intent.getBooleanExtra("com.yalantis.ucrop.openWhiteStatusBar", false);
        int i = R$color.ucrop_color_statusbar;
        this.d = intent.getIntExtra("com.yalantis.ucrop.StatusBarColor", q30.c(this, i));
        int i2 = R$color.ucrop_color_toolbar;
        int intExtra = intent.getIntExtra("com.yalantis.ucrop.ToolbarColor", q30.c(this, i2));
        this.c = intExtra;
        if (intExtra == 0) {
            this.c = q30.c(this, i2);
        }
        if (this.d == 0) {
            this.d = q30.c(this, i);
        }
    }

    private void Y() {
        this.n = (RelativeLayout) findViewById(R$id.ucrop_photobox);
        UCropView uCropView = (UCropView) findViewById(R$id.ucrop);
        this.o = uCropView;
        this.p = uCropView.getCropImageView();
        this.f316q = this.o.getOverlayView();
        this.p.setTransformImageListener(this.P);
        ((ImageView) findViewById(R$id.image_view_logo)).setColorFilter(this.k, PorterDuff.Mode.SRC_ATOP);
        findViewById(R$id.ucrop_frame).setBackgroundColor(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z() {
        Uri uri = (Uri) getIntent().getParcelableExtra("com.yalantis.ucrop.InputUri");
        if (uri == null) {
            return true;
        }
        return a0(uri);
    }

    private boolean a0(Uri uri) {
        if (uri == null) {
            return true;
        }
        if (a22.l(uri.toString())) {
            return !a22.j(a22.d(uri.toString()));
        }
        String strF = a22.f(this, uri);
        if (strF.endsWith("image/*")) {
            strF = a22.a(s12.l(this, uri));
        }
        return !a22.i(strF);
    }

    private void b0(Intent intent) {
        String stringExtra = intent.getStringExtra("com.yalantis.ucrop.CompressionFormatName");
        Bitmap.CompressFormat compressFormatValueOf = !TextUtils.isEmpty(stringExtra) ? Bitmap.CompressFormat.valueOf(stringExtra) : null;
        if (compressFormatValueOf == null) {
            compressFormatValueOf = R;
        }
        this.I = compressFormatValueOf;
        this.J = intent.getIntExtra("com.yalantis.ucrop.CompressionQuality", 90);
        OverlayView overlayView = this.f316q;
        Resources resources = getResources();
        int i = R$color.ucrop_color_default_crop_frame;
        overlayView.setDimmedBorderColor(intent.getIntExtra("com.yalantis.ucrop.DimmedLayerBorderColor", resources.getColor(i)));
        this.L = intent.getBooleanExtra("com.yalantis.ucrop.DragCropFrame", true);
        this.f316q.setDimmedStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CircleStrokeWidth", 1));
        this.M = intent.getBooleanExtra("com.yalantis.ucrop.scale", true);
        this.N = intent.getBooleanExtra("com.yalantis.ucrop.rotate", true);
        int[] intArrayExtra = intent.getIntArrayExtra("com.yalantis.ucrop.AllowedGestures");
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.K = intArrayExtra;
        }
        this.p.setMaxBitmapSize(intent.getIntExtra("com.yalantis.ucrop.MaxBitmapSize", 0));
        this.p.setMaxScaleMultiplier(intent.getFloatExtra("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f));
        this.p.setImageToWrapCropBoundsAnimDuration(intent.getIntExtra("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
        int intExtra = intent.getIntExtra("com.yalantis.ucrop.FreeStyleCropMode", -1);
        if (intExtra == -1 || intExtra > 2) {
            this.f316q.setFreestyleCropEnabled(intent.getBooleanExtra("com.yalantis.ucrop.FreeStyleCrop", false));
        } else {
            this.f316q.setFreestyleCropMode(intExtra);
        }
        this.f316q.setDragSmoothToCenter(intent.getBooleanExtra("com.yalantis.ucrop.DragSmoothToCenter", false));
        this.f316q.setDragFrame(this.L);
        this.f316q.setDimmedColor(intent.getIntExtra("com.yalantis.ucrop.DimmedLayerColor", getResources().getColor(R$color.ucrop_color_default_dimmed)));
        this.f316q.setCircleDimmedLayer(intent.getBooleanExtra("com.yalantis.ucrop.CircleDimmedLayer", false));
        this.f316q.setShowCropFrame(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropFrame", true));
        this.f316q.setCropFrameColor(intent.getIntExtra("com.yalantis.ucrop.CropFrameColor", getResources().getColor(i)));
        this.f316q.setCropFrameStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropFrameStrokeWidth", getResources().getDimensionPixelSize(R$dimen.ucrop_default_crop_frame_stoke_width)));
        this.f316q.setShowCropGrid(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropGrid", true));
        this.f316q.setCropGridRowCount(intent.getIntExtra("com.yalantis.ucrop.CropGridRowCount", 2));
        this.f316q.setCropGridColumnCount(intent.getIntExtra("com.yalantis.ucrop.CropGridColumnCount", 2));
        this.f316q.setCropGridColor(intent.getIntExtra("com.yalantis.ucrop.CropGridColor", getResources().getColor(R$color.ucrop_color_default_crop_grid)));
        this.f316q.setCropGridStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropGridStrokeWidth", getResources().getDimensionPixelSize(R$dimen.ucrop_default_crop_grid_stoke_width)));
        float floatExtra = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioX", 0.0f);
        float floatExtra2 = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioY", 0.0f);
        int intExtra2 = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        if (floatExtra > 0.0f && floatExtra2 > 0.0f) {
            ViewGroup viewGroup = this.r;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.p.setTargetAspectRatio(floatExtra / floatExtra2);
        } else if (parcelableArrayListExtra == null || intExtra2 >= parcelableArrayListExtra.size()) {
            this.p.setTargetAspectRatio(0.0f);
        } else {
            this.p.setTargetAspectRatio(((AspectRatio) parcelableArrayListExtra.get(intExtra2)).b() / ((AspectRatio) parcelableArrayListExtra.get(intExtra2)).c());
        }
        int intExtra3 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeX", 0);
        int intExtra4 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeY", 0);
        if (intExtra3 <= 0 || intExtra4 <= 0) {
            return;
        }
        this.p.setMaxResultImageSizeX(intExtra3);
        this.p.setMaxResultImageSizeY(intExtra4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        GestureCropImageView gestureCropImageView = this.p;
        gestureCropImageView.x(-gestureCropImageView.getCurrentAngle());
        this.p.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(int i) {
        this.p.x(i);
        this.p.z();
    }

    private void e0(int i) {
        if (Z()) {
            GestureCropImageView gestureCropImageView = this.p;
            boolean z = this.M;
            boolean z2 = false;
            if (z && this.l) {
                int i2 = this.K[i];
                z = i2 == 3 || i2 == 1;
            }
            gestureCropImageView.setScaleEnabled(z);
            GestureCropImageView gestureCropImageView2 = this.p;
            boolean z3 = this.N;
            if (z3 && this.l) {
                int i3 = this.K[i];
                if (i3 == 3 || i3 == 2) {
                    z2 = true;
                }
            } else {
                z2 = z3;
            }
            gestureCropImageView2.setRotateEnabled(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(float f2) {
        TextView textView = this.z;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f2)));
        }
    }

    private void i0() {
        int intExtra = getIntent().getIntExtra("com.yalantis.ucrop.navBarColor", 0);
        if (intExtra != 0) {
            getWindow().setNavigationBarColor(intExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(float f2) {
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f2 * 100.0f))));
        }
    }

    private void n0(int i) {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(int i) {
        if (this.l) {
            ViewGroup viewGroup = this.r;
            int i2 = R$id.state_aspect_ratio;
            viewGroup.setSelected(i == i2);
            ViewGroup viewGroup2 = this.s;
            int i3 = R$id.state_rotate;
            viewGroup2.setSelected(i == i3);
            ViewGroup viewGroup3 = this.t;
            int i4 = R$id.state_scale;
            viewGroup3.setSelected(i == i4);
            this.u.setVisibility(i == i2 ? 0 : 8);
            this.v.setVisibility(i == i3 ? 0 : 8);
            this.w.setVisibility(i == i4 ? 0 : 8);
            R(i);
            if (i == i4) {
                e0(0);
            } else if (i == i3) {
                e0(1);
            } else {
                e0(2);
            }
        }
    }

    private void p0() {
        n0(this.d);
        Toolbar toolbar = (Toolbar) findViewById(R$id.toolbar);
        toolbar.setBackgroundColor(this.c);
        toolbar.setTitleTextColor(this.g);
        TextView textView = (TextView) toolbar.findViewById(R$id.toolbar_title);
        textView.setTextColor(this.g);
        textView.setText(this.a);
        Drawable drawableMutate = v8.b(this, this.i).mutate();
        drawableMutate.setColorFilter(bk.a(this.g, BlendModeCompat.SRC_ATOP));
        toolbar.setNavigationIcon(drawableMutate);
        setSupportActionBar(toolbar);
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(false);
        }
    }

    private void q0(Intent intent) {
        int intExtra = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList<AspectRatio> parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(new AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new AspectRatio(getString(R$string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 16.0f, 9.0f));
            intExtra = 2;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.layout_aspect_ratio);
        int i = -1;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        if (V() instanceof PictureMultiCuttingActivity) {
            this.y = new ArrayList();
            this.x = new ArrayList();
        }
        for (AspectRatio aspectRatio : parcelableArrayListExtra) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R$layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.f);
            aspectRatioTextView.setAspectRatio(aspectRatio);
            this.y.add(aspectRatioTextView);
            linearLayout.addView(frameLayout);
            this.x.add(frameLayout);
        }
        ((ViewGroup) this.x.get(intExtra)).setSelected(true);
        for (ViewGroup viewGroup : this.x) {
            i++;
            viewGroup.setTag(Integer.valueOf(i));
            viewGroup.setOnClickListener(new b());
        }
    }

    private void r0() {
        this.z = (TextView) findViewById(R$id.text_view_rotate);
        int i = R$id.rotate_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i)).setScrollingListener(new c());
        ((HorizontalProgressWheelView) findViewById(i)).setMiddleLineColor(this.e);
        findViewById(R$id.wrapper_reset_rotate).setOnClickListener(new d());
        findViewById(R$id.wrapper_rotate_by_angle).setOnClickListener(new e());
    }

    private void s0() {
        this.F = (TextView) findViewById(R$id.text_view_scale);
        int i = R$id.scale_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i)).setScrollingListener(new f());
        ((HorizontalProgressWheelView) findViewById(i)).setMiddleLineColor(this.e);
    }

    private void t0() {
        ImageView imageView = (ImageView) findViewById(R$id.image_view_state_scale);
        ImageView imageView2 = (ImageView) findViewById(R$id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) findViewById(R$id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new mm2(imageView.getDrawable(), this.f));
        imageView2.setImageDrawable(new mm2(imageView2.getDrawable(), this.f));
        imageView3.setImageDrawable(new mm2(imageView3.getDrawable(), this.f));
    }

    protected void Q() {
        if (this.G == null) {
            this.G = new View(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R$id.toolbar);
            this.G.setLayoutParams(layoutParams);
            this.G.setClickable(true);
        }
        ((RelativeLayout) findViewById(R$id.ucrop_photobox)).addView(this.G);
    }

    protected void S() {
        finish();
        U();
    }

    protected void T() {
        this.G.setClickable(true);
        this.m = true;
        supportInvalidateOptionsMenu();
        this.p.u(this.I, this.J, new h());
    }

    protected void U() {
        int intExtra = getIntent().getIntExtra("com.yalantis.ucrop.WindowAnimation", 0);
        int i = R$anim.ucrop_anim_fade_in;
        if (intExtra == 0) {
            intExtra = R$anim.ucrop_close;
        }
        overridePendingTransition(i, intExtra);
    }

    protected Activity V() {
        return this;
    }

    public void X() {
        s11.a(this, this.d, this.c, this.O);
    }

    protected void g0(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.InputUri");
        Uri uri2 = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
        b0(intent);
        if (uri == null || uri2 == null) {
            k0(new NullPointerException("在你的 App 內复写颜色资源 (ucrop_color_toolbar_widget) 使 5.0 以前裝置正常运作"));
            onBackPressed();
            return;
        }
        try {
            boolean zA0 = a0(uri);
            this.p.setRotateEnabled(zA0 ? this.N : zA0);
            GestureCropImageView gestureCropImageView = this.p;
            if (zA0) {
                zA0 = this.M;
            }
            gestureCropImageView.setScaleEnabled(zA0);
            this.p.n(uri, uri2, intent.getIntExtra("com.yalantis.ucrop.InputImageWidth", 0), intent.getIntExtra("com.yalantis.ucrop.InputImageHeight", 0));
        } catch (Exception e2) {
            k0(e2);
            onBackPressed();
        }
    }

    protected void h0() {
        if (!this.l) {
            e0(0);
        } else if (this.r.getVisibility() == 0) {
            o0(R$id.state_aspect_ratio);
        } else {
            o0(R$id.state_scale);
        }
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        return true;
    }

    protected void j0(Intent intent) {
        int intExtra = intent.getIntExtra("com.yalantis.ucrop.activityOrientation", -1);
        if (getRequestedOrientation() != intExtra) {
            setRequestedOrientation(intExtra);
        }
    }

    protected void k0(Throwable th) {
        setResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", th));
    }

    protected void l0(Uri uri, float f2, int i, int i2, int i3, int i4) {
        setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", uri).putExtra("com.yalantis.ucrop.CropAspectRatio", f2).putExtra("com.yalantis.ucrop.ImageWidth", i3).putExtra("com.yalantis.ucrop.ImageHeight", i4).putExtra("com.yalantis.ucrop.OffsetX", i).putExtra("com.yalantis.ucrop.OffsetY", i2).putExtra("com.yalantis.ucrop.EditorImage", getIntent().getBooleanExtra("com.yalantis.ucrop.EditorImage", false)));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        S();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        j0(intent);
        W(intent);
        if (isImmersive()) {
            X();
        }
        setContentView(R$layout.ucrop_activity_photobox);
        this.b = ll2.c(this);
        u0(intent);
        i0();
        g0(intent);
        h0();
        Q();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R$menu.ucrop_menu_activity, menu);
        MenuItem menuItemFindItem = menu.findItem(R$id.menu_loader);
        Drawable icon = menuItemFindItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(bk.a(this.g, BlendModeCompat.SRC_ATOP));
                menuItemFindItem.setIcon(icon);
            } catch (IllegalStateException e2) {
                Log.i("UCropActivity", String.format("%s - %s", e2.getMessage(), "必須指定輸入以及輸出的 Uri"));
            }
            ((Animatable) menuItemFindItem.getIcon()).start();
        }
        MenuItem menuItemFindItem2 = menu.findItem(R$id.menu_crop);
        Drawable drawableE = q30.e(this, this.j);
        if (drawableE == null) {
            return true;
        }
        drawableE.mutate();
        drawableE.setColorFilter(bk.a(this.g, BlendModeCompat.SRC_ATOP));
        menuItemFindItem2.setIcon(drawableE);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R$id.menu_crop) {
            T();
            return true;
        }
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R$id.menu_crop).setVisible(!this.m);
        menu.findItem(R$id.menu_loader).setVisible(this.m);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.p;
        if (gestureCropImageView != null) {
            gestureCropImageView.t();
        }
    }

    protected void u0(Intent intent) {
        this.d = intent.getIntExtra("com.yalantis.ucrop.StatusBarColor", q30.c(this, R$color.ucrop_color_statusbar));
        this.c = intent.getIntExtra("com.yalantis.ucrop.ToolbarColor", q30.c(this, R$color.ucrop_color_toolbar));
        this.e = intent.getIntExtra("com.yalantis.ucrop.UcropColorWidgetActive", q30.c(this, R$color.ucrop_color_widget_background));
        this.f = intent.getIntExtra("com.yalantis.ucrop.UcropColorControlsWidgetActive", q30.c(this, R$color.ucrop_color_active_controls_color));
        this.g = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarWidgetColor", q30.c(this, R$color.ucrop_color_toolbar_widget));
        this.i = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCancelDrawable", R$drawable.ucrop_ic_cross);
        this.j = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCropDrawable", R$drawable.ucrop_ic_done);
        String stringExtra = intent.getStringExtra("com.yalantis.ucrop.UcropToolbarTitleText");
        this.a = stringExtra;
        if (stringExtra == null) {
            stringExtra = getResources().getString(R$string.ucrop_label_edit_photo);
        }
        this.a = stringExtra;
        this.k = intent.getIntExtra("com.yalantis.ucrop.UcropLogoColor", q30.c(this, R$color.ucrop_color_default_logo));
        this.l = !intent.getBooleanExtra("com.yalantis.ucrop.HideBottomControls", false);
        this.h = intent.getIntExtra("com.yalantis.ucrop.UcropRootViewBackgroundColor", q30.c(this, R$color.ucrop_color_crop_background));
        p0();
        Y();
        if (this.l) {
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(R$id.ucrop_photobox)).findViewById(R$id.controls_wrapper);
            viewGroup.setVisibility(0);
            viewGroup.setBackgroundColor(this.h);
            LayoutInflater.from(this).inflate(R$layout.ucrop_controls, viewGroup, true);
            sc scVar = new sc();
            this.H = scVar;
            scVar.X(50L);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R$id.state_aspect_ratio);
            this.r = viewGroup2;
            viewGroup2.setOnClickListener(this.Q);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R$id.state_rotate);
            this.s = viewGroup3;
            viewGroup3.setOnClickListener(this.Q);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(R$id.state_scale);
            this.t = viewGroup4;
            viewGroup4.setOnClickListener(this.Q);
            this.u = (ViewGroup) findViewById(R$id.layout_aspect_ratio);
            this.v = (ViewGroup) findViewById(R$id.layout_rotate_wheel);
            this.w = (ViewGroup) findViewById(R$id.layout_scale_wheel);
            q0(intent);
            r0();
            s0();
            t0();
        }
    }
}
