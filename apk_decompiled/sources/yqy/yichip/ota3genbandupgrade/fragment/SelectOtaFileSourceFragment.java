package yqy.yichip.ota3genbandupgrade.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import yqy.yichip.ota3genbandupgrade.R$id;
import yqy.yichip.ota3genbandupgrade.R$layout;
import yqy.yichip.ota3genbandupgrade.R$style;

/* JADX INFO: loaded from: classes4.dex */
public class SelectOtaFileSourceFragment extends DialogFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private e f450q;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectOtaFileSourceFragment.this.y();
            if (SelectOtaFileSourceFragment.this.f450q != null) {
                SelectOtaFileSourceFragment.this.f450q.a(1);
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectOtaFileSourceFragment.this.y();
            if (SelectOtaFileSourceFragment.this.f450q != null) {
                SelectOtaFileSourceFragment.this.f450q.a(2);
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectOtaFileSourceFragment.this.y();
            if (SelectOtaFileSourceFragment.this.f450q != null) {
                SelectOtaFileSourceFragment.this.f450q.a(3);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectOtaFileSourceFragment.this.y();
        }
    }

    public interface e {
        void a(int i);

        void b();
    }

    public static SelectOtaFileSourceFragment O() {
        return new SelectOtaFileSourceFragment();
    }

    public void P(e eVar) {
        this.f450q = eVar;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        K(2, R$style.DialogFloat);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_select_ota_file_source, viewGroup, false);
        Button button = (Button) viewInflate.findViewById(R$id.btn_cancel);
        TextView textView = (TextView) viewInflate.findViewById(R$id.tv_file_local_manage);
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.tv_file_local_fixed);
        TextView textView3 = (TextView) viewInflate.findViewById(R$id.tv_file_server);
        textView.setOnClickListener(new a());
        textView2.setOnClickListener(new b());
        textView3.setOnClickListener(new c());
        button.setOnClickListener(new d());
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        e eVar = this.f450q;
        if (eVar != null) {
            eVar.b();
        }
    }
}
