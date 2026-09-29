package com.inviu.demo.core

class Board(
    private val width: Int,
    private val height: Int,
    private val obstacles: Set<Coordinate> = emptySet(),
) {
    fun resolve(coordinate: Coordinate): Coordinate =
        Coordinate(Math.floorMod(coordinate.x, width), Math.floorMod(coordinate.y, height))

    fun isBlocked(coordinate: Coordinate): Boolean = coordinate in obstacles
}
