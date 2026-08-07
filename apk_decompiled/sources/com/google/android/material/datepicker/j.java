package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import defpackage.hw1;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
abstract class j extends Fragment {
    protected final LinkedHashSet a = new LinkedHashSet();

    j() {
    }

    boolean v(hw1 hw1Var) {
        return this.a.add(hw1Var);
    }

    void w() {
        this.a.clear();
    }
}
