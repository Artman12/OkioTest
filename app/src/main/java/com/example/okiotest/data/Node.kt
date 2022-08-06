package com.example.okiotest.data

import kotlinx.serialization.Serializable


/**
 * Created by artman on 06.08.2022.
 */
@Serializable
data class Node(
    val children: List<Node>?
)
