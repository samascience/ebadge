package com.seeker.luckychart.model;

/* JADX INFO: loaded from: classes.dex */
public class CoorValue {
    private String label;
    private float rawValue;
    private float value;

    public CoorValue(float f, String str) {
        this.value = f;
        this.label = str;
    }

    public char[] getLabelAsChar() {
        return this.label.toCharArray();
    }

    public float getRawValue() {
        return this.rawValue;
    }

    public float getValue() {
        return this.value;
    }

    public void setRawValue(float f) {
        this.rawValue = f;
    }
}
