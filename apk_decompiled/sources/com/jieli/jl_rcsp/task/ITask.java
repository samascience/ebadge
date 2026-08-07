package com.jieli.jl_rcsp.task;

/* JADX INFO: loaded from: classes3.dex */
public interface ITask {
    void cancel(byte b);

    boolean isRun();

    void setListener(TaskListener taskListener);

    void start();
}
