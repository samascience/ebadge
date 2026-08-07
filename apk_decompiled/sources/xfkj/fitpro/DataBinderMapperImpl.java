package xfkj.fitpro;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.aq0;
import defpackage.b3;
import defpackage.cq0;
import defpackage.d3;
import defpackage.i3;
import defpackage.i4;
import defpackage.k3;
import defpackage.k4;
import defpackage.m3;
import defpackage.m4;
import defpackage.o3;
import defpackage.o4;
import defpackage.q4;
import defpackage.r3;
import defpackage.u3;
import defpackage.u31;
import defpackage.v50;
import defpackage.vp0;
import defpackage.w3;
import defpackage.w50;
import defpackage.x2;
import defpackage.xp0;
import defpackage.z2;
import defpackage.z3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DataBinderMapperImpl extends v50 {
    private static final SparseIntArray a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(22);
        a = sparseIntArray;
        sparseIntArray.put(R.layout.activity_about, 1);
        sparseIntArray.put(R.layout.activity_app_instructions, 2);
        sparseIntArray.put(R.layout.activity_back_permission_settings, 3);
        sparseIntArray.put(R.layout.activity_bluetooth_scan_mvvm, 4);
        sparseIntArray.put(R.layout.activity_debug_function, 5);
        sparseIntArray.put(R.layout.activity_device_home, 6);
        sparseIntArray.put(R.layout.activity_home_voice_assistant_simultaneous_translation, 7);
        sparseIntArray.put(R.layout.activity_login_and_register, 8);
        sparseIntArray.put(R.layout.activity_message_setting, 9);
        sparseIntArray.put(R.layout.activity_picture_push, 10);
        sparseIntArray.put(R.layout.activity_protocol_debug, 11);
        sparseIntArray.put(R.layout.activity_register, 12);
        sparseIntArray.put(R.layout.activity_select_language, 13);
        sparseIntArray.put(R.layout.activity_syn_contracts, 14);
        sparseIntArray.put(R.layout.activity_user_protocol, 15);
        sparseIntArray.put(R.layout.activity_video_push, 16);
        sparseIntArray.put(R.layout.activity_welcome, 17);
        sparseIntArray.put(R.layout.fragment_dialog_common_choise_double, 18);
        sparseIntArray.put(R.layout.fragment_dialog_common_edit_prompt, 19);
        sparseIntArray.put(R.layout.fragment_dialog_common_prompt, 20);
        sparseIntArray.put(R.layout.fragment_dialog_common_time_picker, 21);
        sparseIntArray.put(R.layout.item_bluetooth_device_simple, 22);
    }

    @Override // defpackage.v50
    public List collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.jieli.otasdk.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // defpackage.v50
    public ViewDataBinding getDataBinder(w50 w50Var, View view, int i) {
        int i2 = a.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/activity_about_0".equals(tag)) {
                    return new x2(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for activity_about is invalid. Received: " + tag);
            case 2:
                if ("layout/activity_app_instructions_0".equals(tag)) {
                    return new z2(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for activity_app_instructions is invalid. Received: " + tag);
            case 3:
                if ("layout/activity_back_permission_settings_0".equals(tag)) {
                    return new b3(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for activity_back_permission_settings is invalid. Received: " + tag);
            case 4:
                if ("layout/activity_bluetooth_scan_mvvm_0".equals(tag)) {
                    return new d3(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for activity_bluetooth_scan_mvvm is invalid. Received: " + tag);
            case 5:
                if ("layout/activity_debug_function_0".equals(tag)) {
                    return new i3(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for activity_debug_function is invalid. Received: " + tag);
            case 6:
                if ("layout/activity_device_home_0".equals(tag)) {
                    return new k3(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for activity_device_home is invalid. Received: " + tag);
            case 7:
                if ("layout/activity_home_voice_assistant_simultaneous_translation_0".equals(tag)) {
                    return new m3(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for activity_home_voice_assistant_simultaneous_translation is invalid. Received: " + tag);
            case 8:
                if ("layout/activity_login_and_register_0".equals(tag)) {
                    return new o3(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for activity_login_and_register is invalid. Received: " + tag);
            case 9:
                if ("layout/activity_message_setting_0".equals(tag)) {
                    return new r3(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for activity_message_setting is invalid. Received: " + tag);
            case 10:
                if ("layout/activity_picture_push_0".equals(tag)) {
                    return new u3(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for activity_picture_push is invalid. Received: " + tag);
            case 11:
                if ("layout/activity_protocol_debug_0".equals(tag)) {
                    return new w3(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for activity_protocol_debug is invalid. Received: " + tag);
            case 12:
                if ("layout/activity_register_0".equals(tag)) {
                    return new z3(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for activity_register is invalid. Received: " + tag);
            case 13:
                if ("layout/activity_select_language_0".equals(tag)) {
                    return new i4(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for activity_select_language is invalid. Received: " + tag);
            case 14:
                if ("layout/activity_syn_contracts_0".equals(tag)) {
                    return new k4(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for activity_syn_contracts is invalid. Received: " + tag);
            case 15:
                if ("layout/activity_user_protocol_0".equals(tag)) {
                    return new m4(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for activity_user_protocol is invalid. Received: " + tag);
            case 16:
                if ("layout/activity_video_push_0".equals(tag)) {
                    return new o4(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for activity_video_push is invalid. Received: " + tag);
            case 17:
                if ("layout/activity_welcome_0".equals(tag)) {
                    return new q4(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for activity_welcome is invalid. Received: " + tag);
            case 18:
                if ("layout/fragment_dialog_common_choise_double_0".equals(tag)) {
                    return new vp0(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for fragment_dialog_common_choise_double is invalid. Received: " + tag);
            case 19:
                if ("layout/fragment_dialog_common_edit_prompt_0".equals(tag)) {
                    return new xp0(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for fragment_dialog_common_edit_prompt is invalid. Received: " + tag);
            case 20:
                if ("layout/fragment_dialog_common_prompt_0".equals(tag)) {
                    return new aq0(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for fragment_dialog_common_prompt is invalid. Received: " + tag);
            case 21:
                if ("layout/fragment_dialog_common_time_picker_0".equals(tag)) {
                    return new cq0(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for fragment_dialog_common_time_picker is invalid. Received: " + tag);
            case 22:
                if ("layout/item_bluetooth_device_simple_0".equals(tag)) {
                    return new u31(w50Var, view);
                }
                throw new IllegalArgumentException("The tag for item_bluetooth_device_simple is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // defpackage.v50
    public ViewDataBinding getDataBinder(w50 w50Var, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
