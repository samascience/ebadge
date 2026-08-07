package kotlin.text;

import defpackage.vh0;
import defpackage.y70;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'IGNORE_CASE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes4.dex */
public final class RegexOption implements e {
    private static final /* synthetic */ vh0 $ENTRIES;
    private static final /* synthetic */ RegexOption[] $VALUES;
    public static final RegexOption CANON_EQ;
    public static final RegexOption COMMENTS;
    public static final RegexOption DOT_MATCHES_ALL;
    public static final RegexOption IGNORE_CASE;
    public static final RegexOption LITERAL;
    public static final RegexOption MULTILINE;
    public static final RegexOption UNIX_LINES;
    private final int mask;
    private final int value;

    private static final /* synthetic */ RegexOption[] $values() {
        return new RegexOption[]{IGNORE_CASE, MULTILINE, LITERAL, UNIX_LINES, COMMENTS, DOT_MATCHES_ALL, CANON_EQ};
    }

    static {
        int i = 2;
        IGNORE_CASE = new RegexOption("IGNORE_CASE", 0, i, 0, 2, null);
        int i2 = 2;
        y70 y70Var = null;
        int i3 = 0;
        MULTILINE = new RegexOption("MULTILINE", 1, 8, i3, i2, y70Var);
        int i4 = 2;
        y70 y70Var2 = null;
        int i5 = 0;
        LITERAL = new RegexOption("LITERAL", i, 16, i5, i4, y70Var2);
        UNIX_LINES = new RegexOption("UNIX_LINES", 3, 1, i3, i2, y70Var);
        COMMENTS = new RegexOption("COMMENTS", 4, 4, i5, i4, y70Var2);
        DOT_MATCHES_ALL = new RegexOption("DOT_MATCHES_ALL", 5, 32, i3, i2, y70Var);
        CANON_EQ = new RegexOption("CANON_EQ", 6, 128, i5, i4, y70Var2);
        RegexOption[] regexOptionArr$values = $values();
        $VALUES = regexOptionArr$values;
        $ENTRIES = kotlin.enums.a.a(regexOptionArr$values);
    }

    private RegexOption(String str, int i, int i2, int i3) {
        super(str, i);
        this.value = i2;
        this.mask = i3;
    }

    public static vh0 getEntries() {
        return $ENTRIES;
    }

    public static RegexOption valueOf(String str) {
        return (RegexOption) Enum.valueOf(RegexOption.class, str);
    }

    public static RegexOption[] values() {
        return (RegexOption[]) $VALUES.clone();
    }

    @Override // kotlin.text.e
    public int getMask() {
        return this.mask;
    }

    @Override // kotlin.text.e
    public int getValue() {
        return this.value;
    }

    /* synthetic */ RegexOption(String str, int i, int i2, int i3, int i4, y70 y70Var) {
        this(str, i, i2, (i4 & 2) != 0 ? i2 : i3);
    }
}
