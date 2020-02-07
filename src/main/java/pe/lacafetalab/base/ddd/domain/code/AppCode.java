package pe.lacafetalab.base.ddd.domain.code;


public abstract class AppCode {

    protected String code;

    public AppCode(Integer code) {
        this.code = this.formatCode(code);
    }

    private String formatCode(Integer code) {
        return String.format("%04d", code);
    }

    abstract protected String getModuleCode();

    public String value() {
        return this.getModuleCode().concat(this.code);
    }
}
