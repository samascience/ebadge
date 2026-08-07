package defpackage;

import android.view.View;
import com.legend.smartwatch.electronicbadge.android.R;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class yv2 extends t70 {
    private k5.a c;

    public yv2(List list) {
        super(list);
    }

    @Override // defpackage.t70
    public pg c(View view, int i) {
        return new zv2(view, this.c);
    }

    @Override // defpackage.t70
    public int e(int i) {
        return R.layout.item_style_group;
    }

    public void h(k5.a aVar) {
        this.c = aVar;
    }
}
