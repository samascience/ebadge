package com.github.victools.jsonschema.generator.impl;

import com.github.victools.jsonschema.generator.impl.PropertySortUtils;
import defpackage.ii1;
import java.util.Comparator;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public enum PropertySortUtils {
    ;

    public static final Comparator<ii1> DEFAULT_PROPERTY_ORDER;
    public static final Comparator<ii1> SORT_PROPERTIES_BY_NAME_ALPHABETICALLY;
    public static final Comparator<ii1> SORT_PROPERTIES_FIELDS_BEFORE_METHODS;

    static {
        Comparator<ii1> comparator = new Comparator() { // from class: j82
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                e43.a(obj);
                e43.a(obj2);
                return PropertySortUtils.lambda$static$0(null, null);
            }
        };
        SORT_PROPERTIES_FIELDS_BEFORE_METHODS = comparator;
        Comparator<ii1> comparatorComparing = Comparator.comparing(new Function() { // from class: k82
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                e43.a(obj);
                throw null;
            }
        });
        SORT_PROPERTIES_BY_NAME_ALPHABETICALLY = comparatorComparing;
        DEFAULT_PROPERTY_ORDER = comparator.thenComparing(comparatorComparing);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(ii1 ii1Var, ii1 ii1Var2) {
        throw null;
    }
}
