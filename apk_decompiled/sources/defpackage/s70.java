package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ScrollingTabContainerView;

/* JADX INFO: loaded from: classes.dex */
public interface s70 {
    void a(Menu menu, j.a aVar);

    boolean b();

    void c();

    void collapseActionView();

    boolean d();

    boolean e();

    boolean f();

    boolean g();

    Context getContext();

    CharSequence getTitle();

    void h();

    void i(ScrollingTabContainerView scrollingTabContainerView);

    boolean j();

    void k(int i);

    Menu l();

    void m(int i);

    int n();

    xe3 o(int i, long j);

    void p(j.a aVar, e.a aVar2);

    void q(int i);

    ViewGroup r();

    void s(boolean z);

    void setIcon(int i);

    void setIcon(Drawable drawable);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    int t();

    void u();

    void v();

    void w(boolean z);
}
