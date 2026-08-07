package com.example.bluetoothlibrary.permission;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class PermissionRequest extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 1 || iArr.length <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            String str = strArr[i2];
            if (iArr[i2] != 0 && !arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        arrayList.isEmpty();
    }
}
