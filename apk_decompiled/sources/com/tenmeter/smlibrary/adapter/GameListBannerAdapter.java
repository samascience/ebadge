package com.tenmeter.smlibrary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.a;
import com.bumptech.glide.e;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.entity.SMGameListBannerParent;
import com.tenmeter.smlibrary.utils.DisplayUtil;
import com.tenmeter.smlibrary.utils.SGlideRequestListener;
import com.tenmeter.smlibrary.widget.SMRoundedImageView;
import defpackage.ac0;
import defpackage.q30;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GameListBannerAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<SMGameListBannerParent> data;
    private IGameListItemClick listener;

    public interface IGameListItemClick {
        void itemClick(SMGameInfo sMGameInfo);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public SMGameInfo info;
        public final SMRoundedImageView mBg;
        public final TextView mName;
        public final TextView mSubName;
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            this.mView = view;
            this.mSubName = (TextView) this.itemView.findViewById(R.id.tv_sub_title);
            this.mName = (TextView) this.itemView.findViewById(R.id.tv_title);
            this.mBg = (SMRoundedImageView) this.itemView.findViewById(R.id.iv_bg);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public String toString() {
            return "ViewHolder{mView=" + this.mView + ", itemId=" + this.mName + ", itemName=" + this.mBg + '}';
        }
    }

    public GameListBannerAdapter(Context context, List<SMGameListBannerParent> list, IGameListItemClick iGameListItemClick) {
        this.context = context;
        this.data = list;
        this.listener = iGameListItemClick;
    }

    public void clear() {
        List<SMGameListBannerParent> list = this.data;
        if (list != null) {
            list.clear();
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<SMGameListBannerParent> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setData(List<SMGameListBannerParent> list) {
        List<SMGameListBannerParent> list2 = this.data;
        if (list2 != null) {
            list2.clear();
        }
        this.data.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final SMGameListBannerParent sMGameListBannerParent = this.data.get(i);
        if (viewHolder.getAdapterPosition() == 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtil.getScreenWidth() - DisplayUtil.dp2px(46.0f), -1);
            layoutParams.setMargins(DisplayUtil.dp2px(16.0f), 0, DisplayUtil.dp2px(16.0f), 0);
            viewHolder.itemView.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(DisplayUtil.getScreenWidth() - DisplayUtil.dp2px(46.0f), -1);
            layoutParams2.setMargins(0, 0, DisplayUtil.dp2px(16.0f), 0);
            viewHolder.itemView.setLayoutParams(layoutParams2);
        }
        viewHolder.mSubName.setText(sMGameListBannerParent.getBannerTitle());
        viewHolder.mName.setText(sMGameListBannerParent.getBannerName());
        e eVarR = a.u(this.context).r(sMGameListBannerParent.getBannerImage());
        Context context = this.context;
        int i2 = R.drawable.default_game;
        e eVar = (e) ((e) eVarR.V(q30.e(context, i2))).i(q30.e(this.context, i2));
        SMRoundedImageView sMRoundedImageView = viewHolder.mBg;
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_CROP;
        ((e) eVar.w0(new SGlideRequestListener(sMRoundedImageView, scaleType, scaleType)).f(ac0.d)).u0(viewHolder.mBg);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.adapter.GameListBannerAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GameListBannerAdapter.this.listener != null) {
                    GameListBannerAdapter.this.listener.itemClick(sMGameListBannerParent.getGame());
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sm_sdk_game_list_banner, viewGroup, false));
    }
}
