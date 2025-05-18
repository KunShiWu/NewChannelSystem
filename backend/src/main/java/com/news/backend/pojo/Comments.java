package com.news.backend.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
    @TableId(type = IdType.AUTO)
    private  Integer id;
    private String newsid;
    private String photo;
    private  String  username;
    private  String  content;
}
