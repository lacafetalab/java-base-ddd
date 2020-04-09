package pe.lacafetalab.base.ddd.domain.code;

import pe.lacafetalab.base.ddd.domain.ErrorCode;

public class SharedCode extends AppCode {

	public SharedCode(ErrorCode code) {
		super(code);
	}

	public static SharedCode create(ErrorCode code) {
		return new SharedCode(code);
	}

	@Override
	protected String getModuleCode() {
		return "00";
	}
}
