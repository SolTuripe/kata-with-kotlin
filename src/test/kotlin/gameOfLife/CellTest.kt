package gameOfLife

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class CellTest {
    @Test
    fun `cell should die when under population`() {
        val cell = Cell(true)

        cell.nextGeneration()

        assertFalse(cell.isAlive)
    }

    @Test
    fun `cell should live when two or three living neighbors`() {
        val cell = Cell(true)

        cell.neighbors.add(Cell(true))
        cell.neighbors.add(Cell(true))

        cell.nextGeneration()

        assertTrue(cell.isAlive)
    }

    @Test
    fun `cell should die when overpopulation`() {
        val cell = Cell(true)
        cell.neighbors.add(Cell(true))
        cell.neighbors.add(Cell(true))
        cell.neighbors.add(Cell(true))
        cell.neighbors.add(Cell(true))

        cell.nextGeneration()

        assertFalse(cell.isAlive)
    }

    @Test
    fun `cell should reborn when three living neighbors`() {
        val cell = Cell(false)
        cell.neighbors.add(Cell(true))
        cell.neighbors.add(Cell(true))
        cell.neighbors.add(Cell(true))

        cell.nextGeneration()

        assertTrue(cell.isAlive)
    }
}