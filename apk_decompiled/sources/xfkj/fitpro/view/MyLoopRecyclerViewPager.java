package xfkj.fitpro.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;

/* JADX INFO: loaded from: classes4.dex */
public class MyLoopRecyclerViewPager extends RecyclerViewPager {
    private float F;
    private int G;
    private final String y;
    private float z;

    public MyLoopRecyclerViewPager(Context context) {
        super(context);
        this.y = MyLoopRecyclerViewPager.class.getSimpleName();
        this.G = 10;
    }

    @Override // com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.z = x;
            this.F = y;
        } else if (action == 2 && Math.abs(x - this.z) < Math.abs(y - this.F)) {
            Log.i(this.y, "=============向下滑动");
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public MyLoopRecyclerViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = MyLoopRecyclerViewPager.class.getSimpleName();
        this.G = 10;
    }
}
