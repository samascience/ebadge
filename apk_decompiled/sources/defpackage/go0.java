package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R$attr;
import com.luck.picture.lib.R$drawable;
import com.luck.picture.lib.R$id;
import com.luck.picture.lib.R$layout;
import com.luck.picture.lib.R$style;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class go0 extends PopupWindow {
    private final Context a;
    private final View b;
    private RecyclerView c;
    private v02 d;
    private boolean e = false;
    private ImageView f;
    private Drawable g;
    private Drawable h;
    private final int i;
    private final PictureSelectionConfig j;
    private final int k;
    private View l;

    public go0(Context context) {
        this.a = context;
        PictureSelectionConfig pictureSelectionConfigC = PictureSelectionConfig.c();
        this.j = pictureSelectionConfigC;
        this.i = pictureSelectionConfigC.a;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.picture_window_folder, (ViewGroup) null);
        this.b = viewInflate;
        setContentView(viewInflate);
        setWidth(-1);
        setHeight(-2);
        setAnimationStyle(R$style.PictureThemeWindowStyle);
        setFocusable(true);
        setOutsideTouchable(true);
        update();
        if (pictureSelectionConfigC.Y) {
            this.g = q30.e(context, R$drawable.picture_icon_wechat_up);
            this.h = q30.e(context, R$drawable.picture_icon_wechat_down);
        } else {
            int i = pictureSelectionConfigC.U0;
            if (i != 0) {
                this.g = q30.e(context, i);
            } else {
                this.g = cb.d(context, R$attr.picture_arrow_up_icon, R$drawable.picture_icon_arrow_up);
            }
            int i2 = pictureSelectionConfigC.V0;
            if (i2 != 0) {
                this.h = q30.e(context, i2);
            } else {
                this.h = cb.d(context, R$attr.picture_arrow_down_icon, R$drawable.picture_icon_arrow_down);
            }
        }
        this.k = (int) (((double) ll2.b(context)) * 0.6d);
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        dismiss();
    }

    public void c(List list) {
        this.d.i(this.i);
        this.d.d(list);
        this.c.getLayoutParams().height = list.size() > 8 ? this.k : -2;
    }

    public LocalMediaFolder d(int i) {
        if (this.d.e().size() <= 0 || i >= this.d.e().size()) {
            return null;
        }
        return (LocalMediaFolder) this.d.e().get(i);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.e) {
            return;
        }
        this.l.animate().alpha(0.0f).setDuration(50L).start();
        this.f.setImageDrawable(this.h);
        d6.b(this.f, false);
        this.e = true;
        super.dismiss();
        this.e = false;
    }

    public List e() {
        return this.d.e();
    }

    public void f() {
        this.l = this.b.findViewById(R$id.rootViewBg);
        this.d = new v02(this.j);
        RecyclerView recyclerView = (RecyclerView) this.b.findViewById(R$id.folder_list);
        this.c = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.a));
        this.c.setAdapter(this.d);
        this.b.findViewById(R$id.rootView);
        this.l.setOnClickListener(new View.OnClickListener() { // from class: fo0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.h(view);
            }
        });
    }

    public boolean g() {
        return this.d.e().size() == 0;
    }

    public void i(ImageView imageView) {
        this.f = imageView;
    }

    public void j(lu1 lu1Var) {
        this.d.j(lu1Var);
    }

    public void k(List list) {
        int i;
        try {
            List listE = this.d.e();
            int size = listE.size();
            int size2 = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                LocalMediaFolder localMediaFolder = (LocalMediaFolder) listE.get(i2);
                localMediaFolder.p(0);
                for (0; i < size2; i + 1) {
                    i = (localMediaFolder.h().equals(((LocalMedia) list.get(i)).p()) || localMediaFolder.a() == -1) ? 0 : i + 1;
                    localMediaFolder.p(1);
                    break;
                }
            }
            this.d.d(listE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        try {
            super.showAsDropDown(view);
            this.e = false;
            this.f.setImageDrawable(this.g);
            d6.b(this.f, true);
            this.l.animate().alpha(1.0f).setDuration(250L).setStartDelay(250L).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
