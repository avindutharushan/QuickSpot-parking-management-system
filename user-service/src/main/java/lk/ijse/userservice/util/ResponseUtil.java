package lk.ijse.userservice.util;

public class ResponseUtil {
    private int code;
    private String message;
    private Object data;

    public ResponseUtil() {
    }

    public ResponseUtil(int code, String massage, Object data) {
        this.code = code;
        this.message = massage;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
