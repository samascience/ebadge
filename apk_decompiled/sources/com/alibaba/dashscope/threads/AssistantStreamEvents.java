package com.alibaba.dashscope.threads;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public enum AssistantStreamEvents {
    THREAD_CREATED("thread.created"),
    THREAD_RUN_CREATED("thread.run.created"),
    THREAD_RUN_QUEUED("thread.run.queued"),
    THREAD_RUN_IN_PROGRESS("thread.run.in_progress"),
    THREAD_RUN_REQUIRES_ACTION("thread.run.requires_action"),
    THREAD_RUN_COMPLETED("thread.run.completed"),
    THREAD_RUN_FAILED("thread.run.failed"),
    THREAD_RUN_CANCELLING("thread.run.cancelling"),
    THREAD_RUN_CANCELED("thread.run.cancelled"),
    THREAD_RUN_EXPIRED("thread.run.expired"),
    THREAD_RUN_STEP_CREATED("thread.run.step.created"),
    THREAD_RUN_STEP_IN_PROGRESS("thread.run.step.in_progress"),
    THREAD_RUN_STEP_DELTA("thread.run.step.delta"),
    THREAD_RUN_STEP_COMPLETED("thread.run.step.completed"),
    THREAD_RUN_STEP_FAILED("thread.run.step.failed"),
    THREAD_RUN_STEP_CANCELLED("thread.run.step.cancelled"),
    THREAD_RUN_STEP_EXPIRED("thread.run.step.expired"),
    THREAD_MESSAGE_CREATED("thread.message.created"),
    THREAD_MESSAGE_IN_PROGRESS("thread.message.in_progress"),
    THREAD_MESSAGE_DELTA("thread.message.delta"),
    THREAD_MESSAGE_COMPLETED("thread.message.completed"),
    THREAD_MESSAGE_INCOMPLETE("thread.message.incomplete"),
    ERROR("error"),
    DONE("done"),
    UNKNOWN("unknown");

    private static final Map<String, AssistantStreamEvents> CONSTANTS = new HashMap();
    private final String value;

    static {
        for (AssistantStreamEvents assistantStreamEvents : values()) {
            CONSTANTS.put(assistantStreamEvents.value, assistantStreamEvents);
        }
    }

    AssistantStreamEvents(String str) {
        this.value = str;
    }

    public static AssistantStreamEvents fromValue(String str) {
        AssistantStreamEvents assistantStreamEvents = CONSTANTS.get(str);
        return assistantStreamEvents == null ? UNKNOWN : assistantStreamEvents;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }
}
