package defpackage;

import com.fasterxml.classmate.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class lg2 extends og2 {
    private static final lg2 i = new lg2(Void.TYPE, 'V', "void");
    protected final String g;
    protected final String h;

    protected lg2(Class cls, char c, String str) {
        super(cls, b.b());
        this.g = String.valueOf(c);
        this.h = str;
    }

    public static List n() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new lg2(Boolean.TYPE, 'Z', "boolean"));
        arrayList.add(new lg2(Byte.TYPE, 'B', "byte"));
        arrayList.add(new lg2(Short.TYPE, 'S', "short"));
        arrayList.add(new lg2(Character.TYPE, 'C', "char"));
        arrayList.add(new lg2(Integer.TYPE, 'I', "int"));
        arrayList.add(new lg2(Long.TYPE, 'J', "long"));
        arrayList.add(new lg2(Float.TYPE, 'F', "float"));
        arrayList.add(new lg2(Double.TYPE, 'D', "double"));
        return arrayList;
    }

    public static lg2 o() {
        return i;
    }

    @Override // defpackage.og2
    public StringBuilder b(StringBuilder sb) {
        sb.append(this.h);
        return sb;
    }

    @Override // defpackage.og2
    public StringBuilder c(StringBuilder sb) {
        sb.append(this.h);
        return sb;
    }

    @Override // defpackage.og2
    public boolean d() {
        return false;
    }

    @Override // defpackage.og2
    public String h() {
        return this.h;
    }

    @Override // defpackage.og2
    public List i() {
        return Collections.emptyList();
    }

    @Override // defpackage.og2
    public og2 j() {
        return null;
    }

    @Override // defpackage.og2
    public og2 k() {
        return null;
    }
}
