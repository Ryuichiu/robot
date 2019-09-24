package de.robot.repository;

import de.robot.model.Record;
import org.springframework.data.repository.CrudRepository;

public interface RecordRepository extends CrudRepository<Record, Long> {

    Record findTopByOrderByIdDesc();
}
