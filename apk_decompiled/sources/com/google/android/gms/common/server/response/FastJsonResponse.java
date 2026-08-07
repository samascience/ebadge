package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.converter.zaa;
import defpackage.a52;
import defpackage.nj2;
import defpackage.sf1;
import defpackage.st1;
import defpackage.v71;
import defpackage.zf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class FastJsonResponse {

    public interface a {
        Object u(Object obj);
    }

    private static void f(StringBuilder sb, Field field, Object obj) {
        int i = field.b;
        if (i == 11) {
            sb.append(((FastJsonResponse) field.h.cast(obj)).toString());
        } else {
            if (i != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(v71.a((String) obj));
            sb.append("\"");
        }
    }

    protected static Object g(Field field, Object obj) {
        return field.k != null ? field.u(obj) : obj;
    }

    public abstract Map a();

    protected Object b(Field field) {
        String str = field.f;
        if (field.h == null) {
            return c(str);
        }
        a52.k(c(str) == null, "Concrete field shouldn't be value object: %s", field.f);
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String strSubstring = str.substring(1);
            StringBuilder sb = new StringBuilder(String.valueOf(strSubstring).length() + 4);
            sb.append("get");
            sb.append(upperCase);
            sb.append(strSubstring);
            return getClass().getMethod(sb.toString(), null).invoke(this, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract Object c(String str);

    protected boolean d(Field field) {
        if (field.d != 11) {
            return e(field.f);
        }
        if (field.e) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected abstract boolean e(String str);

    public String toString() {
        Map mapA = a();
        StringBuilder sb = new StringBuilder(100);
        for (String str : mapA.keySet()) {
            Field field = (Field) mapA.get(str);
            if (d(field)) {
                Object objG = g(field, b(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (objG != null) {
                    switch (field.d) {
                        case 8:
                            sb.append("\"");
                            sb.append(zf.a((byte[]) objG));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(zf.b((byte[]) objG));
                            sb.append("\"");
                            break;
                        case 10:
                            sf1.a(sb, (HashMap) objG);
                            break;
                        default:
                            if (field.c) {
                                ArrayList arrayList = (ArrayList) objG;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    if (i > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i);
                                    if (obj != null) {
                                        f(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                            } else {
                                f(sb, field, objG);
                            }
                            break;
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final com.google.android.gms.common.server.response.a CREATOR = new com.google.android.gms.common.server.response.a();
        private final int a;
        protected final int b;
        protected final boolean c;
        protected final int d;
        protected final boolean e;
        protected final String f;
        protected final int g;
        protected final Class h;
        private final String i;
        private zak j;
        private a k;

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, zaa zaaVar) {
            this.a = i;
            this.b = i2;
            this.c = z;
            this.d = i3;
            this.e = z2;
            this.f = str;
            this.g = i4;
            if (str2 == null) {
                this.h = null;
                this.i = null;
            } else {
                this.h = SafeParcelResponse.class;
                this.i = str2;
            }
            if (zaaVar == null) {
                this.k = null;
            } else {
                this.k = zaaVar.G0();
            }
        }

        public static Field F0(String str, int i) {
            return new Field(8, false, 8, false, str, i, null, null);
        }

        public static Field G0(String str, int i, Class cls) {
            return new Field(11, false, 11, false, str, i, cls, null);
        }

        public static Field H0(String str, int i, Class cls) {
            return new Field(11, true, 11, true, str, i, cls, null);
        }

        public static Field I0(String str, int i) {
            return new Field(0, false, 0, false, str, i, null, null);
        }

        public static Field J0(String str, int i) {
            return new Field(7, false, 7, false, str, i, null, null);
        }

        public static Field K0(String str, int i) {
            return new Field(7, true, 7, true, str, i, null, null);
        }

        private final String O0() {
            String str = this.i;
            if (str == null) {
                return null;
            }
            return str;
        }

        private final zaa Q0() {
            a aVar = this.k;
            if (aVar == null) {
                return null;
            }
            return zaa.F0(aVar);
        }

        public int L0() {
            return this.g;
        }

        public final void N0(zak zakVar) {
            this.j = zakVar;
        }

        public final boolean P0() {
            return this.k != null;
        }

        public final Map R0() {
            a52.g(this.i);
            a52.g(this.j);
            return this.j.H0(this.i);
        }

        public String toString() {
            st1.a aVarA = st1.c(this).a("versionCode", Integer.valueOf(this.a)).a("typeIn", Integer.valueOf(this.b)).a("typeInArray", Boolean.valueOf(this.c)).a("typeOut", Integer.valueOf(this.d)).a("typeOutArray", Boolean.valueOf(this.e)).a("outputFieldName", this.f).a("safeParcelFieldId", Integer.valueOf(this.g)).a("concreteTypeName", O0());
            Class cls = this.h;
            if (cls != null) {
                aVarA.a("concreteType.class", cls.getCanonicalName());
            }
            a aVar = this.k;
            if (aVar != null) {
                aVarA.a("converterName", aVar.getClass().getCanonicalName());
            }
            return aVarA.toString();
        }

        public final Object u(Object obj) {
            return this.k.u(obj);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int iA = nj2.a(parcel);
            nj2.h(parcel, 1, this.a);
            nj2.h(parcel, 2, this.b);
            nj2.c(parcel, 3, this.c);
            nj2.h(parcel, 4, this.d);
            nj2.c(parcel, 5, this.e);
            nj2.o(parcel, 6, this.f, false);
            nj2.h(parcel, 7, L0());
            nj2.o(parcel, 8, O0(), false);
            nj2.n(parcel, 9, Q0(), i, false);
            nj2.b(parcel, iA);
        }

        private Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class cls, a aVar) {
            this.a = 1;
            this.b = i;
            this.c = z;
            this.d = i2;
            this.e = z2;
            this.f = str;
            this.g = i3;
            this.h = cls;
            if (cls == null) {
                this.i = null;
            } else {
                this.i = cls.getCanonicalName();
            }
            this.k = aVar;
        }
    }
}
