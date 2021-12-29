package com.app.aidldemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.app.aidldemo.database.DatabaseManager

class ServerService22 : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return mServiceAIDL
    }

    val studentDao = DatabaseManager.getDatabase(this).studentDao()

    private val mServiceAIDL = object : ServerAIDL22.Stub() {

        override fun getStudentList(): List<Student> {
            return studentDao.getStudentList()
        }

        override fun getStudentByName(name: String?): List<Student> {
            return studentDao.getStudentByName(name.toString())
        }

        override fun inserStudent(s: Student?) {
            return studentDao.insertStudent(s)
        }

        override fun deleteStudent(s: Student?) {
            return studentDao.deleteStudent(s)

        }

        override fun updateStudent(s: Student?) {
            return studentDao.updateStudent(s)
        }

        override fun highestMark(): Student {
            var highestMark = 0f

            var avgMark: Float

            var studentIndex = 0

            for (i in studentList.indices) {
                avgMark = studentList[i].math + studentList[i].literature + studentList[i].english
                if (avgMark > highestMark) {
                    highestMark = avgMark
                    studentIndex = i
                }
            }
            return studentList[studentIndex]
        }
    }

}
