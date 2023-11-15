package com.kojstarinnovations.conjava17.infrastructure.adapters.output.persistence.entity;

import com.kojstarinnovations.conjava17.domain.enums.ElementStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private int id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    private ElementStatus elementStatus = ElementStatus.NEW;
}
