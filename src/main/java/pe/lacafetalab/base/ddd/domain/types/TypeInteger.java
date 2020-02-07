package pe.lacafetalab.base.ddd.domain.types;


public abstract class TypeInteger extends TypeBase<Integer> {

    public TypeInteger(Integer value) {
        super(value);
    }


	/*public TypeInteger(String value, BadRequestException ex) {
		if (StringUtils.isBlank(value) || !NumberUtils.isDigits(value)) {
			throw ex;
		}
		this.value = Integer.valueOf(value);
	}*/

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value() == null) ? 0 : value().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TypeInteger other = (TypeInteger) obj;
        if (value() == null) {
            if (other.value() != null)
                return false;
        } else if (!value().equals(other.value()))
            return false;
        return true;
    }

    @Override
    public String toString() {
        if (this.isNull()) {
            return "";
        }
        return Integer.toString(this.value());
    }
}
