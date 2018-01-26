package com.example;

import com.sun.org.glassfish.gmbal.ParameterNames;

import java.util.ArrayList;

/**
 * In this class, there are seven methods.
 *1. sameDepartment method can return an Arraylist of objects from same department
 *2. sameInstructorName method can return an Arraylist of objects whose instructors have same string, expect null and ""
 *3. courseNumRange method can reutrn an Arraylist of objects whose course number in a given inclusive range
 *4. courseStuNumRange method can return an Arraylist of objects whose student number in a legal inclusive range
 *5. coursetitle method can return an Arraylist of objects whose title contain same string
 *6. courseSemester method can return an Arraylist of objects in same semester
 *7. oneCourse method can return an Arraylist of objects with same course number from one department
 *
 */


public class DataFilter {
/**
 * @param needFileteredArray contain all objects from six semesters
 * @param courseTotalNum save the number of objects in needFileteredArray
 */
    private static ArrayList<CourseGrades> needFilteredArray = DataReader.storeFileCotents();
    private static int courseTotalNum = needFilteredArray.size();

    public static ArrayList<CourseGrades> sameDepartment(String department) {
        ArrayList<CourseGrades> requiredDepartmentArray = new ArrayList<CourseGrades>(); //store return arraylist
        //check the department is empty or null
        if(department != null && !department.equals("")){
            for (int i = 0; i < courseTotalNum;i++ ) {  //oneCourse is one specific object in needFilteredArray
                CourseGrades oneCourse = needFilteredArray.get(i);
                if(department.equals(oneCourse.getSubject()) ){
                    requiredDepartmentArray.add(oneCourse);
                }
            }
        }else{
            System.out.println("Department name is invalid");
        }
        return requiredDepartmentArray;
    }

    public static ArrayList<CourseGrades> sameInstructorName(String instructorName) {

        ArrayList<CourseGrades> requiredInstructor = new ArrayList<CourseGrades>();//store return arraylist
        if (instructorName != null && !instructorName.equals("")) {
            for (int i = 0; i < courseTotalNum; i++) {
                //oneCourse is one specific object in needFilteredArray
                CourseGrades oneCourse = needFilteredArray.get(i);
                if (oneCourse.getInstructor().indexOf(instructorName) != -1) {
                    requiredInstructor.add(oneCourse);
                }
            }
        }else{
            System.out.println("Please input valid name");
        }
        return requiredInstructor;
    }

    /**
     *
     * @param courseNumMin is the minimum number of course and it must more than 99
     * @param courseNumMax is the maxmum number of course and  it must less than 999
     *courseNumMax cannot samller than courseNumMin
     * @return course in given course number range
     */
    public static ArrayList<CourseGrades> courseNumRange(int courseNumMin,int courseNumMax){
        ArrayList<CourseGrades> requiredCourseNum = new ArrayList<CourseGrades>(); //store return arraylist
        if(courseNumMax<999 && courseNumMin>99 && courseNumMax>=courseNumMin){
            for (int i = 0; i < courseTotalNum; i++) {
                CourseGrades oneCourse = needFilteredArray.get(i);
                if (courseNumMin <= oneCourse.getNumber() && oneCourse.getNumber() <= courseNumMax) {
                    requiredCourseNum.add(oneCourse);
                }
            }
        }else {
            System.out.println("Your input course number is invalid");
        }
        return requiredCourseNum;
    }

    /**
     *
     * @param stuNumMin is the minimum number of student and it must more than 0
     * @param stuNumMax is the maxmum number of student and it cannot samller than stuNumMin
     * @return courses within given students number range
     */

    public static ArrayList<CourseGrades> courseStuNumRange(int stuNumMin,int stuNumMax){
        //get course with given student number
        ArrayList<CourseGrades> requiredStuNumRange = new ArrayList<CourseGrades>();
        if(stuNumMax>=stuNumMin&&stuNumMin>=0){
            for(int i = 0; i < courseTotalNum; i++) {
                CourseGrades oneCourse = needFilteredArray.get(i);
                int gradeLength = oneCourse.getGrades().length;
                int totalStuNum = 0;
                for(int j = 0; j<gradeLength; j++){
                    totalStuNum += oneCourse.getGrades()[j];
                }
                if(stuNumMax>=totalStuNum&&totalStuNum>=stuNumMin){
                requiredStuNumRange.add(oneCourse);
                }
            }
        }else{
            System.out.println("Your input is invalid");
        }
        return requiredStuNumRange;
    }


    public static ArrayList<CourseGrades> courseTitle(String courseName){
        ArrayList<CourseGrades> requiredCourseTitle = new ArrayList<CourseGrades>(); //store return arraylist
        if (courseName != null && !courseName.equals("")) { //check if the input is valid
            for (int i = 0; i < courseTotalNum; i++) {
                //oneCourse is one specific object in needFilteredArray
                CourseGrades oneCourse = needFilteredArray.get(i);
                if (oneCourse.getTitle().indexOf(courseName) != -1) {
                    requiredCourseTitle.add(oneCourse);
                }
            }
        }else{
            System.out.println("Please input valid name");
        }
        return requiredCourseTitle;
    }

    public static ArrayList<CourseGrades> courseSemester(String semester){ //Use String, becase semester number is fifficult to remember
        ArrayList<CourseGrades> requiredSemester = new ArrayList<CourseGrades>();
        //interperate String semester to semesterNumber
        int semesterNum = 0;
        if(semester == "Fall2013"){
            semesterNum = 120138;
        }else if (semester == "Fall2014"){
            semesterNum = 120148;
        }else if (semester == "Spring2013"){
            semesterNum = 120131;
        }else if (semester == "Spring2014"){
            semesterNum = 120141;
        }else if (semester == "Summer2013"){
            semesterNum = 120135;
        }else if (semester == "Summer2014"){
            semesterNum = 120145;
        }else{
            System.out.println("Your input semester name is illegal");
        }
        for (int i = 0; i < courseTotalNum; i++) {
            //oneCourse is one specific object in needFilteredArray
            CourseGrades oneCourse = needFilteredArray.get(i);
            if (oneCourse.getTerm()==semesterNum ) {
                requiredSemester.add(oneCourse);
            }
        }
        return requiredSemester;
    }

    public static ArrayList<CourseGrades> oneCourse(int courseNum, String subject){

        ArrayList<CourseGrades> requiredCourseNum = new ArrayList<CourseGrades>(); //store return arraylist
        for(int i = 0; i<courseTotalNum; i++){
            CourseGrades oneCourse = needFilteredArray.get(i);
            if(courseNum == oneCourse.getNumber()&&subject.equals(oneCourse.getSubject())){
                requiredCourseNum.add(oneCourse);
            }
        }
        return requiredCourseNum;
    }
}

