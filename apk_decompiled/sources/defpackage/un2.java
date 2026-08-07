package defpackage;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class un2 implements iz1, tg.a {
    private final Path a = new Path();
    private final String b;
    private final je1 c;
    private final tg d;
    private boolean e;
    private b63 f;

    public un2(je1 je1Var, a aVar, do2 do2Var) {
        this.b = do2Var.b();
        this.c = je1Var;
        tg tgVarA = do2Var.c().a();
        this.d = tgVarA;
        aVar.i(tgVarA);
        tgVarA.a(this);
    }

    private void e() {
        this.e = false;
        this.c.invalidateSelf();
    }

    @Override // tg.a
    public void a() {
        e();
    }

    @Override // defpackage.s20
    public void b(List list, List list2) {
        for (int i = 0; i < list.size(); i++) {
            s20 s20Var = (s20) list.get(i);
            if (s20Var instanceof b63) {
                b63 b63Var = (b63) s20Var;
                if (b63Var.j() == ShapeTrimPath.Type.Simultaneously) {
                    this.f = b63Var;
                    b63Var.e(this);
                }
            }
        }
    }

    @Override // defpackage.iz1
    public Path c() {
        if (this.e) {
            return this.a;
        }
        this.a.reset();
        this.a.set((Path) this.d.h());
        this.a.setFillType(Path.FillType.EVEN_ODD);
        ya3.b(this.a, this.f);
        this.e = true;
        return this.a;
    }
}
