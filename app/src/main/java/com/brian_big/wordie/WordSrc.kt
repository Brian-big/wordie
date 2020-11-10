package com.brian_big.wordie

import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName = "word_table")
data class Word(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    val word: String)

@Dao
interface WordDao{
    @Insert
    fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word?>>?

}