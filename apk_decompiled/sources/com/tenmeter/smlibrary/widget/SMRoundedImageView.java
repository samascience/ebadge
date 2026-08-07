package com.tenmeter.smlibrary.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.utils.DisplayUtil;

/* JADX INFO: loaded from: classes3.dex */
public class SMRoundedImageView extends ImageView {
    private float bottomLeftRadius;
    private float bottomRightRadius;
    private float radius;
    private float[] rids;
    private float topLeftRadius;
    private float topRightRadius;

    public SMRoundedImageView(Context context) {
        super(context);
        this.rids = new float[0];
        this.topLeftRadius = 0.0f;
        this.topRightRadius = 0.0f;
        this.bottomLeftRadius = 0.0f;
        this.bottomRightRadius = 0.0f;
        this.radius = 0.0f;
        init(context, null, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SMRoundedImageView, i, 0);
        float dimension = typedArrayObtainStyledAttributes.getDimension(R.styleable.SMRoundedImageView_sm_riv_radius, DisplayUtil.dp2px(8.0f));
        this.radius = dimension;
        this.topLeftRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.SMRoundedImageView_sm_round_top_left_radius, dimension);
        this.topRightRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.SMRoundedImageView_sm_round_top_right_radius, this.radius);
        this.bottomLeftRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.SMRoundedImageView_sm_round_bottom_left_radius, this.radius);
        this.bottomRightRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.SMRoundedImageView_sm_round_bottom_right_radius, this.radius);
        typedArrayObtainStyledAttributes.recycle();
        float f = this.topLeftRadius;
        float f2 = this.topRightRadius;
        float f3 = this.bottomRightRadius;
        float f4 = this.bottomLeftRadius;
        this.rids = new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.rids, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    public void setRids(float f) {
        this.radius = f;
    }

    public SMRoundedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rids = new float[0];
        this.topLeftRadius = 0.0f;
        this.topRightRadius = 0.0f;
        this.bottomLeftRadius = 0.0f;
        this.bottomRightRadius = 0.0f;
        this.radius = 0.0f;
        init(context, attributeSet, 0);
    }

    public SMRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rids = new float[0];
        this.topLeftRadius = 0.0f;
        this.topRightRadius = 0.0f;
        this.bottomLeftRadius = 0.0f;
        this.bottomRightRadius = 0.0f;
        this.radius = 0.0f;
        init(context, attributeSet, i);
    }

    public SMRoundedImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.rids = new float[0];
        this.topLeftRadius = 0.0f;
        this.topRightRadius = 0.0f;
        this.bottomLeftRadius = 0.0f;
        this.bottomRightRadius = 0.0f;
        this.radius = 0.0f;
        init(context, attributeSet, i);
    }
}
