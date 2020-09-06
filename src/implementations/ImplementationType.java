package implementations;

import selection.SelectionMethod;

public enum ImplementationType {
    FILLALL,
    FILLPARENTS;

    public static boolean contains(String type) {
        for (ImplementationType i : ImplementationType.values()) {
            if (i.name().equals(type)) return true;
        }
        return false;
    }

    public static ImplementationMethod getMethodInstance(ImplementationType type, SelectionMethod selectionMethod) {
        switch (type) {
            case FILLALL:
                return new FillAll(selectionMethod);
            case FILLPARENTS:
                return new FillParent(selectionMethod);
        }
        return null;
    }
}
