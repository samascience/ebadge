package com.github.victools.jsonschema.generator;

import com.github.victools.jsonschema.generator.Option;
import defpackage.up2;
import defpackage.vk1;
import defpackage.vn0;
import java.util.Collections;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'FLATTENED_ENUMS' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes.dex */
public final class Option {
    private static final /* synthetic */ Option[] $VALUES;
    public static final Option ADDITIONAL_FIXED_TYPES;
    public static final Option ALLOF_CLEANUP_AT_THE_END;
    public static final Option DEFINITIONS_FOR_ALL_OBJECTS;
    public static final Option DEFINITIONS_FOR_MEMBER_SUPERTYPES;
    public static final Option DEFINITION_FOR_MAIN_SCHEMA;
    public static final Option ENUM_KEYWORD_FOR_SINGLE_VALUES;
    public static final Option EXTRA_OPEN_API_FORMAT_VALUES;
    public static final Option FIELDS_DERIVED_FROM_ARGUMENTFREE_METHODS;
    public static final Option FLATTENED_ENUMS;
    public static final Option FLATTENED_ENUMS_FROM_TOSTRING;
    public static final Option FLATTENED_OPTIONALS;
    public static final Option FLATTENED_SUPPLIERS;
    public static final Option FORBIDDEN_ADDITIONAL_PROPERTIES_BY_DEFAULT;
    public static final Option GETTER_METHODS;
    public static final Option INLINE_ALL_SCHEMAS;
    public static final Option MAP_VALUES_AS_ADDITIONAL_PROPERTIES;
    public static final Option NONPUBLIC_NONSTATIC_FIELDS_WITHOUT_GETTERS;
    public static final Option NONPUBLIC_NONSTATIC_FIELDS_WITH_GETTERS;
    public static final Option NONPUBLIC_STATIC_FIELDS;
    public static final Option NONSTATIC_NONVOID_NONGETTER_METHODS;
    public static final Option NULLABLE_ARRAY_ITEMS_ALLOWED;
    public static final Option NULLABLE_FIELDS_BY_DEFAULT;
    public static final Option NULLABLE_METHOD_RETURN_VALUES_BY_DEFAULT;
    public static final Option PLAIN_DEFINITION_KEYS;
    public static final Option PUBLIC_NONSTATIC_FIELDS;
    public static final Option PUBLIC_STATIC_FIELDS;
    public static final Option SCHEMA_VERSION_INDICATOR;
    public static final Option SIMPLIFIED_ENUMS;
    public static final Option SIMPLIFIED_OPTIONALS;
    public static final Option STATIC_METHODS;
    public static final Option STRICT_TYPE_INFO;
    public static final Option TRANSIENT_FIELDS;
    public static final Option VALUES_FROM_CONSTANT_FIELDS;
    public static final Option VOID_METHODS;
    private final Supplier<vk1> disabledModuleProvider;
    private final Supplier<vk1> enabledModuleProvider;
    private final Set<Option> overriddenOptions;

