package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R$attr;
import com.luck.picture.lib.R$drawable;
import com.luck.picture.lib.R$id;
import com.luck.picture.lib.R$layout;
import com.luck.picture.lib.R$string;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class v02 extends RecyclerView.Adapter {
    private List a = new ArrayList();
    private int b;
    private lu1 c;

    static class a extends RecyclerView.ViewHolder {
        ImageView a;
        TextView b;
        TextView c;

        public a(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R$id.first_image);
            this.b = (TextView) view.findViewById(R$id.tv_folder_name);
            this.c = (TextView) view.findViewById(R$id.tv_sign);
            PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
            this.c.setBackground(cb.d(view.getContext(), R$attr.picture_folder_checked_dot, R$drawable.picture_orange_oval));
            int iB = cb.b(view.getContext(), R$attr.picture_folder_textColor);
            if (iB != 0) {
                this.b.setTextColor(iB);
            }
            float fE = cb.e(view.getContext(), R$attr.picture_folder_textSize);
            if (fE > 0.0f) {
                this.b.setTextSize(0, fE);
            }
        }
    }

    public v02(PictureSelectionConfig pictureSelectionConfig) {
        this.b = pictureSelectionConfig.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(LocalMediaFolder localMediaFolder, int i, View view) {
        if (this.c != null) {
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((LocalMediaFolder) this.a.get(i2)).o(false);
            }
            localMediaFolder.o(true);
            notifyDataSetChanged();
            this.c.c(i, localMediaFolder.j(), localMediaFolder.a(), localMediaFolder.h(), localMediaFolder.d());
        }
    }

    public void d(List list) {
        this.a = list;
        notifyDataSetChanged();
    }

    public List e() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, final int i) {
        final LocalMediaFolder localMediaFolder = (LocalMediaFolder) this.a.get(i);
        String strH = localMediaFolder.h();
        int iG = localMediaFolder.g();
        String strE = localMediaFolder.e();
        boolean zK = localMediaFolder.k();
        aVar.c.setVisibility(localMediaFolder.b() > 0 ? 0 : 4);
        aVar.itemView.setSelected(zK);
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        if (this.b == a22.t()) {
            aVar.a.setImageResource(R$drawable.picture_audio_placeholder);
        } else {
            k01 k01Var = PictureSelectionConfig.w1;
            if (k01Var != null) {
                k01Var.b(aVar.itemView.getContext(), strE, aVar.a);
            }
        }
        Context context = aVar.itemView.getContext();
        if (localMediaFolder.i() != -1) {
            strH = localMediaFolder.i() == a22.t() ? context.getString(R$string.picture_all_audio) : context.getString(R$string.picture_camera_roll);
        }
        aVar.b.setText(context.getString(R$string.picture_camera_roll_num, strH, Integer.valueOf(iG)));
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: u02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.f(localMediaFolder, i, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.picture_album_folder_item, viewGroup, false));
    }

    public void i(int i) {
        this.b = i;
    }

    public void j(lu1 lu1Var) {
        this.c = lu1Var;
    }
}
