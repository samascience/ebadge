package io.microshow.rxffmpeg;

import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class RxFFmpegCommandList extends ArrayList<String> {
    public RxFFmpegCommandList() {
        add("ffmpeg");
        add("-y");
    }

    public RxFFmpegCommandList append(String str) {
        add(str);
        return this;
    }

    public String[] build() {
        String[] strArr = new String[size()];
        for (int i = 0; i < size(); i++) {
            strArr[i] = get(i);
        }
        return strArr;
    }

    public RxFFmpegCommandList clearCommands() {
        clear();
        return this;
    }

    public String[] build(boolean z) {
        String[] strArrBuild = build();
        if (z) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strArrBuild.length; i++) {
                sb.append(strArrBuild[i]);
                if (i < strArrBuild.length - 1) {
                    sb.append(" ");
                }
            }
            Log.e("TAG_FFMPEG", "cmd: " + sb.toString());
        }
        return strArrBuild;
    }
}
