package kotlin.enums;

import defpackage.p31;
import defpackage.vh0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static final vh0 a(Enum[] enumArr) {
        p31.f(enumArr, "entries");
        return new EnumEntriesList(enumArr);
    }
}
