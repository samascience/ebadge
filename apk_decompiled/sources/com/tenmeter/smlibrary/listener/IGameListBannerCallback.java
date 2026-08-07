package com.tenmeter.smlibrary.listener;

import com.tenmeter.smlibrary.entity.SMGameListBannerParent;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IGameListBannerCallback {
    void onError(String str);

    void onSuccessFul(List<SMGameListBannerParent> list);
}
