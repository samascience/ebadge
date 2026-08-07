package com.jieli.jl_rcsp.tool.callback;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseCallbackManager<T> {
    public final ArrayList<T> a;
    public final Handler b;

    public interface CallbackImpl<T> {
        void onPost(T t);
    }

    public class CallbackRunnable implements Runnable {
        public final CallbackImpl<T> a;

        public CallbackRunnable(CallbackImpl<T> callbackImpl) {
            this.a = callbackImpl;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BaseCallbackManager.this.a.isEmpty() || this.a == null) {
                return;
            }
            Iterator it = new ArrayList(BaseCallbackManager.this.a).iterator();
            while (it.hasNext()) {
                this.a.onPost((T) it.next());
            }
        }
    }

    public BaseCallbackManager() {
        this(new Handler(Looper.getMainLooper()));
    }

    public void callbackEvent(CallbackImpl<T> callbackImpl) {
        if (callbackImpl == null) {
            return;
        }
        CallbackRunnable callbackRunnable = new CallbackRunnable(callbackImpl);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.b.post(callbackRunnable);
        } else {
            callbackRunnable.run();
        }
    }

    public void registerCallback(T t) {
        if (t == null || this.a.contains(t)) {
            return;
        }
        this.a.add(t);
    }

    public void release() {
        this.a.clear();
        this.b.removeCallbacksAndMessages(null);
    }

    public void unregisterCallback(T t) {
        if (t == null || this.a.isEmpty()) {
            return;
        }
        this.a.remove(t);
    }

    public BaseCallbackManager(Handler handler) {
        this.a = new ArrayList<>();
        this.b = handler == null ? new Handler(Looper.getMainLooper()) : handler;
    }
}
