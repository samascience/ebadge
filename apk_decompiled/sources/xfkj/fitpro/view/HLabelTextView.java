package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.d;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class HLabelTextView extends LinearLayout {
    private PolygonView a;
    private View b;
    private TextView c;

    public HLabelTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet) {
        View viewInflate = View.inflate(context, R.layout.layout_hlabel_textview, this);
        this.a = (PolygonView) viewInflate.findViewById(R.id.dot);
        this.b = viewInflate.findViewById(R.id.space);
        this.c = (TextView) viewInflate.findViewById(R.id.tv_content);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.HLabelTextView);
        if (typedArrayObtainStyledAttributes != null) {
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == 7) {
                    this.c.setText(typedArrayObtainStyledAttributes.getString(index));
                } else if (index == 8) {
                    this.c.setTextColor(typedArrayObtainStyledAttributes.getColor(index, -16777216));
                } else if (index == 9) {
                    this.c.setTextSize(d.f(typedArrayObtainStyledAttributes.getDimension(index, 20.0f)));
                } else if (index == 1) {
                    this.a.setFillColor(typedArrayObtainStyledAttributes.getColor(index, -16777216));
                } else if (index == 2) {
                    this.a.setRadius(typedArrayObtainStyledAttributes.getInteger(index, 50));
                } else if (index == 6) {
                    this.b.setLayoutParams(new LinearLayout.LayoutParams(typedArrayObtainStyledAttributes.getInteger(index, 10), 1));
                } else if (index == 0) {
                    this.a.setRect(typedArrayObtainStyledAttributes.getBoolean(index, false));
                } else if (index == 4) {
                    this.a.setTextColor(typedArrayObtainStyledAttributes.getColor(index, -16777216));
                } else if (index == 3) {
                    this.a.setTextContent(typedArrayObtainStyledAttributes.getString(index));
                } else if (index == 5) {
                    this.a.setTextSize(typedArrayObtainStyledAttributes.getDimension(index, 10.0f));
                }
            }
        }
    }

    public TextView getTvContent() {
        return this.c;
    }

    public HLabelTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }
}
