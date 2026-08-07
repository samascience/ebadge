package defpackage;

import com.google.gson.reflect.TypeToken;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
class ft2 extends e63 {
    static final f63 b = new a();
    private final e63 a;

    class a implements f63 {
        a() {
        }

        @Override // defpackage.f63
        public e63 a(qv0 qv0Var, TypeToken typeToken) {
            a aVar = null;
            if (typeToken.getRawType() == Timestamp.class) {
                return new ft2(qv0Var.h(Date.class), aVar);
            }
            return null;
        }
    }

    /* synthetic */ ft2(e63 e63Var, a aVar) {
        this(e63Var);
    }

    @Override // defpackage.e63
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Timestamp b(a71 a71Var) {
        Date date = (Date) this.a.b(a71Var);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // defpackage.e63
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(a81 a81Var, Timestamp timestamp) {
        this.a.e(a81Var, timestamp);
    }

    private ft2(e63 e63Var) {
        this.a = e63Var;
    }
}
