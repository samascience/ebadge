package com.fasterxml.jackson.databind.cfg;

import defpackage.hp0;
import defpackage.lb3;
import defpackage.u60;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class DatatypeFeatures implements Serializable {
    protected static final int FEATURE_INDEX_ENUM = 0;
    protected static final int FEATURE_INDEX_JSON_NODE = 1;
    private static final long serialVersionUID = 1;
    private final int _enabledFor1;
    private final int _enabledFor2;
    private final int _explicitFor1;
    private final int _explicitFor2;

    private static class a {
        private static final DatatypeFeatures a = new DatatypeFeatures(a(EnumFeature.values()), 0, a(JsonNodeFeature.values()), 0);

        /* JADX WARN: Multi-variable type inference failed */
        private static int a(Enum[] enumArr) {
            int mask = 0;
            for (hp0 hp0Var : enumArr) {
                if (hp0Var.enabledByDefault()) {
                    mask |= hp0Var.getMask();
                }
            }
            return mask;
        }

        public static DatatypeFeatures b() {
            return a;
        }
    }

    protected DatatypeFeatures(int i, int i2, int i3, int i4) {
        this._enabledFor1 = i;
        this._explicitFor1 = i2;
        this._enabledFor2 = i3;
        this._explicitFor2 = i4;
    }

    private static final int _calcMask(u60... u60VarArr) {
        int mask = 0;
        for (u60 u60Var : u60VarArr) {
            mask |= u60Var.getMask();
        }
        return mask;
    }

    private DatatypeFeatures _with(int i, int i2, int i3, int i4) {
        return (this._enabledFor1 == i && this._explicitFor1 == i2 && this._enabledFor2 == i3 && this._explicitFor2 == i4) ? this : new DatatypeFeatures(i, i2, i3, i4);
    }

    public static DatatypeFeatures defaultFeatures() {
        return a.b();
    }

    public Boolean getExplicitState(u60 u60Var) {
        int iFeatureIndex = u60Var.featureIndex();
        if (iFeatureIndex == 0) {
            if (u60Var.enabledIn(this._explicitFor1)) {
                return Boolean.valueOf(u60Var.enabledIn(this._enabledFor1));
            }
            return null;
        }
        if (iFeatureIndex != 1) {
            lb3.c();
            return null;
        }
        if (u60Var.enabledIn(this._explicitFor2)) {
            return Boolean.valueOf(u60Var.enabledIn(this._enabledFor2));
        }
        return null;
    }

    public boolean isEnabled(u60 u60Var) {
        int iFeatureIndex = u60Var.featureIndex();
        if (iFeatureIndex == 0) {
            return u60Var.enabledIn(this._enabledFor1);
        }
        if (iFeatureIndex == 1) {
            return u60Var.enabledIn(this._enabledFor2);
        }
        lb3.c();
        return false;
    }

    public boolean isExplicitlySet(u60 u60Var) {
        int iFeatureIndex = u60Var.featureIndex();
        if (iFeatureIndex == 0) {
            return u60Var.enabledIn(this._explicitFor1);
        }
        if (iFeatureIndex == 1) {
            return u60Var.enabledIn(this._explicitFor2);
        }
        lb3.c();
        return false;
    }

    public DatatypeFeatures with(u60 u60Var) {
        int mask = u60Var.getMask();
        int iFeatureIndex = u60Var.featureIndex();
        if (iFeatureIndex == 0) {
            return _with(this._enabledFor1 | mask, mask | this._explicitFor1, this._enabledFor2, this._explicitFor2);
        }
        if (iFeatureIndex == 1) {
            return _with(this._enabledFor1, this._explicitFor1, this._enabledFor2 | mask, mask | this._explicitFor2);
        }
        lb3.c();
        return this;
    }

    public DatatypeFeatures withFeatures(u60... u60VarArr) {
        int i_calcMask = _calcMask(u60VarArr);
        if (i_calcMask == 0) {
            return this;
        }
        int iFeatureIndex = u60VarArr[0].featureIndex();
        if (iFeatureIndex == 0) {
            return _with(this._enabledFor1 | i_calcMask, i_calcMask | this._explicitFor1, this._enabledFor2, this._explicitFor2);
        }
        if (iFeatureIndex == 1) {
            return _with(this._enabledFor1, this._explicitFor1, this._enabledFor2 | i_calcMask, i_calcMask | this._explicitFor2);
        }
        lb3.c();
        return this;
    }

    public DatatypeFeatures without(u60 u60Var) {
        int mask = u60Var.getMask();
        int iFeatureIndex = u60Var.featureIndex();
        if (iFeatureIndex == 0) {
            return _with(this._enabledFor1 & (~mask), mask | this._explicitFor1, this._enabledFor2, this._explicitFor2);
        }
        if (iFeatureIndex == 1) {
            return _with(this._enabledFor1, this._explicitFor1, this._enabledFor2 & (~mask), mask | this._explicitFor2);
        }
        lb3.c();
        return this;
    }

    public DatatypeFeatures withoutFeatures(u60... u60VarArr) {
        int i_calcMask = _calcMask(u60VarArr);
        if (i_calcMask == 0) {
            return this;
        }
        int iFeatureIndex = u60VarArr[0].featureIndex();
        if (iFeatureIndex == 0) {
            return _with(this._enabledFor1 & (~i_calcMask), i_calcMask | this._explicitFor1, this._enabledFor2, this._explicitFor2);
        }
        if (iFeatureIndex == 1) {
            return _with(this._enabledFor1, this._explicitFor1, this._enabledFor2 & (~i_calcMask), i_calcMask | this._explicitFor2);
        }
        lb3.c();
        return this;
    }
}
