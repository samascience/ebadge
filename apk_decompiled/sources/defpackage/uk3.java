package defpackage;

import androidx.room.RoomDatabase;

/* JADX INFO: loaded from: classes.dex */
public final class uk3 implements tk3 {
    private final RoomDatabase a;
    private final uh0 b;
    private final no2 c;
    private final no2 d;

    class a extends uh0 {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.uh0
        public /* bridge */ /* synthetic */ void bind(sw2 sw2Var, Object obj) {
            e43.a(obj);
            c(sw2Var, null);
        }

        public void c(sw2 sw2Var, sk3 sk3Var) {
            throw null;
        }

        @Override // defpackage.no2
        public String createQuery() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }
    }

    class b extends no2 {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.no2
        public String createQuery() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    class c extends no2 {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.no2
        public String createQuery() {
            return "DELETE FROM WorkProgress";
        }
    }

    public uk3(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    @Override // defpackage.tk3
    public void a(String str) {
        this.a.assertNotSuspendingTransaction();
        sw2 sw2VarAcquire = this.c.acquire();
        if (str == null) {
            sw2VarAcquire.l0(1);
        } else {
            sw2VarAcquire.f(1, str);
        }
        this.a.beginTransaction();
        try {
            sw2VarAcquire.E();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.c.release(sw2VarAcquire);
        }
    }

    @Override // defpackage.tk3
    public void b() {
        this.a.assertNotSuspendingTransaction();
        sw2 sw2VarAcquire = this.d.acquire();
        this.a.beginTransaction();
        try {
            sw2VarAcquire.E();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.d.release(sw2VarAcquire);
        }
    }
}
