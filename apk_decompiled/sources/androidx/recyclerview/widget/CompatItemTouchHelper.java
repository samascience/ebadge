package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class CompatItemTouchHelper extends ItemTouchHelper {
    public CompatItemTouchHelper(ItemTouchHelper.Callback callback) {
        super(callback);
    }

    public ItemTouchHelper.Callback getCallback() {
        return this.mCallback;
    }
}
