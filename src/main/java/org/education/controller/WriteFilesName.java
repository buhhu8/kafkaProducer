package org.education.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Collection;


@Service
@RequiredArgsConstructor
public class WriteFilesName {


    private final ReadFilesName readFilesName;

    private final KafkaTemplate<String,String> kafkaTemplate;

    @SneakyThrows
    @Scheduled(fixedRate = 3000)
    public void writeFile() {
        BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\kafka\\result.txt", true));
        Collection<String> resultList = readFilesName.readFile();
        for (String result : resultList) {
            kafkaTemplate.send("msg", "1", result);
            writer.write(result);
            writer.newLine();
            System.out.println(result);
        }
        writer.close();
    }
}