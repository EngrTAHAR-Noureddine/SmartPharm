package com.example.smartpharm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var userId: Long = 0L,

    @ColumnInfo(name = "typeUser")
    var typeUser: String = "",

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "locationUser")
    var locationUser: String = "",

    @ColumnInfo(name = "phoneNumber")
    var phoneNumber: String = "",

    @ColumnInfo(name = "emailUser")
    var emailUser: String = "",

    @ColumnInfo(name = "facebookAccount")
    var facebookAccount: String = "",

    @ColumnInfo(name = "instagramAccount")
    var instagramAccount: String = "",

    @ColumnInfo(name = "photoUser")
    var photoUser: String = "",

        )