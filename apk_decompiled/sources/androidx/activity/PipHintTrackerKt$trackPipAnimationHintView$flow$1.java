package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import defpackage.h70;
import defpackage.k83;
import defpackage.n7;
import defpackage.or0;
import defpackage.p32;
import defpackage.x30;
import defpackage.yq0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: loaded from: classes.dex */
@h70(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", l = {85}, m = "invokeSuspend")
final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends SuspendLambda implements or0 {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements View.OnAttachStateChangeListener {
        final /* synthetic */ ProducerScope a;
        final /* synthetic */ View b;
        final /* synthetic */ ViewTreeObserver.OnScrollChangedListener c;
        final /* synthetic */ View.OnLayoutChangeListener d;

        a(ProducerScope producerScope, View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, View.OnLayoutChangeListener onLayoutChangeListener) {
            this.a = producerScope;
            this.b = view;
            this.c = onScrollChangedListener;
            this.d = onLayoutChangeListener;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.a.mo92trySendJP2dKIU(p32.b(this.b));
            this.b.getViewTreeObserver().addOnScrollChangedListener(this.c);
            this.b.addOnLayoutChangeListener(this.d);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.c);
            view.removeOnLayoutChangeListener(this.d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PipHintTrackerKt$trackPipAnimationHintView$flow$1(View view, x30 x30Var) {
        super(2, x30Var);
        this.$view = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(ProducerScope producerScope, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == i5 && i3 == i7 && i2 == i6 && i4 == i8) {
            return;
        }
        producerScope.mo92trySendJP2dKIU(p32.b(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(ProducerScope producerScope, View view) {
        producerScope.mo92trySendJP2dKIU(p32.b(view));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, x30Var);
        pipHintTrackerKt$trackPipAnimationHintView$flow$1.L$0 = obj;
        return pipHintTrackerKt$trackPipAnimationHintView$flow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: androidx.activity.b
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$0(producerScope, view, i2, i3, i4, i5, i6, i7, i8, i9);
                }
            };
            final View view = this.$view;
            final ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.activity.c
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$1(producerScope, view);
                }
            };
            final a aVar = new a(producerScope, this.$view, onScrollChangedListener, onLayoutChangeListener);
            if (n7.a.a(this.$view)) {
                producerScope.mo92trySendJP2dKIU(p32.b(this.$view));
                this.$view.getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
                this.$view.addOnLayoutChangeListener(onLayoutChangeListener);
            }
            this.$view.addOnAttachStateChangeListener(aVar);
            final View view2 = this.$view;
            yq0 yq0Var = new yq0() { // from class: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // defpackage.yq0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m6invoke();
                    return k83.a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m6invoke() {
                    view2.getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
                    view2.removeOnLayoutChangeListener(onLayoutChangeListener);
                    view2.removeOnAttachStateChangeListener(aVar);
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, yq0Var, this) == objD) {
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

    @Override // defpackage.or0
    public final Object invoke(ProducerScope<? super Rect> producerScope, x30 x30Var) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) create(producerScope, x30Var)).invokeSuspend(k83.a);
    }
}
