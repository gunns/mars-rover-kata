package com.inviu.demo.core

interface Orientation {
    fun move(coordinate: Coordinate, displace: (Coordinate, Int, Int) -> Coordinate): Coordinate

    fun right(): Orientation

    fun left(): Orientation
}
