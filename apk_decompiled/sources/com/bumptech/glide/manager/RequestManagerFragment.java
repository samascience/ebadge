package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import defpackage.jf2;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RequestManagerFragment extends Fragment {
    private final com.bumptech.glide.manager.a a;
    private final jf2 b;
    private final Set c;
    private com.bumptech.glide.f d;
    private RequestManagerFragment e;
    private Fragment f;

    private class a implements jf2 {
        a() {
        }

        @Override // defpackage.jf2
        public Set a() {
            Set<RequestManagerFragment> setB = RequestManagerFragment.this.b();
            HashSet hashSet = new HashSet(setB.size());
            for (RequestManagerFragment requestManagerFragment : setB) {
                if (requestManagerFragment.e() != null) {
                    hashSet.add(requestManagerFragment.e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        this(new com.bumptech.glide.manager.a());
    }

    private void a(RequestManagerFragment requestManagerFragment) {
        this.c.add(requestManagerFragment);
    }

    private Fragment d() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f;
    }

    private boolean g(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void h(Activity activity) {
        l();
        RequestManagerFragment requestManagerFragmentI = com.bumptech.glide.a.c(activity).k().i(activity);
        this.e = requestManagerFragmentI;
        if (equals(requestManagerFragmentI)) {
            return;
        }
        this.e.a(this);
    }

    private void i(RequestManagerFragment requestManagerFragment) {
        this.c.remove(requestManagerFragment);
    }

    private void l() {
        RequestManagerFragment requestManagerFragment = this.e;
        if (requestManagerFragment != null) {
            requestManagerFragment.i(this);
            this.e = null;
        }
    }

    Set b() {
        if (equals(this.e)) {
            return Collections.unmodifiableSet(this.c);
        }
        if (this.e == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (RequestManagerFragment requestManagerFragment : this.e.b()) {
            if (g(requestManagerFragment.getParentFragment())) {
                hashSet.add(requestManagerFragment);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    com.bumptech.glide.manager.a c() {
        return this.a;
    }

    public com.bumptech.glide.f e() {
        return this.d;
    }

    public jf2 f() {
        return this.b;
    }

    void j(Fragment fragment) {
        this.f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        h(fragment.getActivity());
    }

    public void k(com.bumptech.glide.f fVar) {
        this.d = fVar;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.c();
        l();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        l();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.a.e();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    RequestManagerFragment(com.bumptech.glide.manager.a aVar) {
        this.b = new a();
        this.c = new HashSet();
        this.a = aVar;
    }
}
