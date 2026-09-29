package com.inviu.demo.core

object South : Orientation {
    private val dx = 0
    private val dy = -1

    override fun move(coordinate: Coordinate, displace: (Coordinate, Int, Int) -> Coordinate): Coordinate =
        displace(coordinate, dx, dy)

    override fun right(): Orientation = West

    override fun left(): Orientation = East
}
