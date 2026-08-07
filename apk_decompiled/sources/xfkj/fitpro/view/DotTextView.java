package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import org.objectweb.asm.Opcodes;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class DotTextView extends AppCompatTextView {
    private Paint h;
    private Rect i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Paint f414q;
    private boolean r;

    public DotTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float totalPaddingStart;
        int totalPaddingTop;
        int i;
        int totalPaddingStart2;
        float f;
        float totalPaddingEnd;
        int totalPaddingStart3;
        super.onDraw(canvas);
        if (!TextUtils.isEmpty(getText()) && this.o) {
            Layout layout = getLayout();
            float primaryHorizontal = layout.getPrimaryHorizontal(0);
            float lineWidth = layout.getLineWidth(0) + primaryHorizontal;
            getPaint().getTextBounds(getText().toString(), 0, getText().length(), this.i);
            switch (this.m) {
                case 1:
                    totalPaddingStart = primaryHorizontal + this.k + getTotalPaddingStart();
                    totalPaddingTop = getTotalPaddingTop();
                    i = this.l;
                    f = totalPaddingTop + i;
                    break;
                case 2:
                    totalPaddingStart = lineWidth + this.k + getTotalPaddingStart();
                    totalPaddingTop = getTotalPaddingTop();
                    i = this.l;
                    f = totalPaddingTop + i;
                    break;
                case 3:
                    totalPaddingStart = primaryHorizontal + this.k + getTotalPaddingStart();
                    totalPaddingTop = getTotalPaddingTop() + (getLineHeight() * layout.getLineCount());
                    i = this.l;
                    f = totalPaddingTop + i;
                    break;
                case 4:
                    totalPaddingStart = lineWidth + this.k + getTotalPaddingStart();
                    totalPaddingTop = getTotalPaddingTop() + (getLineHeight() * layout.getLineCount());
                    i = this.l;
                    f = totalPaddingTop + i;
                    break;
                case 5:
                    totalPaddingStart = primaryHorizontal + this.k + getTotalPaddingStart();
                    totalPaddingTop = getTotalPaddingTop() + ((getLineHeight() * layout.getLineCount()) / 2);
                    i = this.l;
                    f = totalPaddingTop + i;
                    break;
                case 6:
                    totalPaddingStart = lineWidth + this.k + getTotalPaddingStart();
                    totalPaddingTop = getTotalPaddingTop() + ((getLineHeight() * layout.getLineCount()) / 2);
                    i = this.l;
                    f = totalPaddingTop + i;
                    break;
                case 7:
                    if (getCompoundDrawables()[0] == null) {
                        primaryHorizontal += this.k;
                        totalPaddingStart2 = getTotalPaddingStart();
                    } else {
                        totalPaddingStart2 = this.k;
                    }
                    totalPaddingStart = primaryHorizontal + totalPaddingStart2;
                    totalPaddingTop = getTotalPaddingTop() + ((getLineHeight() * layout.getLineCount()) / 2);
                    i = this.l;
                    f = totalPaddingTop + i;
                    break;
                case 8:
                    if (getCompoundDrawables()[2] == null) {
                        totalPaddingEnd = lineWidth + this.k;
                        totalPaddingStart3 = getTotalPaddingStart();
                    } else {
                        totalPaddingEnd = lineWidth + this.k + getTotalPaddingEnd();
                        totalPaddingStart3 = getTotalPaddingStart();
                    }
                    totalPaddingStart = totalPaddingEnd + totalPaddingStart3;
                    totalPaddingTop = getTotalPaddingTop() + ((getLineHeight() * layout.getLineCount()) / 2);
                    i = this.l;
                    f = totalPaddingTop + i;
                    break;
                default:
                    f = 0.0f;
                    totalPaddingStart = 0.0f;
                    break;
            }
            canvas.drawCircle(totalPaddingStart, f, this.n, this.h);
            if (this.r) {
                int iWidth = this.i.width();
                int iHeight = this.i.height();
                canvas.drawText(String.format("[(文字总宽度=%s, 高度=%s, 行数=%s)]", Integer.valueOf(iWidth), Integer.valueOf(iHeight), Integer.valueOf(layout.getLineCount())), 0.0f, iHeight, this.f414q);
                canvas.drawText(String.format("[(DotTextView宽度=%s, 高度=%s)]", Integer.valueOf(getWidth()), Integer.valueOf(getHeight())), 0.0f, iHeight * 2, this.f414q);
                canvas.drawText(String.format("[(每行文字高度(包含文字间距)=%s)]", Integer.valueOf(getLineHeight())), 0.0f, iHeight * 3, this.f414q);
                canvas.drawText(String.format("[(左图标间距=%s，右图标间距=%s，上图标间距=%s，下图标间距=%s)]", Integer.valueOf(getCompoundPaddingStart()), Integer.valueOf(getCompoundPaddingEnd()), Integer.valueOf(getCompoundPaddingTop()), Integer.valueOf(getCompoundPaddingBottom())), 0.0f, iHeight * 4, this.f414q);
            }
        }
    }

    public void setDebug(boolean z) {
        this.r = z;
        if (this.p) {
            postInvalidate();
        }
    }

    public void setDotColor(int i) {
        this.j = i;
        if (this.p) {
            postInvalidate();
        }
    }

    public void setDotGravity(int i) {
        this.m = i;
        if (this.p) {
            postInvalidate();
        }
    }

    public void setDotOffsetX(int i) {
        this.k = i;
        if (this.p) {
            postInvalidate();
        }
    }

    public void setDotOffsetY(int i) {
        this.l = i;
        if (this.p) {
            postInvalidate();
        }
    }

    public void setDotPaddingBottom(int i) {
        this.l = -i;
        if (this.p) {
            postInvalidate();
        }
    }

    public void setDotPaddingLeft(int i) {
        this.k = i;
        if (this.p) {
            postInvalidate();
        }
    }

    public void setDotPaddingRight(int i) {
        this.k = -i;
        if (this.p) {
            postInvalidate();
        }
    }

    public void setDotPaddingTop(int i) {
        this.l = i;
        if (this.p) {
            postInvalidate();
        }
    }

    public void setDotRadius(int i) {
        this.n = i;
        if (this.p) {
            postInvalidate();
        }
    }

    public void setRefreshIImmediately(boolean z) {
        this.p = z;
    }

    public void setShowDot(boolean z) {
        this.o = z;
        if (this.p) {
            postInvalidate();
        }
    }

    public DotTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = true;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DotTextView);
            this.j = typedArrayObtainStyledAttributes.getColor(0, Opcodes.V_PREVIEW);
            this.k = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
            this.l = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0);
            this.m = typedArrayObtainStyledAttributes.getInteger(1, 2);
            this.n = typedArrayObtainStyledAttributes.getInt(4, 10);
            this.o = typedArrayObtainStyledAttributes.getBoolean(6, true);
            this.r = typedArrayObtainStyledAttributes.getBoolean(5, false);
            typedArrayObtainStyledAttributes.recycle();
        }
        Paint paint = new Paint(1);
        this.h = paint;
        paint.setColor(this.j);
        this.h.setStyle(Paint.Style.FILL);
        this.i = new Rect();
        if (this.r) {
            Paint paint2 = new Paint(1);
            this.f414q = paint2;
            paint2.setColor(this.j);
            this.f414q.setTextSize(30.0f);
        }
    }
}
