package parsers;

import models.EquipmentType;
import models.Attribute;
import newModels.Equipment;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class EquipmentParser {
    public static List<Equipment> equipmentParser(Reader reader, EquipmentType equipmentType, long equipmentsNumber,
                                                  int fileLines) {
        List<Equipment> equipmentList = new ArrayList<>();
        try {
            Set<Attribute> titles = titleParser(reader);
            Map<Attribute, Double> values;
            SortedSet<Integer> randomIndexes = new TreeSet<>();
            Random random = new Random();
            int linesRead = 0;

            while (randomIndexes.size() < equipmentsNumber) {
                randomIndexes.add(random.nextInt(fileLines) + 1);
            }

            do {
                values = valuesParser(reader, titles, randomIndexes.first().equals(linesRead));
                if (!values.isEmpty()) {
                    Equipment equipment = getEquipment(values, equipmentType);
                    equipmentList.add(equipment);
                    randomIndexes.remove(randomIndexes.first());
                }
                linesRead++;
            } while (equipmentList.size() <= equipmentsNumber && randomIndexes.size() > 0);

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

    private static Map<Attribute, Double> valuesParser(Reader reader, Set<Attribute> titles, boolean parse) throws IOException {
        int c;
        Iterator<Attribute> iterator = titles.iterator();
        Map<Attribute, Double> values = new LinkedHashMap<>();
        StringBuilder value = new StringBuilder();
        Attribute title;
        while ((c = reader.read()) != '\n') {
            if (parse) {
                if (c == '\t') {
                    title = iterator.next();
                    double valueDouble = Double.parseDouble(value.toString());
                    values.put(title, valueDouble);
                    value = new StringBuilder();
                } else {
                    value.append((char) c);
                }
            }
        }
        if (parse) {
            title = iterator.next();
            double valueDouble = Double.parseDouble(value.toString());
            values.put(title, valueDouble);
        }
        return values;
    }
}
