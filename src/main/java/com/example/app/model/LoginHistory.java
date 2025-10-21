package com.example.app.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
/*
    DTO(Data Transfer Object)
    VO (Value Object)
 */
@Setter
@Getter
public class LoginHistory {
    int idx;
    String memberId;
    LocalDateTime loginAt;
}
