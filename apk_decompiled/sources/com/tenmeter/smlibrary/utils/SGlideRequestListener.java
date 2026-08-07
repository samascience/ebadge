package com.tenmeter.smlibrary.utils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import defpackage.if2;
import defpackage.j03;

/* JADX INFO: loaded from: classes3.dex */
public class SGlideRequestListener implements if2 {
    private ImageView.ScaleType mActualScaleType;
    private ImageView mImageView;
    private ImageView.ScaleType mPlaceScaleType;

    public SGlideRequestListener(ImageView imageView, ImageView.ScaleType scaleType, ImageView.ScaleType scaleType2) {
        this.mPlaceScaleType = scaleType;
        this.mActualScaleType = scaleType2;
        this.mImageView = imageView;
        imageView.setScaleType(scaleType);
    }

    @Override // defpackage.if2
    public boolean onLoadFailed(GlideException glideException, Object obj, j03 j03Var, boolean z) {
        this.mImageView.setScaleType(this.mPlaceScaleType);
        return false;
    }

    @Override // defpackage.if2
    public boolean onResourceReady(Drawable drawable, Object obj, j03 j03Var, DataSource dataSource, boolean z) {
        this.mImageView.setScaleType(this.mActualScaleType);
        return false;
    }
}
