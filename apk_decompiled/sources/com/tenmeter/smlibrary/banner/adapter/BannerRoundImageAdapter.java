package com.tenmeter.smlibrary.banner.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.tenmeter.smlibrary.banner.holder.BannerImageHolder;
import com.tenmeter.smlibrary.widget.SMRoundedImageView;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BannerRoundImageAdapter<T> extends BannerAdapter<T, BannerImageHolder> {
    public BannerRoundImageAdapter(List<T> list) {
        super(list);
    }

    @Override // com.tenmeter.smlibrary.banner.holder.IViewHolder
    public BannerImageHolder onCreateHolder(ViewGroup viewGroup, int i) {
        SMRoundedImageView sMRoundedImageView = new SMRoundedImageView(viewGroup.getContext());
        sMRoundedImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        sMRoundedImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerImageHolder(sMRoundedImageView);
    }
}
