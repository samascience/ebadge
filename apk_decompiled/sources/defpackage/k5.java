package defpackage;

import android.view.View;
import com.legend.smartwatch.electronicbadge.android.R;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class k5 extends t70 {
    private a c;

    public interface a {
        void a(aw2 aw2Var);
    }

    public k5(List list) {
        super(list);
    }

    @Override // defpackage.t70
    public pg c(View view, int i) {
        return new l5(view, this.c);
    }

    @Override // defpackage.t70
    public int e(int i) {
        return R.layout.item_style;
    }

    public void h(a aVar) {
        this.c = aVar;
    }
}
