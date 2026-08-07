package kotlin.text;

import defpackage.ga2;
import defpackage.ja1;
import defpackage.vh0;
import defpackage.y70;
import defpackage.yq0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.text.CharDirectionality;

/* JADX INFO: loaded from: classes4.dex */
public enum CharDirectionality {
    UNDEFINED(-1),
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1),
    RIGHT_TO_LEFT_ARABIC(2),
    EUROPEAN_NUMBER(3),
    EUROPEAN_NUMBER_SEPARATOR(4),
    EUROPEAN_NUMBER_TERMINATOR(5),
    ARABIC_NUMBER(6),
    COMMON_NUMBER_SEPARATOR(7),
    NONSPACING_MARK(8),
    BOUNDARY_NEUTRAL(9),
    PARAGRAPH_SEPARATOR(10),
    SEGMENT_SEPARATOR(11),
    WHITESPACE(12),
    OTHER_NEUTRALS(13),
    LEFT_TO_RIGHT_EMBEDDING(14),
    LEFT_TO_RIGHT_OVERRIDE(15),
    RIGHT_TO_LEFT_EMBEDDING(16),
    RIGHT_TO_LEFT_OVERRIDE(17),
    POP_DIRECTIONAL_FORMAT(18);

    private final int value;
    private static final /* synthetic */ vh0 $ENTRIES = kotlin.enums.a.a(values());
    public static final a Companion = new a(null);
    private static final ja1 directionalityMap$delegate = kotlin.a.a(new yq0() { // from class: dx
        @Override // defpackage.yq0
        public final Object invoke() {
            return CharDirectionality.directionalityMap_delegate$lambda$1();
        }
    });

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    CharDirectionality(int i) {
        this.value = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map directionalityMap_delegate$lambda$1() {
        vh0 entries = getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(ga2.b(kotlin.collections.u.c(kotlin.collections.j.t(entries, 10)), 16));
        for (Object obj : entries) {
            linkedHashMap.put(Integer.valueOf(((CharDirectionality) obj).value), obj);
        }
        return linkedHashMap;
    }

    public static vh0 getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }
}
