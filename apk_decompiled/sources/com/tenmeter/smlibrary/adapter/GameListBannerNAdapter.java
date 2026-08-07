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
import com.tenmeter.smlibrary.banner.adapter.BannerAdapter;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.entity.SMGameListBannerParent;
import com.tenmeter.smlibrary.utils.DisplayUtil;
import com.tenmeter.smlibrary.utils.SGlideRequestListener;
import com.tenmeter.smlibrary.widget.SMRoundedImageView;
import defpackage.ac0;
import defpackage.q30;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GameListBannerNAdapter extends BannerAdapter<SMGameListBannerParent, ViewHolder> {
    private Context context;
    private IGameListItemClick listener;

    public interface IGameListItemClick {
        void itemClick(SMGameInfo sMGameInfo);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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

    public GameListBannerNAdapter(Context context, IGameListItemClick iGameListItemClick, List<SMGameListBannerParent> list) {
        super(list);
        this.context = context;
        this.listener = iGameListItemClick;
    }

    @Override // com.tenmeter.smlibrary.banner.holder.IViewHolder
    public void onBindView(ViewHolder viewHolder, final SMGameListBannerParent sMGameListBannerParent, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewHolder.mBg.getLayoutParams();
        layoutParams.height = (int) ((((double) (DisplayUtil.getScreenWidth() - DisplayUtil.dp2px(44.0f))) / 637.0d) * 289.0d);
        viewHolder.mBg.setLayoutParams(layoutParams);
        viewHolder.mSubName.setText(sMGameListBannerParent.getBannerTitle());
        viewHolder.mName.setText(sMGameListBannerParent.getBannerName());
        e eVarR = a.u(this.context).r(sMGameListBannerParent.getBannerImage());
        Context context = this.context;
        int i3 = R.drawable.default_game;
        e eVar = (e) ((e) eVarR.V(q30.e(context, i3))).i(q30.e(this.context, i3));
        SMRoundedImageView sMRoundedImageView = viewHolder.mBg;
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_CROP;
        ((e) eVar.w0(new SGlideRequestListener(sMRoundedImageView, scaleType, scaleType)).f(ac0.d)).u0(viewHolder.mBg);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.adapter.GameListBannerNAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GameListBannerNAdapter.this.listener != null) {
                    GameListBannerNAdapter.this.listener.itemClick(sMGameListBannerParent.getGame());
                }
            }
        });
    }

    @Override // com.tenmeter.smlibrary.banner.holder.IViewHolder
    public ViewHolder onCreateHolder(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sm_sdk_game_list_banner, viewGroup, false);
        viewInflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new ViewHolder(viewInflate);
    }
}
