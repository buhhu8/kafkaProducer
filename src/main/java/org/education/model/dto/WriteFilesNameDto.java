package org.education.model.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class WriteFilesNameDto {

    Integer id;
    String fileName;
    LocalDate fileCreateDate;
}
