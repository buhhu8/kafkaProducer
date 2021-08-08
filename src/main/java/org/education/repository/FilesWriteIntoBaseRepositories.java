package org.education.repository;

import org.education.model.WriteFileNameEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilesWriteIntoBaseRepositories extends CrudRepository<WriteFileNameEntity, Integer> {

    Optional<WriteFileNameEntity> findById(Integer id);

}
