package com.previewlibrary.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.previewlibrary.GPVideoPlayerActivity;
import com.previewlibrary.GPreviewActivity;
import com.previewlibrary.R$id;
import com.previewlibrary.R$layout;
import com.previewlibrary.enitity.IThumbViewInfo;
import com.previewlibrary.wight.SmoothImageView;
import defpackage.an1;
import defpackage.be3;
import defpackage.wl3;

/* JADX INFO: loaded from: classes.dex */
public class BasePhotoFragment extends Fragment {
    public static final /* synthetic */ int h = 0;
    private IThumbViewInfo a;
    private boolean b = false;
    protected SmoothImageView c;
    protected View d;
    protected View e;
    protected an1 f;
    protected View g;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String videoUrl = BasePhotoFragment.this.a.getVideoUrl();
            if (videoUrl == null || videoUrl.isEmpty()) {
                return;
            }
            GPVideoPlayerActivity.a(BasePhotoFragment.this.getContext(), videoUrl);
        }
    }

    class b implements an1 {
        b() {
        }
    }

    class c implements uk.co.senab2.photoview2.c.i {
        c() {
        }

        @Override // uk.co.senab2.photoview2.c.i
        public void a(View view, float f, float f2) {
            if (BasePhotoFragment.this.c.i()) {
                ((GPreviewActivity) BasePhotoFragment.this.getActivity()).N();
            }
        }
    }

    class d implements SmoothImageView.g {
        d() {
        }

        @Override // com.previewlibrary.wight.SmoothImageView.g
        public void a(int i) {
            String videoUrl;
            if (i != 255 || (videoUrl = BasePhotoFragment.this.a.getVideoUrl()) == null || videoUrl.isEmpty()) {
                BasePhotoFragment.this.g.setVisibility(8);
            } else {
                BasePhotoFragment.this.g.setVisibility(0);
            }
            BasePhotoFragment.this.d.setBackgroundColor(BasePhotoFragment.x(i / 255.0f, -16777216));
        }
    }

    class e implements SmoothImageView.h {
        e() {
        }

        @Override // com.previewlibrary.wight.SmoothImageView.h
        public void a() {
            ((GPreviewActivity) BasePhotoFragment.this.getActivity()).N();
        }
    }

    class f implements SmoothImageView.j {
        f() {
        }

        @Override // com.previewlibrary.wight.SmoothImageView.j
        public void a(SmoothImageView.Status status) {
            BasePhotoFragment.this.d.setBackgroundColor(-16777216);
        }
    }

    private void initView(View view) {
        this.e = view.findViewById(R$id.loading);
        this.c = (SmoothImageView) view.findViewById(R$id.photoView);
        this.g = view.findViewById(R$id.btnVideo);
        View viewFindViewById = view.findViewById(R$id.rootView);
        this.d = viewFindViewById;
        viewFindViewById.setDrawingCacheEnabled(false);
        this.c.setDrawingCacheEnabled(false);
        this.g.setOnClickListener(new a());
        this.f = new b();
    }

    public static int x(float f2, int i) {
        return (Math.min(255, Math.max(0, (int) (f2 * 255.0f))) << 24) + (i & 16777215);
    }

    public static BasePhotoFragment y(Class cls, IThumbViewInfo iThumbViewInfo, boolean z, boolean z2, boolean z3, float f2) {
        BasePhotoFragment basePhotoFragment;
        try {
            basePhotoFragment = (BasePhotoFragment) cls.newInstance();
        } catch (Exception unused) {
            basePhotoFragment = new BasePhotoFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_item", iThumbViewInfo);
        bundle.putBoolean("is_trans_photo", z);
        bundle.putBoolean("isSingleFling", z2);
        bundle.putBoolean("isDrag", z3);
        bundle.putFloat("sensitivity", f2);
        basePhotoFragment.setArguments(bundle);
        return basePhotoFragment;
    }

    private void z() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            if (this.b) {
                this.c.setMinimumScale(0.7f);
            } else {
                this.d.setBackgroundColor(-16777216);
            }
            this.c.setOnViewTapListener(new c());
            this.c.setAlphaChangeListener(new d());
            this.c.setTransformOutListener(new e());
            return;
        }
        arguments.getBoolean("isSingleFling");
        this.a = (IThumbViewInfo) arguments.getParcelable("key_item");
        this.c.n(arguments.getBoolean("isDrag"), arguments.getFloat("sensitivity"));
        this.c.setThumbRect(this.a.getBounds());
        this.d.setTag(this.a.getUrl());
        this.b = arguments.getBoolean("is_trans_photo", false);
        if (!this.a.getUrl().toLowerCase().contains(".gif")) {
            wl3.a().b();
            this.a.getUrl();
            throw null;
        }
        this.c.setZoomable(false);
        wl3.a().b();
        this.a.getUrl();
        throw null;
    }

    public void A() {
        this.f = null;
        SmoothImageView smoothImageView = this.c;
        if (smoothImageView != null) {
            smoothImageView.setImageBitmap(null);
            this.c.setOnViewTapListener(null);
            this.c.setOnPhotoTapListener(null);
            this.c.setAlphaChangeListener(null);
            this.c.setTransformOutListener(null);
            this.c.p(null);
            this.c.q(null);
            this.c.setOnLongClickListener(null);
            this.g.setOnClickListener(null);
            this.c = null;
            this.d = null;
            this.b = false;
        }
    }

    public void B() {
        this.c.p(new f());
    }

    public void C(SmoothImageView.j jVar) {
        this.c.q(jVar);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_image_photo_layout, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        wl3.a().b();
        getActivity();
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        A();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        wl3.a().b();
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView(view);
        z();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }

    public void w(int i) {
        be3.e(this.g).b(0.0f).f(500L).l();
        this.d.setBackgroundColor(i);
    }
}
