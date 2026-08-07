package androidx.databinding;

import android.util.Log;
import android.view.View;
import defpackage.v50;
import defpackage.w50;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MergedDataBinderMapper extends v50 {
    private Set a = new HashSet();
    private List b = new CopyOnWriteArrayList();
    private List c = new CopyOnWriteArrayList();

    private boolean b() {
        boolean z = false;
        for (String str : this.c) {
            try {
                Class<?> cls = Class.forName(str);
                if (v50.class.isAssignableFrom(cls)) {
                    a((v50) cls.newInstance());
                    this.c.remove(str);
                    z = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e);
            } catch (InstantiationException e2) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e2);
            }
        }
        return z;
    }

    public void a(v50 v50Var) {
        if (this.a.add(v50Var.getClass())) {
            this.b.add(v50Var);
            Iterator it = v50Var.collectDependencies().iterator();
            while (it.hasNext()) {
                a((v50) it.next());
            }
        }
    }

    @Override // defpackage.v50
    public ViewDataBinding getDataBinder(w50 w50Var, View view, int i) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ViewDataBinding dataBinder = ((v50) it.next()).getDataBinder(w50Var, view, i);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (b()) {
            return getDataBinder(w50Var, view, i);
        }
        return null;
    }

    @Override // defpackage.v50
    public ViewDataBinding getDataBinder(w50 w50Var, View[] viewArr, int i) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ViewDataBinding dataBinder = ((v50) it.next()).getDataBinder(w50Var, viewArr, i);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (b()) {
            return getDataBinder(w50Var, viewArr, i);
        }
        return null;
    }
}
