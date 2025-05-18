package com.news.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String style;
    private String photo;
    private String content;
    private String author;
}
