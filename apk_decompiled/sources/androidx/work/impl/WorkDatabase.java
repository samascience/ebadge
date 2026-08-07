package androidx.work.impl;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.g;
import defpackage.bl3;
import defpackage.e52;
import defpackage.hz2;
import defpackage.jk3;
import defpackage.k90;
import defpackage.ow2;
import defpackage.pw2;
import defpackage.qk3;
import defpackage.rq0;
import defpackage.tk3;
import defpackage.yk3;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class WorkDatabase extends RoomDatabase {
    private static final long a = TimeUnit.DAYS.toMillis(1);

    class a implements pw2.c {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // pw2.c
        public pw2 a(pw2.b bVar) {
            pw2.b.a aVarA = pw2.b.a(this.a);
            aVarA.c(bVar.b).b(bVar.c).d(true);
            return new rq0().a(aVarA.a());
        }
    }

    class b extends RoomDatabase.b {
        b() {
        }

        @Override // androidx.room.RoomDatabase.b
        public void c(ow2 ow2Var) {
            super.c(ow2Var);
            ow2Var.d();
            try {
                ow2Var.e(WorkDatabase.f());
                ow2Var.j();
            } finally {
                ow2Var.l();
            }
        }
    }

    public static WorkDatabase b(Context context, Executor executor, boolean z) {
        RoomDatabase.a aVarA;
        if (z) {
            aVarA = g.c(context, WorkDatabase.class).c();
        } else {
            aVarA = g.a(context, WorkDatabase.class, jk3.d());
            aVarA.f(new a(context));
        }
        return (WorkDatabase) aVarA.g(executor).a(d()).b(androidx.work.impl.a.a).b(new androidx.work.impl.a.h(context, 2, 3)).b(androidx.work.impl.a.b).b(androidx.work.impl.a.c).b(new androidx.work.impl.a.h(context, 5, 6)).b(androidx.work.impl.a.d).b(androidx.work.impl.a.e).b(androidx.work.impl.a.f).b(new androidx.work.impl.a.i(context)).b(new androidx.work.impl.a.h(context, 10, 11)).b(androidx.work.impl.a.g).e().d();
    }

    static RoomDatabase.b d() {
        return new b();
    }

    static long e() {
        return System.currentTimeMillis() - a;
    }

    static String f() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + e() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }

    public abstract k90 c();

    public abstract e52 g();

    public abstract hz2 h();

    public abstract qk3 i();

    public abstract tk3 j();

    public abstract yk3 k();

    public abstract bl3 l();
}
