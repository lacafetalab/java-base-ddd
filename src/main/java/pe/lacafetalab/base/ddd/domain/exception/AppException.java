package pe.lacafetalab.base.ddd.domain.exception;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.lacafetalab.base.ddd.domain.code.AppCode;

public class AppException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory.getLogger(BadRequestException.class.getName());

	// https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
	private Integer statusCode;
	private Integer code;
	private String message;
	private Object data;

	public AppException(Integer statusCode, AppCode code, String message, Object data, Throwable ex) {
		this(statusCode, generateCode(statusCode, code), message, data, ex);
	}

	public AppException(Integer statusCode, AppCode code, String message) {
		this(statusCode, generateCode(statusCode, code), message, null, null);
	}

	public AppException(Integer statusCode, Integer code, String message, Object data, Throwable ex) {
		super(ex);
		this.statusCode = statusCode;
		this.code = code;
		this.message = message;
		this.data = Optional.ofNullable(data).orElse(new Object());
		LOGGER.error("statusCode[{}], code[{}], messga[{}], data[{}]", this.getStatusCode(), this.getCode().toString(),
				this.getMessage(), this.getData());
	}

	private static Integer generateCode(Integer statusCode, AppCode code) {
		String concatcode = statusCode.toString().concat(code.value());
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

	public Object getData() {
		return data;
	}
}
