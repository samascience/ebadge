package com.luck.picture.lib;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.tencent.connect.common.Constants;
import defpackage.a22;
import defpackage.l32;
import defpackage.q30;

/* JADX INFO: loaded from: classes3.dex */
public class PictureSelectorPreviewWeChatStyleActivity extends PicturePreviewActivity {
    private RecyclerView W;
    private View X;
    private TextView Y;
    private l32 Z;

    private void Q0() {
        if (this.f292q.getVisibility() == 0) {
            this.f292q.setVisibility(8);
        }
        if (this.s.getVisibility() == 0) {
            this.s.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.I.getText())) {
            return;
        }
        this.I.setText(Constants.STR_EMPTY);
    }

    private boolean R0(String str, String str2) {
        return this.y || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.equals(getString(R$string.picture_camera_roll)) || str.equals(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(int i, LocalMedia localMedia, View view) {
        if (this.u == null || localMedia == null || !R0(localMedia.p(), this.Q)) {
            return;
        }
        if (!this.y) {
            i = this.P ? localMedia.k - 1 : localMedia.k;
        }
        this.u.setCurrentItem(i);
    }

    private void T0(LocalMedia localMedia) {
        int itemCount;
        l32 l32Var = this.Z;
        if (l32Var == null || (itemCount = l32Var.getItemCount()) <= 0) {
            return;
        }
        boolean z = false;
        for (int i = 0; i < itemCount; i++) {
            LocalMedia localMediaE = this.Z.e(i);
            if (localMediaE != null && !TextUtils.isEmpty(localMediaE.q())) {
                boolean zV = localMediaE.v();
                boolean z2 = localMediaE.q().equals(localMedia.q()) || localMediaE.m() == localMedia.m();
                if (!z) {
                    z = (zV && !z2) || (!zV && z2);
                }
                localMediaE.J(z2);
            }
        }
        if (z) {
            this.Z.notifyDataSetChanged();
        }
    }

    @Override // com.luck.picture.lib.PicturePreviewActivity
    protected void F0(LocalMedia localMedia) {
        super.F0(localMedia);
        Q0();
        if (this.a.B0) {
            return;
        }
        T0(localMedia);
    }

    @Override // com.luck.picture.lib.PicturePreviewActivity
    protected void G0(boolean z) {
        Q0();
        if (this.F.size() == 0) {
            PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
            this.p.setText(getString(R$string.picture_send));
            this.W.animate().alpha(0.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            this.W.setVisibility(8);
            this.X.animate().alpha(0.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            this.X.setVisibility(8);
            return;
        }
        t0(this.F.size());
        if (this.W.getVisibility() == 8) {
            this.W.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            this.W.setVisibility(0);
            this.X.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            this.X.setVisibility(0);
            if (!this.y || this.Z.getItemCount() <= 0) {
                this.Z.k(this.F, this.y);
            } else {
                Log.i(PicturePreviewActivity.V, "gallery adapter ignore...");
            }
        }
        PictureCropParameterStyle pictureCropParameterStyle2 = PictureSelectionConfig.u1;
        this.p.setTextColor(q30.c(N(), R$color.picture_color_white));
        this.p.setBackgroundResource(R$drawable.picture_send_button_bg);
    }

    @Override // com.luck.picture.lib.PicturePreviewActivity
    protected void H0(boolean z, LocalMedia localMedia) {
        if (z) {
            localMedia.J(true);
            if (this.y) {
                this.Z.e(this.x).c0(false);
                this.Z.notifyDataSetChanged();
            } else if (this.a.v == 1) {
                this.Z.d(localMedia);
            }
        } else {
            localMedia.J(false);
            if (this.y) {
                this.I.setSelected(false);
                this.Z.e(this.x).c0(true);
                this.Z.notifyDataSetChanged();
            } else {
                this.Z.i(localMedia);
            }
        }
        int itemCount = this.Z.getItemCount();
        if (itemCount > 5) {
            this.W.smoothScrollToPosition(itemCount - 1);
        }
    }

    @Override // com.luck.picture.lib.PicturePreviewActivity
    protected void I0(LocalMedia localMedia) {
        this.Z.notifyDataSetChanged();
    }

    @Override // com.luck.picture.lib.PicturePreviewActivity
    protected void J0(LocalMedia localMedia) {
        T0(localMedia);
    }

    @Override // com.luck.picture.lib.PicturePreviewActivity, com.luck.picture.lib.PictureBaseActivity
    public int P() {
        return R$layout.picture_wechat_style_preview;
    }

    @Override // com.luck.picture.lib.PicturePreviewActivity, com.luck.picture.lib.PictureBaseActivity
    public void U() {
        super.U();
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        this.p.setBackgroundResource(R$drawable.picture_send_button_bg);
        TextView textView = this.p;
        Context contextN = N();
        int i = R$color.picture_color_white;
        textView.setTextColor(q30.c(contextN, i));
        this.N.setBackgroundColor(q30.c(N(), R$color.picture_color_half_grey));
        this.I.setBackgroundResource(R$drawable.picture_wechat_select_cb);
        this.o.setImageResource(R$drawable.picture_icon_back);
        this.O.setTextColor(q30.c(this, i));
        if (this.a.c0) {
            this.O.setButtonDrawable(q30.e(this, R$drawable.picture_original_wechat_checkbox));
        }
        G0(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00d9, code lost:
    
        r5 = true;
     */
    @Override // com.luck.picture.lib.PicturePreviewActivity, com.luck.picture.lib.PictureBaseActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void V() {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureSelectorPreviewWeChatStyleActivity.V():void");
    }

    @Override // com.luck.picture.lib.PicturePreviewActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R$id.picture_right) {
            if (this.F.size() != 0) {
                this.s.performClick();
                return;
            }
            this.J.performClick();
            if (this.F.size() != 0) {
                this.s.performClick();
            }
        }
    }

    @Override // com.luck.picture.lib.PicturePreviewActivity
    protected void t0(int i) {
        int i2;
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig.G0) {
            if (pictureSelectionConfig.v != 1) {
                this.p.setText(getString(R$string.picture_send_num, Integer.valueOf(this.F.size()), Integer.valueOf(this.a.w)));
                return;
            } else if (i <= 0) {
                this.p.setText(getString(R$string.picture_send));
                return;
            } else {
                this.p.setText(getString(R$string.picture_send));
                return;
            }
        }
        if (!a22.n(this.F.size() > 0 ? ((LocalMedia) this.F.get(0)).n() : Constants.STR_EMPTY) || (i2 = this.a.y) <= 0) {
            i2 = this.a.w;
        }
        if (this.a.v != 1) {
            this.p.setText(getString(R$string.picture_send_num, Integer.valueOf(this.F.size()), Integer.valueOf(i2)));
        } else if (i <= 0) {
            this.p.setText(getString(R$string.picture_send));
        } else {
            this.p.setText(getString(R$string.picture_send));
        }
    }
}
