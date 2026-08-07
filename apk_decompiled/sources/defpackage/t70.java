package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class t70 extends RecyclerView.Adapter {
    protected List a;
    private pg b;

    class a implements pg.a {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // pg.a
        public void a(View view, int i) {
            t70.this.getClass();
        }
    }

    public t70(List list) {
        this.a = list;
    }

    public abstract pg c(View view, int i);

    public List d() {
        return this.a;
    }

    public abstract int e(int i);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(pg pgVar, int i) {
        pgVar.a(this.a.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public pg onCreateViewHolder(ViewGroup viewGroup, int i) {
        pg pgVarC = c(LayoutInflater.from(viewGroup.getContext()).inflate(e(i), viewGroup, false), i);
        this.b = pgVarC;
        pgVarC.b(new a(i));
        return this.b;
    }

    public Object getItem(int i) {
        List list = this.a;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }
}
