package com.group.FresherManagement.services;

import com.group.FresherManagement.dao.CoursesSubjectDAO;
import com.group.FresherManagement.entities.CoursesSubject;

import java.util.List;

public class CourseSubjectServices {
    private CoursesSubjectDAO coursesSubjectDAO;

    public CourseSubjectServices() {
        this.coursesSubjectDAO = new CoursesSubjectDAO(CoursesSubject.class);
    }

    public List<CoursesSubject> findAll() {
        return coursesSubjectDAO.findAll();
    }

    public CoursesSubject findById(int id) {
        return coursesSubjectDAO.findById(id);
    }

//    public List<CoursesSubject> findAllCourseSubjectOfCourse(Courses courses){
//        List<CoursesSubject> listCourseSubject = findAll();
//        List<CoursesSubject> currList = new ArrayList<CoursesSubject>();
//        for (CoursesSubject coursesSubject: listCourseSubject) {
//            if(coursesSubject.getCourses().getId() == courses.getId()){
//                currList.add(coursesSubject);
//            }
//        }
//    }
}
