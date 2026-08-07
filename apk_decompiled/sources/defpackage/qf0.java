package defpackage;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public final class qf0 {
    private final b a;
    private int b = Integer.MAX_VALUE;
    private int c = 0;

    private static class a extends b {
        private final EditText a;
        private final xf0 b;

        a(EditText editText, boolean z) {
            this.a = editText;
            xf0 xf0Var = new xf0(editText, z);
            this.b = xf0Var;
            editText.addTextChangedListener(xf0Var);
            editText.setEditableFactory(rf0.getInstance());
        }

        @Override // qf0.b
        KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof uf0) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new uf0(keyListener);
        }

        @Override // qf0.b
        InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof sf0 ? inputConnection : new sf0(this.a, inputConnection, editorInfo);
        }

        @Override // qf0.b
        void c(boolean z) {
            this.b.c(z);
        }
    }

    static class b {
        b() {
        }

        abstract KeyListener a(KeyListener keyListener);

        abstract InputConnection b(InputConnection inputConnection, EditorInfo editorInfo);

        abstract void c(boolean z);
    }

    public qf0(EditText editText, boolean z) {
        b52.h(editText, "editText cannot be null");
        this.a = new a(editText, z);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.a.b(inputConnection, editorInfo);
    }

    public void c(boolean z) {
        this.a.c(z);
    }
}
