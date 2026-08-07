package com.alibaba.dashscope.protocol;

/* JADX INFO: loaded from: classes.dex */
public enum WebSocketEventType {
    TASK_STARTED("task-started"),
    RESULT_GENERATED("result-generated"),
    TASK_FINISHED("task-finished"),
    TASK_FAILED("task-failed"),
    RUN_TASK("run-task"),
    CONTINUE_TASK("continue-task"),
    FINISH_TASK("finish-task");

    private final String value;

    WebSocketEventType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
