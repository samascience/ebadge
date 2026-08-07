package com.soundcloud.android.crop;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
abstract class d extends Activity {
    private final ArrayList a = new ArrayList();

    public static class a implements b {
        @Override // com.soundcloud.android.crop.d.b
        public void b(d dVar) {
        }
    }

    public interface b {
        void a(d dVar);

        void b(d dVar);

        void c(d dVar);

        void d(d dVar);
    }

    d() {
    }

    public void a(b bVar) {
        if (this.a.contains(bVar)) {
            return;
        }
        this.a.add(bVar);
    }

    public void b(b bVar) {
        this.a.remove(bVar);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).b(this);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).c(this);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).d(this);
        }
    }
}
