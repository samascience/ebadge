package okio.internal;

import defpackage.h70;
import defpackage.hz1;
import defpackage.k83;
import defpackage.or0;
import defpackage.sm2;
import defpackage.x30;
import defpackage.xm0;
import java.util.Iterator;
import kotlin.collections.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.d;

/* JADX INFO: renamed from: okio.internal.-FileSystem$commonListRecursively$1, reason: invalid class name */
/* JADX INFO: loaded from: classes4.dex */
@h70(c = "okio.internal.-FileSystem$commonListRecursively$1", f = "FileSystem.kt", l = {96}, m = "invokeSuspend")
final class FileSystem$commonListRecursively$1 extends RestrictedSuspendLambda implements or0 {
    final /* synthetic */ hz1 $dir;
    final /* synthetic */ boolean $followSymlinks;
    final /* synthetic */ xm0 $this_commonListRecursively;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileSystem$commonListRecursively$1(hz1 hz1Var, xm0 xm0Var, boolean z, x30 x30Var) {
        super(2, x30Var);
        this.$dir = hz1Var;
        this.$this_commonListRecursively = xm0Var;
        this.$followSymlinks = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        FileSystem$commonListRecursively$1 fileSystem$commonListRecursively$1 = new FileSystem$commonListRecursively$1(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, x30Var);
        fileSystem$commonListRecursively$1.L$0 = obj;
        return fileSystem$commonListRecursively$1;
    }

    @Override // defpackage.or0
    public final Object invoke(sm2 sm2Var, x30 x30Var) {
        return ((FileSystem$commonListRecursively$1) create(sm2Var, x30Var)).invokeSuspend(k83.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        sm2 sm2Var;
        c cVar;
        Iterator it;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            sm2 sm2Var2 = (sm2) this.L$0;
            c cVar2 = new c();
            cVar2.addLast(this.$dir);
            sm2Var = sm2Var2;
            cVar = cVar2;
            it = this.$this_commonListRecursively.a(this.$dir).iterator();
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) this.L$2;
            c cVar3 = (c) this.L$1;
            sm2 sm2Var3 = (sm2) this.L$0;
            d.b(obj);
            cVar = cVar3;
            sm2Var = sm2Var3;
        }
        while (it.hasNext()) {
            hz1 hz1Var = (hz1) it.next();
            xm0 xm0Var = this.$this_commonListRecursively;
            boolean z = this.$followSymlinks;
            this.L$0 = sm2Var;
            this.L$1 = cVar;
            this.L$2 = it;
            this.label = 1;
            if (FileSystem.a(sm2Var, xm0Var, cVar, hz1Var, z, false, this) == objD) {
                return objD;
            }
        }
        return k83.a;
    }
}
