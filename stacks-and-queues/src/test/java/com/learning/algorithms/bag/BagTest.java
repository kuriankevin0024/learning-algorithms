package com.learning.algorithms.bag;

import org.junit.Assert;
import org.junit.Test;

public class BagTest {

    @Test
    public void testLinkedBag() {
        Bag<String> bag = new LinkedBag<>();
        
        bag.add("a");
        bag.add("b");
        bag.add("c");
        bag.add("d");
        bag.add("e");

        Assert.assertEquals(5, bag.size());

        int count = 0;
        String result = "";
        for(String s : bag) {
            result = result + s;
            count++;
        }
        Assert.assertEquals(5 , count);
        Assert.assertEquals("edcba", result);
    }

    @Test
    public void testFixedArrayBag() {
        Bag<String> bag = new FixedArrayBag<>(5);
        
        bag.add("a");
        bag.add("b");
        bag.add("c");
        bag.add("d");
        bag.add("e");

        Assert.assertEquals(5, bag.size());

        int count = 0;
        String result = "";
        for(String s : bag) {
            result = result + s;
            count++;
        }
        Assert.assertEquals(5 , count);
        Assert.assertEquals("abcde", result);
    }

    @Test
    public void testResizingArrayBag() {
        Bag<String> bag = new ResizingArrayBag<>();
        
        bag.add("a");
        bag.add("b");
        bag.add("c");
        bag.add("d");
        bag.add("e");

        Assert.assertEquals(5, bag.size());

        int count = 0;
        String result = "";
        for(String s : bag) {
            result = result + s;
            count++;
        }
        Assert.assertEquals(5 , count);
        Assert.assertEquals("abcde", result);
    }
}
