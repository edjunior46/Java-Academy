package br.com.academy.model;

import java.io.Serializable;

import br.com.academy.enums.Course;
import br.com.academy.enums.Period;
import br.com.academy.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String name;
    @Enumerated(EnumType.STRING)
    private Course course;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Period period;
    
    public Student() {
    }

    public Student(Integer id, String name, Course course, Status status, Period period) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.status = status;
        this.period = period;
    }
    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Period getPeriod() {
        return this.period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
    
    


}
