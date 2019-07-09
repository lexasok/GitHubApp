package net.ozero.githubapp.data.repo.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repo: RepoLocalModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg repos: RepoLocalModel)

    @Query("SELECT * FROM RepoLocalModel")
    fun observeAll(): LiveData<List<RepoLocalModel>>

    @Query("SELECT * FROM RepoLocalModel ORDER BY id DESC LIMIT 1")
    fun last(): RepoLocalModel?

    @Query("SELECT * FROM RepoLocalModel WHERE id = :id" )
    fun observeById(id: Long): LiveData<RepoLocalModel>
}