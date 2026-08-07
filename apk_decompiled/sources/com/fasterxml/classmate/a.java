package com.fasterxml.classmate;

import defpackage.eg2;
import defpackage.fg2;
import defpackage.ig2;
import defpackage.jn0;
import defpackage.og2;
import defpackage.vw0;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final og2[] j = new og2[0];
    private static final ig2[] k = new ig2[0];
    private static final fg2[] l = new fg2[0];
    private static final eg2[] m = new eg2[0];
    protected static final AnnotationConfiguration n = new AnnotationConfiguration.StdConfiguration(AnnotationInclusion.DONT_INCLUDE);
    protected final TypeResolver a;
    protected final C0066a b;
    protected final vw0 c;
    protected final vw0[] d;
    protected ig2[] e = null;
    protected fg2[] f = null;
    protected ig2[] g = null;
    protected fg2[] h = null;
    protected eg2[] i = null;

    /* JADX INFO: renamed from: com.fasterxml.classmate.a$a, reason: collision with other inner class name */
    private static final class C0066a {
        private final AnnotationConfiguration a;

        public C0066a(AnnotationConfiguration annotationConfiguration) {
            this.a = annotationConfiguration;
        }
    }

    public a(TypeResolver typeResolver, AnnotationConfiguration annotationConfiguration, vw0 vw0Var, vw0[] vw0VarArr, jn0 jn0Var, jn0 jn0Var2, jn0 jn0Var3) {
        this.a = typeResolver;
        this.c = vw0Var;
        this.d = vw0VarArr;
        this.b = new C0066a(annotationConfiguration == null ? n : annotationConfiguration);
    }
}
