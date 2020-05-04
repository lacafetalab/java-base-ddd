package pe.lacafetalab.base.ddd.domain.exception;

import pe.lacafetalab.base.ddd.domain.code.AppCode;

public class ConflictException extends AppException {
	private static final long serialVersionUID = 1L;
	private static final int STATUS_CODE = 409;

	public ConflictException(AppCode code) {
		this(code, "");
	}

	public ConflictException(Integer code) {
		this(code, "");
	}

	public ConflictException(AppCode code, String message) {
		this(code, message, null);
	}

	public ConflictException(Integer code, String message) {
		this(code, message, null);
	}

	public ConflictException(AppCode code, String message, Object data) {
		super(STATUS_CODE, code, message, data, null);
	}

	public ConflictException(Integer code, String message, Object data) {
		super(STATUS_CODE, code, message, data, null);
	}
}