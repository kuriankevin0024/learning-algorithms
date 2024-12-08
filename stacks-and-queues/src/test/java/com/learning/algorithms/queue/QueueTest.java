package com.learning.algorithms.queue;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

    @Test
    public void testLinkedQueue() {
        Queue<String> queue = new LinkedQueue<>();
        testQueue(queue);
    }

    @Test
    public void testFixedArrayQueue() {
        Queue<String> queue = new FixedArrayQueue<>(5);
        testQueue(queue);
    }

    @Test
    public void testResizingArrayQueue() {
        Queue<String> queue = new ResizingArrayQueue<>();
        testQueue(queue);
    }

    private void testQueue(Queue<String> queue) {
        
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");

        Assert.assertEquals(5, queue.size());
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals("a", queue.peek());

        int count = 0;
        String result = "";
        for(String s : queue) {
            result = result + s;
            count++;
        }
        Assert.assertEquals(5 , count);
        Assert.assertEquals("abcde", result);

        Assert.assertEquals("a", queue.dequeue());
        Assert.assertEquals("b", queue.dequeue());
        Assert.assertEquals("c", queue.dequeue());
        Assert.assertEquals("d", queue.dequeue());
        Assert.assertEquals("e", queue.dequeue());

        Assert.assertTrue(queue.isEmpty());

        Assert.assertThrows(NoSuchElementException.class, () -> queue.peek());
        Assert.assertThrows(NoSuchElementException.class, () -> queue.dequeue());
    }
}
