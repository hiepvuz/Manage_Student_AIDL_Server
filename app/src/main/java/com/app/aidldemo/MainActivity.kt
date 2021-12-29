package com.app.aidldemo

import android.content.ComponentName
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import com.app.aidldemo.database.DatabaseManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val TAG = this::class.simpleName


    private var mBound = false
    var mServerAIDL: ServerAIDL22? = null

    private val mServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
            mBound = true
            mServerAIDL = ServerAIDL22.Stub.asInterface(service)
            Log.d(TAG, "onServiceConnected: done")

        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            mBound = false

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
    }

    private fun initData() {
        val dbDao = DatabaseManager.getDatabase(this).studentDao()
        val c = CoroutineScope(Dispatchers.IO)
        c.launch {
            val student1 = Student("Student Name 1", 21, 7.5f, 8f, 9f)
            val student2 = Student("Student Name 2", 21, 6f, 6.2f, 5f)
            val student3 = Student("Hoc sinh 3", 21, 4f, 9f, 8f)
            val student4 = Student("Vu Hiep", 21, 8f, 8f, 10f)
            val student5 = Student("Hoc sinh 4", 21, 4.9f, 7.7f, 8.4f)
            val student6 = Student("Hoc sinh 5", 21, 7.2f, 9f, 8f)


            dbDao.insertStudent(student1)
            dbDao.insertStudent(student2)
            dbDao.insertStudent(student3)
            dbDao.insertStudent(student4)
            dbDao.insertStudent(student5)
            dbDao.insertStudent(student6)
        }
    }


}