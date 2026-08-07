package defpackage;

/* JADX INFO: loaded from: classes.dex */
public interface d80 extends cb1 {
    default void d(db1 db1Var) {
        p31.f(db1Var, "owner");
    }

    default void onDestroy(db1 db1Var) {
        p31.f(db1Var, "owner");
    }

    default void onPause(db1 db1Var) {
        p31.f(db1Var, "owner");
    }

    void onResume(db1 db1Var);

    default void onStart(db1 db1Var) {
        p31.f(db1Var, "owner");
    }

    default void onStop(db1 db1Var) {
        p31.f(db1Var, "owner");
    }
}
