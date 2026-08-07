package com.fasterxml.classmate.util;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ClassKey implements Comparable<ClassKey>, Serializable {
    private final Class<?> _class;
    private final String _className;
    private final int _hashCode;

    public ClassKey(Class<?> cls) {
        this._class = cls;
        String name = cls.getName();
        this._className = name;
        this._hashCode = name.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass() == getClass() && ((ClassKey) obj)._class == this._class;
    }

    public int hashCode() {
        return this._hashCode;
    }

    public String toString() {
        return this._className;
    }

    @Override // java.lang.Comparable
    public int compareTo(ClassKey classKey) {
        return this._className.compareTo(classKey._className);
    }
}
