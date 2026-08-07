package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.jn;
import defpackage.k83;
import defpackage.or0;
import defpackage.pr0;
import defpackage.x30;
import java.util.List;
import kotlin.collections.j;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.DelayKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
final class StartedWhileSubscribed implements SharingStarted {
    private final long replayExpiration;
    private final long stopTimeout;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", l = {Opcodes.GETSTATIC, Opcodes.GETFIELD, Opcodes.INVOKEVIRTUAL, Opcodes.INVOKESPECIAL, Opcodes.INVOKEINTERFACE}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements pr0 {
        /* synthetic */ int I$0;
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(x30 x30Var) {
            super(3, x30Var);
        }

        @Override // defpackage.pr0
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((FlowCollector<? super SharingCommand>) obj, ((Number) obj2).intValue(), (x30) obj3);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0070  */
        /* JADX WARN: Code duplicated, block: B:28:0x007c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x008d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x009b A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            FlowCollector flowCollector;
            SharingCommand sharingCommand;
            long j;
            SharingCommand sharingCommand2;
            Object objD = a.d();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        flowCollector = (FlowCollector) this.L$0;
                        d.b(obj);
                        if (StartedWhileSubscribed.this.replayExpiration > 0) {
                            sharingCommand = SharingCommand.STOP;
                            this.L$0 = flowCollector;
                            this.label = 3;
                            if (flowCollector.emit(sharingCommand, this) == objD) {
                                return objD;
                            }
                            j = StartedWhileSubscribed.this.replayExpiration;
                            this.L$0 = flowCollector;
                            this.label = 4;
                            if (DelayKt.delay(j, this) == objD) {
                                return objD;
                            }
                        }
                    } else if (i == 3) {
                        flowCollector = (FlowCollector) this.L$0;
                        d.b(obj);
                        j = StartedWhileSubscribed.this.replayExpiration;
                        this.L$0 = flowCollector;
                        this.label = 4;
                        if (DelayKt.delay(j, this) == objD) {
                            return objD;
                        }
                    } else if (i == 4) {
                        flowCollector = (FlowCollector) this.L$0;
                        d.b(obj);
                    } else if (i != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    sharingCommand2 = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                    this.L$0 = null;
                    this.label = 5;
                    if (flowCollector.emit(sharingCommand2, this) == objD) {
                        return objD;
                    }
                }
                d.b(obj);
            } else {
                d.b(obj);
                flowCollector = (FlowCollector) this.L$0;
                if (this.I$0 > 0) {
                    SharingCommand sharingCommand3 = SharingCommand.START;
                    this.label = 1;
                    if (flowCollector.emit(sharingCommand3, this) == objD) {
                        return objD;
                    }
                } else {
                    long j2 = StartedWhileSubscribed.this.stopTimeout;
                    this.L$0 = flowCollector;
                    this.label = 2;
                    if (DelayKt.delay(j2, this) == objD) {
                        return objD;
                    }
                    if (StartedWhileSubscribed.this.replayExpiration > 0) {
                        sharingCommand = SharingCommand.STOP;
                        this.L$0 = flowCollector;
                        this.label = 3;
                        if (flowCollector.emit(sharingCommand, this) == objD) {
                            return objD;
                        }
                        j = StartedWhileSubscribed.this.replayExpiration;
                        this.L$0 = flowCollector;
                        this.label = 4;
                        if (DelayKt.delay(j, this) == objD) {
                            return objD;
                        }
                    }
                    sharingCommand2 = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                    this.L$0 = null;
                    this.label = 5;
                    if (flowCollector.emit(sharingCommand2, this) == objD) {
                        return objD;
                    }
                }
            }
            return k83.a;
        }

        public final Object invoke(FlowCollector<? super SharingCommand> flowCollector, int i, x30 x30Var) {
            AnonymousClass1 anonymousClass1 = StartedWhileSubscribed.this.new AnonymousClass1(x30Var);
            anonymousClass1.L$0 = flowCollector;
            anonymousClass1.I$0 = i;
            return anonymousClass1.invokeSuspend(k83.a);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedWhileSubscribed$command$2, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", f = "SharingStarted.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements or0 {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(x30 x30Var) {
            super(2, x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(x30Var);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            a.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d.b(obj);
            return jn.a(((SharingCommand) this.L$0) != SharingCommand.START);
        }

        @Override // defpackage.or0
        public final Object invoke(SharingCommand sharingCommand, x30 x30Var) {
            return ((AnonymousClass2) create(sharingCommand, x30Var)).invokeSuspend(k83.a);
        }
    }

    public StartedWhileSubscribed(long j, long j2) {
        this.stopTimeout = j;
        this.replayExpiration = j2;
        if (j < 0) {
            throw new IllegalArgumentException(("stopTimeout(" + j + " ms) cannot be negative").toString());
        }
        if (j2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("replayExpiration(" + j2 + " ms) cannot be negative").toString());
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow<SharingCommand> command(StateFlow<Integer> stateFlow) {
        return FlowKt.distinctUntilChanged(FlowKt.dropWhile(FlowKt.transformLatest(stateFlow, new AnonymousClass1(null)), new AnonymousClass2(null)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof StartedWhileSubscribed) {
            StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
            if (this.stopTimeout == startedWhileSubscribed.stopTimeout && this.replayExpiration == startedWhileSubscribed.replayExpiration) {
                return true;
            }
        }
        return false;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return (Long.hashCode(this.stopTimeout) * 31) + Long.hashCode(this.replayExpiration);
    }

    public String toString() {
        List listD = j.d(2);
        if (this.stopTimeout > 0) {
            listD.add("stopTimeout=" + this.stopTimeout + "ms");
        }
        if (this.replayExpiration < Long.MAX_VALUE) {
            listD.add("replayExpiration=" + this.replayExpiration + "ms");
        }
        return "SharingStarted.WhileSubscribed(" + j.N(j.a(listD), null, null, null, 0, null, null, 63, null) + ')';
    }
}
