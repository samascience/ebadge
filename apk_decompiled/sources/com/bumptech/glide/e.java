package com.bumptech.glide;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.SingleRequest;
import defpackage.ac0;
import defpackage.aj0;
import defpackage.ef2;
import defpackage.ef3;
import defpackage.if2;
import defpackage.j03;
import defpackage.na3;
import defpackage.of2;
import defpackage.z42;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class e extends com.bumptech.glide.request.a implements Cloneable {
    protected static final of2 T = (of2) ((of2) ((of2) new of2().f(ac0.c)).W(Priority.LOW)).d0(true);
    private final Context F;
    private final f G;
    private final Class H;
    private final com.bumptech.glide.a I;
    private final c J;
    private g K;
    private Object L;
    private List M;
    private e N;
    private e O;
    private Float P;
    private boolean Q = true;
    private boolean R;
    private boolean S;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[Priority.values().length];
            b = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    protected e(com.bumptech.glide.a aVar, f fVar, Class cls, Context context) {
        this.I = aVar;
        this.G = fVar;
        this.H = cls;
        this.F = context;
        this.K = fVar.p(cls);
        this.J = aVar.i();
        q0(fVar.n());
        a(fVar.o());
    }

    private e A0(Object obj) {
        if (D()) {
            return clone().A0(obj);
        }
        this.L = obj;
        this.R = true;
        return (e) Z();
    }

    private ef2 B0(Object obj, j03 j03Var, if2 if2Var, com.bumptech.glide.request.a aVar, RequestCoordinator requestCoordinator, g gVar, Priority priority, int i, int i2, Executor executor) {
        Context context = this.F;
        c cVar = this.J;
        return SingleRequest.x(context, cVar, obj, this.L, this.H, aVar, i, i2, priority, j03Var, if2Var, this.M, requestCoordinator, cVar.f(), gVar.b(), executor);
    }

    private ef2 l0(j03 j03Var, if2 if2Var, com.bumptech.glide.request.a aVar, Executor executor) {
        return m0(new Object(), j03Var, if2Var, null, this.K, aVar.v(), aVar.s(), aVar.r(), aVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private ef2 m0(Object obj, j03 j03Var, if2 if2Var, RequestCoordinator requestCoordinator, g gVar, Priority priority, int i, int i2, com.bumptech.glide.request.a aVar, Executor executor) {
        RequestCoordinator requestCoordinator2;
        RequestCoordinator bVar;
        if (this.O != null) {
            bVar = new com.bumptech.glide.request.b(obj, requestCoordinator);
            requestCoordinator2 = bVar;
        } else {
            requestCoordinator2 = null;
            bVar = requestCoordinator;
        }
        ef2 ef2VarN0 = n0(obj, j03Var, if2Var, bVar, gVar, priority, i, i2, aVar, executor);
        if (requestCoordinator2 == null) {
            return ef2VarN0;
        }
        int iS = this.O.s();
        int iR = this.O.r();
        if (na3.s(i, i2) && !this.O.M()) {
            iS = aVar.s();
            iR = aVar.r();
        }
        e eVar = this.O;
        com.bumptech.glide.request.b bVar2 = requestCoordinator2;
        bVar2.o(ef2VarN0, eVar.m0(obj, j03Var, if2Var, bVar2, eVar.K, eVar.v(), iS, iR, this.O, executor));
        return bVar2;
    }

    private ef2 n0(Object obj, j03 j03Var, if2 if2Var, RequestCoordinator requestCoordinator, g gVar, Priority priority, int i, int i2, com.bumptech.glide.request.a aVar, Executor executor) {
        e eVar = this.N;
        if (eVar == null) {
            if (this.P == null) {
                return B0(obj, j03Var, if2Var, aVar, requestCoordinator, gVar, priority, i, i2, executor);
            }
            com.bumptech.glide.request.c cVar = new com.bumptech.glide.request.c(obj, requestCoordinator);
            cVar.n(B0(obj, j03Var, if2Var, aVar, cVar, gVar, priority, i, i2, executor), B0(obj, j03Var, if2Var, aVar.clone().c0(this.P.floatValue()), cVar, gVar, p0(priority), i, i2, executor));
            return cVar;
        }
        if (this.S) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        g gVar2 = eVar.Q ? gVar : eVar.K;
        Priority priorityV = eVar.F() ? this.N.v() : p0(priority);
        int iS = this.N.s();
        int iR = this.N.r();
        if (na3.s(i, i2) && !this.N.M()) {
            iS = aVar.s();
            iR = aVar.r();
        }
        com.bumptech.glide.request.c cVar2 = new com.bumptech.glide.request.c(obj, requestCoordinator);
        ef2 ef2VarB0 = B0(obj, j03Var, if2Var, aVar, cVar2, gVar, priority, i, i2, executor);
        this.S = true;
        e eVar2 = this.N;
        ef2 ef2VarM0 = eVar2.m0(obj, j03Var, if2Var, cVar2, gVar2, priorityV, iS, iR, eVar2, executor);
        this.S = false;
        cVar2.n(ef2VarB0, ef2VarM0);
        return cVar2;
    }

    private Priority p0(Priority priority) {
        int i = a.b[priority.ordinal()];
        if (i == 1) {
            return Priority.NORMAL;
        }
        if (i == 2) {
            return Priority.HIGH;
        }
        if (i == 3 || i == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + v());
    }

    private void q0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            j0((if2) it.next());
        }
    }

    private j03 s0(j03 j03Var, if2 if2Var, com.bumptech.glide.request.a aVar, Executor executor) {
        z42.d(j03Var);
        if (!this.R) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        ef2 ef2VarL0 = l0(j03Var, if2Var, aVar, executor);
        ef2 ef2VarG = j03Var.g();
        if (ef2VarL0.f(ef2VarG) && !v0(aVar, ef2VarG)) {
            if (!((ef2) z42.d(ef2VarG)).isRunning()) {
                ef2VarG.e();
            }
            return j03Var;
        }
        this.G.m(j03Var);
        j03Var.c(ef2VarL0);
        this.G.x(j03Var, ef2VarL0);
        return j03Var;
    }

    private boolean v0(com.bumptech.glide.request.a aVar, ef2 ef2Var) {
        return !aVar.E() && ef2Var.j();
    }

    public e j0(if2 if2Var) {
        if (D()) {
            return clone().j0(if2Var);
        }
        if (if2Var != null) {
            if (this.M == null) {
                this.M = new ArrayList();
            }
            this.M.add(if2Var);
        }
        return (e) Z();
    }

    @Override // com.bumptech.glide.request.a
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public e a(com.bumptech.glide.request.a aVar) {
        z42.d(aVar);
        return (e) super.a(aVar);
    }

    @Override // com.bumptech.glide.request.a
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public e clone() {
        e eVar = (e) super.clone();
        eVar.K = eVar.K.clone();
        if (eVar.M != null) {
            eVar.M = new ArrayList(eVar.M);
        }
        e eVar2 = eVar.N;
        if (eVar2 != null) {
            eVar.N = eVar2.clone();
        }
        e eVar3 = eVar.O;
        if (eVar3 != null) {
            eVar.O = eVar3.clone();
        }
        return eVar;
    }

    public j03 r0(j03 j03Var) {
        return t0(j03Var, null, aj0.b());
    }

    j03 t0(j03 j03Var, if2 if2Var, Executor executor) {
        return s0(j03Var, if2Var, this, executor);
    }

    public ef3 u0(ImageView imageView) {
        com.bumptech.glide.request.a aVarO;
        na3.a();
        z42.d(imageView);
        if (!L() && J() && imageView.getScaleType() != null) {
            switch (a.a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVarO = clone().O();
                    break;
                case 2:
                    aVarO = clone().P();
                    break;
                case 3:
                case 4:
                case 5:
                    aVarO = clone().Q();
                    break;
                case 6:
                    aVarO = clone().P();
                    break;
                default:
                    aVarO = this;
                    break;
            }
        } else {
            aVarO = this;
        }
        return (ef3) s0(this.J.a(imageView, this.H), null, aVarO, aj0.b());
    }

    public e w0(if2 if2Var) {
        if (D()) {
            return clone().w0(if2Var);
        }
        this.M = null;
        return j0(if2Var);
    }

    public e x0(Uri uri) {
        return A0(uri);
    }

    public e y0(Object obj) {
        return A0(obj);
    }

    public e z0(String str) {
        return A0(str);
    }
}
