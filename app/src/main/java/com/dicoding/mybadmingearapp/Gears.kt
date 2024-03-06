package com.dicoding.mybadmingearapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gears(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
