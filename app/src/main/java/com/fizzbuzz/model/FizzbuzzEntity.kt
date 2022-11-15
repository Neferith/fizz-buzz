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
    var int1: Int,
    var int2: Int,
    var limit: Int,
    var str1: String,
    var str2: String
) : Parcelable