package defpackage;

import com.tencent.connect.common.Constants;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class fa implements ei3 {
    private List a;

    public fa(List list) {
        this.a = list;
    }

    @Override // defpackage.ei3
    public int a() {
        return this.a.size();
    }

    @Override // defpackage.ei3
    public Object getItem(int i) {
        return (i < 0 || i >= this.a.size()) ? Constants.STR_EMPTY : this.a.get(i);
    }
}
