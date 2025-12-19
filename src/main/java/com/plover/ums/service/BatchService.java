// SERVICE
package com.plover.ums.service;

import com.plover.ums.dto.BatchDTO;
import com.plover.ums.entity.Batch;
import com.plover.ums.entity.Program;
import com.plover.ums.repo.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchService {

    @Autowired
    private BatchRepository repository;

    public BatchDTO save(BatchDTO dto) {
        Batch entity = convertToEntity(dto);
        entity = repository.save(entity);
        dto.setBatchId(entity.getBatchId());
        return dto;
    }

    private Batch convertToEntity(BatchDTO dto) {
        Batch entity = new Batch();
        entity.setBatchId(dto.getBatchId());
        entity.setTermCode(dto.getTermCode());
        entity.setBatchNumber(dto.getBatchNumber());
        entity.setProgramCode(dto.getProgramCode());
        // Map Foreign Key Proxy
        Program program = new Program();
        program.setId(dto.getProgramId());
        entity.setProgram(program);
        return entity;
    }
}