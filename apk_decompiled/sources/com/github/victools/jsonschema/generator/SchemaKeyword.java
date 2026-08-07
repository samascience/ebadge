package com.github.victools.jsonschema.generator;

import com.github.victools.jsonschema.generator.SchemaKeyword;
import com.github.victools.jsonschema.generator.SchemaVersion;
import com.tencent.open.SocialConstants;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'TAG_SCHEMA' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes.dex */
public final class SchemaKeyword {
    private static final /* synthetic */ SchemaKeyword[] $VALUES;
    public static final SchemaKeyword TAG_ADDITIONAL_PROPERTIES;
    public static final SchemaKeyword TAG_ALLOF;
    public static final SchemaKeyword TAG_ANCHOR;
    public static final SchemaKeyword TAG_ANYOF;
    public static final SchemaKeyword TAG_CONST;
    public static final SchemaKeyword TAG_DEFAULT;
    public static final SchemaKeyword TAG_DEFINITIONS;
    public static final SchemaKeyword TAG_DEPENDENT_REQUIRED;
    public static final SchemaKeyword TAG_DEPENDENT_SCHEMAS;
    public static final SchemaKeyword TAG_DESCRIPTION;
    public static final SchemaKeyword TAG_ELSE;
    public static final SchemaKeyword TAG_ENUM;
    public static final SchemaKeyword TAG_FORMAT;
    public static final SchemaKeyword TAG_ID;
    public static final SchemaKeyword TAG_IF;
    public static final SchemaKeyword TAG_ITEMS;
    public static final SchemaKeyword TAG_ITEMS_MAX;
    public static final SchemaKeyword TAG_ITEMS_MIN;
    public static final SchemaKeyword TAG_ITEMS_UNIQUE;
    public static final SchemaKeyword TAG_LENGTH_MAX;
    public static final SchemaKeyword TAG_LENGTH_MIN;
    public static final SchemaKeyword TAG_MAXIMUM;
    public static final SchemaKeyword TAG_MAXIMUM_EXCLUSIVE;
    public static final SchemaKeyword TAG_MINIMUM;
    public static final SchemaKeyword TAG_MINIMUM_EXCLUSIVE;
    public static final SchemaKeyword TAG_MULTIPLE_OF;
    public static final SchemaKeyword TAG_NOT;
    public static final SchemaKeyword TAG_ONEOF;
    public static final SchemaKeyword TAG_PATTERN;
    public static final SchemaKeyword TAG_PATTERN_PROPERTIES;
    public static final SchemaKeyword TAG_PREFIX_ITEMS;
    public static final SchemaKeyword TAG_PROPERTIES;
    public static final SchemaKeyword TAG_PROPERTIES_MAX;
    public static final SchemaKeyword TAG_PROPERTIES_MIN;
    public static final SchemaKeyword TAG_READ_ONLY;
    public static final SchemaKeyword TAG_REF;
    public static final SchemaKeyword TAG_REF_MAIN;

    @Deprecated
    public static final SchemaKeyword TAG_REF_PREFIX;
    public static final SchemaKeyword TAG_REQUIRED;
    public static final SchemaKeyword TAG_SCHEMA;
    public static final SchemaKeyword TAG_SCHEMA_VALUE;
    public static final SchemaKeyword TAG_THEN;
    public static final SchemaKeyword TAG_TITLE;
    public static final SchemaKeyword TAG_TYPE;
    public static final SchemaKeyword TAG_TYPE_ARRAY;
    public static final SchemaKeyword TAG_TYPE_BOOLEAN;
    public static final SchemaKeyword TAG_TYPE_INTEGER;
    public static final SchemaKeyword TAG_TYPE_NULL;
    public static final SchemaKeyword TAG_TYPE_NUMBER;
    public static final SchemaKeyword TAG_TYPE_OBJECT;
    public static final SchemaKeyword TAG_TYPE_STRING;
    public static final SchemaKeyword TAG_UNEVALUATED_ITEMS;
    public static final SchemaKeyword TAG_UNEVALUATED_PROPERTIES;
    public static final SchemaKeyword TAG_WRITE_ONLY;
    private final List<TagContent> contentTypes;
    private final List<SchemaType> impliedTypes;
    private final Function<SchemaVersion, String> valueProvider;

