package com.jieli.jl_rcsp.task;

import android.content.Context;
import android.net.Uri;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.util.JLFileIOUtil;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class UriTransferTask extends TransferTask {
    public final Context g;
    public final String h;
    public final String i;

    public UriTransferTask(Context context, RcspOpImpl rcspOpImpl, String str, String str2, TransferTask.Param param) {
        super(rcspOpImpl, Constants.STR_EMPTY, param);
        setPath(context.getExternalCacheDir() + File.separator + str2);
        this.h = str;
        this.i = str2;
        this.g = context;
    }

    public final /* synthetic */ void l() {
        try {
            InputStream inputStreamOpenInputStream = this.g.getContentResolver().openInputStream(Uri.parse(this.h));
            JLFileIOUtil.isToFile(getPath(), inputStreamOpenInputStream);
            inputStreamOpenInputStream.close();
            if (isRun()) {
                return;
            }
            super.start();
        } catch (IOException e) {
            e.printStackTrace();
            onError(4097, "Failed to read file . uri = " + this.h);
        }
    }

    @Override // com.jieli.jl_rcsp.task.TransferTask
    public void release() {
        super.release();
        File file = new File(getPath());
        if (file.exists()) {
            file.delete();
        }
    }

    @Override // com.jieli.jl_rcsp.task.TransferTask, com.jieli.jl_rcsp.task.ITask
    public void start() {
        if (new File(getPath()).exists()) {
            super.start();
        } else {
            this.executor.execute(new Runnable() { // from class: ba3
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.l();
                }
            });
        }
    }
}
