package com.airbnb.lottie.model.content;

import defpackage.j30;
import defpackage.je1;
import defpackage.o91;
import defpackage.s20;
import defpackage.ui1;

/* JADX INFO: loaded from: classes.dex */
public class MergePaths implements j30 {
    private final String a;
    private final MergePathsMode b;

    public enum MergePathsMode {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        public static MergePathsMode forId(int i) {
            if (i == 1) {
                return Merge;
            }
            if (i == 2) {
                return Add;
            }
            if (i == 3) {
                return Subtract;
            }
            if (i != 4) {
                return i != 5 ? Merge : ExcludeIntersections;
            }
            return Intersect;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode) {
        this.a = str;
        this.b = mergePathsMode;
    }

    @Override // defpackage.j30
    public s20 a(je1 je1Var, com.airbnb.lottie.model.layer.a aVar) {
        if (je1Var.h()) {
            return new ui1(this);
        }
        o91.d("Animation contains merge paths but they are disabled.");
        return null;
    }

    public MergePathsMode b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public String toString() {
        return "MergePaths{mode=" + this.b + '}';
    }
}
