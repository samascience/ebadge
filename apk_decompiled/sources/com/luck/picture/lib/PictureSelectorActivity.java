package com.luck.picture.lib;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blankj.utilcode.util.PermissionUtils;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.dialog.PhotoItemSelectedDialog;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.luck.picture.lib.widget.RecyclerPreloadView;
import com.tencent.connect.common.Constants;
import defpackage.a22;
import defpackage.b81;
import defpackage.bw1;
import defpackage.cb;
import defpackage.d12;
import defpackage.db3;
import defpackage.ew1;
import defpackage.g02;
import defpackage.g5;
import defpackage.gi1;
import defpackage.go0;
import defpackage.gv1;
import defpackage.i11;
import defpackage.js2;
import defpackage.ll2;
import defpackage.lu1;
import defpackage.m5;
import defpackage.mv0;
import defpackage.ol2;
import defpackage.p33;
import defpackage.q30;
import defpackage.qh1;
import defpackage.qr2;
import defpackage.s12;
import defpackage.si;
import defpackage.sv1;
import defpackage.sv2;
import defpackage.t73;
import defpackage.v22;
import defpackage.vt;
import defpackage.w12;
import defpackage.wc0;
import defpackage.wv1;
import defpackage.wz1;
import defpackage.y02;
import defpackage.y60;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PictureSelectorActivity extends PictureBaseActivity implements View.OnClickListener, lu1, sv1, gv1, bw1 {
    protected TextView F;
    protected TextView G;
    protected TextView H;
    protected RecyclerPreloadView I;
    protected RelativeLayout J;
    protected w12 K;
    protected go0 L;
    protected MediaPlayer O;
    protected SeekBar P;
    protected d12 R;
    protected CheckBox S;
    protected int T;
    protected boolean U;
    private int W;
    private int X;
    protected ImageView n;
    protected ImageView o;
    protected View p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected View f293q;
    protected TextView r;
    protected TextView s;
    protected TextView t;
    protected TextView u;
    protected TextView v;
    protected TextView w;
    protected TextView x;
    protected TextView y;
    protected TextView z;
    protected Animation M = null;
    protected boolean N = false;
    protected boolean Q = false;
    private long V = 0;
    public Runnable Y = new k();

    class a extends wv1 {
        a() {
        }

        @Override // defpackage.wv1
        public void c(List list, int i, boolean z) {
            PictureSelectorActivity pictureSelectorActivity = PictureSelectorActivity.this;
            pictureSelectorActivity.j = z;
            if (pictureSelectorActivity.isFinishing()) {
                return;
            }
            if (list.size() == 0) {
                PictureSelectorActivity.this.K.clear();
            }
            PictureSelectorActivity.this.K.h(list);
            PictureSelectorActivity.this.I.onScrolled(0, 0);
            PictureSelectorActivity.this.I.smoothScrollToPosition(0);
            PictureSelectorActivity.this.K();
        }
    }

    class b implements PermissionUtils.b {
        b() {
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onDenied() {
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
            PictureSelectorActivity.this.p1();
        }
    }

    class c extends wv1 {
        final /* synthetic */ long a;

        c(long j) {
            this.a = j;
        }

        @Override // defpackage.wv1
        public void c(List list, int i, boolean z) {
            if (PictureSelectorActivity.this.isFinishing()) {
                return;
            }
            PictureSelectorActivity pictureSelectorActivity = PictureSelectorActivity.this;
            pictureSelectorActivity.j = z;
            if (!z) {
                if (pictureSelectorActivity.K.q()) {
                    PictureSelectorActivity pictureSelectorActivity2 = PictureSelectorActivity.this;
                    pictureSelectorActivity2.k1(pictureSelectorActivity2.getString(this.a == -1 ? R$string.picture_empty : R$string.picture_data_null), R$drawable.picture_icon_no_data);
                    return;
                }
                return;
            }
            pictureSelectorActivity.G0();
            int size = list.size();
            if (size > 0) {
                int iP = PictureSelectorActivity.this.K.p();
                PictureSelectorActivity.this.K.l().addAll(list);
                PictureSelectorActivity.this.K.notifyItemRangeChanged(iP, PictureSelectorActivity.this.K.getItemCount());
            } else {
                PictureSelectorActivity.this.j();
            }
            if (size < 10) {
                RecyclerPreloadView recyclerPreloadView = PictureSelectorActivity.this.I;
                recyclerPreloadView.onScrolled(recyclerPreloadView.getScrollX(), PictureSelectorActivity.this.I.getScrollY());
            }
        }
    }

    class d extends wv1 {
        d() {
        }

        @Override // defpackage.wv1
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(LocalMediaFolder localMediaFolder) {
            ArrayList arrayList = new ArrayList();
            if (localMediaFolder != null) {
                arrayList.add(localMediaFolder);
                PictureSelectorActivity.this.j1(localMediaFolder.h());
            } else {
                PictureSelectorActivity.this.j1(null);
            }
            PictureSelectorActivity.this.H0(arrayList);
        }
    }

    class e extends wv1 {
        e() {
        }

        @Override // defpackage.wv1
        public void b(List list) {
            if (PictureSelectorActivity.this.isFinishing()) {
                return;
            }
            PictureSelectorActivity pictureSelectorActivity = PictureSelectorActivity.this;
            pictureSelectorActivity.j = true;
            pictureSelectorActivity.J0(list);
        }
    }

    class f extends wv1 {
        f() {
        }

        @Override // defpackage.wv1
        public void b(List list) {
            PictureSelectorActivity.this.H0(list);
        }
    }

    class g extends wv1 {
        final /* synthetic */ LocalMediaFolder a;

        g(LocalMediaFolder localMediaFolder) {
            this.a = localMediaFolder;
        }

        @Override // defpackage.wv1
        public void c(List list, int i, boolean z) {
            LocalMediaFolder localMediaFolder;
            if (PictureSelectorActivity.this.isFinishing()) {
                return;
            }
            PictureSelectorActivity.this.K();
            PictureSelectorActivity pictureSelectorActivity = PictureSelectorActivity.this;
            if (pictureSelectorActivity.K != null) {
                pictureSelectorActivity.j = true;
                if (z && list.size() == 0) {
                    PictureSelectorActivity.this.j();
                    return;
                }
                int iP = PictureSelectorActivity.this.K.p();
                int size = list.size();
                PictureSelectorActivity pictureSelectorActivity2 = PictureSelectorActivity.this;
                int i2 = pictureSelectorActivity2.T + iP;
                pictureSelectorActivity2.T = i2;
                if (size >= iP) {
                    if (iP <= 0 || iP >= size || i2 == size || pictureSelectorActivity2.N0((LocalMedia) list.get(0))) {
                        if (i == 1 && (localMediaFolder = this.a) != null) {
                            list.addAll(0, localMediaFolder.d());
                            js2.f(list);
                        }
                        PictureSelectorActivity.this.K.h(list);
                    } else {
                        PictureSelectorActivity.this.K.l().addAll(list);
                    }
                }
                if (!PictureSelectorActivity.this.K.q()) {
                    PictureSelectorActivity.this.G0();
                } else {
                    PictureSelectorActivity pictureSelectorActivity3 = PictureSelectorActivity.this;
                    pictureSelectorActivity3.k1(pictureSelectorActivity3.getString(R$string.picture_empty), R$drawable.picture_icon_no_data);
                }
            }
        }
    }

    class h implements Runnable {
        final /* synthetic */ String a;

        h(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            PictureSelectorActivity.this.K0(this.a);
        }
    }

    class i implements SeekBar.OnSeekBarChangeListener {
        i() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                PictureSelectorActivity.this.O.seekTo(i);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    class j implements Runnable {
        final /* synthetic */ String a;

        j(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            PictureSelectorActivity.this.s1(this.a);
        }
    }

    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                PictureSelectorActivity pictureSelectorActivity = PictureSelectorActivity.this;
                MediaPlayer mediaPlayer = pictureSelectorActivity.O;
                if (mediaPlayer != null) {
                    pictureSelectorActivity.H.setText(y60.b(mediaPlayer.getCurrentPosition()));
                    PictureSelectorActivity pictureSelectorActivity2 = PictureSelectorActivity.this;
                    pictureSelectorActivity2.P.setProgress(pictureSelectorActivity2.O.getCurrentPosition());
                    PictureSelectorActivity pictureSelectorActivity3 = PictureSelectorActivity.this;
                    pictureSelectorActivity3.P.setMax(pictureSelectorActivity3.O.getDuration());
                    PictureSelectorActivity pictureSelectorActivity4 = PictureSelectorActivity.this;
                    pictureSelectorActivity4.G.setText(y60.b(pictureSelectorActivity4.O.getDuration()));
                    PictureSelectorActivity pictureSelectorActivity5 = PictureSelectorActivity.this;
                    pictureSelectorActivity5.h.postDelayed(pictureSelectorActivity5.Y, 200L);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class l implements View.OnClickListener {
        private String a;

        public l(String str) {
            this.a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            PictureSelectorActivity.this.s1(this.a);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R$id.tv_PlayPause) {
                PictureSelectorActivity.this.d1();
            }
            if (id == R$id.tv_Stop) {
                PictureSelectorActivity pictureSelectorActivity = PictureSelectorActivity.this;
                pictureSelectorActivity.F.setText(pictureSelectorActivity.getString(R$string.picture_stop_audio));
                PictureSelectorActivity pictureSelectorActivity2 = PictureSelectorActivity.this;
                pictureSelectorActivity2.x.setText(pictureSelectorActivity2.getString(R$string.picture_play_audio));
                PictureSelectorActivity.this.s1(this.a);
            }
            if (id == R$id.tv_Quit) {
                PictureSelectorActivity.this.h.postDelayed(new Runnable() { // from class: a32
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                }, 30L);
                try {
                    d12 d12Var = PictureSelectorActivity.this.R;
                    if (d12Var != null && d12Var.isShowing()) {
                        PictureSelectorActivity.this.R.dismiss();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                PictureSelectorActivity pictureSelectorActivity3 = PictureSelectorActivity.this;
                pictureSelectorActivity3.h.removeCallbacks(pictureSelectorActivity3.Y);
            }
        }
    }

    private boolean B0(LocalMedia localMedia) {
        if (a22.n(localMedia.n())) {
            PictureSelectionConfig pictureSelectionConfig = this.a;
            int i2 = pictureSelectionConfig.I;
            if (i2 <= 0 || pictureSelectionConfig.H <= 0) {
                if (i2 > 0) {
                    long jK = localMedia.k();
                    int i3 = this.a.I;
                    if (jK < i3) {
                        showPromptDialog(getString(R$string.picture_choose_min_seconds, Integer.valueOf(i3 / 1000)));
                        return false;
                    }
                } else if (pictureSelectionConfig.H > 0) {
                    long jK2 = localMedia.k();
                    int i4 = this.a.H;
                    if (jK2 > i4) {
                        showPromptDialog(getString(R$string.picture_choose_max_seconds, Integer.valueOf(i4 / 1000)));
                        return false;
                    }
                }
            } else if (localMedia.k() < this.a.I || localMedia.k() > this.a.H) {
                showPromptDialog(getString(R$string.picture_choose_limit_seconds, Integer.valueOf(this.a.I / 1000), Integer.valueOf(this.a.H / 1000)));
                return false;
            }
        }
        return true;
    }

    private void C0(Intent intent) throws Throwable {
        PictureSelectionConfig pictureSelectionConfig;
        String strB;
        int iF;
        if (intent != null) {
            try {
                pictureSelectionConfig = (PictureSelectionConfig) intent.getParcelableExtra("PictureSelectorConfig");
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        } else {
            pictureSelectionConfig = null;
        }
        if (pictureSelectionConfig != null) {
            this.a = pictureSelectionConfig;
        }
        if (this.a.a == a22.t()) {
            this.a.a1 = a22.t();
            this.a.Z0 = M(intent);
            if (TextUtils.isEmpty(this.a.Z0)) {
                return;
            }
            if (ol2.b()) {
                try {
                    Uri uriC = vt.c(N(), TextUtils.isEmpty(this.a.k) ? this.a.e : this.a.k);
                    if (uriC != null) {
                        s12.v(y02.a(this, Uri.parse(this.a.Z0)), y02.b(this, uriC));
                        this.a.Z0 = uriC.toString();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        if (TextUtils.isEmpty(this.a.Z0)) {
            return;
        }
        LocalMedia localMedia = new LocalMedia();
        if (a22.h(this.a.Z0)) {
            String strL = s12.l(N(), Uri.parse(this.a.Z0));
            File file = new File(strL);
            strB = a22.b(strL, this.a.a1);
            localMedia.q0(file.length());
            localMedia.Y(file.getName());
            if (a22.m(strB)) {
                qh1 qh1VarG = gi1.g(N(), this.a.Z0);
                localMedia.r0(qh1VarG.c());
                localMedia.Z(qh1VarG.b());
            } else if (a22.n(strB)) {
                qh1 qh1VarH = gi1.h(N(), this.a.Z0);
                localMedia.r0(qh1VarH.c());
                localMedia.Z(qh1VarH.b());
                localMedia.W(qh1VarH.a());
            } else if (a22.k(strB)) {
                localMedia.W(gi1.d(N(), this.a.Z0).a());
            }
            int iLastIndexOf = this.a.Z0.lastIndexOf(WatchConstant.FAT_FS_ROOT) + 1;
            localMedia.b0(iLastIndexOf > 0 ? db3.c(this.a.Z0.substring(iLastIndexOf)) : -1L);
            localMedia.p0(strL);
            String stringExtra = intent != null ? intent.getStringExtra("mediaPath") : null;
            localMedia.H(a22.h(stringExtra) ? null : stringExtra);
            localMedia.I(g5.a(N(), file, Constants.STR_EMPTY));
            localMedia.U(file.lastModified() / 1000);
        } else {
            File file2 = new File(this.a.Z0);
            PictureSelectionConfig pictureSelectionConfig2 = this.a;
            strB = a22.b(pictureSelectionConfig2.Z0, pictureSelectionConfig2.a1);
            localMedia.q0(file2.length());
            localMedia.Y(file2.getName());
            if (a22.m(strB)) {
                Context contextN = N();
                PictureSelectionConfig pictureSelectionConfig3 = this.a;
                si.d(contextN, pictureSelectionConfig3.j1, pictureSelectionConfig3.Z0);
                qh1 qh1VarG2 = gi1.g(N(), this.a.Z0);
                localMedia.r0(qh1VarG2.c());
                localMedia.Z(qh1VarG2.b());
            } else if (a22.n(strB)) {
                qh1 qh1VarH2 = gi1.h(N(), this.a.Z0);
                localMedia.r0(qh1VarH2.c());
                localMedia.Z(qh1VarH2.b());
                localMedia.W(qh1VarH2.a());
            } else if (a22.k(strB)) {
                localMedia.W(gi1.d(N(), this.a.Z0).a());
            }
            localMedia.b0(System.currentTimeMillis());
            localMedia.p0(this.a.Z0);
            String stringExtra2 = intent != null ? intent.getStringExtra("mediaPath") : null;
            if (ol2.a()) {
                if (TextUtils.isEmpty(stringExtra2) || a22.h(stringExtra2)) {
                    localMedia.H(this.a.Z0);
                } else {
                    localMedia.H(stringExtra2);
                }
            }
            localMedia.I(g5.a(N(), file2, this.a.W0));
            localMedia.U(file2.lastModified() / 1000);
        }
        localMedia.n0(this.a.Z0);
        localMedia.d0(strB);
        PictureSelectionConfig pictureSelectionConfig4 = this.a;
        localMedia.l0(g5.b(pictureSelectionConfig4.Z0, strB, pictureSelectionConfig4.W0));
        localMedia.K(this.a.a);
        Y0(localMedia);
        if (ol2.a()) {
            if (a22.n(localMedia.n()) && a22.h(this.a.Z0)) {
                if (this.a.t1) {
                    new com.luck.picture.lib.a(N(), localMedia.s());
                    return;
                } else {
                    sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(localMedia.s()))));
                    return;
                }
            }
            return;
        }
        if (this.a.t1) {
            new com.luck.picture.lib.a(N(), this.a.Z0);
        } else {
            sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(this.a.Z0))));
        }
        if (!a22.m(localMedia.n()) || (iF = gi1.f(N())) == -1) {
            return;
        }
        gi1.k(N(), iF);
    }

    private void D0(LocalMedia localMedia) {
        int i2;
        List listN = this.K.n();
        int size = listN.size();
        String strN = size > 0 ? ((LocalMedia) listN.get(0)).n() : Constants.STR_EMPTY;
        boolean zP = a22.p(strN, localMedia.n());
        if (!this.a.G0) {
            if (!a22.n(strN) || (i2 = this.a.y) <= 0) {
                if (size >= this.a.w) {
                    showPromptDialog(sv2.b(N(), strN, this.a.w));
                    return;
                } else {
                    if (zP || size == 0) {
                        listN.add(localMedia);
                        this.K.i(listN);
                        return;
                    }
                    return;
                }
            }
            if (size >= i2) {
                showPromptDialog(sv2.b(N(), strN, this.a.y));
                return;
            } else {
                if ((zP || size == 0) && listN.size() < this.a.y) {
                    listN.add(localMedia);
                    this.K.i(listN);
                    return;
                }
                return;
            }
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            if (a22.n(((LocalMedia) listN.get(i4)).n())) {
                i3++;
            }
        }
        if (!a22.n(localMedia.n())) {
            if (listN.size() >= this.a.w) {
                showPromptDialog(sv2.b(N(), localMedia.n(), this.a.w));
                return;
            } else {
                listN.add(localMedia);
                this.K.i(listN);
                return;
            }
        }
        int i5 = this.a.y;
        if (i5 <= 0) {
            showPromptDialog(getString(R$string.picture_rule));
        } else if (i3 >= i5) {
            showPromptDialog(getString(R$string.picture_message_max_num, Integer.valueOf(i5)));
        } else {
            listN.add(localMedia);
            this.K.i(listN);
        }
    }

    private void E0(LocalMedia localMedia) {
        List listN = this.K.n();
        if (this.a.c) {
            listN.add(localMedia);
            this.K.i(listN);
            n1(localMedia);
        } else {
            if (a22.p(listN.size() > 0 ? ((LocalMedia) listN.get(0)).n() : Constants.STR_EMPTY, localMedia.n()) || listN.size() == 0) {
                o1();
                listN.add(localMedia);
                this.K.i(listN);
            }
        }
    }

    private int F0() {
        if (db3.a(this.r.getTag(R$id.view_tag)) != -1) {
            return this.a.b1;
        }
        int i2 = this.X;
        int i3 = i2 > 0 ? this.a.b1 - i2 : this.a.b1;
        this.X = 0;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        if (this.u.getVisibility() == 0) {
            this.u.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(List list) {
        if (list == null) {
            k1(getString(R$string.picture_data_exception), R$drawable.picture_icon_data_error);
        } else if (list.size() > 0) {
            this.L.c(list);
            LocalMediaFolder localMediaFolder = (LocalMediaFolder) list.get(0);
            localMediaFolder.o(true);
            this.r.setTag(R$id.view_count_tag, Integer.valueOf(localMediaFolder.g()));
            List listD = localMediaFolder.d();
            w12 w12Var = this.K;
            if (w12Var != null) {
                int iP = w12Var.p();
                int size = listD.size();
                int i2 = this.T + iP;
                this.T = i2;
                if (size >= iP) {
                    if (iP <= 0 || iP >= size || i2 == size) {
                        this.K.h(listD);
                    } else {
                        this.K.l().addAll(listD);
                        LocalMedia localMedia = (LocalMedia) this.K.l().get(0);
                        localMediaFolder.s(localMedia.q());
                        localMediaFolder.d().add(0, localMedia);
                        localMediaFolder.p(1);
                        localMediaFolder.v(localMediaFolder.g() + 1);
                        t1(this.L.e(), localMedia);
                    }
                }
                if (this.K.q()) {
                    k1(getString(R$string.picture_empty), R$drawable.picture_icon_no_data);
                } else {
                    G0();
                }
            }
        } else {
            k1(getString(R$string.picture_empty), R$drawable.picture_icon_no_data);
        }
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(List list) {
        this.L.c(list);
        this.k = 1;
        LocalMediaFolder localMediaFolderD = this.L.d(0);
        this.r.setTag(R$id.view_count_tag, Integer.valueOf(localMediaFolderD != null ? localMediaFolderD.g() : 0));
        this.r.setTag(R$id.view_index_tag, 0);
        long jA = localMediaFolderD != null ? localMediaFolderD.a() : -1L;
        this.I.setEnabledLoadMore(true);
        this.m.d(jA, this.k, new g(localMediaFolderD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(String str) {
        this.O = new MediaPlayer();
        try {
            if (a22.h(str)) {
                this.O.setDataSource(N(), Uri.parse(str));
            } else {
                this.O.setDataSource(str);
            }
            this.O.prepare();
            this.O.setLooping(true);
            d1();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean L0(int i2) {
        int i3;
        return i2 != 0 && (i3 = this.W) > 0 && i3 < i2;
    }

    private boolean M0(int i2) {
        this.r.setTag(R$id.view_index_tag, Integer.valueOf(i2));
        LocalMediaFolder localMediaFolderD = this.L.d(i2);
        if (localMediaFolderD == null || localMediaFolderD.d() == null || localMediaFolderD.d().size() <= 0) {
            return false;
        }
        this.K.h(localMediaFolderD.d());
        this.k = localMediaFolderD.c();
        this.j = localMediaFolderD.l();
        this.I.smoothScrollToPosition(0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N0(LocalMedia localMedia) {
        LocalMedia localMediaM = this.K.m(0);
        if (localMediaM != null && localMedia != null) {
            if (localMediaM.q().equals(localMedia.q())) {
                return true;
            }
            if (a22.h(localMedia.q()) && a22.h(localMediaM.q()) && !TextUtils.isEmpty(localMedia.q()) && !TextUtils.isEmpty(localMediaM.q())) {
                return localMedia.q().substring(localMedia.q().lastIndexOf(WatchConstant.FAT_FS_ROOT) + 1).equals(localMediaM.q().substring(localMediaM.q().lastIndexOf(WatchConstant.FAT_FS_ROOT) + 1));
            }
        }
        return false;
    }

    private void O0(boolean z) {
        if (z) {
            I0(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(CompoundButton compoundButton, boolean z) {
        this.a.L0 = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(d12 d12Var, boolean z, View view) {
        if (!isFinishing()) {
            d12Var.dismiss();
        }
        if (z) {
            return;
        }
        ew1 ew1Var = PictureSelectionConfig.x1;
        if (ew1Var != null) {
            ew1Var.onCancel();
        }
        L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(d12 d12Var, View view) {
        if (!isFinishing()) {
            d12Var.dismiss();
        }
        wz1.c(N());
        this.U = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(String str, DialogInterface dialogInterface) {
        this.h.removeCallbacks(this.Y);
        this.h.postDelayed(new j(str), 30L);
        try {
            d12 d12Var = this.R;
            if (d12Var == null || !d12Var.isShowing()) {
                return;
            }
            this.R.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void T0() {
        if (Build.VERSION.SDK_INT >= 33) {
            if (wz1.a(this, "android.permission.READ_MEDIA_IMAGES")) {
                g1();
                return;
            } else {
                wz1.d(this, new String[]{"android.permission.READ_MEDIA_IMAGES"}, 1);
                return;
            }
        }
        if (wz1.a(this, "android.permission.READ_EXTERNAL_STORAGE")) {
            g1();
        } else {
            wz1.d(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
        }
    }

    private void U0() {
        if (this.K == null || !this.j) {
            return;
        }
        this.k++;
        long jC = db3.c(this.r.getTag(R$id.view_tag));
        this.m.c(jC, this.k, F0(), new c(jC));
    }

    private void V0(LocalMedia localMedia) {
        LocalMediaFolder localMediaFolder;
        try {
            boolean zG = this.L.g();
            int iG = this.L.d(0) != null ? this.L.d(0).g() : 0;
            if (zG) {
                J(this.L.e());
                localMediaFolder = this.L.e().size() > 0 ? (LocalMediaFolder) this.L.e().get(0) : null;
                if (localMediaFolder == null) {
                    localMediaFolder = new LocalMediaFolder();
                    this.L.e().add(0, localMediaFolder);
                }
            } else {
                localMediaFolder = (LocalMediaFolder) this.L.e().get(0);
            }
            localMediaFolder.s(localMedia.q());
            localMediaFolder.t(localMedia.n());
            localMediaFolder.r(this.K.l());
            localMediaFolder.m(-1L);
            localMediaFolder.v(L0(iG) ? localMediaFolder.g() : localMediaFolder.g() + 1);
            LocalMediaFolder localMediaFolderO = O(localMedia.q(), localMedia.s(), localMedia.n(), this.L.e());
            if (localMediaFolderO != null) {
                localMediaFolderO.v(L0(iG) ? localMediaFolderO.g() : localMediaFolderO.g() + 1);
                if (!L0(iG)) {
                    localMediaFolderO.d().add(0, localMedia);
                }
                localMediaFolderO.m(localMedia.b());
                localMediaFolderO.s(this.a.Z0);
                localMediaFolderO.t(localMedia.n());
            }
            go0 go0Var = this.L;
            go0Var.c(go0Var.e());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void W0(LocalMedia localMedia) {
        if (localMedia == null) {
            return;
        }
        int size = this.L.e().size();
        LocalMediaFolder localMediaFolder = size > 0 ? (LocalMediaFolder) this.L.e().get(0) : new LocalMediaFolder();
        int iG = localMediaFolder.g();
        localMediaFolder.s(localMedia.q());
        localMediaFolder.t(localMedia.n());
        localMediaFolder.v(L0(iG) ? localMediaFolder.g() : localMediaFolder.g() + 1);
        if (size == 0) {
            localMediaFolder.x(getString(this.a.a == a22.t() ? R$string.picture_all_audio : R$string.picture_camera_roll));
            localMediaFolder.z(this.a.a);
            localMediaFolder.n(true);
            localMediaFolder.o(true);
            localMediaFolder.m(-1L);
            this.L.e().add(0, localMediaFolder);
            LocalMediaFolder localMediaFolder2 = new LocalMediaFolder();
            localMediaFolder2.x(localMedia.p());
            localMediaFolder2.v(L0(iG) ? localMediaFolder2.g() : localMediaFolder2.g() + 1);
            localMediaFolder2.s(localMedia.q());
            localMediaFolder2.t(localMedia.n());
            localMediaFolder2.m(localMedia.b());
            this.L.e().add(this.L.e().size(), localMediaFolder2);
        } else {
            String strB = g5.b(localMedia.q(), localMedia.n(), this.a.W0);
            for (int i2 = 0; i2 < size; i2++) {
                LocalMediaFolder localMediaFolder3 = (LocalMediaFolder) this.L.e().get(i2);
                if (!TextUtils.isEmpty(localMediaFolder3.h()) && localMediaFolder3.h().startsWith(strB)) {
                    localMedia.I(localMediaFolder3.a());
                    localMediaFolder3.s(this.a.Z0);
                    localMediaFolder3.t(localMedia.n());
                    localMediaFolder3.v(L0(iG) ? localMediaFolder3.g() : localMediaFolder3.g() + 1);
                    if (localMediaFolder3.d() != null && localMediaFolder3.d().size() > 0) {
                        localMediaFolder3.d().add(0, localMedia);
                    }
                }
            }
            LocalMediaFolder localMediaFolder4 = new LocalMediaFolder();
            localMediaFolder4.x(localMedia.p());
            localMediaFolder4.v(L0(iG) ? localMediaFolder4.g() : localMediaFolder4.g() + 1);
            localMediaFolder4.s(localMedia.q());
            localMediaFolder4.t(localMedia.n());
            localMediaFolder4.m(localMedia.b());
            this.L.e().add(localMediaFolder4);
            g0(this.L.e());
        }
        go0 go0Var = this.L;
        go0Var.c(go0Var.e());
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void Y0(LocalMedia localMedia) {
        if (this.K != null) {
            if (!L0(this.L.d(0) != null ? this.L.d(0).g() : 0)) {
                this.K.l().add(0, localMedia);
                this.X++;
            }
            if (B0(localMedia)) {
                if (this.a.v == 1) {
                    E0(localMedia);
                } else {
                    D0(localMedia);
                }
            }
            this.K.notifyItemInserted(this.a.f0 ? 1 : 0);
            w12 w12Var = this.K;
            w12Var.notifyItemRangeChanged(this.a.f0 ? 1 : 0, w12Var.p());
            PictureSelectionConfig pictureSelectionConfig = this.a;
            if (pictureSelectionConfig.p1) {
                j1(localMedia.p());
            } else if (pictureSelectionConfig.c1) {
                W0(localMedia);
            } else {
                V0(localMedia);
            }
            this.u.setVisibility((this.K.p() > 0 || this.a.c) ? 8 : 0);
            if (this.L.d(0) != null) {
                this.r.setTag(R$id.view_count_tag, Integer.valueOf(this.L.d(0).g()));
            }
            this.W = 0;
        }
    }

    private void a1() {
        int i2;
        int i3;
        List listN = this.K.n();
        int size = listN.size();
        LocalMedia localMedia = listN.size() > 0 ? (LocalMedia) listN.get(0) : null;
        String strN = localMedia != null ? localMedia.n() : Constants.STR_EMPTY;
        boolean zM = a22.m(strN);
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig.G0) {
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                if (a22.n(((LocalMedia) listN.get(i6)).n())) {
                    i5++;
                } else {
                    i4++;
                }
            }
            PictureSelectionConfig pictureSelectionConfig2 = this.a;
            if (pictureSelectionConfig2.v == 2) {
                int i7 = pictureSelectionConfig2.x;
                if (i7 > 0 && i4 < i7) {
                    showPromptDialog(getString(R$string.picture_min_img_num, Integer.valueOf(i7)));
                    return;
                }
                int i8 = pictureSelectionConfig2.z;
                if (i8 > 0 && i5 < i8) {
                    showPromptDialog(getString(R$string.picture_min_video_num, Integer.valueOf(i8)));
                    return;
                }
            }
        } else if (pictureSelectionConfig.v == 2) {
            if (a22.m(strN) && (i3 = this.a.x) > 0 && size < i3) {
                showPromptDialog(getString(R$string.picture_min_img_num, Integer.valueOf(i3)));
                return;
            } else if (a22.n(strN) && (i2 = this.a.z) > 0 && size < i2) {
                showPromptDialog(getString(R$string.picture_min_video_num, Integer.valueOf(i2)));
                return;
            }
        }
        PictureSelectionConfig pictureSelectionConfig3 = this.a;
        if (!pictureSelectionConfig3.D0 || size != 0) {
            if (pictureSelectionConfig3.a == a22.s() && this.a.G0) {
                y0(zM, listN);
                return;
            } else {
                h1(zM, listN);
                return;
            }
        }
        if (pictureSelectionConfig3.v == 2) {
            int i9 = pictureSelectionConfig3.x;
            if (i9 > 0 && size < i9) {
                showPromptDialog(getString(R$string.picture_min_img_num, Integer.valueOf(i9)));
                return;
            }
            int i10 = pictureSelectionConfig3.z;
            if (i10 > 0 && size < i10) {
                showPromptDialog(getString(R$string.picture_min_video_num, Integer.valueOf(i10)));
                return;
            }
        }
        ew1 ew1Var = PictureSelectionConfig.x1;
        if (ew1Var != null) {
            ew1Var.a(listN);
        } else {
            setResult(-1, v22.h(listN));
        }
        L();
    }

    private void c1() {
        List listN = this.K.n();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        int size = listN.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add((LocalMedia) listN.get(i2));
        }
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("previewSelectList", arrayList);
        bundle.putParcelableArrayList("selectList", (ArrayList) listN);
        bundle.putBoolean("bottom_preview", true);
        bundle.putBoolean("isOriginal", this.a.L0);
        bundle.putBoolean("isShowCamera", this.K.s());
        bundle.putString("currentDirectory", this.r.getText().toString());
        Context contextN = N();
        PictureSelectionConfig pictureSelectionConfig = this.a;
        b81.a(contextN, pictureSelectionConfig.Y, bundle, pictureSelectionConfig.v == 1 ? 69 : 609);
        overridePendingTransition(PictureSelectionConfig.v1.c, R$anim.picture_anim_fade_in);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1() {
        MediaPlayer mediaPlayer = this.O;
        if (mediaPlayer != null) {
            this.P.setProgress(mediaPlayer.getCurrentPosition());
            this.P.setMax(this.O.getDuration());
        }
        String string = this.x.getText().toString();
        int i2 = R$string.picture_play_audio;
        if (string.equals(getString(i2))) {
            this.x.setText(getString(R$string.picture_pause_audio));
            this.F.setText(getString(i2));
        } else {
            this.x.setText(getString(i2));
            this.F.setText(getString(R$string.picture_pause_audio));
        }
        e1();
        if (this.Q) {
            return;
        }
        this.h.post(this.Y);
        this.Q = true;
    }

    private void f1(Intent intent) {
        if (intent == null) {
            return;
        }
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig.c0) {
            pictureSelectionConfig.L0 = intent.getBooleanExtra("isOriginal", pictureSelectionConfig.L0);
            this.S.setChecked(this.a.L0);
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("selectList");
        if (this.K == null || parcelableArrayListExtra == null) {
            return;
        }
        if (intent.getBooleanExtra("isCompleteOrSelected", false)) {
            Z0(parcelableArrayListExtra);
            if (this.a.G0) {
                int size = parcelableArrayListExtra.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (a22.m(((LocalMedia) parcelableArrayListExtra.get(i2)).n())) {
                        if (!this.a.b0) {
                            break;
                        } else {
                            H(parcelableArrayListExtra);
                        }
                    }
                }
                b0(parcelableArrayListExtra);
            } else {
                String strN = parcelableArrayListExtra.size() > 0 ? ((LocalMedia) parcelableArrayListExtra.get(0)).n() : Constants.STR_EMPTY;
                if (this.a.b0 && a22.m(strN)) {
                    H(parcelableArrayListExtra);
                } else {
                    b0(parcelableArrayListExtra);
                }
            }
        } else {
            this.N = true;
        }
        this.K.i(parcelableArrayListExtra);
        this.K.notifyDataSetChanged();
    }

    private void h1(boolean z, List list) {
        LocalMedia localMedia = list.size() > 0 ? (LocalMedia) list.get(0) : null;
        if (localMedia == null) {
            return;
        }
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig.o0 && !pictureSelectionConfig.L0 && z) {
            if (pictureSelectionConfig.v != 1) {
                t73.c(this, (ArrayList) list);
                return;
            } else {
                pictureSelectionConfig.Y0 = localMedia.q();
                t73.b(this, this.a.Y0, localMedia.n(), localMedia.u(), localMedia.l());
                return;
            }
        }
        if (pictureSelectionConfig.b0 && z) {
            H(list);
        } else {
            b0(list);
        }
    }

    private void i1() {
        LocalMediaFolder localMediaFolderD = this.L.d(db3.a(this.r.getTag(R$id.view_index_tag)));
        localMediaFolderD.r(this.K.l());
        localMediaFolderD.q(this.k);
        localMediaFolderD.u(this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(String str) {
        if (TextUtils.isEmpty(str)) {
            this.r.setText(getString(this.a.a == a22.t() ? R$string.picture_all_audio : R$string.picture_camera_roll));
        } else {
            this.r.setText(str);
        }
        this.r.setTag(R$id.view_tag, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(String str, int i2) {
        if (this.u.getVisibility() == 8 || this.u.getVisibility() == 4) {
            this.u.setCompoundDrawablesRelativeWithIntrinsicBounds(0, i2, 0, 0);
            this.u.setText(str);
            this.u.setVisibility(0);
        }
    }

    private void m1(Intent intent) {
        Uri uriD;
        if (intent == null || (uriD = com.yalantis.ucrop.b.d(intent)) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        String path = uriD.getPath();
        if (this.K != null) {
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("selectList");
            if (parcelableArrayListExtra != null) {
                this.K.i(parcelableArrayListExtra);
                this.K.notifyDataSetChanged();
            }
            List listN = this.K.n();
            LocalMedia localMedia = null;
            LocalMedia localMedia2 = (listN == null || listN.size() <= 0) ? null : (LocalMedia) listN.get(0);
            if (localMedia2 != null) {
                this.a.Y0 = localMedia2.q();
                localMedia2.T(path);
                localMedia2.K(this.a.a);
                boolean z = !TextUtils.isEmpty(path);
                if (ol2.a() && a22.h(localMedia2.q())) {
                    localMedia2.H(path);
                }
                localMedia2.O(intent.getIntExtra("com.yalantis.ucrop.ImageWidth", 0));
                localMedia2.N(intent.getIntExtra("com.yalantis.ucrop.ImageHeight", 0));
                localMedia2.P(intent.getIntExtra("com.yalantis.ucrop.OffsetX", 0));
                localMedia2.Q(intent.getIntExtra("com.yalantis.ucrop.OffsetY", 0));
                localMedia2.R(intent.getFloatExtra("com.yalantis.ucrop.CropAspectRatio", 0.0f));
                localMedia2.X(intent.getBooleanExtra("com.yalantis.ucrop.EditorImage", false));
                localMedia2.S(z);
                arrayList.add(localMedia2);
                Q(arrayList);
                return;
            }
            if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                localMedia = (LocalMedia) parcelableArrayListExtra.get(0);
            }
            if (localMedia != null) {
                this.a.Y0 = localMedia.q();
                localMedia.T(path);
                localMedia.K(this.a.a);
                boolean z2 = !TextUtils.isEmpty(path);
                if (ol2.a() && a22.h(localMedia.q())) {
                    localMedia.H(path);
                }
                localMedia.O(intent.getIntExtra("com.yalantis.ucrop.ImageWidth", 0));
                localMedia.N(intent.getIntExtra("com.yalantis.ucrop.ImageHeight", 0));
                localMedia.P(intent.getIntExtra("com.yalantis.ucrop.OffsetX", 0));
                localMedia.Q(intent.getIntExtra("com.yalantis.ucrop.OffsetY", 0));
                localMedia.R(intent.getFloatExtra("com.yalantis.ucrop.CropAspectRatio", 0.0f));
                localMedia.X(intent.getBooleanExtra("com.yalantis.ucrop.EditorImage", false));
                localMedia.S(z2);
                arrayList.add(localMedia);
                Q(arrayList);
            }
        }
    }

    private void n1(LocalMedia localMedia) {
        String strN = localMedia.n();
        boolean zM = a22.m(strN);
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig.o0 && !pictureSelectionConfig.L0 && zM) {
            String str = pictureSelectionConfig.Z0;
            pictureSelectionConfig.Y0 = str;
            t73.b(this, str, strN, localMedia.u(), localMedia.l());
        } else if (pictureSelectionConfig.b0 && zM) {
            H(this.K.n());
        } else {
            b0(this.K.n());
        }
    }

    private void o1() {
        List listN = this.K.n();
        if (listN == null || listN.size() <= 0) {
            return;
        }
        int iR = ((LocalMedia) listN.get(0)).r();
        listN.clear();
        this.K.notifyItemChanged(iR);
    }

    private void q1(final String str) {
        if (isFinishing()) {
            return;
        }
        d12 d12Var = new d12(N(), R$layout.picture_audio_dialog);
        this.R = d12Var;
        d12Var.getWindow().setWindowAnimations(R$style.Picture_Theme_Dialog_AudioStyle);
        this.F = (TextView) this.R.findViewById(R$id.tv_musicStatus);
        this.H = (TextView) this.R.findViewById(R$id.tv_musicTime);
        this.P = (SeekBar) this.R.findViewById(R$id.musicSeekBar);
        this.G = (TextView) this.R.findViewById(R$id.tv_musicTotal);
        this.x = (TextView) this.R.findViewById(R$id.tv_PlayPause);
        this.y = (TextView) this.R.findViewById(R$id.tv_Stop);
        this.z = (TextView) this.R.findViewById(R$id.tv_Quit);
        this.h.postDelayed(new h(str), 30L);
        this.x.setOnClickListener(new l(str));
        this.y.setOnClickListener(new l(str));
        this.z.setOnClickListener(new l(str));
        this.P.setOnSeekBarChangeListener(new i());
        this.R.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: z22
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.a.S0(str, dialogInterface);
            }
        });
        this.h.post(this.Y);
        this.R.show();
    }

    private void t1(List list, LocalMedia localMedia) {
        File parentFile = new File(localMedia.s()).getParentFile();
        if (parentFile == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            LocalMediaFolder localMediaFolder = (LocalMediaFolder) list.get(i2);
            String strH = localMediaFolder.h();
            if (!TextUtils.isEmpty(strH) && strH.equals(parentFile.getName())) {
                localMediaFolder.s(this.a.Z0);
                localMediaFolder.v(localMediaFolder.g() + 1);
                localMediaFolder.p(1);
                localMediaFolder.d().add(0, localMedia);
                return;
            }
        }
    }

    private void y0(boolean z, List list) {
        int i2 = 0;
        LocalMedia localMedia = list.size() > 0 ? (LocalMedia) list.get(0) : null;
        if (localMedia == null) {
            return;
        }
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (!pictureSelectionConfig.o0 || pictureSelectionConfig.L0) {
            if (!pictureSelectionConfig.b0) {
                b0(list);
                return;
            }
            int size = list.size();
            while (i2 < size) {
                if (a22.m(((LocalMedia) list.get(i2)).n())) {
                    H(list);
                    return;
                }
                i2++;
            }
            b0(list);
            return;
        }
        if (pictureSelectionConfig.v == 1 && z) {
            pictureSelectionConfig.Y0 = localMedia.q();
            t73.b(this, this.a.Y0, localMedia.n(), localMedia.u(), localMedia.l());
            return;
        }
        int size2 = list.size();
        int i3 = 0;
        while (i2 < size2) {
            LocalMedia localMedia2 = (LocalMedia) list.get(i2);
            if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.q()) && a22.m(localMedia2.n())) {
                i3++;
            }
            i2++;
        }
        if (i3 <= 0) {
            b0(list);
        } else {
            t73.c(this, (ArrayList) list);
        }
    }

    protected void A0(List list) {
        if (list.size() == 0) {
            this.t.setEnabled(this.a.D0);
            this.t.setSelected(false);
            this.w.setEnabled(false);
            this.w.setSelected(false);
            PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
            if (this.c) {
                I0(list.size());
                return;
            } else {
                this.v.setVisibility(4);
                this.t.setText(getString(R$string.picture_please_select));
                return;
            }
        }
        this.t.setEnabled(true);
        this.t.setSelected(true);
        this.w.setEnabled(true);
        this.w.setSelected(true);
        PictureCropParameterStyle pictureCropParameterStyle2 = PictureSelectionConfig.u1;
        if (this.c) {
            I0(list.size());
            return;
        }
        if (!this.N) {
            this.v.startAnimation(this.M);
        }
        this.v.setVisibility(0);
        this.v.setText(db3.e(Integer.valueOf(list.size())));
        this.t.setText(getString(R$string.picture_completed));
        this.N = false;
    }

    protected void I0(int i2) {
        if (this.a.v == 1) {
            if (i2 <= 0) {
                PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
                return;
            } else {
                PictureCropParameterStyle pictureCropParameterStyle2 = PictureSelectionConfig.u1;
                return;
            }
        }
        if (i2 <= 0) {
            PictureCropParameterStyle pictureCropParameterStyle3 = PictureSelectionConfig.u1;
        } else {
            PictureCropParameterStyle pictureCropParameterStyle4 = PictureSelectionConfig.u1;
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public int P() {
        return R$layout.picture_selector;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public void U() {
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        int iB = cb.b(N(), R$attr.picture_title_textColor);
        if (iB != 0) {
            this.r.setTextColor(iB);
        }
        int iB2 = cb.b(N(), R$attr.picture_right_textColor);
        if (iB2 != 0) {
            this.s.setTextColor(iB2);
        }
        int iB3 = cb.b(N(), R$attr.picture_container_backgroundColor);
        if (iB3 != 0) {
            this.i.setBackgroundColor(iB3);
        }
        this.n.setImageDrawable(cb.d(N(), R$attr.picture_leftBack_icon, R$drawable.picture_icon_back));
        int i2 = this.a.V0;
        if (i2 != 0) {
            this.o.setImageDrawable(q30.e(this, i2));
        } else {
            this.o.setImageDrawable(cb.d(N(), R$attr.picture_arrow_down_icon, R$drawable.picture_icon_arrow_down));
        }
        int iB4 = cb.b(N(), R$attr.picture_bottom_bg);
        if (iB4 != 0) {
            this.J.setBackgroundColor(iB4);
        }
        ColorStateList colorStateListC = cb.c(N(), R$attr.picture_complete_textColor);
        if (colorStateListC != null) {
            this.t.setTextColor(colorStateListC);
        }
        ColorStateList colorStateListC2 = cb.c(N(), R$attr.picture_preview_textColor);
        if (colorStateListC2 != null) {
            this.w.setTextColor(colorStateListC2);
        }
        int iF = cb.f(N(), R$attr.picture_titleRightArrow_LeftPadding);
        if (iF != 0) {
            ((RelativeLayout.LayoutParams) this.o.getLayoutParams()).leftMargin = iF;
        }
        this.v.setBackground(cb.d(N(), R$attr.picture_num_style, R$drawable.picture_num_oval));
        int iF2 = cb.f(N(), R$attr.picture_titleBar_height);
        if (iF2 > 0) {
            this.p.getLayoutParams().height = iF2;
        }
        if (this.a.c0) {
            this.S.setButtonDrawable(cb.d(N(), R$attr.picture_original_check_style, R$drawable.picture_original_wechat_checkbox));
            int iB5 = cb.b(N(), R$attr.picture_original_text_color);
            if (iB5 != 0) {
                this.S.setTextColor(iB5);
            }
        }
        this.p.setBackgroundColor(this.d);
        this.K.i(this.g);
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void V() {
        super.V();
        this.i = findViewById(R$id.container);
        this.p = findViewById(R$id.titleBar);
        this.n = (ImageView) findViewById(R$id.pictureLeftBack);
        this.r = (TextView) findViewById(R$id.picture_title);
        this.s = (TextView) findViewById(R$id.picture_right);
        this.t = (TextView) findViewById(R$id.picture_tv_ok);
        this.S = (CheckBox) findViewById(R$id.cb_original);
        this.o = (ImageView) findViewById(R$id.ivArrow);
        this.f293q = findViewById(R$id.viewClickMask);
        this.w = (TextView) findViewById(R$id.picture_id_preview);
        this.v = (TextView) findViewById(R$id.tv_media_num);
        this.I = (RecyclerPreloadView) findViewById(R$id.picture_recycler);
        this.J = (RelativeLayout) findViewById(R$id.select_bar_layout);
        this.u = (TextView) findViewById(R$id.tv_empty);
        O0(this.c);
        if (!this.c) {
            this.M = AnimationUtils.loadAnimation(this, R$anim.picture_anim_modal_in);
        }
        this.w.setOnClickListener(this);
        if (this.a.g1) {
            this.p.setOnClickListener(this);
        }
        this.w.setVisibility((this.a.a == a22.t() || !this.a.j0) ? 8 : 0);
        RelativeLayout relativeLayout = this.J;
        PictureSelectionConfig pictureSelectionConfig = this.a;
        relativeLayout.setVisibility((pictureSelectionConfig.v == 1 && pictureSelectionConfig.c) ? 8 : 0);
        this.n.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.f293q.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.o.setOnClickListener(this);
        j1(null);
        go0 go0Var = new go0(this);
        this.L = go0Var;
        go0Var.i(this.o);
        this.L.j(this);
        RecyclerPreloadView recyclerPreloadView = this.I;
        int i2 = this.a.M;
        if (i2 <= 0) {
            i2 = 4;
        }
        recyclerPreloadView.addItemDecoration(new mv0(i2, ll2.a(this, 2.0f), false));
        RecyclerPreloadView recyclerPreloadView2 = this.I;
        Context contextN = N();
        int i3 = this.a.M;
        recyclerPreloadView2.setLayoutManager(new GridLayoutManager(contextN, i3 > 0 ? i3 : 4));
        if (this.a.c1) {
            this.I.setReachBottomRow(2);
            this.I.setOnRecyclerViewPreloadListener(this);
        } else {
            this.I.setHasFixedSize(true);
        }
        RecyclerView.ItemAnimator itemAnimator = this.I.getItemAnimator();
        if (itemAnimator != null) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            this.I.setItemAnimator(null);
        }
        T0();
        this.u.setText(getString(this.a.a == a22.t() ? R$string.picture_audio_empty : R$string.picture_empty));
        sv2.f(this.u, this.a.a);
        w12 w12Var = new w12(N(), this.a);
        this.K = w12Var;
        w12Var.z(this);
        int i4 = this.a.f1;
        if (i4 == 1) {
            this.I.setAdapter(new m5(this.K));
        } else if (i4 != 2) {
            this.I.setAdapter(this.K);
        } else {
            this.I.setAdapter(new qr2(this.K));
        }
        if (this.a.c0) {
            this.S.setVisibility(0);
            this.S.setChecked(this.a.L0);
            this.S.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: y22
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.a.P0(compoundButton, z);
                }
            });
        }
    }

    protected void X0(Intent intent) {
        ArrayList arrayListC;
        if (intent == null || (arrayListC = com.yalantis.ucrop.b.c(intent)) == null || arrayListC.size() <= 0) {
            return;
        }
        this.K.i(arrayListC);
        this.K.notifyDataSetChanged();
        Q(arrayListC);
    }

    protected void Z0(List list) {
    }

    @Override // defpackage.sv1
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public void a(LocalMedia localMedia, int i2) {
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig.v != 1 || !pictureSelectionConfig.c) {
            r1(this.K.l(), i2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(localMedia);
        if (!this.a.o0 || !a22.m(localMedia.n()) || this.a.L0) {
            Q(arrayList);
        } else {
            this.K.i(arrayList);
            t73.b(this, localMedia.q(), localMedia.n(), localMedia.u(), localMedia.l());
        }
    }

    @Override // defpackage.lu1
    public void c(int i2, boolean z, long j2, String str, List list) {
        this.K.A(this.a.f0 && z);
        this.r.setText(str);
        TextView textView = this.r;
        int i3 = R$id.view_tag;
        long jC = db3.c(textView.getTag(i3));
        this.r.setTag(R$id.view_count_tag, Integer.valueOf(this.L.d(i2) != null ? this.L.d(i2).g() : 0));
        if (!this.a.c1) {
            this.K.h(list);
            this.I.smoothScrollToPosition(0);
        } else if (jC != j2) {
            i1();
            if (!M0(i2)) {
                this.k = 1;
                f0();
                this.m.d(j2, this.k, new a());
            }
        }
        this.r.setTag(i3, Long.valueOf(j2));
        this.L.dismiss();
    }

    public void e1() {
        try {
            MediaPlayer mediaPlayer = this.O;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.O.pause();
                } else {
                    this.O.start();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // defpackage.sv1
    public void f(List list) {
        A0(list);
        z0(list);
    }

    protected void g1() {
        f0();
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig.p1) {
            this.m.b(new d());
        } else if (pictureSelectionConfig.c1) {
            this.m.a(new e());
        } else {
            this.m.a(new f());
        }
    }

    @Override // defpackage.sv1
    public void i() {
        if (wz1.a(this, "android.permission.CAMERA")) {
            p1();
        } else {
            g02.o(new b(), getString(R$string.take_picture), "android.permission.CAMERA");
        }
    }

    @Override // defpackage.bw1
    public void j() {
        U0();
    }

    protected void l1(final boolean z, String[] strArr, String str) {
        if (isFinishing()) {
            return;
        }
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        final d12 d12Var = new d12(N(), R$layout.picture_wind_base_dialog);
        d12Var.setCancelable(false);
        d12Var.setCanceledOnTouchOutside(false);
        Button button = (Button) d12Var.findViewById(R$id.btn_cancel);
        Button button2 = (Button) d12Var.findViewById(R$id.btn_commit);
        button2.setText(getString(R$string.picture_go_setting));
        TextView textView = (TextView) d12Var.findViewById(R$id.tvTitle);
        TextView textView2 = (TextView) d12Var.findViewById(R$id.tv_content);
        textView.setText(getString(R$string.picture_prompt));
        textView2.setText(str);
        button.setOnClickListener(new View.OnClickListener() { // from class: w22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Q0(d12Var, z, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: x22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.R0(d12Var, view);
            }
        });
        d12Var.show();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) throws Throwable {
        Throwable th;
        ArrayList parcelableArrayListExtra;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            if (i3 == 0) {
                f1(intent);
                if (i2 == 909) {
                    gi1.b(this, this.a.Z0);
                    return;
                }
                return;
            }
            if (i3 != 96 || intent == null || (th = (Throwable) intent.getSerializableExtra("com.yalantis.ucrop.Error")) == null) {
                return;
            }
            p33.b(N(), th.getMessage());
            return;
        }
        if (i2 == 69) {
            m1(intent);
            return;
        }
        if (i2 == 166) {
            if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra("selectList")) == null || parcelableArrayListExtra.size() <= 0) {
                return;
            }
            b0(parcelableArrayListExtra);
            return;
        }
        if (i2 == 609) {
            X0(intent);
        } else {
            if (i2 != 909) {
                return;
            }
            C0(intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (ol2.a()) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
        ew1 ew1Var = PictureSelectionConfig.x1;
        if (ew1Var != null) {
            ew1Var.onCancel();
        }
        L();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.pictureLeftBack || id == R$id.picture_right) {
            go0 go0Var = this.L;
            if (go0Var == null || !go0Var.isShowing()) {
                onBackPressed();
                return;
            } else {
                this.L.dismiss();
                return;
            }
        }
        if (id == R$id.picture_title || id == R$id.ivArrow || id == R$id.viewClickMask) {
            if (this.a.p1) {
                return;
            }
            if (this.L.isShowing()) {
                this.L.dismiss();
                return;
            }
            if (this.L.g()) {
                return;
            }
            this.L.showAsDropDown(this.p);
            if (this.a.c) {
                return;
            }
            this.L.k(this.K.n());
            return;
        }
        if (id == R$id.picture_id_preview) {
            c1();
            return;
        }
        if (id == R$id.picture_tv_ok || id == R$id.tv_media_num) {
            a1();
            return;
        }
        if (id == R$id.titleBar && this.a.g1) {
            if (SystemClock.uptimeMillis() - this.V >= 500) {
                this.V = SystemClock.uptimeMillis();
            } else if (this.K.getItemCount() > 0) {
                this.I.scrollToPosition(0);
            }
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.W = bundle.getInt("all_folder_size");
            this.T = bundle.getInt("oldCurrentListSize", 0);
            List listF = v22.f(bundle);
            if (listF == null) {
                listF = this.g;
            }
            this.g = listF;
            w12 w12Var = this.K;
            if (w12Var != null) {
                this.N = true;
                w12Var.i(listF);
            }
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Animation animation = this.M;
        if (animation != null) {
            animation.cancel();
            this.M = null;
        }
        if (this.O != null) {
            this.h.removeCallbacks(this.Y);
            this.O.release();
            this.O = null;
        }
    }

    @Override // defpackage.gv1
    public void onItemClick(View view, int i2) {
        if (i2 == 0) {
            PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
            j0();
        } else {
            if (i2 != 1) {
                return;
            }
            PictureCropParameterStyle pictureCropParameterStyle2 = PictureSelectionConfig.u1;
            k0();
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                l1(false, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, getString(R$string.picture_jurisdiction));
                return;
            } else {
                g1();
                return;
            }
        }
        if (i2 == 2) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                l1(true, new String[]{"android.permission.CAMERA"}, getString(R$string.picture_camera));
                return;
            } else {
                i();
                return;
            }
        }
        if (i2 != 5) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            l1(false, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, getString(R$string.picture_jurisdiction));
        } else {
            p1();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        CheckBox checkBox;
        super.onResume();
        if (this.U) {
            if (!wz1.a(this, "android.permission.READ_EXTERNAL_STORAGE")) {
                l1(false, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, getString(R$string.picture_jurisdiction));
            } else if (this.K.q()) {
                g1();
            }
            this.U = false;
        }
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (!pictureSelectionConfig.c0 || (checkBox = this.S) == null) {
            return;
        }
        checkBox.setChecked(pictureSelectionConfig.L0);
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        w12 w12Var = this.K;
        if (w12Var != null) {
            bundle.putInt("oldCurrentListSize", w12Var.p());
            if (this.L.e().size() > 0) {
                bundle.putInt("all_folder_size", this.L.d(0).g());
            }
            if (this.K.n() != null) {
                v22.i(bundle, this.K.n());
            }
        }
    }

    public void p1() {
        if (wc0.a()) {
            return;
        }
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        PictureSelectionConfig pictureSelectionConfig = this.a;
        int i2 = pictureSelectionConfig.a;
        if (i2 != 0) {
            if (i2 == 1) {
                j0();
                return;
            } else if (i2 == 2) {
                k0();
                return;
            } else {
                if (i2 != 3) {
                    return;
                }
                i0();
                return;
            }
        }
        if (pictureSelectionConfig.o1 == a22.w()) {
            j0();
        } else {
            if (this.a.o1 == a22.y()) {
                k0();
                return;
            }
            PhotoItemSelectedDialog photoItemSelectedDialogO = PhotoItemSelectedDialog.O();
            photoItemSelectedDialogO.P(this);
            photoItemSelectedDialogO.M(getSupportFragmentManager(), "PhotoItemSelectedDialog");
        }
    }

    public void r1(List list, int i2) {
        LocalMedia localMedia = (LocalMedia) list.get(i2);
        String strN = localMedia.n();
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        if (a22.n(strN)) {
            PictureSelectionConfig pictureSelectionConfig = this.a;
            if (pictureSelectionConfig.v == 1 && !pictureSelectionConfig.k0) {
                arrayList.add(localMedia);
                b0(arrayList);
                return;
            } else {
                PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
                bundle.putParcelable("mediaKey", localMedia);
                b81.b(N(), bundle, 166);
                return;
            }
        }
        if (a22.k(strN)) {
            if (this.a.v != 1) {
                q1(localMedia.q());
                return;
            } else {
                arrayList.add(localMedia);
                b0(arrayList);
                return;
            }
        }
        PictureCropParameterStyle pictureCropParameterStyle2 = PictureSelectionConfig.u1;
        List listN = this.K.n();
        i11.c().d(new ArrayList(list));
        bundle.putParcelableArrayList("selectList", (ArrayList) listN);
        bundle.putInt("position", i2);
        bundle.putBoolean("isOriginal", this.a.L0);
        bundle.putBoolean("isShowCamera", this.K.s());
        bundle.putLong("bucket_id", db3.c(this.r.getTag(R$id.view_tag)));
        bundle.putInt("page", this.k);
        bundle.putParcelable("PictureSelectorConfig", this.a);
        bundle.putInt("count", db3.a(this.r.getTag(R$id.view_count_tag)));
        bundle.putString("currentDirectory", this.r.getText().toString());
        Context contextN = N();
        PictureSelectionConfig pictureSelectionConfig2 = this.a;
        b81.a(contextN, pictureSelectionConfig2.Y, bundle, pictureSelectionConfig2.v == 1 ? 69 : 609);
        overridePendingTransition(PictureSelectionConfig.v1.c, R$anim.picture_anim_fade_in);
    }

    public void s1(String str) {
        MediaPlayer mediaPlayer = this.O;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                this.O.reset();
                if (a22.h(str)) {
                    this.O.setDataSource(N(), Uri.parse(str));
                } else {
                    this.O.setDataSource(str);
                }
                this.O.prepare();
                this.O.seekTo(0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    protected void z0(List list) {
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig.c0) {
            if (!pictureSelectionConfig.d0) {
                this.S.setText(getString(R$string.picture_default_original_image));
                return;
            }
            long jT = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                jT += ((LocalMedia) list.get(i2)).t();
            }
            if (jT <= 0) {
                this.S.setText(getString(R$string.picture_default_original_image));
            } else {
                this.S.setText(getString(R$string.picture_original_image, s12.g(jT, 2)));
            }
        }
    }
}
