package com.tenmeter.smlibrary.listener;

import com.tenmeter.smlibrary.entity.SMADBean;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IADCallback {
    void onError(String str);

    void onSuccessFul(List<SMADBean> list);
}
