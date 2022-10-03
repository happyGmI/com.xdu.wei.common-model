package enums;

public enum ApiEnum {

    SUCCESS(0, 200, "Success"),
    KNOWN_FAIL(0, 201, "Known fail"),
    COMMON_FAIL(1, 500,"Intern fail"),
    ;

    private int status;
    private int errCode;
    private String message;


    private ApiEnum(int code, int errCode,String message) {
        this.status = code;
        this.errCode = errCode;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public int getErrCode() {
        return errCode;
    }

    public String getMessage() {
        return message;
    }
}
