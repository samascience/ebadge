package kotlin.text;

import defpackage.ar0;
import defpackage.dg1;
import defpackage.ga2;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.rm2;
import defpackage.sm2;
import defpackage.x30;
import defpackage.y70;
import defpackage.yq0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes4.dex */
public final class Regex implements Serializable {
    public static final a Companion = new a(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    private static final class Serialized implements Serializable {
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        public static final class a {
            public /* synthetic */ a(y70 y70Var) {
                this();
            }

            private a() {
            }
        }

        public Serialized(String str, int i) {
            p31.f(str, "pattern");
            this.pattern = str;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            p31.e(patternCompile, "compile(...)");
            return new Regex(patternCompile);
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }
    }

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(int i) {
            return (i & 2) != 0 ? i | 64 : i;
        }

        private a() {
        }
    }

    public static final class b implements ar0 {
        final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.ar0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Enum r3) {
            e eVar = (e) r3;
            return Boolean.valueOf((this.a & eVar.getMask()) == eVar.getValue());
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$findAll$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements ar0 {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1, dg1.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // defpackage.ar0
        public final dg1 invoke(dg1 dg1Var) {
            p31.f(dg1Var, "p0");
            return dg1Var.next();
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$splitToSequence$1, reason: invalid class name */
    @h70(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", l = {275, DfuBaseService.NOTIFICATION_ID, 287}, m = "invokeSuspend")
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements or0 {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $limit;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CharSequence charSequence, int i, x30 x30Var) {
            super(2, x30Var);
            this.$input = charSequence;
            this.$limit = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            AnonymousClass1 anonymousClass1 = Regex.this.new AnonymousClass1(this.$input, this.$limit, x30Var);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.or0
        public final Object invoke(sm2 sm2Var, x30 x30Var) {
            return ((AnonymousClass1) create(sm2Var, x30Var)).invokeSuspend(k83.a);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0070 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x007b  */
        /* JADX WARN: Code duplicated, block: B:27:0x009c A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006e -> B:21:0x0071). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            sm2 sm2Var;
            Matcher matcher;
            int i;
            String string;
            String string2;
            Object objD = kotlin.coroutines.intrinsics.a.d();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.d.b(obj);
                sm2 sm2Var2 = (sm2) this.L$0;
                Matcher matcher2 = Regex.this.nativePattern.matcher(this.$input);
                if (this.$limit != 1 && matcher2.find()) {
                    int iEnd = 0;
                    sm2Var = sm2Var2;
                    matcher = matcher2;
                    i = 0;
                    string = this.$input.subSequence(iEnd, matcher.start()).toString();
                    this.L$0 = sm2Var;
                    this.L$1 = matcher;
                    this.I$0 = i;
                    this.label = 2;
                    if (sm2Var.a(string, this) == objD) {
                        return objD;
                    }
                    iEnd = matcher.end();
                    i++;
                    if (i != this.$limit - 1) {
                    }
                    CharSequence charSequence = this.$input;
                    string2 = charSequence.subSequence(iEnd, charSequence.length()).toString();
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 3;
                    if (sm2Var.a(string2, this) == objD) {
                        return objD;
                    }
                    return k83.a;
                }
                String string3 = this.$input.toString();
                this.label = 1;
                if (sm2Var2.a(string3, this) == objD) {
                    return objD;
                }
            } else {
                if (i2 != 1) {
                    if (i2 == 2) {
                        i = this.I$0;
                        Matcher matcher3 = (Matcher) this.L$1;
                        sm2Var = (sm2) this.L$0;
                        kotlin.d.b(obj);
                        matcher = matcher3;
                        iEnd = matcher.end();
                        i++;
                        if (i != this.$limit - 1 || !matcher.find()) {
                            CharSequence charSequence2 = this.$input;
                            string2 = charSequence2.subSequence(iEnd, charSequence2.length()).toString();
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 3;
                            if (sm2Var.a(string2, this) == objD) {
                                return objD;
                            }
                        }
                        string = this.$input.subSequence(iEnd, matcher.start()).toString();
                        this.L$0 = sm2Var;
                        this.L$1 = matcher;
                        this.I$0 = i;
                        this.label = 2;
                        if (sm2Var.a(string, this) == objD) {
                            return objD;
                        }
                        iEnd = matcher.end();
                        i++;
                        if (i != this.$limit - 1) {
                        }
                        CharSequence charSequence3 = this.$input;
                        string2 = charSequence3.subSequence(iEnd, charSequence3.length()).toString();
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 3;
                        if (sm2Var.a(string2, this) == objD) {
                            return objD;
                        }
                    } else {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.d.b(obj);
                    }
                    return k83.a;
                }
                kotlin.d.b(obj);
            }
            return k83.a;
        }
    }

    public Regex(Pattern pattern) {
        p31.f(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public static /* synthetic */ dg1 find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public static /* synthetic */ rm2 findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    public static /* synthetic */ rm2 splitToSequence$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.splitToSequence(charSequence, i);
    }

    private final Object writeReplace() {
        String strPattern = this.nativePattern.pattern();
        p31.e(strPattern, "pattern(...)");
        return new Serialized(strPattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence charSequence) {
        p31.f(charSequence, "input");
        return this.nativePattern.matcher(charSequence).find();
    }

    public final dg1 find(CharSequence charSequence, int i) {
        p31.f(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        p31.e(matcher, "matcher(...)");
        return h.f(matcher, i, charSequence);
    }

    public final rm2 findAll(final CharSequence charSequence, final int i) {
        p31.f(charSequence, "input");
        if (i >= 0 && i <= charSequence.length()) {
            return kotlin.sequences.d.g(new yq0() { // from class: pe2
                @Override // defpackage.yq0
                public final Object invoke() {
                    return this.a.find(charSequence, i);
                }
            }, AnonymousClass2.INSTANCE);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i + ", input length: " + charSequence.length());
    }

    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        int iFlags = this.nativePattern.flags();
        EnumSet enumSetAllOf = EnumSet.allOf(RegexOption.class);
        p31.c(enumSetAllOf);
        kotlin.collections.j.B(enumSetAllOf, new b(iFlags));
        Set<RegexOption> setUnmodifiableSet = Collections.unmodifiableSet(enumSetAllOf);
        p31.e(setUnmodifiableSet, "unmodifiableSet(...)");
        this._options = setUnmodifiableSet;
        return setUnmodifiableSet;
    }

    public final String getPattern() {
        String strPattern = this.nativePattern.pattern();
        p31.e(strPattern, "pattern(...)");
        return strPattern;
    }

    public final dg1 matchAt(CharSequence charSequence, int i) {
        p31.f(charSequence, "input");
        Matcher matcherRegion = this.nativePattern.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(i, charSequence.length());
        if (!matcherRegion.lookingAt()) {
            return null;
        }
        p31.c(matcherRegion);
        return new g(matcherRegion, charSequence);
    }

    public final dg1 matchEntire(CharSequence charSequence) {
        p31.f(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        p31.e(matcher, "matcher(...)");
        return h.g(matcher, charSequence);
    }

    public final boolean matches(CharSequence charSequence) {
        p31.f(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    public final boolean matchesAt(CharSequence charSequence, int i) {
        p31.f(charSequence, "input");
        return this.nativePattern.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(i, charSequence.length()).lookingAt();
    }

    public final String replace(CharSequence charSequence, String str) {
        p31.f(charSequence, "input");
        p31.f(str, "replacement");
        String strReplaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        p31.e(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public final String replaceFirst(CharSequence charSequence, String str) {
        p31.f(charSequence, "input");
        p31.f(str, "replacement");
        String strReplaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        p31.e(strReplaceFirst, "replaceFirst(...)");
        return strReplaceFirst;
    }

    public final List<String> split(CharSequence charSequence, int i) {
        p31.f(charSequence, "input");
        w.t0(i);
        Matcher matcher = this.nativePattern.matcher(charSequence);
        if (i == 1 || !matcher.find()) {
            return kotlin.collections.j.e(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(i > 0 ? ga2.d(i, 10) : 10);
        int i2 = i - 1;
        int iEnd = 0;
        do {
            arrayList.add(charSequence.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i2 >= 0 && arrayList.size() == i2) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(iEnd, charSequence.length()).toString());
        return arrayList;
    }

    public final rm2 splitToSequence(CharSequence charSequence, int i) {
        p31.f(charSequence, "input");
        w.t0(i);
        return kotlin.sequences.d.b(new AnonymousClass1(charSequence, i, null));
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String string = this.nativePattern.toString();
        p31.e(string, "toString(...)");
        return string;
    }

    public final String replace(CharSequence charSequence, ar0 ar0Var) {
        p31.f(charSequence, "input");
        p31.f(ar0Var, "transform");
        int iIntValue = 0;
        dg1 dg1VarFind$default = find$default(this, charSequence, 0, 2, null);
        if (dg1VarFind$default == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(charSequence, iIntValue, dg1VarFind$default.a().h().intValue());
            sb.append((CharSequence) ar0Var.invoke(dg1VarFind$default));
            iIntValue = dg1VarFind$default.a().g().intValue() + 1;
            dg1VarFind$default = dg1VarFind$default.next();
            if (iIntValue >= length) {
                break;
            }
        } while (dg1VarFind$default != null);
        if (iIntValue < length) {
            sb.append(charSequence, iIntValue, length);
        }
        String string = sb.toString();
        p31.e(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str) {
        p31.f(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        p31.e(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str, RegexOption regexOption) {
        p31.f(str, "pattern");
        p31.f(regexOption, "option");
        Pattern patternCompile = Pattern.compile(str, Companion.b(regexOption.getValue()));
        p31.e(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str, Set<? extends RegexOption> set) {
        p31.f(str, "pattern");
        p31.f(set, "options");
        Pattern patternCompile = Pattern.compile(str, Companion.b(h.j(set)));
        p31.e(patternCompile, "compile(...)");
        this(patternCompile);
    }
}
