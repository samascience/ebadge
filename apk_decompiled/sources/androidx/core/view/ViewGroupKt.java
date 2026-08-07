package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import defpackage.ar0;
import defpackage.k81;
import defpackage.rm2;
import defpackage.y53;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewGroupKt {

    public static final class a implements rm2 {
        final /* synthetic */ ViewGroup a;

        a(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // defpackage.rm2
        public Iterator iterator() {
            return ViewGroupKt.c(this.a);
        }
    }

    public static final class b implements Iterator, k81 {
        private int a;
        final /* synthetic */ ViewGroup b;

        b(ViewGroup viewGroup) {
            this.b = viewGroup;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public View next() {
            ViewGroup viewGroup = this.b;
            int i = this.a;
            this.a = i + 1;
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b.getChildCount();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup viewGroup = this.b;
            int i = this.a - 1;
            this.a = i;
            viewGroup.removeViewAt(i);
        }
    }

    public static final class c implements rm2 {
        final /* synthetic */ ViewGroup a;

        public c(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // defpackage.rm2
        public Iterator iterator() {
            return new y53(ViewGroupKt.a(this.a).iterator(), new ar0() { // from class: androidx.core.view.ViewGroupKt$descendants$1$1
                @Override // defpackage.ar0
                public final Iterator<View> invoke(View view) {
                    rm2 rm2VarA;
                    ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
                    if (viewGroup == null || (rm2VarA = ViewGroupKt.a(viewGroup)) == null) {
                        return null;
                    }
                    return rm2VarA.iterator();
                }
            });
        }
    }

    public static final rm2 a(ViewGroup viewGroup) {
        return new a(viewGroup);
    }

    public static final rm2 b(ViewGroup viewGroup) {
        return new c(viewGroup);
    }

    public static final Iterator c(ViewGroup viewGroup) {
        return new b(viewGroup);
    }
}
