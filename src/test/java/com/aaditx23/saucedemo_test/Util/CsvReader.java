package com.aaditx23.saucedemo_test.Util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CsvReader {

    private static Map<String, String> readCsvAsMap(){
        Map<String, String> map = new HashMap<>();

        try(Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/data.csv"))){
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);

            for(CSVRecord record: parser){
                String key = record.get(0);
                String value = record.get(1);
                map.put(key, value);
            }
        }
        catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Could not read CSV file from: " + "src/test/resources/data.csv");
        }
        return map;

    }

    public static Map<String, String> getCsvData(){
        return readCsvAsMap();
    }
}
