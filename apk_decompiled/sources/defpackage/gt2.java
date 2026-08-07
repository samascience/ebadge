package defpackage;

import java.sql.Date;
import java.sql.Timestamp;

/* JADX INFO: loaded from: classes3.dex */
public abstract class gt2 {
    public static final boolean a;
    public static final z70.b b;
    public static final z70.b c;
    public static final f63 d;
    public static final f63 e;
    public static final f63 f;

    class a extends z70.b {
        a(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // z70.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Date d(java.util.Date date) {
            return new Date(date.getTime());
        }
    }

    class b extends z70.b {
        b(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // z70.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Timestamp d(java.util.Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        a = z;
        if (z) {
            b = new a(Date.class);
            c = new b(Timestamp.class);
            d = dt2.b;
            e = et2.b;
            f = ft2.b;
            return;
        }
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
    }
}
