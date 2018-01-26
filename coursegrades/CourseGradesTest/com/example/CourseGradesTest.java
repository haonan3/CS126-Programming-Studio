package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseGradesTest {
    public static final String JSON_FOR_ONE_COURSE = "{ \"CRN\": 41758, \"Subject\": \"AAS\", \"Number\": 100, \"Title\": \"Intro Asian American Studies\", \"Section\": \"AD1\", \"Type\": \"DIS\", \"Term\": 120138, \"Instructor\": \"Arai, Sayuri\", \"Grades\": [6, 16, 5, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0], \"Average\": 3.72 }";
    public static final String JSON_FOR_ARRAY_COURSES = "[\n" +
            "  { \"CRN\": 41758, \"Subject\": \"AAS\", \"Number\": 100, \"Title\": \"Intro Asian American Studies\", \"Section\": \"AD1\", \"Type\": \"DIS\", \"Term\": 120138, \"Instructor\": \"Arai, Sayuri\", \"Grades\": [6, 16, 5, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0], \"Average\": 3.72 },\n" +
            "  { \"CRN\": 47100, \"Subject\": \"AAS\", \"Number\": 100, \"Title\": \"Intro Asian American Studies\", \"Section\": \"AD2\", \"Type\": \"DIS\", \"Term\": 120138, \"Instructor\": \"Arai, Sayuri\", \"Grades\": [6, 11, 4, 5, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0], \"Average\": 3.64 },\n" +
            "  { \"CRN\": 47102, \"Subject\": \"AAS\", \"Number\": 100, \"Title\": \"Intro Asian American Studies\", \"Section\": \"AD3\", \"Type\": \"DIS\", \"Term\": 120138, \"Instructor\": \"Davis, Thomas E\", \"Grades\": [2, 24, 1, 2, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0], \"Average\": 3.75 },\n" +
            "  { \"CRN\": 51248, \"Subject\": \"AAS\", \"Number\": 100, \"Title\": \"Intro Asian American Studies\", \"Section\": \"AD4\", \"Type\": \"DIS\", \"Term\": 120138, \"Instructor\": \"Davis, Thomas E\", \"Grades\": [7, 16, 4, 4, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0], \"Average\": 3.71 },\n" +
            "  { \"CRN\": 58861, \"Subject\": \"VM\", \"Number\": 610, \"Title\": \"Medicine and Surgery II\", \"Section\": \"AL1\", \"Type\": \"LEC\", \"Term\": 120138, \"Instructor\": \"Ridgway, Marcella D\", \"Grades\": [0, 9, 0, 0, 64, 0, 0, 46, 0, 0, 2, 0, 0, 0], \"Average\": 2.66 }\n" +
            "]\n";
    private CourseGrades courseGrades;
    private CourseGrades[] courseGradesArray;

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        courseGrades = gson.fromJson(JSON_FOR_ONE_COURSE,CourseGrades.class);
        courseGradesArray = gson.fromJson(JSON_FOR_ARRAY_COURSES,CourseGrades[].class);
    }

    @Test
    public void getCRN() throws Exception {

        assertEquals(41758,courseGrades.getCRN());
        assertEquals(41758,courseGradesArray[0].getCRN());
    }
//
    @Test
    public void getSubject() throws Exception {
    }

    @Test
    public void getNumber() throws Exception {
    }

    @Test
    public void getTitle() throws Exception {
    }

    @Test
    public void getSection() throws Exception {
    }

    @Test
    public void getType() throws Exception {
    }

    @Test
    public void getTerm() throws Exception {
    }

    @Test
    public void getInstructor() throws Exception {
    }

    @Test
    public void getGrades() throws Exception {
    assertEquals(11, courseGradesArray[1].getGrades()[1]); // notice: I can get one int for array by this way
    }

    @Test
    public void getAverage() throws Exception {
    }

}