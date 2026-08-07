package defpackage;

import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public class sb1 extends qc {
    private final ListView s;

    public sb1(ListView listView) {
        super(listView);
        this.s = listView;
    }

    @Override // defpackage.qc
    public boolean a(int i) {
        return false;
    }

    @Override // defpackage.qc
    public boolean b(int i) {
        ListView listView = this.s;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.qc
    public void j(int i, int i2) {
        this.s.scrollListBy(i2);
    }
}
