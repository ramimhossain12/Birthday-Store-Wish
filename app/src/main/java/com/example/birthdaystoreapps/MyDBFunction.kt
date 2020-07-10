package com.example.birthdaystoreapps

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBFunction internal constructor(c: Context?) : SQLiteOpenHelper(c, DATABSE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        val s = "CREATE TABLE $TABLE_NAME ($TAB_ID INTEGER PRIMARY KEY, $TAB_NAME TEXT, $TAB_DAYS TEXT)"
        db.execSQL(s)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

    // ---- ---- adding data to database --- -----
    fun addingDataToTable(dt: DataTemp) {
        val sqd = this.writableDatabase
        val cv = ContentValues()
        cv.put(TAB_NAME, dt.name)
        cv.put(TAB_DAYS, dt.day)
        sqd.insert(TABLE_NAME, null, cv)
        sqd.close()
    }

    // --- ---- showing data ------ ----
    fun my_data(): Array<String?> {
        val sq = this.readableDatabase
        val q = "SELECT * FROM $TABLE_NAME"
        val c = sq.rawQuery(q, null)
        val recvied_data = arrayOfNulls<String>(c.count)
        c.moveToFirst()
        if (c.moveToFirst()) {
            var counter = 0
            do {
                recvied_data[counter] = """
                    ${c.getString(c.getColumnIndex(TAB_NAME + ""))}
                    Birthday: ${c.getString(c.getColumnIndex(TAB_DAYS + ""))}
                    """.trimIndent()
                counter = counter + 1
            } while (c.moveToNext())
        }
        return recvied_data
    }

    fun fetch_day(id: Int): String {
        val sq = this.readableDatabase
        val q = "SELECT $TAB_DAYS FROM $TABLE_NAME WHERE $TAB_ID = $id"
        val c = sq.rawQuery(q, null)
        var s = ""
        c.moveToFirst()
        if (c.moveToFirst()) {
            s = c.getString(c.getColumnIndex(TAB_DAYS + ""))
        }
        return s
    }

    fun update_birthday(id: Int, bday: String?): Int {
        val sq = this.writableDatabase
        val cv = ContentValues()
        cv.put(TAB_DAYS, bday)
        return sq.update(TABLE_NAME, cv, "$TAB_ID = ? ", arrayOf(id.toString() + ""))
    }

    fun delete_bday(bday: String): Int {
        val s = this.writableDatabase
        return s.delete(TABLE_NAME, "$TAB_DAYS = ?", arrayOf(bday))
    }

    companion object {
        private const val DATABSE_NAME = "mydb"
        private const val TABLE_NAME = "mytab"
        private const val TAB_ID = "id"
        private const val TAB_NAME = "name"
        private const val TAB_DAYS = "days"
    }
}