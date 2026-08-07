package okio.internal;

import defpackage.h70;
import defpackage.hz1;
import defpackage.k83;
import defpackage.or0;
import defpackage.sm2;
import defpackage.x30;
import defpackage.xm0;
import kotlin.collections.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.d;

/* JADX INFO: renamed from: okio.internal.-FileSystem$commonDeleteRecursively$sequence$1, reason: invalid class name */
/* JADX INFO: loaded from: classes4.dex */
@h70(c = "okio.internal.-FileSystem$commonDeleteRecursively$sequence$1", f = "FileSystem.kt", l = {75}, m = "invokeSuspend")
final class FileSystem$commonDeleteRecursively$sequence$1 extends RestrictedSuspendLambda implements or0 {
    final /* synthetic */ hz1 $fileOrDirectory;
    final /* synthetic */ xm0 $this_commonDeleteRecursively;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileSystem$commonDeleteRecursively$sequence$1(xm0 xm0Var, hz1 hz1Var, x30 x30Var) {
        super(2, x30Var);
        this.$this_commonDeleteRecursively = xm0Var;
        this.$fileOrDirectory = hz1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        FileSystem$commonDeleteRecursively$sequence$1 fileSystem$commonDeleteRecursively$sequence$1 = new FileSystem$commonDeleteRecursively$sequence$1(this.$this_commonDeleteRecursively, this.$fileOrDirectory, x30Var);
        fileSystem$commonDeleteRecursively$sequence$1.L$0 = obj;
        return fileSystem$commonDeleteRecursively$sequence$1;
    }

    @Override // defpackage.or0
    public final Object invoke(sm2 sm2Var, x30 x30Var) {
        return ((FileSystem$commonDeleteRecursively$sequence$1) create(sm2Var, x30Var)).invokeSuspend(k83.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            sm2 sm2Var = (sm2) this.L$0;
            xm0 xm0Var = this.$this_commonDeleteRecursively;
            c cVar = new c();
            hz1 hz1Var = this.$fileOrDirectory;
            this.label = 1;
            if (FileSystem.a(sm2Var, xm0Var, cVar, hz1Var, false, true, this) == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d.b(obj);
        }
        return k83.a;
    }
}
