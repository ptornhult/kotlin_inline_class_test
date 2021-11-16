package com.example.kotlininlineclass.parcel

import android.os.Parcel
import android.os.Parcelable
import com.example.kotlininlineclass.db.TestId
import kotlinx.parcelize.Parcelize


@Parcelize
private data class TestDataClass(val id: TestId) : Parcelable

fun main() {
    val testData = TestDataClass(TestId(42))

    // Obtain a Parcel object and write the parcelable object to it:
    // Obtain a Parcel object and write the parcelable object to it:
    val parceled = testData.forceParcel()
    print(testData == parceled)

}

inline fun <reified T> T.forceParcel(): T? where T : Parcelable {
    val bytes = Parcel.obtain().use {
        writeParcelable(this@forceParcel, 0)
        marshall()
    }
    return Parcel.obtain().use {
        unmarshall(bytes, 0, bytes.size)
        setDataPosition(0)
        readParcelable(T::class.java.classLoader)
    }
}

inline fun <reified T> Parcel.use(action: Parcel.() -> T): T {
    return try {
        action()
    } finally {
        recycle()
    }
}
