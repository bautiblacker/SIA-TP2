import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class Parser {
    public static void main(String[] args) {
        String filePath = args[0];
        try {
            Reader reader = new FileReader(filePath);
            Set<String> titles = titleParser(reader);

            Map<String, Double> values;

            do {
                values = valuesParser(reader, titles);

                // ACA YA TENGO UNA FILA DEL ARCHIVO EN EL MAPA
                // APLICAR ALGORITMOS PARA VER SI ES LA MEJOR OPCION

            } while (!values.isEmpty());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static Set<String> titleParser(Reader reader) throws IOException {
        Set<String> lineParsed = new LinkedHashSet<>();
        StringBuilder value = new StringBuilder();
        int c;
        while ((c = reader.read()) != '\n'){
            if(c == '\t'){
                lineParsed.add(value.toString());
                value = new StringBuilder();
            } else {
                value.append((char) c);
            }
        }
        lineParsed.add(value.toString());
        return lineParsed;
    }

    private static Map<String, Double> valuesParser(Reader reader, Set<String> titles) throws IOException {
        int c;
        Iterator<String> iterator = titles.iterator();
        Map<String, Double> values = new LinkedHashMap<>();
        StringBuilder value = new StringBuilder();
        String title;
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
