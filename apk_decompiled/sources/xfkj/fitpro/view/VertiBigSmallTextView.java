package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.d;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import defpackage.pv2;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class VertiBigSmallTextView extends LinearLayout {
    private TextView a;
    private TextView b;
    private TextView c;
    private ImageView d;

    public VertiBigSmallTextView(Context context) {
        super(context);
    }

    private void a(Context context, AttributeSet attributeSet) {
        View viewInflate = View.inflate(context, R.layout.layout_vertical_textview, this);
        this.a = (TextView) viewInflate.findViewById(R.id.tv_big);
        this.b = (TextView) viewInflate.findViewById(R.id.tv_small);
        this.c = (TextView) viewInflate.findViewById(R.id.tv_label);
        this.d = (ImageView) viewInflate.findViewById(R.id.img_label_top);
        View viewFindViewById = viewInflate.findViewById(R.id.space);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.VerticalBigSmallTextView);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = Constants.STR_EMPTY;
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == 3) {
                this.a.setText(typedArrayObtainStyledAttributes.getString(index));
            } else if (index == 6) {
                this.c.setText(typedArrayObtainStyledAttributes.getString(index));
            } else if (index == 10) {
                this.b.setText(typedArrayObtainStyledAttributes.getString(index));
            } else if (index == 2) {
                this.a.setTextSize(d.f(typedArrayObtainStyledAttributes.getDimension(index, 24.0f)));
            } else if (index == 5) {
                this.c.setTextSize(d.f(typedArrayObtainStyledAttributes.getDimension(index, 24.0f)));
            } else if (index == 9) {
                this.b.setTextSize(d.f(typedArrayObtainStyledAttributes.getDimension(index, 12.0f)));
            } else if (index == 4) {
                this.c.setTextColor(typedArrayObtainStyledAttributes.getColor(index, -16777216));
            } else if (index == 0) {
                this.a.setTextColor(typedArrayObtainStyledAttributes.getColor(index, -16777216));
            } else if (index == 8) {
                this.b.setTextColor(typedArrayObtainStyledAttributes.getColor(index, -16777216));
            } else if (index == 11) {
                int integer = typedArrayObtainStyledAttributes.getInteger(index, 1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
                layoutParams.setMargins(0, integer, 0, 0);
                viewFindViewById.setLayoutParams(layoutParams);
            } else if (index == 7) {
                this.d.setImageResource(typedArrayObtainStyledAttributes.getResourceId(7, R.mipmap.ic_launcher));
            } else if (index == 1) {
                string = typedArrayObtainStyledAttributes.getString(1);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        if (pv2.h(string)) {
            return;
        }
        this.a.setTypeface(Typeface.createFromAsset(context.getAssets(), string));
    }

    public String getTvBigText() {
        return this.a.getText().toString();
    }

    public String getTvLabelText() {
        return this.c.getText().toString();
    }

    public String getTvSmallText() {
        return this.b.getText().toString();
    }

    public void setBigFontText(String str) {
        this.a.setText(str);
    }

    public void setSmallFontText(String str) {
        this.b.setText(str);
    }

    public void setTvLabelText(String str) {
        this.c.setText(str);
    }

    public VertiBigSmallTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public VertiBigSmallTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }
}
