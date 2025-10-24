package com.example.app.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Comment {
    String writerId;
    String content;
    int articleNo;
    LocalDateTime commentedAt;
}
