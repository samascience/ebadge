package com.fasterxml.classmate.util;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MethodKey implements Serializable {
    private static final Class<?>[] NO_CLASSES = new Class[0];
    private final Class<?>[] _argumentTypes;
    private final int _hashCode;
    private final String _name;

    public MethodKey(String str) {
        this._name = str;
        this._argumentTypes = NO_CLASSES;
        this._hashCode = str.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        MethodKey methodKey = (MethodKey) obj;
        Class<?>[] clsArr = methodKey._argumentTypes;
        int length = this._argumentTypes.length;
        if (clsArr.length != length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (clsArr[i] != this._argumentTypes[i]) {
                return false;
            }
        }
        return this._name.equals(methodKey._name);
    }

    public int hashCode() {
        return this._hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._name);
        sb.append('(');
        int length = this._argumentTypes.length;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(this._argumentTypes[i].getName());
        }
        sb.append(')');
        return sb.toString();
    }

    public MethodKey(String str, Class<?>[] clsArr) {
        this._name = str;
        this._argumentTypes = clsArr;
        this._hashCode = str.hashCode() + clsArr.length;
    }
}
