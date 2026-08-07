package defpackage;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class o61 extends u51 {
    private final LinkedTreeMap a = new LinkedTreeMap(false);

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o61) && ((o61) obj).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void j(String str, u51 u51Var) {
        LinkedTreeMap linkedTreeMap = this.a;
        if (u51Var == null) {
            u51Var = l61.a;
        }
        linkedTreeMap.put(str, u51Var);
    }

    public void k(String str, Boolean bool) {
        j(str, bool == null ? l61.a : new v61(bool));
    }

    public void l(String str, Character ch) {
        j(str, ch == null ? l61.a : new v61(ch));
    }

    public void m(String str, Number number) {
        j(str, number == null ? l61.a : new v61(number));
    }

    public void n(String str, String str2) {
        j(str, str2 == null ? l61.a : new v61(str2));
    }

    public Set o() {
        return this.a.entrySet();
    }

    public u51 p(String str) {
        return (u51) this.a.get(str);
    }

    public o61 q(String str) {
        return (o61) this.a.get(str);
    }

    public boolean r(String str) {
        return this.a.containsKey(str);
    }

    public u51 s(String str) {
        return (u51) this.a.remove(str);
    }

    public int size() {
        return this.a.size();
    }
}
