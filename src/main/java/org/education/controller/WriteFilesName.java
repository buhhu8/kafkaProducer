package org.education.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class WriteFilesName {

    @Autowired
    private final ReadFilesName readFilesName;
    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;

    @SneakyThrows
    @Scheduled(fixedRate = 3000)
    public void writeFile() {
        BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\kafka\\result.txt", true));
        Collection<String> resultList = readFilesName.readFile();
        for (String result : resultList) {
            kafkaTemplate.send("msg", "1", result);
            writer.write(result);
            writer.newLine();
        }
        writer.close();
    }
}