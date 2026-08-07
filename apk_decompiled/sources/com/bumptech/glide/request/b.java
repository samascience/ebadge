package com.bumptech.glide.request;

import defpackage.ef2;

/* JADX INFO: loaded from: classes.dex */
public final class b implements RequestCoordinator, ef2 {
    private final Object a;
    private final RequestCoordinator b;
    private volatile ef2 c;
    private volatile ef2 d;
    private RequestCoordinator.RequestState e;
    private RequestCoordinator.RequestState f;

    public b(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.e = requestState;
        this.f = requestState;
        this.a = obj;
        this.b = requestCoordinator;
    }

    private boolean k(ef2 ef2Var) {
        return ef2Var.equals(this.c) || (this.e == RequestCoordinator.RequestState.FAILED && ef2Var.equals(this.d));
    }

    private boolean l() {
        RequestCoordinator requestCoordinator = this.b;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    private boolean m() {
        RequestCoordinator requestCoordinator = this.b;
        return requestCoordinator == null || requestCoordinator.g(this);
    }

    private boolean n() {
        RequestCoordinator requestCoordinator = this.b;
        return requestCoordinator == null || requestCoordinator.h(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void a(ef2 ef2Var) {
        synchronized (this.a) {
            try {
                if (ef2Var.equals(this.d)) {
                    this.f = RequestCoordinator.RequestState.FAILED;
                    RequestCoordinator requestCoordinator = this.b;
                    if (requestCoordinator != null) {
                        requestCoordinator.a(this);
                    }
                    return;
                }
                this.e = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator.RequestState requestState = this.f;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.f = requestState2;
                    this.d.e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, defpackage.ef2
    public boolean b() {
        boolean z;
        synchronized (this.a) {
            try {
                z = this.c.b() || this.d.b();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void c(ef2 ef2Var) {
        synchronized (this.a) {
            try {
                if (ef2Var.equals(this.c)) {
                    this.e = RequestCoordinator.RequestState.SUCCESS;
                } else if (ef2Var.equals(this.d)) {
                    this.f = RequestCoordinator.RequestState.SUCCESS;
                }
                RequestCoordinator requestCoordinator = this.b;
                if (requestCoordinator != null) {
                    requestCoordinator.c(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.ef2
    public void clear() {
        synchronized (this.a) {
            try {
                RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
                this.e = requestState;
                this.c.clear();
                if (this.f != requestState) {
                    this.f = requestState;
                    this.d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean d(ef2 ef2Var) {
        boolean z;
        synchronized (this.a) {
            try {
                z = l() && k(ef2Var);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // defpackage.ef2
    public void e() {
        synchronized (this.a) {
            try {
                RequestCoordinator.RequestState requestState = this.e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.e = requestState2;
                    this.c.e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.ef2
    public boolean f(ef2 ef2Var) {
        if (!(ef2Var instanceof b)) {
            return false;
        }
        b bVar = (b) ef2Var;
        return this.c.f(bVar.c) && this.d.f(bVar.d);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean g(ef2 ef2Var) {
        boolean z;
        synchronized (this.a) {
            try {
                z = m() && k(ef2Var);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.a) {
            try {
                RequestCoordinator requestCoordinator = this.b;
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
        synchronized (this.a) {
            try {
                z = n() && k(ef2Var);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // defpackage.ef2
    public boolean i() {
        boolean z;
        synchronized (this.a) {
            try {
                RequestCoordinator.RequestState requestState = this.e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
                z = requestState == requestState2 && this.f == requestState2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // defpackage.ef2
    public boolean isRunning() {
        boolean z;
        synchronized (this.a) {
            try {
                RequestCoordinator.RequestState requestState = this.e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                z = requestState == requestState2 || this.f == requestState2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // defpackage.ef2
    public boolean j() {
        boolean z;
        synchronized (this.a) {
            try {
                RequestCoordinator.RequestState requestState = this.e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
                z = requestState == requestState2 || this.f == requestState2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public void o(ef2 ef2Var, ef2 ef2Var2) {
        this.c = ef2Var;
        this.d = ef2Var2;
    }

    @Override // defpackage.ef2
    public void pause() {
        synchronized (this.a) {
            try {
                RequestCoordinator.RequestState requestState = this.e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState == requestState2) {
                    this.e = RequestCoordinator.RequestState.PAUSED;
                    this.c.pause();
                }
                if (this.f == requestState2) {
                    this.f = RequestCoordinator.RequestState.PAUSED;
                    this.d.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
