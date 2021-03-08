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
public class Assignment {

    //fields
    private String title;
    private String description;
    private Date subDateTime;
    private int oralMark;
    private int totalMark;

    //constructor simple
    public Assignment() {
    }

    //constructor
    public Assignment(String title, String description, Date subDateTime, int oralMark, int totalMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
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
    public String getDescription() {
        return description;
    }

    //setter
    public void setDescription(String description) {
        this.description = description;
    }

    //getter
    public Date getSubDateTime() {
        return subDateTime;
    }

    //setter
    public void setSubDateTime(Date subDateTime) {
        this.subDateTime = subDateTime;
    }

    //getter
    public int getOralMark() {
        return oralMark;
    }

    //setter
    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    //getter
    public int getTotalMark() {
        return totalMark;
    }

    //setter
    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    @Override
    public String toString() {
        return "Assignment{" + "title=" + title + ", description=" + description
                + ", subDateTime=" + subDateTime + ", oralMark=" + oralMark + ", totalMark="
                + totalMark + '}';
    }

}
