package defpackage;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class v61 extends u51 {
    private final Object a;

    public v61(Boolean bool) {
        Objects.requireNonNull(bool);
        this.a = bool;
    }

    private static boolean o(v61 v61Var) {
        Object obj = v61Var.a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // defpackage.u51
    public int a() {
        return p() ? m().intValue() : Integer.parseInt(e());
    }

    @Override // defpackage.u51
    public String e() {
        Object obj = this.a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (p()) {
            return m().toString();
        }
        if (n()) {
            return ((Boolean) this.a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.a.getClass());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v61.class != obj.getClass()) {
            return false;
        }
        v61 v61Var = (v61) obj;
        if (this.a == null) {
            return v61Var.a == null;
        }
        if (o(this) && o(v61Var)) {
            return m().longValue() == v61Var.m().longValue();
        }
        Object obj2 = this.a;
        if (!(obj2 instanceof Number) || !(v61Var.a instanceof Number)) {
            return obj2.equals(v61Var.a);
        }
        double dDoubleValue = m().doubleValue();
        double dDoubleValue2 = v61Var.m().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.a == null) {
            return 31;
        }
        if (o(this)) {
            jDoubleToLongBits = m().longValue();
        } else {
            Object obj = this.a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(m().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public boolean j() {
        return n() ? ((Boolean) this.a).booleanValue() : Boolean.parseBoolean(e());
    }

    public double k() {
        return p() ? m().doubleValue() : Double.parseDouble(e());
    }

    public long l() {
        return p() ? m().longValue() : Long.parseLong(e());
    }

    public Number m() {
        Object obj = this.a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new LazilyParsedNumber((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean n() {
        return this.a instanceof Boolean;
    }

    public boolean p() {
        return this.a instanceof Number;
    }

    public boolean q() {
        return this.a instanceof String;
    }

    public v61(Number number) {
        Objects.requireNonNull(number);
        this.a = number;
    }

    public v61(String str) {
        Objects.requireNonNull(str);
        this.a = str;
    }

    public v61(Character ch) {
        Objects.requireNonNull(ch);
        this.a = ch.toString();
    }
}
