package com.inviu.demo.core

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BoardTest {

    private val board = Board(10, 10)

    @Test
    fun `keeps a coordinate that is inside the board`() {
        assertEquals(Coordinate(3, 4), board.resolve(Coordinate(3, 4)))
    }

    @Test
    fun `keeps the last coordinate of the board`() {
        assertEquals(Coordinate(9, 9), board.resolve(Coordinate(9, 9)))
    }

    @Test
    fun `wraps x to 0 when it reaches the width`() {
        assertEquals(Coordinate(0, 5), board.resolve(Coordinate(10, 5)))
    }

    @Test
    fun `wraps y to 0 when it reaches the height`() {
        assertEquals(Coordinate(5, 0), board.resolve(Coordinate(5, 10)))
    }

    @Test
    fun `wraps x to the last column when it goes below 0`() {
        assertEquals(Coordinate(9, 5), board.resolve(Coordinate(-1, 5)))
    }

    @Test
    fun `wraps y to the last row when it goes below 0`() {
        assertEquals(Coordinate(5, 9), board.resolve(Coordinate(5, -1)))
    }

    @Test
    fun `uses its own width and height`() {
        assertEquals(Coordinate(0, 1), Board(3, 5).resolve(Coordinate(3, 6)))
    }

    @Test
    fun `a coordinate with an obstacle is blocked`() {
        val boardWithObstacle = Board(10, 10, setOf(Coordinate(2, 3)))
        assertEquals(true, boardWithObstacle.isBlocked(Coordinate(2, 3)))
    }

    @Test
    fun `a coordinate without an obstacle is not blocked`() {
        val boardWithObstacle = Board(10, 10, setOf(Coordinate(2, 3)))
        assertEquals(false, boardWithObstacle.isBlocked(Coordinate(3, 2)))
    }

    @Test
    fun `a board without obstacles blocks nothing`() {
        assertEquals(false, board.isBlocked(Coordinate(2, 3)))
    }

}
