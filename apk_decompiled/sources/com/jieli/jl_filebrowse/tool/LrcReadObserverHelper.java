package com.jieli.jl_filebrowse.tool;

import android.os.Handler;
import com.jieli.jl_filebrowse.interfaces.lrc.LrcReadObserver;
import com.jieli.jl_rcsp.tool.callback.BaseCallbackManager;

/* JADX INFO: loaded from: classes3.dex */
public class LrcReadObserverHelper extends BaseCallbackManager<LrcReadObserver> implements LrcReadObserver {
    public LrcReadObserverHelper(Handler handler) {
        super(handler);
    }

    @Override // com.jieli.jl_filebrowse.interfaces.lrc.LrcReadObserver
    public void onLrcReadFailed(final int i) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: ve1
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((LrcReadObserver) obj).onLrcReadFailed(i);
            }
        });
    }

    @Override // com.jieli.jl_filebrowse.interfaces.lrc.LrcReadObserver
    public void onLrcReadStart() {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: te1
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((LrcReadObserver) obj).onLrcReadStart();
            }
        });
    }

    @Override // com.jieli.jl_filebrowse.interfaces.lrc.LrcReadObserver
    public void onLrcReadStop(final String str) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: ue1
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((LrcReadObserver) obj).onLrcReadStop(str);
            }
        });
    }
}
