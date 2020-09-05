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

    public static Implementation getMethodInstance(ImplementationType type) {
        switch (type) {
            case FILLALL:
                return null;
            case FILLPARENTS:
                return null;
        }
        return null;
    }
}
