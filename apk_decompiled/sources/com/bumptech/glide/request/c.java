package com.bumptech.glide.request;

import defpackage.ef2;

/* JADX INFO: loaded from: classes.dex */
public class c implements RequestCoordinator, ef2 {
    private final RequestCoordinator a;
    private final Object b;
    private volatile ef2 c;
    private volatile ef2 d;
    private RequestCoordinator.RequestState e;
    private RequestCoordinator.RequestState f;
    private boolean g;

    public c(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.e = requestState;
        this.f = requestState;
        this.b = obj;
        this.a = requestCoordinator;
    }

    private boolean k() {
        RequestCoordinator requestCoordinator = this.a;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    private boolean l() {
        RequestCoordinator requestCoordinator = this.a;
        return requestCoordinator == null || requestCoordinator.g(this);
    }

    private boolean m() {
        RequestCoordinator requestCoordinator = this.a;
        return requestCoordinator == null || requestCoordinator.h(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void a(ef2 ef2Var) {
        synchronized (this.b) {
            try {
                if (!ef2Var.equals(this.c)) {
                    this.f = RequestCoordinator.RequestState.FAILED;
                    return;
                }
                this.e = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator requestCoordinator = this.a;
                if (requestCoordinator != null) {
                    requestCoordinator.a(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, defpackage.ef2
    public boolean b() {
        boolean z;
        synchronized (this.b) {
            try {
                z = this.d.b() || this.c.b();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void c(ef2 ef2Var) {
        synchronized (this.b) {
            try {
                if (ef2Var.equals(this.d)) {
                    this.f = RequestCoordinator.RequestState.SUCCESS;
                    return;
                }
                this.e = RequestCoordinator.RequestState.SUCCESS;
                RequestCoordinator requestCoordinator = this.a;
                if (requestCoordinator != null) {
                    requestCoordinator.c(this);
                }
                if (!this.f.isComplete()) {
                    this.d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.ef2
    public void clear() {
        synchronized (this.b) {
            this.g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.e = requestState;
            this.f = requestState;
            this.d.clear();
            this.c.clear();
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean d(ef2 ef2Var) {
        boolean z;
        synchronized (this.b) {
            try {
                z = k() && ef2Var.equals(this.c) && this.e != RequestCoordinator.RequestState.PAUSED;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // defpackage.ef2
    public void e() {
        synchronized (this.b) {
            try {
                this.g = true;
                try {
                    if (this.e != RequestCoordinator.RequestState.SUCCESS) {
                        RequestCoordinator.RequestState requestState = this.f;
                        RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                        if (requestState != requestState2) {
                            this.f = requestState2;
                            this.d.e();
                        }
                    }
                    if (this.g) {
                        RequestCoordinator.RequestState requestState3 = this.e;
                        RequestCoordinator.RequestState requestState4 = RequestCoordinator.RequestState.RUNNING;
                        if (requestState3 != requestState4) {
                            this.e = requestState4;
                            this.c.e();
                        }
                    }
                    this.g = false;
                } catch (Throwable th) {
                    this.g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // defpackage.ef2
    public boolean f(ef2 ef2Var) {
        if (!(ef2Var instanceof c)) {
            return false;
        }
        c cVar = (c) ef2Var;
        if (this.c == null) {
            if (cVar.c != null) {
                return false;
            }
        } else if (!this.c.f(cVar.c)) {
            return false;
        }
        if (this.d == null) {
            if (cVar.d != null) {
                return false;
            }
        } else if (!this.d.f(cVar.d)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean g(ef2 ef2Var) {
        boolean z;
        synchronized (this.b) {
            try {
                z = l() && ef2Var.equals(this.c) && !b();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.b) {
            try {
                RequestCoordinator requestCoordinator = this.a;
                root = requestCoordinator != null ? requestCoordinator.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean h(ef2 ef2Var) {
        boolean z;
        synchronized (this.b) {
            try {
                z = m() && (ef2Var.equals(this.c) || this.e != RequestCoordinator.RequestState.SUCCESS);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // defpackage.ef2
    public boolean i() {
        boolean z;
        synchronized (this.b) {
            z = this.e == RequestCoordinator.RequestState.CLEARED;
        }
        return z;
    }

    @Override // defpackage.ef2
    public boolean isRunning() {
        boolean z;
        synchronized (this.b) {
            z = this.e == RequestCoordinator.RequestState.RUNNING;
        }
        return z;
    }

    @Override // defpackage.ef2
    public boolean j() {
        boolean z;
        synchronized (this.b) {
            z = this.e == RequestCoordinator.RequestState.SUCCESS;
        }
        return z;
    }

    public void n(ef2 ef2Var, ef2 ef2Var2) {
        this.c = ef2Var;
        this.d = ef2Var2;
    }

    @Override // defpackage.ef2
    public void pause() {
        synchronized (this.b) {
            try {
                if (!this.f.isComplete()) {
                    this.f = RequestCoordinator.RequestState.PAUSED;
                    this.d.pause();
                }
                if (!this.e.isComplete()) {
                    this.e = RequestCoordinator.RequestState.PAUSED;
                    this.c.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
