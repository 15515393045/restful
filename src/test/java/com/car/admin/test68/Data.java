package com.car.admin.test68;

import java.io.Serializable;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-10-09 10:36
 **/
public class Data implements Serializable {

    private Long id ;
    private Long courseId ;
    private String content ;

    public Long getId() {
        return id;
    }

    public Data setId(Long id) {
        this.id = id;
        return this ;
    }

    public Long getCourseId() {
        return courseId;
    }

    public Data setCourseId(Long courseId) {
        this.courseId = courseId;
        return this ;
    }

    public String getContent() {
        return content;
    }

    public Data setContent(String content) {
        this.content = content;
        return this ;
    }

}
