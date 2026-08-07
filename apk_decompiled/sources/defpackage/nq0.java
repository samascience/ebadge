package defpackage;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.legend.smartwatch.electronicbadge.android.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class nq0 extends RecyclerView.Adapter {
    private List a = new ArrayList();
    private int b = wa3.b(35.0f);

    public class a extends RecyclerView.ViewHolder {
        private final ImageView a;

        public a(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R.id.mIv);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        com.bumptech.glide.a.t(com.blankj.utilcode.util.a.g()).r((String) this.a.get(i)).u0(aVar.a);
        ViewGroup.LayoutParams layoutParams = aVar.a.getLayoutParams();
        layoutParams.width = this.b;
        aVar.a.setLayoutParams(layoutParams);
        Log.i("TAG", "onBindViewHolder: " + getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frames_item_layout, viewGroup, false));
    }

    public void e(int i) {
        this.b = i;
    }

    public void f(int i, String str) {
        this.a.set(i, str);
        notifyItemChanged(i);
    }

    public void g(List list) {
        this.a.clear();
        this.a.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }
}
