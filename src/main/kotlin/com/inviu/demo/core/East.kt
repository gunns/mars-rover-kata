package com.inviu.demo.core

object East : Orientation {
    private val dx = 1
    private val dy = 0

    override fun move(coordinate: Coordinate, displace: (Coordinate, Int, Int) -> Coordinate): Coordinate =
        displace(coordinate, dx, dy)

    override fun right(): Orientation = South

    override fun left(): Orientation = North
}
