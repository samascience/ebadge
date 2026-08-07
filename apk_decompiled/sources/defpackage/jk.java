package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import com.legend.smartwatch.electronicbadge.android.R;
import java.util.List;
import kotlin.collections.j;
import xfkj.fitpro.model.BluetoothDeviceInfo;

/* JADX INFO: loaded from: classes4.dex */
public final class jk extends RecyclerView.Adapter {
    private List a;
    private final ar0 b;

    public final class a extends RecyclerView.ViewHolder {
        private final t31 a;
        final /* synthetic */ jk b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(jk jkVar, t31 t31Var) {
            super(t31Var.getRoot());
            p31.f(t31Var, "binding");
            this.b = jkVar;
            this.a = t31Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(jk jkVar, BluetoothDeviceInfo bluetoothDeviceInfo, View view) {
            jkVar.b.invoke(bluetoothDeviceInfo);
        }

        public final void b(final BluetoothDeviceInfo bluetoothDeviceInfo) {
            p31.f(bluetoothDeviceInfo, "device");
            this.a.K(bluetoothDeviceInfo);
            View root = this.a.getRoot();
            final jk jkVar = this.b;
            root.setOnClickListener(new View.OnClickListener() { // from class: ik
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    jk.a.c(jkVar, bluetoothDeviceInfo, view);
                }
            });
            this.a.j();
        }
    }

    public /* synthetic */ jk(List list, ar0 ar0Var, int i, y70 y70Var) {
        this((i & 1) != 0 ? j.j() : list, ar0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        p31.f(aVar, "holder");
        aVar.b((BluetoothDeviceInfo) this.a.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        p31.f(viewGroup, "parent");
        t31 t31Var = (t31) e.e(LayoutInflater.from(viewGroup.getContext()), R.layout.item_bluetooth_device_simple, viewGroup, false);
        p31.c(t31Var);
        return new a(this, t31Var);
    }

    public final void f(List list) {
        p31.f(list, "newDeviceList");
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    public jk(List list, ar0 ar0Var) {
        p31.f(list, "deviceList");
        p31.f(ar0Var, "onDeviceClick");
        this.a = list;
        this.b = ar0Var;
    }
}
