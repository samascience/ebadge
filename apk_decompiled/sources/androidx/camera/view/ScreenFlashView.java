package androidx.camera.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.camera.core.u;
import androidx.camera.core.x;
import defpackage.ft;
import defpackage.t23;

/* JADX INFO: loaded from: classes.dex */
public final class ScreenFlashView extends View {
    private Window a;
    private u.i b;

    class a implements u.i {
        private float a;

        a() {
        }

        @Override // androidx.camera.core.u.i
        public void a(long j, u.j jVar) {
            x.a("ScreenFlashView", "ScreenFlash#apply");
            ScreenFlashView.this.setAlpha(1.0f);
            WindowManager.LayoutParams attributes = ScreenFlashView.this.a.getAttributes();
            this.a = attributes.screenBrightness;
            attributes.screenBrightness = 1.0f;
            ScreenFlashView.this.a.setAttributes(attributes);
            jVar.a();
        }

        @Override // androidx.camera.core.u.i
        public void clear() {
            x.a("ScreenFlashView", "ScreenFlash#clearScreenFlashUi");
            ScreenFlashView.this.setAlpha(0.0f);
            WindowManager.LayoutParams attributes = ScreenFlashView.this.a.getAttributes();
            attributes.screenBrightness = this.a;
            ScreenFlashView.this.a.setAttributes(attributes);
        }
    }

    public ScreenFlashView(Context context) {
        this(context, null);
    }

    private void b(Window window) {
        if (this.a != window) {
            this.b = window == null ? null : new a();
        }
    }

    private void setScreenFlashUiInfo(u.i iVar) {
        x.a("ScreenFlashView", "setScreenFlashUiInfo: mCameraController is null!");
    }

    public u.i getScreenFlash() {
        return this.b;
    }

    public void setController(ft ftVar) {
        t23.a();
    }

    public void setScreenFlashWindow(Window window) {
        t23.a();
        b(window);
        this.a = window;
        setScreenFlashUiInfo(getScreenFlash());
    }

    public ScreenFlashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScreenFlashView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ScreenFlashView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setBackgroundColor(-1);
        setAlpha(0.0f);
        setElevation(Float.MAX_VALUE);
    }
}
