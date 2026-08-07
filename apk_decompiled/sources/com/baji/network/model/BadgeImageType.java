package com.baji.network.model;

import defpackage.vh0;
import defpackage.y70;
import kotlin.enums.a;

/* JADX INFO: loaded from: classes.dex */
public enum BadgeImageType {
    BORDER(1, "边框"),
    STICKER(2, "贴纸"),
    TIME_STYLE(3, "时间样式");

    private final String description;
    private final int value;
    private static final /* synthetic */ vh0 $ENTRIES = a.a(values());
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(y70 y70Var) {
            this();
        }

        public final BadgeImageType fromValue(int i) {
            for (BadgeImageType badgeImageType : BadgeImageType.values()) {
                if (badgeImageType.getValue() == i) {
                    return badgeImageType;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    BadgeImageType(int i, String str) {
        this.value = i;
        this.description = str;
    }

    public static vh0 getEntries() {
        return $ENTRIES;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getValue() {
        return this.value;
    }
}
