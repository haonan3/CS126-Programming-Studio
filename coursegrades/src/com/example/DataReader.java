package com.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReader {
    // We're providing 2 years worth of data
    public static final String[] JSON_FILES = {"Fall2013.json", "Fall2014.json", "Spring2013.json",
            "Spring2014.json", "Summer2013.json", "Summer2014.json"};

    /**
     * Return the names of the data files as an ArrayList
     *
     * @return an ArrayList of Strings containing the names of the JSON files
     */
    public static List<String> getJsonFilesAsList() {
        // Arrays is a Java library containing utility functions for working with Java arrays.  We're
        // using the 'asList' method which returns a List interface for an existing array.  We use
        // this to construct an actual ArrayList.  Observant readers might note that this function
        // returns an ArrayList, but the return type of the function is a List.  List is an interface
        // that ArrayList implements; we'll talk about interfaces on Tuesday.
        return new ArrayList<String>(Arrays.asList(JSON_FILES));
    }

    public static ArrayList<String> getJsonFilesAsArraylist(){
        return new ArrayList<String>(Arrays.asList(JSON_FILES));
    }

    /**
     * This function reads the contents of a file located in the project's 'data' directory into a String
     *
     * @param filename contains the name of file
     * @return a String containing the file's contents
     */
    public static String getFileContentsAsString(String filename) {

        // Java uses Paths as an operating system-independent specification of the location of files.
        // In this case, we're looking for files that are in a directory called 'data' located in the
        // root directory of the project, which is the 'current working directory'.
        final Path path = FileSystems.getDefault().getPath("data", filename);

        try {
            // Read all of the bytes out of the file specified by 'path' and then convert those bytes
            // into a Java String.  Because this operation can fail if the file doesn't exist, we
            // include this in a try/catch block
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            // Since we couldn't find the file, there is no point in trying to continue.  Let the
            // user know what happened and exit the run of the program.  Note: we're only exiting
            // in this way because we haven't talked about exceptions and throwing them in CS 126 yet.
            System.out.println("Couldn't find file: " + filename);
            System.exit(-1);
            return null;  // note that this return will never execute, but Java wants it there.
        }
    }

    /**
     * @param
     * @return courseGradesCotentsArrayTotal is the Arraylist have all CourseGRades objects
     */

    public static ArrayList<CourseGrades> storeFileCotents(){
        Gson gson = new Gson();
        ArrayList<CourseGrades> courseGradesCotentsArrayTotal = new ArrayList<CourseGrades>();

        //create CourseGrades array for every semester
        CourseGrades[] courseDate_Fall2013;
        CourseGrades[] courseDate_Fall2014;
        CourseGrades[] courseDate_Spring2013;
        CourseGrades[] courseDate_Spring2014;
        CourseGrades[] courseDate_Summer2013;
        CourseGrades[] courseDate_Summer2014;

        //parse every file and store strings in CourseGrades arrays
        courseDate_Fall2013 = gson.fromJson(DataReader.getFileContentsAsString("Fall2013.json"),CourseGrades[].class);
        courseDate_Fall2014 = gson.fromJson(DataReader.getFileContentsAsString("Fall2014.json"),CourseGrades[].class);
        courseDate_Spring2013 = gson.fromJson(DataReader.getFileContentsAsString("Spring2013.json"),CourseGrades[].class);
        courseDate_Spring2014 = gson.fromJson(DataReader.getFileContentsAsString("Spring2014.json"),CourseGrades[].class);
        courseDate_Summer2013 = gson.fromJson(DataReader.getFileContentsAsString("Summer2013.json"),CourseGrades[].class);
        courseDate_Summer2014 = gson.fromJson(DataReader.getFileContentsAsString("Summer2014.json"),CourseGrades[].class);

        //transform array into arraylist
        ArrayList<CourseGrades> courseGradesContentsArrayFall2013 = new ArrayList<CourseGrades>(Arrays.asList(courseDate_Fall2013));
        ArrayList<CourseGrades> courseGradesContentsArrayFall2014= new ArrayList<CourseGrades>(Arrays.asList(courseDate_Fall2014));
        ArrayList<CourseGrades> courseGradesContentsArraySpring2013= new ArrayList<CourseGrades>(Arrays.asList(courseDate_Spring2013));
        ArrayList<CourseGrades> courseGradesContentsArraySpring2014= new ArrayList<CourseGrades>(Arrays.asList(courseDate_Spring2014));
        ArrayList<CourseGrades> courseGradesContentsArraySummer2013 = new ArrayList<CourseGrades>(Arrays.asList(courseDate_Summer2013));
        ArrayList<CourseGrades> courseGradesContentsArraySummer2014 = new ArrayList<CourseGrades>(Arrays.asList(courseDate_Summer2014));

        //merge six Arraylist together
        courseGradesCotentsArrayTotal.addAll(courseGradesContentsArrayFall2013);
        courseGradesCotentsArrayTotal.addAll(courseGradesContentsArrayFall2014);
        courseGradesCotentsArrayTotal.addAll(courseGradesContentsArraySpring2013);
        courseGradesCotentsArrayTotal.addAll(courseGradesContentsArraySpring2014);
        courseGradesCotentsArrayTotal.addAll(courseGradesContentsArraySummer2013);
        courseGradesCotentsArrayTotal.addAll(courseGradesContentsArraySummer2014);

        return courseGradesCotentsArrayTotal;
    }

//where should I put my main function?

/*
    public static void main(String[] args) {
        ArrayList<String> dataArray;
        int fileNumber;
        GetData getFileData = new GetData();
        fileNumber = GetData.getJsonFilesAsList().size();


    }
*/
}
