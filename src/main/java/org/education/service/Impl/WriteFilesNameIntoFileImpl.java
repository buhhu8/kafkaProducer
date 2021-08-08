package org.education.service.Impl;

import lombok.RequiredArgsConstructor;
import org.education.model.WriteFileNameEntity;
import org.education.model.dto.WriteFilesNameDto;
import org.education.repository.FilesWriteIntoBaseRepositories;
import org.education.service.WriteFilesNameIntoFile;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WriteFilesNameIntoFileImpl implements WriteFilesNameIntoFile {

    private final FilesWriteIntoBaseRepositories filesWrite;
    private final ModelMapper modelMapper;

    @Override
    public void getFiles(Integer id) {
        filesWrite.findById(id);
    }

    public void saveFiles(WriteFilesNameDto dto){
        filesWrite.save(modelMapper.map(dto, WriteFileNameEntity.class));
    }
}
