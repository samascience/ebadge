package defpackage;

import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.protocol.Protocol;
import com.alibaba.dashscope.protocol.StreamingMode;
import com.alibaba.dashscope.protocol.WebSocketEventType;
import com.baji.protocol.model.ProtocolConstants;
import com.tencent.connect.common.Constants;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public class gu1 extends sh3 implements vv0 {
    private static final hd1 j = ld1.k(gu1.class);
    private zt1 a;
    private qh3 b;
    private AtomicBoolean c = new AtomicBoolean(false);
    private AtomicBoolean d = new AtomicBoolean(false);
    protected AtomicBoolean e = new AtomicBoolean(false);
    protected FlowableEmitter f;
    private boolean g;
    private FlowableEmitter h;
    private AtomicBoolean i;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[WebSocketEventType.values().length];
            a = iArr;
            try {
                iArr[WebSocketEventType.TASK_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[WebSocketEventType.TASK_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[WebSocketEventType.TASK_FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[WebSocketEventType.RESULT_GENERATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public gu1(zt1 zt1Var, boolean z) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.i = atomicBoolean;
        this.a = zt1Var;
        atomicBoolean.set(z);
    }

    private df2 l(String str, boolean z, String str2, Map map, String str3) {
        String str4 = map != null ? (String) map.get("user-agent") : null;
        HashMap map2 = map != null ? new HashMap(map) : new HashMap();
        map2.remove("user-agent");
        df2.a aVar = new df2.a();
        aVar.h(iw0.d(t50.c(str, z, str2, map2, str4)));
        String str5 = i20.k;
        if (str3 == null) {
            str3 = str5;
        }
        return aVar.m(str3).b();
    }

    private void n(final String str, final boolean z, final String str2, final Map map, final String str3) {
        int i = 0;
        String str4 = Constants.STR_EMPTY;
        while (i < 3) {
            try {
                Flowable.create(new FlowableOnSubscribe() { // from class: fu1
                    @Override // io.reactivex.FlowableOnSubscribe
                    public final void subscribe(FlowableEmitter flowableEmitter) {
                        this.a.o(str, z, str2, map, str3, flowableEmitter);
                    }
                }, BackpressureStrategy.BUFFER).timeout(60L, TimeUnit.SECONDS).blockingSubscribe();
                return;
            } catch (Throwable th) {
                i++;
                String message = th.getMessage();
                j.error(message);
                if (message.contains("401 Unauthorized")) {
                    str4 = message;
                    break;
                } else {
                    if (message.contains("Can not find api-key.")) {
                        throw th;
                    }
                    try {
                        Thread.sleep(ProtocolConstants.CONNECTION_TIMEOUT_MS);
                    } catch (InterruptedException unused) {
                    }
                    str4 = message;
                }
            }
        }
        throw new ApiException(xt2.c().b("ConnectionError").d(str4).f(44).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(String str, boolean z, String str2, Map map, String str3, FlowableEmitter flowableEmitter) {
        this.h = flowableEmitter;
        try {
            zt1 zt1VarB = au1.b();
            this.a = zt1VarB;
            this.b = zt1VarB.z(l(str, z, str2, map, str3), this);
        } catch (Throwable th) {
            this.h.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(xv0 xv0Var, FlowableEmitter flowableEmitter) {
        this.f = flowableEmitter;
        this.g = xv0Var.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(xv0 xv0Var, FlowableEmitter flowableEmitter) {
        this.f = flowableEmitter;
        this.g = xv0Var.i();
    }

    private void r(xv0 xv0Var) {
        if (xv0Var.m() == null) {
            t(xv0Var.a(), xv0Var.p(), t71.toJson(xv0Var.j()), xv0Var.n(), xv0Var.e(), xv0Var.b());
        } else {
            t(xv0Var.a(), xv0Var.p(), t71.toJson(xv0Var.j()), xv0Var.n(), xv0Var.e(), xv0Var.b());
            s(xv0Var.a(), xv0Var.p(), ByteString.of(xv0Var.m()), xv0Var.n(), xv0Var.e(), xv0Var.b());
        }
    }

    @Override // defpackage.vv0
    public Flowable a(final xv0 xv0Var) {
        Flowable flowableCreate = Flowable.create(new FlowableOnSubscribe() { // from class: eu1
            @Override // io.reactivex.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) {
                this.a.q(xv0Var, flowableEmitter);
            }
        }, BackpressureStrategy.BUFFER);
        flowableCreate.subscribe().dispose();
        r(xv0Var);
        return flowableCreate;
    }

    @Override // defpackage.vv0
    public u50 b(final xv0 xv0Var) {
        if (xv0Var.k() != StreamingMode.NONE && xv0Var.k() != StreamingMode.IN) {
            throw new ApiException(xt2.c().b("Invalid call").f(44).d("Please use streamOut interface of websocket.").a());
        }
        Flowable flowableCreate = Flowable.create(new FlowableOnSubscribe() { // from class: du1
            @Override // io.reactivex.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) {
                this.a.p(xv0Var, flowableEmitter);
            }
        }, BackpressureStrategy.BUFFER);
        flowableCreate.subscribe().dispose();
        r(xv0Var);
        return (u50) flowableCreate.blockingSingle();
    }

    @Override // defpackage.sh3
    public void c(qh3 qh3Var, int i, String str) {
        j.debug(uv2.a("WebSocket %s closed: %d, %s", qh3Var.toString(), Integer.valueOf(i), str));
        this.c.set(false);
        this.d.set(false);
    }

    @Override // defpackage.sh3
    public void d(qh3 qh3Var, int i, String str) {
        qh3Var.f(i, null);
        j.debug(uv2.a("Websocket is closing, code: %s, reasion: %s", Integer.valueOf(i), str));
        FlowableEmitter flowableEmitter = this.f;
        if (flowableEmitter == null || flowableEmitter.isCancelled()) {
            return;
        }
        this.f.onComplete();
    }

    @Override // defpackage.sh3
    public void e(qh3 qh3Var, Throwable th, eh2 eh2Var) {
        String strString;
        if (this.d.get()) {
            j.debug("called close before but not working, close again in onFailure.");
            m(1001, "call closed before");
            return;
        }
        if (eh2Var != null) {
            try {
                strString = eh2Var.n().string();
            } catch (IOException e) {
                j.error(e.getMessage());
                strString = Constants.STR_EMPTY;
            }
        } else {
            strString = Constants.STR_EMPTY;
        }
        String strA = uv2.a("Websocket failure %s, cause: %s, body: %s", th.getMessage(), th.getCause(), strString);
        hd1 hd1Var = j;
        hd1Var.error(strA);
        this.c.set(false);
        FlowableEmitter flowableEmitter = this.h;
        if (flowableEmitter != null && !flowableEmitter.isCancelled()) {
            this.h.onError(new Exception(strA, th));
            return;
        }
        FlowableEmitter flowableEmitter2 = this.f;
        if (flowableEmitter2 == null || flowableEmitter2.isCancelled()) {
            hd1Var.error(strA);
        } else {
            this.f.onError(new Exception(strA, th));
        }
    }

    @Override // defpackage.sh3
    public void f(qh3 qh3Var, String str) {
        if (this.d.get()) {
            j.debug("called close before but not working, close again in onMessage.");
            m(1001, "call closed before");
            return;
        }
        hd1 hd1Var = j;
        hd1Var.debug(str);
        if (!this.e.get()) {
            hd1Var.debug("Receive first package.");
            this.e.set(true);
        }
        try {
            e43.a(t71.fromJson(str, vh3.class));
            int[] iArr = a.a;
            throw null;
        } catch (Throwable unused) {
            this.f.onError(new ApiException(xt2.c().b("MessageFormatError").d(uv2.a("Receive message: %s, json deserialize exception", str)).f(44).a()));
        }
    }

    @Override // defpackage.sh3
    public void g(qh3 qh3Var, ByteString byteString) {
        if (this.d.get()) {
            j.debug("called close before but not working, close again in onMessage.");
            m(1001, "call closed before");
        } else {
            if (!this.e.get()) {
                j.debug("Receive first binary package.");
                this.e.set(true);
            }
            this.f.onNext(new u50().n(Protocol.WEBSOCKET, sq1.c().a(byteString.asByteBuffer()).b(), this.g));
        }
    }

    @Override // defpackage.sh3
    public void h(qh3 qh3Var, eh2 eh2Var) {
        if (this.d.get()) {
            j.debug("called close before but not working, close again in onOpen.");
            m(1001, "call closed before");
            return;
        }
        this.c.set(true);
        FlowableEmitter flowableEmitter = this.h;
        if (flowableEmitter == null || flowableEmitter.isCancelled()) {
            return;
        }
        this.h.onComplete();
    }

    public boolean m(int i, String str) {
        this.d.set(true);
        qh3 qh3Var = this.b;
        if (qh3Var != null) {
            return qh3Var.f(i, str);
        }
        return true;
    }

    protected void s(String str, boolean z, ByteString byteString, String str2, Map map, String str3) {
        if (!this.c.get()) {
            n(str, z, str2, map, str3);
        }
        for (int i = 0; i < 3 && !this.b.a(byteString); i++) {
            n(str, z, str2, map, str3);
            j.warn(uv2.a("Send request failed, the connection may closed, will reconnect and send again", new Object[0]));
            Observable.timer(5000L, TimeUnit.MILLISECONDS).blockingSingle();
        }
    }

    protected void t(String str, boolean z, String str2, String str3, Map map, String str4) {
        if (!this.c.get()) {
            n(str, z, str3, map, str4);
        }
        if (this.i.get()) {
            hd1 hd1Var = j;
            hd1Var.info("Sending message: " + str2);
            if (this.b.b(str2)) {
                return;
            }
            hd1Var.warn("Send request failed, return without retry.");
            return;
        }
        for (int i = 0; i < 3; i++) {
            hd1 hd1Var2 = j;
            hd1Var2.debug("Sending message: " + str2);
            if (this.b.b(str2)) {
                return;
            }
            n(str, z, str3, map, str4);
            hd1Var2.warn(uv2.a("Send request failed, the connection may closed, will reconnect and send again", new Object[0]));
            Observable.timer(5000L, TimeUnit.MILLISECONDS).blockingSingle();
        }
    }
}
