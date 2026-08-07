package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import defpackage.jf2;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SupportRequestManagerFragment extends Fragment {
    private final com.bumptech.glide.manager.a a;
    private final jf2 b;
    private final Set c;
    private SupportRequestManagerFragment d;
    private com.bumptech.glide.f e;
    private Fragment f;

    private class a implements jf2 {
        a() {
        }

        @Override // defpackage.jf2
        public Set a() {
            Set<SupportRequestManagerFragment> setW = SupportRequestManagerFragment.this.w();
            HashSet hashSet = new HashSet(setW.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : setW) {
                if (supportRequestManagerFragment.z() != null) {
                    hashSet.add(supportRequestManagerFragment.z());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new com.bumptech.glide.manager.a());
    }

    private static FragmentManager B(Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private boolean C(Fragment fragment) {
        Fragment fragmentY = y();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(fragmentY)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void D(Context context, FragmentManager fragmentManager) {
        H();
        SupportRequestManagerFragment supportRequestManagerFragmentK = com.bumptech.glide.a.c(context).k().k(fragmentManager);
        this.d = supportRequestManagerFragmentK;
        if (equals(supportRequestManagerFragmentK)) {
            return;
        }
        this.d.v(this);
    }

    private void E(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.c.remove(supportRequestManagerFragment);
    }

    private void H() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.d;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.E(this);
            this.d = null;
        }
    }

    private void v(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.c.add(supportRequestManagerFragment);
    }

    private Fragment y() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f;
    }

    public jf2 A() {
        return this.b;
    }

    void F(Fragment fragment) {
        FragmentManager fragmentManagerB;
        this.f = fragment;
        if (fragment == null || fragment.getContext() == null || (fragmentManagerB = B(fragment)) == null) {
            return;
        }
        D(fragment.getContext(), fragmentManagerB);
    }

    public void G(com.bumptech.glide.f fVar) {
        this.e = fVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager fragmentManagerB = B(this);
        if (fragmentManagerB == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
            }
        } else {
            try {
                D(getContext(), fragmentManagerB);
            } catch (IllegalStateException e) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.c();
        H();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f = null;
        H();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.a.e();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + y() + "}";
    }

    Set w() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.d;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.c);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.d.w()) {
            if (C(supportRequestManagerFragment2.y())) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    com.bumptech.glide.manager.a x() {
        return this.a;
    }

    public com.bumptech.glide.f z() {
        return this.e;
    }

    public SupportRequestManagerFragment(com.bumptech.glide.manager.a aVar) {
        this.b = new a();
        this.c = new HashSet();
        this.a = aVar;
    }
}
