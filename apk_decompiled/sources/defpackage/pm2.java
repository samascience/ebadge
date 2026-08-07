package defpackage;

import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class pm2 implements Iterator {
    private Iterator a;

    public pm2(Iterator it) {
        this.a = it;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public nm2 next() {
        return new om2(this.a.next());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.a.remove();
    }
}
