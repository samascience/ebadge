package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class c92 extends RecyclerView.Adapter {
    private List a;

    public static final class a extends RecyclerView.ViewHolder {
        private final TextView a;
        private final TextView b;
        private final TextView c;
        private final TextView d;
        private final TextView e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            p31.f(view, "itemView");
            View viewFindViewById = view.findViewById(R.id.tv_log_type);
            p31.e(viewFindViewById, "findViewById(...)");
            this.a = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.tv_log_time);
            p31.e(viewFindViewById2, "findViewById(...)");
            this.b = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.tv_log_content);
            p31.e(viewFindViewById3, "findViewById(...)");
            this.c = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.tv_log_details);
            p31.e(viewFindViewById4, "findViewById(...)");
            this.d = (TextView) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.tv_log_hex_data);
            p31.e(viewFindViewById5, "findViewById(...)");
            this.e = (TextView) viewFindViewById5;
        }

        public final void a(d92 d92Var) {
            p31.f(d92Var, "logItem");
            this.a.setText(d92Var.e().getDisplayName());
            this.a.setBackgroundColor(q30.c(this.itemView.getContext(), d92Var.e().getColorRes()));
            this.b.setText(d92Var.c());
            this.c.setText(d92Var.a());
            TextView textView = this.d;
            String strB = d92Var.b();
            String str = Constants.STR_EMPTY;
            if (strB == null) {
                strB = Constants.STR_EMPTY;
            }
            textView.setText(strB);
            TextView textView2 = this.d;
            String strB2 = d92Var.b();
            textView2.setVisibility((strB2 == null || strB2.length() == 0) ? 8 : 0);
            TextView textView3 = this.e;
            String strD = d92Var.d();
            if (strD != null) {
                str = strD;
            }
            textView3.setText(str);
            TextView textView4 = this.e;
            String strD2 = d92Var.d();
            textView4.setVisibility((strD2 == null || strD2.length() == 0) ? 8 : 0);
        }
    }

    public c92(List list) {
        p31.f(list, "logItems");
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        p31.f(aVar, "holder");
        aVar.a((d92) this.a.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        p31.f(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_protocol_log, viewGroup, false);
        p31.c(viewInflate);
        return new a(viewInflate);
    }

    public final void e(List list) {
        p31.f(list, "newLogs");
        this.a.clear();
        this.a.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }
}
