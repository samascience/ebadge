package defpackage;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.legend.smartwatch.electronicbadge.android.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class zv2 extends pg {
    TextView c;
    RecyclerView d;
    k5 e;
    private k5.a f;

    public zv2(View view, k5.a aVar) {
        super(view);
        this.c = (TextView) view.findViewById(R.id.tv_group_title);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_styles);
        this.d = recyclerView;
        this.f = aVar;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 0, false));
        k5 k5Var = new k5(new ArrayList());
        this.e = k5Var;
        k5Var.h(this.f);
        this.d.setAdapter(this.e);
    }

    @Override // defpackage.pg
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(xv2 xv2Var, int i) {
        this.c.setText(xv2Var.d());
        ArrayList arrayList = new ArrayList();
        for (aw2 aw2Var : xv2Var.c()) {
            ys0 ys0Var = new ys0();
            ys0Var.f(aw2Var.d());
            ys0Var.g(aw2Var.k());
            ys0Var.h(aw2Var.g());
            arrayList.add(ys0Var);
        }
        this.e.d().clear();
        this.e.d().addAll(arrayList);
        this.e.notifyDataSetChanged();
    }
}
