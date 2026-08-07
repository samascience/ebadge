package com.tenmeter.smlibrary.listener;

import com.tenmeter.smlibrary.entity.SMGameUser;

/* JADX INFO: loaded from: classes3.dex */
public interface IUserInfoCallback {
    void onError(String str);

    void onSuccessFul(SMGameUser sMGameUser);
}
