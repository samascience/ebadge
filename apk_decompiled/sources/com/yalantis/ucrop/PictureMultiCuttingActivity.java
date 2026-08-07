package com.yalantis.ucrop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.luck.picture.lib.R$anim;
import com.luck.picture.lib.R$color;
import com.luck.picture.lib.R$id;
import com.luck.picture.lib.R$layout;
import com.luck.picture.lib.entity.LocalMedia;
import defpackage.a22;
import defpackage.ll2;
import defpackage.ol2;
import defpackage.q30;
import defpackage.s12;
import defpackage.y60;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class PictureMultiCuttingActivity extends UCropActivity {
    private RecyclerView S;
    private com.yalantis.ucrop.a T;
    private final ArrayList U = new ArrayList();
    private boolean V;
    private int W;
    private int X;
    private String Y;
    private boolean Z;
    private boolean a0;

    class a implements com.yalantis.ucrop.a.b {
        a() {
        }

        @Override // com.yalantis.ucrop.a.b
        public void a(int i, View view) {
            if (a22.n(((LocalMedia) PictureMultiCuttingActivity.this.U.get(i)).n()) || PictureMultiCuttingActivity.this.W == i) {
                return;
            }
            PictureMultiCuttingActivity.this.H0();
            PictureMultiCuttingActivity.this.W = i;
            PictureMultiCuttingActivity pictureMultiCuttingActivity = PictureMultiCuttingActivity.this;
            pictureMultiCuttingActivity.X = pictureMultiCuttingActivity.W;
            PictureMultiCuttingActivity.this.F0();
        }
    }

    private void A0() {
        boolean booleanExtra = getIntent().getBooleanExtra("com.yalantis.ucrop.skip_multiple_crop", true);
        RecyclerView recyclerView = new RecyclerView(this);
        this.S = recyclerView;
        int i = R$id.id_recycler;
        recyclerView.setId(i);
        this.S.setBackgroundColor(q30.c(this, R$color.ucrop_color_widget_background));
        this.S.setLayoutParams(new RelativeLayout.LayoutParams(-1, ll2.a(this, 80.0f)));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        if (this.a0) {
            this.S.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getApplicationContext(), R$anim.ucrop_layout_animation_fall_down));
        }
        this.S.setLayoutManager(linearLayoutManager);
        RecyclerView.ItemAnimator itemAnimator = this.S.getItemAnimator();
        Objects.requireNonNull(itemAnimator);
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        G0();
        ((LocalMedia) this.U.get(this.W)).S(true);
        com.yalantis.ucrop.a aVar = new com.yalantis.ucrop.a(this.U);
        this.T = aVar;
        this.S.setAdapter(aVar);
        if (booleanExtra) {
            this.T.f(new a());
        }
        this.n.addView(this.S);
        B0(this.l);
        ((RelativeLayout.LayoutParams) ((FrameLayout) findViewById(R$id.ucrop_frame)).getLayoutParams()).addRule(2, i);
        ((RelativeLayout.LayoutParams) this.S.getLayoutParams()).addRule(2, R$id.controls_wrapper);
    }

    private void B0(boolean z) {
        if (this.S.getLayoutParams() == null) {
            return;
        }
        if (z) {
            ((RelativeLayout.LayoutParams) this.S.getLayoutParams()).addRule(12, 0);
            ((RelativeLayout.LayoutParams) this.S.getLayoutParams()).addRule(2, R$id.wrapper_controls);
        } else {
            ((RelativeLayout.LayoutParams) this.S.getLayoutParams()).addRule(12);
            ((RelativeLayout.LayoutParams) this.S.getLayoutParams()).addRule(2, 0);
        }
    }

    private void C0(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            LocalMedia localMedia = (LocalMedia) this.U.get(i2);
            if (localMedia != null && a22.m(localMedia.n())) {
                this.W = i2;
                return;
            }
        }
    }

    private void D0() {
        ArrayList arrayList = this.U;
        if (arrayList == null || arrayList.size() == 0) {
            onBackPressed();
            return;
        }
        int size = this.U.size();
        if (this.V) {
            C0(size);
        }
    }

    private void E0() {
        G0();
        ((LocalMedia) this.U.get(this.W)).S(true);
        this.T.notifyItemChanged(this.W);
        this.n.addView(this.S);
        B0(this.l);
        ((RelativeLayout.LayoutParams) ((FrameLayout) findViewById(R$id.ucrop_frame)).getLayoutParams()).addRule(2, R$id.id_recycler);
        ((RelativeLayout.LayoutParams) this.S.getLayoutParams()).addRule(2, R$id.controls_wrapper);
    }

    private void G0() {
        int size = this.U.size();
        for (int i = 0; i < size; i++) {
            ((LocalMedia) this.U.get(i)).S(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        int i;
        int size = this.U.size();
        if (size <= 1 || size <= (i = this.X)) {
            return;
        }
        ((LocalMedia) this.U.get(i)).S(false);
        this.T.notifyItemChanged(this.W);
    }

    protected void F0() {
        Uri uriFromFile;
        String strU;
        this.n.removeView(this.S);
        View view = this.G;
        if (view != null) {
            this.n.removeView(view);
        }
        setContentView(R$layout.ucrop_activity_photobox);
        this.n = (RelativeLayout) findViewById(R$id.ucrop_photobox);
        Q();
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        LocalMedia localMedia = (LocalMedia) this.U.get(this.W);
        String strQ = localMedia.q();
        boolean zL = a22.l(strQ);
        String strD = a22.d(a22.h(strQ) ? s12.l(this, Uri.parse(strQ)) : strQ);
        if (localMedia.E()) {
            uriFromFile = Uri.fromFile(new File(localMedia.a()));
        } else {
            uriFromFile = (zL || a22.h(strQ)) ? Uri.parse(strQ) : Uri.fromFile(new File(strQ));
        }
        extras.putInt("com.yalantis.ucrop.InputImageWidth", localMedia.u());
        extras.putInt("com.yalantis.ucrop.InputImageHeight", localMedia.l());
        extras.putParcelable("com.yalantis.ucrop.InputUri", uriFromFile);
        File externalFilesDir = Environment.getExternalStorageState().equals("mounted") ? getExternalFilesDir(Environment.DIRECTORY_PICTURES) : getCacheDir();
        if (TextUtils.isEmpty(this.Y)) {
            strU = y60.d("IMG_CROP_") + strD;
        } else {
            strU = this.Z ? this.Y : s12.u(this.Y);
        }
        extras.putParcelable("com.yalantis.ucrop.OutputUri", Uri.fromFile(new File(externalFilesDir, strU)));
        intent.putExtras(extras);
        u0(intent);
        E0();
        g0(intent);
        h0();
        double dA = this.W * ll2.a(this, 60.0f);
        int i = this.b;
        if (dA > ((double) i) * 0.8d) {
            this.S.scrollBy(ll2.a(this, 60.0f), 0);
        } else if (dA < ((double) i) * 0.4d) {
            this.S.scrollBy(ll2.a(this, -60.0f), 0);
        }
    }

    @Override // com.yalantis.ucrop.UCropActivity
    protected void l0(Uri uri, float f, int i, int i2, int i3, int i4) {
        try {
            int size = this.U.size();
            int i5 = this.W;
            if (size < i5) {
                onBackPressed();
                return;
            }
            LocalMedia localMedia = (LocalMedia) this.U.get(i5);
            localMedia.T(uri.getPath());
            localMedia.S(true);
            localMedia.R(f);
            localMedia.P(i);
            localMedia.Q(i2);
            localMedia.O(i3);
            localMedia.N(i4);
            localMedia.H(ol2.a() ? localMedia.i() : localMedia.a());
            H0();
            int i6 = this.W + 1;
            this.W = i6;
            if (this.V && i6 < this.U.size() && a22.n(((LocalMedia) this.U.get(this.W)).n())) {
                while (this.W < this.U.size() && !a22.m(((LocalMedia) this.U.get(this.W)).n())) {
                    this.W++;
                }
            }
            int i7 = this.W;
            this.X = i7;
            if (i7 < this.U.size()) {
                F0();
                return;
            }
            for (int i8 = 0; i8 < this.U.size(); i8++) {
                LocalMedia localMedia2 = (LocalMedia) this.U.get(i8);
                localMedia2.S(!TextUtils.isEmpty(localMedia2.i()));
            }
            setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUriList", this.U));
            onBackPressed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yalantis.ucrop.UCropActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.Y = intent.getStringExtra("com.yalantis.ucrop.RenameCropFileName");
        this.Z = intent.getBooleanExtra("com.yalantis.ucrop.isCamera", false);
        this.V = intent.getBooleanExtra("com.yalantis.ucrop.isWithVideoImage", false);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("com.yalantis.ucrop.cuts");
        this.a0 = getIntent().getBooleanExtra(".isMultipleAnimation", true);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() == 0) {
            onBackPressed();
            return;
        }
        this.U.addAll(parcelableArrayListExtra);
        if (this.U.size() > 1) {
            D0();
            A0();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.yalantis.ucrop.a aVar = this.T;
        if (aVar != null) {
            aVar.f(null);
        }
        super.onDestroy();
    }
}
