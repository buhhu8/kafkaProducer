package org.education.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "newFile")
public class WriteFileNameEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;
    String fileName;
    LocalDate fileCreateDate;

}
