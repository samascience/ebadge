package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.phy.ota_demo.R$id;
import com.phy.ota_demo.R$layout;
import com.phy.otalib.model.OTAType;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class t93 extends RecyclerView.Adapter {
    private List a;

    static class a extends RecyclerView.ViewHolder {
        TextView a;
        TextView b;
        TextView c;

        public a(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.tv_device_name);
            this.b = (TextView) view.findViewById(R$id.tv_device_address);
            this.c = (TextView) view.findViewById(R$id.tv_status);
        }
    }

    public t93(List list) {
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        o02 o02Var = (o02) this.a.get(i);
        aVar.a.setText(o02Var.m());
        aVar.b.setText(o02Var.h());
        if (o02Var.k() != OTAType.OnOTAUpgrade || o02Var.l() <= 0.0f) {
            aVar.c.setText(o02Var.j());
        } else {
            aVar.c.setText(String.format("%s%%", Integer.valueOf((int) o02Var.l())));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_upgrade_device_plus_list, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }
}
