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
import com.tenmeter.smlibrary.entity.SMIconListParent;
import com.tenmeter.smlibrary.utils.SGlideRequestListener;
import defpackage.ac0;
import defpackage.q30;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class IconListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<SMIconListParent> data;
    private IGameListItemClick listener;

    public interface IGameListItemClick {
        void itemClick(SMIconListParent sMIconListParent);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public SMIconListParent info;
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

    public IconListAdapter(Context context, List<SMIconListParent> list, IGameListItemClick iGameListItemClick) {
        this.context = context;
        this.data = list;
        this.listener = iGameListItemClick;
    }

    public void clear() {
        List<SMIconListParent> list = this.data;
        if (list != null) {
            list.clear();
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<SMIconListParent> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setData(List<SMIconListParent> list) {
        List<SMIconListParent> list2 = this.data;
        if (list2 != null) {
            list2.clear();
        }
        this.data.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final SMIconListParent sMIconListParent = this.data.get(i);
        viewHolder.info = sMIconListParent;
        viewHolder.mName.setText(this.data.get(i).getIconName());
        e eVarR = a.u(this.context).r(sMIconListParent.getIconUrl());
        Context context = this.context;
        int i2 = R.drawable.default_game;
        ((e) ((e) ((e) eVarR.V(q30.e(context, i2))).i(q30.e(this.context, i2))).w0(new SGlideRequestListener(viewHolder.mBg, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.FIT_XY)).f(ac0.d)).u0(viewHolder.mBg);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.adapter.IconListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (IconListAdapter.this.listener != null) {
                    IconListAdapter.this.listener.itemClick(sMIconListParent);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sm_sdk_icon_list, viewGroup, false));
    }
}
