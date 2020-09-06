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
            Validate.getAndValidateMutation(data, mutationName.toUpperCase(), mutationProbValue);

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
            Validate.getAndValidateCriteria(data, stopCriteria.toUpperCase(), param);

        } catch (IOException | ParseException | InvalidArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return data;

    }
}
