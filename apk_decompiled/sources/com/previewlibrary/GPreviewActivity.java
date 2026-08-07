package com.previewlibrary;

import android.R;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.previewlibrary.enitity.IThumbViewInfo;
import com.previewlibrary.view.BasePhotoFragment;
import com.previewlibrary.wight.BezierBannerView;
import com.previewlibrary.wight.PhotoViewPager;
import com.previewlibrary.wight.SmoothImageView;
import com.seeker.luckychart.animation.ChartCoordinateportAnimator;
import com.tencent.open.SocialConstants;
import defpackage.jq0;
import defpackage.wl3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GPreviewActivity extends FragmentActivity {
    private List b;
    private int c;
    private PhotoViewPager e;
    private TextView f;
    private BezierBannerView g;
    private GPreviewBuilder$IndicatorType h;
    private boolean a = false;
    private List d = new ArrayList();
    private boolean i = true;

    class a implements ViewPager.j {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i) {
            if (GPreviewActivity.this.f != null) {
                GPreviewActivity.this.f.setText(GPreviewActivity.this.getString(R$string.string_count, Integer.valueOf(i + 1), Integer.valueOf(GPreviewActivity.this.b.size())));
            }
            GPreviewActivity.this.c = i;
            GPreviewActivity.this.e.N(GPreviewActivity.this.c, true);
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            GPreviewActivity.this.e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ((BasePhotoFragment) GPreviewActivity.this.d.get(GPreviewActivity.this.c)).B();
        }
    }

    class c implements SmoothImageView.j {
        c() {
        }

        @Override // com.previewlibrary.wight.SmoothImageView.j
        public void a(SmoothImageView.Status status) {
            GPreviewActivity.this.K();
        }
    }

    private class d extends jq0 {
        d(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // defpackage.jq0, androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i, Object obj) {
            super.a(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            if (GPreviewActivity.this.d == null) {
                return 0;
            }
            return GPreviewActivity.this.d.size();
        }

        @Override // defpackage.jq0
        public Fragment t(int i) {
            return (Fragment) GPreviewActivity.this.d.get(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        finish();
        overridePendingTransition(0, 0);
    }

    private void initData() {
        this.b = getIntent().getParcelableArrayListExtra("imagePaths");
        this.c = getIntent().getIntExtra("position", -1);
        this.h = (GPreviewBuilder$IndicatorType) getIntent().getSerializableExtra(SocialConstants.PARAM_TYPE);
        this.i = getIntent().getBooleanExtra("isShow", true);
        int intExtra = getIntent().getIntExtra("duration", ChartCoordinateportAnimator.FAST_ANIMATION_DURATION);
        if (getIntent().getBooleanExtra("isFullscreen", false)) {
            setTheme(R.style.Theme.Translucent.NoTitleBar.Fullscreen);
        }
        try {
            SmoothImageView.setDuration(intExtra);
            L(this.b, this.c, (Class) getIntent().getSerializableExtra("className"));
        } catch (Exception unused) {
            L(this.b, this.c, BasePhotoFragment.class);
        }
    }

    private void initView() {
        this.e = (PhotoViewPager) findViewById(R$id.viewPager);
        this.e.setAdapter(new d(getSupportFragmentManager()));
        this.e.setCurrentItem(this.c);
        this.e.setOffscreenPageLimit(3);
        this.g = (BezierBannerView) findViewById(R$id.bezierBannerView);
        TextView textView = (TextView) findViewById(R$id.ltAddDot);
        this.f = textView;
        if (this.h == GPreviewBuilder$IndicatorType.Dot) {
            this.g.setVisibility(0);
            this.g.a(this.e);
        } else {
            textView.setVisibility(0);
            this.f.setText(getString(R$string.string_count, Integer.valueOf(this.c + 1), Integer.valueOf(this.b.size())));
            this.e.c(new a());
        }
        if (this.d.size() == 1 && !this.i) {
            this.g.setVisibility(8);
            this.f.setVisibility(8);
        }
        this.e.getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    protected void L(List list, int i, Class cls) {
        if (list == null) {
            finish();
            return;
        }
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            this.d.add(BasePhotoFragment.y(cls, (IThumbViewInfo) list.get(i2), i == i2, getIntent().getBooleanExtra("isSingleFling", false), getIntent().getBooleanExtra("isDrag", false), getIntent().getFloatExtra("sensitivity", 0.5f)));
            i2++;
        }
    }

    public int M() {
        return 0;
    }

    public void N() {
        if (this.a) {
            return;
        }
        this.a = true;
        int currentItem = this.e.getCurrentItem();
        if (currentItem >= this.b.size()) {
            K();
            return;
        }
        BasePhotoFragment basePhotoFragment = (BasePhotoFragment) this.d.get(currentItem);
        TextView textView = this.f;
        if (textView != null) {
            textView.setVisibility(8);
        } else {
            this.g.setVisibility(8);
        }
        basePhotoFragment.w(0);
        basePhotoFragment.C(new c());
    }

    @Override // android.app.Activity
    public void finish() {
        int i = BasePhotoFragment.h;
        super.finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        N();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        if (M() == 0) {
            setContentView(R$layout.activity_image_preview_photo);
        } else {
            setContentView(M());
        }
        initView();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        wl3.a().b();
        throw null;
    }
}
