package com.plover.ums.service;

import com.plover.ums.dto.SlotDTO;
import com.plover.ums.entity.Slot;
import com.plover.ums.entity.Term;
import com.plover.ums.repo.SlotRepo;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SlotService {
    private final SlotRepo repo;
    private final EntityManager em;

    public SlotService(SlotRepo repo, EntityManager em) {
        this.repo = repo;
        this.em = em;
    }

    @Transactional
    public SlotDTO save(SlotDTO dto) {
        Slot slot = new Slot();
        slot.setSlotNumber(dto.getSlotNumber());
        slot.setTimeText(dto.getTimeText());
        slot.setStartTime(dto.getStartTime());
        slot.setEndTime(dto.getEndTime());
        slot.setSlotStartTime(dto.getSlotStartTime());
        slot.setSlotEndTime(dto.getSlotEndTime());
        slot.setCampusId(dto.getCampusId());

        if (dto.getTermCode() != null) {
            slot.setTerm(em.getReference(Term.class, dto.getTermCode()));
        }

        Slot savedSlot = repo.save(slot);
        dto.setSlotId(savedSlot.getSlotId());
        return dto;
    }

    @Transactional(readOnly = true)
    public List<SlotDTO> findAll() {
        return repo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private SlotDTO mapToDto(Slot s) {
        SlotDTO dto = new SlotDTO();
        dto.setSlotId(s.getSlotId());
        dto.setSlotNumber(s.getSlotNumber());
        dto.setTimeText(s.getTimeText());
        dto.setStartTime(s.getStartTime());
        dto.setEndTime(s.getEndTime());
        dto.setSlotStartTime(s.getSlotStartTime());
        dto.setSlotEndTime(s.getSlotEndTime());
        dto.setCampusId(s.getCampusId());
        if (s.getTerm() != null) dto.setTermCode(s.getTerm().getTermCode());
        return dto;
    }
}