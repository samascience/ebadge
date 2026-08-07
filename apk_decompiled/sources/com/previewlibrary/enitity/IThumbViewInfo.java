package com.previewlibrary.enitity;

import android.graphics.Rect;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface IThumbViewInfo extends Parcelable {
    Rect getBounds();

    String getUrl();

    String getVideoUrl();
}
