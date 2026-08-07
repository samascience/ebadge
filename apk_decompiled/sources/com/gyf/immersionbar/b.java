package com.gyf.immersionbar;

import android.view.View;
import defpackage.pv1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class b implements Cloneable {
    public View F;
    public int H;
    public int I;
    pv1 Q;
    public View z;
    public int a = 0;
    public int b = -16777216;
    public int c = -16777216;
    public float d = 0.0f;
    public float e = 0.0f;
    public float f = 0.0f;
    public float g = 0.0f;
    public boolean h = false;
    public boolean i = false;
    public BarHide j = BarHide.FLAG_SHOW_BAR;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public float o = 0.0f;
    public float p = 0.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f277q = true;
    public int r = -16777216;
    public int s = -16777216;
    Map t = new HashMap();
    public float u = 0.0f;
    public int v = 0;
    public int w = -16777216;
    public float x = 0.0f;
    public boolean y = false;
    public boolean G = true;
    public boolean J = false;
    public boolean K = false;
    public int L = 18;
    public boolean M = true;
    public boolean N = true;
    public boolean O = true;
    public boolean P = true;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b clone() {
        try {
            return (b) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
