package com.example.kotlininlineclass.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
abstract class TestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(test: Test)

    @Query("SELECT * FROM test WHERE id = :id")
    abstract suspend fun getById(id: TestId): Test?

    @Query("SELECT * FROM test")
    abstract suspend fun list(): List<Test>
}
