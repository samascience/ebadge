package com.baidu.location;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;

    public static class a {
        private String a = null;
        private String b = null;
        private String c = null;
        private String d = null;
        private String e = null;
        private String f = null;
        private String g = null;
        private String h = null;
        private String i = null;
        private String j = null;
        private String k = null;

        public a l(String str) {
            this.j = str;
            return this;
        }

        public b m() {
            String str;
            StringBuffer stringBuffer = new StringBuffer();
            String str2 = this.a;
            if (str2 != null) {
                stringBuffer.append(str2);
            }
            String str3 = this.c;
            if (str3 != null) {
                stringBuffer.append(str3);
            }
            String str4 = this.c;
            if (str4 != null && (str = this.d) != null && !str4.equals(str)) {
                stringBuffer.append(this.d);
            }
            String str5 = this.f;
            if (str5 != null) {
                String str6 = this.d;
                if (str6 == null) {
                    stringBuffer.append(str5);
                } else if (!str6.equals(str5)) {
                    str5 = this.f;
                    stringBuffer.append(str5);
                }
            }
            String str7 = this.k;
            if (str7 != null) {
                stringBuffer.append(str7);
            }
            String str8 = this.g;
            if (str8 != null) {
                stringBuffer.append(str8);
            }
            String str9 = this.h;
            if (str9 != null) {
                stringBuffer.append(str9);
            }
            if (stringBuffer.length() > 0) {
                this.i = stringBuffer.toString();
            }
            return new b(this);
        }

        public a n(String str) {
            this.d = str;
            return this;
        }

        public a o(String str) {
            this.e = str;
            return this;
        }

        public a p(String str) {
            this.a = str;
            return this;
        }

        public a q(String str) {
            this.b = str;
            return this;
        }

        public a r(String str) {
            this.f = str;
            return this;
        }

        public a s(String str) {
            this.c = str;
            return this;
        }

        public a t(String str) {
            this.g = str;
            return this;
        }

        public a u(String str) {
            this.h = str;
            return this;
        }

        public a v(String str) {
            this.k = str;
            return this;
        }
    }

    private b(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
    }
}
