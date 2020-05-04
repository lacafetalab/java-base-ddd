package pe.lacafetalab.base.ddd.domain.exception;

import org.apache.commons.lang3.StringUtils;

import pe.lacafetalab.base.ddd.domain.code.AppCode;

public class LoginException extends AppException {
	private static final long serialVersionUID = 1L;

	private static final int STATUS_CODE = 404;

	public LoginException(AppCode code) {
		super(STATUS_CODE, code, StringUtils.EMPTY, null, null);
	}

	public LoginException(AppCode code, String message) {
		super(STATUS_CODE, code, message, null, null);
	}

	public LoginException(Integer code, String message) {
		super(STATUS_CODE, code, message, null, null);
	}
}