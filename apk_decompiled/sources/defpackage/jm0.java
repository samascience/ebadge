package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.onmicro.omtoolbox.R$id;
import com.onmicro.omtoolbox.R$layout;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class jm0 extends RecyclerView.Adapter {
    private List a;
    private View.OnClickListener b = new a();
    private c c;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (jm0.this.c != null) {
                jm0.this.c.a(((Integer) view.getTag()).intValue());
            }
        }
    }

    class b extends RecyclerView.ViewHolder {
        private TextView a;

        public b(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.tv_file_name);
        }
    }

    public interface c {
        void a(int i);
    }

    public jm0(List list) {
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i) {
        bVar.itemView.setTag(Integer.valueOf(i));
        e43.a(this.a.get(i));
        TextView unused = bVar.a;
        Locale locale = Locale.ROOT;
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.recy_item_file_list, viewGroup, false);
        viewInflate.setOnClickListener(this.b);
        return new b(viewInflate);
    }

    public void f(c cVar) {
        this.c = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
