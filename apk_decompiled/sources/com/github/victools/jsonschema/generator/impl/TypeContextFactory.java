package com.github.victools.jsonschema.generator.impl;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.fasterxml.classmate.AnnotationInclusion;
import defpackage.k63;
import defpackage.vk2;

/* JADX INFO: loaded from: classes.dex */
public enum TypeContextFactory {
    ;

    @Deprecated
    public static k63 createDefaultTypeContext() {
        return createTypeContext(AnnotationInclusion.INCLUDE_AND_INHERIT_IF_INHERITED);
    }

    @Deprecated
    public static k63 createTypeContext(AnnotationInclusion annotationInclusion) {
        return createTypeContext(new AnnotationConfiguration.StdConfiguration(annotationInclusion));
    }

    public static k63 createDefaultTypeContext(vk2 vk2Var) {
        return createTypeContext(AnnotationInclusion.INCLUDE_AND_INHERIT_IF_INHERITED, vk2Var);
    }

    public static k63 createTypeContext(AnnotationInclusion annotationInclusion, vk2 vk2Var) {
        return createTypeContext(new AnnotationConfiguration.StdConfiguration(annotationInclusion), vk2Var);
    }

    @Deprecated
    public static k63 createTypeContext(AnnotationConfiguration annotationConfiguration) {
        return new k63(annotationConfiguration);
    }

    public static k63 createTypeContext(AnnotationConfiguration annotationConfiguration, vk2 vk2Var) {
        return new k63(annotationConfiguration, vk2Var);
    }
}