    static {
        Option option = new Option("SCHEMA_VERSION_INDICATOR", 0, null, null, new Option[0]);
        SCHEMA_VERSION_INDICATOR = option;
        Option option2 = new Option("ADDITIONAL_FIXED_TYPES", 1, new Supplier() { // from class: ww1
            @Override // java.util.function.Supplier
            public final Object get() {
                return tp2.g();
            }
        }, new Supplier() { // from class: xw1
            @Override // java.util.function.Supplier
            public final Object get() {
                return tp2.h();
            }
        }, new Option[0]);
        ADDITIONAL_FIXED_TYPES = option2;
        Option option3 = new Option("SIMPLIFIED_ENUMS", 2, new Supplier() { // from class: yw1
            @Override // java.util.function.Supplier
            public final Object get() {
                return yh0.a();
            }
        }, null, new Option[0]);
        SIMPLIFIED_ENUMS = option3;
        Option option4 = new Option("FLATTENED_ENUMS", 3, new Supplier() { // from class: zw1
            @Override // java.util.function.Supplier
            public final Object get() {
                return yh0.b();
            }
        }, null, option3);
        FLATTENED_ENUMS = option4;
        Option option5 = new Option("FLATTENED_ENUMS_FROM_TOSTRING", 4, new Supplier() { // from class: ax1
            @Override // java.util.function.Supplier
            public final Object get() {
                return yh0.c();
            }
        }, null, option4, option3);
        FLATTENED_ENUMS_FROM_TOSTRING = option5;
        Option option6 = new Option("SIMPLIFIED_OPTIONALS", 5, new Supplier() { // from class: bx1
            @Override // java.util.function.Supplier
            public final Object get() {
                return Option.lambda$static$0();
            }
        }, null, new Option[0]);
        SIMPLIFIED_OPTIONALS = option6;
        Option option7 = new Option("FLATTENED_OPTIONALS", 6, new Supplier() { // from class: cx1
            @Override // java.util.function.Supplier
            public final Object get() {
                return new un0();
            }
        }, null, option6);
        FLATTENED_OPTIONALS = option7;
        Option option8 = new Option("FLATTENED_SUPPLIERS", 7, new Supplier() { // from class: dx1
            @Override // java.util.function.Supplier
            public final Object get() {
                return Option.lambda$static$1();
            }
        }, null, new Option[0]);
        FLATTENED_SUPPLIERS = option8;
        Option option9 = new Option("VALUES_FROM_CONSTANT_FIELDS", 8, new Supplier() { // from class: ex1
            @Override // java.util.function.Supplier
            public final Object get() {
                return new h20();
            }
        }, null, new Option[0]);
        VALUES_FROM_CONSTANT_FIELDS = option9;
        Option option10 = new Option("PUBLIC_STATIC_FIELDS", 9, null, null, new Option[0]);
        PUBLIC_STATIC_FIELDS = option10;
        Option option11 = new Option("PUBLIC_NONSTATIC_FIELDS", 10, null, new Supplier() { // from class: fx1
            @Override // java.util.function.Supplier
            public final Object get() {
                return tl0.f();
            }
        }, new Option[0]);
        PUBLIC_NONSTATIC_FIELDS = option11;
        Option option12 = new Option("NONPUBLIC_STATIC_FIELDS", 11, null, null, new Option[0]);
        NONPUBLIC_STATIC_FIELDS = option12;
        Option option13 = new Option("NONPUBLIC_NONSTATIC_FIELDS_WITH_GETTERS", 12, null, new Supplier() { // from class: gx1
            @Override // java.util.function.Supplier
            public final Object get() {
                return tl0.d();
            }
        }, new Option[0]);
        NONPUBLIC_NONSTATIC_FIELDS_WITH_GETTERS = option13;
        Option option14 = new Option("NONPUBLIC_NONSTATIC_FIELDS_WITHOUT_GETTERS", 13, null, new Supplier() { // from class: hx1
            @Override // java.util.function.Supplier
            public final Object get() {
                return tl0.e();
            }
        }, new Option[0]);
        NONPUBLIC_NONSTATIC_FIELDS_WITHOUT_GETTERS = option14;
        Option option15 = new Option("TRANSIENT_FIELDS", 14, null, new Supplier() { // from class: ix1
            @Override // java.util.function.Supplier
            public final Object get() {
                return tl0.g();
            }
        }, new Option[0]);
        TRANSIENT_FIELDS = option15;
        Option option16 = new Option("STATIC_METHODS", 15, null, null, new Option[0]);
        STATIC_METHODS = option16;
        Option option17 = new Option("VOID_METHODS", 16, null, new Supplier() { // from class: jx1
            @Override // java.util.function.Supplier
            public final Object get() {
                return ak1.d();
            }
        }, new Option[0]);
        VOID_METHODS = option17;
        Option option18 = new Option("GETTER_METHODS", 17, null, new Supplier() { // from class: kx1
            @Override // java.util.function.Supplier
            public final Object get() {
                return ak1.b();
            }
        }, new Option[0]);
        GETTER_METHODS = option18;
        Option option19 = new Option("NONSTATIC_NONVOID_NONGETTER_METHODS", 18, null, new Supplier() { // from class: lx1
            @Override // java.util.function.Supplier
            public final Object get() {
                return ak1.c();
            }
        }, new Option[0]);
        NONSTATIC_NONVOID_NONGETTER_METHODS = option19;
        Option option20 = new Option("NULLABLE_FIELDS_BY_DEFAULT", 19, null, null, new Option[0]);
        NULLABLE_FIELDS_BY_DEFAULT = option20;
        Option option21 = new Option("NULLABLE_METHOD_RETURN_VALUES_BY_DEFAULT", 20, null, null, new Option[0]);
        NULLABLE_METHOD_RETURN_VALUES_BY_DEFAULT = option21;
        Option option22 = new Option("NULLABLE_ARRAY_ITEMS_ALLOWED", 21, null, null, new Option[0]);
        NULLABLE_ARRAY_ITEMS_ALLOWED = option22;
        Option option23 = new Option("FIELDS_DERIVED_FROM_ARGUMENTFREE_METHODS", 22, null, null, new Option[0]);
        FIELDS_DERIVED_FROM_ARGUMENTFREE_METHODS = option23;
        Option option24 = new Option("MAP_VALUES_AS_ADDITIONAL_PROPERTIES", 23, new Supplier() { // from class: mx1
            @Override // java.util.function.Supplier
            public final Object get() {
                return u4.d();
            }
        }, null, new Option[0]);
        MAP_VALUES_AS_ADDITIONAL_PROPERTIES = option24;
        Option option25 = new Option("ENUM_KEYWORD_FOR_SINGLE_VALUES", 24, null, null, new Option[0]);
        ENUM_KEYWORD_FOR_SINGLE_VALUES = option25;
        Option option26 = new Option("FORBIDDEN_ADDITIONAL_PROPERTIES_BY_DEFAULT", 25, new Supplier() { // from class: nx1
            @Override // java.util.function.Supplier
            public final Object get() {
                return u4.e();
            }
        }, null, new Option[0]);
        FORBIDDEN_ADDITIONAL_PROPERTIES_BY_DEFAULT = option26;
        Option option27 = new Option("DEFINITIONS_FOR_ALL_OBJECTS", 26, null, null, new Option[0]);
        DEFINITIONS_FOR_ALL_OBJECTS = option27;
        Option option28 = new Option("DEFINITION_FOR_MAIN_SCHEMA", 27, null, null, new Option[0]);
        DEFINITION_FOR_MAIN_SCHEMA = option28;
        Option option29 = new Option("DEFINITIONS_FOR_MEMBER_SUPERTYPES", 28, null, null, new Option[0]);
        DEFINITIONS_FOR_MEMBER_SUPERTYPES = option29;
        Option option30 = new Option("INLINE_ALL_SCHEMAS", 29, new Supplier() { // from class: ox1
            @Override // java.util.function.Supplier
            public final Object get() {
                return new l21();
            }
        }, null, option27, option28);
        INLINE_ALL_SCHEMAS = option30;
        Option option31 = new Option("PLAIN_DEFINITION_KEYS", 30, null, null, new Option[0]);
        PLAIN_DEFINITION_KEYS = option31;
        Option option32 = new Option("EXTRA_OPEN_API_FORMAT_VALUES", 31, null, null, new Option[0]);
        EXTRA_OPEN_API_FORMAT_VALUES = option32;
        Option option33 = new Option("ALLOF_CLEANUP_AT_THE_END", 32, null, null, new Option[0]);
        ALLOF_CLEANUP_AT_THE_END = option33;
        Option option34 = new Option("STRICT_TYPE_INFO", 33, null, null, new Option[0]);
        STRICT_TYPE_INFO = option34;
        $VALUES = new Option[]{option, option2, option3, option4, option5, option6, option7, option8, option9, option10, option11, option12, option13, option14, option15, option16, option17, option18, option19, option20, option21, option22, option23, option24, option25, option26, option27, option28, option29, option30, option31, option32, option33, option34};
    }

    private Option(String str, int i, Supplier supplier, Supplier supplier2, Option... optionArr) {
        super(str, i);
        this.enabledModuleProvider = supplier;
        this.disabledModuleProvider = supplier2;
        if (optionArr == null || optionArr.length == 0) {
            this.overriddenOptions = Collections.emptySet();
        } else {
            this.overriddenOptions = (Set) Stream.of((Object[]) optionArr).collect(Collectors.toSet());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ vk1 lambda$static$0() {
        return new up2(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ vk1 lambda$static$1() {
        return new vn0(Supplier.class);
    }

    public static Option valueOf(String str) {
        return (Option) Enum.valueOf(Option.class, str);
    }

    public static Option[] values() {
        return (Option[]) $VALUES.clone();
    }

    vk1 getModule(boolean z) {
        Supplier<vk1> supplier = z ? this.enabledModuleProvider : this.disabledModuleProvider;
        if (supplier == null) {
            return null;
        }
        return supplier.get();
    }

    public boolean isOverriding(Option option) {
        return this.overriddenOptions.contains(option);
    }
}
