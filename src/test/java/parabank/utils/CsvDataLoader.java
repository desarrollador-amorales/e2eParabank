package parabank.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CsvDataLoader {

    private CsvDataLoader() {}

    // Lee CSV por classpath (ruta relativa a src/test/resources)
    public static Map<String, String> loadRowById(String resourcePath, String idColumn, String idValue) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath);
        if (is == null) {
            throw new IllegalArgumentException("No se encontró el recurso en classpath: " + resourcePath);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String headerLine = br.readLine();
            if (headerLine == null) throw new IllegalArgumentException("CSV vacío: " + resourcePath);

            String[] headers = splitCsvLine(headerLine);
            int idIndex = indexOf(headers, idColumn);
            if (idIndex < 0) throw new IllegalArgumentException("No existe la columna '" + idColumn + "' en " + resourcePath);

            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] values = splitCsvLine(line);
                if (values.length != headers.length) continue;

                if (values[idIndex].trim().equals(idValue)) {
                    Map<String, String> row = new HashMap<>();
                    for (int i = 0; i < headers.length; i++) {
                        row.put(headers[i].trim(), values[i].trim());
                    }
                    return row;
                }
            }
            throw new IllegalArgumentException("No se encontró id=" + idValue + " en " + resourcePath);

        } catch (Exception e) {
            throw new RuntimeException("Error leyendo CSV " + resourcePath + ": " + e.getMessage(), e);
        }
    }

    private static int indexOf(String[] arr, String value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].trim().equals(value)) return i;
        }
        return -1;
    }

    // Parser simple (sirve para CSV sin comillas ni comas internas)
    private static String[] splitCsvLine(String line) {
        return line.split("\\s*,\\s*");
    }
}
