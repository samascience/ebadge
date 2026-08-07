package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class RadioGroupSelector extends LinearLayout {
    private RadioGroup a;
    private RadioButton b;
    private RadioButton c;
    RadioGroup.OnCheckedChangeListener d;

    public enum STATUS {
        LEFT,
        RIGHT
    }

    public RadioGroupSelector(Context context) {
        super(context);
    }

    private void b(Context context, AttributeSet attributeSet) {
        View viewInflate = View.inflate(context, R.layout.layout_radio_group_selector_view, this);
        this.a = (RadioGroup) viewInflate.findViewById(R.id.rad_group);
        this.b = (RadioButton) viewInflate.findViewById(R.id.rad_1);
        this.c = (RadioButton) viewInflate.findViewById(R.id.rad_2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RadioGroupSelector);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        if (indexCount > 0) {
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.b.setText(typedArrayObtainStyledAttributes.getString(index));
                } else if (index == 1) {
                    this.c.setText(typedArrayObtainStyledAttributes.getString(index));
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        this.a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: ea2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                this.a.c(radioGroup, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(RadioGroup radioGroup, int i) {
        RadioGroup.OnCheckedChangeListener onCheckedChangeListener = this.d;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(radioGroup, i);
        }
    }

    public void setCheckChangeListener(RadioGroup.OnCheckedChangeListener onCheckedChangeListener) {
        this.d = onCheckedChangeListener;
    }

    public void setStatus(STATUS status) {
        if (status == STATUS.LEFT) {
            this.b.setChecked(true);
        } else {
            this.c.setChecked(true);
        }
    }

    public RadioGroupSelector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public RadioGroupSelector(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
    }
}
