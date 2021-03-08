/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Geo
 */
public class Course {

    //fields
    private String title;
    private String stream;
    private String type;
    private Date start_date;
    private Date end_date;

    //constructor simple
    public Course() {
    }

    //constructor
    public Course(String title, String stream, String type,
            Date start_date, Date end_date) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    //getter
    public String getTitle() {
        return title;
    }

    //setter
    public void setTitle(String title) {
        this.title = title;
    }

    //getter
    public String getStream() {
        return stream;
    }

    //setter
    public void setStream(String stream) {
        this.stream = stream;
    }

    //getter
    public String getType() {
        return type;
    }

    //setter
    public void setType(String type) {
        this.type = type;
    }

    //getter
    public Date getStart_date() {
        return start_date;
    }

    //setter
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    //getter
    public Date getEnd_date() {
        return end_date;
    }

    //setter
    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Course{" + "title=" + title + ", stream=" + stream + ", type=" + type
                + ", start_date=" + start_date + ", end_date=" + end_date + '}';
    }

}
