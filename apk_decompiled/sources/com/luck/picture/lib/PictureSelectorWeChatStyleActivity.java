package com.luck.picture.lib;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import defpackage.a22;
import defpackage.cb;
import defpackage.go0;
import defpackage.q30;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PictureSelectorWeChatStyleActivity extends PictureSelectorActivity {
    private RelativeLayout Z;

    private void u1() {
        this.v.setVisibility(8);
        this.t.setVisibility(8);
    }

    private void w1(boolean z) {
        if (this.Z.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Z.getLayoutParams();
            if (z) {
                layoutParams.addRule(1, -1);
                layoutParams.addRule(14);
            } else {
                layoutParams.addRule(14, -1);
                layoutParams.addRule(1, R$id.pictureLeftBack);
            }
        }
    }

    @Override // com.luck.picture.lib.PictureSelectorActivity
    protected void A0(List list) {
        int size = list.size();
        if (size == 0) {
            this.s.setEnabled(false);
            this.s.setSelected(false);
            this.w.setEnabled(false);
            this.w.setSelected(false);
            PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
            this.s.setBackgroundResource(R$drawable.picture_send_button_default_bg);
            this.s.setTextColor(q30.c(N(), R$color.picture_color_53575e));
            this.w.setTextColor(q30.c(N(), R$color.picture_color_9b));
            this.w.setText(getString(R$string.picture_preview));
            this.s.setText(getString(R$string.picture_send));
            return;
        }
        this.s.setEnabled(true);
        this.s.setSelected(true);
        this.w.setEnabled(true);
        this.w.setSelected(true);
        v1(list);
        PictureCropParameterStyle pictureCropParameterStyle2 = PictureSelectionConfig.u1;
        this.s.setBackgroundResource(R$drawable.picture_send_button_bg);
        TextView textView = this.s;
        Context contextN = N();
        int i = R$color.picture_color_white;
        textView.setTextColor(q30.c(contextN, i));
        this.w.setTextColor(q30.c(N(), i));
        this.w.setText(getString(R$string.picture_preview_num, Integer.valueOf(size)));
    }

    @Override // com.luck.picture.lib.PictureSelectorActivity, com.luck.picture.lib.PictureBaseActivity
    public int P() {
        return R$layout.picture_wechat_style_selector;
    }

    @Override // com.luck.picture.lib.PictureSelectorActivity, com.luck.picture.lib.PictureBaseActivity
    public void U() {
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        this.s.setBackgroundResource(R$drawable.picture_send_button_default_bg);
        this.Z.setBackgroundResource(R$drawable.picture_album_bg);
        this.s.setTextColor(q30.c(N(), R$color.picture_color_53575e));
        int iB = cb.b(N(), R$attr.picture_bottom_bg);
        RelativeLayout relativeLayout = this.J;
        if (iB == 0) {
            iB = q30.c(N(), R$color.picture_color_grey);
        }
        relativeLayout.setBackgroundColor(iB);
        this.S.setTextColor(q30.c(this, R$color.picture_color_white));
        this.o.setImageDrawable(q30.e(this, R$drawable.picture_icon_wechat_down));
        if (this.a.c0) {
            this.S.setButtonDrawable(q30.e(this, R$drawable.picture_original_wechat_checkbox));
        }
        super.U();
        u1();
    }

    @Override // com.luck.picture.lib.PictureSelectorActivity, com.luck.picture.lib.PictureBaseActivity
    protected void V() {
        super.V();
        this.Z = (RelativeLayout) findViewById(R$id.rlAlbum);
        this.s.setOnClickListener(this);
        this.s.setText(getString(R$string.picture_send));
        this.w.setTextSize(16.0f);
        this.S.setTextSize(16.0f);
        PictureSelectionConfig pictureSelectionConfig = this.a;
        boolean z = pictureSelectionConfig.v == 1 && pictureSelectionConfig.c;
        this.s.setVisibility(z ? 8 : 0);
        this.s.setOnClickListener(this);
        w1(z);
    }

    @Override // com.luck.picture.lib.PictureSelectorActivity
    protected void Z0(List list) {
        super.Z0(list);
        v1(list);
    }

    @Override // com.luck.picture.lib.PictureSelectorActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R$id.picture_right) {
            super.onClick(view);
            return;
        }
        go0 go0Var = this.L;
        if (go0Var == null || !go0Var.isShowing()) {
            this.t.performClick();
        } else {
            this.L.dismiss();
        }
    }

    protected void v1(List list) {
        int i;
        int size = list.size();
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig.G0) {
            if (pictureSelectionConfig.v != 1) {
                this.s.setText(getString(R$string.picture_send_num, Integer.valueOf(size), Integer.valueOf(this.a.w)));
                return;
            } else if (size <= 0) {
                this.s.setText(getString(R$string.picture_send));
                return;
            } else {
                this.s.setText(getString(R$string.picture_send));
                return;
            }
        }
        if (!a22.n(((LocalMedia) list.get(0)).n()) || (i = this.a.y) <= 0) {
            i = this.a.w;
        }
        if (this.a.v == 1) {
            this.s.setText(getString(R$string.picture_send));
        } else {
            this.s.setText(getString(R$string.picture_send_num, Integer.valueOf(size), Integer.valueOf(i)));
        }
    }
}
