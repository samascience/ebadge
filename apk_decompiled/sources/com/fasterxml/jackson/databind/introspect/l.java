package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.tencent.connect.common.Constants;
import defpackage.ay;
import defpackage.d7;
import defpackage.l10;
import defpackage.lt1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class l extends com.fasterxml.jackson.databind.introspect.g implements Comparable {
    private static final AnnotationIntrospector.ReferenceProperty m = AnnotationIntrospector.ReferenceProperty.e(Constants.STR_EMPTY);
    protected final boolean b;
    protected final MapperConfig c;
    protected final AnnotationIntrospector d;
    protected final PropertyName e;
    protected final PropertyName f;
    protected g g;
    protected g h;
    protected g i;
    protected g j;
    protected transient PropertyMetadata k;
    protected transient AnnotationIntrospector.ReferenceProperty l;

    class a implements i {
        a() {
        }

        @Override // com.fasterxml.jackson.databind.introspect.l.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Class[] a(AnnotatedMember annotatedMember) {
            return l.this.d.findViews(annotatedMember);
        }
    }

    class b implements i {
        b() {
        }

        @Override // com.fasterxml.jackson.databind.introspect.l.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AnnotationIntrospector.ReferenceProperty a(AnnotatedMember annotatedMember) {
            return l.this.d.findReferenceType(annotatedMember);
        }
    }

    class c implements i {
        c() {
        }

        @Override // com.fasterxml.jackson.databind.introspect.l.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(AnnotatedMember annotatedMember) {
            return l.this.d.isTypeId(annotatedMember);
        }
    }

    class d implements i {
        d() {
        }

        @Override // com.fasterxml.jackson.databind.introspect.l.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public lt1 a(AnnotatedMember annotatedMember) {
            lt1 lt1VarFindObjectIdInfo = l.this.d.findObjectIdInfo(annotatedMember);
            return lt1VarFindObjectIdInfo != null ? l.this.d.findObjectReferenceInfo(annotatedMember, lt1VarFindObjectIdInfo) : lt1VarFindObjectIdInfo;
        }
    }

    class e implements i {
        e() {
        }

        @Override // com.fasterxml.jackson.databind.introspect.l.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public JsonProperty.Access a(AnnotatedMember annotatedMember) {
            return l.this.d.findPropertyAccess(annotatedMember);
        }
    }

    static /* synthetic */ class f {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonProperty.Access.values().length];
            a = iArr;
            try {
                iArr[JsonProperty.Access.READ_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonProperty.Access.READ_WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonProperty.Access.WRITE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonProperty.Access.AUTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    protected static final class g {
        public final Object a;
        public final g b;
        public final PropertyName c;
        public final boolean d;
        public final boolean e;
        public final boolean f;

        public g(Object obj, g gVar, PropertyName propertyName, boolean z, boolean z2, boolean z3) {
            this.a = obj;
            this.b = gVar;
            PropertyName propertyName2 = (propertyName == null || propertyName.isEmpty()) ? null : propertyName;
            this.c = propertyName2;
            if (z) {
                if (propertyName2 == null) {
                    throw new IllegalArgumentException("Cannot pass true for 'explName' if name is null/empty");
                }
                if (!propertyName.hasSimpleName()) {
                    z = false;
                }
            }
            this.d = z;
            this.e = z2;
            this.f = z3;
        }

        protected g a(g gVar) {
            g gVar2 = this.b;
            return gVar2 == null ? c(gVar) : c(gVar2.a(gVar));
        }

        public g b() {
            g gVar = this.b;
            if (gVar == null) {
                return this;
            }
            g gVarB = gVar.b();
            if (this.c != null) {
                return gVarB.c == null ? c(null) : c(gVarB);
            }
            if (gVarB.c != null) {
                return gVarB;
            }
            boolean z = this.e;
            if (z == gVarB.e) {
                return c(gVarB);
            }
            return z ? c(null) : gVarB;
        }

        public g c(g gVar) {
            return gVar == this.b ? this : new g(this.a, gVar, this.c, this.d, this.e, this.f);
        }

        public g d(Object obj) {
            return obj == this.a ? this : new g(obj, this.b, this.c, this.d, this.e, this.f);
        }

        public g e() {
            g gVarE;
            if (!this.f) {
                g gVar = this.b;
                return (gVar == null || (gVarE = gVar.e()) == this.b) ? this : c(gVarE);
            }
            g gVar2 = this.b;
            if (gVar2 == null) {
                return null;
            }
            return gVar2.e();
        }

        public g f() {
            return this.b == null ? this : new g(this.a, null, this.c, this.d, this.e, this.f);
        }

        public g g() {
            g gVar = this.b;
            g gVarG = gVar == null ? null : gVar.g();
            return this.e ? c(gVarG) : gVarG;
        }

        public String toString() {
            String str = String.format("%s[visible=%b,ignore=%b,explicitName=%b]", this.a.toString(), Boolean.valueOf(this.e), Boolean.valueOf(this.f), Boolean.valueOf(this.d));
            if (this.b == null) {
                return str;
            }
            return str + ", " + this.b.toString();
        }
    }

    protected static class h implements Iterator {
        private g a;

        public h(g gVar) {
            this.a = gVar;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AnnotatedMember next() {
            g gVar = this.a;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            AnnotatedMember annotatedMember = (AnnotatedMember) gVar.a;
            this.a = gVar.b;
            return annotatedMember;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private interface i {
        Object a(AnnotatedMember annotatedMember);
    }

    public l(MapperConfig mapperConfig, AnnotationIntrospector annotationIntrospector, boolean z, PropertyName propertyName) {
        this(mapperConfig, annotationIntrospector, z, propertyName, propertyName);
    }

    private boolean A(g gVar) {
        while (gVar != null) {
            if (!gVar.f && gVar.c != null && gVar.d) {
                return true;
            }
            gVar = gVar.b;
        }
        return false;
    }

    private boolean B(g gVar) {
        while (gVar != null) {
            PropertyName propertyName = gVar.c;
            if (propertyName != null && propertyName.hasSimpleName()) {
                return true;
            }
            gVar = gVar.b;
        }
        return false;
    }

    private boolean C(g gVar) {
        PropertyName propertyName;
        while (gVar != null) {
            if (!gVar.f && (propertyName = gVar.c) != null && propertyName.hasSimpleName()) {
                return true;
            }
            gVar = gVar.b;
        }
        return false;
    }

    private boolean D(g gVar) {
        while (gVar != null) {
            if (gVar.f) {
                return true;
            }
            gVar = gVar.b;
        }
        return false;
    }

    private boolean E(g gVar) {
        while (gVar != null) {
            if (gVar.e) {
                return true;
            }
            gVar = gVar.b;
        }
        return false;
    }

    private g F(g gVar, com.fasterxml.jackson.databind.introspect.f fVar) {
        AnnotatedMember annotatedMember = (AnnotatedMember) ((AnnotatedMember) gVar.a).withAnnotations(fVar);
        g gVar2 = gVar.b;
        if (gVar2 != null) {
            gVar = gVar.c(F(gVar2, fVar));
        }
        return gVar.d(annotatedMember);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v0 ??, still in use, count: 1, list:
          (r8v0 ?? I:java.lang.Object) from 0x0023: INVOKE (r11v0 ?? I:java.util.Map), (r7v0 ?? I:java.lang.Object), (r8v0 ?? I:java.lang.Object) INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    private void G(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v0 ??, still in use, count: 1, list:
          (r8v0 ?? I:java.lang.Object) from 0x0023: INVOKE (r11v0 ?? I:java.util.Map), (r7v0 ?? I:java.lang.Object), (r8v0 ?? I:java.lang.Object) INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    private Set H(g gVar, Set set) {
        while (gVar != null) {
            if (gVar.d && gVar.c != null) {
                if (set == null) {
                    set = new HashSet();
                }
                set.add(gVar.c);
            }
            gVar = gVar.b;
        }
        return set;
    }

    private com.fasterxml.jackson.databind.introspect.f I(g gVar) {
        com.fasterxml.jackson.databind.introspect.f allAnnotations = ((AnnotatedMember) gVar.a).getAllAnnotations();
        g gVar2 = gVar.b;
        return gVar2 != null ? com.fasterxml.jackson.databind.introspect.f.d(allAnnotations, I(gVar2)) : allAnnotations;
    }

    private com.fasterxml.jackson.databind.introspect.f L(int i2, g... gVarArr) {
        com.fasterxml.jackson.databind.introspect.f fVarI = I(gVarArr[i2]);
        do {
            i2++;
            if (i2 >= gVarArr.length) {
                return fVarI;
            }
        } while (gVarArr[i2] == null);
        return com.fasterxml.jackson.databind.introspect.f.d(fVarI, L(i2, gVarArr));
    }

    private g N(g gVar) {
        return gVar == null ? gVar : gVar.e();
    }

    private g O(g gVar) {
        return gVar == null ? gVar : gVar.g();
    }

    private g S(g gVar) {
        return gVar == null ? gVar : gVar.b();
    }

    private static g n0(g gVar, g gVar2) {
        if (gVar == null) {
            return gVar2;
        }
        return gVar2 == null ? gVar : gVar.a(gVar2);
    }

    private boolean z(g gVar) {
        while (gVar != null) {
            if (gVar.c != null && gVar.d) {
                return true;
            }
            gVar = gVar.b;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035 A[PHI: r1 r7
      0x0035: PHI (r1v3 boolean) = (r1v0 boolean), (r1v6 boolean) binds: [B:5:0x000b, B:14:0x002a] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r7v5 com.fasterxml.jackson.databind.PropertyMetadata) = (r7v0 com.fasterxml.jackson.databind.PropertyMetadata), (r7v9 com.fasterxml.jackson.databind.PropertyMetadata) binds: [B:5:0x000b, B:14:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    protected PropertyMetadata J(PropertyMetadata propertyMetadata, AnnotatedMember annotatedMember) {
        Nulls nullsNonDefaultContentNulls;
        Boolean mergeable;
        Boolean boolFindMergeInfo;
        AnnotatedMember annotatedMemberH = h();
        boolean z = true;
        Nulls nullsNonDefaultValueNulls = null;
        if (annotatedMember != null) {
            AnnotationIntrospector annotationIntrospector = this.d;
            if (annotationIntrospector == null) {
                nullsNonDefaultContentNulls = null;
            } else {
                if (annotatedMemberH != null && (boolFindMergeInfo = annotationIntrospector.findMergeInfo(annotatedMember)) != null) {
                    if (boolFindMergeInfo.booleanValue()) {
                        propertyMetadata = propertyMetadata.withMergeInfo(PropertyMetadata.a.b(annotatedMemberH));
                    }
                    z = false;
                }
                JsonSetter.Value valueFindSetterInfo = this.d.findSetterInfo(annotatedMember);
                if (valueFindSetterInfo != null) {
                    nullsNonDefaultValueNulls = valueFindSetterInfo.nonDefaultValueNulls();
                    nullsNonDefaultContentNulls = valueFindSetterInfo.nonDefaultContentNulls();
                } else {
                    nullsNonDefaultContentNulls = null;
                }
            }
            if (z || nullsNonDefaultValueNulls == null || nullsNonDefaultContentNulls == null) {
                l10 configOverride = this.c.getConfigOverride(M(annotatedMember));
                JsonSetter.Value setterInfo = configOverride.getSetterInfo();
                if (setterInfo != null) {
                    if (nullsNonDefaultValueNulls == null) {
                        nullsNonDefaultValueNulls = setterInfo.nonDefaultValueNulls();
                    }
                    if (nullsNonDefaultContentNulls == null) {
                        nullsNonDefaultContentNulls = setterInfo.nonDefaultContentNulls();
                    }
                }
                if (z && annotatedMemberH != null && (mergeable = configOverride.getMergeable()) != null) {
                    if (mergeable.booleanValue()) {
                        propertyMetadata = propertyMetadata.withMergeInfo(PropertyMetadata.a.c(annotatedMemberH));
                    }
                    z = false;
                }
            }
        } else {
            nullsNonDefaultContentNulls = null;
        }
        if (z || nullsNonDefaultValueNulls == null || nullsNonDefaultContentNulls == null) {
            JsonSetter.Value defaultSetterInfo = this.c.getDefaultSetterInfo();
            if (nullsNonDefaultValueNulls == null) {
                nullsNonDefaultValueNulls = defaultSetterInfo.nonDefaultValueNulls();
            }
            if (nullsNonDefaultContentNulls == null) {
                nullsNonDefaultContentNulls = defaultSetterInfo.nonDefaultContentNulls();
            }
            if (z) {
                if (Boolean.TRUE.equals(this.c.getDefaultMergeable()) && annotatedMemberH != null) {
                    propertyMetadata = propertyMetadata.withMergeInfo(PropertyMetadata.a.a(annotatedMemberH));
                }
            }
        }
        return (nullsNonDefaultValueNulls == null && nullsNonDefaultContentNulls == null) ? propertyMetadata : propertyMetadata.withNulls(nullsNonDefaultValueNulls, nullsNonDefaultContentNulls);
    }

    protected int K(AnnotatedMethod annotatedMethod) {
        String name = annotatedMethod.getName();
        if (!name.startsWith("get") || name.length() <= 3) {
            return (!name.startsWith("is") || name.length() <= 2) ? 3 : 2;
        }
        return 1;
    }

    protected Class M(AnnotatedMember annotatedMember) {
        if (annotatedMember instanceof AnnotatedMethod) {
            AnnotatedMethod annotatedMethod = (AnnotatedMethod) annotatedMember;
            if (annotatedMethod.getParameterCount() > 0) {
                return annotatedMethod.getParameterType(0).getRawClass();
            }
        }
        return annotatedMember.getType().getRawClass();
    }

    protected AnnotatedMethod P(AnnotatedMethod annotatedMethod, AnnotatedMethod annotatedMethod2) {
        Class<?> declaringClass = annotatedMethod.getDeclaringClass();
        Class<?> declaringClass2 = annotatedMethod2.getDeclaringClass();
        if (declaringClass != declaringClass2) {
            if (declaringClass.isAssignableFrom(declaringClass2)) {
                return annotatedMethod2;
            }
            if (declaringClass2.isAssignableFrom(declaringClass)) {
                return annotatedMethod;
            }
        }
        int iR = R(annotatedMethod2);
        int iR2 = R(annotatedMethod);
        if (iR != iR2) {
            return iR < iR2 ? annotatedMethod2 : annotatedMethod;
        }
        AnnotationIntrospector annotationIntrospector = this.d;
        if (annotationIntrospector == null) {
            return null;
        }
        return annotationIntrospector.resolveSetterConflict(this.c, annotatedMethod, annotatedMethod2);
    }

    protected AnnotatedMethod Q(g gVar, g gVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(gVar.a);
        arrayList.add(gVar2.a);
        for (g gVar3 = gVar2.b; gVar3 != null; gVar3 = gVar3.b) {
            AnnotatedMethod annotatedMethodP = P((AnnotatedMethod) gVar.a, (AnnotatedMethod) gVar3.a);
            if (annotatedMethodP != gVar.a) {
                Object obj = gVar3.a;
                if (annotatedMethodP == obj) {
                    arrayList.clear();
                    gVar = gVar3;
                } else {
                    arrayList.add(obj);
                }
            }
        }
        if (arrayList.isEmpty()) {
            this.j = gVar.f();
            return (AnnotatedMethod) gVar.a;
        }
        throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s", getName(), (String) arrayList.stream().map(new Function() { // from class: qy1
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return ((AnnotatedMethod) obj2).getFullName();
            }
        }).collect(Collectors.joining(" vs "))));
    }

    protected int R(AnnotatedMethod annotatedMethod) {
        String name = annotatedMethod.getName();
        return (!name.startsWith("set") || name.length() <= 3) ? 2 : 1;
    }

    public void T(l lVar) {
        this.g = n0(this.g, lVar.g);
        this.h = n0(this.h, lVar.h);
        this.i = n0(this.i, lVar.i);
        this.j = n0(this.j, lVar.j);
    }

    public void U(AnnotatedParameter annotatedParameter, PropertyName propertyName, boolean z, boolean z2, boolean z3) {
        this.h = new g(annotatedParameter, this.h, propertyName, z, z2, z3);
    }

    public void V(AnnotatedField annotatedField, PropertyName propertyName, boolean z, boolean z2, boolean z3) {
        this.g = new g(annotatedField, this.g, propertyName, z, z2, z3);
    }

    public void W(AnnotatedMethod annotatedMethod, PropertyName propertyName, boolean z, boolean z2, boolean z3) {
        this.i = new g(annotatedMethod, this.i, propertyName, z, z2, z3);
    }

    public void X(AnnotatedMethod annotatedMethod, PropertyName propertyName, boolean z, boolean z2, boolean z3) {
        this.j = new g(annotatedMethod, this.j, propertyName, z, z2, z3);
    }

    public boolean Y() {
        return C(this.g) || C(this.i) || C(this.j) || A(this.h);
    }

    public boolean Z() {
        return D(this.g) || D(this.i) || D(this.j) || D(this.h);
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public boolean a() {
        return (this.h == null && this.j == null && this.g == null) ? false : true;
    }

    public boolean a0() {
        return E(this.g) || E(this.i) || E(this.j) || E(this.h);
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public boolean b() {
        return (this.i == null && this.g == null) ? false : true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public int compareTo(l lVar) {
        if (this.h != null) {
            if (lVar.h == null) {
                return -1;
            }
        } else if (lVar.h != null) {
            return 1;
        }
        return getName().compareTo(lVar.getName());
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public JsonInclude.Value c() {
        AnnotatedMember annotatedMemberH = h();
        AnnotationIntrospector annotationIntrospector = this.d;
        JsonInclude.Value valueFindPropertyInclusion = annotationIntrospector == null ? null : annotationIntrospector.findPropertyInclusion(annotatedMemberH);
        return valueFindPropertyInclusion == null ? JsonInclude.Value.empty() : valueFindPropertyInclusion;
    }

    public Collection c0(Collection collection) {
        HashMap map = new HashMap();
        G(collection, map, this.g);
        G(collection, map, this.i);
        G(collection, map, this.j);
        G(collection, map, this.h);
        return map.values();
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public lt1 d() {
        return (lt1) f0(new d());
    }

    public JsonProperty.Access d0() {
        return (JsonProperty.Access) g0(new e(), JsonProperty.Access.AUTO);
    }

    public Set e0() {
        Set setH = H(this.h, H(this.j, H(this.i, H(this.g, null))));
        return setH == null ? Collections.emptySet() : setH;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public AnnotationIntrospector.ReferenceProperty f() {
        AnnotationIntrospector.ReferenceProperty referenceProperty = this.l;
        if (referenceProperty != null) {
            if (referenceProperty == m) {
                return null;
            }
            return referenceProperty;
        }
        AnnotationIntrospector.ReferenceProperty referenceProperty2 = (AnnotationIntrospector.ReferenceProperty) f0(new b());
        this.l = referenceProperty2 == null ? m : referenceProperty2;
        return referenceProperty2;
    }

    protected Object f0(i iVar) {
        g gVar;
        g gVar2;
        Object objA = null;
        if (this.d == null) {
            return null;
        }
        if (this.b) {
            g gVar3 = this.i;
            if (gVar3 != null) {
                objA = iVar.a((AnnotatedMember) gVar3.a);
            }
        } else {
            g gVar4 = this.h;
            objA = gVar4 != null ? iVar.a((AnnotatedMember) gVar4.a) : null;
            if (objA == null && (gVar = this.j) != null) {
                objA = iVar.a((AnnotatedMember) gVar.a);
            }
        }
        return (objA != null || (gVar2 = this.g) == null) ? objA : iVar.a((AnnotatedMember) gVar2.a);
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public Class[] g() {
        return (Class[]) f0(new a());
    }

    protected Object g0(i iVar, Object obj) {
        Object objA;
        Object objA2;
        Object objA3;
        Object objA4;
        Object objA5;
        Object objA6;
        Object objA7;
        Object objA8;
        if (this.d == null) {
            return null;
        }
        if (this.b) {
            g gVar = this.i;
            if (gVar != null && (objA8 = iVar.a((AnnotatedMember) gVar.a)) != null && objA8 != obj) {
                return objA8;
            }
            g gVar2 = this.g;
            if (gVar2 != null && (objA7 = iVar.a((AnnotatedMember) gVar2.a)) != null && objA7 != obj) {
                return objA7;
            }
            g gVar3 = this.h;
            if (gVar3 != null && (objA6 = iVar.a((AnnotatedMember) gVar3.a)) != null && objA6 != obj) {
                return objA6;
            }
            g gVar4 = this.j;
            if (gVar4 == null || (objA5 = iVar.a((AnnotatedMember) gVar4.a)) == null || objA5 == obj) {
                return null;
            }
            return objA5;
        }
        g gVar5 = this.h;
        if (gVar5 != null && (objA4 = iVar.a((AnnotatedMember) gVar5.a)) != null && objA4 != obj) {
            return objA4;
        }
        g gVar6 = this.j;
        if (gVar6 != null && (objA3 = iVar.a((AnnotatedMember) gVar6.a)) != null && objA3 != obj) {
            return objA3;
        }
        g gVar7 = this.g;
        if (gVar7 != null && (objA2 = iVar.a((AnnotatedMember) gVar7.a)) != null && objA2 != obj) {
            return objA2;
        }
        g gVar8 = this.i;
        if (gVar8 == null || (objA = iVar.a((AnnotatedMember) gVar8.a)) == null || objA == obj) {
            return null;
        }
        return objA;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public PropertyName getFullName() {
        return this.e;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public PropertyMetadata getMetadata() {
        if (this.k == null) {
            AnnotatedMember annotatedMemberK0 = k0();
            if (annotatedMemberK0 == null) {
                this.k = PropertyMetadata.STD_REQUIRED_OR_OPTIONAL;
            } else {
                Boolean boolHasRequiredMarker = this.d.hasRequiredMarker(annotatedMemberK0);
                String strFindPropertyDescription = this.d.findPropertyDescription(annotatedMemberK0);
                Integer numFindPropertyIndex = this.d.findPropertyIndex(annotatedMemberK0);
                String strFindPropertyDefaultValue = this.d.findPropertyDefaultValue(annotatedMemberK0);
                if (boolHasRequiredMarker == null && numFindPropertyIndex == null && strFindPropertyDefaultValue == null) {
                    PropertyMetadata propertyMetadataWithDescription = PropertyMetadata.STD_REQUIRED_OR_OPTIONAL;
                    if (strFindPropertyDescription != null) {
                        propertyMetadataWithDescription = propertyMetadataWithDescription.withDescription(strFindPropertyDescription);
                    }
                    this.k = propertyMetadataWithDescription;
                } else {
                    this.k = PropertyMetadata.construct(boolHasRequiredMarker, strFindPropertyDescription, numFindPropertyIndex, strFindPropertyDefaultValue);
                }
                if (!this.b) {
                    this.k = J(this.k, annotatedMemberK0);
                }
            }
        }
        return this.k;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g, defpackage.in1
    public String getName() {
        PropertyName propertyName = this.e;
        if (propertyName == null) {
            return null;
        }
        return propertyName.getSimpleName();
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public PropertyName getWrapperName() {
        AnnotationIntrospector annotationIntrospector;
        AnnotatedMember annotatedMemberO = o();
        if (annotatedMemberO == null || (annotationIntrospector = this.d) == null) {
            return null;
        }
        return annotationIntrospector.findWrapperName(annotatedMemberO);
    }

    protected AnnotatedField h0() {
        g gVar = this.g;
        if (gVar == null) {
            return null;
        }
        return (AnnotatedField) gVar.a;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public AnnotatedParameter i() {
        g gVar = this.h;
        if (gVar == null) {
            return null;
        }
        while (!(((AnnotatedParameter) gVar.a).getOwner() instanceof AnnotatedConstructor)) {
            gVar = gVar.b;
            if (gVar == null) {
                return (AnnotatedParameter) this.h.a;
            }
        }
        return (AnnotatedParameter) gVar.a;
    }

    protected AnnotatedMethod i0() {
        g gVar = this.i;
        if (gVar == null) {
            return null;
        }
        return (AnnotatedMethod) gVar.a;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public Iterator j() {
        g gVar = this.h;
        return gVar == null ? ay.n() : new h(gVar);
    }

    public String j0() {
        return this.f.getSimpleName();
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public AnnotatedField k() {
        g gVar = this.g;
        if (gVar == null) {
            return null;
        }
        AnnotatedField annotatedField = (AnnotatedField) gVar.a;
        for (g gVar2 = gVar.b; gVar2 != null; gVar2 = gVar2.b) {
            AnnotatedField annotatedField2 = (AnnotatedField) gVar2.a;
            Class<?> declaringClass = annotatedField.getDeclaringClass();
            Class<?> declaringClass2 = annotatedField2.getDeclaringClass();
            if (declaringClass != declaringClass2) {
                if (declaringClass.isAssignableFrom(declaringClass2)) {
                    annotatedField = annotatedField2;
                } else if (declaringClass2.isAssignableFrom(declaringClass)) {
                }
            }
            throw new IllegalArgumentException("Multiple fields representing property \"" + getName() + "\": " + annotatedField.getFullName() + " vs " + annotatedField2.getFullName());
        }
        return annotatedField;
    }

    protected AnnotatedMember k0() {
        if (this.b) {
            g gVar = this.i;
            if (gVar != null) {
                return (AnnotatedMember) gVar.a;
            }
            g gVar2 = this.g;
            if (gVar2 != null) {
                return (AnnotatedMember) gVar2.a;
            }
            return null;
        }
        g gVar3 = this.h;
        if (gVar3 != null) {
            return (AnnotatedMember) gVar3.a;
        }
        g gVar4 = this.j;
        if (gVar4 != null) {
            return (AnnotatedMember) gVar4.a;
        }
        g gVar5 = this.g;
        if (gVar5 != null) {
            return (AnnotatedMember) gVar5.a;
        }
        g gVar6 = this.i;
        if (gVar6 != null) {
            return (AnnotatedMember) gVar6.a;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0031  */
    /* JADX WARN: Code duplicated, block: B:21:0x0043 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    /* JADX WARN: Code duplicated, block: B:28:0x0049 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0046 A[SYNTHETIC] */
    @Override // com.fasterxml.jackson.databind.introspect.g
    public AnnotatedMethod l() {
        int iK;
        int iK2;
        g gVar = this.i;
        if (gVar == null) {
            return null;
        }
        g gVar2 = gVar.b;
        if (gVar2 == null) {
            return (AnnotatedMethod) gVar.a;
        }
        while (gVar2 != null) {
            Class<?> declaringClass = ((AnnotatedMethod) gVar.a).getDeclaringClass();
            Class<?> declaringClass2 = ((AnnotatedMethod) gVar2.a).getDeclaringClass();
            if (declaringClass == declaringClass2) {
                iK = K((AnnotatedMethod) gVar2.a);
                iK2 = K((AnnotatedMethod) gVar.a);
                if (iK != iK2) {
                    throw new IllegalArgumentException("Conflicting getter definitions for property \"" + getName() + "\": " + ((AnnotatedMethod) gVar.a).getFullName() + " vs " + ((AnnotatedMethod) gVar2.a).getFullName());
                }
                if (iK < iK2) {
                    gVar = gVar2;
                }
            } else if (declaringClass.isAssignableFrom(declaringClass2)) {
                gVar = gVar2;
            } else if (declaringClass2.isAssignableFrom(declaringClass)) {
                continue;
            } else {
                iK = K((AnnotatedMethod) gVar2.a);
                iK2 = K((AnnotatedMethod) gVar.a);
                if (iK != iK2) {
                    throw new IllegalArgumentException("Conflicting getter definitions for property \"" + getName() + "\": " + ((AnnotatedMethod) gVar.a).getFullName() + " vs " + ((AnnotatedMethod) gVar2.a).getFullName());
                }
                if (iK < iK2) {
                    gVar = gVar2;
                }
            }
            gVar2 = gVar2.b;
        }
        this.i = gVar.f();
        return (AnnotatedMethod) gVar.a;
    }

    protected AnnotatedMethod l0() {
        g gVar = this.j;
        if (gVar == null) {
            return null;
        }
        return (AnnotatedMethod) gVar.a;
    }

    public boolean m0() {
        return this.i != null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public AnnotatedMember o() {
        AnnotatedMember annotatedMemberM;
        return (this.b || (annotatedMemberM = m()) == null) ? h() : annotatedMemberM;
    }

    public void o0(boolean z) {
        if (z) {
            g gVar = this.i;
            if (gVar != null) {
                this.i = F(this.i, L(0, gVar, this.g, this.h, this.j));
                return;
            }
            g gVar2 = this.g;
            if (gVar2 != null) {
                this.g = F(this.g, L(0, gVar2, this.h, this.j));
                return;
            }
            return;
        }
        g gVar3 = this.h;
        if (gVar3 != null) {
            this.h = F(this.h, L(0, gVar3, this.j, this.g, this.i));
            return;
        }
        g gVar4 = this.j;
        if (gVar4 != null) {
            this.j = F(this.j, L(0, gVar4, this.g, this.i));
            return;
        }
        g gVar5 = this.g;
        if (gVar5 != null) {
            this.g = F(this.g, L(0, gVar5, this.i));
        }
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public JavaType p() {
        if (this.b) {
            d7 d7VarL = l();
            return (d7VarL == null && (d7VarL = k()) == null) ? TypeFactory.unknownType() : d7VarL.getType();
        }
        d7 d7VarI = i();
        if (d7VarI == null) {
            AnnotatedMethod annotatedMethodR = r();
            if (annotatedMethodR != null) {
                return annotatedMethodR.getParameterType(0);
            }
            d7VarI = k();
        }
        return (d7VarI == null && (d7VarI = l()) == null) ? TypeFactory.unknownType() : d7VarI.getType();
    }

    public void p0() {
        this.h = null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public Class q() {
        return p().getRawClass();
    }

    public void q0() {
        this.g = N(this.g);
        this.i = N(this.i);
        this.j = N(this.j);
        this.h = N(this.h);
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public AnnotatedMethod r() {
        g gVar = this.j;
        if (gVar == null) {
            return null;
        }
        g gVar2 = gVar.b;
        if (gVar2 == null) {
            return (AnnotatedMethod) gVar.a;
        }
        while (gVar2 != null) {
            AnnotatedMethod annotatedMethodP = P((AnnotatedMethod) gVar.a, (AnnotatedMethod) gVar2.a);
            if (annotatedMethodP != gVar.a) {
                if (annotatedMethodP != gVar2.a) {
                    return Q(gVar, gVar2);
                }
                gVar = gVar2;
            }
            gVar2 = gVar2.b;
        }
        this.j = gVar.f();
        return (AnnotatedMethod) gVar.a;
    }

    public JsonProperty.Access r0(boolean z, k kVar) {
        JsonProperty.Access accessD0 = d0();
        if (accessD0 == null) {
            accessD0 = JsonProperty.Access.AUTO;
        }
        int i2 = f.a[accessD0.ordinal()];
        if (i2 == 1) {
            if (kVar != null) {
                kVar.k(getName());
                Iterator it = e0().iterator();
                while (it.hasNext()) {
                    kVar.k(((PropertyName) it.next()).getSimpleName());
                }
            }
            this.j = null;
            this.h = null;
            if (!this.b) {
                this.g = null;
            }
        } else if (i2 != 2) {
            if (i2 != 3) {
                this.i = O(this.i);
                this.h = O(this.h);
                if (!z || this.i == null) {
                    this.g = O(this.g);
                    this.j = O(this.j);
                }
            } else {
                this.i = null;
                if (this.b) {
                    this.g = null;
                }
            }
        }
        return accessD0;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public boolean s() {
        return this.h != null;
    }

    public void s0() {
        this.g = S(this.g);
        this.i = S(this.i);
        this.j = S(this.j);
        this.h = S(this.h);
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public boolean t() {
        return this.g != null;
    }

    public l t0(PropertyName propertyName) {
        return new l(this, propertyName);
    }

    public String toString() {
        return "[Property '" + this.e + "'; ctors: " + this.h + ", field(s): " + this.g + ", getter(s): " + this.i + ", setter(s): " + this.j + "]";
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public boolean u(PropertyName propertyName) {
        return this.e.equals(propertyName);
    }

    public l u0(String str) {
        PropertyName propertyNameWithSimpleName = this.e.withSimpleName(str);
        return propertyNameWithSimpleName == this.e ? this : new l(this, propertyNameWithSimpleName);
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public boolean v() {
        return this.j != null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public boolean w() {
        return B(this.g) || B(this.i) || B(this.j) || z(this.h);
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public boolean x() {
        return z(this.g) || z(this.i) || z(this.j) || z(this.h);
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public boolean y() {
        Boolean bool = (Boolean) f0(new c());
        return bool != null && bool.booleanValue();
    }

    protected l(MapperConfig mapperConfig, AnnotationIntrospector annotationIntrospector, boolean z, PropertyName propertyName, PropertyName propertyName2) {
        this.c = mapperConfig;
        this.d = annotationIntrospector;
        this.f = propertyName;
        this.e = propertyName2;
        this.b = z;
    }

    protected l(l lVar, PropertyName propertyName) {
        this.c = lVar.c;
        this.d = lVar.d;
        this.f = lVar.f;
        this.e = propertyName;
        this.g = lVar.g;
        this.h = lVar.h;
        this.i = lVar.i;
        this.j = lVar.j;
        this.b = lVar.b;
    }
}
