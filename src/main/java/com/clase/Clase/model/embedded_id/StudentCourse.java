package com.clase.Clase.model.embedded_id;

import com.clase.Clase.model.Course;
import com.clase.Clase.model.Student;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StudentCourse 
{
    @EmbeddedId
    private StudentCourseKey id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @MapsId("courseId")
    private Course course;

    @Column(name = "rating")
    private int rating;

    @Override
    public String toString() {
        return "CourseRating{" + "id=" + id + ", rating=" + rating + '}';
    }
}


