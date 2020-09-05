package implementations;

import selection.SelectionMethod;

public abstract class Implementation implements ImplementationMethod{
    private SelectionMethod method;
    public Implementation(SelectionMethod method) { this.method = method; }

    public SelectionMethod getMethod() {
        return method;
    }
}
