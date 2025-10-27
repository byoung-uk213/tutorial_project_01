package com.example.app.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class LikedArticle {
    int idx;
    String memberId;
    int articleNo;
    int no;
    String writerId;
    String topic;
    String title;
    String content;
    LocalDateTime wroteAt;
    int viewCnt;
    int likeCnt;
    int commentCnt;
}
