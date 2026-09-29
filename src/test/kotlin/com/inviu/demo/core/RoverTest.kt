package com.inviu.demo.core

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RoverTest {

    @Test
    fun `rover initializes in given coordenates`() {
        val rover = Rover(Coordinate(0,0),North)
        assertEquals(Coordinate(0,0), rover.coordinate())
        assertEquals(North, rover.orientation())
    }

    @Test
    fun `rover initializes in given coordenates 1, 1`() {
        val rover = Rover(Coordinate(1,1),North)
        assertEquals(Coordinate(1,1), rover.coordinate())
        assertEquals(North, rover.orientation())
    }

    @Test
    fun `rover initializes in given coordenates 2, 2, south`() {
        val rover = Rover(Coordinate(2,2),South)
        assertEquals(Coordinate(2,2), rover.coordinate())
        assertEquals(South, rover.orientation())
    }

    @Test
    fun `rover initializes in given coordenates 0, 0, north, moves 1 to north and now is in 0,1`() {
        val rover = Rover(Coordinate(0,0),North)
        val coordinate = rover.coordinate()
        rover.order(Forward())
        assertEquals(Coordinate(0,0), coordinate)
        assertEquals(Coordinate(0,1), rover.coordinate())
        assertEquals(North, rover.orientation())

    }

    @Test
    fun `rover initializes in given coordenates 0, 1, south, moves 1 to south and now is in 0,0`() {
        val rover = Rover(Coordinate(0,1),South)
        rover.order(Forward())
        assertEquals(Coordinate(0,0), rover.coordinate())
        assertEquals(South, rover.orientation())
    }

    @Test
    fun `rover initializes in given coordenates 0, 0, east, moves 1 to east and now is in 1,0`() {
        val rover = Rover(Coordinate(0,0),East)
        rover.order(Forward())
        assertEquals(Coordinate(1,0), rover.coordinate())
        assertEquals(East, rover.orientation())
    }

    @Test
    fun `rover initializes in given coordenates 1, 0, west, moves 1 to west and now is in 0,0`() {
        val rover = Rover(Coordinate(1,0),West)
        rover.order(Forward())
        assertEquals(Coordinate(0,0), rover.coordinate())
        assertEquals(West, rover.orientation())
    }

    @Test
    fun `rover initializes in given coordenates 0, 1, north, moves 1 backward and now is in 0,0`() {
        val rover = Rover(Coordinate(0,1),North)
        rover.order(Backward())
        assertEquals(Coordinate(0,0), rover.coordinate())
        assertEquals(North, rover.orientation())
    }

    @Test
    fun `rover initializes in given coordenates 0, 0, south, moves 1 backward and now is in 0,1`() {
        val rover = Rover(Coordinate(0,0),South)
        rover.order(Backward())
        assertEquals(Coordinate(0,1), rover.coordinate())
        assertEquals(South, rover.orientation())
    }

    @Test
    fun `rover initializes in given coordenates 1, 0, east, moves 1 backward and now is in 0,0`() {
        val rover = Rover(Coordinate(1,0),East)
        rover.order(Backward())
        assertEquals(Coordinate(0,0), rover.coordinate())
        assertEquals(East, rover.orientation())
    }

    @Test
    fun `rover initializes in given coordenates 0, 0, west, moves 1 backward and now is in 1,0`() {
        val rover = Rover(Coordinate(0,0),West)
        rover.order(Backward())
        assertEquals(Coordinate(1,0), rover.coordinate())
        assertEquals(West, rover.orientation())
    }

    // mover a la derecha

    @Test
    fun `rover initializes looking north and turns right to look east`() {
        val rover = Rover(Coordinate(0,0),North)
        rover.order(TurnRight())
        assertEquals(East, rover.orientation())
    }

    @Test
    fun `rover initializes looking east and turns right to look south`() {
        val rover = Rover(Coordinate(0,0),East)
        rover.order(TurnRight())
        assertEquals(South, rover.orientation())
    }

    @Test
    fun `rover initializes looking south and turns right to look west`() {
        val rover = Rover(Coordinate(0,0),South)
        rover.order(TurnRight())
        assertEquals(West, rover.orientation())
    }

    @Test
    fun `rover initializes looking west and turns right to look north`() {
        val rover = Rover(Coordinate(0,0),West)
        rover.order(TurnRight())
        assertEquals(North, rover.orientation())
    }

    @Test
    fun `rover turns right and keeps its coordinate`() {
        val rover = Rover(Coordinate(3,4),North)
        rover.order(TurnRight())
        assertEquals(Coordinate(3,4), rover.coordinate())
    }

    @Test
    fun `rover initializes looking north and turns left to look west`() {
        val rover = Rover(Coordinate(0,0),North)
        rover.order(TurnLeft())
        assertEquals(West, rover.orientation())
    }

    @Test
    fun `rover initializes looking west and turns left to look south`() {
        val rover = Rover(Coordinate(0,0),West)
        rover.order(TurnLeft())
        assertEquals(South, rover.orientation())
    }

    @Test
    fun `rover initializes looking south and turns left to look east`() {
        val rover = Rover(Coordinate(0,0),South)
        rover.order(TurnLeft())
        assertEquals(East, rover.orientation())
    }

    @Test
    fun `rover initializes looking east and turns left to look north`() {
        val rover = Rover(Coordinate(0,0),East)
        rover.order(TurnLeft())
        assertEquals(North, rover.orientation())
    }

    @Test
    fun `rover turns left and keeps its coordinate`() {
        val rover = Rover(Coordinate(3,4),North)
        rover.order(TurnLeft())
        assertEquals(Coordinate(3,4), rover.coordinate())
    }

}
