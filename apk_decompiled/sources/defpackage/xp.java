package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class xp extends u9 {
    private int g;

    @Override // defpackage.ap2, java.util.Map
    public void clear() {
        this.g = 0;
        super.clear();
    }

    @Override // defpackage.ap2, java.util.Map
    public int hashCode() {
        if (this.g == 0) {
            this.g = super.hashCode();
        }
        return this.g;
    }

    @Override // defpackage.ap2
    public void i(ap2 ap2Var) {
        this.g = 0;
        super.i(ap2Var);
    }

    @Override // defpackage.ap2
    public Object j(int i) {
        this.g = 0;
        return super.j(i);
    }

    @Override // defpackage.ap2
    public Object k(int i, Object obj) {
        this.g = 0;
        return super.k(i, obj);
    }

    @Override // defpackage.ap2, java.util.Map
    public Object put(Object obj, Object obj2) {
        this.g = 0;
        return super.put(obj, obj2);
    }
}
