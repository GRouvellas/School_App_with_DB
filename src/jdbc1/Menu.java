/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

import utils.Checks;
import dao.AssaPCouPStuDao;
import dao.AssaPCouPStuDaoImpl;
import dao.AssignmentDao;
import dao.AssignmentDaoImpl;
import dao.AssignmentsPCourseDao;
import dao.AssignmentsPCourseDaoImpl;
import dao.CourseDao;
import dao.CourseDaoImpl;
import dao.StudentDao;
import dao.StudentDaoImpl;
import dao.StudentsPCourseDao;
import dao.StudentsPCourseDaoImpl;
import dao.TrainerDao;
import dao.TrainerDaoImpl;
import dao.TrainersPCourseDao;
import dao.TrainersPCourseDaoImpl;
import java.util.Scanner;

/**
 *
 * @author Geo
 */
public class Menu {

    //creates various empty DAO objects that we will need to call methods from, then creates a switch statement  
    //with various methods and asks the user which one he wants to run
    public static void Menu() {
        Scanner sc = new Scanner(System.in);
        int num;
        StudentDao s = new StudentDaoImpl();
        TrainerDao t = new TrainerDaoImpl();
        AssignmentDao a = new AssignmentDaoImpl();
        CourseDao c = new CourseDaoImpl();
        StudentsPCourseDao spc = new StudentsPCourseDaoImpl();
        TrainersPCourseDao tpc = new TrainersPCourseDaoImpl();
        AssignmentsPCourseDao apc = new AssignmentsPCourseDaoImpl();
        AssaPCouPStuDao apcps = new AssaPCouPStuDaoImpl();
        System.out.println("\nEnter the number of the action you wish to do from the following "
                + "Menu: \n1. Print the list of all the Students \n2. Print the list of all "
                + "the Trainers \n3. Print the list of all the Assignments \n4. Print the list of all "
                + "the Courses \n5. Print the list of all the Students per Course \n6. Print the list "
                + "of all the Trainers per Course \n7. Print the list of all the Assignments per Course"
                + "\n8. Print the list of all the Assignments per Course per Student \n9. Print the list "
                + "of Students that belong to more than one Courses \n10. Insert a Student \n11. Insert a Trainer \n"
                + "12. Insert an Assignment \n13. Insert a Course \n14. Insert a Student in a Course "
                + "\n15. Insert a Trainer in a Course \n16. Insert an Assignment in a Student in a Course "
                + "\n17. Exit this Menu");
        do {
            num = Integer.parseInt(Checks.integerCheck(sc.nextLine()));
            switch (num) {
                case 1:
                    s.allStudents();
                    break;
                case 2:
                    t.allTrainers();
                    break;
                case 3:
                    a.allAssignments();
                    break;
                case 4:
                    c.allCourses();
                    break;
                case 5:
                    spc.allStudentsPCourse();
                    break;
                case 6:
                    tpc.allTrainersPCourse();
                    break;
                case 7:
                    apc.allAssignmentsPCourse();
                    break;
                case 8:
                    apcps.allAssaPCouPStu();
                    break;
                case 9:
                    spc.StudentsInCourses();
                    break;
                case 10:
                    s.insertStudent(s.createStudent());
                    System.out.println("Student Inserted!");
                    break;
                case 11:
                    t.insertTrainer(t.createTrainer());
                    System.out.println("Trainer Inserted!");
                    break;
                case 12:
                    a.insertAssignment(a.createAssignment());
                    System.out.println("Assignment Inserted!");
                    break;
                case 13:
                    c.insertCourse(c.createCourse());
                    System.out.println("Course Inserted!");
                    break;
                case 14:
                    spc.insertStudentsPCourse(spc.createStudentsPCourse());
                    System.out.println("Student inserted in a Course");
                    break;
                case 15:
                    tpc.insertTrainersPCourse(tpc.createTrainersPCourse());
                    System.out.println("Trainer inserted in a Course");
                    break;
                case 16:
                    apcps.insertAssaPCouPStu();
                    System.out.println("Assignment per Student per Course completed!");
                    break;
                case 17:
                    break;
                default:
                    System.out.println("Input a number from 1-17");
            }
        } while (num != 17);
    }

}
