package com.tenmeter.smlibrary.listener;

import com.tenmeter.smlibrary.entity.SMGameListParent;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IGameListForTypeCallback {
    void onError(String str);

    void onSuccessFul(List<SMGameListParent> list);
}
