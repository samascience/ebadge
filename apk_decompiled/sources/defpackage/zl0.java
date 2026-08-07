package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.phy.ota_demo.R$id;
import com.phy.ota_demo.R$layout;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zl0 extends RecyclerView.Adapter {
    private List a;
    private fv1 b;
    private ev1 c;

    static class a extends RecyclerView.ViewHolder {
        public TextView a;
        public TextView b;
        public TextView c;

        public a(View view) {
            super(view);
            this.c = (TextView) view.findViewById(R$id.tv_file_name);
            this.b = (TextView) view.findViewById(R$id.tv_file_path);
            this.a = (TextView) view.findViewById(R$id.tv_delete);
        }
    }

    public zl0(List list) {
        this.a = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(a aVar, View view) {
        this.b.onItemClick(aVar.itemView, aVar.getLayoutPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(a aVar, View view) {
        fv1 fv1Var = this.b;
        if (fv1Var != null) {
            fv1Var.onItemClick(view, aVar.getAdapterPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(a aVar, View view) {
        ev1 ev1Var = this.c;
        if (ev1Var != null) {
            ev1Var.a(view, aVar.getAdapterPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final a aVar, int i) {
        u93 u93Var = (u93) this.a.get(i);
        aVar.c.setText(u93Var.a().getName());
        aVar.b.setText(u93Var.a().getPath());
        if (this.b != null) {
            aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: yl0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.f(aVar, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_file_list, (ViewGroup) null);
        final a aVar = new a(viewInflate);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: wl0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.g(aVar, view);
            }
        });
        aVar.a.setOnClickListener(new View.OnClickListener() { // from class: xl0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.h(aVar, view);
            }
        });
        return aVar;
    }

    public void k(ev1 ev1Var) {
        this.c = ev1Var;
    }

    public void l(fv1 fv1Var) {
        this.b = fv1Var;
    }
}
