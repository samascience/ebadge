package com.onmicro.omtoolbox.scanner;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.onmicro.omtoolbox.R$drawable;
import com.onmicro.omtoolbox.R$id;
import com.onmicro.omtoolbox.R$layout;
import com.onmicro.omtoolbox.R$string;
import defpackage.g3;
import defpackage.hj2;
import defpackage.o33;
import defpackage.pc0;
import defpackage.pj0;
import defpackage.q30;

/* JADX INFO: loaded from: classes3.dex */
public class ScannerFragment extends DialogFragment {
    private TextView H;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BluetoothAdapter f304q;
    private b r;
    private com.onmicro.omtoolbox.scanner.a s;
    private Button t;
    private boolean u;
    private String v;
    private boolean w;
    private int x;
    private View y;
    private boolean z = false;
    private final Handler F = new Handler(Looper.getMainLooper());
    private BluetoothAdapter.LeScanCallback G = new a();

    class a implements BluetoothAdapter.LeScanCallback {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i, BluetoothDevice bluetoothDevice) {
            if (!ScannerFragment.this.w || i >= ScannerFragment.this.x) {
                if (!ScannerFragment.this.u || TextUtils.isEmpty(ScannerFragment.this.v) || ScannerFragment.this.v.equals(bluetoothDevice.getName())) {
                    ScannerFragment.this.s.f(bluetoothDevice, i);
                }
            }
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(final BluetoothDevice bluetoothDevice, final int i, byte[] bArr) {
            ScannerFragment.this.F.post(new Runnable() { // from class: com.onmicro.omtoolbox.scanner.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(i, bluetoothDevice);
                }
            });
        }
    }

    public interface b {
        void b(pj0 pj0Var);

        void h();
    }

    public static ScannerFragment X() {
        return new ScannerFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(androidx.appcompat.app.b bVar, int i) {
        c0(false);
        bVar.dismiss();
        this.r.b(this.s.i(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(View view) {
        this.s.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(androidx.appcompat.app.b bVar, View view) {
        if (view.getId() == R$id.btn_cancel) {
            if (this.z) {
                bVar.cancel();
            } else {
                c0(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0() {
        if (this.z) {
            c0(false);
        }
    }

    private void c0(boolean z) {
        if (!z) {
            if (this.z) {
                this.z = false;
                this.t.setText(R$string.scan);
                this.f304q.stopLeScan(this.G);
                if (!this.s.h().isEmpty() || 4 == this.H.getVisibility()) {
                    return;
                }
                this.H.setVisibility(0);
                return;
            }
            return;
        }
        if (q30.a(requireContext(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
            if (g3.v(requireActivity(), "android.permission.ACCESS_FINE_LOCATION") && this.y.getVisibility() == 8) {
                this.y.setVisibility(0);
                return;
            } else {
                requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
                return;
            }
        }
        View view = this.y;
        if (view != null) {
            view.setVisibility(8);
        }
        this.z = true;
        this.s.clear();
        if (4 == this.H.getVisibility()) {
            this.H.setVisibility(4);
        }
        this.t.setText(R$string.cancel);
        this.f304q.startLeScan(this.G);
        this.F.postDelayed(new Runnable() { // from class: hk2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b0();
            }
        }, 5000L);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog E(Bundle bundle) {
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R$layout.fragment_device_select, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new pc0(getContext(), 1, R$drawable.divider));
        com.onmicro.omtoolbox.scanner.a aVar = new com.onmicro.omtoolbox.scanner.a();
        this.s = aVar;
        recyclerView.setAdapter(aVar);
        final androidx.appcompat.app.b bVarA = new androidx.appcompat.app.b.a(requireContext()).u(viewInflate).a();
        this.s.m(new com.onmicro.omtoolbox.scanner.a.d() { // from class: ik2
            @Override // com.onmicro.omtoolbox.scanner.a.d
            public final void a(int i) {
                this.a.Y(bVarA, i);
            }
        });
        viewInflate.findViewById(R$id.iv_sort).setOnClickListener(new View.OnClickListener() { // from class: jk2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Z(view);
            }
        });
        this.y = viewInflate.findViewById(R$id.permission_rationale);
        this.H = (TextView) viewInflate.findViewById(R$id.tv_empty);
        Button button = (Button) viewInflate.findViewById(R$id.btn_cancel);
        this.t = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: kk2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a0(bVarA, view);
            }
        });
        if (bundle == null) {
            c0(true);
        }
        return bVarA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.r = (b) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString() + " must implement OnDeviceSelectedListener");
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        this.r.h();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BluetoothManager bluetoothManager = (BluetoothManager) requireContext().getSystemService("bluetooth");
        if (bluetoothManager != null) {
            this.f304q = bluetoothManager.getAdapter();
        }
        this.u = hj2.a(getContext(), "is_filter_name", false);
        this.v = hj2.c(getContext(), "filter_name");
        this.w = hj2.a(getContext(), "is_filter_rssi", false);
        this.x = hj2.b(getContext(), "filter_rssi", -60);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        c0(false);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 1) {
            return;
        }
        if (iArr[0] == 0) {
            c0(true);
        } else {
            this.y.setVisibility(0);
            o33.b(getActivity(), getString(R$string.no_required_permission));
        }
    }
}
