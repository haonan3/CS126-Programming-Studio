package com.example;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DataFilterTest {
    @Test
    public void sameDepartment() throws Exception {
        assertEquals("CS", DataFilter.sameDepartment("CS").get(0).getSubject());
        assertEquals(342, DataFilter.sameDepartment("CS").size());
    }

    @Test
    //Test the input is "" or NULL
    public void sameInstructorName() throws Exception {
        assertEquals("Arai, Sayuri", DataFilter.sameInstructorName("Sayuri").get(0).getInstructor());
        assertEquals(0, DataFilter.sameInstructorName("").size());
        assertEquals(0, DataFilter.sameInstructorName("NULL").size());
    }

    @Test
    public void courseNumRange() throws Exception {
        assertEquals("AD1", DataFilter.courseNumRange(100, 100).get(0).getSection());
        assertEquals(0, DataFilter.courseNumRange(101, 100).size());
        assertEquals(53, DataFilter.courseNumRange(225, 225).size());
    }

    @Test
    //Test the invalid input case, stuNumMin > stuNumMax
    public void courseStuNumRange() throws Exception {
        assertEquals("AD1", DataFilter.courseStuNumRange(35, 35).get(0).getSection());
        assertEquals(0, DataFilter.courseStuNumRange(36, 35).size());
    }

    @Test
    //Test the invalid cases
    public void courseTitle() throws Exception {
        assertEquals(225, DataFilter.courseTitle("Data Structure").get(0).getNumber());
        assertEquals(0, DataFilter.sameInstructorName("").size());
        assertEquals(0, DataFilter.sameInstructorName(null).size());
    }

    @Test
    public void courseSemester() throws Exception {
        assertEquals("AAS", DataFilter.courseSemester("Fall2013").get(0).getSubject());
        assertEquals(43832, DataFilter.courseSemester("Spring2013").get(0).getCRN());
    }

    @Test

    public void oneCourse() throws Exception {
        assertEquals(14, DataFilter.oneCourse(225, "CS").size());
    }

}