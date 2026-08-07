package kotlin.text;

import defpackage.dg1;
import defpackage.e31;
import defpackage.ga2;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h {
    /* JADX INFO: Access modifiers changed from: private */
    public static final dg1 f(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new g(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final dg1 g(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new g(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e31 h(MatchResult matchResult) {
        return ga2.k(matchResult.start(), matchResult.end());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e31 i(MatchResult matchResult, int i) {
        return ga2.k(matchResult.start(i), matchResult.end(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j(Iterable iterable) {
        Iterator it = iterable.iterator();
        int value = 0;
        while (it.hasNext()) {
            value |= ((e) it.next()).getValue();
        }
        return value;
    }
}
