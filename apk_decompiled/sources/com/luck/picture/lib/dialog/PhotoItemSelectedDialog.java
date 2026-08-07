package com.luck.picture.lib.dialog;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.m;
import com.luck.picture.lib.R$id;
import com.luck.picture.lib.R$layout;
import com.luck.picture.lib.R$style;
import defpackage.gv1;
import defpackage.ll2;

/* JADX INFO: loaded from: classes3.dex */
public class PhotoItemSelectedDialog extends DialogFragment implements View.OnClickListener {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private gv1 f299q;

    private void N() {
        Window window;
        Dialog dialogB = B();
        if (dialogB == null || (window = dialogB.getWindow()) == null) {
            return;
        }
        window.setLayout(ll2.c(getContext()), -2);
        window.setGravity(80);
        window.setWindowAnimations(R$style.PictureThemeDialogFragmentAnim);
    }

    public static PhotoItemSelectedDialog O() {
        return new PhotoItemSelectedDialog();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void M(FragmentManager fragmentManager, String str) {
        m mVarP = fragmentManager.p();
        mVarP.d(this, str);
        mVarP.i();
    }

    public void P(gv1 gv1Var) {
        this.f299q = gv1Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        gv1 gv1Var = this.f299q;
        if (gv1Var != null) {
            if (id == R$id.picture_tv_photo) {
                gv1Var.onItemClick(view, 0);
            }
            if (id == R$id.picture_tv_video) {
                this.f299q.onItemClick(view, 1);
            }
        }
        z();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (B() != null) {
            B().requestWindowFeature(1);
            if (B().getWindow() != null) {
                B().getWindow().setBackgroundDrawableResource(R.color.transparent);
            }
        }
        return layoutInflater.inflate(R$layout.picture_dialog_camera_selected, viewGroup);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        N();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R$id.picture_tv_photo);
        TextView textView2 = (TextView) view.findViewById(R$id.picture_tv_video);
        TextView textView3 = (TextView) view.findViewById(R$id.picture_tv_cancel);
        textView2.setOnClickListener(this);
        textView.setOnClickListener(this);
        textView3.setOnClickListener(this);
    }
}
