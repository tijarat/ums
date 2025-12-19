package com.plover.ums.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "WEB_USERS_FACULTY", schema = "UMSDM")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class WebUserFaculty {

    @EmbeddedId
    private WebUserFacultyId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("facultyId")
    @JoinColumn(name = "FACULTY_ID")
    private Faculty faculty;
}