package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.JsonParser;

/* JADX INFO: loaded from: classes.dex */
public class TokenFilter {
    public static final TokenFilter a = new TokenFilter();

    public enum Inclusion {
        ONLY_INCLUDE_ALL,
        INCLUDE_ALL_AND_PATH,
        INCLUDE_NON_NULL
    }

    protected TokenFilter() {
    }

    protected boolean a() {
        return true;
    }

    public void b() {
    }

    public void c() {
    }

    public TokenFilter d() {
        return this;
    }

    public TokenFilter e() {
        return this;
    }

    public TokenFilter f(int i) {
        return this;
    }

    public boolean g(boolean z) {
        return false;
    }

    public boolean h(boolean z) {
        return false;
    }

    public TokenFilter i(String str) {
        return this;
    }

    public TokenFilter j(int i) {
        return this;
    }

    public boolean k(JsonParser jsonParser) {
        return a();
    }

    public String toString() {
        return this == a ? "TokenFilter.INCLUDE_ALL" : super.toString();
    }
}
