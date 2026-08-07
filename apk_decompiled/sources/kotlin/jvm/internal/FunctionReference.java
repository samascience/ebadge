package kotlin.jvm.internal;

import defpackage.g81;
import defpackage.j81;
import defpackage.ke2;
import defpackage.p31;
import defpackage.yr0;

/* JADX INFO: loaded from: classes4.dex */
public class FunctionReference extends CallableReference implements yr0, j81 {
    private final int arity;
    private final int flags;

    public FunctionReference(int i) {
        this(i, CallableReference.NO_RECEIVER, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected g81 computeReflected() {
        return ke2.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && this.flags == functionReference.flags && this.arity == functionReference.arity && p31.a(getBoundReceiver(), functionReference.getBoundReceiver()) && p31.a(getOwner(), functionReference.getOwner());
        }
        if (obj instanceof j81) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // defpackage.yr0
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // defpackage.j81
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // defpackage.j81
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // defpackage.j81
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // defpackage.j81
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.CallableReference, defpackage.g81
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        g81 g81VarCompute = compute();
        if (g81VarCompute != this) {
            return g81VarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public FunctionReference(int i, Object obj) {
        this(i, obj, null, null, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference
    public j81 getReflected() {
        return (j81) super.getReflected();
    }

    public FunctionReference(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.arity = i;
        this.flags = i2 >> 1;
    }
}
