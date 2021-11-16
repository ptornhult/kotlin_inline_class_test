package com.example.kotlininlineclass.db

import androidx.room.TypeConverter
import com.example.kotlininlineclass.UserId

class UserIdTypeConverter {
    @TypeConverter
    fun toInt(userId: UserId?): Int? = userId?.id

    @TypeConverter
    fun toUserId(id: Int?): UserId? = id?.let { UserId(it) }
}
