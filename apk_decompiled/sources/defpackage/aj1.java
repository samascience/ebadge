package defpackage;

import com.tencent.open.SocialConstants;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class aj1 implements t51 {
    @Override // defpackage.t51
    public Object a(u51 u51Var, Type type, q51 q51Var) {
        Class clsA = t20.a(u51Var.c().p(SocialConstants.PARAM_TYPE).e());
        return clsA == null ? u51Var.toString() : q51Var.a(u51Var, clsA);
    }
}
