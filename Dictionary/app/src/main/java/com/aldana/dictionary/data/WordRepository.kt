package com.aldana.dictionary.data

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.aldana.dictionary.data.dao.WordDao
import com.aldana.dictionary.data.models.Word

class WordRepository(private val wordDao: WordDao) {

    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}