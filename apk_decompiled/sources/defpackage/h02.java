package defpackage;

import com.legend.mywatch.commonlib.R$string;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h02 {
    private static final Map a;

    static {
        HashMap map = new HashMap();
        a = map;
        map.put("android.permission.CAMERA", Integer.valueOf(R$string.camera_permission));
        map.put("android.permission.READ_CONTACTS", Integer.valueOf(R$string.read_contacts_permission));
        map.put("android.permission.READ_CALL_LOG", Integer.valueOf(R$string.read_call_log_permission));
        map.put("android.permission.READ_PHONE_STATE", Integer.valueOf(R$string.read_phone_state_permission));
        map.put("android.permission.WRITE_EXTERNAL_STORAGE", Integer.valueOf(R$string.write_external_storage_permission));
        map.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(R$string.read_external_storage_permission));
        map.put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(R$string.access_fine_location_permission));
        map.put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(R$string.access_coarse_location_permission));
        map.put("android.permission.RECORD_AUDIO", Integer.valueOf(R$string.record_audio_permission));
        map.put("android.permission.SEND_SMS", Integer.valueOf(R$string.send_sms_permission));
        map.put("android.permission.RECEIVE_SMS", Integer.valueOf(R$string.receive_sms_permission));
        map.put("android.permission.READ_SMS", Integer.valueOf(R$string.read_sms_permission));
        map.put("android.permission.CALL_PHONE", Integer.valueOf(R$string.call_phone_permission));
        map.put("android.permission.BODY_SENSORS", Integer.valueOf(R$string.body_sensors_permission));
        map.put("android.permission.ACTIVITY_RECOGNITION", Integer.valueOf(R$string.activity_recognition_permission));
        map.put("android.permission.BLUETOOTH", Integer.valueOf(R$string.bluetooth_permission));
        map.put("android.permission.BLUETOOTH_ADMIN", Integer.valueOf(R$string.bluetooth_admin_permission));
        map.put("android.permission.NFC", Integer.valueOf(R$string.nfc_permission));
        map.put("android.permission.GET_ACCOUNTS", Integer.valueOf(R$string.get_accounts_permission));
        map.put("android.permission.PROCESS_OUTGOING_CALLS", Integer.valueOf(R$string.process_outgoing_calls_permission));
        map.put("android.permission.USE_SIP", Integer.valueOf(R$string.use_sip_permission));
        map.put("android.permission.BROADCAST_STICKY", Integer.valueOf(R$string.broadcast_sticky_permission));
        map.put("android.permission.CHANGE_NETWORK_STATE", Integer.valueOf(R$string.change_network_state_permission));
        map.put("android.permission.CHANGE_WIFI_STATE", Integer.valueOf(R$string.change_wifi_state_permission));
        map.put("android.permission.CHANGE_WIFI_MULTICAST_STATE", Integer.valueOf(R$string.change_wifi_multicast_state_permission));
        map.put("android.permission.EXPAND_STATUS_BAR", Integer.valueOf(R$string.expand_status_bar_permission));
        map.put("com.android.launcher.permission.INSTALL_SHORTCUT", Integer.valueOf(R$string.install_shortcut_permission));
        map.put("android.permission.KILL_BACKGROUND_PROCESSES", Integer.valueOf(R$string.kill_background_processes_permission));
        map.put("android.permission.MODIFY_AUDIO_SETTINGS", Integer.valueOf(R$string.modify_audio_settings_permission));
        map.put("android.permission.RECEIVE_BOOT_COMPLETED", Integer.valueOf(R$string.receive_boot_completed_permission));
        map.put("android.permission.RECEIVE_MMS", Integer.valueOf(R$string.receive_mms_permission));
        map.put("android.permission.RECEIVE_WAP_PUSH", Integer.valueOf(R$string.receive_wap_push_permission));
        map.put("android.permission.REBOOT", Integer.valueOf(R$string.reboot_permission));
        map.put("android.permission.SET_PROCESS_LIMIT", Integer.valueOf(R$string.set_process_limit_permission));
        map.put("android.permission.SET_TIME_ZONE", Integer.valueOf(R$string.set_time_zone_permission));
        map.put("android.permission.SET_WALLPAPER", Integer.valueOf(R$string.set_wallpaper_permission));
        map.put("android.permission.SET_WALLPAPER_HINTS", Integer.valueOf(R$string.set_wallpaper_hints_permission));
        map.put("android.permission.SYSTEM_ALERT_WINDOW", Integer.valueOf(R$string.system_alert_window_permission));
        map.put("android.permission.VIBRATE", Integer.valueOf(R$string.vibrate_permission));
        map.put("android.permission.WAKE_LOCK", Integer.valueOf(R$string.wake_lock_permission));
        map.put("android.permission.WRITE_SETTINGS", Integer.valueOf(R$string.write_settings_permission));
        map.put("android.permission.WRITE_SYNC_SETTINGS", Integer.valueOf(R$string.write_sync_settings_permission));
        map.put("android.permission.ACCESS_NETWORK_STATE", Integer.valueOf(R$string.access_network_state_permission));
        map.put("android.permission.ACCESS_WIFI_STATE", Integer.valueOf(R$string.access_wifi_state_permission));
        map.put("android.permission.ACCESS_LOCATION_EXTRA_COMMANDS", Integer.valueOf(R$string.access_location_extra_commands_permission));
        map.put("android.permission.BATTERY_STATS", Integer.valueOf(R$string.battery_stats_permission));
        map.put("android.permission.BROADCAST_PACKAGE_REMOVED", Integer.valueOf(R$string.broadcast_package_removed_permission));
        map.put("android.permission.CHANGE_CONFIGURATION", Integer.valueOf(R$string.change_configuration_permission));
        map.put("android.permission.CLEAR_APP_CACHE", Integer.valueOf(R$string.clear_app_cache_permission));
        map.put("android.permission.CONTROL_LOCATION_UPDATES", Integer.valueOf(R$string.control_location_updates_permission));
        map.put("android.permission.DELETE_CACHE_FILES", Integer.valueOf(R$string.delete_cache_files_permission));
        map.put("android.permission.DELETE_PACKAGES", Integer.valueOf(R$string.delete_packages_permission));
        map.put("android.permission.DIAGNOSTIC", Integer.valueOf(R$string.diagnostic_permission));
        map.put("android.permission.DISABLE_KEYGUARD", Integer.valueOf(R$string.disable_keyguard_permission));
        map.put("android.permission.DUMP", Integer.valueOf(R$string.dump_permission));
        map.put("android.permission.FACTORY_TEST", Integer.valueOf(R$string.factory_test_permission));
        map.put("android.permission.GET_PACKAGE_SIZE", Integer.valueOf(R$string.get_package_size_permission));
        map.put("android.permission.GLOBAL_SEARCH", Integer.valueOf(R$string.global_search_permission));
        map.put("android.permission.INSTALL_LOCATION_PROVIDER", Integer.valueOf(R$string.install_location_provider_permission));
        map.put("android.permission.INSTALL_PACKAGES", Integer.valueOf(R$string.install_packages_permission));
        map.put("android.permission.MASTER_CLEAR", Integer.valueOf(R$string.master_clear_permission));
        map.put("android.permission.MOUNT_FORMAT_FILESYSTEMS", Integer.valueOf(R$string.mount_format_filesystems_permission));
        map.put("android.permission.MOUNT_UNMOUNT_FILESYSTEMS", Integer.valueOf(R$string.mount_unmount_filesystems_permission));
        map.put("android.permission.PERSISTENT_ACTIVITY", Integer.valueOf(R$string.persistent_activity_permission));
        map.put("android.permission.READ_CALENDAR", Integer.valueOf(R$string.read_calendar_permission));
        map.put("android.permission.READ_INPUT_STATE", Integer.valueOf(R$string.read_input_state_permission));
        map.put("android.permission.READ_LOGS", Integer.valueOf(R$string.read_logs_permission));
        map.put("android.permission.READ_SYNC_SETTINGS", Integer.valueOf(R$string.read_sync_settings_permission));
        map.put("android.permission.READ_SYNC_STATS", Integer.valueOf(R$string.read_sync_stats_permission));
        map.put("android.permission.REORDER_TASKS", Integer.valueOf(R$string.reorder_tasks_permission));
        map.put("android.permission.REQUEST_INSTALL_PACKAGES", Integer.valueOf(R$string.request_install_packages_permission));
        map.put("com.android.alarm.permission.SET_ALARM", Integer.valueOf(R$string.set_alarm_permission));
        map.put("android.permission.SET_ALWAYS_FINISH", Integer.valueOf(R$string.set_always_finish_permission));
        map.put("android.permission.SET_ANIMATION_SCALE", Integer.valueOf(R$string.set_animation_scale_permission));
        map.put("android.permission.SET_DEBUG_APP", Integer.valueOf(R$string.set_debug_app_permission));
        map.put("android.permission.SET_PREFERRED_APPLICATIONS", Integer.valueOf(R$string.set_preferred_applications_permission));
        map.put("android.permission.SET_TIME", Integer.valueOf(R$string.set_time_permission));
        map.put("android.permission.SIGNAL_PERSISTENT_PROCESSES", Integer.valueOf(R$string.signal_persistent_processes_permission));
        map.put("android.permission.STATUS_BAR", Integer.valueOf(R$string.status_bar_permission));
        map.put("android.permission.TRANSMIT_IR", Integer.valueOf(R$string.transmit_ir_permission));
        map.put("android.permission.WRITE_APN_SETTINGS", Integer.valueOf(R$string.write_apn_settings_permission));
        map.put("android.permission.WRITE_CALENDAR", Integer.valueOf(R$string.write_calendar_permission));
        map.put("android.permission.WRITE_CONTACTS", Integer.valueOf(R$string.write_contacts_permission));
        map.put("android.permission.WRITE_SECURE_SETTINGS", Integer.valueOf(R$string.write_secure_settings_permission));
        map.put("android.permission.BLUETOOTH_SCAN", Integer.valueOf(R$string.bluetooth_scan));
        map.put("android.permission.BLUETOOTH_CONNECT", Integer.valueOf(R$string.bluetooth_connect));
        map.put("android.permission.BLUETOOTH_ADVERTISE", Integer.valueOf(R$string.bluetooth_advertise));
        map.put("android.permission.READ_MEDIA_IMAGES", Integer.valueOf(R$string.read_media_images));
        map.put("android.permission.ACCESS_BACKGROUND_LOCATION", Integer.valueOf(R$string.access_background_location_permission));
        map.put("android.permission.POST_NOTIFICATIONS", Integer.valueOf(R$string.post_notifications_permission));
    }

    public static String a(String str) {
        return pv2.d(((Integer) a.getOrDefault(str, Integer.valueOf(R$string.unknown_permission))).intValue());
    }

    public static String[] b(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = a(strArr[i]);
        }
        return strArr2;
    }
}
