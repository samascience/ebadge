package com.google.android.material.search;

import android.animation.Animator;
import android.view.View;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
class a {
    private Animator d;
    private Animator e;
    private final Set a = new LinkedHashSet();
    private final Set b = new LinkedHashSet();
    private final Set c = new LinkedHashSet();
    private boolean f = true;
    private Animator g = null;

    a() {
    }

    void a(boolean z) {
        this.f = z;
    }

    void b(SearchBar searchBar) {
        Animator animator = this.d;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.e;
        if (animator2 != null) {
            animator2.end();
        }
        View centerView = searchBar.getCenterView();
        if (centerView != null) {
            centerView.setAlpha(0.0f);
        }
    }
}
