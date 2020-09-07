package parsers;

import exceptions.InvalidArgumentException;
import models.Data;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import static parsers.Parameters.*;
import static sun.security.krb5.Confounder.intValue;

public class ConfigParser {
    public static Data parse(String path) {
        JSONParser parser = new JSONParser();
        Reader configReader;
        Data data = new Data();

        try {
            configReader = new FileReader(path);
            JSONObject json = (JSONObject) parser.parse(configReader);

            // Player class
            String playerClass = (String) json.get(PLAYER_TYPE.name());
            Validate.getAndValidatePlayer(data, playerClass.toUpperCase());

            // Population and selectLimit
            Long populationValue = (Long) json.get(POPULATION.name());
            Long selectLimit = (Long) json.get(SELECTION_LIMIT.name());
            Validate.validatePopulationAndSelect(data, populationValue, selectLimit);

            // Mutation method validation
            String mutationName= (String) json.get(MUTATION.name());
            Double mutationProbValue = (Double) json.get(MUTATION_PROB.name());
            Integer crossoverM = ((Long) json.get(LIMITED_MULTIGEN_M.name())).intValue();

            Validate.getAndValidateMutation(data, mutationName.toUpperCase(), mutationProbValue, crossoverM);

            //  Crossover method validation
            String crossoverName = (String) json.get(CROSSOVER.name());
            Double crossoverProbValue = (Double) json.get(CROSSOVER_PROB.name());
            Validate.getAndValidateCrossover(data, crossoverName.toUpperCase(), crossoverProbValue);
            //  uniformThresholdValue = Validate.getAndValidateThreshold(crossoverName,  (Double) json.get(UNIFORM_THRESHOLD));

            // Validate and get selection and replacement methods
            Validate.getAndValidateSelectionMethods(data, json);

            // Implementation method validation
            String implementationName = (String) json.get(IMPLEMENTATION_METHOD.name());
            Validate.getAndValidateImplementation(data, implementationName.toUpperCase());

            String stopCriteria = (String) json.get(CRITERIA.name());
            Number param = (Number) json.get(CRITERIA_PARAM.name());
            Double structurePercentage = (Double) json.get(STRUCTURE_PERCENTAGE.name());
            Validate.getAndValidateCriteria(data, stopCriteria.toUpperCase(), structurePercentage, param);

            Long maxLines = (Long) json.get(MAX_LINES.name());
            data.setMaxLines(maxLines);

        } catch (IOException | ParseException | InvalidArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return data;

    }
}
