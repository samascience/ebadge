package com.alibaba.dashscope.aigc.multimodalconversation;

import defpackage.xm2;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class OcrOptions implements Serializable {

    @xm2("task")
    private Task task;

    @xm2("task_config")
    private d taskConfig;

    public enum Task {
        KEY_INFORMATION_EXTRACTION,
        TEXT_RECOGNITION,
        TABLE_PARSING,
        DOCUMENT_PARSING,
        FORMULA_RECOGNITION,
        MULTI_LAN,
        ADVANCED_RECOGNITION
    }

    public static abstract class b {
        private Task a;

        static /* synthetic */ d b(b bVar) {
            bVar.getClass();
            return null;
        }

        public String toString() {
            return "OcrOptions.OcrOptionsBuilder(task=" + this.a + ", taskConfig=" + ((Object) null) + ")";
        }
    }

    private static final class c extends b {
        private c() {
        }
    }

    public static class d {
    }

    protected OcrOptions(b bVar) {
        this.task = bVar.a;
        b.b(bVar);
    }

    public static b builder() {
        return new c();
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof OcrOptions;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OcrOptions)) {
            return false;
        }
        OcrOptions ocrOptions = (OcrOptions) obj;
        if (!ocrOptions.canEqual(this)) {
            return false;
        }
        Task task = getTask();
        Task task2 = ocrOptions.getTask();
        if (task != null ? !task.equals(task2) : task2 != null) {
            return false;
        }
        getTaskConfig();
        ocrOptions.getTaskConfig();
        return true;
    }

    public Task getTask() {
        return this.task;
    }

    public d getTaskConfig() {
        return null;
    }

    public int hashCode() {
        Task task = getTask();
        int iHashCode = task == null ? 43 : task.hashCode();
        getTaskConfig();
        return ((iHashCode + 59) * 59) + 43;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setTaskConfig(d dVar) {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OcrOptions(task=");
        sb.append(getTask());
        sb.append(", taskConfig=");
        getTaskConfig();
        sb.append((Object) null);
        sb.append(")");
        return sb.toString();
    }
}
