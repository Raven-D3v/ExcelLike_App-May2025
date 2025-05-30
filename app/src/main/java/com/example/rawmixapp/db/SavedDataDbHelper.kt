package com.example.rawmixapp.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.*

class SavedDataDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "saved_data.db"
        const val DATABASE_VERSION = 1

        // Table name and columns
        const val TABLE_SAVED_DATA = "saved_data"
        const val COLUMN_ID = "id"
        const val COLUMN_PAGE_TYPE = "page_type" // 1 for Page1, 2 for Page2
        const val COLUMN_DATA = "data" // JSON string containing all the data
        const val COLUMN_TIMESTAMP = "timestamp"
        const val COLUMN_TITLE = "title" // Optional title for the saved entry
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE $TABLE_SAVED_DATA (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_PAGE_TYPE INTEGER NOT NULL,
                $COLUMN_DATA TEXT NOT NULL,
                $COLUMN_TIMESTAMP INTEGER NOT NULL,
                $COLUMN_TITLE TEXT
            )
        """.trimIndent()
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_SAVED_DATA")
        onCreate(db)
    }

    fun saveData(pageType: Int, data: String, title: String? = null): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_PAGE_TYPE, pageType)
            put(COLUMN_DATA, data)
            put(COLUMN_TIMESTAMP, System.currentTimeMillis())
            put(COLUMN_TITLE, title)
        }
        return db.insert(TABLE_SAVED_DATA, null, values)
    }

    fun getAllSavedData(): List<SavedDataEntry> {
        val entries = mutableListOf<SavedDataEntry>()
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_SAVED_DATA,
            null,
            null,
            null,
            null,
            null,
            "$COLUMN_TIMESTAMP DESC"
        )

        with(cursor) {
            while (moveToNext()) {
                val id = getLong(getColumnIndexOrThrow(COLUMN_ID))
                val pageType = getInt(getColumnIndexOrThrow(COLUMN_PAGE_TYPE))
                val data = getString(getColumnIndexOrThrow(COLUMN_DATA))
                val timestamp = getLong(getColumnIndexOrThrow(COLUMN_TIMESTAMP))
                val title = getString(getColumnIndexOrThrow(COLUMN_TITLE))

                entries.add(SavedDataEntry(id, pageType, data, timestamp, title))
            }
        }
        cursor.close()
        return entries
    }

    fun getSavedData(id: Long): SavedDataEntry? {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_SAVED_DATA,
            null,
            "$COLUMN_ID = ?",
            arrayOf(id.toString()),
            null,
            null,
            null
        )

        return if (cursor.moveToFirst()) {
            val pageType = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_PAGE_TYPE))
            val data = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATA))
            val timestamp = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_TIMESTAMP))
            val title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE))
            cursor.close()
            SavedDataEntry(id, pageType, data, timestamp, title)
        } else {
            cursor.close()
            null
        }
    }

    fun deleteSavedData(id: Long): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_SAVED_DATA, "$COLUMN_ID = ?", arrayOf(id.toString()))
    }

    fun updateSavedData(id: Long, data: String): Int {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_DATA, data)
            put(COLUMN_TIMESTAMP, System.currentTimeMillis())
        }
        return db.update(TABLE_SAVED_DATA, values, "$COLUMN_ID = ?", arrayOf(id.toString()))
    }
}

data class SavedDataEntry(
    val id: Long,
    val pageType: Int,
    val data: String,
    val timestamp: Long,
    val title: String?
) {
    fun getFormattedDate(): String {
        val date = Date(timestamp)
        return java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(date)
    }
} 