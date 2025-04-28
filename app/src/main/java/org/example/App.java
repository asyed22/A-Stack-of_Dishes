package org.example;

public class App {
    public static void main(String[] args) {
        DishStack stack = new DishStack(5); // Maximum size = 5

        Dish oneDish = new Dish("A dish with one fish pattern on it");
        Dish twoDish = new Dish("A dish with two fish patterns on it");
        Dish redDish = new Dish("A dish with a red fish pattern on it");
        Dish blueDish = new Dish("A dish with a blue fish pattern on it");

        System.out.println("Initial stack size: " + stack.size());

        stack.push(oneDish);
        stack.push(twoDish);
        stack.push(redDish);
        stack.push(blueDish);

        System.out.println("Size after pushes: " + stack.size());

        Dish peekedDish = stack.peek();
        System.out.println("Top dish description (peek): " + peekedDish.getDescription());

        Dish poppedDish = stack.pop();
        System.out.println("Popped dish description: " + poppedDish.getDescription());

        Dish anotherPoppedDish = stack.pop();
        System.out.println("Another popped dish description: " + anotherPoppedDish.getDescription());

        System.out.println("Final stack size: " + stack.size());

        stack.clear();
        System.out.println("Size after clearing: " + stack.size());
    }
}

class DishStack {
    private Dish[] stack;
    private int top;
    private int capacity;

    public DishStack(int capacity) {
        this.capacity = capacity;
        stack = new Dish[capacity];
        top = -1;
    }

    public void push(Dish item) {
        if (top >= capacity - 1) {
            System.out.println("Stack is full. Cannot push: " + item.getDescription());
            return;
        }
        stack[++top] = item;
    }

    public Dish pop() {
        if (top == -1) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        return stack[top--];
    }

    public Dish peek() {
        if (top == -1) {
            System.out.println("Stack is empty. Nothing to peek.");
            return null;
        }
        return stack[top];
    }

    public int size() {
        return top + 1;
    }

    public void clear() {
        top = -1;
        System.out.println("Stack cleared.");
    }
}
