package androidx.collection;

import defpackage.e43;
import defpackage.h70;
import defpackage.k83;
import defpackage.ok2;
import defpackage.or0;
import defpackage.sm2;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.d;

/* JADX INFO: loaded from: classes.dex */
@h70(c = "androidx.collection.ScatterMap$MapWrapper$entries$1$iterator$1", f = "ScatterMap.kt", l = {701}, m = "invokeSuspend")
final class ScatterMap$MapWrapper$entries$1$iterator$1 extends RestrictedSuspendLambda implements or0 {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ok2 this$0;

    ScatterMap$MapWrapper$entries$1$iterator$1(ok2 ok2Var, x30 x30Var) {
        super(2, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        ScatterMap$MapWrapper$entries$1$iterator$1 scatterMap$MapWrapper$entries$1$iterator$1 = new ScatterMap$MapWrapper$entries$1$iterator$1(null, x30Var);
        scatterMap$MapWrapper$entries$1$iterator$1.L$0 = obj;
        return scatterMap$MapWrapper$entries$1$iterator$1;
    }

    @Override // defpackage.or0
    public final Object invoke(sm2 sm2Var, x30 x30Var) {
        return ((ScatterMap$MapWrapper$entries$1$iterator$1) create(sm2Var, x30Var)).invokeSuspend(k83.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            throw null;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = this.I$3;
        int i3 = this.I$2;
        long j = this.J$0;
        int i4 = this.I$1;
        int i5 = this.I$0;
        long[] jArr = (long[]) this.L$2;
        e43.a(this.L$1);
        d.b(obj);
        do {
            j >>= 8;
            i2++;
            while (i2 >= i3) {
                if (i3 == 8) {
                    do {
                        if (i4 != i5) {
                            i4++;
                            j = jArr[i4];
                        }
                    } while ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L);
                    i3 = 8 - ((~(i4 - i5)) >>> 31);
                    i2 = 0;
                }
                return k83.a;
            }
        } while ((255 & j) >= 128);
        throw null;
    }
}
