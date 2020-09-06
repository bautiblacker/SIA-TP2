package implementations;

import selection.SelectionMethod;

public abstract class Implementation implements ImplementationMethod {
    private SelectionMethod method;

    public SelectionMethod getMethod() {
        return method;
    }

    @Override
    public void setMethod(SelectionMethod method) {
        this.method = method;
    }
}
