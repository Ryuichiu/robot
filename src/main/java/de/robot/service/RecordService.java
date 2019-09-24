package de.robot.service;

import de.robot.model.Record;
import de.robot.repository.RecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RecordService {

    private static final Logger LOG = LoggerFactory.getLogger(RecordService.class);

    private RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }


    public Record findTopByOrderByIdDesc() {
        return recordRepository.findTopByOrderByIdDesc();
    }

    public Record saveRecord(Record record) {
        Record savedRecord = recordRepository.save(record);
        if (savedRecord != null) {
            LOG.info("Record with id {} has been saved.", savedRecord.getId());
        }
        return savedRecord;
    }
}
