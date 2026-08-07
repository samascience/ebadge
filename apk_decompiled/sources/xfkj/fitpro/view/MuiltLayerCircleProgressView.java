package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.d;
import com.legend.smartwatch.electronicbadge.android.R;
import com.seeker.luckychart.animation.ChartCoordinateportAnimator;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class MuiltLayerCircleProgressView extends FrameLayout {
    CircleProgressView a;
    CircleDoubleProgressView b;

    public MuiltLayerCircleProgressView(Context context) {
        super(context);
    }

    private int a(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    private void b(Context context, AttributeSet attributeSet) {
        View viewInflate = View.inflate(context, R.layout.layout_muilt_layer_circle_pb, this);
        this.a = (CircleProgressView) viewInflate.findViewById(R.id.circle1);
        this.b = (CircleDoubleProgressView) viewInflate.findViewById(R.id.circle2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MuiltLayerCircleProgressView);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        int integer = 200;
        int integer2 = 200;
        int integer3 = 30;
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == 0) {
                this.a.setNormalColor(typedArrayObtainStyledAttributes.getColor(index, -3618616));
            } else if (index == 1) {
                this.a.setProgressColor(typedArrayObtainStyledAttributes.getColor(index, -3618616));
            } else if (index == 2) {
                this.b.setNormal1Color(typedArrayObtainStyledAttributes.getColor(index, -3618616));
            } else if (index == 3) {
                this.b.setProgress1Color(typedArrayObtainStyledAttributes.getColor(index, -3618616));
            } else if (index == 4) {
                this.b.setNormal2Color(typedArrayObtainStyledAttributes.getColor(index, -3618616));
            } else if (index == 5) {
                this.b.setProgress2Color(typedArrayObtainStyledAttributes.getColor(index, -3618616));
            } else if (index == 16) {
                float dimension = typedArrayObtainStyledAttributes.getDimension(index, 12.0f);
                this.a.setProgressStrokeWidth(dimension);
                this.b.setProgressStrokeWidth(dimension);
            } else if (index == 15) {
                float dimension2 = typedArrayObtainStyledAttributes.getDimension(index, 12.0f);
                this.a.setNormalStrokeWidth(dimension2);
                this.b.setNormalStrokeWidth(dimension2);
            } else if (index == 17) {
                integer3 = typedArrayObtainStyledAttributes.getInteger(index, 30);
            } else if (index == 19) {
                integer = typedArrayObtainStyledAttributes.getInteger(index, ChartCoordinateportAnimator.FAST_ANIMATION_DURATION);
            } else if (index == 6) {
                integer2 = typedArrayObtainStyledAttributes.getInteger(index, ChartCoordinateportAnimator.FAST_ANIMATION_DURATION);
            } else if (index == 18) {
                int integer4 = typedArrayObtainStyledAttributes.getInteger(index, ChartCoordinateportAnimator.FAST_ANIMATION_DURATION);
                this.a.setStartAngle(integer4);
                this.b.setStartAngle(integer4);
            } else if (index == 14) {
                boolean z = typedArrayObtainStyledAttributes.getBoolean(index, false);
                this.a.setShowIcon(z);
                this.b.setShowIcon(z);
            } else if (index == 7) {
                this.a.setmIcon(ImageUtils.a(typedArrayObtainStyledAttributes.getResourceId(index, R.mipmap.ic_launcher)));
            } else if (index == 9) {
                this.b.setmIcon1(ImageUtils.a(typedArrayObtainStyledAttributes.getResourceId(index, R.mipmap.ic_launcher)));
            } else if (index == 11) {
                this.b.setmIcon2(ImageUtils.a(typedArrayObtainStyledAttributes.getResourceId(index, R.mipmap.ic_launcher)));
            } else if (index == 8) {
                this.a.setIconBgColor(typedArrayObtainStyledAttributes.getColor(index, -16777216));
            } else if (index == 10) {
                this.b.setIconBgColor1(typedArrayObtainStyledAttributes.getColor(index, -16777216));
            } else if (index == 12) {
                this.b.setIconBgColor2(typedArrayObtainStyledAttributes.getColor(index, -16777216));
            } else if (index == 13) {
                float dimension3 = typedArrayObtainStyledAttributes.getDimension(index, d.c(15.0f));
                this.a.setmIconSize(dimension3);
                this.b.setmIconSize(dimension3);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        int iA = a(integer);
        int iA2 = a(integer2);
        int iA3 = a(integer3);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA2);
        layoutParams.gravity = 17;
        this.b.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA - iA3, iA2 - iA3);
        layoutParams2.gravity = 17;
        this.a.setLayoutParams(layoutParams2);
    }

    public void setCircleView1Progress(int i) {
        this.a.h(i);
    }

    public void setCircleView2Progress(int i) {
        this.b.l(i);
    }

    public void setCircleView3Progress(int i) {
        this.b.m(i);
    }

    public MuiltLayerCircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MuiltLayerCircleProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
    }
}
