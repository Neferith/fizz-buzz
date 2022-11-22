package com.fizzbuzz.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * The fizzbuzz params
 * This class just describe application parameters
 * The Parcelable implementation is used to pass the instance of a class as a parameter of an intent.
 */
@Parcelize
data class FizzbuzzEntity(
    var int1: Long = 3,
    var int2: Long = 5,
    var limit: Long = Long.MAX_VALUE,
    var str1: String = "fizz",
    var str2: String = "buzz"
) : Parcelable