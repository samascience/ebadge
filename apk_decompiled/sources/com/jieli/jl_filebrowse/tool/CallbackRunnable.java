package com.jieli.jl_filebrowse.tool;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class CallbackRunnable<T> implements Runnable {
    public final ArrayList<T> a;
    public final CallbackImpl<T> b;

    public CallbackRunnable(ArrayList<T> arrayList, CallbackImpl<T> callbackImpl) {
        this.a = arrayList;
        this.b = callbackImpl;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList<T> arrayList = this.a;
        if (arrayList == null || this.b == null || arrayList.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.a).iterator();
        while (it.hasNext()) {
            this.b.onCallback((T) it.next());
        }
    }
}
