package defpackage;

import androidx.work.OverwritingInputMerger;

/* JADX INFO: loaded from: classes.dex */
public final class qw1 extends wk3 {

    public static final class a extends wk3.a {
        public a(Class cls) {
            super(cls);
            this.c.d = OverwritingInputMerger.class.getName();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // wk3.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public qw1 c() {
            if (this.a && this.c.j.h()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            return new qw1(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // wk3.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public a d() {
            return this;
        }
    }

    qw1(a aVar) {
        super(aVar.b, aVar.c, aVar.d);
    }

    public static qw1 d(Class cls) {
        return (qw1) new a(cls).b();
    }
}
