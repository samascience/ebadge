package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class hp2 implements rw2 {
    private final String a;
    private final Object[] b;

    public hp2(String str, Object[] objArr) {
        this.a = str;
        this.b = objArr;
    }

    private static void a(qw2 qw2Var, int i, Object obj) {
        if (obj == null) {
            qw2Var.l0(i);
            return;
        }
        if (obj instanceof byte[]) {
            qw2Var.R(i, (byte[]) obj);
            return;
        }
        if (obj instanceof Float) {
            qw2Var.h(i, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            qw2Var.h(i, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Long) {
            qw2Var.i(i, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Integer) {
            qw2Var.i(i, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            qw2Var.i(i, ((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Byte) {
            qw2Var.i(i, ((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof String) {
            qw2Var.f(i, (String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            qw2Var.i(i, ((Boolean) obj).booleanValue() ? 1L : 0L);
            return;
        }
        throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i + " Supported types: null, byte[], float, double, long, int, short, byte, string");
    }

    public static void b(qw2 qw2Var, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            a(qw2Var, i, obj);
        }
    }

    @Override // defpackage.rw2
    public String n() {
        return this.a;
    }

    @Override // defpackage.rw2
    public void u(qw2 qw2Var) {
        b(qw2Var, this.b);
    }

    public hp2(String str) {
        this(str, null);
    }
}
