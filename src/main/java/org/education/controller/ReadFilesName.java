package org.education.controller;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class ReadFilesName {


    @SneakyThrows
    public Collection<String> readFile() {
        File folder = new File("F:\\kafka");
        File[] listOfFiles = folder.listFiles();
        BufferedReader reader = new BufferedReader(new FileReader("F:\\kafka\\result.txt"));
        String readBuffer = reader.readLine();
        Collection<String> fileName = new ArrayList<String>();
        Collection<String> resultFileName = new ArrayList<String>();
        while (readBuffer != null) {
            fileName.add(readBuffer);
            readBuffer = reader.readLine();
        }
        for (int i = 0; i < listOfFiles.length; i++) {
            if (fileName.contains(listOfFiles[i].getName()) == false) {
                resultFileName.add(listOfFiles[i].getName());
            }
        }
        reader.close();
        return resultFileName;
    }
}
