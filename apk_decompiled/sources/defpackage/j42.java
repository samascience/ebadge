package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class j42 extends i42 {
    private final Object c;

    public j42(int i) {
        super(i);
        this.c = new Object();
    }

    @Override // defpackage.i42, defpackage.h42
    public boolean a(Object obj) {
        boolean zA;
        p31.f(obj, "instance");
        synchronized (this.c) {
            zA = super.a(obj);
        }
        return zA;
    }

    @Override // defpackage.i42, defpackage.h42
    public Object b() {
        Object objB;
        synchronized (this.c) {
            objB = super.b();
        }
        return objB;
    }
}
