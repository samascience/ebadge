package defpackage;

import androidx.room.RoomDatabase;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class no2 {
    private final RoomDatabase mDatabase;
    private final AtomicBoolean mLock = new AtomicBoolean(false);
    private volatile sw2 mStmt;

    public no2(RoomDatabase roomDatabase) {
        this.mDatabase = roomDatabase;
    }

    private sw2 a() {
        return this.mDatabase.compileStatement(createQuery());
    }

    private sw2 b(boolean z) {
        if (!z) {
            return a();
        }
        if (this.mStmt == null) {
            this.mStmt = a();
        }
        return this.mStmt;
    }

    public sw2 acquire() {
        assertNotMainThread();
        return b(this.mLock.compareAndSet(false, true));
    }

    protected void assertNotMainThread() {
        this.mDatabase.assertNotMainThread();
    }

    protected abstract String createQuery();

    public void release(sw2 sw2Var) {
        if (sw2Var == this.mStmt) {
            this.mLock.set(false);
        }
    }
}
