package yqy.yichip.ota3genbandupgrade.fragment;

import android.R;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import androidx.fragment.app.DialogFragment;
import defpackage.ba1;
import defpackage.hj0;
import java.util.ArrayList;
import java.util.List;
import yqy.yichip.ota3genbandupgrade.R$id;
import yqy.yichip.ota3genbandupgrade.R$layout;
import yqy.yichip.ota3genbandupgrade.R$style;

/* JADX INFO: loaded from: classes4.dex */
public class ScannerBleFragment extends DialogFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ba1 f449q;
    private b r;
    private ProgressBar s;
    private LinearLayout t;
    private List u;
    private ba1 v;
    private String w;
    boolean x;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ScannerBleFragment.this.y();
        }
    }

    public interface b {
        void a();

        void b(BluetoothDevice bluetoothDevice);
    }

    private ScannerBleFragment(List list, String str) {
        new ArrayList();
        this.x = false;
        this.u = list;
        this.w = str;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Log.d("ScannerBleFragment", "已配对的设备 ： " + ((BluetoothDevice) list.get(i)).getAddress());
        }
    }

    public static ScannerBleFragment P(List list, String str) {
        return new ScannerBleFragment(list, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(BluetoothDevice bluetoothDevice, int i) {
        this.f449q.a(new hj0(bluetoothDevice, i));
        String str = this.w;
        if (str == null || !str.equalsIgnoreCase(bluetoothDevice.getAddress()) || this.x) {
            return;
        }
        this.x = true;
        Log.i("addScannedDevice", "=============================addScannedDevice");
        if (this.r != null) {
            y();
            this.r.b(bluetoothDevice);
        }
    }

    private void T() {
        List list = this.u;
        if (list == null || list.size() <= 0) {
            this.t.setVisibility(8);
            return;
        }
        this.t.setVisibility(0);
        for (int i = 0; i < this.u.size(); i++) {
            this.v.a(new hj0((BluetoothDevice) this.u.get(i), 0));
        }
    }

    public void O(final BluetoothDevice bluetoothDevice, final int i) {
        requireActivity().runOnUiThread(new Runnable() { // from class: gk2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.R(bluetoothDevice, i);
            }
        });
    }

    public void Q() {
        this.s.setVisibility(4);
    }

    public void S(b bVar) {
        this.r = bVar;
    }

    public void U() {
        this.s.setVisibility(0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        K(2, R$style.DialogFullScreen);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_ble_scanner, viewGroup, false);
        this.t = (LinearLayout) viewInflate.findViewById(R$id.ll_bonded_devices);
        ListView listView = (ListView) viewInflate.findViewById(R$id.lv_bonded_devices);
        ListView listView2 = (ListView) viewInflate.findViewById(R.id.list);
        Button button = (Button) viewInflate.findViewById(R$id.btn_cancel);
        this.s = (ProgressBar) viewInflate.findViewById(R$id.progress_bar);
        this.f449q = new ba1(getActivity());
        listView2.setEmptyView(viewInflate.findViewById(R.id.empty));
        listView2.setAdapter((ListAdapter) this.f449q);
        this.v = new ba1(getActivity());
        listView.setEmptyView(viewInflate.findViewById(R.id.empty));
        listView.setAdapter((ListAdapter) this.v);
        T();
        button.setOnClickListener(new a());
        U();
        B().setCancelable(false);
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        b bVar = this.r;
        if (bVar != null) {
            bVar.a();
        }
    }
}
