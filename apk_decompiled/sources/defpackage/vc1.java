package defpackage;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class vc1 implements uc1 {
    private final LocaleList a;

    vc1(Object obj) {
        this.a = (LocaleList) obj;
    }

    @Override // defpackage.uc1
    public String a() {
        return this.a.toLanguageTags();
    }

    @Override // defpackage.uc1
    public Object b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this.a.equals(((uc1) obj).b());
    }

    @Override // defpackage.uc1
    public Locale get(int i) {
        return this.a.get(i);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // defpackage.uc1
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // defpackage.uc1
    public int size() {
        return this.a.size();
    }

    public String toString() {
        return this.a.toString();
    }
}
