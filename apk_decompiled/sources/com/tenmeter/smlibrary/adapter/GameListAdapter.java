package com.tenmeter.smlibrary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.a;
import com.bumptech.glide.e;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.utils.DisplayUtil;
import com.tenmeter.smlibrary.utils.GlideRoundTransform;
import com.tenmeter.smlibrary.utils.SGlideRequestListener;
import defpackage.ac0;
import defpackage.q30;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GameListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<SMGameInfo> data;
    private IGameListItemClick listener;

    public interface IGameListItemClick {
        void itemClick(SMGameInfo sMGameInfo);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public SMGameInfo info;
        public final ImageView mBg;
        public final TextView mName;
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            this.mView = view;
            this.mName = (TextView) this.itemView.findViewById(R.id.tv_name);
            this.mBg = (ImageView) this.itemView.findViewById(R.id.iv_bg);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public String toString() {
            return "ViewHolder{mView=" + this.mView + ", itemId=" + this.mName + ", itemName=" + this.mBg + '}';
        }
    }

    public GameListAdapter(Context context, List<SMGameInfo> list, IGameListItemClick iGameListItemClick) {
        this.context = context;
        this.data = list;
        this.listener = iGameListItemClick;
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
        viewHolder.mName.setText(this.data.get(i).getGname());
        e eVarR = a.u(this.context).r(sMGameInfo.getBackground());
        Context context = this.context;
        int i2 = R.drawable.default_game;
        ((e) ((e) ((e) ((e) eVarR.V(q30.e(context, i2))).i(q30.e(this.context, i2))).w0(new SGlideRequestListener(viewHolder.mBg, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.FIT_XY)).e0(new GlideRoundTransform(DisplayUtil.dp2px(8.0f), 0, GlideRoundTransform.CornerType.ALL))).f(ac0.d)).u0(viewHolder.mBg);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.adapter.GameListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GameListAdapter.this.listener != null) {
                    GameListAdapter.this.listener.itemClick(sMGameInfo);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sm_sdk_game_list, viewGroup, false));
    }
}
