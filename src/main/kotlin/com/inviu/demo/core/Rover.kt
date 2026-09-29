package com.inviu.demo.core

class Rover(coordinate: Coordinate, orientation: Orientation) {

    private var state = RoverState(coordinate, orientation)

    fun coordinate(): Coordinate = state.coordinate

    fun orientation(): Orientation = state.orientation

    fun order(order: Order) {
        state = order.apply(state)
    }
}
