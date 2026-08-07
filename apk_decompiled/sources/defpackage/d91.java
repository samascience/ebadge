package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes.dex */
public class d91 {
    private final List a;
    private e91 b;

    public d91(String... strArr) {
        this.a = Arrays.asList(strArr);
    }

    private boolean b() {
        List list = this.a;
        return ((String) list.get(list.size() - 1)).equals("**");
    }

    private boolean f(String str) {
        return str.equals("__container");
    }

    public d91 a(String str) {
        d91 d91Var = new d91(this);
        d91Var.a.add(str);
        return d91Var;
    }

    public boolean c(String str, int i) {
        if (i >= this.a.size()) {
            return false;
        }
        boolean z = i == this.a.size() - 1;
        String str2 = (String) this.a.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.a.size() + (-2) && b())) && (str2.equals(str) || str2.equals(Marker.ANY_MARKER));
        }
        if (!z && ((String) this.a.get(i + 1)).equals(str)) {
            return i == this.a.size() + (-2) || (i == this.a.size() + (-3) && b());
        }
        if (z) {
            return true;
        }
        int i2 = i + 1;
        if (i2 < this.a.size() - 1) {
            return false;
        }
        return ((String) this.a.get(i2)).equals(str);
    }

    public e91 d() {
        return this.b;
    }

    public int e(String str, int i) {
        if (f(str)) {
            return 0;
        }
        if (((String) this.a.get(i)).equals("**")) {
            return (i != this.a.size() - 1 && ((String) this.a.get(i + 1)).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean g(String str, int i) {
        if (f(str)) {
            return true;
        }
        if (i >= this.a.size()) {
            return false;
        }
        return ((String) this.a.get(i)).equals(str) || ((String) this.a.get(i)).equals("**") || ((String) this.a.get(i)).equals(Marker.ANY_MARKER);
    }

    public boolean h(String str, int i) {
        return str.equals("__container") || i < this.a.size() - 1 || ((String) this.a.get(i)).equals("**");
    }

    public d91 i(e91 e91Var) {
        d91 d91Var = new d91(this);
        d91Var.b = e91Var;
        return d91Var;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.a);
        sb.append(",resolved=");
        sb.append(this.b != null);
        sb.append('}');
        return sb.toString();
    }

    private d91(d91 d91Var) {
        this.a = new ArrayList(d91Var.a);
        this.b = d91Var.b;
    }
}
