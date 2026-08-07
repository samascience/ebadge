package kotlin.uuid;

import defpackage.p31;

/* JADX INFO: loaded from: classes4.dex */
abstract class a {
    public static final Object a(Uuid uuid) {
        p31.f(uuid, "uuid");
        return new UuidSerialized(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }
}
