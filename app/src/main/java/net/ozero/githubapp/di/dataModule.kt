package net.ozero.githubapp.di

import android.content.Context
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import net.ozero.githubapp.BuildConfig
import net.ozero.githubapp.data.database.RoomAppDatabase
import net.ozero.githubapp.data.repo.remote.ApiClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.erased.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun dataModule(appContext: Context) = Kodein.Module(name = "data") {

    // Room Database
    bind<RoomAppDatabase>() with singleton {
        Room
            .databaseBuilder(appContext, RoomAppDatabase::class.java, BuildConfig.DATABASE_NAME)
            .build()
    }

    // Retrofit Client
    bind<ApiClient>() with singleton {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.HEADERS
        val client = OkHttpClient().newBuilder()
        client.interceptors().add(interceptor)

        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(ApiClient::class.java)
    }
}