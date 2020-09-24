package io.github.loshine.nbnhhsh.data

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.github.loshine.nbnhhsh.data.repo.GuessDataRepository
import io.github.loshine.nbnhhsh.data.repo.GuessRepository
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindGuessRepository(repository: GuessDataRepository): GuessRepository

    companion object {

        @Provides
        fun provideSerializer(): JsonSerializer {
            return KotlinxSerializer()
        }

        @Provides
        fun provideClient(jsonSerializer: JsonSerializer): HttpClient {
            return HttpClient(CIO) {
                install(JsonFeature) {
                    serializer = jsonSerializer
                }
            }
        }
    }
}