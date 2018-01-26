package com.example;

import java.util.ArrayList;

/**
 * There are four methods in this class
 * totalStuNum will return the total students number of the input courses
 * gradedStuNum will return the student number of a given grade level in input courses
 * getWeightedGPA will return the weighted GPA of input courses
 * getAsRate will return the As rate of input courses
 */
public class DataCalculator {
    /**
     * this muthod calculate the total number of stundents of input Arraylist
     * @param filteredArray
     * @return
     */
    public static int totalStuNum(ArrayList<CourseGrades> filteredArray){
        int totalNum = 0;
        int filteredArrayLength = filteredArray.size();
        for(int i = 0; i<filteredArrayLength;i++){
            CourseGrades oneCourse = filteredArray.get(i);
            int gradesLength = oneCourse.getGrades().length;
            for(int j = 0; j < gradesLength; j++){
                totalNum += oneCourse.getGrades()[j];
            }
        }
        return totalNum;
    }

    /**
     * this method calculate the student number of certain grade level
     * @param filteredArray
     * @param level
     * @return
     */
    public static int gradedStuNum(ArrayList<CourseGrades> filteredArray, String level){
        int stuNum = 0;
        int gradeIndex = 0;
        int filteredArrayLength = filteredArray.size();
        if(level == "A+"){
            gradeIndex = 0;
        }else if(level == "A"){
            gradeIndex = 1;
        }else if(level == "A-"){
            gradeIndex = 2;
        }else if(level == "B+"){
            gradeIndex = 3;
        }else if(level == "B"){
            gradeIndex = 4;
        }else if(level == "B-"){
            gradeIndex = 5;
        }else if(level == "C+"){
            gradeIndex = 6;
        }else if(level == "C"){
            gradeIndex = 7;
        }else if(level == "C-"){
            gradeIndex = 8;
        }else if(level == "D+"){
            gradeIndex = 9;
        }else if(level == "D"){
            gradeIndex = 10;
        }else if(level == "D-"){
            gradeIndex = 11;
        }else if(level == "F"){
            gradeIndex = 12;
        }else if(level == "W"){
            gradeIndex = 13;
        }else{
            System.out.println("Invalid input");
        }

        for(int i = 0; i<filteredArrayLength; i++){
            CourseGrades oneCourse = filteredArray.get(i);
            stuNum += oneCourse.getGrades()[gradeIndex];
            }
        return stuNum;
    }

    /**
     * this method calculate weighted GPA of courses in input Arraylist
     * @param filteredArray
     * @return
     */
    public float getWeightedGPA(ArrayList<CourseGrades> filteredArray) {
        int filteredArrayLength = filteredArray.size();
        float totalGPA = 0;
        float stuTotalNum = 0;
        float weightedGPA = -1;  //if the total stuNUm is 0, then return -1, which represent invalid
        for (int i = 0; i < filteredArrayLength; i++) {
            float eachCourseStuNum = 0;
            CourseGrades oneCourse = filteredArray.get(i);
            int gradesLength = oneCourse.getGrades().length;
            for (int j = 0; j < gradesLength; j++) {
                eachCourseStuNum += oneCourse.getGrades()[j];
            }
            totalGPA += eachCourseStuNum * oneCourse.getAverage();
        }
        stuTotalNum = DataCalculator.totalStuNum(filteredArray);
        if (stuTotalNum!=0) {
            weightedGPA = totalGPA /stuTotalNum;
        }
        return weightedGPA;
    }

    /**
     * this method let students check the As rate of courses
     * @param filteredArray
     * @return
     */
    public static float getAsRate(ArrayList<CourseGrades> filteredArray) {
        float AsRate = 0;
        float AsStuNum = (float) DataCalculator.gradedStuNum(filteredArray,"A+")+
                (float) DataCalculator.gradedStuNum(filteredArray,"B")+
                (float) DataCalculator.gradedStuNum(filteredArray,"A-");
        //System.out.println(DataCalculator.gradedStuNum(filteredArray,"A+"));
        float totalStu = (float) DataCalculator.totalStuNum(filteredArray);
        System.out.println(AsStuNum);
        System.out.println(totalStu);
        AsRate = AsStuNum/totalStu;
        return AsRate*100;
    }

}
