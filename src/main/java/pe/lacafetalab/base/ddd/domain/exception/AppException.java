package pe.lacafetalab.base.ddd.domain.exception;

import java.util.Optional;

import pe.lacafetalab.base.ddd.domain.code.AppCoding;
import pe.lacafetalab.base.ddd.domain.code.EnumCodeType;

public class AppException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	// https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
	private Integer statusCode;
	private Integer code;
	private String message;
	private Object data;

	public AppException(Throwable e) {
		this(500, 500, e.getMessage(), new Object(), e);
	}

	public <C extends Enum<C> & EnumCodeType> AppException(Integer statusCode, C code, String message, Object data,
			Throwable ex) {
		this(statusCode, generateCode(statusCode, code), message, data, ex);
	}

	public <C extends Enum<C> & EnumCodeType> AppException(Integer statusCode, C code, String message) {
		this(statusCode, generateCode(statusCode, code), message, null, null);
	}

	/**
	 * Instanstiate a AppException object.
	 *
	 * @deprecated Try to use the one with code EnumCodeType enum object parameter.
	 * 
	 */
	@Deprecated
	public AppException(Integer statusCode, Integer code, String message, Object data, Throwable ex) {
		super(ex);
		this.statusCode = statusCode;
		this.code = code;
		this.message = message;
		this.data = Optional.ofNullable(data).orElse(new Object());
	}

	private static <C extends Enum<C> & EnumCodeType> Integer generateCode(Integer statusCode, C code) {
		return AppCoding.value(statusCode, code);
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
