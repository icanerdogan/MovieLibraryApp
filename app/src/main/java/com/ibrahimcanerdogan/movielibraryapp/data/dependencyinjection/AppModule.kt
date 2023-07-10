package com.ibrahimcanerdogan.movielibraryapp.data.dependencyinjection

import com.ibrahimcanerdogan.movielibraryapp.data.remote.MovieAPI
import com.ibrahimcanerdogan.movielibraryapp.data.repository.MovieRepositoryImpl
import com.ibrahimcanerdogan.movielibraryapp.domain.repository.MovieRepository
import com.ibrahimcanerdogan.movielibraryapp.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieAPI() : MovieAPI {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(movieAPI: MovieAPI) : MovieRepository {
        return MovieRepositoryImpl(movieAPI)
    }
}