package xfkj.fitpro.model;

import android.util.Log;
import java.util.Date;
import xfkj.fitpro.utils.SleepUtils$SleepType;

/* JADX INFO: loaded from: classes4.dex */
public class SleepChartValueBean {
    private static int offsetOfLight;
    private Date startDate;
    private int status;
    private int timeLong;

    public SleepChartValueBean() {
        this.timeLong = 20;
        this.status = 0;
    }

    public static void setOffsetOfLight(int i) {
        offsetOfLight = i;
    }

    public int getElementLevel() {
        int i = this.status;
        if (i != 0 && i != SleepUtils$SleepType.WAKE_UP.getSleepType()) {
            if (this.status == SleepUtils$SleepType.EYE_MOVEMENT.getSleepType()) {
                return 1;
            }
            if (this.status == SleepUtils$SleepType.LIGHT.getSleepType()) {
                return 2 - offsetOfLight;
            }
            if (this.status == SleepUtils$SleepType.DEEP.getSleepType()) {
                return 3;
            }
        }
        return 0;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public int getStatus() {
        return this.status;
    }

    public int getTimeLong() {
        return this.timeLong;
    }

    public void setStartDate(Date date) {
        this.startDate = date;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTimeLong(int i) {
        this.timeLong = i;
    }

    public SleepChartValueBean(int i, int i2, Date date) {
        this.timeLong = 20;
        this.status = 0;
        Log.d("tag", "1timeLong=" + i + ", status=" + i2 + ", startDate");
        this.timeLong = i;
        if (i2 != SleepUtils$SleepType.LIGHT.getSleepType() && i2 != SleepUtils$SleepType.DEEP.getSleepType() && i2 != SleepUtils$SleepType.EYE_MOVEMENT.getSleepType()) {
            i2 = SleepUtils$SleepType.WAKE_UP.getSleepType();
        }
        this.status = i2;
        this.startDate = date;
        Log.d("tag", "2timeLong=" + this.timeLong + ", status=" + this.status + ", startDate");
    }

    public int getElementLevel(boolean z) {
        Log.d("SleepChartValueBean", "getElementLevel: status=" + this.status + ", showEyeMovement=" + z + ", offsetOfLight=" + offsetOfLight);
        int i = this.status;
        if (i != 0 && i != SleepUtils$SleepType.WAKE_UP.getSleepType()) {
            if (this.status == SleepUtils$SleepType.EYE_MOVEMENT.getSleepType()) {
                if (!z) {
                    return -1;
                }
                if (offsetOfLight > 0) {
                    Log.d("SleepChartValueBean", "眼动状态，offsetOfLight > 0，返回 0");
                    return 0;
                }
                Log.d("SleepChartValueBean", "眼动状态，offsetOfLight = 0，返回 1");
                return 1;
            }
            if (this.status == SleepUtils$SleepType.LIGHT.getSleepType()) {
                if (!z) {
                    return 1;
                }
                if (offsetOfLight > 0) {
                    Log.d("SleepChartValueBean", "浅睡状态，offsetOfLight > 0，返回 1");
                    return 1;
                }
                Log.d("SleepChartValueBean", "浅睡状态，offsetOfLight = 0，返回 2");
                return 2;
            }
            if (this.status == SleepUtils$SleepType.DEEP.getSleepType()) {
                if (!z) {
                    return 2;
                }
                if (offsetOfLight > 0) {
                    Log.d("SleepChartValueBean", "深睡状态，offsetOfLight > 0，返回 2");
                    return 2;
                }
                Log.d("SleepChartValueBean", "深睡状态，offsetOfLight = 0，返回 3");
                return 3;
            }
        }
        return 0;
    }
}
