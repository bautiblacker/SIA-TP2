import models.*;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class EquipmentParser {
    public static List<Equipment> equipmentParser(Reader reader, EquipmentType equipmentType) {
        List<Equipment> equipmentList = new ArrayList<>();
        try {
            Set<Property> titles = titleParser(reader);
            Map<Property, Double> values;

            do {
                values = valuesParser(reader, titles);
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

    private static Equipment getEquipment(Map<Property, Double> equipmentValues, EquipmentType type) {
        switch(type){
            case BOOT:
                return new Boot(equipmentValues);
            case GLOVES:
                return new Gloves(equipmentValues);
            case HELMET:
                return new Helmet(equipmentValues);
            case WEAPON:
                return new Weapon(equipmentValues);
            case SHIRTFRONT:
                return new Shirtfront(equipmentValues);
            default:
                return null;
        }
    }



    private static Set<Property> titleParser(Reader reader) throws IOException {
        Set<Property> lineParsed = new LinkedHashSet<>();
        StringBuilder value = new StringBuilder();
        int c;
        while ((c = reader.read()) != '\n'){
            if(c == '\t'){
                lineParsed.add(Property.getProperty(value.toString()));
                value = new StringBuilder();
            } else {
                value.append((char) c);
            }
        }
        lineParsed.add(Property.getProperty(value.toString()));
        return lineParsed;
    }

    private static Map<Property, Double> valuesParser(Reader reader, Set<Property> titles) throws IOException {
        int c;
        Iterator<Property> iterator = titles.iterator();
        Map<Property, Double> values = new LinkedHashMap<>();
        StringBuilder value = new StringBuilder();
        Property title;
        while ((c = reader.read()) != '\n'){
            if(c == '\t'){
                title = iterator.next();
                double valueDouble = Double.parseDouble(value.toString());
                values.put(title,valueDouble);
                value = new StringBuilder();
            } else {
                value.append((char) c);
            }
        }
        title = iterator.next();
        double valueDouble = Double.parseDouble(value.toString());
        values.put(title,valueDouble);
        return values;
    }


}
