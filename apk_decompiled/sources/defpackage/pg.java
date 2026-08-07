package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes4.dex */
public abstract class pg extends RecyclerView.ViewHolder implements View.OnClickListener {
    protected a a;
    protected final String b;

    public interface a {
        void a(View view, int i);
    }

    public pg(View view) {
        super(view);
        this.a = null;
        this.b = getClass().getSimpleName();
        view.setOnClickListener(this);
    }

    public abstract void a(Object obj, int i);

    public void b(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(view, getPosition());
        }
    }
}
