package defpackage;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes3.dex */
public class ym1 implements Observer {
    private wt1 a;

    public ym1(wt1 wt1Var) {
        this.a = wt1Var;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.a.onError(th);
    }

    @Override // io.reactivex.Observer
    public void onNext(Object obj) {
        this.a.onNext(obj);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
    }
}
