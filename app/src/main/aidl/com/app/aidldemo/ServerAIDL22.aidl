// ServerAIDL22.aidl
package com.app.aidldemo;

// Declare any non-default types here with import statements

interface ServerAIDL22 {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */

    List<Student> getStudentList();
    List<Student> getStudentByName(String name);
    void inserStudent(in Student s);
    void deleteStudent(in Student s);
    void updateStudent(in Student s);
    Student highestMark();
}
parcelable Student;