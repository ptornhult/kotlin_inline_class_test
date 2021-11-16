package com.example.kotlininlineclass.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// FAILS BECAUSE OF
// Test.java:7: error: Entities and POJOs must have a usable public constructor. You can have an empty constructor or a constructor whose parameters match the fields (by name and type).
//@Entity(tableName = "test")
//data class Test(
//    @PrimaryKey
//    @ColumnInfo(name = "id") val id: TestId,
//)

// FAILS BECAUSE OF
// Test.java:10: error: Cannot find getter for field.
@Entity(tableName = "test")
data class Test(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: TestId,
) {
    constructor() : this(TestId(0))
}
