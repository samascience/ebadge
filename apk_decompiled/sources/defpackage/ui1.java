package defpackage;

import android.graphics.Path;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class ui1 implements iz1, jv0 {
    private final String d;
    private final MergePaths f;
    private final Path a = new Path();
    private final Path b = new Path();
    private final Path c = new Path();
    private final List e = new ArrayList();

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.Merge.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MergePaths.MergePathsMode.Add.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MergePaths.MergePathsMode.Subtract.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MergePaths.MergePathsMode.Intersect.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[MergePaths.MergePathsMode.ExcludeIntersections.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public ui1(MergePaths mergePaths) {
        this.d = mergePaths.c();
        this.f = mergePaths;
    }

    private void a() {
        for (int i = 0; i < this.e.size(); i++) {
            this.c.addPath(((iz1) this.e.get(i)).c());
        }
    }

    private void f(Path.Op op) {
        this.b.reset();
        this.a.reset();
        for (int size = this.e.size() - 1; size >= 1; size--) {
            iz1 iz1Var = (iz1) this.e.get(size);
            if (iz1Var instanceof u20) {
                u20 u20Var = (u20) iz1Var;
                List listJ = u20Var.j();
                for (int size2 = listJ.size() - 1; size2 >= 0; size2--) {
                    Path pathC = ((iz1) listJ.get(size2)).c();
                    pathC.transform(u20Var.k());
                    this.b.addPath(pathC);
                }
            } else {
                this.b.addPath(iz1Var.c());
            }
        }
        iz1 iz1Var2 = (iz1) this.e.get(0);
        if (iz1Var2 instanceof u20) {
            u20 u20Var2 = (u20) iz1Var2;
            List listJ2 = u20Var2.j();
            for (int i = 0; i < listJ2.size(); i++) {
                Path pathC2 = ((iz1) listJ2.get(i)).c();
                pathC2.transform(u20Var2.k());
                this.a.addPath(pathC2);
            }
        } else {
            this.a.set(iz1Var2.c());
        }
        this.c.op(this.a, this.b, op);
    }

    @Override // defpackage.s20
    public void b(List list, List list2) {
        for (int i = 0; i < this.e.size(); i++) {
            ((iz1) this.e.get(i)).b(list, list2);
        }
    }

    @Override // defpackage.iz1
    public Path c() {
        this.c.reset();
        int i = a.a[this.f.b().ordinal()];
        if (i == 1) {
            a();
        } else if (i == 2) {
            f(Path.Op.UNION);
        } else if (i == 3) {
            f(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            f(Path.Op.INTERSECT);
        } else if (i == 5) {
            f(Path.Op.XOR);
        }
        return this.c;
    }

    @Override // defpackage.jv0
    public void e(ListIterator listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            s20 s20Var = (s20) listIterator.previous();
            if (s20Var instanceof iz1) {
                this.e.add((iz1) s20Var);
                listIterator.remove();
            }
        }
    }
}
