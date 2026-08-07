package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class ng2 {
    public abstract ng2 getReferencedType();

    public boolean isReferenceType() {
        return getReferencedType() != null;
    }

    public abstract String toCanonical();
}
