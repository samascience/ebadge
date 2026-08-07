package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.phy.ota_demo.R$id;
import com.phy.ota_demo.R$layout;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class q02 extends RecyclerView.Adapter {
    private Context a;
    private List b;
    private fv1 c;

    static class a extends RecyclerView.ViewHolder {
        public ImageView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public ImageView e;
        public View f;

        public a(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R$id.iv_rssi);
            this.b = (TextView) view.findViewById(R$id.tv_rssi);
            this.c = (TextView) view.findViewById(R$id.tv_device_name);
            this.d = (TextView) view.findViewById(R$id.tv_device_address);
            this.e = (ImageView) view.findViewById(R$id.iv_check);
            this.f = view.findViewById(R$id.item_device);
        }
    }

    public q02(Context context, List list) {
        this.b = list;
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(a aVar, View view) {
        if (this.c != null) {
            this.c.onItemClick(view, aVar.getAdapterPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        o02 o02Var = (o02) this.b.get(i);
        aVar.b.setText(String.format(Locale.getDefault(), "%d dBm", Integer.valueOf(o02Var.n())));
        aVar.c.setText(o02Var.m());
        aVar.d.setText(o02Var.h());
        aVar.e.setVisibility(o02Var.t() ? 0 : 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        final a aVar = new a(LayoutInflater.from(this.a).inflate(R$layout.item_phy_device_list, (ViewGroup) null));
        aVar.f.setOnClickListener(new View.OnClickListener() { // from class: p02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.d(aVar, view);
            }
        });
        return aVar;
    }

    public void g(fv1 fv1Var) {
        this.c = fv1Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }
}
