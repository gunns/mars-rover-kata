package com.inviu.demo.core

class Rover(coordinate: Coordinate, orientation: Orientation, private val board: Board) {

    private var state = RoverState(coordinate, orientation)

    fun state(): RoverState = state

    fun order(order: Order) {
        when (order) {
            Order.FORWARD -> move(1)
            Order.BACKWARD -> move(-1)
            Order.TURN_RIGHT -> turnRight()
            Order.TURN_LEFT -> turnLeft()
        }
    }

    private fun move(step: Int) {
        val x = state.coordinate.x
        val y = state.coordinate.y
        val moved = when (state.orientation) {
            Orientation.NORTH -> Coordinate(x, y + step)
            Orientation.SOUTH -> Coordinate(x, y - step)
            Orientation.EAST -> Coordinate(x + step, y)
            Orientation.WEST -> Coordinate(x - step, y)
        }
        val resolved = Coordinate(
            Math.floorMod(moved.x, board.width),
            Math.floorMod(moved.y, board.height),
        )
        if (resolved !in board.obstacles) {
            state = state.copy(coordinate = resolved)
        }
    }

    private fun turnRight() {
        val next = when (state.orientation) {
            Orientation.NORTH -> Orientation.EAST
            Orientation.EAST -> Orientation.SOUTH
            Orientation.SOUTH -> Orientation.WEST
            Orientation.WEST -> Orientation.NORTH
        }
        state = state.copy(orientation = next)
    }

    private fun turnLeft() {
        val next = when (state.orientation) {
            Orientation.NORTH -> Orientation.WEST
            Orientation.WEST -> Orientation.SOUTH
            Orientation.SOUTH -> Orientation.EAST
            Orientation.EAST -> Orientation.NORTH
        }
        state = state.copy(orientation = next)
    }
}
