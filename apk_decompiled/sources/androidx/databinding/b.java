package androidx.databinding;

/* JADX INFO: loaded from: classes.dex */
abstract class b extends androidx.databinding.a {

    class a extends g.a {
        a() {
        }

        @Override // androidx.databinding.g.a
        public void b(g gVar, int i) {
            b.this.notifyChange();
        }
    }

    public b() {
    }

    public b(g... gVarArr) {
        if (gVarArr == null || gVarArr.length == 0) {
            return;
        }
        a aVar = new a();
        for (g gVar : gVarArr) {
            gVar.addOnPropertyChangedCallback(aVar);
        }
    }
}
