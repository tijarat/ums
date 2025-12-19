package com.plover.ums.service;

import com.plover.ums.dto.AcademicCalendarDTO;
import com.plover.ums.entity.AcademicCalendar;
import com.plover.ums.repo.AcademicCalendarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcademicCalendarService {

    @Autowired
    private AcademicCalendarRepo repo;

    public AcademicCalendarDTO save(AcademicCalendarDTO dto) {
        AcademicCalendar entity = toEntity(dto);
        return toDTO(repo.save(entity));
    }

    public AcademicCalendarDTO update(AcademicCalendarDTO dto) {
        AcademicCalendar entity = toEntity(dto);
        return toDTO(repo.save(entity));
    }

    public AcademicCalendarDTO findById(Long id) {
        return repo.findById(id).map(this::toDTO).orElse(null);
    }

    public List<AcademicCalendarDTO> findAll() {
        return repo.findAll()
                   .stream()
                   .map(this::toDTO)
                   .collect(Collectors.toList());
    }

    public List<AcademicCalendarDTO> findByTerm(String termCde) {
        return repo.findByTermCde(termCde)
                   .stream()
                   .map(this::toDTO)
                   .collect(Collectors.toList());
    }

    public List<AcademicCalendarDTO> findByFaculty(Long facultyId) {
        return repo.findByFacultyId(facultyId)
                   .stream()
                   .map(this::toDTO)
                   .collect(Collectors.toList());
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private AcademicCalendar toEntity(AcademicCalendarDTO d) {
        AcademicCalendar e = new AcademicCalendar();
        e.setActivityId(d.getActivityId());
        e.setActivityName(d.getActivityName());
        e.setTermCde(d.getTermCde());
        e.setStartDate(d.getStartDate());
        e.setEndDate(d.getEndDate());
        e.setFacultyId(d.getFacultyId());
        return e;
    }

    private AcademicCalendarDTO toDTO(AcademicCalendar e) {
        AcademicCalendarDTO d = new AcademicCalendarDTO();
        d.setActivityId(e.getActivityId());
        d.setActivityName(e.getActivityName());
        d.setTermCde(e.getTermCde());
        d.setStartDate(e.getStartDate());
        d.setEndDate(e.getEndDate());
        d.setFacultyId(e.getFacultyId());
        return d;
    }
}
