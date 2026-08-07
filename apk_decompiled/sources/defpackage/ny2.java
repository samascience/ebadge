package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class ny2 {
    private Context a;
    private Drawable b;
    private Drawable c;
    private String d;
    private ColorStateList e;
    private int f;
    private Typeface g;
    private int h;
    private int i = -2;
    private int j = -2;
    private int k = 0;

    public ny2(Context context) {
        this.a = context;
    }

    public Drawable a() {
        return this.b;
    }

    public int b() {
        return this.j;
    }

    public Drawable c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public int e() {
        return this.h;
    }

    public int f() {
        return this.f;
    }

    public Typeface g() {
        return this.g;
    }

    public ColorStateList h() {
        return this.e;
    }

    public int i() {
        return this.k;
    }

    public int j() {
        return this.i;
    }

    public ny2 k(int i) {
        return l(q30.e(this.a, i));
    }

    public ny2 l(Drawable drawable) {
        this.b = drawable;
        return this;
    }

    public ny2 m(int i) {
        this.j = i;
        return this;
    }

    public ny2 n(int i) {
        return o(q30.e(this.a, i));
    }

    public ny2 o(Drawable drawable) {
        this.c = drawable;
        return this;
    }

    public ny2 p(int i) {
        this.i = i;
        return this;
    }
}
