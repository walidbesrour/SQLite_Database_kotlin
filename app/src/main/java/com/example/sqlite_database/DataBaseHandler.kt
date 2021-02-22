package com.example.sqlite_database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME ="MyDB"
val TABLE_NAME = "Users"
val COL_AGE = "age"
var COL_NAME = "name"
val COL_ID ="id"

class DataBaseHandler(var context : Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE" + TABLE_NAME + " (" +
                COL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME + " VARCHAR(256)," +
                COL_AGE + " INTEGER)"
//        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
//                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
//                COL_NAME + " VARCHAR(256)," +
//                COL_AGE +" INTEGER)"
        db?.execSQL(createTable)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user: User){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME, user.name)
        cv.put(COL_AGE,user.age)
        var result = db.insert(TABLE_NAME,null,cv)
        if(result == -1.toLong()){
            Toast.makeText(context,"FAILED",Toast.LENGTH_LONG).show()
            println("*******failed***********")
        }
        else
        {
            Toast.makeText(context,"Success",Toast.LENGTH_LONG).show()
            println("*******Success***********")
        }


    }
}