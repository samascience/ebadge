package defpackage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class og extends jq0 {
    List h;
    private List i;

    public og(FragmentManager fragmentManager, List list) {
        super(fragmentManager);
        new ArrayList();
        this.h = list;
    }

    @Override // androidx.viewpager.widget.a
    public int d() {
        return this.h.size();
    }

    @Override // androidx.viewpager.widget.a
    public CharSequence f(int i) {
        return !fz.a(this.i) ? (CharSequence) this.i.get(i) : Constants.STR_EMPTY;
    }

    @Override // defpackage.jq0
    public Fragment t(int i) {
        return (Fragment) this.h.get(i);
    }
}
