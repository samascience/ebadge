package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.rm2;
import defpackage.sm2;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.d;

/* JADX INFO: loaded from: classes.dex */
@h70(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {410, 412}, m = "invokeSuspend")
final class ViewKt$allViews$1 extends RestrictedSuspendLambda implements or0 {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewKt$allViews$1(View view, x30 x30Var) {
        super(2, x30Var);
        this.$this_allViews = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, x30Var);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // defpackage.or0
    public final Object invoke(sm2 sm2Var, x30 x30Var) {
        return ((ViewKt$allViews$1) create(sm2Var, x30Var)).invokeSuspend(k83.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        sm2 sm2Var;
        Object objD = a.d();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                sm2Var = (sm2) this.L$0;
                d.b(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
            }
            return k83.a;
        }
        d.b(obj);
        sm2Var = (sm2) this.L$0;
        View view = this.$this_allViews;
        this.L$0 = sm2Var;
        this.label = 1;
        if (sm2Var.a(view, this) == objD) {
            return objD;
        }
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            rm2 rm2VarB = ViewGroupKt.b((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            if (sm2Var.b(rm2VarB, this) == objD) {
                return objD;
            }
        }
        return k83.a;
    }
}
