package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.g;
import defpackage.ap2;
import defpackage.c91;
import defpackage.db1;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends Activity implements db1, c91.a {
    private final ap2 extraDataMap = new ap2(0, 1, null);
    private final g lifecycleRegistry = new g(this);

    public static class a {
    }

    private final boolean l(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        String str = strArr[0];
        switch (str.hashCode()) {
            case -645125871:
                return str.equals("--translation") && Build.VERSION.SDK_INT >= 31;
            case 100470631:
                if (!str.equals("--dump-dumpable")) {
                    return false;
                }
                break;
            case 472614934:
                if (!str.equals("--list-dumpables")) {
                    return false;
                }
                break;
            case 1159329357:
                return str.equals("--contentcapture") && Build.VERSION.SDK_INT >= 29;
            case 1455016274:
                return str.equals("--autofill");
            default:
                return false;
        }
        return Build.VERSION.SDK_INT >= 33;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        p31.f(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        p31.e(decorView, "window.decorView");
        if (c91.d(decorView, keyEvent)) {
            return true;
        }
        return c91.e(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        p31.f(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        p31.e(decorView, "window.decorView");
        if (c91.d(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public <T extends a> T getExtraData(Class<T> cls) {
        p31.f(cls, "extraDataClass");
        return (T) this.extraDataMap.get(cls);
    }

    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.b.c(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        p31.f(bundle, "outState");
        this.lifecycleRegistry.n(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public void putExtraData(a aVar) {
        p31.f(aVar, "extraData");
        this.extraDataMap.put(aVar.getClass(), aVar);
    }

    protected final boolean shouldDumpInternalState(String[] strArr) {
        return !l(strArr);
    }

    @Override // c91.a
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        p31.f(keyEvent, "event");
        return super.dispatchKeyEvent(keyEvent);
    }
}
