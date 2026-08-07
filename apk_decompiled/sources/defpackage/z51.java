package defpackage;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

/* JADX INFO: loaded from: classes.dex */
public abstract class z51 extends it0 {
    protected static final int[] r = ex.e();
    protected static final d41 s = JsonGenerator.c;
    protected final oy0 k;
    protected int[] l;
    protected int m;
    protected CharacterEscapes n;
    protected vm2 o;
    protected boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected boolean f457q;

    public z51(oy0 oy0Var, int i, jt1 jt1Var) {
        super(i, jt1Var);
        this.l = r;
        this.o = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        this.k = oy0Var;
        if (JsonGenerator.Feature.ESCAPE_NON_ASCII.enabledIn(i)) {
            this.m = 127;
        }
        this.f457q = JsonGenerator.Feature.WRITE_HEX_UPPER_CASE.enabledIn(i);
        this.p = !JsonGenerator.Feature.QUOTE_FIELD_NAMES.enabledIn(i);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator A0(int i) {
        if (i < 0) {
            i = 0;
        }
        this.m = i;
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator G0(vm2 vm2Var) {
        this.o = vm2Var;
        return this;
    }

    @Override // defpackage.it0
    protected void G1(int i, int i2) {
        super.G1(i, i2);
        this.p = !JsonGenerator.Feature.QUOTE_FIELD_NAMES.enabledIn(i);
        this.f457q = JsonGenerator.Feature.WRITE_HEX_UPPER_CASE.enabledIn(i);
    }

    protected void J1(String str) {
        n(String.format("Can not %s, expecting field name (context: %s)", str, this.h.m()));
    }

    protected void K1(String str, int i) {
        if (i == 0) {
            if (this.h.i()) {
                this.a.beforeArrayValues(this);
                return;
            } else {
                if (this.h.j()) {
                    this.a.beforeObjectEntries(this);
                    return;
                }
                return;
            }
        }
        if (i == 1) {
            this.a.writeArrayValueSeparator(this);
            return;
        }
        if (i == 2) {
            this.a.writeObjectFieldValueSeparator(this);
            return;
        }
        if (i == 3) {
            this.a.writeRootValueSeparator(this);
        } else if (i != 5) {
            u();
        } else {
            J1(str);
        }
    }

    @Override // defpackage.it0, com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator e0(JsonGenerator.Feature feature) {
        super.e0(feature);
        if (feature == JsonGenerator.Feature.QUOTE_FIELD_NAMES) {
            this.p = true;
        } else if (feature == JsonGenerator.Feature.WRITE_HEX_UPPER_CASE) {
            this.f457q = false;
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator w0(CharacterEscapes characterEscapes) {
        this.n = characterEscapes;
        if (characterEscapes == null) {
            this.l = r;
        } else {
            this.l = characterEscapes.getEscapeCodesForAscii();
        }
        return this;
    }
}
