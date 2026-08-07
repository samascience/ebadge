package xfkj.fitpro.model.sever.reponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class BaseResponse<T> implements Serializable {
    private T data;
    private CommonErrorResponse error;
    private boolean success;

    public T getData() {
        return this.data;
    }

    public CommonErrorResponse getError() {
        if (this.error == null) {
            CommonErrorResponse commonErrorResponse = new CommonErrorResponse();
            this.error = commonErrorResponse;
            commonErrorResponse.setCode(-1);
            this.error.setMessage("未发现异常");
        }
        return this.error;
    }

    public boolean isSuccess() {
        if (this.success && getData() == null) {
            CommonErrorResponse commonErrorResponse = new CommonErrorResponse();
            this.error = commonErrorResponse;
            commonErrorResponse.setCode(-1);
            this.error.setMessage("数据没发现");
            this.success = false;
        }
        return this.success;
    }

    public String toString() {
        return "BaseResponse{data=" + this.data + ", success=" + this.success + ", error=" + this.error + '}';
    }
}
