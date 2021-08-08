package org.education.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.education.model.dto.WriteFilesNameDto;
import org.education.service.Impl.WriteFilesNameIntoFileImpl;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Collection;


@Service
@RequiredArgsConstructor
public class WriteFilesName {

    private final ReadFilesName readFilesName;
    private final KafkaTemplate<String,String> kafkaTemplate;
    private final WriteFilesNameIntoFileImpl writeFilesNameIntoFile;


    @SneakyThrows
    @Scheduled(fixedRate = 3000)
    public void writeFile() {
        WriteFilesNameDto dto = new WriteFilesNameDto(null,null,null);
        BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\kafka\\result.txt", true));
        Collection<String> resultList = readFilesName.readFile();
        for (String result : resultList) {
            kafkaTemplate.send("msg", "1", result);
            writer.write(result);
            writer.newLine();
            dto.setFileName(result);
            dto.setFileCreateDate(LocalDate.now());
            writeFilesNameIntoFile.saveFiles(dto);
        }
        writer.close();
    }
}