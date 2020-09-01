package mutation;

import models.Equipment;

import java.security.InvalidParameterException;
import java.util.Map;

public class LimitedMultigen implements Mutation {

    public Equipment perform(Equipment eq, Map<String, Object> params) {
        if(params.get("M") != null) {
            int M = (Integer) params.get("M");
            Gen genMutation = new Gen();
            Equipment newEq = null;
            for(int i = 0; i < M; i++) {
                newEq = genMutation.perform(eq, params);
            }
            return newEq == null ? eq : newEq;
        }
        throw new InvalidParameterException();
    }
}
