package defpackage;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class s53 {
    public View b;
    public final Map a = new HashMap();
    final ArrayList c = new ArrayList();

    public s53(View view) {
        this.b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s53)) {
            return false;
        }
        s53 s53Var = (s53) obj;
        return this.b == s53Var.b && this.a.equals(s53Var.a);
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + this.a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.b + "\n") + "    values:";
        for (String str2 : this.a.keySet()) {
            str = str + "    " + str2 + ": " + this.a.get(str2) + "\n";
        }
        return str;
    }
}
