package implementations;

public enum ImplementationType {
    FILLALL,
    FILLPARENTS;

    public static boolean contains(String type) {
        for(ImplementationType i : ImplementationType.values()) {
            if(i.name().equals(type)) return true;
        }
        return false;
    }

    public static ImplementationMethod getMethodInstance(ImplementationType type) {
        switch (type) {
            case FILLALL:
<<<<<<< HEAD
                return new FillAll();
            case FILLPARENTS:
                return new FillParents();
=======
                return null;
            case FILLPARENTS:
                return null;
>>>>>>> new begin big commit
        }
        return null;
    }
}
