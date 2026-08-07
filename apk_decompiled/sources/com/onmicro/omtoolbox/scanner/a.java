package com.onmicro.omtoolbox.scanner;

import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import com.onmicro.omtoolbox.R$layout;
import com.onmicro.omtoolbox.scanner.a;
import defpackage.pj0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class a extends RecyclerView.Adapter {
    private boolean b;
    private d e;
    private List a = new ArrayList();
    private View.OnClickListener c = new ViewOnClickListenerC0101a();
    private View.OnTouchListener d = new b();

    /* JADX INFO: renamed from: com.onmicro.omtoolbox.scanner.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0101a implements View.OnClickListener {
        ViewOnClickListenerC0101a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.e != null) {
                a.this.e.a(((Integer) view.getTag()).intValue());
            }
        }
    }

    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                a.this.b = true;
            } else if (action == 1 || action == 3) {
                a.this.b = false;
            }
            return false;
        }
    }

    class c extends RecyclerView.ViewHolder {
        TextView a;
        TextView b;
        TextView c;

        public c(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface d {
        void a(int i);
    }

    private pj0 g(BluetoothDevice bluetoothDevice) {
        List list = this.a;
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (pj0 pj0Var : this.a) {
            if (pj0Var.a(bluetoothDevice)) {
                return pj0Var;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int j(pj0 pj0Var, pj0 pj0Var2) {
        return pj0Var2.b - pj0Var.b;
    }

    public void clear() {
        this.a.clear();
        notifyDataSetChanged();
    }

    public void f(BluetoothDevice bluetoothDevice, int i) {
        pj0 pj0VarG = g(bluetoothDevice);
        if (pj0VarG == null) {
            this.a.add(new pj0(bluetoothDevice, i));
        } else {
            pj0VarG.b = i;
        }
        if (this.b) {
            return;
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List h() {
        return this.a;
    }

    public pj0 i(int i) {
        return (pj0) this.a.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i) {
        cVar.itemView.setTag(Integer.valueOf(i));
        pj0 pj0Var = (pj0) this.a.get(i);
        BluetoothDevice bluetoothDevice = pj0Var.a;
        String name = bluetoothDevice.getName();
        String address = bluetoothDevice.getAddress();
        TextView textView = cVar.a;
        if (TextUtils.isEmpty(name)) {
            name = "N/Y";
        }
        textView.setText(name);
        cVar.b.setText(address);
        cVar.c.setText(String.format(Locale.ROOT, "%ddBm", Integer.valueOf(pj0Var.b)));
        cVar.itemView.setOnClickListener(this.c);
        cVar.itemView.setOnTouchListener(this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.recy_item_device_list, viewGroup, false));
    }

    public void m(d dVar) {
        this.e = dVar;
    }

    public void n() {
        Collections.sort(this.a, new Comparator() { // from class: qa0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return a.j((pj0) obj, (pj0) obj2);
            }
        });
        notifyDataSetChanged();
    }
}
