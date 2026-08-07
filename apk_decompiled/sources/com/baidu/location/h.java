package com.baidu.location;

/* JADX INFO: loaded from: classes.dex */
class h extends Thread {
    final /* synthetic */ c a;

    h(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (this.a.B != null) {
                this.a.B.f();
                this.a.B.r();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
