package androidx.databinding;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements g {
    private transient k mCallbacks;

    @Override // androidx.databinding.g
    public void addOnPropertyChangedCallback(g.a aVar) {
        synchronized (this) {
            try {
                if (this.mCallbacks == null) {
                    this.mCallbacks = new k();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mCallbacks.a(aVar);
    }

    public void notifyChange() {
        synchronized (this) {
            try {
                k kVar = this.mCallbacks;
                if (kVar == null) {
                    return;
                }
                kVar.d(this, 0, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void notifyPropertyChanged(int i) {
        synchronized (this) {
            try {
                k kVar = this.mCallbacks;
                if (kVar == null) {
                    return;
                }
                kVar.d(this, i, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.g
    public void removeOnPropertyChangedCallback(g.a aVar) {
        synchronized (this) {
            try {
                k kVar = this.mCallbacks;
                if (kVar == null) {
                    return;
                }
                kVar.i(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
