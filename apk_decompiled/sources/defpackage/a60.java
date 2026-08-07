package defpackage;

import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.DataInfo;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.tool.datahandles.DataHandlerModify;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a60 implements Runnable {
    public final /* synthetic */ RcspCommandCallback a;
    public final /* synthetic */ DataInfo b;
    public final /* synthetic */ CommandBase c;

    public /* synthetic */ a60(RcspCommandCallback rcspCommandCallback, DataInfo dataInfo, CommandBase commandBase) {
        this.a = rcspCommandCallback;
        this.b = dataInfo;
        this.c = commandBase;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DataHandlerModify.a(this.a, this.b, this.c);
    }
}
