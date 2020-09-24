package io.github.loshine.nbnhhsh.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class GuessResult(
    val name: String,
    val trans: List<String>? = null
//    val inputting: List<String>? = null
)