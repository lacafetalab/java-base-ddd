package pe.lacafetalab.base.ddd.domain.code;

import pe.lacafetalab.base.ddd.domain.ErrorCode;

public abstract class AppCode {

	protected String code;

	public AppCode(ErrorCode code) {
		this.code = this.formatCode(code);
	}

	private String formatCode(ErrorCode code) {
		return String.format("%04d", code.value());
	}

	abstract protected String getModuleCode();

	public String value() {
		return this.getModuleCode().concat(this.code);
	}
}
