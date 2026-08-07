package defpackage;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.DaoException;

/* JADX INFO: loaded from: classes4.dex */
public interface gi3 {
    void a(List list);

    void b(StringBuilder sb, String str);

    public static class b extends a {
        public final h82 d;
        public final String e;

        public b(h82 h82Var, String str, Object obj) {
            super(c(h82Var, obj));
            this.d = h82Var;
            this.e = str;
        }

        private static Object c(h82 h82Var, Object obj) {
            if (obj != null && obj.getClass().isArray()) {
                throw new DaoException("Illegal value: found array, but simple object required");
            }
            Class cls = h82Var.b;
            if (cls == Date.class) {
                if (obj instanceof Date) {
                    return Long.valueOf(((Date) obj).getTime());
                }
                if (obj instanceof Long) {
                    return obj;
                }
                throw new DaoException("Illegal date value: expected java.util.Date or Long for value " + obj);
            }
            if (cls == Boolean.TYPE || cls == Boolean.class) {
                if (obj instanceof Boolean) {
                    return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
                }
                if (obj instanceof Number) {
                    int iIntValue = ((Number) obj).intValue();
                    if (iIntValue != 0 && iIntValue != 1) {
                        throw new DaoException("Illegal boolean value: numbers must be 0 or 1, but was " + obj);
                    }
                } else if (obj instanceof String) {
                    String str = (String) obj;
                    if ("TRUE".equalsIgnoreCase(str)) {
                        return 1;
                    }
                    if ("FALSE".equalsIgnoreCase(str)) {
                        return 0;
                    }
                    throw new DaoException("Illegal boolean value: Strings must be \"TRUE\" or \"FALSE\" (case insensitive), but was " + obj);
                }
            }
            return obj;
        }

        private static Object[] d(h82 h82Var, Object[] objArr) {
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = c(h82Var, objArr[i]);
            }
            return objArr;
        }

        @Override // defpackage.gi3
        public void b(StringBuilder sb, String str) {
            ht2.h(sb, str, this.d).append(this.e);
        }

        public b(h82 h82Var, String str, Object[] objArr) {
            super(d(h82Var, objArr));
            this.d = h82Var;
            this.e = str;
        }
    }

    public static abstract class a implements gi3 {
        protected final boolean a;
        protected final Object b;
        protected final Object[] c;

        public a(Object obj) {
            this.b = obj;
            this.a = true;
            this.c = null;
        }

        @Override // defpackage.gi3
        public void a(List list) {
            if (this.a) {
                list.add(this.b);
                return;
            }
            Object[] objArr = this.c;
            if (objArr != null) {
                for (Object obj : objArr) {
                    list.add(obj);
                }
            }
        }

        public a(Object[] objArr) {
            this.b = null;
            this.a = false;
            this.c = objArr;
        }
    }
}
