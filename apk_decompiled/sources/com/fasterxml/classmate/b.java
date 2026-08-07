package com.fasterxml.classmate;

import com.tencent.connect.common.Constants;
import defpackage.og2;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static final String[] e;
    private static final og2[] f;
    private static final b g;
    private final String[] a;
    private final og2[] b;
    private final String[] c;
    private final int d;

    static {
        String[] strArr = new String[0];
        e = strArr;
        og2[] og2VarArr = new og2[0];
        f = og2VarArr;
        g = new b(strArr, og2VarArr, null);
    }

    private b(String[] strArr, og2[] og2VarArr, String[] strArr2) {
        strArr = strArr == null ? e : strArr;
        this.a = strArr;
        og2VarArr = og2VarArr == null ? f : og2VarArr;
        this.b = og2VarArr;
        if (strArr.length != og2VarArr.length) {
            throw new IllegalArgumentException("Mismatching names (" + strArr.length + "), types (" + og2VarArr.length + ")");
        }
        int length = og2VarArr.length;
        int iHashCode = 1;
        for (int i = 0; i < length; i++) {
            iHashCode += this.b[i].hashCode();
        }
        this.c = strArr2;
        this.d = iHashCode;
    }

    public static b a(Class cls, og2[] og2VarArr) {
        String[] strArr;
        if (og2VarArr == null) {
            og2VarArr = f;
        }
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null || typeParameters.length == 0) {
            strArr = e;
        } else {
            int length = typeParameters.length;
            strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = typeParameters[i].getName();
            }
        }
        if (strArr.length == og2VarArr.length) {
            return new b(strArr, og2VarArr, null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can not create TypeBinding for class ");
        sb.append(cls.getName());
        sb.append(" with ");
        sb.append(og2VarArr.length);
        sb.append(" type parameter");
        sb.append(og2VarArr.length == 1 ? Constants.STR_EMPTY : "s");
        sb.append(": class expects ");
        sb.append(strArr.length);
        throw new IllegalArgumentException(sb.toString());
    }

    public static b b() {
        return g;
    }

    public og2 c(String str) {
        int length = this.a.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(this.a[i])) {
                return this.b[i];
            }
        }
        return null;
    }

    public og2 d(int i) {
        if (i < 0) {
            return null;
        }
        og2[] og2VarArr = this.b;
        if (i >= og2VarArr.length) {
            return null;
        }
        return og2VarArr[i];
    }

    public List e() {
        og2[] og2VarArr = this.b;
        return og2VarArr.length == 0 ? Collections.emptyList() : Arrays.asList(og2VarArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != b.class) {
            return false;
        }
        b bVar = (b) obj;
        int length = this.b.length;
        if (length != bVar.h()) {
            return false;
        }
        og2[] og2VarArr = bVar.b;
        for (int i = 0; i < length; i++) {
            if (!og2VarArr[i].equals(this.b[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean f(String str) {
        String[] strArr = this.c;
        if (strArr == null) {
            return false;
        }
        int length = strArr.length;
        do {
            length--;
            if (length < 0) {
                return false;
            }
        } while (!str.equals(this.c[length]));
        return true;
    }

    public boolean g() {
        return this.b.length == 0;
    }

    public int h() {
        return this.b.length;
    }

    public int hashCode() {
        return this.d;
    }

    protected og2[] i() {
        return this.b;
    }

    public b j(String str) {
        String[] strArr = this.c;
        int length = strArr == null ? 0 : strArr.length;
        String[] strArr2 = length == 0 ? new String[1] : (String[]) Arrays.copyOf(strArr, length + 1);
        strArr2[length] = str;
        return new b(this.a, this.b, strArr2);
    }

    public String toString() {
        if (this.b.length == 0) {
            return Constants.STR_EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        int length = this.b.length;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb = this.b[i].b(sb);
        }
        sb.append('>');
        return sb.toString();
    }
}
