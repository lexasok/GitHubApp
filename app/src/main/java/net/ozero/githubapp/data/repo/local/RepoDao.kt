package net.ozero.githubapp.data.repo.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RepoDao {

    @Insert
    fun insert(repo: RepoLocalModel)

    @Insert
    fun insertAll(vararg repos: RepoLocalModel)

    @Query("SELECT * FROM RepoLocalModel")
    fun observeAll(): LiveData<List<RepoLocalModel>>
}