package defpackage;

import android.os.Bundle;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

/* JADX INFO: loaded from: classes.dex */
public class h52 extends RecyclerViewAccessibilityDelegate {
    final RecyclerView a;
    final t1 b;
    final t1 c;

    class a extends t1 {
        a() {
        }

        @Override // defpackage.t1
        public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
            Preference preferenceF;
            h52.this.b.onInitializeAccessibilityNodeInfo(view, m2Var);
            int childAdapterPosition = h52.this.a.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = h52.this.a.getAdapter();
            if ((adapter instanceof b) && (preferenceF = ((b) adapter).f(childAdapterPosition)) != null) {
                preferenceF.O(m2Var);
            }
        }

        @Override // defpackage.t1
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return h52.this.b.performAccessibilityAction(view, i, bundle);
        }
    }

    public h52(RecyclerView recyclerView) {
        super(recyclerView);
        this.b = super.getItemDelegate();
        this.c = new a();
        this.a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
    public t1 getItemDelegate() {
        return this.c;
    }
}
