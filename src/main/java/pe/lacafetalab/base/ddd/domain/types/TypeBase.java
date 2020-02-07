package pe.lacafetalab.base.ddd.domain.types;

public abstract class TypeBase<T> {
    private T value;

    public TypeBase(T value) {
        this.value = value;
    }

    public T value() {
        return this.value;
    }

    public boolean isNull() {
        return this.value == null;
    }

    @Override
    abstract public String toString();
}
