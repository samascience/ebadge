package defpackage;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.filter.TokenFilter;

/* JADX INFO: loaded from: classes.dex */
public class u61 extends TokenFilter {
    protected final JsonPointer b;

    public u61(String str) {
        this(JsonPointer.compile(str));
    }

    @Override // com.fasterxml.jackson.core.filter.TokenFilter
    protected boolean a() {
        return this.b.matches();
    }

    @Override // com.fasterxml.jackson.core.filter.TokenFilter
    public TokenFilter d() {
        return this;
    }

    @Override // com.fasterxml.jackson.core.filter.TokenFilter
    public TokenFilter e() {
        return this;
    }

    @Override // com.fasterxml.jackson.core.filter.TokenFilter
    public TokenFilter f(int i) {
        JsonPointer jsonPointerMatchElement = this.b.matchElement(i);
        if (jsonPointerMatchElement == null) {
            return null;
        }
        return jsonPointerMatchElement.matches() ? TokenFilter.a : new u61(jsonPointerMatchElement);
    }

    @Override // com.fasterxml.jackson.core.filter.TokenFilter
    public TokenFilter i(String str) {
        JsonPointer jsonPointerMatchProperty = this.b.matchProperty(str);
        if (jsonPointerMatchProperty == null) {
            return null;
        }
        return jsonPointerMatchProperty.matches() ? TokenFilter.a : new u61(jsonPointerMatchProperty);
    }

    @Override // com.fasterxml.jackson.core.filter.TokenFilter
    public String toString() {
        return "[JsonPointerFilter at: " + this.b + "]";
    }

    public u61(JsonPointer jsonPointer) {
        this.b = jsonPointer;
    }
}
