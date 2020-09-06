package parsers;

import models.EquipmentType;
import models.Attribute;
import newModels.Equipment;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class EquipmentParser {
    public static List<Equipment> equipmentParser(Reader reader, EquipmentType equipmentType, long number) {
        List<Equipment> equipmentList = new ArrayList<>();
        try {
            Set<Attribute> titles = titleParser(reader);
            Map<Attribute, Double> values;

            do {
                values = valuesParser(reader, titles, number);
                Equipment equipment = getEquipment(values,equipmentType);
                if(equipment == null){
                    return null;
                }
                equipmentList.add(equipment);
            } while (!values.isEmpty());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return equipmentList;
    }

    private static Equipment getEquipment(Map<Attribute, Double> equipmentValues, EquipmentType type) {
        return new Equipment(equipmentValues, type);
    }


    private static Set<Attribute> titleParser(Reader reader) throws IOException {
        Set<Attribute> lineParsed = new LinkedHashSet<>();
        StringBuilder value = new StringBuilder();
        int c;
        while ((c = reader.read()) != '\n') {
            if (c == '\t') {
                lineParsed.add(Attribute.getProperty(value.toString()));
                value = new StringBuilder();
            } else {
                value.append((char) c);
            }
        }
        lineParsed.add(Attribute.getProperty(value.toString()));
        return lineParsed;
    }

    private static Map<Attribute, Double> valuesParser(Reader reader, Set<Attribute> titles, long number) throws IOException {
        int c;
        Iterator<Attribute> iterator = titles.iterator();
        Map<Attribute, Double> values = new LinkedHashMap<>();
        StringBuilder value = new StringBuilder();
        Attribute title;
        Random random = new Random();
        long multiple = random.nextLong(); // TODO: setear limite
        long counter = 0;
        while ((c = reader.read()) != '\n') {
            if (c == '\t') {
                title = iterator.next();
                double valueDouble = Double.parseDouble(value.toString());
                if(counter % multiple == 0) values.put(title,valueDouble);
                value = new StringBuilder();
                counter++;
            } else {
                value.append((char) c);
            }
        }
        title = iterator.next();
        double valueDouble = Double.parseDouble(value.toString());
        values.put(title, valueDouble);
        return values;
    }
}
