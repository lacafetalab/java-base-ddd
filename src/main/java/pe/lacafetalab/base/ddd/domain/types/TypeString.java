package pe.lacafetalab.base.ddd.domain.types;

public abstract class TypeString extends TypeBase<String> {

    public TypeString(String value) {
        super(value);
    }

    public int length() {
        if (this.isNull()) {
            return 0;
        }
        return this.value().length();
    }

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
        TypeString other = (TypeString) obj;
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
        return this.value();
    }
}
