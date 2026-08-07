package com.tenmeter.smlibrary.listener;

import com.tenmeter.smlibrary.entity.SMGameInfo;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IGameListCallback {
    void onError(String str);

    void onSuccessFul(List<SMGameInfo> list);
}
