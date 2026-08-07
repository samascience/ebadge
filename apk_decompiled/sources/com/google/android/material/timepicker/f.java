package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.R$string;
import com.tencent.connect.common.Constants;
import defpackage.m2;
import defpackage.q30;

/* JADX INFO: loaded from: classes3.dex */
class f implements ClockHandView.c, TimePickerView.f, TimePickerView.e, ClockHandView.b, g {
    private static final String[] f = {Constants.VIA_REPORT_TYPE_SET_AVATAR, "1", "2", "3", Constants.VIA_TO_TYPE_QZONE, "5", Constants.VIA_SHARE_TYPE_INFO, "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_SHARE_TYPE_MINI_PROGRAM, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
    private static final String[] g = {"00", "1", "2", "3", Constants.VIA_TO_TYPE_QZONE, "5", Constants.VIA_SHARE_TYPE_INFO, "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_SHARE_TYPE_MINI_PROGRAM, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_REPORT_TYPE_JOININ_GROUP, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, Constants.VIA_REPORT_TYPE_WPA_STATE, Constants.VIA_REPORT_TYPE_START_WAP, Constants.VIA_REPORT_TYPE_START_GROUP, "18", Constants.VIA_ACT_TYPE_NINETEEN, "20", "21", Constants.VIA_REPORT_TYPE_DATALINE, Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR};
    private static final String[] h = {"00", "5", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_WPA_STATE, "20", Constants.VIA_REPORT_TYPE_CHAT_AUDIO, "30", "35", "40", "45", "50", "55"};
    private final TimePickerView a;
    private final TimeModel b;
    private float c;
    private float d;
    private boolean e = false;

    class a extends com.google.android.material.timepicker.a {
        a(Context context, int i) {
            super(context, i);
        }

        @Override // com.google.android.material.timepicker.a, defpackage.t1
        public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
            super.onInitializeAccessibilityNodeInfo(view, m2Var);
            m2Var.n0(view.getResources().getString(f.this.b.c(), String.valueOf(f.this.b.d())));
        }
    }

    class b extends com.google.android.material.timepicker.a {
        b(Context context, int i) {
            super(context, i);
        }

        @Override // com.google.android.material.timepicker.a, defpackage.t1
        public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
            super.onInitializeAccessibilityNodeInfo(view, m2Var);
            m2Var.n0(view.getResources().getString(R$string.material_minute_suffix, String.valueOf(f.this.b.e)));
        }
    }

    public f(TimePickerView timePickerView, TimeModel timeModel) {
        this.a = timePickerView;
        this.b = timeModel;
        k();
    }

    private String[] i() {
        return this.b.c == 1 ? g : f;
    }

    private int j() {
        return (this.b.d() * 30) % 360;
    }

    private void l(int i, int i2) {
        TimeModel timeModel = this.b;
        if (timeModel.e == i2 && timeModel.d == i) {
            return;
        }
        this.a.performHapticFeedback(4);
    }

    private void n() {
        TimeModel timeModel = this.b;
        int i = 1;
        if (timeModel.f == 10 && timeModel.c == 1 && timeModel.d >= 12) {
            i = 2;
        }
        this.a.J(i);
    }

    private void o() {
        TimePickerView timePickerView = this.a;
        TimeModel timeModel = this.b;
        timePickerView.W(timeModel.g, timeModel.d(), this.b.e);
    }

    private void p() {
        q(f, "%d");
        q(h, "%02d");
    }

    private void q(String[] strArr, String str) {
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = TimeModel.b(this.a.getResources(), strArr[i], str);
        }
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void a(float f2, boolean z) {
        if (this.e) {
            return;
        }
        TimeModel timeModel = this.b;
        int i = timeModel.d;
        int i2 = timeModel.e;
        int iRound = Math.round(f2);
        TimeModel timeModel2 = this.b;
        if (timeModel2.f == 12) {
            timeModel2.i((iRound + 3) / 6);
            this.c = (float) Math.floor(this.b.e * 6);
        } else {
            int i3 = (iRound + 15) / 30;
            if (timeModel2.c == 1) {
                i3 %= 12;
                if (this.a.F() == 2) {
                    i3 += 12;
                }
            }
            this.b.h(i3);
            this.d = j();
        }
        if (z) {
            return;
        }
        o();
        l(i, i2);
    }

    @Override // com.google.android.material.timepicker.g
    public void b() {
        this.a.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.g
    public void c() {
        this.d = j();
        TimeModel timeModel = this.b;
        this.c = timeModel.e * 6;
        m(timeModel.f, false);
        o();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.b
    public void d(float f2, boolean z) {
        this.e = true;
        TimeModel timeModel = this.b;
        int i = timeModel.e;
        int i2 = timeModel.d;
        if (timeModel.f == 10) {
            this.a.K(this.d, false);
            AccessibilityManager accessibilityManager = (AccessibilityManager) q30.i(this.a.getContext(), AccessibilityManager.class);
            if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
                m(12, true);
            }
        } else {
            int iRound = Math.round(f2);
            if (!z) {
                this.b.i(((iRound + 15) / 30) * 5);
                this.c = this.b.e * 6;
            }
            this.a.K(this.c, z);
        }
        this.e = false;
        o();
        l(i2, i);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.e
    public void e(int i) {
        this.b.j(i);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.f
    public void f(int i) {
        m(i, true);
    }

    @Override // com.google.android.material.timepicker.g
    public void g() {
        this.a.setVisibility(8);
    }

    public void k() {
        if (this.b.c == 0) {
            this.a.U();
        }
        this.a.E(this);
        this.a.Q(this);
        this.a.P(this);
        this.a.N(this);
        p();
        c();
    }

    void m(int i, boolean z) {
        boolean z2 = i == 12;
        this.a.I(z2);
        this.b.f = i;
        this.a.S(z2 ? h : i(), z2 ? R$string.material_minute_suffix : this.b.c());
        n();
        this.a.K(z2 ? this.c : this.d, z);
        this.a.H(i);
        this.a.M(new a(this.a.getContext(), R$string.material_hour_selection));
        this.a.L(new b(this.a.getContext(), R$string.material_minute_selection));
    }
}
