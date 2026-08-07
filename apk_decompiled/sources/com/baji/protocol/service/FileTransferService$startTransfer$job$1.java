package com.baji.protocol.service;

import com.baji.protocol.model.ErrorCode;
import com.baji.protocol.model.TransferFileInfo;
import com.baji.protocol.model.TransferStatus;
import com.jieli.jl_rcsp.constant.Command;
import defpackage.h70;
import defpackage.jn;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import java.util.Map;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
@h70(c = "com.baji.protocol.service.FileTransferService$startTransfer$job$1", f = "FileTransferService.kt", l = {Command.CMD_SET_DEVICE_STORAGE, 238}, m = "invokeSuspend")
final class FileTransferService$startTransfer$job$1 extends SuspendLambda implements or0 {
    final /* synthetic */ long $tempFileId;
    final /* synthetic */ TransferFileInfo $transferInfo;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FileTransferService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileTransferService$startTransfer$job$1(TransferFileInfo transferFileInfo, FileTransferService fileTransferService, long j, x30 x30Var) {
        super(2, x30Var);
        this.$transferInfo = transferFileInfo;
        this.this$0 = fileTransferService;
        this.$tempFileId = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        FileTransferService$startTransfer$job$1 fileTransferService$startTransfer$job$1 = new FileTransferService$startTransfer$job$1(this.$transferInfo, this.this$0, this.$tempFileId, x30Var);
        fileTransferService$startTransfer$job$1.L$0 = obj;
        return fileTransferService$startTransfer$job$1;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00d4 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineScope coroutineScope;
        TransferFileInfo transferFileInfoCopy$default;
        FileTransferService fileTransferService;
        Object objD = a.d();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    coroutineScope = (CoroutineScope) this.L$0;
                    d.b(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d.b(obj);
                }
                return k83.a;
            }
            d.b(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            if (this.$transferInfo.getMediaId() == -1) {
                FileTransferService fileTransferService2 = this.this$0;
                long j = this.$tempFileId;
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = fileTransferService2.requestMediaIdAllocation(j, this);
                if (obj == objD) {
                    return objD;
                }
            } else {
                transferFileInfoCopy$default = this.$transferInfo;
            }
            long mediaId = transferFileInfoCopy$default.getMediaId();
            this.this$0.transferJobs.remove(jn.c(this.$tempFileId));
            Long lC = jn.c(mediaId);
            Map map = this.this$0.transferJobs;
            kotlin.coroutines.d.b bVar = coroutineScope.getCoroutineContext().get(Job.Key);
            p31.c(bVar);
            map.put(lC, bVar);
            this.this$0.updateTransferStatus(mediaId, TransferStatus.PREPARING, ErrorCode.SUCCESS, "Starting transfer with media ID: " + mediaId);
            fileTransferService = this.this$0;
            this.L$0 = null;
            this.label = 2;
            if (fileTransferService.performStandardTransfer(transferFileInfoCopy$default, this) == objD) {
                return objD;
            }
            return k83.a;
            int iIntValue = ((Number) obj).intValue();
            if (iIntValue == -1) {
                FileTransferService fileTransferService3 = this.this$0;
                long j2 = this.$tempFileId;
                TransferStatus transferStatus = TransferStatus.FAILED;
                ErrorCode errorCode = ErrorCode.UNKNOWN_ERROR;
                fileTransferService3.updateTransferStatus(j2, transferStatus, errorCode, "Failed to allocate media ID");
                TransferErrorCallback transferErrorCallback = this.this$0.errorCallback;
                if (transferErrorCallback != null) {
                    transferErrorCallback.onError(this.$tempFileId, errorCode, "Failed to allocate media ID");
                }
                return k83.a;
            }
            transferFileInfoCopy$default = TransferFileInfo.copy$default(this.$transferInfo, iIntValue, 0L, null, null, null, 30, null);
            long mediaId2 = transferFileInfoCopy$default.getMediaId();
            this.this$0.transferJobs.remove(jn.c(this.$tempFileId));
            Long lC2 = jn.c(mediaId2);
            Map map2 = this.this$0.transferJobs;
            kotlin.coroutines.d.b bVar2 = coroutineScope.getCoroutineContext().get(Job.Key);
            p31.c(bVar2);
            map2.put(lC2, bVar2);
            this.this$0.updateTransferStatus(mediaId2, TransferStatus.PREPARING, ErrorCode.SUCCESS, "Starting transfer with media ID: " + mediaId2);
            fileTransferService = this.this$0;
            this.L$0 = null;
            this.label = 2;
            if (fileTransferService.performStandardTransfer(transferFileInfoCopy$default, this) == objD) {
                return objD;
            }
            return k83.a;
        } catch (Exception e) {
            FileTransferService fileTransferService4 = this.this$0;
            long j3 = this.$tempFileId;
            TransferStatus transferStatus2 = TransferStatus.FAILED;
            ErrorCode errorCode2 = ErrorCode.UNKNOWN_ERROR;
            String message = e.getMessage();
            fileTransferService4.updateTransferStatus(j3, transferStatus2, errorCode2, message == null ? "Unknown error" : message);
            TransferErrorCallback transferErrorCallback2 = this.this$0.errorCallback;
            if (transferErrorCallback2 != null) {
                long j4 = this.$tempFileId;
                String message2 = e.getMessage();
                transferErrorCallback2.onError(j4, errorCode2, message2 != null ? message2 : "Unknown error");
            }
        }
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((FileTransferService$startTransfer$job$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
