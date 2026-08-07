package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import defpackage.be3;
import defpackage.m2;
import defpackage.n2;
import defpackage.t1;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerViewAccessibilityDelegate extends t1 {
    private final ItemDelegate mItemDelegate;
    final RecyclerView mRecyclerView;

    public static class ItemDelegate extends t1 {
        private Map<View, t1> mOriginalItemDelegates = new WeakHashMap();
        final RecyclerViewAccessibilityDelegate mRecyclerViewDelegate;

        public ItemDelegate(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            this.mRecyclerViewDelegate = recyclerViewAccessibilityDelegate;
        }

        @Override // defpackage.t1
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            t1 t1Var = this.mOriginalItemDelegates.get(view);
            return t1Var != null ? t1Var.dispatchPopulateAccessibilityEvent(view, accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // defpackage.t1
        public n2 getAccessibilityNodeProvider(View view) {
            t1 t1Var = this.mOriginalItemDelegates.get(view);
            return t1Var != null ? t1Var.getAccessibilityNodeProvider(view) : super.getAccessibilityNodeProvider(view);
        }

        t1 getAndRemoveOriginalDelegateForItem(View view) {
            return this.mOriginalItemDelegates.remove(view);
        }

        @Override // defpackage.t1
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            t1 t1Var = this.mOriginalItemDelegates.get(view);
            if (t1Var != null) {
                t1Var.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // defpackage.t1
        public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
            if (this.mRecyclerViewDelegate.shouldIgnore() || this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) {
                super.onInitializeAccessibilityNodeInfo(view, m2Var);
                return;
            }
            this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, m2Var);
            t1 t1Var = this.mOriginalItemDelegates.get(view);
            if (t1Var != null) {
                t1Var.onInitializeAccessibilityNodeInfo(view, m2Var);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, m2Var);
            }
        }

        @Override // defpackage.t1
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            t1 t1Var = this.mOriginalItemDelegates.get(view);
            if (t1Var != null) {
                t1Var.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // defpackage.t1
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            t1 t1Var = this.mOriginalItemDelegates.get(viewGroup);
            return t1Var != null ? t1Var.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // defpackage.t1
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (this.mRecyclerViewDelegate.shouldIgnore() || this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) {
                return super.performAccessibilityAction(view, i, bundle);
            }
            t1 t1Var = this.mOriginalItemDelegates.get(view);
            if (t1Var != null) {
                if (t1Var.performAccessibilityAction(view, i, bundle)) {
                    return true;
                }
            } else if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            return this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, i, bundle);
        }

        void saveOriginalDelegate(View view) {
            t1 t1VarM = be3.m(view);
            if (t1VarM == null || t1VarM == this) {
                return;
            }
            this.mOriginalItemDelegates.put(view, t1VarM);
        }

        @Override // defpackage.t1
        public void sendAccessibilityEvent(View view, int i) {
            t1 t1Var = this.mOriginalItemDelegates.get(view);
            if (t1Var != null) {
                t1Var.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        }

        @Override // defpackage.t1
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            t1 t1Var = this.mOriginalItemDelegates.get(view);
            if (t1Var != null) {
                t1Var.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        t1 itemDelegate = getItemDelegate();
        if (itemDelegate == null || !(itemDelegate instanceof ItemDelegate)) {
            this.mItemDelegate = new ItemDelegate(this);
        } else {
            this.mItemDelegate = (ItemDelegate) itemDelegate;
        }
    }

    public t1 getItemDelegate() {
        return this.mItemDelegate;
    }

    @Override // defpackage.t1
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || shouldIgnore()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    @Override // defpackage.t1
    public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
        super.onInitializeAccessibilityNodeInfo(view, m2Var);
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return;
        }
        this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(m2Var);
    }

    @Override // defpackage.t1
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return false;
        }
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(i, bundle);
    }

    boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }
}
