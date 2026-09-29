package com.inviu.demo.core

class Rover(coordinate: Coordinate, orientation: Orientation, private val board: Board) {

    private var state = RoverState(coordinate, orientation)

    fun state(): RoverState = state

    fun order(order: Order) {
        val next = order.apply(state)
        val resolved = board.resolve(next.coordinate)
        if (!board.isBlocked(resolved)) {
            state = next.copy(coordinate = resolved)
        }
    }
}
