package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.CharacterEscapes;
import defpackage.vm2;

/* JADX INFO: loaded from: classes.dex */
public class b extends c {
    protected CharacterEscapes i;
    protected vm2 j;
    protected int k;
    protected char l;

    public b() {
        this.l = JsonFactory.DEFAULT_QUOTE_CHAR;
        this.j = JsonFactory.DEFAULT_ROOT_VALUE_SEPARATOR;
        this.k = 0;
    }

    public b(JsonFactory jsonFactory) {
        super(jsonFactory);
        this.l = JsonFactory.DEFAULT_QUOTE_CHAR;
        this.i = jsonFactory.getCharacterEscapes();
        this.j = jsonFactory._rootValueSeparator;
        this.k = jsonFactory._maximumNonEscapedChar;
    }
}
