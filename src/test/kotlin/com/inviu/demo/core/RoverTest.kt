package com.inviu.demo.core

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RoverTest {

    private val board = Board(10, 10)

    @Test
    fun `rover initializes in given coordenates`() {
        val rover = Rover(Coordinate(0,0),North,board)
        assertEquals(RoverState(Coordinate(0,0), North), rover.state())
    }

    @Test
    fun `rover initializes in given coordenates 1, 1`() {
        val rover = Rover(Coordinate(1,1),North,board)
        assertEquals(RoverState(Coordinate(1,1), North), rover.state())
    }

    @Test
    fun `rover initializes in given coordenates 2, 2, south`() {
        val rover = Rover(Coordinate(2,2),South,board)
        assertEquals(RoverState(Coordinate(2,2), South), rover.state())
    }

    @Test
    fun `rover initializes in given coordenates 0, 0, north, moves 1 to north and now is in 0,1`() {
        val rover = Rover(Coordinate(0,0),North,board)
        val initialState = rover.state()
        rover.order(Forward())
        assertEquals(RoverState(Coordinate(0,0), North), initialState)
        assertEquals(RoverState(Coordinate(0,1), North), rover.state())

    }

    @Test
    fun `rover initializes in given coordenates 0, 1, south, moves 1 to south and now is in 0,0`() {
        val rover = Rover(Coordinate(0,1),South,board)
        rover.order(Forward())
        assertEquals(RoverState(Coordinate(0,0), South), rover.state())
    }

    @Test
    fun `rover initializes in given coordenates 0, 0, east, moves 1 to east and now is in 1,0`() {
        val rover = Rover(Coordinate(0,0),East,board)
        rover.order(Forward())
        assertEquals(RoverState(Coordinate(1,0), East), rover.state())
    }

    @Test
    fun `rover initializes in given coordenates 1, 0, west, moves 1 to west and now is in 0,0`() {
        val rover = Rover(Coordinate(1,0),West,board)
        rover.order(Forward())
        assertEquals(RoverState(Coordinate(0,0), West), rover.state())
    }

    @Test
    fun `rover initializes in given coordenates 0, 1, north, moves 1 backward and now is in 0,0`() {
        val rover = Rover(Coordinate(0,1),North,board)
        rover.order(Backward())
        assertEquals(RoverState(Coordinate(0,0), North), rover.state())
    }

    @Test
    fun `rover initializes in given coordenates 0, 0, south, moves 1 backward and now is in 0,1`() {
        val rover = Rover(Coordinate(0,0),South,board)
        rover.order(Backward())
        assertEquals(RoverState(Coordinate(0,1), South), rover.state())
    }

    @Test
    fun `rover initializes in given coordenates 1, 0, east, moves 1 backward and now is in 0,0`() {
        val rover = Rover(Coordinate(1,0),East,board)
        rover.order(Backward())
        assertEquals(RoverState(Coordinate(0,0), East), rover.state())
    }

    @Test
    fun `rover initializes in given coordenates 0, 0, west, moves 1 backward and now is in 1,0`() {
        val rover = Rover(Coordinate(0,0),West,board)
        rover.order(Backward())
        assertEquals(RoverState(Coordinate(1,0), West), rover.state())
    }

    // mover a la derecha

    @Test
    fun `rover initializes looking north and turns right to look east`() {
        val rover = Rover(Coordinate(0,0),North,board)
        rover.order(TurnRight())
        assertEquals(RoverState(Coordinate(0,0), East), rover.state())
    }

    @Test
    fun `rover initializes looking east and turns right to look south`() {
        val rover = Rover(Coordinate(0,0),East,board)
        rover.order(TurnRight())
        assertEquals(RoverState(Coordinate(0,0), South), rover.state())
    }

    @Test
    fun `rover initializes looking south and turns right to look west`() {
        val rover = Rover(Coordinate(0,0),South,board)
        rover.order(TurnRight())
        assertEquals(RoverState(Coordinate(0,0), West), rover.state())
    }

    @Test
    fun `rover initializes looking west and turns right to look north`() {
        val rover = Rover(Coordinate(0,0),West,board)
        rover.order(TurnRight())
        assertEquals(RoverState(Coordinate(0,0), North), rover.state())
    }

    @Test
    fun `rover turns right and keeps its coordinate`() {
        val rover = Rover(Coordinate(3,4),North,board)
        rover.order(TurnRight())
        assertEquals(RoverState(Coordinate(3,4), East), rover.state())
    }

    @Test
    fun `rover initializes looking north and turns left to look west`() {
        val rover = Rover(Coordinate(0,0),North,board)
        rover.order(TurnLeft())
        assertEquals(RoverState(Coordinate(0,0), West), rover.state())
    }

    @Test
    fun `rover initializes looking west and turns left to look south`() {
        val rover = Rover(Coordinate(0,0),West,board)
        rover.order(TurnLeft())
        assertEquals(RoverState(Coordinate(0,0), South), rover.state())
    }

    @Test
    fun `rover initializes looking south and turns left to look east`() {
        val rover = Rover(Coordinate(0,0),South,board)
        rover.order(TurnLeft())
        assertEquals(RoverState(Coordinate(0,0), East), rover.state())
    }

    @Test
    fun `rover initializes looking east and turns left to look north`() {
        val rover = Rover(Coordinate(0,0),East,board)
        rover.order(TurnLeft())
        assertEquals(RoverState(Coordinate(0,0), North), rover.state())
    }

    @Test
    fun `rover turns left and keeps its coordinate`() {
        val rover = Rover(Coordinate(3,4),North,board)
        rover.order(TurnLeft())
        assertEquals(RoverState(Coordinate(3,4), West), rover.state())
    }
   //El mapa de Marte es finito (por defecto, una cuadrícula de $10 \times 10$,
// con coordenadas de $0$ a $9$).
// Los bordes son conectados de forma toroidal: si el Rover cruza el límite superior ($y=9$)
// avanzando al Norte, reaparece en el límite inferior ($y=0$).

    @Test
    fun `rover reaches end of mars and starts in y=0 moving forward north`() {
        val rover = Rover(Coordinate(0,9),North,board)
        rover.order(Forward())
        assertEquals(RoverState(Coordinate(0,0), North), rover.state())
    }

    // tablero de 10 x 10: al pasar el borde vuelve al lado opuesto

    @Test
    fun `rover at 0,9 looking north wraps around the board when moving forward and is in 0,0`() {
        val rover = Rover(Coordinate(0,9),North,board)
        rover.order(Forward())
        assertEquals(RoverState(Coordinate(0,0), North), rover.state())
    }

    @Test
    fun `rover at 0,0 looking south wraps around the board when moving forward and is in 0,9`() {
        val rover = Rover(Coordinate(0,0),South,board)
        rover.order(Forward())
        assertEquals(RoverState(Coordinate(0,9), South), rover.state())
    }

    @Test
    fun `rover at 9,0 looking east wraps around the board when moving forward and is in 0,0`() {
        val rover = Rover(Coordinate(9,0),East,board)
        rover.order(Forward())
        assertEquals(RoverState(Coordinate(0,0), East), rover.state())
    }

    @Test
    fun `rover at 0,0 looking west wraps around the board when moving forward and is in 9,0`() {
        val rover = Rover(Coordinate(0,0),West,board)
        rover.order(Forward())
        assertEquals(RoverState(Coordinate(9,0), West), rover.state())
    }

    @Test
    fun `rover at 0,0 looking north wraps around the board when moving backward and is in 0,9`() {
        val rover = Rover(Coordinate(0,0),North,board)
        rover.order(Backward())
        assertEquals(RoverState(Coordinate(0,9), North), rover.state())
    }

    @Test
    fun `rover at 0,9 looking south wraps around the board when moving backward and is in 0,0`() {
        val rover = Rover(Coordinate(0,9),South,board)
        rover.order(Backward())
        assertEquals(RoverState(Coordinate(0,0), South), rover.state())
    }

    @Test
    fun `rover at 0,0 looking east wraps around the board when moving backward and is in 9,0`() {
        val rover = Rover(Coordinate(0,0),East,board)
        rover.order(Backward())
        assertEquals(RoverState(Coordinate(9,0), East), rover.state())
    }

    @Test
    fun `rover at 9,0 looking west wraps around the board when moving backward and is in 0,0`() {
        val rover = Rover(Coordinate(9,0),West,board)
        rover.order(Backward())
        assertEquals(RoverState(Coordinate(0,0), West), rover.state())
    }

    // obstaculos: el rover no se mueve a una casilla bloqueada

    @Test
    fun `rover moving forward north is blocked and stays in 0,0`() {
        val boardWithObstacle = Board(10, 10, setOf(Coordinate(0,1)))
        val rover = Rover(Coordinate(0,0),North,boardWithObstacle)
        rover.order(Forward())
        assertEquals(RoverState(Coordinate(0,0), North), rover.state())
    }

    @Test
    fun `rover moving forward south is blocked and stays in 0,1`() {
        val boardWithObstacle = Board(10, 10, setOf(Coordinate(0,0)))
        val rover = Rover(Coordinate(0,1),South,boardWithObstacle)
        rover.order(Forward())
        assertEquals(RoverState(Coordinate(0,1), South), rover.state())
    }

    @Test
    fun `rover moving forward east is blocked and stays in 0,0`() {
        val boardWithObstacle = Board(10, 10, setOf(Coordinate(1,0)))
        val rover = Rover(Coordinate(0,0),East,boardWithObstacle)
        rover.order(Forward())
        assertEquals(RoverState(Coordinate(0,0), East), rover.state())
    }

    @Test
    fun `rover moving forward west is blocked and stays in 1,0`() {
        val boardWithObstacle = Board(10, 10, setOf(Coordinate(0,0)))
        val rover = Rover(Coordinate(1,0),West,boardWithObstacle)
        rover.order(Forward())
        assertEquals(RoverState(Coordinate(1,0), West), rover.state())
    }

    @Test
    fun `rover moving backward looking north is blocked and stays in 0,1`() {
        val boardWithObstacle = Board(10, 10, setOf(Coordinate(0,0)))
        val rover = Rover(Coordinate(0,1),North,boardWithObstacle)
        rover.order(Backward())
        assertEquals(RoverState(Coordinate(0,1), North), rover.state())
    }

    @Test
    fun `rover moving backward looking east is blocked and stays in 1,0`() {
        val boardWithObstacle = Board(10, 10, setOf(Coordinate(0,0)))
        val rover = Rover(Coordinate(1,0),East,boardWithObstacle)
        rover.order(Backward())
        assertEquals(RoverState(Coordinate(1,0), East), rover.state())
    }

    @Test
    fun `rover moving forward north across the edge is blocked and stays in 0,9`() {
        val boardWithObstacle = Board(10, 10, setOf(Coordinate(0,0)))
        val rover = Rover(Coordinate(0,9),North,boardWithObstacle)
        rover.order(Forward())
        assertEquals(RoverState(Coordinate(0,9), North), rover.state())
    }

    @Test
    fun `rover moves normally when the obstacle is not in its way`() {
        val boardWithObstacle = Board(10, 10, setOf(Coordinate(5,5)))
        val rover = Rover(Coordinate(0,0),North,boardWithObstacle)
        rover.order(Forward())
        assertEquals(RoverState(Coordinate(0,1), North), rover.state())
    }

    @Test
    fun `rover can turn even when the obstacle is right in front of it`() {
        val boardWithObstacle = Board(10, 10, setOf(Coordinate(0,1)))
        val rover = Rover(Coordinate(0,0),North,boardWithObstacle)
        rover.order(TurnRight())
        assertEquals(RoverState(Coordinate(0,0), East), rover.state())
    }

}
