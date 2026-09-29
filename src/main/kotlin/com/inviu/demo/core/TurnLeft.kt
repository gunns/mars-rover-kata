package com.inviu.demo.core

class TurnLeft : Order {
    override fun apply(state: RoverState): RoverState =
        state.copy(orientation = state.orientation.left())
}
