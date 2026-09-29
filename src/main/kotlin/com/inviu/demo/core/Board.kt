package com.inviu.demo.core

data class Board(
    val width: Int,
    val height: Int,
    val obstacles: Set<Coordinate> = emptySet(),
)
