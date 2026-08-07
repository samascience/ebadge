package com.tenmeter.smlibrary.listener;

import com.tenmeter.smlibrary.entity.SMIconListParent;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IIconCallback {
    void onError(String str);

    void onSuccessFul(List<SMIconListParent> list);
}
