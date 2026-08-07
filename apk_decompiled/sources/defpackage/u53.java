package defpackage;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes4.dex */
public final class u53 extends cg {

    public final class a extends cg.a {
        private final w31 a;
        final /* synthetic */ u53 b;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(u53 u53Var, w31 w31Var) {
            p31.f(w31Var, "binding");
            this.b = u53Var;
            LinearLayout root = w31Var.getRoot();
            p31.e(root, "getRoot(...)");
            super(root);
            this.a = w31Var;
        }

        @Override // cg.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(v53 v53Var, int i) {
            p31.f(v53Var, "item");
            this.a.b.setText(v53Var.a());
            this.a.c.setText(v53Var.b());
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
        w31 w31VarInflate = w31.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        p31.e(w31VarInflate, "inflate(...)");
        return new a(this, w31VarInflate);
    }
}
