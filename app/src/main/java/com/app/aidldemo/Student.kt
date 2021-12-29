package com.app.aidldemo

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student(
    var name: String?,
    var age: Int,
    var math: Float,
    var literature: Float,
    var english: Float
) : Parcelable {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
        parcel.writeFloat(math)
        parcel.writeFloat(literature)
        parcel.writeFloat(english)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}