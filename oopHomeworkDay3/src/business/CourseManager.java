package business;

import core.logging.ILogger;
import dataAccess.Interface.ICourseDao;
import entities.Course;

import java.util.List;

public class CourseManager {

    private ICourseDao iCourseDao;
    private ILogger[] loggers;
    private List<Course> courses;
    private TranslateManager translate;
    public CourseManager(ICourseDao iCourseDao, ILogger[] loggers, List<Course> courses) {
        this.iCourseDao = iCourseDao;
        this.loggers = loggers;
        this.courses = courses;
    }

    public void add(Course course) throws Exception {
        for (Course tempCourse : courses) {

            if (tempCourse.getCoursePrice() < 0) {
                throw new Exception("Course price cannot be less than 0 : " + tempCourse.getCourseName() + ": "+tempCourse.getCoursePrice());
            }
            else if (translate.TurkishToEnglish(tempCourse.getCourseName().toLowerCase()) == translate.TurkishToEnglish(course.getCourseName().toLowerCase()))
            {
                throw new Exception("There cannot be more than one course with the same name. : " + tempCourse.getCourseName() + " = " + course.getCourseName());
            }


        }
        iCourseDao.add(course);
        courses.add(course);

        for (ILogger logger : loggers) {
            logger.log(course.getCourseName());
        }


    }
}
