package com.inviu.demo.core

interface Order {
    fun apply(state: RoverState): RoverState
}
