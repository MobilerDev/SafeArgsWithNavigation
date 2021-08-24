package com.cevlikalprn.safeargswithnavigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val characterImage: Int,
    val characterName: String,
    val characterAge: Int
):Parcelable
