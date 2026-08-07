package xfkj.fitpro.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes4.dex */
public class RxRunTextView extends AppCompatTextView {
    public RxRunTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }

    public RxRunTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RxRunTextView(Context context) {
        super(context);
    }
}
