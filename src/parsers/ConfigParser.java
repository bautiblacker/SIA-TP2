package parsers;

import exceptions.InvalidArgumentException;
import models.ConfigParams;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import static parsers.Parameters.*;

public class ConfigParser {
    public static ConfigParams parse(String path) {
        JSONParser parser = new JSONParser();
        Reader configReader;
        ConfigParams configParams = new ConfigParams();

        try {
            configReader = new FileReader(path);
            JSONObject json = (JSONObject) parser.parse(configReader);

            // Player class
            String playerClass = (String) json.get(PLAYER_TYPE.name());
            Validate.getAndValidatePlayer(configParams, playerClass.toUpperCase());

            // Population and selectLimit
            Long populationValue = (Long) json.get(POPULATION.name());
            Long selectLimit = (Long) json.get(SELECTION_LIMIT.name());
            Validate.validatePopulationAndSelect(configParams, populationValue, selectLimit);

            // Mutation method validation
            String mutationName= (String) json.get(MUTATION.name());
            Double mutationProbValue = (Double) json.get(MUTATION_PROB.name());
            Validate.getAndValidateMutation(configParams, mutationName.toUpperCase(), mutationProbValue);

            //  Crossover method validation
            String crossoverName = (String) json.get(CROSSOVER.name());
            Double crossoverProbValue = (Double) json.get(CROSSOVER_PROB.name());
            Validate.getAndValidateCrossover(configParams, crossoverName.toUpperCase(), crossoverProbValue);
            //  uniformThresholdValue = Validate.getAndValidateThreshold(crossoverName,  (Double) json.get(UNIFORM_THRESHOLD));

            // Validate and get selection and replacement methods
            Validate.getAndValidateSelectionMethods(configParams, json);

            // Implementation method validation
            String implementationName = (String) json.get(IMPLEMENTATION_METHOD.name());
            Validate.getAndValidateImplementation(configParams, implementationName.toUpperCase());

            String stopCriteria = (String) json.get(CRITERIA.name());
            Number param = (Number) json.get(CRITERIA_PARAM.name());
            Validate.getAndValidateCriteria(configParams, stopCriteria.toUpperCase(), param);

        } catch (IOException | ParseException | InvalidArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return configParams;

    }
}
