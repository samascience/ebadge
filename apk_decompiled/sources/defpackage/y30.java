package defpackage;

import kotlin.Result;
import kotlin.coroutines.intrinsics.a;

/* JADX INFO: loaded from: classes4.dex */
public abstract class y30 {
    public static final void a(ar0 ar0Var, x30 x30Var) {
        p31.f(ar0Var, "<this>");
        p31.f(x30Var, "completion");
        x30 x30VarC = a.c(a.a(ar0Var, x30Var));
        Result.a aVar = Result.Companion;
        x30VarC.resumeWith(Result.m69constructorimpl(k83.a));
    }

    public static final void b(or0 or0Var, Object obj, x30 x30Var) {
        p31.f(or0Var, "<this>");
        p31.f(x30Var, "completion");
        x30 x30VarC = a.c(a.b(or0Var, obj, x30Var));
        Result.a aVar = Result.Companion;
        x30VarC.resumeWith(Result.m69constructorimpl(k83.a));
    }
}
