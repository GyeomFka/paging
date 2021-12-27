package org.zerobase.paging.domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Posts {

    private Long id;
    private String title;
    private String createTime;

    public Posts(long id, String title) {
        this.id = id;
        this.title = title;
        this.createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCreateTime() {
        return createTime;
    }
}
