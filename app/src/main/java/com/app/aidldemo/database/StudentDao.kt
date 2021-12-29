package com.app.aidldemo.database

import androidx.room.*
import com.app.aidldemo.Student

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertStudent(student: Student?)

    @Update
    fun updateStudent(student: Student?)

    @Delete
     fun deleteStudent(student: Student?)

    @Query("SELECT * FROM student")
    fun getHighestMarkStudent(): Student

    @Query("SELECT * FROM student")
    fun getStudentList(): List<Student>

    @Query("SELECT * FROM student WHERE name LIKE '%' || :search || '%'")
    fun getStudentByName(search: String): List<Student>

}