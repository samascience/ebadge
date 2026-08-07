package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class a extends Preference {
    private long S;

    a(Context context, List list, long j) {
        super(context);
        s0();
        t0(list);
        this.S = j + 1000000;
    }

    private void s0() {
        f0(R$layout.expand_button);
        d0(R$drawable.ic_arrow_down_24dp);
        l0(R$string.expand_button_title);
        i0(RoomDatabase.MAX_BIND_PARAMETER_CNT);
    }

    private void t0(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        CharSequence string = null;
        while (it.hasNext()) {
            Preference preference = (Preference) it.next();
            CharSequence charSequenceX = preference.x();
            boolean z = preference instanceof PreferenceGroup;
            if (z && !TextUtils.isEmpty(charSequenceX)) {
                arrayList.add((PreferenceGroup) preference);
            }
            if (arrayList.contains(preference.o())) {
                if (z) {
                    arrayList.add((PreferenceGroup) preference);
                }
            } else if (!TextUtils.isEmpty(charSequenceX)) {
                string = string == null ? charSequenceX : g().getString(R$string.summary_collapsed_preference_list, string, charSequenceX);
            }
        }
        j0(string);
    }

    @Override // androidx.preference.Preference
    public void J(d dVar) {
        super.J(dVar);
        dVar.d(false);
    }

    @Override // androidx.preference.Preference
    long k() {
        return this.S;
    }
}
