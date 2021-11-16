package com.example.kotlininlineclass.dataclass

import com.example.kotlininlineclass.db.TestId

private data class TestDataClass(val id: TestId)

fun main() {

    println(TestId(1) == TestId(1))
    println(TestId(1) != TestId(2))
    // Illegal check by ref for value class assert(TestId(1) === TestId(1))
    println(TestDataClass(TestId(1)) == TestDataClass(TestId(1)))
    println(TestDataClass(TestId(1)) !== TestDataClass(TestId(1)))

    println(TestDataClass(TestId(1)) == TestDataClass(TestId(2)).copy(id = TestId(1)))
    println(1 == TestDataClass(TestId(2)).copy(id = TestId(1)).id.id)
}
