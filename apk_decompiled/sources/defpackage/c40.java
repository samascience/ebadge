package defpackage;

import android.view.View;
import com.legend.smartwatch.electronicbadge.android.R;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class c40 extends t70 {
    public c40(List list) {
        super(list);
    }

    @Override // defpackage.t70
    public pg c(View view, int i) {
        return new a40(view, d());
    }

    @Override // defpackage.t70
    public int e(int i) {
        return R.layout.layout_item_contract;
    }
}
