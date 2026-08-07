package defpackage;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class dm0 implements Comparator {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(u93 u93Var, u93 u93Var2) {
        return u93Var.a().lastModified() > u93Var2.a().lastModified() ? -1 : 1;
    }
}
