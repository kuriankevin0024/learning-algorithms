package com.learning.algorithms.stack;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

    @Test
    public void testLinkedStack() {
        Stack<String> stack = new LinkedStack<>();
        testStack(stack);
    }

    @Test
    public void testFixedArrayStack() {
        Stack<String> stack = new FixedArrayStack<>(5);
        testStack(stack);
    }

    @Test
    public void testResizingArrayStack() {
        Stack<String> stack = new ResizingArrayStack<>();
        testStack(stack);
    }

    private void testStack(Stack<String> stack) {
        
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");

        Assert.assertEquals(5, stack.size());
        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals("e", stack.peek());

        int count = 0;
        String result = "";
        for(String s : stack) {
            result = result + s;
            count++;
        }
        Assert.assertEquals(5 , count);
        Assert.assertEquals("edcba", result);

        Assert.assertEquals("e", stack.pop());
        Assert.assertEquals("d", stack.pop());
        Assert.assertEquals("c", stack.pop());
        Assert.assertEquals("b", stack.pop());
        Assert.assertEquals("a", stack.pop());

        Assert.assertTrue(stack.isEmpty());

        Assert.assertThrows(NoSuchElementException.class, () -> stack.peek());
        Assert.assertThrows(NoSuchElementException.class, () -> stack.pop());
    }
}
