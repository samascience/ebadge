package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class NameTransformer {
    public static final NameTransformer NOP = new NopTransformer();

    public static class Chained extends NameTransformer implements Serializable {
        private static final long serialVersionUID = 1;
        protected final NameTransformer _t1;
        protected final NameTransformer _t2;

        public Chained(NameTransformer nameTransformer, NameTransformer nameTransformer2) {
            this._t1 = nameTransformer;
            this._t2 = nameTransformer2;
        }

        @Override // com.fasterxml.jackson.databind.util.NameTransformer
        public String reverse(String str) {
            String strReverse = this._t1.reverse(str);
            return strReverse != null ? this._t2.reverse(strReverse) : strReverse;
        }

        public String toString() {
            return "[ChainedTransformer(" + this._t1 + ", " + this._t2 + ")]";
        }

        @Override // com.fasterxml.jackson.databind.util.NameTransformer
        public String transform(String str) {
            return this._t1.transform(this._t2.transform(str));
        }
    }

    protected static final class NopTransformer extends NameTransformer implements Serializable {
        private static final long serialVersionUID = 1;

        protected NopTransformer() {
        }

        @Override // com.fasterxml.jackson.databind.util.NameTransformer
        public String reverse(String str) {
            return str;
        }

        @Override // com.fasterxml.jackson.databind.util.NameTransformer
        public String transform(String str) {
            return str;
        }
    }

    static class a extends NameTransformer {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.fasterxml.jackson.databind.util.NameTransformer
        public String reverse(String str) {
            if (!str.startsWith(this.a)) {
                return null;
            }
            String strSubstring = str.substring(this.a.length());
            if (strSubstring.endsWith(this.b)) {
                return strSubstring.substring(0, strSubstring.length() - this.b.length());
            }
            return null;
        }

        public String toString() {
            return "[PreAndSuffixTransformer('" + this.a + "','" + this.b + "')]";
        }

        @Override // com.fasterxml.jackson.databind.util.NameTransformer
        public String transform(String str) {
            return this.a + str + this.b;
        }
    }

    static class b extends NameTransformer {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // com.fasterxml.jackson.databind.util.NameTransformer
        public String reverse(String str) {
            if (str.startsWith(this.a)) {
                return str.substring(this.a.length());
            }
            return null;
        }

        public String toString() {
            return "[PrefixTransformer('" + this.a + "')]";
        }

        @Override // com.fasterxml.jackson.databind.util.NameTransformer
        public String transform(String str) {
            return this.a + str;
        }
    }

    static class c extends NameTransformer {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // com.fasterxml.jackson.databind.util.NameTransformer
        public String reverse(String str) {
            if (str.endsWith(this.a)) {
                return str.substring(0, str.length() - this.a.length());
            }
            return null;
        }

        public String toString() {
            return "[SuffixTransformer('" + this.a + "')]";
        }

        @Override // com.fasterxml.jackson.databind.util.NameTransformer
        public String transform(String str) {
            return str + this.a;
        }
    }

    protected NameTransformer() {
    }

    public static NameTransformer chainedTransformer(NameTransformer nameTransformer, NameTransformer nameTransformer2) {
        return new Chained(nameTransformer, nameTransformer2);
    }

    public static NameTransformer simpleTransformer(String str, String str2) {
        boolean z = false;
        boolean z2 = (str == null || str.isEmpty()) ? false : true;
        if (str2 != null && !str2.isEmpty()) {
            z = true;
        }
        if (z2) {
            return z ? new a(str, str2) : new b(str);
        }
        return z ? new c(str2) : NOP;
    }

    public abstract String reverse(String str);

    public abstract String transform(String str);
}
