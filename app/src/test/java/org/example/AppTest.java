package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void testStackPushAndSize() {
        DishStack<Dish> stack = new DishStack<>(3);
        assertEquals(0, stack.size());

        stack.push(new Dish("Plate 1"));
        stack.push(new Dish("Plate 2"));
        assertEquals(2, stack.size());
    }

    @Test
    void testStackPeek() {
        DishStack<Dish> stack = new DishStack<>(3);
        Dish dish = new Dish("Peek Dish");
        stack.push(dish);

        Dish peekedDish = stack.peek();
        assertNotNull(peekedDish);
        assertEquals("Peek Dish", peekedDish.getDescription());
        // Make sure peek does NOT remove
        assertEquals(1, stack.size());
    }

    @Test
    void testStackPop() {
        DishStack<Dish> stack = new DishStack<>(3);
        Dish dish1 = new Dish("Dish 1");
        Dish dish2 = new Dish("Dish 2");

        stack.push(dish1);
        stack.push(dish2);

        Dish popped = stack.pop();
        assertEquals("Dish 2", popped.getDescription());
        assertEquals(1, stack.size());
    }

    @Test
    void testStackClear() {
        DishStack<Dish> stack = new DishStack<>(3);
        stack.push(new Dish("Dish 1"));
        stack.push(new Dish("Dish 2"));

        stack.clear();
        assertEquals(0, stack.size());
        assertNull(stack.peek());
        assertNull(stack.pop());
    }
}
