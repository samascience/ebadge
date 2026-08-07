package yqy.yichip.ota3genbandupgrade.fragment;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import java.util.Objects;
import yqy.yichip.ota3genbandupgrade.R$id;
import yqy.yichip.ota3genbandupgrade.R$layout;

/* JADX INFO: loaded from: classes4.dex */
public class LoadingDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f448q = "正在加载";
    private boolean r = true;
    private TextView s;

    public LoadingDialogFragment N(String str) {
        this.f448q = str;
        TextView textView = this.s;
        if (textView != null) {
            textView.setText(str);
        }
        return this;
    }

    public LoadingDialogFragment O(boolean z) {
        this.r = z;
        if (B() != null) {
            B().setCanceledOnTouchOutside(z);
        }
        return this;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialogB = B();
        Objects.requireNonNull(dialogB);
        Window window = dialogB.getWindow();
        Objects.requireNonNull(window);
        window.setBackgroundDrawableResource(R.color.transparent);
        B().requestWindowFeature(1);
        B().setCanceledOnTouchOutside(this.r);
        View viewInflate = layoutInflater.inflate(R$layout.layout_dialog_loading, viewGroup);
        TextView textView = (TextView) viewInflate.findViewById(R$id.textView);
        this.s = textView;
        textView.setText(this.f448q);
        B().setCancelable(false);
        return viewInflate;
    }
}
