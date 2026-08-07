package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import defpackage.ms2;
import defpackage.vf0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class h {
    private final androidx.emoji2.text.e.j a;
    private final l b;
    private androidx.emoji2.text.e.InterfaceC0019e c;
    private final boolean d;
    private final int[] e;

    private static final class a {
        static int a(CharSequence charSequence, int i, int i2) {
            int length = charSequence.length();
            if (i < 0 || length < i || i2 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i2 != 0) {
                    i--;
                    if (i < 0) {
                        return z ? -1 : 0;
                    }
                    char cCharAt = charSequence.charAt(i);
                    if (z) {
                        if (!Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        i2--;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i2--;
                    } else {
                        if (Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        z = true;
                    }
                }
                return i;
            }
        }

        static int b(CharSequence charSequence, int i, int i2) {
            int length = charSequence.length();
            if (i < 0 || length < i || i2 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i2 != 0) {
                    if (i >= length) {
                        if (z) {
                            return -1;
                        }
                        return length;
                    }
                    char cCharAt = charSequence.charAt(i);
                    if (z) {
                        if (!Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i2--;
                        i++;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i2--;
                        i++;
                    } else {
                        if (Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i++;
                        z = true;
                    }
                }
                return i;
            }
        }
    }

    private static class b implements c {
        public n a;
        private final androidx.emoji2.text.e.j b;

        b(n nVar, androidx.emoji2.text.e.j jVar) {
            this.a = nVar;
            this.b = jVar;
        }

        @Override // androidx.emoji2.text.h.c
        public boolean b(CharSequence charSequence, int i, int i2, m mVar) {
            if (mVar.k()) {
                return true;
            }
            if (this.a == null) {
                this.a = new n(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
            }
            this.a.setSpan(this.b.a(mVar), i, i2, 33);
            return true;
        }

        @Override // androidx.emoji2.text.h.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public n a() {
            return this.a;
        }
    }

    private interface c {
        Object a();

        boolean b(CharSequence charSequence, int i, int i2, m mVar);
    }

    private static class d implements c {
        private final String a;

        d(String str) {
            this.a = str;
        }

        @Override // androidx.emoji2.text.h.c
        public boolean b(CharSequence charSequence, int i, int i2, m mVar) {
            if (!TextUtils.equals(charSequence.subSequence(i, i2), this.a)) {
                return true;
            }
            mVar.l(true);
            return false;
        }

        @Override // androidx.emoji2.text.h.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public d a() {
            return this;
        }
    }

    static final class e {
        private int a = 1;
        private final l.a b;
        private l.a c;
        private l.a d;
        private int e;
        private int f;
        private final boolean g;
        private final int[] h;

        e(l.a aVar, boolean z, int[] iArr) {
            this.b = aVar;
            this.c = aVar;
            this.g = z;
            this.h = iArr;
        }

        private static boolean d(int i) {
            return i == 65039;
        }

        private static boolean f(int i) {
            return i == 65038;
        }

        private int g() {
            this.a = 1;
            this.c = this.b;
            this.f = 0;
            return 1;
        }

        private boolean h() {
            if (this.c.b().j() || d(this.e)) {
                return true;
            }
            if (this.g) {
                if (this.h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.h, this.c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int a(int i) {
            l.a aVarA = this.c.a(i);
            int iG = 2;
            if (this.a != 2) {
                if (aVarA == null) {
                    iG = g();
                } else {
                    this.a = 2;
                    this.c = aVarA;
                    this.f = 1;
                }
            } else if (aVarA != null) {
                this.c = aVarA;
                this.f++;
            } else if (f(i)) {
                iG = g();
            } else if (!d(i)) {
                if (this.c.b() != null) {
                    iG = 3;
                    if (this.f != 1 || h()) {
                        this.d = this.c;
                        g();
                    } else {
                        iG = g();
                    }
                } else {
                    iG = g();
                }
            }
            this.e = i;
            return iG;
        }

        m b() {
            return this.c.b();
        }

        m c() {
            return this.d.b();
        }

        boolean e() {
            return this.a == 2 && this.c.b() != null && (this.f > 1 || h());
        }
    }

    h(l lVar, androidx.emoji2.text.e.j jVar, androidx.emoji2.text.e.InterfaceC0019e interfaceC0019e, boolean z, int[] iArr, Set set) {
        this.a = jVar;
        this.b = lVar;
        this.c = interfaceC0019e;
        this.d = z;
        this.e = iArr;
        g(set);
    }

    private static boolean a(Editable editable, KeyEvent keyEvent, boolean z) {
        vf0[] vf0VarArr;
        if (f(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!e(selectionStart, selectionEnd) && (vf0VarArr = (vf0[]) editable.getSpans(selectionStart, selectionEnd, vf0.class)) != null && vf0VarArr.length > 0) {
            for (vf0 vf0Var : vf0VarArr) {
                int spanStart = editable.getSpanStart(vf0Var);
                int spanEnd = editable.getSpanEnd(vf0Var);
                if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean b(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
        int iMax;
        int iMin;
        if (editable != null && inputConnection != null && i >= 0 && i2 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (e(selectionStart, selectionEnd)) {
                return false;
            }
            if (z) {
                iMax = a.a(editable, selectionStart, Math.max(i, 0));
                iMin = a.b(editable, selectionEnd, Math.max(i2, 0));
                if (iMax == -1 || iMin == -1) {
                    return false;
                }
            } else {
                iMax = Math.max(selectionStart - i, 0);
                iMin = Math.min(selectionEnd + i2, editable.length());
            }
            vf0[] vf0VarArr = (vf0[]) editable.getSpans(iMax, iMin, vf0.class);
            if (vf0VarArr != null && vf0VarArr.length > 0) {
                for (vf0 vf0Var : vf0VarArr) {
                    int spanStart = editable.getSpanStart(vf0Var);
                    int spanEnd = editable.getSpanEnd(vf0Var);
                    iMax = Math.min(spanStart, iMax);
                    iMin = Math.max(spanEnd, iMin);
                }
                int iMax2 = Math.max(iMax, 0);
                int iMin2 = Math.min(iMin, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(iMax2, iMin2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    static boolean c(Editable editable, int i, KeyEvent keyEvent) {
        boolean zA;
        if (i != 67) {
            zA = i != 112 ? false : a(editable, keyEvent, true);
        } else {
            zA = a(editable, keyEvent, false);
        }
        if (!zA) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean d(CharSequence charSequence, int i, int i2, m mVar) {
        if (mVar.d() == 0) {
            mVar.m(this.c.a(charSequence, i, i2, mVar.h()));
        }
        return mVar.d() == 2;
    }

    private static boolean e(int i, int i2) {
        return i == -1 || i2 == -1 || i != i2;
    }

    private static boolean f(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    private void g(Set set) {
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            i(str, 0, str.length(), 1, true, new d(str));
        }
    }

    private Object i(CharSequence charSequence, int i, int i2, int i3, boolean z, c cVar) {
        int iCharCount;
        e eVar = new e(this.b.f(), this.d, this.e);
        int i4 = 0;
        boolean zB = true;
        int iCodePointAt = Character.codePointAt(charSequence, i);
        loop0: while (true) {
            iCharCount = i;
            while (true) {
                if (i >= i2 || i4 >= i3 || !zB) {
                    break loop0;
                }
                int iA = eVar.a(iCodePointAt);
                if (iA == 1) {
                    iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                    if (iCharCount < i2) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    }
                    i = iCharCount;
                } else if (iA == 2) {
                    i += Character.charCount(iCodePointAt);
                    if (i < i2) {
                        iCodePointAt = Character.codePointAt(charSequence, i);
                    }
                } else if (iA != 3) {
                }
            }
            if (z || !d(charSequence, iCharCount, i, eVar.c())) {
                zB = cVar.b(charSequence, iCharCount, i, eVar.c());
                i4++;
            }
        }
        if (eVar.e() && i4 < i3 && zB && (z || !d(charSequence, iCharCount, i, eVar.b()))) {
            cVar.b(charSequence, iCharCount, i, eVar.b());
        }
        return cVar.a();
    }

    CharSequence h(CharSequence charSequence, int i, int i2, int i3, boolean z) {
        n nVar;
        vf0[] vf0VarArr;
        boolean z2 = charSequence instanceof ms2;
        if (z2) {
            ((ms2) charSequence).a();
        }
        if (!z2) {
            try {
                nVar = charSequence instanceof Spannable ? new n((Spannable) charSequence) : (!(charSequence instanceof Spanned) || ((Spanned) charSequence).nextSpanTransition(i + (-1), i2 + 1, vf0.class) > i2) ? null : new n(charSequence);
            } finally {
                if (z2) {
                    ((ms2) charSequence).d();
                }
            }
        }
        if (nVar != null && (vf0VarArr = (vf0[]) nVar.getSpans(i, i2, vf0.class)) != null && vf0VarArr.length > 0) {
            for (vf0 vf0Var : vf0VarArr) {
                int spanStart = nVar.getSpanStart(vf0Var);
                int spanEnd = nVar.getSpanEnd(vf0Var);
                if (spanStart != i2) {
                    nVar.removeSpan(vf0Var);
                }
                i = Math.min(spanStart, i);
                i2 = Math.max(spanEnd, i2);
            }
        }
        int i4 = i2;
        if (i != i4 && i < charSequence.length()) {
            if (i3 != Integer.MAX_VALUE && nVar != null) {
                i3 -= ((vf0[]) nVar.getSpans(0, nVar.length(), vf0.class)).length;
            }
            n nVar2 = (n) i(charSequence, i, i4, i3, z, new b(nVar, this.a));
            return nVar2 != null ? nVar2.b() : charSequence;
        }
        return charSequence;
    }
}
