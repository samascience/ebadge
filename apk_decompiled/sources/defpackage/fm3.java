package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes4.dex */
public class fm3 {
    private SharedPreferences a;
    private SharedPreferences.Editor b;

    public fm3(Context context) {
        this.a = context.getSharedPreferences("_3_gen_band_ota_test", 0);
    }

    public boolean a(String str) {
        SharedPreferences.Editor editorEdit = this.a.edit();
        this.b = editorEdit;
        editorEdit.putString("test_start_time", str);
        return this.b.commit();
    }
}
