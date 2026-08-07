package kotlin.jvm.internal;

import defpackage.g81;
import defpackage.i81;
import defpackage.ke2;
import defpackage.u81;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CallableReference implements g81, Serializable {
    public static final Object NO_RECEIVER = NoReceiver.INSTANCE;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient g81 reflected;
    private final String signature;

    private static class NoReceiver implements Serializable {
        private static final NoReceiver INSTANCE = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() throws ObjectStreamException {
            return INSTANCE;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    @Override // defpackage.g81
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // defpackage.g81
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public g81 compute() {
        g81 g81Var = this.reflected;
        if (g81Var != null) {
            return g81Var;
        }
        g81 g81VarComputeReflected = computeReflected();
        this.reflected = g81VarComputeReflected;
        return g81VarComputeReflected;
    }

    protected abstract g81 computeReflected();

    @Override // defpackage.f81
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public i81 getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? ke2.c(cls) : ke2.b(cls);
    }

    @Override // defpackage.g81
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    protected g81 getReflected() {
        g81 g81VarCompute = compute();
        if (g81VarCompute != this) {
            return g81VarCompute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // defpackage.g81
    public u81 getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // defpackage.g81
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // defpackage.g81
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // defpackage.g81
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // defpackage.g81
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // defpackage.g81
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // defpackage.g81
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    protected CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    protected CallableReference(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }
}
