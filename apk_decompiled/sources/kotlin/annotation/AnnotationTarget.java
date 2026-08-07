package kotlin.annotation;

import defpackage.vh0;
import kotlin.enums.a;

/* JADX INFO: loaded from: classes4.dex */
public enum AnnotationTarget {
    CLASS,
    ANNOTATION_CLASS,
    TYPE_PARAMETER,
    PROPERTY,
    FIELD,
    LOCAL_VARIABLE,
    VALUE_PARAMETER,
    CONSTRUCTOR,
    FUNCTION,
    PROPERTY_GETTER,
    PROPERTY_SETTER,
    TYPE,
    EXPRESSION,
    FILE,
    TYPEALIAS;

    private static final /* synthetic */ vh0 $ENTRIES = a.a(values());

    public static vh0 getEntries() {
        return $ENTRIES;
    }
}
