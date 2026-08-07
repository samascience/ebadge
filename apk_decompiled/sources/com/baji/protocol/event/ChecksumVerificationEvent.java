package com.baji.protocol.event;

/* JADX INFO: loaded from: classes.dex */
public final class ChecksumVerificationEvent extends BajiBaseEvent {
    private final int actualChecksum;
    private final String eventType = "CHECKSUM_VERIFICATION";
    private final int expectedChecksum;
    private final long fileId;
    private final boolean isValid;

    public ChecksumVerificationEvent(long j, int i, int i2, boolean z) {
        this.fileId = j;
        this.expectedChecksum = i;
        this.actualChecksum = i2;
        this.isValid = z;
    }

    public final int getActualChecksum() {
        return this.actualChecksum;
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("校验和验证: 文件ID=");
        sb.append(this.fileId);
        sb.append(", 期望=");
        sb.append(this.expectedChecksum);
        sb.append(", 实际=");
        sb.append(this.actualChecksum);
        sb.append(", 结果=");
        sb.append(this.isValid ? "通过" : "失败");
        return sb.toString();
    }

    @Override // com.baji.protocol.event.BajiBaseEvent
    public String getEventType() {
        return this.eventType;
    }

    public final int getExpectedChecksum() {
        return this.expectedChecksum;
    }

    public final long getFileId() {
        return this.fileId;
    }

    public final boolean isValid() {
        return this.isValid;
    }
}
