package pe.lacafetalab.base.ddd.domain.exception;

import pe.lacafetalab.base.ddd.domain.code.AppCode;

public class BadRequestException extends AppException {
	private static final long serialVersionUID = 1L;
	private static final int STATUS_CODE = 400;

	/**
	 * recomendaciones para el code se antepone el status code para el modulo shared
	 * poner 00, es muy improbable que tengas mas de 99 agregates y luego poner un
	 * codigo para describir el error ejemplo : 400 00 xxx
	 *
	 * @param code
	 */

	public BadRequestException(AppCode code) {
		this(code, "");
	}

	public BadRequestException(Integer code) {
		this(code, "");
	}

	public BadRequestException(AppCode code, String message) {
		this(code, message, null);
	}

	public BadRequestException(Integer code, String message) {
		this(code, message, null);
	}

	public BadRequestException(AppCode code, String message, Object data) {
		super(STATUS_CODE, code, message, data, null);
	}

	public BadRequestException(Integer code, String message, Object data) {
		super(STATUS_CODE, code, message, data, null);
	}
}