package defpackage;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ResolvedRecursiveType;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class yx {
    protected final yx a;
    protected final Class b;
    private ArrayList c;

    public yx(Class cls) {
        this(null, cls);
    }

    public void a(ResolvedRecursiveType resolvedRecursiveType) {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(resolvedRecursiveType);
    }

    public yx b(Class cls) {
        return new yx(this, cls);
    }

    public yx c(Class cls) {
        if (this.b == cls) {
            return this;
        }
        for (yx yxVar = this.a; yxVar != null; yxVar = yxVar.a) {
            if (yxVar.b == cls) {
                return yxVar;
            }
        }
        return null;
    }

    public void d(JavaType javaType) {
        ArrayList arrayList = this.c;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((ResolvedRecursiveType) it.next()).setReference(javaType);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ClassStack (self-refs: ");
        ArrayList arrayList = this.c;
        sb.append(arrayList == null ? "0" : String.valueOf(arrayList.size()));
        sb.append(')');
        for (yx yxVar = this; yxVar != null; yxVar = yxVar.a) {
            sb.append(' ');
            sb.append(yxVar.b.getName());
        }
        sb.append(']');
        return sb.toString();
    }

    private yx(yx yxVar, Class cls) {
        this.a = yxVar;
        this.b = cls;
    }
}
