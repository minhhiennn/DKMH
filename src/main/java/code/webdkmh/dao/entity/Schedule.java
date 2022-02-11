package code.webdkmh.dao.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Schedule")
public class Schedule {
    @Id
    @Column(name = "ID_Schedule", nullable = false, length = 50)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_Course_Offering", nullable = false)
    private CourseOffering idCourseOffering;

    @ManyToOne
    @JoinColumn(name = "Id_Profeesor")
    private Professor idProfeesor;

    @Column(name = "Theoretical", nullable = false, length = 2)
    private String theoretical;

    @Column(name = "Teaching_Day", nullable = false)
    private Integer teachingDay;

    @Column(name = "Start_Day", nullable = false)
    private LocalDate startDay;

    @Column(name = "End_Day", nullable = false)
    private LocalDate endDay;

    @Column(name = "Study_place", nullable = false, length = 50)
    private String studyPlace;

    @Column(name = "Start_Slot", nullable = false)
    private Integer startSlot;

    @Column(name = "End_Slot", nullable = false)
    private Integer endSlot;

    public Integer getEndSlot() {
        return endSlot;
    }

    public void setEndSlot(Integer endSlot) {
        this.endSlot = endSlot;
    }

    public Integer getStartSlot() {
        return startSlot;
    }

    public void setStartSlot(Integer startSlot) {
        this.startSlot = startSlot;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public void setStudyPlace(String studyPlace) {
        this.studyPlace = studyPlace;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public Integer getTeachingDay() {
        return teachingDay;
    }

    public void setTeachingDay(Integer teachingDay) {
        this.teachingDay = teachingDay;
    }

    public String getTheoretical() {
        return theoretical;
    }

    public void setTheoretical(String theoretical) {
        this.theoretical = theoretical;
    }

    public Professor getIdProfeesor() {
        return idProfeesor;
    }

    public void setIdProfeesor(Professor idProfeesor) {
        this.idProfeesor = idProfeesor;
    }

    public CourseOffering getIdCourseOffering() {
        return idCourseOffering;
    }

    public void setIdCourseOffering(CourseOffering idCourseOffering) {
        this.idCourseOffering = idCourseOffering;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}