package retrofit2;

import defpackage.df2;
import defpackage.eh2;
import defpackage.eq;
import defpackage.fh2;
import defpackage.fi1;
import defpackage.fo;
import defpackage.gq;
import defpackage.hu1;
import defpackage.np0;
import defpackage.so;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes4.dex */
final class OkHttpCall<T> implements Call<T> {

    @Nullable
    private final Object[] args;
    private volatile boolean canceled;

    @GuardedBy("this")
    @Nullable
    private Throwable creationFailure;

    @GuardedBy("this")
    private boolean executed;

    @GuardedBy("this")
    @Nullable
    private eq rawCall;
    private final ServiceMethod<T, ?> serviceMethod;

    static final class ExceptionCatchingRequestBody extends fh2 {
        private final fh2 delegate;
        IOException thrownException;

        ExceptionCatchingRequestBody(fh2 fh2Var) {
            this.delegate = fh2Var;
        }

        @Override // defpackage.fh2, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // defpackage.fh2
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // defpackage.fh2
        public fi1 contentType() {
            return this.delegate.contentType();
        }

        @Override // defpackage.fh2
        public so source() {
            return hu1.b(new np0(this.delegate.source()) { // from class: retrofit2.OkHttpCall.ExceptionCatchingRequestBody.1
                @Override // defpackage.np0, defpackage.ks2
                public long read(fo foVar, long j) throws IOException {
                    try {
                        return super.read(foVar, j);
                    } catch (IOException e) {
                        ExceptionCatchingRequestBody.this.thrownException = e;
                        throw e;
                    }
                }
            });
        }

        void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    static final class NoContentResponseBody extends fh2 {
        private final long contentLength;
        private final fi1 contentType;

        NoContentResponseBody(fi1 fi1Var, long j) {
            this.contentType = fi1Var;
            this.contentLength = j;
        }

        @Override // defpackage.fh2
        public long contentLength() {
            return this.contentLength;
        }

        @Override // defpackage.fh2
        public fi1 contentType() {
            return this.contentType;
        }

        @Override // defpackage.fh2
        public so source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    OkHttpCall(ServiceMethod<T, ?> serviceMethod, @Nullable Object[] objArr) {
        this.serviceMethod = serviceMethod;
        this.args = objArr;
    }

    private eq createRawCall() throws IOException {
        eq call = this.serviceMethod.toCall(this.args);
        if (call != null) {
            return call;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    @Override // retrofit2.Call
    public void cancel() {
        eq eqVar;
        this.canceled = true;
        synchronized (this) {
            eqVar = this.rawCall;
        }
        if (eqVar != null) {
            eqVar.cancel();
        }
    }

    @Override // retrofit2.Call
    public void enqueue(final Callback<T> callback) {
        eq eqVar;
        Throwable th;
        Utils.checkNotNull(callback, "callback == null");
        synchronized (this) {
            try {
                if (this.executed) {
                    throw new IllegalStateException("Already executed.");
                }
                this.executed = true;
                eqVar = this.rawCall;
                th = this.creationFailure;
                if (eqVar == null && th == null) {
                    try {
                        eq eqVarCreateRawCall = createRawCall();
                        this.rawCall = eqVarCreateRawCall;
                        eqVar = eqVarCreateRawCall;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.throwIfFatal(th);
                        this.creationFailure = th;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            eqVar.cancel();
        }
        eqVar.n(new gq() { // from class: retrofit2.OkHttpCall.1
            private void callFailure(Throwable th4) {
                try {
                    callback.onFailure(OkHttpCall.this, th4);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }

            @Override // defpackage.gq
            public void onFailure(eq eqVar2, IOException iOException) {
                callFailure(iOException);
            }

            @Override // defpackage.gq
            public void onResponse(eq eqVar2, eh2 eh2Var) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(eh2Var));
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                } catch (Throwable th5) {
                    callFailure(th5);
                }
            }
        });
    }

    @Override // retrofit2.Call
    public Response<T> execute() throws IOException {
        eq eqVarCreateRawCall;
        synchronized (this) {
            try {
                if (this.executed) {
                    throw new IllegalStateException("Already executed.");
                }
                this.executed = true;
                Throwable th = this.creationFailure;
                if (th != null) {
                    if (th instanceof IOException) {
                        throw ((IOException) th);
                    }
                    if (th instanceof RuntimeException) {
                        throw ((RuntimeException) th);
                    }
                    throw ((Error) th);
                }
                eqVarCreateRawCall = this.rawCall;
                if (eqVarCreateRawCall == null) {
                    try {
                        eqVarCreateRawCall = createRawCall();
                        this.rawCall = eqVarCreateRawCall;
                    } catch (IOException | Error | RuntimeException e) {
                        Utils.throwIfFatal(e);
                        this.creationFailure = e;
                        throw e;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (this.canceled) {
            eqVarCreateRawCall.cancel();
        }
        return parseResponse(eqVarCreateRawCall.execute());
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        boolean z = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            try {
                eq eqVar = this.rawCall;
                if (eqVar == null || !eqVar.isCanceled()) {
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // retrofit2.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    Response<T> parseResponse(eh2 eh2Var) throws IOException {
        fh2 fh2VarN = eh2Var.n();
        eh2 eh2VarC = eh2Var.w0().b(new NoContentResponseBody(fh2VarN.contentType(), fh2VarN.contentLength())).c();
        int iC = eh2VarC.C();
        if (iC < 200 || iC >= 300) {
            try {
                return Response.error(Utils.buffer(fh2VarN), eh2VarC);
            } finally {
                fh2VarN.close();
            }
        }
        if (iC == 204 || iC == 205) {
            fh2VarN.close();
            return Response.success((Object) null, eh2VarC);
        }
        ExceptionCatchingRequestBody exceptionCatchingRequestBody = new ExceptionCatchingRequestBody(fh2VarN);
        try {
            return Response.success(this.serviceMethod.toResponse(exceptionCatchingRequestBody), eh2VarC);
        } catch (RuntimeException e) {
            exceptionCatchingRequestBody.throwIfCaught();
            throw e;
        }
    }

    @Override // retrofit2.Call
    public synchronized df2 request() {
        eq eqVar = this.rawCall;
        if (eqVar != null) {
            return eqVar.request();
        }
        Throwable th = this.creationFailure;
        if (th != null) {
            if (th instanceof IOException) {
                throw new RuntimeException("Unable to create request.", this.creationFailure);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            eq eqVarCreateRawCall = createRawCall();
            this.rawCall = eqVarCreateRawCall;
            return eqVarCreateRawCall.request();
        } catch (IOException e) {
            this.creationFailure = e;
            throw new RuntimeException("Unable to create request.", e);
        } catch (Error e2) {
            e = e2;
            Utils.throwIfFatal(e);
            this.creationFailure = e;
            throw e;
        } catch (RuntimeException e3) {
            e = e3;
            Utils.throwIfFatal(e);
            this.creationFailure = e;
            throw e;
        }
    }

    @Override // retrofit2.Call
    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.serviceMethod, this.args);
    }
}
