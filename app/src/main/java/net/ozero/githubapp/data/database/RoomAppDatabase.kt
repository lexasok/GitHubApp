package net.ozero.githubapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import net.ozero.githubapp.BuildConfig
import net.ozero.githubapp.data.repo.local.RepoDao
import net.ozero.githubapp.data.repo.local.RepoLocalModel
import net.ozero.githubapp.entity.Repo

@Database(entities = [RepoLocalModel::class], version = BuildConfig.DATABASE_VERSION)
abstract class RoomAppDatabase : RoomDatabase() {

    abstract fun repoDao(): RepoDao
}