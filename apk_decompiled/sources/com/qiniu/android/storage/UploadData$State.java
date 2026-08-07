package com.qiniu.android.storage;

/* JADX INFO: loaded from: classes.dex */
enum UploadData$State {
    NeedToCheck,
    WaitToUpload,
    Uploading,
    Complete;

    /* JADX INFO: Access modifiers changed from: private */
    public int intValue() {
        return ordinal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static UploadData$State state(int i) {
        UploadData$State[] uploadData$StateArrValues = values();
        return (i < 0 || i >= uploadData$StateArrValues.length) ? NeedToCheck : uploadData$StateArrValues[i];
    }
}
