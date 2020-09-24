package io.github.loshine.nbnhhsh.data.repo

import io.github.loshine.nbnhhsh.data.entity.Guess
import io.github.loshine.nbnhhsh.data.entity.GuessResult
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GuessRepository {
    suspend fun guess(keyword: String): Flow<List<GuessResult>>
}


class GuessDataRepository @Inject constructor(private val client: HttpClient) : GuessRepository {

    override suspend fun guess(keyword: String): Flow<List<GuessResult>> = flow {
        emit(client.post("https://lab.magiconch.com/api/nbnhhsh/guess") {
            contentType(ContentType.Application.Json)
            body = Guess(text = keyword)
        })
    }
}