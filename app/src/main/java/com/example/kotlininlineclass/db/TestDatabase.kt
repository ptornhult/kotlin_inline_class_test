package com.example.kotlininlineclass.db

// FAILS BECAUSE OF
// TestIdTypeConverter.java:6: error: Class is referenced as a converter but it does not have any converter methods.
//@Database(
//    entities = [
//        Test::class,
//    ], version = 1
//)
//@TypeConverters(
//    TestIdTypeConverter::class,
//)
//abstract class TestDatabase : RoomDatabase() {
//    abstract fun testDao(): TestDao
//
//    companion object {
//        fun create(context: Context): TestDatabase = Room.inMemoryDatabaseBuilder(context.applicationContext, TestDatabase::class.java)
//            .build()
//    }
//}

// FAILS BECAUSE OF
// Test.java:7: error: Entities and POJOs must have a usable public constructor. You can have an empty constructor or a constructor whose parameters match the fields (by name and type).
//@Database(
//    entities = [
//        Test::class,
//    ], version = 1
//)
//abstract class TestDatabase : RoomDatabase() {
//    abstract fun testDao(): TestDao
//
//    companion object {
//        fun create(context: Context): TestDatabase = Room.inMemoryDatabaseBuilder(context.applicationContext, TestDatabase::class.java)
//            .build()
//    }
//}
