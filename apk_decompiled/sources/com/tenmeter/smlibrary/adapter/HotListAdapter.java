package com.tenmeter.smlibrary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.a;
import com.bumptech.glide.e;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.utils.DisplayUtil;
import com.tenmeter.smlibrary.utils.SGlideRequestListener;
import defpackage.ac0;
import defpackage.q30;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class HotListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<SMGameInfo> data;
    private int imgWidth;
    private IGameListItemClick listener;

    public interface IGameListItemClick {
        void itemClick(SMGameInfo sMGameInfo);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public SMGameInfo info;
        public final ImageView mBg;
        public final TextView mTitle;
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            this.mView = view;
            this.mTitle = (TextView) this.itemView.findViewById(R.id.tv_title);
            this.mBg = (ImageView) this.itemView.findViewById(R.id.iv_bg);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public String toString() {
            return "ViewHolder{mView=" + this.mView + ", itemId=" + this.mTitle + ", itemName=" + this.mBg + '}';
        }
    }

    public HotListAdapter(Context context, List<SMGameInfo> list, IGameListItemClick iGameListItemClick, int i) {
        this.context = context;
        this.data = list;
        this.listener = iGameListItemClick;
        this.imgWidth = i;
    }

    public void clear() {
        List<SMGameInfo> list = this.data;
        if (list != null) {
            list.clear();
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<SMGameInfo> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setData(List<SMGameInfo> list) {
        List<SMGameInfo> list2 = this.data;
        if (list2 != null) {
            list2.clear();
        }
        this.data.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final SMGameInfo sMGameInfo = this.data.get(i);
        viewHolder.info = sMGameInfo;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewHolder.mBg.getLayoutParams();
        int i2 = this.imgWidth;
        layoutParams.width = i2;
        layoutParams.height = (int) ((((double) i2) / 320.0d) * 194.0d);
        viewHolder.mBg.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) viewHolder.mTitle.getLayoutParams();
        layoutParams2.width = this.imgWidth;
        viewHolder.mTitle.setLayoutParams(layoutParams2);
        viewHolder.mTitle.setText(sMGameInfo.getGname());
        RecyclerView.LayoutParams layoutParams3 = (RecyclerView.LayoutParams) viewHolder.itemView.getLayoutParams();
        if (i == 0) {
            ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = DisplayUtil.dp2px(0.0f);
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = DisplayUtil.dp2px(11.0f);
        }
        if (i == getItemCount() - 1) {
            ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin = DisplayUtil.dp2px(22.0f);
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin = DisplayUtil.dp2px(0.0f);
        }
        viewHolder.itemView.setLayoutParams(layoutParams3);
        e eVarR = a.u(this.context).r(sMGameInfo.getBackground());
        Context context = this.context;
        int i3 = R.drawable.default_game;
        ((e) ((e) ((e) eVarR.V(q30.e(context, i3))).i(q30.e(this.context, i3))).w0(new SGlideRequestListener(viewHolder.mBg, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.FIT_XY)).f(ac0.d)).u0(viewHolder.mBg);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.adapter.HotListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotListAdapter.this.listener != null) {
                    HotListAdapter.this.listener.itemClick(sMGameInfo);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sm_sdk_hot_game_list, viewGroup, false));
    }
}
