package com.example.kotlininlineclass


// class UserId(val id: Int)

@JvmInline
value class UserId(val id: Int)

val uid = UserId(1)

@JvmInline
value class UserId2(val id: UserId)

val uid2 = UserId2(uid)


class User(val id: Int, val name: String)

@JvmInline
value class Staff(val user: User)

val staff = Staff(User(1, "Anna"))

fun main() {
    println("TEST: $uid")
    println("TEST: $uid2")
    println("TEST: $staff")
    assert(uid.id == 1)
}

//
// class OwnerId(id: Int): UserId(id)
//
// fun setSalary(salary: Int, userId: Int) { ... }
// setSalary(userId, 1_000)
