package com.luck.picture.lib;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.luck.picture.lib.widget.PreviewViewPager;
import com.tencent.connect.common.Constants;
import defpackage.a22;
import defpackage.cb;
import defpackage.db3;
import defpackage.i11;
import defpackage.i32;
import defpackage.jg3;
import defpackage.ll2;
import defpackage.ol2;
import defpackage.p33;
import defpackage.qc1;
import defpackage.s12;
import defpackage.sv2;
import defpackage.t73;
import defpackage.v22;
import defpackage.wv1;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PicturePreviewActivity extends PictureBaseActivity implements View.OnClickListener, i32.a {
    public static final String V = "PicturePreviewActivity";
    protected i32 G;
    protected Animation H;
    protected TextView I;
    protected View J;
    protected boolean K;
    protected int L;
    protected int M;
    protected RelativeLayout N;
    protected CheckBox O;
    protected boolean P;
    protected String Q;
    protected boolean R;
    protected boolean S;
    protected String U;
    protected ViewGroup n;
    protected ImageView o;
    protected TextView p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected TextView f292q;
    protected TextView r;
    protected TextView s;
    protected ImageView t;
    protected PreviewViewPager u;
    protected View v;
    protected TextView w;
    protected int x;
    protected boolean y;
    private int z;
    protected List F = new ArrayList();
    private int T = 0;

    class a extends wv1 {
        final /* synthetic */ List a;

        a(List list) {
            this.a = list;
        }

        @Override // defpackage.wv1
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(LocalMediaFolder localMediaFolder) {
            PicturePreviewActivity.this.u0(localMediaFolder != null ? localMediaFolder.d() : this.a);
        }
    }

    class b implements ViewPager.j {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i, float f, int i2) {
            PicturePreviewActivity picturePreviewActivity = PicturePreviewActivity.this;
            picturePreviewActivity.v0(picturePreviewActivity.a.B0, i, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i) {
            PicturePreviewActivity picturePreviewActivity = PicturePreviewActivity.this;
            picturePreviewActivity.x = i;
            picturePreviewActivity.M0();
            PicturePreviewActivity picturePreviewActivity2 = PicturePreviewActivity.this;
            LocalMedia localMediaA = picturePreviewActivity2.G.A(picturePreviewActivity2.x);
            if (localMediaA == null) {
                return;
            }
            PicturePreviewActivity.this.L = localMediaA.r();
            PicturePreviewActivity picturePreviewActivity3 = PicturePreviewActivity.this;
            PictureSelectionConfig pictureSelectionConfig = picturePreviewActivity3.a;
            if (!pictureSelectionConfig.B0) {
                if (pictureSelectionConfig.m0) {
                    picturePreviewActivity3.I.setText(db3.e(Integer.valueOf(localMediaA.o())));
                    PicturePreviewActivity.this.A0(localMediaA);
                }
                PicturePreviewActivity picturePreviewActivity4 = PicturePreviewActivity.this;
                picturePreviewActivity4.E0(picturePreviewActivity4.x);
            }
            PicturePreviewActivity picturePreviewActivity5 = PicturePreviewActivity.this;
            PictureSelectionConfig pictureSelectionConfig2 = picturePreviewActivity5.a;
            if (pictureSelectionConfig2.c0) {
                picturePreviewActivity5.O.setChecked(pictureSelectionConfig2.L0);
                PicturePreviewActivity picturePreviewActivity6 = PicturePreviewActivity.this;
                if (picturePreviewActivity6.a.d0) {
                    picturePreviewActivity6.U = s12.g(localMediaA.t(), 2);
                    PicturePreviewActivity picturePreviewActivity7 = PicturePreviewActivity.this;
                    picturePreviewActivity7.O.setText(picturePreviewActivity7.getString(R$string.picture_original_image, picturePreviewActivity7.U));
                } else {
                    picturePreviewActivity6.O.setText(picturePreviewActivity6.getString(R$string.picture_default_original_image));
                }
            }
            PicturePreviewActivity picturePreviewActivity8 = PicturePreviewActivity.this;
            if (picturePreviewActivity8.a.e0) {
                picturePreviewActivity8.w.setVisibility(a22.n(localMediaA.n()) ? 8 : 0);
            } else {
                picturePreviewActivity8.w.setVisibility(8);
            }
            PicturePreviewActivity.this.F0(localMediaA);
            PicturePreviewActivity picturePreviewActivity9 = PicturePreviewActivity.this;
            PictureSelectionConfig pictureSelectionConfig3 = picturePreviewActivity9.a;
            if (!pictureSelectionConfig3.c1 || picturePreviewActivity9.y || pictureSelectionConfig3.p1 || !picturePreviewActivity9.j) {
                return;
            }
            if (picturePreviewActivity9.x != picturePreviewActivity9.G.B() - 11) {
                PicturePreviewActivity picturePreviewActivity10 = PicturePreviewActivity.this;
                if (picturePreviewActivity10.x != picturePreviewActivity10.G.B() - 1) {
                    return;
                }
            }
            PicturePreviewActivity.this.z0();
        }
    }

    class c extends wv1 {
        c() {
        }

        @Override // defpackage.wv1
        public void c(List list, int i, boolean z) {
            i32 i32Var;
            if (PicturePreviewActivity.this.isFinishing()) {
                return;
            }
            PicturePreviewActivity.this.j = z;
            if (z) {
                if (list.size() <= 0 || (i32Var = PicturePreviewActivity.this.G) == null) {
                    PicturePreviewActivity.this.z0();
                } else {
                    i32Var.z().addAll(list);
                    PicturePreviewActivity.this.G.j();
                }
            }
        }
    }

    class d extends wv1 {
        d() {
        }

        @Override // defpackage.wv1
        public void c(List list, int i, boolean z) {
            i32 i32Var;
            if (PicturePreviewActivity.this.isFinishing()) {
                return;
            }
            PicturePreviewActivity.this.j = z;
            if (z) {
                if (list.size() <= 0 || (i32Var = PicturePreviewActivity.this.G) == null) {
                    PicturePreviewActivity.this.z0();
                } else {
                    i32Var.z().addAll(list);
                    PicturePreviewActivity.this.G.j();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(LocalMedia localMedia) {
        if (this.a.m0) {
            this.I.setText(Constants.STR_EMPTY);
            int size = this.F.size();
            for (int i = 0; i < size; i++) {
                LocalMedia localMedia2 = (LocalMedia) this.F.get(i);
                if (localMedia2.q().equals(localMedia.q()) || localMedia2.m() == localMedia.m()) {
                    localMedia.f0(localMedia2.o());
                    this.I.setText(db3.e(Integer.valueOf(localMedia.o())));
                }
            }
        }
    }

    private void K0(String str, LocalMedia localMedia) {
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (!pictureSelectionConfig.o0 || pictureSelectionConfig.L0 || !a22.m(str)) {
            onBackPressed();
            return;
        }
        this.R = false;
        PictureSelectionConfig pictureSelectionConfig2 = this.a;
        if (pictureSelectionConfig2.v != 1) {
            t73.c(this, (ArrayList) this.F);
        } else {
            pictureSelectionConfig2.Y0 = localMedia.q();
            t73.b(this, this.a.Y0, localMedia.n(), localMedia.u(), localMedia.l());
        }
    }

    private void L0() {
        this.T = 0;
        this.x = 0;
        M0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (!pictureSelectionConfig.c1 || this.y || pictureSelectionConfig.p1) {
            this.r.setText(getString(R$string.picture_preview_image_num, Integer.valueOf(this.x + 1), Integer.valueOf(this.G.B())));
        } else {
            this.r.setText(getString(R$string.picture_preview_image_num, Integer.valueOf(this.x + 1), Integer.valueOf(this.z)));
        }
    }

    private void N0() {
        int size = this.F.size();
        int i = 0;
        while (i < size) {
            LocalMedia localMedia = (LocalMedia) this.F.get(i);
            i++;
            localMedia.f0(i);
        }
    }

    private void O0() {
        Intent intent = new Intent();
        if (this.S) {
            intent.putExtra("isCompleteOrSelected", this.R);
            intent.putParcelableArrayListExtra("selectList", (ArrayList) this.F);
        }
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig.c0) {
            intent.putExtra("isOriginal", pictureSelectionConfig.L0);
        }
        setResult(0, intent);
    }

    private void s0(String str, LocalMedia localMedia) {
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (!pictureSelectionConfig.o0 || pictureSelectionConfig.L0) {
            onBackPressed();
            return;
        }
        this.R = false;
        boolean zM = a22.m(str);
        PictureSelectionConfig pictureSelectionConfig2 = this.a;
        if (pictureSelectionConfig2.v == 1 && zM) {
            pictureSelectionConfig2.Y0 = localMedia.q();
            t73.b(this, this.a.Y0, localMedia.n(), localMedia.u(), localMedia.l());
            return;
        }
        int size = this.F.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            LocalMedia localMedia2 = (LocalMedia) this.F.get(i2);
            if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.q()) && a22.m(localMedia2.n())) {
                i++;
            }
        }
        if (i > 0) {
            t73.c(this, (ArrayList) this.F);
        } else {
            this.R = true;
            onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(List list) {
        i32 i32Var = new i32(N(), this.a, this);
        this.G = i32Var;
        i32Var.w(list);
        this.u.setAdapter(this.G);
        this.u.setCurrentItem(this.x);
        M0();
        E0(this.x);
        LocalMedia localMediaA = this.G.A(this.x);
        if (localMediaA != null) {
            this.L = localMediaA.r();
            PictureSelectionConfig pictureSelectionConfig = this.a;
            if (pictureSelectionConfig.c0) {
                if (pictureSelectionConfig.d0) {
                    String strG = s12.g(localMediaA.t(), 2);
                    this.U = strG;
                    this.O.setText(getString(R$string.picture_original_image, strG));
                } else {
                    this.O.setText(getString(R$string.picture_default_original_image));
                }
            }
            if (this.a.m0) {
                this.f292q.setSelected(true);
                this.I.setText(db3.e(Integer.valueOf(localMediaA.o())));
                A0(localMediaA);
            }
            if (this.a.e0) {
                this.w.setVisibility(a22.n(localMediaA.n()) ? 8 : 0);
            } else {
                this.w.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(boolean z, int i, int i2) {
        if (!z || this.G.B() <= 0) {
            return;
        }
        if (i2 < this.M / 2) {
            LocalMedia localMediaA = this.G.A(i);
            if (localMediaA != null) {
                this.I.setSelected(w0(localMediaA));
                PictureSelectionConfig pictureSelectionConfig = this.a;
                if (pictureSelectionConfig.Y) {
                    J0(localMediaA);
                    return;
                } else {
                    if (pictureSelectionConfig.m0) {
                        this.I.setText(db3.e(Integer.valueOf(localMediaA.o())));
                        A0(localMediaA);
                        E0(i);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        int i3 = i + 1;
        LocalMedia localMediaA2 = this.G.A(i3);
        if (localMediaA2 != null) {
            this.I.setSelected(w0(localMediaA2));
            PictureSelectionConfig pictureSelectionConfig2 = this.a;
            if (pictureSelectionConfig2.Y) {
                J0(localMediaA2);
            } else if (pictureSelectionConfig2.m0) {
                this.I.setText(db3.e(Integer.valueOf(localMediaA2.o())));
                A0(localMediaA2);
                E0(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(CompoundButton compoundButton, boolean z) {
        this.a.L0 = z;
        if (this.F.size() == 0 && z) {
            B0();
        }
    }

    private void y0() {
        long longExtra = getIntent().getLongExtra("bucket_id", -1L);
        int i = this.T + 1;
        this.T = i;
        this.m.c(longExtra, i, this.a.b1, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        long longExtra = getIntent().getLongExtra("bucket_id", -1L);
        int i = this.T + 1;
        this.T = i;
        this.m.c(longExtra, i, this.a.b1, new d());
    }

    protected void B0() {
        int i;
        boolean z;
        if (this.G.B() > 0) {
            LocalMedia localMediaA = this.G.A(this.u.getCurrentItem());
            String strS = localMediaA.s();
            if (!TextUtils.isEmpty(strS) && !new File(strS).exists()) {
                p33.b(N(), a22.A(N(), localMediaA.n()));
                return;
            }
            String strN = this.F.size() > 0 ? ((LocalMedia) this.F.get(0)).n() : Constants.STR_EMPTY;
            int size = this.F.size();
            if (this.a.G0) {
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    if (a22.n(((LocalMedia) this.F.get(i3)).n())) {
                        i2++;
                    }
                }
                if (a22.n(localMediaA.n())) {
                    PictureSelectionConfig pictureSelectionConfig = this.a;
                    if (pictureSelectionConfig.y <= 0) {
                        showPromptDialog(getString(R$string.picture_rule));
                        return;
                    }
                    if (size >= pictureSelectionConfig.w && !this.I.isSelected()) {
                        showPromptDialog(getString(R$string.picture_message_max_num, Integer.valueOf(this.a.w)));
                        return;
                    }
                    if (i2 >= this.a.y && !this.I.isSelected()) {
                        showPromptDialog(sv2.b(N(), localMediaA.n(), this.a.y));
                        return;
                    }
                    if (!this.I.isSelected() && this.a.I > 0 && localMediaA.k() < this.a.I) {
                        showPromptDialog(N().getString(R$string.picture_choose_min_seconds, Integer.valueOf(this.a.I / 1000)));
                        return;
                    } else if (!this.I.isSelected() && this.a.H > 0 && localMediaA.k() > this.a.H) {
                        showPromptDialog(N().getString(R$string.picture_choose_max_seconds, Integer.valueOf(this.a.H / 1000)));
                        return;
                    }
                } else if (size >= this.a.w && !this.I.isSelected()) {
                    showPromptDialog(getString(R$string.picture_message_max_num, Integer.valueOf(this.a.w)));
                    return;
                }
            } else {
                if (!TextUtils.isEmpty(strN) && !a22.p(strN, localMediaA.n())) {
                    showPromptDialog(getString(R$string.picture_rule));
                    return;
                }
                if (!a22.n(strN) || (i = this.a.y) <= 0) {
                    if (size >= this.a.w && !this.I.isSelected()) {
                        showPromptDialog(sv2.b(N(), strN, this.a.w));
                        return;
                    }
                    if (a22.n(localMediaA.n())) {
                        if (!this.I.isSelected() && this.a.I > 0 && localMediaA.k() < this.a.I) {
                            showPromptDialog(N().getString(R$string.picture_choose_min_seconds, Integer.valueOf(this.a.I / 1000)));
                            return;
                        } else if (!this.I.isSelected() && this.a.H > 0 && localMediaA.k() > this.a.H) {
                            showPromptDialog(N().getString(R$string.picture_choose_max_seconds, Integer.valueOf(this.a.H / 1000)));
                            return;
                        }
                    }
                } else {
                    if (size >= i && !this.I.isSelected()) {
                        showPromptDialog(sv2.b(N(), strN, this.a.y));
                        return;
                    }
                    if (!this.I.isSelected() && this.a.I > 0 && localMediaA.k() < this.a.I) {
                        showPromptDialog(N().getString(R$string.picture_choose_min_seconds, Integer.valueOf(this.a.I / 1000)));
                        return;
                    } else if (!this.I.isSelected() && this.a.H > 0 && localMediaA.k() > this.a.H) {
                        showPromptDialog(N().getString(R$string.picture_choose_max_seconds, Integer.valueOf(this.a.H / 1000)));
                        return;
                    }
                }
            }
            if (this.I.isSelected()) {
                this.I.setSelected(false);
                z = false;
            } else {
                this.I.setSelected(true);
                this.I.startAnimation(this.H);
                z = true;
            }
            this.S = true;
            if (z) {
                jg3.a().d();
                if (this.a.v == 1) {
                    this.F.clear();
                }
                this.F.add(localMediaA);
                H0(true, localMediaA);
                localMediaA.f0(this.F.size());
                if (this.a.m0) {
                    this.I.setText(db3.e(Integer.valueOf(localMediaA.o())));
                }
            } else {
                int size2 = this.F.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    LocalMedia localMedia = (LocalMedia) this.F.get(i4);
                    if (localMedia.q().equals(localMediaA.q()) || localMedia.m() == localMediaA.m()) {
                        this.F.remove(localMedia);
                        H0(false, localMediaA);
                        N0();
                        A0(localMedia);
                        break;
                    }
                }
            }
            G0(true);
        }
    }

    protected void C0() {
        int i;
        int i2;
        int size = this.F.size();
        LocalMedia localMedia = this.F.size() > 0 ? (LocalMedia) this.F.get(0) : null;
        String strN = localMedia != null ? localMedia.n() : Constants.STR_EMPTY;
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig.G0) {
            int size2 = this.F.size();
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size2; i5++) {
                if (a22.n(((LocalMedia) this.F.get(i5)).n())) {
                    i4++;
                } else {
                    i3++;
                }
            }
            PictureSelectionConfig pictureSelectionConfig2 = this.a;
            if (pictureSelectionConfig2.v == 2) {
                int i6 = pictureSelectionConfig2.x;
                if (i6 > 0 && i3 < i6) {
                    showPromptDialog(getString(R$string.picture_min_img_num, Integer.valueOf(i6)));
                    return;
                }
                int i7 = pictureSelectionConfig2.z;
                if (i7 > 0 && i4 < i7) {
                    showPromptDialog(getString(R$string.picture_min_video_num, Integer.valueOf(i7)));
                    return;
                }
            }
        } else if (pictureSelectionConfig.v == 2) {
            if (a22.m(strN) && (i2 = this.a.x) > 0 && size < i2) {
                showPromptDialog(getString(R$string.picture_min_img_num, Integer.valueOf(i2)));
                return;
            } else if (a22.n(strN) && (i = this.a.z) > 0 && size < i) {
                showPromptDialog(getString(R$string.picture_min_video_num, Integer.valueOf(i)));
                return;
            }
        }
        this.R = true;
        this.S = true;
        if (this.a.a == a22.s() && this.a.G0) {
            s0(strN, localMedia);
        } else {
            K0(strN, localMedia);
        }
    }

    protected void D0() {
        if (this.G.B() > 0) {
            LocalMedia localMediaA = this.G.A(this.u.getCurrentItem());
            t73.d(this, localMediaA.q(), localMediaA.n(), localMediaA.u(), localMediaA.l());
        }
    }

    public void E0(int i) {
        if (this.G.B() <= 0) {
            this.I.setSelected(false);
            return;
        }
        LocalMedia localMediaA = this.G.A(i);
        if (localMediaA != null) {
            this.I.setSelected(w0(localMediaA));
        }
    }

    protected void F0(LocalMedia localMedia) {
    }

    protected void G0(boolean z) {
        this.K = z;
        if (this.F.size() == 0) {
            this.s.setEnabled(false);
            this.s.setSelected(false);
            PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
            if (this.c) {
                t0(0);
                return;
            } else {
                this.f292q.setVisibility(4);
                this.s.setText(getString(R$string.picture_please_select));
                return;
            }
        }
        this.s.setEnabled(true);
        this.s.setSelected(true);
        PictureCropParameterStyle pictureCropParameterStyle2 = PictureSelectionConfig.u1;
        if (this.c) {
            t0(this.F.size());
            return;
        }
        if (this.K) {
            this.f292q.startAnimation(this.H);
        }
        this.f292q.setVisibility(0);
        this.f292q.setText(db3.e(Integer.valueOf(this.F.size())));
        this.s.setText(getString(R$string.picture_completed));
    }

    protected void H0(boolean z, LocalMedia localMedia) {
    }

    protected void I0(LocalMedia localMedia) {
    }

    protected void J0(LocalMedia localMedia) {
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public int P() {
        return R$layout.picture_preview;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public void U() {
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        this.I.setBackground(cb.d(N(), R$attr.picture_checked_style, R$drawable.picture_checkbox_selector));
        ColorStateList colorStateListC = cb.c(N(), R$attr.picture_ac_preview_complete_textColor);
        if (colorStateListC != null) {
            this.s.setTextColor(colorStateListC);
        }
        this.o.setImageDrawable(cb.d(N(), R$attr.picture_preview_leftBack_icon, R$drawable.picture_icon_back));
        int iB = cb.b(N(), R$attr.picture_ac_preview_title_textColor);
        if (iB != 0) {
            this.r.setTextColor(iB);
        }
        this.f292q.setBackground(cb.d(N(), R$attr.picture_num_style, R$drawable.picture_num_oval));
        int iB2 = cb.b(N(), R$attr.picture_ac_preview_bottom_bg);
        if (iB2 != 0) {
            this.N.setBackgroundColor(iB2);
        }
        int iF = cb.f(N(), R$attr.picture_titleBar_height);
        if (iF > 0) {
            this.n.getLayoutParams().height = iF;
        }
        if (this.a.c0) {
            this.O.setButtonDrawable(cb.d(N(), R$attr.picture_original_check_style, R$drawable.picture_original_wechat_checkbox));
            int iB3 = cb.b(N(), R$attr.picture_original_text_color);
            if (iB3 != 0) {
                this.O.setTextColor(iB3);
            }
        }
        this.n.setBackgroundColor(this.d);
        G0(false);
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void V() {
        super.V();
        this.n = (ViewGroup) findViewById(R$id.titleBar);
        this.M = ll2.c(this);
        this.H = AnimationUtils.loadAnimation(this, R$anim.picture_anim_modal_in);
        this.o = (ImageView) findViewById(R$id.pictureLeftBack);
        this.p = (TextView) findViewById(R$id.picture_right);
        this.t = (ImageView) findViewById(R$id.ivArrow);
        this.u = (PreviewViewPager) findViewById(R$id.preview_pager);
        this.v = findViewById(R$id.picture_id_preview);
        this.w = (TextView) findViewById(R$id.picture_id_editor);
        this.J = findViewById(R$id.btnCheck);
        this.I = (TextView) findViewById(R$id.check);
        this.o.setOnClickListener(this);
        this.s = (TextView) findViewById(R$id.picture_tv_ok);
        this.O = (CheckBox) findViewById(R$id.cb_original);
        this.f292q = (TextView) findViewById(R$id.tv_media_num);
        this.N = (RelativeLayout) findViewById(R$id.select_bar_layout);
        this.s.setOnClickListener(this);
        this.f292q.setOnClickListener(this);
        this.r = (TextView) findViewById(R$id.picture_title);
        this.v.setVisibility(8);
        this.t.setVisibility(8);
        this.p.setVisibility(8);
        this.I.setVisibility(0);
        this.J.setVisibility(0);
        if (this.a.e0) {
            this.w.setVisibility(0);
            this.w.setOnClickListener(this);
        } else {
            this.w.setVisibility(8);
        }
        this.x = getIntent().getIntExtra("position", 0);
        if (this.c) {
            t0(0);
        }
        this.f292q.setSelected(this.a.m0);
        this.J.setOnClickListener(this);
        if (getIntent().getParcelableArrayListExtra("selectList") != null) {
            this.F = getIntent().getParcelableArrayListExtra("selectList");
        }
        this.y = getIntent().getBooleanExtra("bottom_preview", false);
        this.P = getIntent().getBooleanExtra("isShowCamera", this.a.f0);
        this.Q = getIntent().getStringExtra("currentDirectory");
        if (this.y) {
            u0(getIntent().getParcelableArrayListExtra("previewSelectList"));
        } else {
            ArrayList arrayList = new ArrayList(i11.c().b());
            i11.c().a();
            this.z = getIntent().getIntExtra("count", 0);
            PictureSelectionConfig pictureSelectionConfig = this.a;
            if (!pictureSelectionConfig.c1 || pictureSelectionConfig.p1) {
                u0(arrayList);
                if (arrayList.size() == 0) {
                    PictureSelectionConfig pictureSelectionConfig2 = this.a;
                    if (pictureSelectionConfig2.p1) {
                        this.m.b(new a(arrayList));
                    } else {
                        pictureSelectionConfig2.c1 = true;
                        this.m = new qc1(N(), this.a);
                        L0();
                        y0();
                    }
                }
            } else if (arrayList.size() == 0) {
                L0();
                u0(arrayList);
                y0();
            } else {
                this.T = getIntent().getIntExtra("page", 0);
                u0(arrayList);
            }
        }
        this.u.c(new b());
        if (this.a.c0) {
            boolean booleanExtra = getIntent().getBooleanExtra("isOriginal", this.a.L0);
            this.O.setVisibility(0);
            this.a.L0 = booleanExtra;
            this.O.setChecked(booleanExtra);
            this.O.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: d22
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.a.x0(compoundButton, z);
                }
            });
        }
    }

    @Override // i32.a
    public void d() {
        onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Throwable th;
        LocalMedia localMedia;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            if (i2 != 96 || (th = (Throwable) intent.getSerializableExtra("com.yalantis.ucrop.Error")) == null) {
                return;
            }
            p33.b(N(), th.getMessage());
            return;
        }
        if (i != 69) {
            if (i != 609) {
                return;
            }
            intent.putParcelableArrayListExtra("com.yalantis.ucrop.OutputUriList", com.yalantis.ucrop.b.c(intent));
            intent.putParcelableArrayListExtra("selectList", (ArrayList) this.F);
            setResult(-1, intent);
            finish();
            return;
        }
        if (intent != null) {
            if (!intent.getBooleanExtra("com.yalantis.ucrop.EditorImage", false)) {
                intent.putParcelableArrayListExtra("selectList", (ArrayList) this.F);
                setResult(-1, intent);
                finish();
                return;
            }
            Uri uriD = com.yalantis.ucrop.b.d(intent);
            if (uriD == null || this.G == null) {
                return;
            }
            String path = uriD.getPath();
            LocalMedia localMediaA = this.G.A(this.u.getCurrentItem());
            int i3 = 0;
            while (true) {
                if (i3 >= this.F.size()) {
                    localMedia = null;
                    z = false;
                    break;
                }
                localMedia = (LocalMedia) this.F.get(i3);
                if (TextUtils.equals(localMediaA.q(), localMedia.q()) || localMediaA.m() == localMedia.m()) {
                    z = true;
                    break;
                }
                i3++;
            }
            localMediaA.S(!TextUtils.isEmpty(path));
            localMediaA.T(path);
            localMediaA.P(intent.getIntExtra("com.yalantis.ucrop.OffsetX", 0));
            localMediaA.Q(intent.getIntExtra("com.yalantis.ucrop.OffsetY", 0));
            localMediaA.R(intent.getFloatExtra("com.yalantis.ucrop.CropAspectRatio", 0.0f));
            localMediaA.O(intent.getIntExtra("com.yalantis.ucrop.ImageWidth", 0));
            localMediaA.N(intent.getIntExtra("com.yalantis.ucrop.ImageHeight", 0));
            localMediaA.X(localMediaA.z());
            if (ol2.a() && a22.h(localMediaA.q())) {
                localMediaA.H(path);
            }
            if (z) {
                localMedia.S(!TextUtils.isEmpty(path));
                localMedia.T(path);
                localMedia.P(intent.getIntExtra("com.yalantis.ucrop.OffsetX", 0));
                localMedia.Q(intent.getIntExtra("com.yalantis.ucrop.OffsetY", 0));
                localMedia.R(intent.getFloatExtra("com.yalantis.ucrop.CropAspectRatio", 0.0f));
                localMedia.O(intent.getIntExtra("com.yalantis.ucrop.ImageWidth", 0));
                localMedia.N(intent.getIntExtra("com.yalantis.ucrop.ImageHeight", 0));
                localMedia.X(localMediaA.z());
                if (ol2.a() && a22.h(localMediaA.q())) {
                    localMedia.H(path);
                }
                this.S = true;
                I0(localMedia);
            } else {
                B0();
            }
            this.G.j();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        O0();
        finish();
        overridePendingTransition(0, PictureSelectionConfig.v1.d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.pictureLeftBack) {
            onBackPressed();
            return;
        }
        if (id == R$id.picture_tv_ok || id == R$id.tv_media_num) {
            C0();
        } else if (id == R$id.btnCheck) {
            B0();
        } else if (id == R$id.picture_id_editor) {
            D0();
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            List listF = v22.f(bundle);
            if (listF == null) {
                listF = this.F;
            }
            this.F = listF;
            this.R = bundle.getBoolean("isCompleteOrSelected", false);
            this.S = bundle.getBoolean("isChangeSelectedData", false);
            E0(this.x);
            G0(false);
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Animation animation = this.H;
        if (animation != null) {
            animation.cancel();
        }
        i32 i32Var = this.G;
        if (i32Var != null) {
            i32Var.x();
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("isCompleteOrSelected", this.R);
        bundle.putBoolean("isChangeSelectedData", this.S);
        v22.i(bundle, this.F);
        if (this.G != null) {
            i11.c().d(this.G.z());
        }
    }

    protected void t0(int i) {
        if (this.a.v == 1) {
            if (i <= 0) {
                PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
                return;
            } else {
                PictureCropParameterStyle pictureCropParameterStyle2 = PictureSelectionConfig.u1;
                return;
            }
        }
        if (i <= 0) {
            PictureCropParameterStyle pictureCropParameterStyle3 = PictureSelectionConfig.u1;
        } else {
            PictureCropParameterStyle pictureCropParameterStyle4 = PictureSelectionConfig.u1;
        }
    }

    protected boolean w0(LocalMedia localMedia) {
        int size = this.F.size();
        for (int i = 0; i < size; i++) {
            LocalMedia localMedia2 = (LocalMedia) this.F.get(i);
            if (localMedia2.q().equals(localMedia.q()) || localMedia2.m() == localMedia.m()) {
                return true;
            }
        }
        return false;
    }
}
