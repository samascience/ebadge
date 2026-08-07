package defpackage;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class da1 extends cg {

    public final class a extends cg.a {
        private final v31 a;
        final /* synthetic */ da1 b;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(da1 da1Var, v31 v31Var) {
            p31.f(v31Var, "binding");
            this.b = da1Var;
            LinearLayout root = v31Var.getRoot();
            p31.e(root, "getRoot(...)");
            super(root);
            this.a = v31Var;
        }

        @Override // cg.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ea1 ea1Var, int i) {
            p31.f(ea1Var, "item");
            this.a.b.setText(ea1Var.a());
            this.a.c.setText(ea1Var.b());
        }
    }

    @Override // defpackage.cg, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return super.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        p31.f(viewGroup, "parent");
        v31 v31VarInflate = v31.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        p31.e(v31VarInflate, "inflate(...)");
        return new a(this, v31VarInflate);
    }

    public final void j(List list) {
        p31.f(list, "newData");
        setData(list);
    }
}
