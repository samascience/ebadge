package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import defpackage.cf3;
import defpackage.rs2;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class b extends androidx.constraintlayout.motion.widget.a {
    private String g;
    private int h = -1;
    private boolean i = false;
    private float j = Float.NaN;
    private float k = Float.NaN;
    private float l = Float.NaN;
    private float m = Float.NaN;
    private float n = Float.NaN;
    private float o = Float.NaN;
    private float p = Float.NaN;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f172q = Float.NaN;
    private float r = Float.NaN;
    private float s = Float.NaN;
    private float t = Float.NaN;
    private float u = Float.NaN;
    private float v = Float.NaN;
    private float w = Float.NaN;

    private static class a {
        private static SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyAttribute_android_alpha, 1);
            a.append(R$styleable.KeyAttribute_android_elevation, 2);
            a.append(R$styleable.KeyAttribute_android_rotation, 4);
            a.append(R$styleable.KeyAttribute_android_rotationX, 5);
            a.append(R$styleable.KeyAttribute_android_rotationY, 6);
            a.append(R$styleable.KeyAttribute_android_transformPivotX, 19);
            a.append(R$styleable.KeyAttribute_android_transformPivotY, 20);
            a.append(R$styleable.KeyAttribute_android_scaleX, 7);
            a.append(R$styleable.KeyAttribute_transitionPathRotate, 8);
            a.append(R$styleable.KeyAttribute_transitionEasing, 9);
            a.append(R$styleable.KeyAttribute_motionTarget, 10);
            a.append(R$styleable.KeyAttribute_framePosition, 12);
            a.append(R$styleable.KeyAttribute_curveFit, 13);
            a.append(R$styleable.KeyAttribute_android_scaleY, 14);
            a.append(R$styleable.KeyAttribute_android_translationX, 15);
            a.append(R$styleable.KeyAttribute_android_translationY, 16);
            a.append(R$styleable.KeyAttribute_android_translationZ, 17);
            a.append(R$styleable.KeyAttribute_motionProgress, 18);
        }

        public static void a(b bVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (a.get(index)) {
                    case 1:
                        bVar.j = typedArray.getFloat(index, bVar.j);
                        break;
                    case 2:
                        bVar.k = typedArray.getDimension(index, bVar.k);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + a.get(index));
                        break;
                    case 4:
                        bVar.l = typedArray.getFloat(index, bVar.l);
                        break;
                    case 5:
                        bVar.m = typedArray.getFloat(index, bVar.m);
                        break;
                    case 6:
                        bVar.n = typedArray.getFloat(index, bVar.n);
                        break;
                    case 7:
                        bVar.r = typedArray.getFloat(index, bVar.r);
                        break;
                    case 8:
                        bVar.f172q = typedArray.getFloat(index, bVar.f172q);
                        break;
                    case 9:
                        bVar.g = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.h1) {
                            int resourceId = typedArray.getResourceId(index, bVar.b);
                            bVar.b = resourceId;
                            if (resourceId == -1) {
                                bVar.c = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            bVar.c = typedArray.getString(index);
                        } else {
                            bVar.b = typedArray.getResourceId(index, bVar.b);
                        }
                        break;
                    case 12:
                        bVar.a = typedArray.getInt(index, bVar.a);
                        break;
                    case 13:
                        bVar.h = typedArray.getInteger(index, bVar.h);
                        break;
                    case 14:
                        bVar.s = typedArray.getFloat(index, bVar.s);
                        break;
                    case 15:
                        bVar.t = typedArray.getDimension(index, bVar.t);
                        break;
                    case 16:
                        bVar.u = typedArray.getDimension(index, bVar.u);
                        break;
                    case 17:
                        bVar.v = typedArray.getDimension(index, bVar.v);
                        break;
                    case 18:
                        bVar.w = typedArray.getFloat(index, bVar.w);
                        break;
                    case 19:
                        bVar.o = typedArray.getDimension(index, bVar.o);
                        break;
                    case 20:
                        bVar.p = typedArray.getDimension(index, bVar.p);
                        break;
                }
            }
        }
    }

    public b() {
        this.d = 1;
        this.e = new HashMap();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void R(String str, Object obj) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals("motionProgress")) {
                    b = 0;
                }
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    b = 1;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    b = 2;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    b = 3;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    b = 4;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    b = 5;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    b = 6;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b = 7;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b = 8;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    b = 9;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    b = 10;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    b = AttrAndFunCode.SYS_INFO_ATTR_HIGH_AND_BASS;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b = AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    b = AttrAndFunCode.SYS_INFO_ATTR_CURRENT_NOISE_MODE;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b = AttrAndFunCode.SYS_INFO_ATTR_ALL_NOISE_MODE;
                }
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    b = AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    b = AttrAndFunCode.SYS_INFO_ATTR_FIXED_LEN_DATA_FUN;
                }
                break;
        }
        switch (b) {
            case 0:
                this.w = k(obj);
                break;
            case 1:
                this.g = obj.toString();
                break;
            case 2:
                this.m = k(obj);
                break;
            case 3:
                this.n = k(obj);
                break;
            case 4:
                this.t = k(obj);
                break;
            case 5:
                this.u = k(obj);
                break;
            case 6:
                this.v = k(obj);
                break;
            case 7:
                this.r = k(obj);
                break;
            case 8:
                this.s = k(obj);
                break;
            case 9:
                this.o = k(obj);
                break;
            case 10:
                this.p = k(obj);
                break;
            case 11:
                this.l = k(obj);
                break;
            case 12:
                this.k = k(obj);
                break;
            case 13:
                this.f172q = k(obj);
                break;
            case 14:
                this.j = k(obj);
                break;
            case 15:
                this.h = l(obj);
                break;
            case 16:
                this.i = j(obj);
                break;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.motion.widget.a
    public void a(HashMap map) {
        for (String str : map.keySet()) {
            rs2 rs2Var = (rs2) map.get(str);
            if (rs2Var != null) {
                if (!str.startsWith("CUSTOM")) {
                    byte b = -1;
                    switch (str.hashCode()) {
                        case -1249320806:
                            if (str.equals("rotationX")) {
                                b = 0;
                            }
                            break;
                        case -1249320805:
                            if (str.equals("rotationY")) {
                                b = 1;
                            }
                            break;
                        case -1225497657:
                            if (str.equals("translationX")) {
                                b = 2;
                            }
                            break;
                        case -1225497656:
                            if (str.equals("translationY")) {
                                b = 3;
                            }
                            break;
                        case -1225497655:
                            if (str.equals("translationZ")) {
                                b = 4;
                            }
                            break;
                        case -1001078227:
                            if (str.equals("progress")) {
                                b = 5;
                            }
                            break;
                        case -908189618:
                            if (str.equals("scaleX")) {
                                b = 6;
                            }
                            break;
                        case -908189617:
                            if (str.equals("scaleY")) {
                                b = 7;
                            }
                            break;
                        case -760884510:
                            if (str.equals("transformPivotX")) {
                                b = 8;
                            }
                            break;
                        case -760884509:
                            if (str.equals("transformPivotY")) {
                                b = 9;
                            }
                            break;
                        case -40300674:
                            if (str.equals("rotation")) {
                                b = 10;
                            }
                            break;
                        case -4379043:
                            if (str.equals("elevation")) {
                                b = AttrAndFunCode.SYS_INFO_ATTR_HIGH_AND_BASS;
                            }
                            break;
                        case 37232917:
                            if (str.equals("transitionPathRotate")) {
                                b = AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE;
                            }
                            break;
                        case 92909918:
                            if (str.equals("alpha")) {
                                b = AttrAndFunCode.SYS_INFO_ATTR_CURRENT_NOISE_MODE;
                            }
                            break;
                    }
                    switch (b) {
                        case 0:
                            if (!Float.isNaN(this.m)) {
                                rs2Var.c(this.a, this.m);
                            }
                            break;
                        case 1:
                            if (!Float.isNaN(this.n)) {
                                rs2Var.c(this.a, this.n);
                            }
                            break;
                        case 2:
                            if (!Float.isNaN(this.t)) {
                                rs2Var.c(this.a, this.t);
                            }
                            break;
                        case 3:
                            if (!Float.isNaN(this.u)) {
                                rs2Var.c(this.a, this.u);
                            }
                            break;
                        case 4:
                            if (!Float.isNaN(this.v)) {
                                rs2Var.c(this.a, this.v);
                            }
                            break;
                        case 5:
                            if (!Float.isNaN(this.w)) {
                                rs2Var.c(this.a, this.w);
                            }
                            break;
                        case 6:
                            if (!Float.isNaN(this.r)) {
                                rs2Var.c(this.a, this.r);
                            }
                            break;
                        case 7:
                            if (!Float.isNaN(this.s)) {
                                rs2Var.c(this.a, this.s);
                            }
                            break;
                        case 8:
                            if (!Float.isNaN(this.m)) {
                                rs2Var.c(this.a, this.o);
                            }
                            break;
                        case 9:
                            if (!Float.isNaN(this.n)) {
                                rs2Var.c(this.a, this.p);
                            }
                            break;
                        case 10:
                            if (!Float.isNaN(this.l)) {
                                rs2Var.c(this.a, this.l);
                            }
                            break;
                        case 11:
                            if (!Float.isNaN(this.k)) {
                                rs2Var.c(this.a, this.k);
                            }
                            break;
                        case 12:
                            if (!Float.isNaN(this.f172q)) {
                                rs2Var.c(this.a, this.f172q);
                            }
                            break;
                        case 13:
                            if (!Float.isNaN(this.j)) {
                                rs2Var.c(this.a, this.j);
                            }
                            break;
                    }
                } else {
                    ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.e.get(str.substring(7));
                    if (constraintAttribute != null) {
                        ((cf3.b) rs2Var).i(this.a, constraintAttribute);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.a
    /* JADX INFO: renamed from: b */
    public androidx.constraintlayout.motion.widget.a clone() {
        return new b().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.a
    public androidx.constraintlayout.motion.widget.a c(androidx.constraintlayout.motion.widget.a aVar) {
        super.c(aVar);
        b bVar = (b) aVar;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
        this.m = bVar.m;
        this.n = bVar.n;
        this.o = bVar.o;
        this.p = bVar.p;
        this.f172q = bVar.f172q;
        this.r = bVar.r;
        this.s = bVar.s;
        this.t = bVar.t;
        this.u = bVar.u;
        this.v = bVar.v;
        this.w = bVar.w;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.a
    public void d(HashSet hashSet) {
        if (!Float.isNaN(this.j)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.k)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.u)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.v)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f172q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.w)) {
            hashSet.add("progress");
        }
        if (this.e.size() > 0) {
            Iterator it = this.e.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + ((String) it.next()));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.a
    public void e(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyAttribute));
    }

    @Override // androidx.constraintlayout.motion.widget.a
    public void h(HashMap map) {
        if (this.h == -1) {
            return;
        }
        if (!Float.isNaN(this.j)) {
            map.put("alpha", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.k)) {
            map.put("elevation", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.l)) {
            map.put("rotation", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.m)) {
            map.put("rotationX", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.n)) {
            map.put("rotationY", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.o)) {
            map.put("transformPivotX", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.p)) {
            map.put("transformPivotY", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.t)) {
            map.put("translationX", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.u)) {
            map.put("translationY", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.v)) {
            map.put("translationZ", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.f172q)) {
            map.put("transitionPathRotate", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.r)) {
            map.put("scaleX", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.s)) {
            map.put("scaleY", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.w)) {
            map.put("progress", Integer.valueOf(this.h));
        }
        if (this.e.size() > 0) {
            Iterator it = this.e.keySet().iterator();
            while (it.hasNext()) {
                map.put("CUSTOM," + ((String) it.next()), Integer.valueOf(this.h));
            }
        }
    }
}
