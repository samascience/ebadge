package com.jieli.jl_filebrowse.tool;

import android.os.Handler;
import com.jieli.jl_filebrowse.bean.FileStruct;
import com.jieli.jl_filebrowse.bean.SDCardBean;
import com.jieli.jl_filebrowse.interfaces.FileObserver;
import com.jieli.jl_rcsp.tool.callback.BaseCallbackManager;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FileObserverHelper extends BaseCallbackManager<FileObserver> implements FileObserver {
    public FileObserverHelper(Handler handler) {
        super(handler);
    }

    @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
    public void OnFlayCallback(final boolean z) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: qm0
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((FileObserver) obj).OnFlayCallback(z);
            }
        });
    }

    @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
    public void onFileReadFailed(final int i) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: om0
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((FileObserver) obj).onFileReadFailed(i);
            }
        });
    }

    @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
    public void onFileReadStart() {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: mm0
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((FileObserver) obj).onFileReadStart();
            }
        });
    }

    @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
    public void onFileReadStop(final boolean z) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: rm0
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((FileObserver) obj).onFileReadStop(z);
            }
        });
    }

    @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
    public void onFileReceiver(final List<FileStruct> list) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: pm0
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((FileObserver) obj).onFileReceiver(list);
            }
        });
    }

    @Override // com.jieli.jl_filebrowse.interfaces.FileObserver
    public void onSdCardStatusChange(final List<SDCardBean> list) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: nm0
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((FileObserver) obj).onSdCardStatusChange(list);
            }
        });
    }
}
