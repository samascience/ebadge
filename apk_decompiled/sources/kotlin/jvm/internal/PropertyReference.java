package kotlin.jvm.internal;

import defpackage.g81;
import defpackage.p31;
import defpackage.q81;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PropertyReference extends CallableReference implements q81 {
    private final boolean syntheticJavaProperty;

    public PropertyReference() {
        this.syntheticJavaProperty = false;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public g81 compute() {
        return this.syntheticJavaProperty ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return getOwner().equals(propertyReference.getOwner()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && p31.a(getBoundReceiver(), propertyReference.getBoundReceiver());
        }
        if (obj instanceof q81) {
            return obj.equals(compute());
        }
        return false;
    }

    public abstract /* synthetic */ q81.a getGetter();

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // defpackage.q81
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // defpackage.q81
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        g81 g81VarCompute = compute();
        if (g81VarCompute != this) {
            return g81VarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference
    public q81 getReflected() {
        if (this.syntheticJavaProperty) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        return (q81) super.getReflected();
    }

    public PropertyReference(Object obj) {
        super(obj);
        this.syntheticJavaProperty = false;
    }

    public PropertyReference(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.syntheticJavaProperty = (i & 2) == 2;
    }
}
