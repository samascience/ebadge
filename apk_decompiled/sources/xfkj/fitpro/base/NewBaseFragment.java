package xfkj.fitpro.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blankj.utilcode.util.c;
import com.gyf.immersionbar.h;
import defpackage.di0;
import defpackage.hg;
import defpackage.wd3;
import defpackage.xd3;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NewBaseFragment<T extends wd3> extends BaseFrameFragment {
    protected Context c;
    public wd3 f;
    protected View g;
    protected String b = getClass().getSimpleName();
    private boolean d = false;
    private List e = new ArrayList();
    protected Handler h = new a();
    private List i = new ArrayList();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            NewBaseFragment.this.D(message);
            if (NewBaseFragment.this.e.contains(Integer.valueOf(message.what))) {
                NewBaseFragment.this.e.remove(Integer.valueOf(message.what));
            }
        }
    }

    private void w(Bundle bundle) {
        this.c = getActivity();
        B(this.g);
        z(bundle);
        A();
        this.d = true;
        di0.b(this);
    }

    public abstract void A();

    protected void B(View view) {
    }

    public boolean C() {
        return this.d;
    }

    protected void D(Message message) {
        int i = message.what;
        if (this.i.contains(Integer.valueOf(i))) {
            Map map = (Map) message.getData().getSerializable("Datas");
            boolean z = true;
            if (map != null && (map.get("is_ok") == null || !map.get("is_ok").equals("1"))) {
                z = false;
            }
            E(i, z);
        }
    }

    protected void E(int i, boolean z) {
    }

    protected void F() {
        if (this.e.isEmpty()) {
            return;
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            G(((Integer) it.next()).intValue());
        }
    }

    protected void G(int i) {
        this.e.remove(Integer.valueOf(i));
        this.h.removeMessages(i);
    }

    @Override // xfkj.fitpro.base.BaseFrameFragment, defpackage.dp2
    public void a() {
        h.q0(this).O(true).k0(true, 0.2f).G();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (hg.i == -1) {
            c.n();
            return null;
        }
        if (!(getClass().getGenericSuperclass() instanceof ParameterizedType)) {
            this.g = layoutInflater.inflate(y(), viewGroup, false);
            w(bundle);
            return this.g;
        }
        this.f = xd3.a(this, layoutInflater, viewGroup, false);
        w(bundle);
        View root = this.f.getRoot();
        this.g = root;
        return root;
    }

    @Override // com.gyf.immersionbar.components.SimpleImmersionFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        di0.c(this);
        super.onDestroyView();
        this.d = false;
        F();
        this.i.clear();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Object obj) {
    }

    protected View x(int i) {
        return this.g.findViewById(i);
    }

    protected int y() {
        return 0;
    }

    public abstract void z(Bundle bundle);
}
