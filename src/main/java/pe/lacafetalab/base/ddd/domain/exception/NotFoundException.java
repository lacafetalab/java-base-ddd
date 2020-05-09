package pe.lacafetalab.base.ddd.domain.exception;

import org.apache.commons.lang3.StringUtils;

import pe.lacafetalab.base.ddd.domain.code.AppCode;

public class NotFoundException extends AppException {
	private static final long serialVersionUID = 1L;

	private static final int STATUS_CODE = 404;

	public NotFoundException(AppCode code) {
		super(STATUS_CODE, code, StringUtils.EMPTY, null, null);
	}

	public NotFoundException(Integer code) {
		super(STATUS_CODE, code, StringUtils.EMPTY, null, null);
	}

	public NotFoundException(AppCode code, String message) {
		super(STATUS_CODE, code, message, null, null);
	}

	public NotFoundException(Integer code, String message) {
		super(STATUS_CODE, code, message, null, null);
	}
}