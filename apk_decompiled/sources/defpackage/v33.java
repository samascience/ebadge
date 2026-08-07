package defpackage;

import com.tencent.open.SocialConstants;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class v33 implements t51 {
    @Override // defpackage.t51
    public Object a(u51 u51Var, Type type, q51 q51Var) {
        Class clsC;
        if (u51Var.c().p(SocialConstants.PARAM_TYPE) != null && (clsC = t33.c(u51Var.c().p(SocialConstants.PARAM_TYPE).e())) != null) {
            return q51Var.a(u51Var, clsC);
        }
        return u51Var.toString();
    }
}
