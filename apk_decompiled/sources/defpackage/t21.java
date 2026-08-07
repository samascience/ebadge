package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class t21 {

    class a extends t21 {
        a() {
        }

        @Override // defpackage.t21
        public s21 a(String str) {
            return null;
        }
    }

    public static t21 c() {
        return new a();
    }

    public abstract s21 a(String str);

    public final s21 b(String str) {
        s21 s21VarA = a(str);
        return s21VarA == null ? s21.a(str) : s21VarA;
    }
}
