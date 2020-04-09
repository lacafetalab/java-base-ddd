package pe.lacafetalab.base.ddd.domain.exception;

import pe.lacafetalab.base.ddd.domain.code.AppCode;

public class AppException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    // https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
	private Integer statusCode;
    private Integer code;
    private String message;

    public AppException(Integer statusCode, AppCode code, String message) {
        this.statusCode = statusCode;
        this.code = this.generateCode(code);
        this.message = message;
    }

    private Integer generateCode(AppCode code) {
        String concatcode = this.statusCode.toString().concat(code.value());
        return Integer.parseInt(concatcode);
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
