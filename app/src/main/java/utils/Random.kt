package utils

fun randint(min: Int, max: Int): Int =
    (min + Math.random() * (max - min + 1)).toInt()
// Esta es la función randint que menciono en el enunciado