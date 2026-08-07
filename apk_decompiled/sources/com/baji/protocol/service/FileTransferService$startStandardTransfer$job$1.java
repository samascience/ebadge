package com.baji.protocol.service;

import com.baji.protocol.model.ErrorCode;
import com.baji.protocol.model.TransferFileInfo;
import com.baji.protocol.model.TransferStatus;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
@h70(c = "com.baji.protocol.service.FileTransferService$startStandardTransfer$job$1", f = "FileTransferService.kt", l = {1059}, m = "invokeSuspend")
final class FileTransferService$startStandardTransfer$job$1 extends SuspendLambda implements or0 {
    final /* synthetic */ long $fileId;
    final /* synthetic */ TransferFileInfo $transferInfo;
    int label;
    final /* synthetic */ FileTransferService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileTransferService$startStandardTransfer$job$1(FileTransferService fileTransferService, TransferFileInfo transferFileInfo, long j, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = fileTransferService;
        this.$transferInfo = transferFileInfo;
        this.$fileId = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new FileTransferService$startStandardTransfer$job$1(this.this$0, this.$transferInfo, this.$fileId, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = a.d();
        int i = this.label;
        try {
            if (i == 0) {
                d.b(obj);
                FileTransferService fileTransferService = this.this$0;
                TransferFileInfo transferFileInfo = this.$transferInfo;
                this.label = 1;
                if (fileTransferService.performStandardTransfer(transferFileInfo, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
            }
        } catch (Exception e) {
            FileTransferService fileTransferService2 = this.this$0;
            long j = this.$fileId;
            TransferStatus transferStatus = TransferStatus.FAILED;
            ErrorCode errorCode = ErrorCode.UNKNOWN_ERROR;
            String message = e.getMessage();
            fileTransferService2.updateTransferStatus(j, transferStatus, errorCode, message == null ? "Unknown error" : message);
            TransferErrorCallback transferErrorCallback = this.this$0.errorCallback;
            if (transferErrorCallback != null) {
                long j2 = this.$fileId;
                String message2 = e.getMessage();
                transferErrorCallback.onError(j2, errorCode, message2 != null ? message2 : "Unknown error");
            }
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((FileTransferService$startStandardTransfer$job$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
