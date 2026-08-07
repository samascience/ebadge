package androidx.preference;

import android.R;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class d extends RecyclerView.ViewHolder {
    private final SparseArray a;
    private boolean b;
    private boolean c;

    d(View view) {
        super(view);
        SparseArray sparseArray = new SparseArray(4);
        this.a = sparseArray;
        sparseArray.put(R.id.title, view.findViewById(R.id.title));
        sparseArray.put(R.id.summary, view.findViewById(R.id.summary));
        sparseArray.put(R.id.icon, view.findViewById(R.id.icon));
        int i = R$id.icon_frame;
        sparseArray.put(i, view.findViewById(i));
        sparseArray.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
    }

    public View a(int i) {
        View view = (View) this.a.get(i);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.itemView.findViewById(i);
        if (viewFindViewById != null) {
            this.a.put(i, viewFindViewById);
        }
        return viewFindViewById;
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public void d(boolean z) {
        this.b = z;
    }

    public void e(boolean z) {
        this.c = z;
    }
}
