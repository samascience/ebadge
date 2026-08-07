package androidx.lifecycle;

import defpackage.db1;
import defpackage.h70;
import defpackage.j70;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
@h70(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {84}, m = "invokeSuspend")
final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements or0 {
    final /* synthetic */ or0 $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    @h70(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {166}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements or0 {
        final /* synthetic */ CoroutineScope $$this$coroutineScope;
        final /* synthetic */ or0 $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, CoroutineScope coroutineScope, or0 or0Var, x30 x30Var) {
            super(2, x30Var);
            this.$this_repeatOnLifecycle = lifecycle;
            this.$state = state;
            this.$$this$coroutineScope = coroutineScope;
            this.$block = or0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, x30Var);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00b7  */
        /* JADX WARN: Code duplicated, block: B:31:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:36:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:39:0x00d9  */
        /* JADX WARN: Type inference failed for: r10v0, types: [T, androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Ref$ObjectRef ref$ObjectRef;
            Ref$ObjectRef ref$ObjectRef2;
            Job job;
            f fVar;
            Job job2;
            f fVar2;
            Object objD = kotlin.coroutines.intrinsics.a.d();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ref$ObjectRef2 = (Ref$ObjectRef) this.L$1;
                ref$ObjectRef = (Ref$ObjectRef) this.L$0;
                try {
                    kotlin.d.b(obj);
                    job2 = (Job) ref$ObjectRef.element;
                    if (job2 != null) {
                        Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                    }
                    fVar2 = (f) ref$ObjectRef2.element;
                    if (fVar2 != null) {
                        this.$this_repeatOnLifecycle.d(fVar2);
                    }
                    return k83.a;
                } catch (Throwable th) {
                    th = th;
                    job = (Job) ref$ObjectRef.element;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    fVar = (f) ref$ObjectRef2.element;
                    if (fVar != null) {
                        this.$this_repeatOnLifecycle.d(fVar);
                    }
                    throw th;
                }
            }
            kotlin.d.b(obj);
            if (this.$this_repeatOnLifecycle.b() == Lifecycle.State.DESTROYED) {
                return k83.a;
            }
            final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
            try {
                Lifecycle.State state = this.$state;
                Lifecycle lifecycle = this.$this_repeatOnLifecycle;
                final CoroutineScope coroutineScope = this.$$this$coroutineScope;
                final or0 or0Var = this.$block;
                this.L$0 = ref$ObjectRef3;
                this.L$1 = ref$ObjectRef4;
                this.L$2 = state;
                this.L$3 = lifecycle;
                this.L$4 = coroutineScope;
                this.L$5 = or0Var;
                this.label = 1;
                final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.coroutines.intrinsics.a.c(this), 1);
                cancellableContinuationImpl.initCancellability();
                Lifecycle.Event.a aVar = Lifecycle.Event.Companion;
                final Lifecycle.Event eventD = aVar.d(state);
                final Lifecycle.Event eventA = aVar.a(state);
                final Mutex mutexMutex$default = MutexKt.Mutex$default(false, 1, null);
                ?? r10 = new f() { // from class: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1

                    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1, reason: invalid class name */
                    @h70(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {Opcodes.LOOKUPSWITCH, 110}, m = "invokeSuspend")
                    static final class AnonymousClass1 extends SuspendLambda implements or0 {
                        final /* synthetic */ or0 $block;
                        final /* synthetic */ Mutex $mutex;
                        Object L$0;
                        Object L$1;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(Mutex mutex, or0 or0Var, x30 x30Var) {
                            super(2, x30Var);
                            this.$mutex = mutex;
                            this.$block = or0Var;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final x30 create(Object obj, x30 x30Var) {
                            return new AnonymousClass1(this.$mutex, this.$block, x30Var);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            Mutex mutex;
                            or0 or0Var;
                            Mutex mutex2;
                            Throwable th;
                            Object objD = kotlin.coroutines.intrinsics.a.d();
                            int i = this.label;
                            try {
                                if (i == 0) {
                                    kotlin.d.b(obj);
                                    mutex = this.$mutex;
                                    or0Var = this.$block;
                                    this.L$0 = mutex;
                                    this.L$1 = or0Var;
                                    this.label = 1;
                                    if (mutex.lock(null, this) == objD) {
                                        return objD;
                                    }
                                } else {
                                    if (i != 1) {
                                        if (i != 2) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        mutex2 = (Mutex) this.L$0;
                                        try {
                                            kotlin.d.b(obj);
                                            k83 k83Var = k83.a;
                                            mutex2.unlock(null);
                                            return k83.a;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            mutex2.unlock(null);
                                            throw th;
                                        }
                                    }
                                    or0Var = (or0) this.L$1;
                                    Mutex mutex3 = (Mutex) this.L$0;
                                    kotlin.d.b(obj);
                                    mutex = mutex3;
                                }
                                RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(or0Var, null);
                                this.L$0 = mutex;
                                this.L$1 = null;
                                this.label = 2;
                                if (CoroutineScopeKt.coroutineScope(repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1, this) == objD) {
                                    return objD;
                                }
                                mutex2 = mutex;
                                k83 k83Var2 = k83.a;
                                mutex2.unlock(null);
                                return k83.a;
                            } catch (Throwable th3) {
                                mutex2 = mutex;
                                th = th3;
                                mutex2.unlock(null);
                                throw th;
                            }
                        }

                        @Override // defpackage.or0
                        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
                            return ((AnonymousClass1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
                        }
                    }

                    /* JADX WARN: Type inference failed for: r9v5, types: [T, kotlinx.coroutines.Job] */
                    @Override // androidx.lifecycle.f
                    public final void c(db1 db1Var, Lifecycle.Event event) {
                        p31.f(db1Var, "<anonymous parameter 0>");
                        p31.f(event, "event");
                        if (event == eventD) {
                            ref$ObjectRef3.element = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(mutexMutex$default, or0Var, null), 3, null);
                            return;
                        }
                        if (event == eventA) {
                            Job job3 = (Job) ref$ObjectRef3.element;
                            if (job3 != null) {
                                Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
                            }
                            ref$ObjectRef3.element = null;
                        }
                        if (event == Lifecycle.Event.ON_DESTROY) {
                            CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                            Result.a aVar2 = Result.Companion;
                            cancellableContinuation.resumeWith(Result.m69constructorimpl(k83.a));
                        }
                    }
                };
                ref$ObjectRef4.element = r10;
                p31.d(r10, "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");
                lifecycle.a((f) r10);
                Object result = cancellableContinuationImpl.getResult();
                if (result == kotlin.coroutines.intrinsics.a.d()) {
                    j70.c(this);
                }
                if (result == objD) {
                    return objD;
                }
                ref$ObjectRef = ref$ObjectRef3;
                ref$ObjectRef2 = ref$ObjectRef4;
                job2 = (Job) ref$ObjectRef.element;
                if (job2 != null) {
                    Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
                fVar2 = (f) ref$ObjectRef2.element;
                if (fVar2 != null) {
                    this.$this_repeatOnLifecycle.d(fVar2);
                }
                return k83.a;
            } catch (Throwable th2) {
                th = th2;
                ref$ObjectRef = ref$ObjectRef3;
                ref$ObjectRef2 = ref$ObjectRef4;
                job = (Job) ref$ObjectRef.element;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                fVar = (f) ref$ObjectRef2.element;
                if (fVar != null) {
                    this.$this_repeatOnLifecycle.d(fVar);
                }
                throw th;
            }
        }

        @Override // defpackage.or0
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((AnonymousClass1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, or0 or0Var, x30 x30Var) {
        super(2, x30Var);
        this.$this_repeatOnLifecycle = lifecycle;
        this.$state = state;
        this.$block = or0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, x30Var);
        repeatOnLifecycleKt$repeatOnLifecycle$3.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            kotlin.d.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, coroutineScope, this.$block, null);
            this.label = 1;
            if (BuildersKt.withContext(immediate, anonymousClass1, this) == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.d.b(obj);
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