    public enum SchemaType {
        NULL("null"),
        ARRAY("array"),
        OBJECT("object"),
        BOOLEAN("boolean"),
        STRING("string"),
        INTEGER("integer"),
        NUMBER("number");

        private final String schemaKeywordValue;

        SchemaType(String str) {
            this.schemaKeywordValue = str;
        }

        public String getSchemaKeywordValue() {
            return this.schemaKeywordValue;
        }
    }

    public enum TagContent {
        SCHEMA,
        ARRAY_OF_SCHEMAS,
        NAMED_SCHEMAS,
        NON_SCHEMA
    }

    static {
        TagContent tagContent = TagContent.NON_SCHEMA;
        SchemaKeyword schemaKeyword = new SchemaKeyword("TAG_SCHEMA", 0, "$schema", Collections.singletonList(tagContent));
        TAG_SCHEMA = schemaKeyword;
        SchemaKeyword schemaKeyword2 = new SchemaKeyword("TAG_SCHEMA_VALUE", 1, new Function() { // from class: zk2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((SchemaVersion) obj).getIdentifier();
            }
        }, Collections.emptyList(), Collections.emptyList());
        TAG_SCHEMA_VALUE = schemaKeyword2;
        SchemaKeyword schemaKeyword3 = new SchemaKeyword("TAG_ID", 2, "$id", Collections.singletonList(tagContent));
        TAG_ID = schemaKeyword3;
        SchemaKeyword schemaKeyword4 = new SchemaKeyword("TAG_ANCHOR", 3, "$anchor", Collections.singletonList(tagContent));
        TAG_ANCHOR = schemaKeyword4;
        Function function = new Function() { // from class: al2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SchemaKeyword.lambda$static$0((SchemaVersion) obj);
            }
        };
        TagContent tagContent2 = TagContent.NAMED_SCHEMAS;
        SchemaKeyword schemaKeyword5 = new SchemaKeyword("TAG_DEFINITIONS", 4, function, Collections.singletonList(tagContent2), Collections.emptyList());
        TAG_DEFINITIONS = schemaKeyword5;
        SchemaKeyword schemaKeyword6 = new SchemaKeyword("TAG_REF", 5, "$ref", Collections.singletonList(tagContent));
        TAG_REF = schemaKeyword6;
        SchemaKeyword schemaKeyword7 = new SchemaKeyword("TAG_REF_MAIN", 6, "#");
        TAG_REF_MAIN = schemaKeyword7;
        SchemaKeyword schemaKeyword8 = new SchemaKeyword("TAG_REF_PREFIX", 7, new Function() { // from class: bl2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SchemaKeyword.lambda$static$1((SchemaVersion) obj);
            }
        }, Collections.emptyList(), Collections.emptyList());
        TAG_REF_PREFIX = schemaKeyword8;
        SchemaKeyword schemaKeyword9 = new SchemaKeyword("TAG_TYPE", 8, SocialConstants.PARAM_TYPE, Collections.singletonList(tagContent));
        TAG_TYPE = schemaKeyword9;
        SchemaKeyword schemaKeyword10 = new SchemaKeyword("TAG_TYPE_NULL", 9, SchemaType.NULL.getSchemaKeywordValue());
        TAG_TYPE_NULL = schemaKeyword10;
        SchemaType schemaType = SchemaType.ARRAY;
        SchemaKeyword schemaKeyword11 = new SchemaKeyword("TAG_TYPE_ARRAY", 10, schemaType.getSchemaKeywordValue());
        TAG_TYPE_ARRAY = schemaKeyword11;
        SchemaType schemaType2 = SchemaType.OBJECT;
        SchemaKeyword schemaKeyword12 = new SchemaKeyword("TAG_TYPE_OBJECT", 11, schemaType2.getSchemaKeywordValue());
        TAG_TYPE_OBJECT = schemaKeyword12;
        SchemaKeyword schemaKeyword13 = new SchemaKeyword("TAG_TYPE_BOOLEAN", 12, SchemaType.BOOLEAN.getSchemaKeywordValue());
        TAG_TYPE_BOOLEAN = schemaKeyword13;
        SchemaType schemaType3 = SchemaType.STRING;
        SchemaKeyword schemaKeyword14 = new SchemaKeyword("TAG_TYPE_STRING", 13, schemaType3.getSchemaKeywordValue());
        TAG_TYPE_STRING = schemaKeyword14;
        SchemaType schemaType4 = SchemaType.INTEGER;
        SchemaKeyword schemaKeyword15 = new SchemaKeyword("TAG_TYPE_INTEGER", 14, schemaType4.getSchemaKeywordValue());
        TAG_TYPE_INTEGER = schemaKeyword15;
        SchemaType schemaType5 = SchemaType.NUMBER;
        SchemaKeyword schemaKeyword16 = new SchemaKeyword("TAG_TYPE_NUMBER", 15, schemaType5.getSchemaKeywordValue());
        TAG_TYPE_NUMBER = schemaKeyword16;
        SchemaKeyword schemaKeyword17 = new SchemaKeyword("TAG_PROPERTIES", 16, "properties", Collections.singletonList(tagContent2), Collections.singletonList(schemaType2));
        TAG_PROPERTIES = schemaKeyword17;
        TagContent tagContent3 = TagContent.SCHEMA;
        SchemaKeyword schemaKeyword18 = new SchemaKeyword("TAG_UNEVALUATED_PROPERTIES", 17, "unevaluatedProperties", Collections.singletonList(tagContent3), Collections.singletonList(schemaType2));
        TAG_UNEVALUATED_PROPERTIES = schemaKeyword18;
        TagContent tagContent4 = TagContent.ARRAY_OF_SCHEMAS;
        SchemaKeyword schemaKeyword19 = new SchemaKeyword("TAG_ITEMS", 18, "items", Arrays.asList(tagContent3, tagContent4), Collections.singletonList(schemaType));
        TAG_ITEMS = schemaKeyword19;
        SchemaKeyword schemaKeyword20 = new SchemaKeyword("TAG_PREFIX_ITEMS", 19, new Function() { // from class: cl2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SchemaKeyword.lambda$static$2((SchemaVersion) obj);
            }
        }, Collections.singletonList(tagContent4), Collections.singletonList(schemaType));
        TAG_PREFIX_ITEMS = schemaKeyword20;
        SchemaKeyword schemaKeyword21 = new SchemaKeyword("TAG_UNEVALUATED_ITEMS", 20, "unevaluatedItems", Collections.singletonList(tagContent3), Collections.singletonList(schemaType));
        TAG_UNEVALUATED_ITEMS = schemaKeyword21;
        SchemaKeyword schemaKeyword22 = new SchemaKeyword("TAG_REQUIRED", 21, "required", Collections.singletonList(tagContent), Collections.singletonList(schemaType2));
        TAG_REQUIRED = schemaKeyword22;
        SchemaKeyword schemaKeyword23 = new SchemaKeyword("TAG_DEPENDENT_SCHEMAS", 22, new Function() { // from class: dl2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SchemaKeyword.lambda$static$3((SchemaVersion) obj);
            }
        }, Collections.singletonList(tagContent2), Collections.singletonList(schemaType2));
        TAG_DEPENDENT_SCHEMAS = schemaKeyword23;
        SchemaKeyword schemaKeyword24 = new SchemaKeyword("TAG_DEPENDENT_REQUIRED", 23, new Function() { // from class: el2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SchemaKeyword.lambda$static$4((SchemaVersion) obj);
            }
        }, Collections.singletonList(tagContent), Collections.singletonList(schemaType2));
        TAG_DEPENDENT_REQUIRED = schemaKeyword24;
        SchemaKeyword schemaKeyword25 = new SchemaKeyword("TAG_ADDITIONAL_PROPERTIES", 24, "additionalProperties", Collections.singletonList(tagContent3), Collections.singletonList(schemaType2));
        TAG_ADDITIONAL_PROPERTIES = schemaKeyword25;
        SchemaKeyword schemaKeyword26 = new SchemaKeyword("TAG_PATTERN_PROPERTIES", 25, "patternProperties", Collections.singletonList(tagContent2), Collections.singletonList(schemaType2));
        TAG_PATTERN_PROPERTIES = schemaKeyword26;
        SchemaKeyword schemaKeyword27 = new SchemaKeyword("TAG_PROPERTIES_MIN", 26, "minProperties", Collections.singletonList(tagContent), Collections.singletonList(schemaType2));
        TAG_PROPERTIES_MIN = schemaKeyword27;
        SchemaKeyword schemaKeyword28 = new SchemaKeyword("TAG_PROPERTIES_MAX", 27, "maxProperties", Collections.singletonList(tagContent), Collections.singletonList(schemaType2));
        TAG_PROPERTIES_MAX = schemaKeyword28;
        SchemaKeyword schemaKeyword29 = new SchemaKeyword("TAG_ALLOF", 28, "allOf", Collections.singletonList(tagContent4));
        TAG_ALLOF = schemaKeyword29;
        SchemaKeyword schemaKeyword30 = new SchemaKeyword("TAG_ANYOF", 29, "anyOf", Collections.singletonList(tagContent4));
        TAG_ANYOF = schemaKeyword30;
        SchemaKeyword schemaKeyword31 = new SchemaKeyword("TAG_ONEOF", 30, "oneOf", Collections.singletonList(tagContent4));
        TAG_ONEOF = schemaKeyword31;
        SchemaKeyword schemaKeyword32 = new SchemaKeyword("TAG_NOT", 31, "not", Collections.singletonList(tagContent3));
        TAG_NOT = schemaKeyword32;
        SchemaKeyword schemaKeyword33 = new SchemaKeyword("TAG_TITLE", 32, "title", Collections.singletonList(tagContent));
        TAG_TITLE = schemaKeyword33;
        SchemaKeyword schemaKeyword34 = new SchemaKeyword("TAG_DESCRIPTION", 33, SocialConstants.PARAM_COMMENT, Collections.singletonList(tagContent));
        TAG_DESCRIPTION = schemaKeyword34;
        SchemaKeyword schemaKeyword35 = new SchemaKeyword("TAG_CONST", 34, "const", Collections.singletonList(tagContent));
        TAG_CONST = schemaKeyword35;
        SchemaKeyword schemaKeyword36 = new SchemaKeyword("TAG_ENUM", 35, "enum", Collections.singletonList(tagContent));
        TAG_ENUM = schemaKeyword36;
        SchemaKeyword schemaKeyword37 = new SchemaKeyword("TAG_DEFAULT", 36, "default", Collections.singletonList(tagContent));
        TAG_DEFAULT = schemaKeyword37;
        SchemaKeyword schemaKeyword38 = new SchemaKeyword("TAG_READ_ONLY", 37, "readOnly", Collections.singletonList(tagContent));
        TAG_READ_ONLY = schemaKeyword38;
        SchemaKeyword schemaKeyword39 = new SchemaKeyword("TAG_WRITE_ONLY", 38, "writeOnly", Collections.singletonList(tagContent));
        TAG_WRITE_ONLY = schemaKeyword39;
        SchemaKeyword schemaKeyword40 = new SchemaKeyword("TAG_LENGTH_MIN", 39, "minLength", Collections.singletonList(tagContent), Collections.singletonList(schemaType3));
        TAG_LENGTH_MIN = schemaKeyword40;
        SchemaKeyword schemaKeyword41 = new SchemaKeyword("TAG_LENGTH_MAX", 40, "maxLength", Collections.singletonList(tagContent), Collections.singletonList(schemaType3));
        TAG_LENGTH_MAX = schemaKeyword41;
        SchemaKeyword schemaKeyword42 = new SchemaKeyword("TAG_FORMAT", 41, "format", Collections.singletonList(tagContent), Collections.singletonList(schemaType3));
        TAG_FORMAT = schemaKeyword42;
        SchemaKeyword schemaKeyword43 = new SchemaKeyword("TAG_PATTERN", 42, "pattern", Collections.singletonList(tagContent), Collections.singletonList(schemaType3));
        TAG_PATTERN = schemaKeyword43;
        SchemaKeyword schemaKeyword44 = new SchemaKeyword("TAG_MINIMUM", 43, "minimum", Collections.singletonList(tagContent), Arrays.asList(schemaType4, schemaType5));
        TAG_MINIMUM = schemaKeyword44;
        SchemaKeyword schemaKeyword45 = new SchemaKeyword("TAG_MINIMUM_EXCLUSIVE", 44, "exclusiveMinimum", Collections.singletonList(tagContent), Arrays.asList(schemaType4, schemaType5));
        TAG_MINIMUM_EXCLUSIVE = schemaKeyword45;
        SchemaKeyword schemaKeyword46 = new SchemaKeyword("TAG_MAXIMUM", 45, "maximum", Collections.singletonList(tagContent), Arrays.asList(schemaType4, schemaType5));
        TAG_MAXIMUM = schemaKeyword46;
        SchemaKeyword schemaKeyword47 = new SchemaKeyword("TAG_MAXIMUM_EXCLUSIVE", 46, "exclusiveMaximum", Collections.singletonList(tagContent), Arrays.asList(schemaType4, schemaType5));
        TAG_MAXIMUM_EXCLUSIVE = schemaKeyword47;
        SchemaKeyword schemaKeyword48 = new SchemaKeyword("TAG_MULTIPLE_OF", 47, "multipleOf", Collections.singletonList(tagContent), Arrays.asList(schemaType4, schemaType5));
        TAG_MULTIPLE_OF = schemaKeyword48;
        SchemaKeyword schemaKeyword49 = new SchemaKeyword("TAG_ITEMS_MIN", 48, "minItems", Collections.singletonList(tagContent), Collections.singletonList(schemaType));
        TAG_ITEMS_MIN = schemaKeyword49;
        SchemaKeyword schemaKeyword50 = new SchemaKeyword("TAG_ITEMS_MAX", 49, "maxItems", Collections.singletonList(tagContent), Collections.singletonList(schemaType));
        TAG_ITEMS_MAX = schemaKeyword50;
        SchemaKeyword schemaKeyword51 = new SchemaKeyword("TAG_ITEMS_UNIQUE", 50, "uniqueItems", Collections.singletonList(tagContent), Collections.singletonList(schemaType));
        TAG_ITEMS_UNIQUE = schemaKeyword51;
        SchemaKeyword schemaKeyword52 = new SchemaKeyword("TAG_IF", 51, "if", Collections.singletonList(tagContent3));
        TAG_IF = schemaKeyword52;
        SchemaKeyword schemaKeyword53 = new SchemaKeyword("TAG_THEN", 52, "then", Collections.singletonList(tagContent3));
        TAG_THEN = schemaKeyword53;
        SchemaKeyword schemaKeyword54 = new SchemaKeyword("TAG_ELSE", 53, "else", Collections.singletonList(tagContent3));
        TAG_ELSE = schemaKeyword54;
        $VALUES = new SchemaKeyword[]{schemaKeyword, schemaKeyword2, schemaKeyword3, schemaKeyword4, schemaKeyword5, schemaKeyword6, schemaKeyword7, schemaKeyword8, schemaKeyword9, schemaKeyword10, schemaKeyword11, schemaKeyword12, schemaKeyword13, schemaKeyword14, schemaKeyword15, schemaKeyword16, schemaKeyword17, schemaKeyword18, schemaKeyword19, schemaKeyword20, schemaKeyword21, schemaKeyword22, schemaKeyword23, schemaKeyword24, schemaKeyword25, schemaKeyword26, schemaKeyword27, schemaKeyword28, schemaKeyword29, schemaKeyword30, schemaKeyword31, schemaKeyword32, schemaKeyword33, schemaKeyword34, schemaKeyword35, schemaKeyword36, schemaKeyword37, schemaKeyword38, schemaKeyword39, schemaKeyword40, schemaKeyword41, schemaKeyword42, schemaKeyword43, schemaKeyword44, schemaKeyword45, schemaKeyword46, schemaKeyword47, schemaKeyword48, schemaKeyword49, schemaKeyword50, schemaKeyword51, schemaKeyword52, schemaKeyword53, schemaKeyword54};
    }

    private SchemaKeyword(String str, int i, String str2) {
        this(str, i, str2, Collections.emptyList(), Collections.emptyList());
    }

    public static Map<String, SchemaKeyword> getReverseTagMap(final SchemaVersion schemaVersion, final Predicate<SchemaKeyword> predicate) {
        return (Map) Stream.of((Object[]) values()).filter(new Predicate() { // from class: gl2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return SchemaKeyword.lambda$getReverseTagMap$7(predicate, (SchemaKeyword) obj);
            }
        }).collect(Collectors.toMap(new Function() { // from class: hl2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SchemaKeyword.lambda$getReverseTagMap$8(schemaVersion, (SchemaKeyword) obj);
            }
        }, new Function() { // from class: xk2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SchemaKeyword.lambda$getReverseTagMap$9((SchemaKeyword) obj);
            }
        }, new BinaryOperator() { // from class: yk2
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return SchemaKeyword.lambda$getReverseTagMap$10((SchemaKeyword) obj, (SchemaKeyword) obj2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SchemaKeyword lambda$getReverseTagMap$10(SchemaKeyword schemaKeyword, SchemaKeyword schemaKeyword2) {
        return schemaKeyword;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getReverseTagMap$7(Predicate predicate, SchemaKeyword schemaKeyword) {
        return !schemaKeyword.contentTypes.isEmpty() && predicate.test(schemaKeyword);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getReverseTagMap$8(SchemaVersion schemaVersion, SchemaKeyword schemaKeyword) {
        return schemaKeyword.forVersion(schemaVersion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SchemaKeyword lambda$getReverseTagMap$9(SchemaKeyword schemaKeyword) {
        return schemaKeyword;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$5(String str, SchemaVersion schemaVersion) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$6(String str, SchemaVersion schemaVersion) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$0(SchemaVersion schemaVersion) {
        return (schemaVersion == SchemaVersion.DRAFT_6 || schemaVersion == SchemaVersion.DRAFT_7) ? "definitions" : "$defs";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$1(SchemaVersion schemaVersion) {
        return (schemaVersion == SchemaVersion.DRAFT_6 || schemaVersion == SchemaVersion.DRAFT_7) ? "#/definitions/" : "#/$defs/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$2(SchemaVersion schemaVersion) {
        return (schemaVersion == SchemaVersion.DRAFT_6 || schemaVersion == SchemaVersion.DRAFT_7) ? "items" : "prefixItems";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$3(SchemaVersion schemaVersion) {
        return (schemaVersion == SchemaVersion.DRAFT_6 || schemaVersion == SchemaVersion.DRAFT_7) ? "dependencies" : "dependentSchemas";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$4(SchemaVersion schemaVersion) {
        return (schemaVersion == SchemaVersion.DRAFT_6 || schemaVersion == SchemaVersion.DRAFT_7) ? "dependencies" : "dependentRequired";
    }

    public static SchemaKeyword valueOf(String str) {
        return (SchemaKeyword) Enum.valueOf(SchemaKeyword.class, str);
    }

    public static SchemaKeyword[] values() {
        return (SchemaKeyword[]) $VALUES.clone();
    }

    public String forVersion(SchemaVersion schemaVersion) {
        return this.valueProvider.apply(schemaVersion);
    }

    public List<SchemaType> getImpliedTypes() {
        return this.impliedTypes;
    }

    public boolean supportsContentType(TagContent tagContent) {
        return this.contentTypes.contains(tagContent);
    }

    private SchemaKeyword(String str, int i, final String str2, List list) {
        this(str, i, new Function() { // from class: wk2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SchemaKeyword.lambda$new$5(str2, (SchemaVersion) obj);
            }
        }, list, Collections.emptyList());
    }

    private SchemaKeyword(String str, int i, final String str2, List list, List list2) {
        this(str, i, new Function() { // from class: fl2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SchemaKeyword.lambda$new$6(str2, (SchemaVersion) obj);
            }
        }, list, list2);
    }

    private SchemaKeyword(String str, int i, Function function, List list, List list2) {
        super(str, i);
        this.valueProvider = function;
        this.contentTypes = Collections.unmodifiableList(list);
        this.impliedTypes = Collections.unmodifiableList(list2);
    }
}
