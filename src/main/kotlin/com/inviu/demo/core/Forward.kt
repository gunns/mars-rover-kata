package com.inviu.demo.core

class Forward : Order {
    override fun apply(state: RoverState): RoverState =
        state.copy(
            coordinate = state.orientation.move(state.coordinate) { coordinate, dx, dy ->
                Coordinate(coordinate.x + dx, coordinate.y + dy)
            }
        )
}
