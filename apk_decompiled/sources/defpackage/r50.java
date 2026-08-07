package defpackage;

import java.lang.reflect.Field;
import java.util.ArrayList;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

/* JADX INFO: loaded from: classes4.dex */
public final class r50 implements Cloneable {
    public final r60 a;
    public final String b;
    public final h82[] c;
    public final String[] d;
    public final String[] e;
    public final String[] f;
    public final h82 g;
    public final boolean h;
    public final uz2 i;
    private bz0 j;

    public r50(r60 r60Var, Class cls) {
        this.a = r60Var;
        try {
            this.b = (String) cls.getField("TABLENAME").get(null);
            h82[] h82VarArrE = e(cls);
            this.c = h82VarArrE;
            this.d = new String[h82VarArrE.length];
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            h82 h82Var = null;
            for (int i = 0; i < h82VarArrE.length; i++) {
                h82 h82Var2 = h82VarArrE[i];
                String str = h82Var2.e;
                this.d[i] = str;
                if (h82Var2.d) {
                    arrayList.add(str);
                    h82Var = h82Var2;
                } else {
                    arrayList2.add(str);
                }
            }
            this.f = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            this.e = strArr;
            h82 h82Var3 = strArr.length == 1 ? h82Var : null;
            this.g = h82Var3;
            this.i = new uz2(r60Var, this.b, this.d, strArr);
            if (h82Var3 == null) {
                this.h = false;
            } else {
                Class cls2 = h82Var3.b;
                this.h = cls2.equals(Long.TYPE) || cls2.equals(Long.class) || cls2.equals(Integer.TYPE) || cls2.equals(Integer.class) || cls2.equals(Short.TYPE) || cls2.equals(Short.class) || cls2.equals(Byte.TYPE) || cls2.equals(Byte.class);
            }
        } catch (Exception e) {
            throw new DaoException("Could not init DAOConfig", e);
        }
    }

    private static h82[] e(Class cls) throws IllegalAccessException {
        Field[] declaredFields = Class.forName(cls.getName() + "$Properties").getDeclaredFields();
        ArrayList<h82> arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if ((field.getModifiers() & 9) == 9) {
                Object obj = field.get(null);
                if (obj instanceof h82) {
                    arrayList.add((h82) obj);
                }
            }
        }
        h82[] h82VarArr = new h82[arrayList.size()];
        for (h82 h82Var : arrayList) {
            int i = h82Var.a;
            if (h82VarArr[i] != null) {
                throw new DaoException("Duplicate property ordinals");
            }
            h82VarArr[i] = h82Var;
        }
        return h82VarArr;
    }

    public void a() {
        bz0 bz0Var = this.j;
        if (bz0Var != null) {
            bz0Var.clear();
        }
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public r50 clone() {
        return new r50(this);
    }

    public bz0 c() {
        return this.j;
    }

    public void d(IdentityScopeType identityScopeType) {
        if (identityScopeType == IdentityScopeType.None) {
            this.j = null;
            return;
        }
        if (identityScopeType != IdentityScopeType.Session) {
            throw new IllegalArgumentException("Unsupported type: " + identityScopeType);
        }
        if (this.h) {
            this.j = new cz0();
        } else {
            this.j = new dz0();
        }
    }

    public r50(r50 r50Var) {
        this.a = r50Var.a;
        this.b = r50Var.b;
        this.c = r50Var.c;
        this.d = r50Var.d;
        this.e = r50Var.e;
        this.f = r50Var.f;
        this.g = r50Var.g;
        this.i = r50Var.i;
        this.h = r50Var.h;
    }
}
