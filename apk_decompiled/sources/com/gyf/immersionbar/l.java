package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class l implements Handler.Callback {
    private final String a;
    private final String b;
    private final Handler c;
    private final Map d;
    private final Map e;
    private final Map f;
    private final Map g;

    private static class b {
        private static final l a = new l();
    }

    private static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    private RequestBarManagerFragment d(FragmentManager fragmentManager, String str) {
        return e(fragmentManager, str, false);
    }

    private RequestBarManagerFragment e(FragmentManager fragmentManager, String str, boolean z) {
        RequestBarManagerFragment requestBarManagerFragment = (RequestBarManagerFragment) fragmentManager.findFragmentByTag(str);
        if (requestBarManagerFragment == null && (requestBarManagerFragment = (RequestBarManagerFragment) this.d.get(fragmentManager)) == null) {
            if (z) {
                return null;
            }
            for (Fragment fragment : fragmentManager.getFragments()) {
                if (fragment instanceof RequestBarManagerFragment) {
                    String tag = fragment.getTag();
                    if (tag == null) {
                        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                    } else if (tag.contains(".tag.notOnly.")) {
                        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                    }
                }
            }
            requestBarManagerFragment = new RequestBarManagerFragment();
            this.d.put(fragmentManager, requestBarManagerFragment);
            fragmentManager.beginTransaction().add(requestBarManagerFragment, str).commitAllowingStateLoss();
            this.c.obtainMessage(1, fragmentManager).sendToTarget();
        }
        if (!z) {
            return requestBarManagerFragment;
        }
        if (this.f.get(str) == null) {
            this.f.put(str, requestBarManagerFragment);
            fragmentManager.beginTransaction().remove(requestBarManagerFragment).commitAllowingStateLoss();
            this.c.obtainMessage(3, str).sendToTarget();
        }
        return null;
    }

    static l f() {
        return b.a;
    }

    private SupportRequestBarManagerFragment g(androidx.fragment.app.FragmentManager fragmentManager, String str) {
        return h(fragmentManager, str, false);
    }

    private SupportRequestBarManagerFragment h(androidx.fragment.app.FragmentManager fragmentManager, String str, boolean z) {
        SupportRequestBarManagerFragment supportRequestBarManagerFragment = (SupportRequestBarManagerFragment) fragmentManager.j0(str);
        if (supportRequestBarManagerFragment == null && (supportRequestBarManagerFragment = (SupportRequestBarManagerFragment) this.e.get(fragmentManager)) == null) {
            if (z) {
                return null;
            }
            for (androidx.fragment.app.Fragment fragment : fragmentManager.u0()) {
                if (fragment instanceof SupportRequestBarManagerFragment) {
                    String tag = fragment.getTag();
                    if (tag == null) {
                        fragmentManager.p().o(fragment).i();
                    } else if (tag.contains(".tag.notOnly.")) {
                        fragmentManager.p().o(fragment).i();
                    }
                }
            }
            supportRequestBarManagerFragment = new SupportRequestBarManagerFragment();
            this.e.put(fragmentManager, supportRequestBarManagerFragment);
            fragmentManager.p().d(supportRequestBarManagerFragment, str).i();
            this.c.obtainMessage(2, fragmentManager).sendToTarget();
        }
        if (!z) {
            return supportRequestBarManagerFragment;
        }
        if (this.g.get(str) == null) {
            this.g.put(str, supportRequestBarManagerFragment);
            fragmentManager.p().o(supportRequestBarManagerFragment).i();
            this.c.obtainMessage(4, str).sendToTarget();
        }
        return null;
    }

    public h b(Activity activity, boolean z) {
        a(activity, "activity is null");
        String str = this.a + activity.getClass().getName();
        if (!z) {
            str = str + System.identityHashCode(activity) + ".tag.notOnly.";
        }
        return activity instanceof FragmentActivity ? g(((FragmentActivity) activity).getSupportFragmentManager(), str).v(activity) : d(activity.getFragmentManager(), str).a(activity);
    }

    public h c(androidx.fragment.app.Fragment fragment, boolean z) {
        a(fragment, "fragment is null");
        a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof DialogFragment) {
            a(((DialogFragment) fragment).B(), "fragment.getDialog() is null");
        }
        String str = this.a + fragment.getClass().getName();
        if (!z) {
            str = str + System.identityHashCode(fragment) + ".tag.notOnly.";
        }
        return g(fragment.getChildFragmentManager(), str).v(fragment);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.d.remove((FragmentManager) message.obj);
            return true;
        }
        if (i == 2) {
            this.e.remove((androidx.fragment.app.FragmentManager) message.obj);
            return true;
        }
        if (i == 3) {
            this.f.remove((String) message.obj);
            return true;
        }
        if (i != 4) {
            return false;
        }
        this.g.remove((String) message.obj);
        return true;
    }

    private l() {
        this.a = h.class.getName() + FileUtils.FILE_EXTENSION_SEPARATOR;
        this.b = ".tag.notOnly.";
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
        this.c = new Handler(Looper.getMainLooper(), this);
    }
}
