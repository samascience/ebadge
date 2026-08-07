package com.jieli.bluetooth_connect.tool;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseCbManager<T> {
    private final ArrayList<T> mListeners = new ArrayList<>();
    private final Handler mUIHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: protected */
    public interface CallbackImpl<T> {
        void onCallback(T t);
    }

    private class CallbackRunnable implements Runnable {
        private final CallbackImpl<T> mImpl;

        public CallbackRunnable(CallbackImpl<T> callbackImpl) {
            this.mImpl = callbackImpl;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mImpl == null || BaseCbManager.this.mListeners.isEmpty()) {
                return;
            }
            Iterator it = new ArrayList(BaseCbManager.this.mListeners).iterator();
            while (it.hasNext()) {
                this.mImpl.onCallback((T) it.next());
            }
        }
    }

    BaseCbManager() {
    }

    public boolean addListener(T t) {
        if (t == null) {
            return false;
        }
        if (this.mListeners.contains(t)) {
            return true;
        }
        return this.mListeners.add(t);
    }

    public void callbackEvent(CallbackImpl<T> callbackImpl) {
        if (callbackImpl == null) {
            return;
        }
        CallbackRunnable callbackRunnable = new CallbackRunnable(callbackImpl);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mUIHandler.post(callbackRunnable);
        } else {
            callbackRunnable.run();
        }
    }

    public void destroy() {
        this.mListeners.clear();
        this.mUIHandler.removeCallbacksAndMessages(null);
    }

    public boolean removeListener(T t) {
        if (t == null || this.mListeners.isEmpty()) {
            return false;
        }
        return this.mListeners.remove(t);
    }
}
