package defpackage;

import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public final class gk0 extends l1 {
    private final a a = new a();

    public static final class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // defpackage.l1
    public Random getImpl() {
        Object obj = this.a.get();
        p31.e(obj, "get(...)");
        return (Random) obj;
    }
}
