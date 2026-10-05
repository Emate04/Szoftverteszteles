import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    @Nested
    @DisplayName("area() tesztek")
    class AreaTests {
        @Test
        void testAreaCalculation() {
            Table table = new Table(100, 200, 75);
            assertEquals(20000, table.area());
        }
    }

    @Nested
    @DisplayName("getCapacity() tesztek")
    class CapacityTests {
        @Test
        void testCapacityCalculation() {
            Table table = new Table(60, 120, 75);
            assertEquals(6, table.getCapacity());
        }
    }

    @Nested
    @DisplayName("setHeight() és validáció tesztek")
    class SetHeightTests {

        @Test
        void testSetHeightWhenNotAdjustableShouldNotChange() {
            Table staticTable = new Table(80, 120, 75);
            staticTable.setHeight(85);
            assertEquals(75, staticTable.getCurrentHeight());
        }

        @Test
        void testSetHeightWhenAdjustableAndValidRange() {
            Table adjustableTable = new Table(80, 120, 75, 75);
            adjustableTable.setHeight(110);
            assertEquals(110, adjustableTable.getCurrentHeight());
        }

        @Test
        void testSetHeightLowerBoundaries() {
            Table adjustableTable = new Table(80, 120, 75, 75);

            adjustableTable.setHeight(0);
            assertEquals(0, adjustableTable.getCurrentHeight());

            adjustableTable.setHeight(-5);
            assertEquals(0, adjustableTable.getCurrentHeight());
        }

        @Test
        void testSetHeightUpperBoundaries() {
            Table adjustableTable = new Table(80, 120, 75, 75);

            adjustableTable.setHeight(200);
            assertEquals(200, adjustableTable.getCurrentHeight());

            adjustableTable.setHeight(201);
            assertEquals(200, adjustableTable.getCurrentHeight());
        }
    }

    @Nested
    @DisplayName("Gyakorló feladat tesztek")
    class PracticeTests {

        @Test
        void testRepaintChangesColor() {
            Table table = new Table(80, 120, 75, 75, true, "barna", 4);
            table.repaint("fehér");
            assertEquals("fehér", table.getColor());
        }

        @Test
        void testIsStable() {
            Table stableTable = new Table(80, 120, 75, 75, false, "barna", 3);
            Table unstableTable = new Table(80, 120, 75, 75, false, "barna", 2);

            assertTrue(stableTable.isStable());
            assertFalse(unstableTable.isStable());
        }

        @Test
        void testIsFoldable() {
            Table foldableTable = new Table(80, 120, 75, 75, true, "fekete", 4);
            assertTrue(foldableTable.isFoldable());

            Table threeLeggedAdjustable = new Table(80, 120, 75, 75, true, "fekete", 3);
            assertFalse(threeLeggedAdjustable.isFoldable());

            Table nonAdjustableTable = new Table(80, 120, 75, 75, false, "fekete", 4);
            assertFalse(nonAdjustableTable.isFoldable());
        }

        @Test
        void testGetPerimeter() {
            Table table = new Table(80, 120, 75);
            assertEquals(400, table.getPerimeter());
        }
    }
}