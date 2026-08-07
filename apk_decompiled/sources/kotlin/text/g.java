package kotlin.text;

import defpackage.ar0;
import defpackage.bg1;
import defpackage.cg1;
import defpackage.dg1;
import defpackage.e31;
import defpackage.p31;
import defpackage.x0;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.text.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public final class g implements dg1 {
    private final Matcher a;
    private final CharSequence b;
    private final cg1 c;

    public static final class a extends x0 implements cg1 {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final bg1 f(a aVar, int i) {
            return aVar.e(i);
        }

        @Override // defpackage.x0, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof bg1) {
                return d((bg1) obj);
            }
            return false;
        }

        public /* bridge */ boolean d(bg1 bg1Var) {
            return super.contains(bg1Var);
        }

        public bg1 e(int i) {
            e31 e31VarI = h.i(g.this.c(), i);
            if (e31VarI.h().intValue() < 0) {
                return null;
            }
            String strGroup = g.this.c().group(i);
            p31.e(strGroup, "group(...)");
            return new bg1(strGroup, e31VarI);
        }

        @Override // defpackage.x0
        public int getSize() {
            return g.this.c().groupCount() + 1;
        }

        @Override // defpackage.x0, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return kotlin.sequences.d.v(kotlin.collections.j.C(kotlin.collections.j.k(this)), new ar0() { // from class: fg1
                @Override // defpackage.ar0
                public final Object invoke(Object obj) {
                    return g.a.f(this.a, ((Integer) obj).intValue());
                }
            }).iterator();
        }
    }

    public g(Matcher matcher, CharSequence charSequence) {
        p31.f(matcher, "matcher");
        p31.f(charSequence, "input");
        this.a = matcher;
        this.b = charSequence;
        this.c = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult c() {
        return this.a;
    }

    @Override // defpackage.dg1
    public e31 a() {
        return h.h(c());
    }

    @Override // defpackage.dg1
    public dg1 next() {
        int iEnd = c().end() + (c().end() == c().start() ? 1 : 0);
        if (iEnd > this.b.length()) {
            return null;
        }
        Matcher matcher = this.a.pattern().matcher(this.b);
        p31.e(matcher, "matcher(...)");
        return h.f(matcher, iEnd, this.b);
    }
}
