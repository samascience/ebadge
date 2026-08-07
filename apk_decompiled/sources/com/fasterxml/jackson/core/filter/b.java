package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonToken;
import com.jieli.jl_rcsp.constant.WatchConstant;
import defpackage.h71;

/* JADX INFO: loaded from: classes.dex */
public class b extends h71 {
    protected final b c;
    protected b d;
    protected String e;
    protected TokenFilter f;
    protected boolean g;
    protected boolean h;

    protected b(int i, b bVar, TokenFilter tokenFilter, boolean z) {
        this.a = i;
        this.c = bVar;
        this.f = tokenFilter;
        this.b = -1;
        this.g = z;
        this.h = false;
    }

    public static b r(TokenFilter tokenFilter) {
        return new b(0, null, tokenFilter, true);
    }

    @Override // defpackage.h71
    public final String b() {
        return this.e;
    }

    @Override // defpackage.h71
    public Object c() {
        return null;
    }

    @Override // defpackage.h71
    public boolean g() {
        return this.e != null;
    }

    @Override // defpackage.h71
    public void l(Object obj) {
    }

    protected void n(StringBuilder sb) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.n(sb);
        }
        int i = this.a;
        if (i != 2) {
            if (i != 1) {
                sb.append(WatchConstant.FAT_FS_ROOT);
                return;
            }
            sb.append('[');
            sb.append(a());
            sb.append(']');
            return;
        }
        sb.append('{');
        if (this.e != null) {
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            sb.append(this.e);
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        } else {
            sb.append('?');
        }
        sb.append('}');
    }

    public TokenFilter o(TokenFilter tokenFilter) {
        int i = this.a;
        if (i == 2) {
            return tokenFilter;
        }
        int i2 = this.b + 1;
        this.b = i2;
        return i == 1 ? tokenFilter.f(i2) : tokenFilter.j(i2);
    }

    public b p(TokenFilter tokenFilter, boolean z) {
        b bVar = this.d;
        if (bVar != null) {
            return bVar.x(1, tokenFilter, z);
        }
        b bVar2 = new b(1, this, tokenFilter, z);
        this.d = bVar2;
        return bVar2;
    }

    public b q(TokenFilter tokenFilter, boolean z) {
        b bVar = this.d;
        if (bVar != null) {
            return bVar.x(2, tokenFilter, z);
        }
        b bVar2 = new b(2, this, tokenFilter, z);
        this.d = bVar2;
        return bVar2;
    }

    public b s(b bVar) {
        b bVar2 = this.c;
        if (bVar2 == bVar) {
            return this;
        }
        while (bVar2 != null) {
            b bVar3 = bVar2.c;
            if (bVar3 == bVar) {
                return bVar2;
            }
            bVar2 = bVar3;
        }
        return null;
    }

    public TokenFilter t() {
        return this.f;
    }

    @Override // defpackage.h71
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        n(sb);
        return sb.toString();
    }

    @Override // defpackage.h71
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public final b e() {
        return this.c;
    }

    public boolean v() {
        return this.g;
    }

    public JsonToken w() {
        if (!this.g) {
            this.g = true;
            return this.a == 2 ? JsonToken.START_OBJECT : JsonToken.START_ARRAY;
        }
        if (!this.h || this.a != 2) {
            return null;
        }
        this.h = false;
        return JsonToken.FIELD_NAME;
    }

    protected b x(int i, TokenFilter tokenFilter, boolean z) {
        this.a = i;
        this.f = tokenFilter;
        this.b = -1;
        this.e = null;
        this.g = z;
        this.h = false;
        return this;
    }

    public TokenFilter y(String str) {
        this.e = str;
        this.h = true;
        return this.f;
    }
}
