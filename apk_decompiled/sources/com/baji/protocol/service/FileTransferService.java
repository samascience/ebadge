package com.baji.protocol.service;

import android.util.Log;
import com.baji.protocol.event.BajiBaseEvent;
import com.baji.protocol.model.ChunkInfo;
import com.baji.protocol.model.ErrorCode;
import com.baji.protocol.model.FileTransferCommand;
import com.baji.protocol.model.FileType;
import com.baji.protocol.model.FunctionType;
import com.baji.protocol.model.ModuleId;
import com.baji.protocol.model.TransferFileInfo;
import com.baji.protocol.model.TransferStatus;
import com.baji.protocol.model.TransferStatusInfo;
import com.baji.protocol.utils.Crc32Utils;
import com.baji.protocol.utils.ProtocolEncoder;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import defpackage.gx;
import defpackage.h70;
import defpackage.jn;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.j;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes.dex */
public final class FileTransferService extends BaseProtocolService {
    private or0 dataSender;
    private TransferErrorCallback errorCallback;
    private MediaManagementService mediaManagementService;
    private TransferProgressCallback progressCallback;
    private TransferStatusCallback statusCallback;
    private final Map<Long, Job> transferJobs = new LinkedHashMap();
    private final Map<Long, TransferStatusInfo> transferStatus = new LinkedHashMap();
    private final ConcurrentHashMap<Long, CompletableDeferred<AckResult>> pendingAcks = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Long, CompletableDeferred<StatusResult>> pendingStatusQueries = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Long, CompletableDeferred<Integer>> pendingMediaIdAllocations = new ConcurrentHashMap<>();

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[FileTransferCommand.values().length];
            try {
                iArr[FileTransferCommand.TRANSFER_ACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileTransferCommand.TRANSFER_NACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileTransferCommand.NEXT_CHUNK_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FileTransferCommand.RETRY_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FileTransferCommand.STATUS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FileTransferCommand.VERIFICATION_RESULT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FileTransferCommand.TRANSFER_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[FileTransferCommand.TRANSFER_STOP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[FileTransferCommand.TRANSFER_COMPLETE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[FileTransferCommand.FILE_DATA.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[FileTransferCommand.RECEIVED_CHECKSUM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[FileTransferCommand.TOTAL_TRANSFERRED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TransferStatus.values().length];
            try {
                iArr2[TransferStatus.TRANSFERRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[TransferStatus.COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[TransferStatus.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[TransferStatus.CANCELLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: com.baji.protocol.service.FileTransferService$handleNextChunkRequest$1, reason: invalid class name */
    @h70(c = "com.baji.protocol.service.FileTransferService$handleNextChunkRequest$1", f = "FileTransferService.kt", l = {722}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements or0 {
        final /* synthetic */ long $fileId;
        final /* synthetic */ int $requestedChunkIndex;
        int label;
        final /* synthetic */ FileTransferService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, FileTransferService fileTransferService, long j, x30 x30Var) {
            super(2, x30Var);
            this.$requestedChunkIndex = i;
            this.this$0 = fileTransferService;
            this.$fileId = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new AnonymousClass1(this.$requestedChunkIndex, this.this$0, this.$fileId, x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            try {
                if (i == 0) {
                    d.b(obj);
                    Log.d("FileTransferService", "开始发送数据块 " + this.$requestedChunkIndex);
                    FileTransferService fileTransferService = this.this$0;
                    long j = this.$fileId;
                    int i2 = this.$requestedChunkIndex;
                    this.label = 1;
                    obj = fileTransferService.sendSpecificChunk(j, i2, this);
                    if (obj == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d.b(obj);
                }
                if (((Boolean) obj).booleanValue()) {
                    this.this$0.updateTransferStatus(this.$fileId, TransferStatus.TRANSFERRING, ErrorCode.SUCCESS, "Chunk " + this.$requestedChunkIndex + " sent successfully");
                } else {
                    this.this$0.updateTransferStatus(this.$fileId, TransferStatus.FAILED, ErrorCode.UNKNOWN_ERROR, "Failed to send chunk " + this.$requestedChunkIndex);
                }
            } catch (Exception e) {
                Log.e("FileTransferService", "处理下一个数据块请求失败", e);
                this.this$0.updateTransferStatus(this.$fileId, TransferStatus.FAILED, ErrorCode.UNKNOWN_ERROR, "Failed to process chunk request: " + e.getMessage());
            }
            return k83.a;
        }

        @Override // defpackage.or0
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((AnonymousClass1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    /* JADX INFO: renamed from: com.baji.protocol.service.FileTransferService$handleRetryRequest$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "com.baji.protocol.service.FileTransferService$handleRetryRequest$1", f = "FileTransferService.kt", l = {766}, m = "invokeSuspend")
    static final class C01841 extends SuspendLambda implements or0 {
        final /* synthetic */ long $fileId;
        final /* synthetic */ int $retryChunkIndex;
        int label;
        final /* synthetic */ FileTransferService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01841(int i, FileTransferService fileTransferService, long j, x30 x30Var) {
            super(2, x30Var);
            this.$retryChunkIndex = i;
            this.this$0 = fileTransferService;
            this.$fileId = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new C01841(this.$retryChunkIndex, this.this$0, this.$fileId, x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            try {
                if (i == 0) {
                    d.b(obj);
                    Log.d("FileTransferService", "开始重传数据块 " + this.$retryChunkIndex);
                    this.this$0.updateTransferStatus(this.$fileId, TransferStatus.TRANSFERRING, ErrorCode.SUCCESS, "Retrying chunk: " + this.$retryChunkIndex);
                    FileTransferService fileTransferService = this.this$0;
                    long j = this.$fileId;
                    int i2 = this.$retryChunkIndex;
                    this.label = 1;
                    obj = fileTransferService.sendSpecificChunk(j, i2, this);
                    if (obj == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d.b(obj);
                }
                if (((Boolean) obj).booleanValue()) {
                    this.this$0.updateTransferStatus(this.$fileId, TransferStatus.TRANSFERRING, ErrorCode.SUCCESS, "Chunk " + this.$retryChunkIndex + " retried successfully");
                    jn.b(Log.d("FileTransferService", "重传数据块 " + this.$retryChunkIndex + " 完成"));
                } else {
                    this.this$0.updateTransferStatus(this.$fileId, TransferStatus.FAILED, ErrorCode.UNKNOWN_ERROR, "Failed to retry chunk " + this.$retryChunkIndex);
                }
            } catch (Exception e) {
                Log.e("FileTransferService", "处理重试请求失败", e);
                this.this$0.updateTransferStatus(this.$fileId, TransferStatus.FAILED, ErrorCode.UNKNOWN_ERROR, "Failed to retry chunk: " + e.getMessage());
            }
            return k83.a;
        }

        @Override // defpackage.or0
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((C01841) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    /* JADX INFO: renamed from: com.baji.protocol.service.FileTransferService$performStandardTransfer$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "com.baji.protocol.service.FileTransferService", f = "FileTransferService.kt", l = {1083, 1089}, m = "performStandardTransfer")
    static final class C01851 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01851(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileTransferService.this.performStandardTransfer(null, this);
        }
    }

    /* JADX INFO: renamed from: com.baji.protocol.service.FileTransferService$queryTransferStatus$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "com.baji.protocol.service.FileTransferService", f = "FileTransferService.kt", l = {684}, m = "queryTransferStatus")
    static final class C01861 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01861(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileTransferService.this.queryTransferStatus(0L, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.baji.protocol.service.FileTransferService$queryTransferStatus$2, reason: invalid class name */
    @h70(c = "com.baji.protocol.service.FileTransferService$queryTransferStatus$2", f = "FileTransferService.kt", l = {685}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements or0 {
        final /* synthetic */ CompletableDeferred<StatusResult> $deferred;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(CompletableDeferred<StatusResult> completableDeferred, x30 x30Var) {
            super(2, x30Var);
            this.$deferred = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new AnonymousClass2(this.$deferred, x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            if (i == 0) {
                d.b(obj);
                CompletableDeferred<StatusResult> completableDeferred = this.$deferred;
                this.label = 1;
                obj = completableDeferred.await(this);
                if (obj == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
            }
            return obj;
        }

        @Override // defpackage.or0
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((AnonymousClass2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    /* JADX INFO: renamed from: com.baji.protocol.service.FileTransferService$requestMediaIdAllocation$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "com.baji.protocol.service.FileTransferService", f = "FileTransferService.kt", l = {262}, m = "requestMediaIdAllocation")
    static final class C01871 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01871(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileTransferService.this.requestMediaIdAllocation(0L, this);
        }
    }

    /* JADX INFO: renamed from: com.baji.protocol.service.FileTransferService$requestMediaIdAllocation$2, reason: invalid class name and case insensitive filesystem */
    @h70(c = "com.baji.protocol.service.FileTransferService$requestMediaIdAllocation$2", f = "FileTransferService.kt", l = {263}, m = "invokeSuspend")
    static final class C01882 extends SuspendLambda implements or0 {
        final /* synthetic */ CompletableDeferred<Integer> $deferred;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01882(CompletableDeferred<Integer> completableDeferred, x30 x30Var) {
            super(2, x30Var);
            this.$deferred = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new C01882(this.$deferred, x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            if (i == 0) {
                d.b(obj);
                CompletableDeferred<Integer> completableDeferred = this.$deferred;
                this.label = 1;
                obj = completableDeferred.await(this);
                if (obj == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
            }
            return obj;
        }

        @Override // defpackage.or0
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((C01882) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    /* JADX INFO: renamed from: com.baji.protocol.service.FileTransferService$sendChunkWithAck$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "com.baji.protocol.service.FileTransferService", f = "FileTransferService.kt", l = {642, 653, 665}, m = "sendChunkWithAck")
    static final class C01891 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C01891(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileTransferService.this.sendChunkWithAck(0L, 0, null, false, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.baji.protocol.service.FileTransferService$sendSpecificChunk$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "com.baji.protocol.service.FileTransferService", f = "FileTransferService.kt", l = {1147}, m = "sendSpecificChunk")
    static final class C01901 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        C01901(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileTransferService.this.sendSpecificChunk(0L, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.baji.protocol.service.FileTransferService$transferFileWithAck$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "com.baji.protocol.service.FileTransferService", f = "FileTransferService.kt", l = {360, 418}, m = "transferFileWithAck")
    static final class C01911 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        long J$1;
        long J$2;
        long J$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C01911(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileTransferService.this.transferFileWithAck(null, this);
        }
    }

    /* JADX INFO: renamed from: com.baji.protocol.service.FileTransferService$waitForTransferAck$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "com.baji.protocol.service.FileTransferService", f = "FileTransferService.kt", l = {604}, m = "waitForTransferAck")
    static final class C01921 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01921(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileTransferService.this.waitForTransferAck(0L, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.baji.protocol.service.FileTransferService$waitForTransferAck$2, reason: invalid class name and case insensitive filesystem */
    @h70(c = "com.baji.protocol.service.FileTransferService$waitForTransferAck$2", f = "FileTransferService.kt", l = {605}, m = "invokeSuspend")
    static final class C01932 extends SuspendLambda implements or0 {
        final /* synthetic */ CompletableDeferred<AckResult> $deferred;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01932(CompletableDeferred<AckResult> completableDeferred, x30 x30Var) {
            super(2, x30Var);
            this.$deferred = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new C01932(this.$deferred, x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            if (i == 0) {
                d.b(obj);
                CompletableDeferred<AckResult> completableDeferred = this.$deferred;
                this.label = 1;
                obj = completableDeferred.await(this);
                if (obj == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
            }
            return obj;
        }

        @Override // defpackage.or0
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((C01932) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    private final byte[] buildChunkPayload(ChunkInfo chunkInfo) {
        byte[] bArr = new byte[chunkInfo.getChunkData().length + 17];
        ProtocolEncoder protocolEncoder = ProtocolEncoder.INSTANCE;
        System.arraycopy(protocolEncoder.longToBytes(chunkInfo.getFileId()), 0, bArr, 0, 8);
        System.arraycopy(protocolEncoder.intToBytes(chunkInfo.getChunkIndex()), 0, bArr, 8, 4);
        System.arraycopy(protocolEncoder.intToBytes(chunkInfo.getChunkSize()), 0, bArr, 12, 4);
        bArr[16] = chunkInfo.isLastChunk();
        System.arraycopy(chunkInfo.getChunkData(), 0, bArr, 17, chunkInfo.getChunkData().length);
        return bArr;
    }

    private final byte[] buildFileInfoPayload(TransferFileInfo transferFileInfo) {
        byte[] bArr = new byte[14];
        bArr[0] = 7;
        ProtocolEncoder protocolEncoder = ProtocolEncoder.INSTANCE;
        System.arraycopy(protocolEncoder.intToBytes((int) transferFileInfo.getFileSize()), 0, bArr, 1, 4);
        bArr[5] = 8;
        bArr[6] = transferFileInfo.getFileType().getValue();
        bArr[7] = 10;
        bArr[8] = transferFileInfo.getFunctionType().getValue();
        bArr[9] = 9;
        System.arraycopy(protocolEncoder.intToBytes(transferFileInfo.getMediaId()), 0, bArr, 10, 4);
        return bArr;
    }

    private final int calculateFileChecksum(File file) {
        try {
            return Crc32Utils.INSTANCE.calculateCrc32(file);
        } catch (Exception e) {
            Log.e("FileTransferService", "计算校验和失败", e);
            return 0;
        }
    }

    public static /* synthetic */ TransferFileInfo createTransferFileInfo$default(FileTransferService fileTransferService, int i, long j, FileType fileType, FunctionType functionType, String str, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            str = Constants.STR_EMPTY;
        }
        return fileTransferService.createTransferFileInfo(i, j, fileType, functionType, str);
    }

    private final void handleNextChunkRequest(byte[] bArr) {
        if (bArr.length < 8) {
            Log.w("FileTransferService", "下一个数据块请求载荷长度不足");
            return;
        }
        ProtocolEncoder protocolEncoder = ProtocolEncoder.INSTANCE;
        long jBytesToLong = protocolEncoder.bytesToLong(bArr, 0);
        int iBytesToInt = bArr.length >= 12 ? protocolEncoder.bytesToInt(bArr, 8) : 0;
        Log.d("FileTransferService", "收到下一个数据块请求: fileId=" + jBytesToLong + ", chunkIndex=" + iBytesToInt);
        if (this.transferJobs.containsKey(Long.valueOf(jBytesToLong))) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(iBytesToInt, this, jBytesToLong, null), 3, null);
            return;
        }
        Log.w("FileTransferService", "未找到文件ID " + jBytesToLong + " 的传输任务");
    }

    private final void handleRetryRequest(byte[] bArr) {
        if (bArr.length < 8) {
            Log.w("FileTransferService", "重试请求载荷长度不足");
            return;
        }
        ProtocolEncoder protocolEncoder = ProtocolEncoder.INSTANCE;
        long jBytesToLong = protocolEncoder.bytesToLong(bArr, 0);
        int iBytesToInt = bArr.length >= 12 ? protocolEncoder.bytesToInt(bArr, 8) : 0;
        Log.d("FileTransferService", "收到重试请求: fileId=" + jBytesToLong + ", chunkIndex=" + iBytesToInt);
        if (this.transferJobs.containsKey(Long.valueOf(jBytesToLong))) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C01841(iBytesToInt, this, jBytesToLong, null), 3, null);
            return;
        }
        Log.w("FileTransferService", "未找到文件ID " + jBytesToLong + " 的传输任务");
    }

    private final void handleStatusRequest(byte[] bArr) {
        Log.d("FileTransferService", "收到状态请求");
        if (this.transferStatus.isEmpty()) {
            sendStatusResponse(new TransferStatusInfo(0L, TransferStatus.IDLE, ErrorCode.SUCCESS, "No active transfers", 0L, 16, null));
            return;
        }
        Iterator<T> it = this.transferStatus.values().iterator();
        while (it.hasNext()) {
            sendStatusResponse((TransferStatusInfo) it.next());
        }
    }

    private final void handleStatusResponse(byte[] bArr) {
        TransferStatus transferStatus;
        if (bArr.length < 1) {
            Log.w("FileTransferService", "状态响应载荷长度不足，期望1字节，实际" + bArr.length + "字节");
            return;
        }
        TransferStatus[] transferStatusArrValues = TransferStatus.values();
        int length = transferStatusArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                transferStatus = null;
                break;
            }
            transferStatus = transferStatusArrValues[i];
            if (transferStatus.getValue() == bArr[0]) {
                break;
            } else {
                i++;
            }
        }
        if (transferStatus == null) {
            transferStatus = TransferStatus.IDLE;
        }
        TransferStatus transferStatus2 = transferStatus;
        Log.d("FileTransferService", "收到状态响应: status=" + transferStatus2);
        Long l = (Long) j.I(getActiveTransferFileIds());
        long jLongValue = l != null ? l.longValue() : 0L;
        CompletableDeferred<StatusResult> completableDeferred = this.pendingStatusQueries.get(Long.valueOf(jLongValue));
        if (completableDeferred != null && !completableDeferred.isCompleted()) {
            int i2 = WhenMappings.$EnumSwitchMapping$1[transferStatus2.ordinal()];
            if (i2 == 1 || i2 == 2) {
                completableDeferred.complete(new StatusResult.Success(transferStatus2));
            } else if (i2 == 3 || i2 == 4) {
                completableDeferred.complete(new StatusResult.Failed("Transfer failed: " + transferStatus2));
            } else {
                completableDeferred.complete(new StatusResult.Success(transferStatus2));
            }
            this.pendingStatusQueries.remove(Long.valueOf(jLongValue));
        }
        if (jLongValue > 0) {
            updateTransferStatus(jLongValue, transferStatus2, ErrorCode.SUCCESS, "Status from device");
        }
    }

    private final void handleTransferAck(byte[] bArr) {
        if (bArr.length < 8) {
            Log.w("FileTransferService", "ACK载荷长度不足");
            return;
        }
        ProtocolEncoder protocolEncoder = ProtocolEncoder.INSTANCE;
        long jBytesToLong = protocolEncoder.bytesToLong(bArr, 0);
        int iBytesToInt = bArr.length >= 12 ? protocolEncoder.bytesToInt(bArr, 8) : -1;
        Log.d("FileTransferService", "收到传输确认: fileId=" + jBytesToLong + ", chunkIndex=" + iBytesToInt);
        CompletableDeferred<AckResult> completableDeferred = this.pendingAcks.get(Long.valueOf(jBytesToLong));
        if (completableDeferred != null && !completableDeferred.isCompleted()) {
            completableDeferred.complete(AckResult.Success.INSTANCE);
            this.pendingAcks.remove(Long.valueOf(jBytesToLong));
        }
        TransferStatusInfo transferStatusInfo = this.transferStatus.get(Long.valueOf(jBytesToLong));
        if (transferStatusInfo == null || transferStatusInfo.getStatus() != TransferStatus.TRANSFERRING) {
            return;
        }
        Log.d("FileTransferService", "数据块 " + iBytesToInt + " 确认成功");
    }

    private final void handleTransferNack(byte[] bArr) {
        if (bArr.length < 8) {
            Log.w("FileTransferService", "NACK载荷长度不足");
            return;
        }
        ProtocolEncoder protocolEncoder = ProtocolEncoder.INSTANCE;
        long jBytesToLong = protocolEncoder.bytesToLong(bArr, 0);
        ErrorCode errorCodeFromValue = bArr.length >= 12 ? ErrorCode.Companion.fromValue(protocolEncoder.bytesToInt(bArr, 8)) : ErrorCode.UNKNOWN_ERROR;
        String str = bArr.length > 12 ? new String(bArr, 12, bArr.length - 12, gx.b) : "Transfer rejected by device";
        Log.w("FileTransferService", "收到传输拒绝: fileId=" + jBytesToLong + ", errorCode=" + errorCodeFromValue + ", message=" + str);
        CompletableDeferred<AckResult> completableDeferred = this.pendingAcks.get(Long.valueOf(jBytesToLong));
        if (completableDeferred != null && !completableDeferred.isCompleted()) {
            completableDeferred.complete(new AckResult.Rejected(errorCodeFromValue, str));
            this.pendingAcks.remove(Long.valueOf(jBytesToLong));
        }
        updateTransferStatus(jBytesToLong, TransferStatus.FAILED, errorCodeFromValue, str);
        TransferErrorCallback transferErrorCallback = this.errorCallback;
        if (transferErrorCallback != null) {
            transferErrorCallback.onError(jBytesToLong, errorCodeFromValue, str);
        }
    }

    private final void handleVerificationRequest(byte[] bArr) {
        if (bArr.length < 8) {
            Log.w("FileTransferService", "验证结果请求载荷长度不足");
            return;
        }
        long jBytesToLong = ProtocolEncoder.INSTANCE.bytesToLong(bArr, 0);
        Log.d("FileTransferService", "收到验证结果请求: fileId=" + jBytesToLong);
        TransferStatusInfo transferStatusInfo = this.transferStatus.get(Long.valueOf(jBytesToLong));
        if (transferStatusInfo != null) {
            sendVerificationResult(jBytesToLong, WhenMappings.$EnumSwitchMapping$1[transferStatusInfo.getStatus().ordinal()] == 2);
            return;
        }
        Log.w("FileTransferService", "未找到文件ID " + jBytesToLong + " 的传输状态");
        sendVerificationResult(jBytesToLong, false);
    }

    private final void handleVerificationResult(byte[] bArr) {
        if (bArr.length < 9) {
            Log.w("FileTransferService", "验证结果响应载荷长度不足");
            return;
        }
        long jBytesToLong = ProtocolEncoder.INSTANCE.bytesToLong(bArr, 0);
        boolean z = bArr[8] == 1;
        Log.d("FileTransferService", "收到验证结果响应: fileId=" + jBytesToLong + ", result=" + z);
        if (z) {
            updateTransferStatus(jBytesToLong, TransferStatus.COMPLETED, ErrorCode.SUCCESS, "File verification successful");
            return;
        }
        TransferStatus transferStatus = TransferStatus.FAILED;
        ErrorCode errorCode = ErrorCode.VERIFICATION_FAILED;
        updateTransferStatus(jBytesToLong, transferStatus, errorCode, "File verification failed");
        TransferErrorCallback transferErrorCallback = this.errorCallback;
        if (transferErrorCallback != null) {
            transferErrorCallback.onError(jBytesToLong, errorCode, "File verification failed");
        }
    }

    public static /* synthetic */ void initialize$default(FileTransferService fileTransferService, TransferProgressCallback transferProgressCallback, TransferStatusCallback transferStatusCallback, TransferErrorCallback transferErrorCallback, PacketSendCallback packetSendCallback, or0 or0Var, MediaManagementService mediaManagementService, int i, Object obj) {
        if ((i & 1) != 0) {
            transferProgressCallback = null;
        }
        if ((i & 2) != 0) {
            transferStatusCallback = null;
        }
        if ((i & 4) != 0) {
            transferErrorCallback = null;
        }
        if ((i & 8) != 0) {
            packetSendCallback = null;
        }
        if ((i & 16) != 0) {
            or0Var = null;
        }
        if ((i & 32) != 0) {
            mediaManagementService = null;
        }
        fileTransferService.initialize(transferProgressCallback, transferStatusCallback, transferErrorCallback, packetSendCallback, or0Var, mediaManagementService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x009d A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:14:0x0037, B:30:0x0097, B:32:0x009d, B:35:0x00b9, B:37:0x00bd, B:39:0x00cf, B:40:0x00d6, B:42:0x00da, B:44:0x0103, B:45:0x0123, B:46:0x0128), top: B:54:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00b8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x00b9 A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:14:0x0037, B:30:0x0097, B:32:0x009d, B:35:0x00b9, B:37:0x00bd, B:39:0x00cf, B:40:0x00d6, B:42:0x00da, B:44:0x0103, B:45:0x0123, B:46:0x0128), top: B:54:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00bd A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:14:0x0037, B:30:0x0097, B:32:0x009d, B:35:0x00b9, B:37:0x00bd, B:39:0x00cf, B:40:0x00d6, B:42:0x00da, B:44:0x0103, B:45:0x0123, B:46:0x0128), top: B:54:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00cf A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:14:0x0037, B:30:0x0097, B:32:0x009d, B:35:0x00b9, B:37:0x00bd, B:39:0x00cf, B:40:0x00d6, B:42:0x00da, B:44:0x0103, B:45:0x0123, B:46:0x0128), top: B:54:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00d6 A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:14:0x0037, B:30:0x0097, B:32:0x009d, B:35:0x00b9, B:37:0x00bd, B:39:0x00cf, B:40:0x00d6, B:42:0x00da, B:44:0x0103, B:45:0x0123, B:46:0x0128), top: B:54:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00da A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:14:0x0037, B:30:0x0097, B:32:0x009d, B:35:0x00b9, B:37:0x00bd, B:39:0x00cf, B:40:0x00d6, B:42:0x00da, B:44:0x0103, B:45:0x0123, B:46:0x0128), top: B:54:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0103 A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:14:0x0037, B:30:0x0097, B:32:0x009d, B:35:0x00b9, B:37:0x00bd, B:39:0x00cf, B:40:0x00d6, B:42:0x00da, B:44:0x0103, B:45:0x0123, B:46:0x0128), top: B:54:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0123 A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:14:0x0037, B:30:0x0097, B:32:0x009d, B:35:0x00b9, B:37:0x00bd, B:39:0x00cf, B:40:0x00d6, B:42:0x00da, B:44:0x0103, B:45:0x0123, B:46:0x0128), top: B:54:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0156  */
    /* JADX WARN: Instruction removed from duplicated block: B:42:0x00da, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:44:0x0103, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:51:0x0156, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v8, types: [long] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object performStandardTransfer(TransferFileInfo transferFileInfo, x30 x30Var) throws Throwable {
        C01851 c01851;
        FileTransferService fileTransferService;
        ErrorCode errorCode;
        TransferErrorCallback transferErrorCallback;
        TransferFileInfo transferFileInfo2;
        FileTransferService fileTransferService2;
        long j;
        AckResult ackResult;
        TransferErrorCallback transferErrorCallback2;
        ErrorCode errorCode2;
        TransferErrorCallback transferErrorCallback3;
        int i;
        if (!(x30Var instanceof C01851) || (fileTransferService = (i = (c01851 = (C01851) x30Var).label) & Integer.MIN_VALUE) == 0) {
            c01851 = new C01851(x30Var);
        } else {
            c01851.label = i - Integer.MIN_VALUE;
        }
        C01851 c01852 = c01851;
        Object objWaitForTransferAck = c01852.result;
        Object objD = a.d();
        long j2 = c01852.label;
        try {
            if (j2 == 0) {
                d.b(objWaitForTransferAck);
                long mediaId = transferFileInfo.getMediaId();
                try {
                    sendPacket(ModuleId.FILE_TRANSFER, FileTransferCommand.TRANSFER_START.getValue(), buildFileInfoPayload(transferFileInfo));
                    updateTransferStatus(mediaId, TransferStatus.PREPARING, ErrorCode.SUCCESS, "Waiting for device confirmation");
                    c01852.L$0 = this;
                    transferFileInfo2 = transferFileInfo;
                    c01852.L$1 = transferFileInfo2;
                    c01852.J$0 = mediaId;
                    c01852.label = 1;
                    objWaitForTransferAck = waitForTransferAck(mediaId, 30000L, c01852);
                    if (objWaitForTransferAck == objD) {
                        return objD;
                    }
                    fileTransferService2 = this;
                    j = mediaId;
                    ackResult = (AckResult) objWaitForTransferAck;
                    if (ackResult instanceof AckResult.Success) {
                        fileTransferService2.updateTransferStatus(j, TransferStatus.TRANSFERRING, ErrorCode.SUCCESS, "Device confirmed, starting transfer");
                        c01852.L$0 = fileTransferService2;
                        c01852.L$1 = null;
                        c01852.J$0 = j;
                        c01852.label = 2;
                        if (fileTransferService2.transferFileWithAck(transferFileInfo2, c01852) == objD) {
                            return objD;
                        }
                    } else if (ackResult instanceof AckResult.Timeout) {
                        TransferStatus transferStatus = TransferStatus.FAILED;
                        errorCode2 = ErrorCode.TRANSFER_TIMEOUT;
                        fileTransferService2.updateTransferStatus(j, transferStatus, errorCode2, "Device confirmation timeout");
                        transferErrorCallback3 = fileTransferService2.errorCallback;
                        if (transferErrorCallback3 != null) {
                            transferErrorCallback3.onError(j, errorCode2, "Device did not respond to transfer start");
                        }
                    } else {
                        if (ackResult instanceof AckResult.Rejected) {
                            throw new NoWhenBranchMatchedException();
                        }
                        fileTransferService2.updateTransferStatus(j, TransferStatus.FAILED, ((AckResult.Rejected) ackResult).getErrorCode(), "Device rejected transfer: " + ((AckResult.Rejected) ackResult).getMessage());
                        transferErrorCallback2 = fileTransferService2.errorCallback;
                        if (transferErrorCallback2 != null) {
                            transferErrorCallback2.onError(j, ((AckResult.Rejected) ackResult).getErrorCode(), "Device rejected transfer: " + ((AckResult.Rejected) ackResult).getMessage());
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    fileTransferService = this;
                    j2 = mediaId;
                    Log.e("FileTransferService", "标准传输流程失败", e);
                    TransferStatus transferStatus2 = TransferStatus.FAILED;
                    errorCode = ErrorCode.UNKNOWN_ERROR;
                    fileTransferService.updateTransferStatus(j2, transferStatus2, errorCode, "Transfer failed: " + e.getMessage());
                    transferErrorCallback = fileTransferService.errorCallback;
                    if (transferErrorCallback != null) {
                        transferErrorCallback.onError(j2, errorCode, "Transfer failed: " + e.getMessage());
                    }
                }
            } else if (j2 == 1) {
                j2 = c01852.J$0;
                TransferFileInfo transferFileInfo3 = (TransferFileInfo) c01852.L$1;
                FileTransferService fileTransferService3 = (FileTransferService) c01852.L$0;
                try {
                    d.b(objWaitForTransferAck);
                    transferFileInfo2 = transferFileInfo3;
                    fileTransferService2 = fileTransferService3;
                    j = j2;
                    ackResult = (AckResult) objWaitForTransferAck;
                    if (ackResult instanceof AckResult.Success) {
                        fileTransferService2.updateTransferStatus(j, TransferStatus.TRANSFERRING, ErrorCode.SUCCESS, "Device confirmed, starting transfer");
                        c01852.L$0 = fileTransferService2;
                        c01852.L$1 = null;
                        c01852.J$0 = j;
                        c01852.label = 2;
                        if (fileTransferService2.transferFileWithAck(transferFileInfo2, c01852) == objD) {
                            return objD;
                        }
                    } else if (ackResult instanceof AckResult.Timeout) {
                        TransferStatus transferStatus3 = TransferStatus.FAILED;
                        errorCode2 = ErrorCode.TRANSFER_TIMEOUT;
                        fileTransferService2.updateTransferStatus(j, transferStatus3, errorCode2, "Device confirmation timeout");
                        transferErrorCallback3 = fileTransferService2.errorCallback;
                        if (transferErrorCallback3 != null) {
                            transferErrorCallback3.onError(j, errorCode2, "Device did not respond to transfer start");
                        }
                    } else {
                        if (ackResult instanceof AckResult.Rejected) {
                            throw new NoWhenBranchMatchedException();
                        }
                        fileTransferService2.updateTransferStatus(j, TransferStatus.FAILED, ((AckResult.Rejected) ackResult).getErrorCode(), "Device rejected transfer: " + ((AckResult.Rejected) ackResult).getMessage());
                        transferErrorCallback2 = fileTransferService2.errorCallback;
                        if (transferErrorCallback2 != null) {
                            transferErrorCallback2.onError(j, ((AckResult.Rejected) ackResult).getErrorCode(), "Device rejected transfer: " + ((AckResult.Rejected) ackResult).getMessage());
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileTransferService = fileTransferService3;
                    Log.e("FileTransferService", "标准传输流程失败", e);
                    TransferStatus transferStatus4 = TransferStatus.FAILED;
                    errorCode = ErrorCode.UNKNOWN_ERROR;
                    fileTransferService.updateTransferStatus(j2, transferStatus4, errorCode, "Transfer failed: " + e.getMessage());
                    transferErrorCallback = fileTransferService.errorCallback;
                    if (transferErrorCallback != null) {
                        transferErrorCallback.onError(j2, errorCode, "Transfer failed: " + e.getMessage());
                    }
                }
            } else {
                if (j2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                long j3 = c01852.J$0;
                d.b(objWaitForTransferAck);
            }
        } catch (Exception e3) {
            e = e3;
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object queryTransferStatus(long j, long j2, x30 x30Var) throws Throwable {
        C01861 c01861;
        FileTransferService fileTransferService;
        if (x30Var instanceof C01861) {
            c01861 = (C01861) x30Var;
            int i = c01861.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01861.label = i - Integer.MIN_VALUE;
            } else {
                c01861 = new C01861(x30Var);
            }
        } else {
            c01861 = new C01861(x30Var);
        }
        Object objWithTimeout = c01861.result;
        Object objD = a.d();
        int i2 = c01861.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c01861.J$0;
            fileTransferService = (FileTransferService) c01861.L$0;
            try {
                d.b(objWithTimeout);
            } catch (TimeoutCancellationException unused) {
                fileTransferService.pendingStatusQueries.remove(jn.c(j));
                return StatusResult.Timeout.INSTANCE;
            } catch (Exception e) {
                e = e;
                fileTransferService.pendingStatusQueries.remove(jn.c(j));
                return new StatusResult.Failed("Status query failed: " + e.getMessage());
            }
        }
        d.b(objWithTimeout);
        CompletableDeferred<StatusResult> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.pendingStatusQueries.put(jn.c(j), completableDeferredCompletableDeferred$default);
        try {
            sendPacket(ModuleId.FILE_TRANSFER, FileTransferCommand.STATUS.getValue(), new byte[0]);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(completableDeferredCompletableDeferred$default, null);
            c01861.L$0 = this;
            c01861.J$0 = j;
            c01861.label = 1;
            objWithTimeout = TimeoutKt.withTimeout(j2, anonymousClass2, c01861);
            return objWithTimeout == objD ? objD : objWithTimeout;
        } catch (TimeoutCancellationException unused2) {
            fileTransferService = this;
            fileTransferService.pendingStatusQueries.remove(jn.c(j));
            return StatusResult.Timeout.INSTANCE;
        } catch (Exception e2) {
            e = e2;
            fileTransferService = this;
            fileTransferService.pendingStatusQueries.remove(jn.c(j));
            return new StatusResult.Failed("Status query failed: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object requestMediaIdAllocation(long j, x30 x30Var) throws Throwable {
        C01871 c01871;
        FileTransferService fileTransferService;
        if (x30Var instanceof C01871) {
            c01871 = (C01871) x30Var;
            int i = c01871.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01871.label = i - Integer.MIN_VALUE;
            } else {
                c01871 = new C01871(x30Var);
            }
        } else {
            c01871 = new C01871(x30Var);
        }
        Object objWithTimeout = c01871.result;
        Object objD = a.d();
        int i2 = c01871.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c01871.J$0;
            fileTransferService = (FileTransferService) c01871.L$0;
            try {
                d.b(objWithTimeout);
            } catch (TimeoutCancellationException unused) {
                fileTransferService.pendingMediaIdAllocations.remove(jn.c(j));
                Log.w("FileTransferService", "Media ID allocation timeout");
                return jn.b(-1);
            } catch (Exception e) {
                e = e;
                fileTransferService.pendingMediaIdAllocations.remove(jn.c(j));
                Log.e("FileTransferService", "Media ID allocation failed", e);
                return jn.b(-1);
            }
        }
        d.b(objWithTimeout);
        CompletableDeferred<Integer> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.pendingMediaIdAllocations.put(jn.c(j), completableDeferredCompletableDeferred$default);
        try {
            MediaManagementService mediaManagementService = this.mediaManagementService;
            if (mediaManagementService != null) {
                mediaManagementService.requestMediaId();
            }
            C01882 c01882 = new C01882(completableDeferredCompletableDeferred$default, null);
            c01871.L$0 = this;
            c01871.J$0 = j;
            c01871.label = 1;
            objWithTimeout = TimeoutKt.withTimeout(30000L, c01882, c01871);
            return objWithTimeout == objD ? objD : objWithTimeout;
        } catch (TimeoutCancellationException unused2) {
            fileTransferService = this;
            fileTransferService.pendingMediaIdAllocations.remove(jn.c(j));
            Log.w("FileTransferService", "Media ID allocation timeout");
            return jn.b(-1);
        } catch (Exception e2) {
            e = e2;
            fileTransferService = this;
            fileTransferService.pendingMediaIdAllocations.remove(jn.c(j));
            Log.e("FileTransferService", "Media ID allocation failed", e);
            return jn.b(-1);
        }
    }

    private final void sendBroadcastEvent(BajiBaseEvent bajiBaseEvent) {
        Log.d("FileTransferService", "发送事件: " + bajiBaseEvent.getEventType());
    }

    private final void sendChunk(ChunkInfo chunkInfo) {
        sendPacket(ModuleId.FILE_TRANSFER, FileTransferCommand.FILE_DATA.getValue(), buildChunkPayload(chunkInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x00f1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:40:0x0130  */
    /* JADX WARN: Code duplicated, block: B:43:0x0156 A[Catch: Exception -> 0x0188, TRY_LEAVE, TryCatch #2 {Exception -> 0x0188, blocks: (B:41:0x0132, B:43:0x0156), top: B:92:0x0132 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0171 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x0172  */
    /* JADX WARN: Code duplicated, block: B:62:0x018d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:88:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0102 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0086: MOVE (r6 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:20:0x0083 */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0087: MOVE (r14 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]), block:B:20:0x0083 */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0085: MOVE (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:20:0x0083 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x018d -> B:26:0x00ba). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x022b -> B:26:0x00ba). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object sendChunkWithAck(long r27, int r29, byte[] r30, boolean r31, int r32, defpackage.x30 r33) {
        /*
            Method dump skipped, instruction units count: 573
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baji.protocol.service.FileTransferService.sendChunkWithAck(long, int, byte[], boolean, int, x30):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x00d0 A[Catch: Exception -> 0x00ed, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x00ed, blocks: (B:34:0x00c8, B:37:0x00d0, B:31:0x00c1), top: B:62:0x00c1 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00f1 A[Catch: Exception -> 0x00eb, TryCatch #3 {Exception -> 0x00eb, blocks: (B:39:0x00e6, B:44:0x00f1, B:46:0x00f7, B:48:0x0111, B:50:0x0115, B:52:0x0139, B:53:0x013e), top: B:64:0x00ce }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00f7 A[Catch: Exception -> 0x00eb, TryCatch #3 {Exception -> 0x00eb, blocks: (B:39:0x00e6, B:44:0x00f1, B:46:0x00f7, B:48:0x0111, B:50:0x0115, B:52:0x0139, B:53:0x013e), top: B:64:0x00ce }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0111 A[Catch: Exception -> 0x00eb, TryCatch #3 {Exception -> 0x00eb, blocks: (B:39:0x00e6, B:44:0x00f1, B:46:0x00f7, B:48:0x0111, B:50:0x0115, B:52:0x0139, B:53:0x013e), top: B:64:0x00ce }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0115 A[Catch: Exception -> 0x00eb, TryCatch #3 {Exception -> 0x00eb, blocks: (B:39:0x00e6, B:44:0x00f1, B:46:0x00f7, B:48:0x0111, B:50:0x0115, B:52:0x0139, B:53:0x013e), top: B:64:0x00ce }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0139 A[Catch: Exception -> 0x00eb, TryCatch #3 {Exception -> 0x00eb, blocks: (B:39:0x00e6, B:44:0x00f1, B:46:0x00f7, B:48:0x0111, B:50:0x0115, B:52:0x0139, B:53:0x013e), top: B:64:0x00ce }] */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Instruction removed from duplicated block: B:37:0x00d0, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:46:0x00f7, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:50:0x0115, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object sendSpecificChunk(long j, int i, x30 x30Var) throws Throwable {
        C01901 c01901;
        String str;
        boolean z;
        String str2;
        Object objQueryTransferStatus;
        String str3;
        StatusResult statusResult;
        boolean z2;
        String str4;
        boolean z3;
        int i2 = i;
        if (x30Var instanceof C01901) {
            c01901 = (C01901) x30Var;
            int i3 = c01901.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c01901.label = i3 - Integer.MIN_VALUE;
            } else {
                c01901 = new C01901(x30Var);
            }
        } else {
            c01901 = new C01901(x30Var);
        }
        C01901 c01902 = c01901;
        Object obj = c01902.result;
        Object objD = a.d();
        int i4 = c01902.label;
        boolean z4 = false;
        if (i4 == 0) {
            d.b(obj);
            try {
                if (this.transferStatus.get(jn.c(j)) == null) {
                    Log.w("FileTransferService", "未找到文件ID " + j + " 的传输状态");
                    return jn.a(false);
                }
                Log.d("FileTransferService", "发送数据块 " + i2 + "，文件ID: " + j);
                str = "FileTransferService";
                z = true;
                try {
                    sendChunk(new ChunkInfo(j, i, 1024, new byte[1024], false));
                    c01902.I$0 = i2;
                    c01902.label = 1;
                    str2 = "发送数据块 ";
                    try {
                        objQueryTransferStatus = queryTransferStatus(j, 5000L, c01902);
                        if (objQueryTransferStatus == objD) {
                            return objD;
                        }
                        statusResult = (StatusResult) objQueryTransferStatus;
                        z2 = statusResult instanceof StatusResult.Success;
                        if (z2) {
                            Log.d(str, "数据块 " + i2 + " 发送成功");
                            z3 = z;
                        } else {
                            str4 = str;
                            if (statusResult instanceof StatusResult.Timeout) {
                                Log.w(str4, "数据块 " + i2 + " 状态查询超时");
                            } else {
                                if (statusResult instanceof StatusResult.Failed) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                Log.e(str4, "数据块 " + i2 + " 发送失败: " + ((StatusResult.Failed) statusResult).getMessage());
                            }
                            z3 = false;
                        }
                        z4 = z3;
                    } catch (Exception e) {
                        e = e;
                        str3 = str;
                        Log.e(str3, str2 + i2 + " 失败", e);
                        return jn.a(z4);
                    }
                } catch (Exception e2) {
                    e = e2;
                    str2 = "发送数据块 ";
                    str3 = str;
                    Log.e(str3, str2 + i2 + " 失败", e);
                    return jn.a(z4);
                }
            } catch (Exception e3) {
                e = e3;
                str2 = "发送数据块 ";
                str3 = "FileTransferService";
                Log.e(str3, str2 + i2 + " 失败", e);
                return jn.a(z4);
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i5 = c01902.I$0;
            try {
                d.b(obj);
                i2 = i5;
                str2 = "发送数据块 ";
                str = "FileTransferService";
                objQueryTransferStatus = obj;
                z = true;
                statusResult = (StatusResult) objQueryTransferStatus;
                z2 = statusResult instanceof StatusResult.Success;
                try {
                    if (z2) {
                        Log.d(str, "数据块 " + i2 + " 发送成功");
                        z3 = z;
                    } else {
                        str4 = str;
                        if (statusResult instanceof StatusResult.Timeout) {
                            Log.w(str4, "数据块 " + i2 + " 状态查询超时");
                        } else {
                            if (statusResult instanceof StatusResult.Failed) {
                                throw new NoWhenBranchMatchedException();
                            }
                            Log.e(str4, "数据块 " + i2 + " 发送失败: " + ((StatusResult.Failed) statusResult).getMessage());
                        }
                        z3 = false;
                    }
                    z4 = z3;
                } catch (Exception e4) {
                    e = e4;
                    str3 = z2;
                    Log.e(str3, str2 + i2 + " 失败", e);
                }
            } catch (Exception e5) {
                e = e5;
                i2 = i5;
                str2 = "发送数据块 ";
                str3 = "FileTransferService";
                Log.e(str3, str2 + i2 + " 失败", e);
                return jn.a(z4);
            }
        }
        return jn.a(z4);
    }

    private final void sendStatusResponse(TransferStatusInfo transferStatusInfo) {
        sendPacket(ModuleId.FILE_TRANSFER, FileTransferCommand.STATUS.getValue(), new byte[]{transferStatusInfo.getStatus().getValue()});
    }

    private final void sendTransferCompleteWithChecksum(long j, int i) {
        byte[] bArr = new byte[12];
        ProtocolEncoder protocolEncoder = ProtocolEncoder.INSTANCE;
        System.arraycopy(protocolEncoder.longToBytes(j), 0, bArr, 0, 8);
        System.arraycopy(protocolEncoder.intToBytes(i), 0, bArr, 8, 4);
        sendPacket(ModuleId.FILE_TRANSFER, FileTransferCommand.TRANSFER_COMPLETE.getValue(), bArr);
        Log.d("FileTransferService", "发送传输完成通知: fileId=" + j + ", checksum=" + i);
    }

    private final void sendVerificationRequest(long j) {
        byte[] bArr = new byte[8];
        System.arraycopy(ProtocolEncoder.INSTANCE.longToBytes(j), 0, bArr, 0, 8);
        sendPacket(ModuleId.FILE_TRANSFER, FileTransferCommand.VERIFICATION_RESULT.getValue(), bArr);
        Log.d("FileTransferService", "发送验证结果请求: fileId=" + j);
    }

    private final void sendVerificationResult(long j, boolean z) {
        byte[] bArr = new byte[9];
        System.arraycopy(ProtocolEncoder.INSTANCE.longToBytes(j), 0, bArr, 0, 8);
        bArr[8] = z ? (byte) 1 : (byte) 0;
        sendPacket(ModuleId.FILE_TRANSFER, FileTransferCommand.VERIFICATION_RESULT.getValue(), bArr);
        Log.d("FileTransferService", "发送验证结果响应: fileId=" + j + ", success=" + z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x022f -> B:144:0x024d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 11481. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:99)
        */
    public final java.lang.Object transferFileWithAck(com.baji.protocol.model.TransferFileInfo r55, defpackage.x30 r56) {
        /*
            Method dump skipped, instruction units count: 1148
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baji.protocol.service.FileTransferService.transferFileWithAck(com.baji.protocol.model.TransferFileInfo, x30):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTransferStatus(long j, TransferStatus transferStatus, ErrorCode errorCode, String str) {
        TransferStatusInfo transferStatusInfo = new TransferStatusInfo(j, transferStatus, errorCode, str, 0L, 16, null);
        this.transferStatus.put(Long.valueOf(j), transferStatusInfo);
        TransferStatusCallback transferStatusCallback = this.statusCallback;
        if (transferStatusCallback != null) {
            transferStatusCallback.onStatusChanged(transferStatusInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object waitForTransferAck(long j, long j2, x30 x30Var) throws Throwable {
        C01921 c01921;
        FileTransferService fileTransferService;
        if (x30Var instanceof C01921) {
            c01921 = (C01921) x30Var;
            int i = c01921.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01921.label = i - Integer.MIN_VALUE;
            } else {
                c01921 = new C01921(x30Var);
            }
        } else {
            c01921 = new C01921(x30Var);
        }
        Object objWithTimeout = c01921.result;
        Object objD = a.d();
        int i2 = c01921.label;
        if (i2 == 0) {
            d.b(objWithTimeout);
            CompletableDeferred<AckResult> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            this.pendingAcks.put(jn.c(j), completableDeferredCompletableDeferred$default);
            try {
                C01932 c01932 = new C01932(completableDeferredCompletableDeferred$default, null);
                c01921.L$0 = this;
                c01921.J$0 = j;
                c01921.label = 1;
                objWithTimeout = TimeoutKt.withTimeout(j2, c01932, c01921);
                if (objWithTimeout == objD) {
                    return objD;
                }
                fileTransferService = this;
            } catch (TimeoutCancellationException unused) {
                fileTransferService = this;
                fileTransferService.pendingAcks.remove(jn.c(j));
                return AckResult.Timeout.INSTANCE;
            } catch (Exception unused2) {
                fileTransferService = this;
                fileTransferService.pendingAcks.remove(jn.c(j));
                return AckResult.Timeout.INSTANCE;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c01921.J$0;
            fileTransferService = (FileTransferService) c01921.L$0;
            try {
                d.b(objWithTimeout);
            } catch (TimeoutCancellationException unused3) {
                fileTransferService.pendingAcks.remove(jn.c(j));
                return AckResult.Timeout.INSTANCE;
            } catch (Exception unused4) {
                fileTransferService.pendingAcks.remove(jn.c(j));
                return AckResult.Timeout.INSTANCE;
            }
        }
        return (AckResult) objWithTimeout;
    }

    public final void cancelAllTransfers() {
        Iterator it = j.X(this.transferJobs.keySet()).iterator();
        while (it.hasNext()) {
            cancelTransfer(((Number) it.next()).longValue(), "Cancelled by user");
        }
    }

    public final void cancelTransfer(long j, String str) {
        p31.f(str, "reason");
        Job job = this.transferJobs.get(Long.valueOf(j));
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.transferJobs.remove(Long.valueOf(j));
        updateTransferStatus(j, TransferStatus.CANCELLED, ErrorCode.SUCCESS, str);
    }

    public final TransferFileInfo createTransferFileInfo(int i, long j, FileType fileType, FunctionType functionType, String str) {
        p31.f(fileType, "fileType");
        p31.f(functionType, "functionType");
        p31.f(str, "filePath");
        return new TransferFileInfo(i, j, fileType, functionType, str);
    }

    public final List<Long> getActiveTransferFileIds() {
        return j.X(this.transferJobs.keySet());
    }

    @Override // com.baji.protocol.service.BaseProtocolService
    public ModuleId getModuleId() {
        return ModuleId.FILE_TRANSFER;
    }

    public final List<TransferStatusInfo> getTransferStatus() {
        return j.X(this.transferStatus.values());
    }

    public final void handleMediaIdAllocation(long j, boolean z, String str) {
        Object next;
        p31.f(str, "message");
        if (!z) {
            Collection<CompletableDeferred<Integer>> collectionValues = this.pendingMediaIdAllocations.values();
            p31.e(collectionValues, "<get-values>(...)");
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                CompletableDeferred completableDeferred = (CompletableDeferred) it.next();
                if (!completableDeferred.isCompleted()) {
                    completableDeferred.complete(-1);
                }
            }
            this.pendingMediaIdAllocations.clear();
            Log.w("FileTransferService", "Media ID allocation failed: " + str);
            return;
        }
        Set<Map.Entry<Long, CompletableDeferred<Integer>>> setEntrySet = this.pendingMediaIdAllocations.entrySet();
        p31.e(setEntrySet, "<get-entries>(...)");
        Iterator<T> it2 = setEntrySet.iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!((CompletableDeferred) ((Map.Entry) next).getValue()).isActive());
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            ((CompletableDeferred) entry.getValue()).complete(Integer.valueOf((int) j));
            this.pendingMediaIdAllocations.remove(entry.getKey());
            Log.d("FileTransferService", "Media ID allocated: " + j);
        }
    }

    @Override // com.baji.protocol.service.BaseProtocolService
    public void handlePacket(byte b, byte[] bArr) {
        FileTransferCommand fileTransferCommand;
        p31.f(bArr, "payload");
        FileTransferCommand[] fileTransferCommandArrValues = FileTransferCommand.values();
        int length = fileTransferCommandArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                fileTransferCommand = null;
                break;
            }
            fileTransferCommand = fileTransferCommandArrValues[i];
            if (fileTransferCommand.getValue() == b) {
                break;
            } else {
                i++;
            }
        }
        switch (fileTransferCommand == null ? -1 : WhenMappings.$EnumSwitchMapping$0[fileTransferCommand.ordinal()]) {
            case -1:
                TransferErrorCallback transferErrorCallback = this.errorCallback;
                if (transferErrorCallback != null) {
                    transferErrorCallback.onError(0L, ErrorCode.UNSUPPORTED_COMMAND, "Unknown command: " + ((int) b));
                    return;
                }
                return;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                handleTransferAck(bArr);
                return;
            case 2:
                handleTransferNack(bArr);
                return;
            case 3:
                handleNextChunkRequest(bArr);
                return;
            case 4:
                handleRetryRequest(bArr);
                return;
            case 5:
                int length2 = bArr.length;
                if (length2 == 0) {
                    handleStatusRequest(bArr);
                    return;
                }
                if (length2 == 1) {
                    handleStatusResponse(bArr);
                    return;
                }
                Log.w("FileTransferService", "STATUS命令载荷长度不正确: " + bArr.length + "字节，期望0或1字节");
                return;
            case 6:
                int length3 = bArr.length;
                if (length3 == 8) {
                    handleVerificationRequest(bArr);
                    return;
                }
                if (length3 == 9) {
                    handleVerificationResult(bArr);
                    return;
                }
                Log.w("FileTransferService", "VERIFICATION_RESULT命令载荷长度不正确: " + bArr.length + "字节，期望8或9字节");
                return;
            case 7:
                Log.w("FileTransferService", "APP端不应接收TRANSFER_START命令");
                return;
            case 8:
                Log.w("FileTransferService", "APP端不应接收TRANSFER_STOP命令");
                return;
            case 9:
                Log.w("FileTransferService", "APP端不应接收TRANSFER_COMPLETE命令");
                return;
            case 10:
                Log.w("FileTransferService", "APP端不应接收FILE_DATA命令");
                return;
            case 11:
                Log.w("FileTransferService", "APP端不应接收RECEIVED_CHECKSUM命令");
                return;
            case 12:
                Log.w("FileTransferService", "APP端不应接收TOTAL_TRANSFERRED命令");
                return;
        }
    }

    @Override // com.baji.protocol.service.BaseProtocolService
    public void initialize(PacketSendCallback packetSendCallback) {
        setPacketSendCallback(packetSendCallback);
    }

    public final boolean isFileTransferring(long j) {
        return this.transferJobs.containsKey(Long.valueOf(j));
    }

    @Override // com.baji.protocol.service.BaseProtocolService
    protected boolean sendDataToDevice(byte[] bArr, String str) {
        p31.f(bArr, "data");
        p31.f(str, SocialConstants.PARAM_COMMENT);
        or0 or0Var = this.dataSender;
        if (or0Var != null) {
            return ((Boolean) or0Var.invoke(bArr, str)).booleanValue();
        }
        return false;
    }

    public final void startStandardTransfer(TransferFileInfo transferFileInfo) {
        p31.f(transferFileInfo, "transferInfo");
        long mediaId = transferFileInfo.getMediaId();
        if (this.transferJobs.containsKey(Long.valueOf(mediaId))) {
            TransferErrorCallback transferErrorCallback = this.errorCallback;
            if (transferErrorCallback != null) {
                transferErrorCallback.onError(mediaId, ErrorCode.DEVICE_BUSY, "File is already being transferred");
                return;
            }
            return;
        }
        updateTransferStatus(mediaId, TransferStatus.PREPARING, ErrorCode.SUCCESS, "Preparing transfer");
        this.transferJobs.put(Long.valueOf(mediaId), BuildersKt__Builders_commonKt.launch$default(getServiceScope(), null, null, new FileTransferService$startStandardTransfer$job$1(this, transferFileInfo, mediaId, null), 3, null));
    }

    public final void startTransfer(int i, long j, FileType fileType, FunctionType functionType, String str) {
        p31.f(fileType, "fileType");
        p31.f(functionType, "functionType");
        p31.f(str, "filePath");
        startTransfer(new TransferFileInfo(i, j, fileType, functionType, str));
    }

    public final void stopTransfer(long j) {
        Job job = this.transferJobs.get(Long.valueOf(j));
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.transferJobs.remove(Long.valueOf(j));
        updateTransferStatus(j, TransferStatus.CANCELLED, ErrorCode.SUCCESS, "Transfer cancelled");
    }

    public final TransferStatusInfo getTransferStatus(long j) {
        return this.transferStatus.get(Long.valueOf(j));
    }

    public final void initialize(TransferProgressCallback transferProgressCallback, TransferStatusCallback transferStatusCallback, TransferErrorCallback transferErrorCallback, PacketSendCallback packetSendCallback, or0 or0Var, MediaManagementService mediaManagementService) {
        this.progressCallback = transferProgressCallback;
        this.statusCallback = transferStatusCallback;
        this.errorCallback = transferErrorCallback;
        setPacketSendCallback(packetSendCallback);
        this.dataSender = or0Var;
        this.mediaManagementService = mediaManagementService;
    }

    public final void startTransfer(TransferFileInfo transferFileInfo) {
        p31.f(transferFileInfo, "transferInfo");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.transferJobs.containsKey(Long.valueOf(jCurrentTimeMillis))) {
            TransferErrorCallback transferErrorCallback = this.errorCallback;
            if (transferErrorCallback != null) {
                transferErrorCallback.onError(jCurrentTimeMillis, ErrorCode.DEVICE_BUSY, "File is already being transferred");
                return;
            }
            return;
        }
        updateTransferStatus(jCurrentTimeMillis, TransferStatus.PREPARING, ErrorCode.SUCCESS, "Preparing transfer");
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(getServiceScope(), null, null, new FileTransferService$startTransfer$job$1(transferFileInfo, this, jCurrentTimeMillis, null), 3, null);
        this.transferJobs.put(Long.valueOf(jCurrentTimeMillis), jobLaunch$default);
    }
}
