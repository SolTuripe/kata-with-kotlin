package gameOfLife

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun `game should be generated with given size`() {
        val game = Game(size = 3)
        assertEquals(9, game.cells.size)
    }
}