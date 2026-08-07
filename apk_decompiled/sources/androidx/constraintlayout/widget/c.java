package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private SparseIntArray a = new SparseIntArray();
    private HashMap b = new HashMap();

    public interface a {
    }

    public void a(int i, a aVar) {
        HashSet hashSet = (HashSet) this.b.get(Integer.valueOf(i));
        if (hashSet == null) {
            hashSet = new HashSet();
            this.b.put(Integer.valueOf(i), hashSet);
        }
        hashSet.add(new WeakReference(aVar));
    }

    public void b(int i, a aVar) {
        HashSet<WeakReference> hashSet = (HashSet) this.b.get(Integer.valueOf(i));
        if (hashSet == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (WeakReference weakReference : hashSet) {
            a aVar2 = (a) weakReference.get();
            if (aVar2 == null || aVar2 == aVar) {
                arrayList.add(weakReference);
            }
        }
        hashSet.removeAll(arrayList);
    }
}
