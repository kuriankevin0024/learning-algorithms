package com.learning.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

/**
 * JUnit 4 Test Cases for Union-Find Implementations
 */
public class UnionFindTest {

    /**
     * Helper method to perform a series of union and connected operations
     * and validate the expected outcomes on a given UnionFind instance.
     *
     * @param uf the UnionFind instance to test
     */
    private void performTests(UnionFind uf) {
        // Initially, all elements are separate
        assertEquals("Initial count should be equal to number of elements", 10, uf.count());

        // Connect some elements
        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(4, 5);
        uf.union(6, 7);
        uf.union(8, 9);

        assertTrue("0 and 1 should be connected", uf.connected(0, 1));
        assertTrue("2 and 3 should be connected", uf.connected(2, 3));
        assertTrue("4 and 5 should be connected", uf.connected(4, 5));
        assertTrue("6 and 7 should be connected", uf.connected(6, 7));
        assertTrue("8 and 9 should be connected", uf.connected(8, 9));

        assertEquals("Count should be 5 after initial unions", 5, uf.count());

        // Perform more unions
        uf.union(1, 2);
        uf.union(5, 6);
        uf.union(3, 7);

        assertTrue("0 and 3 should be connected", uf.connected(0, 3));
        assertTrue("4 and 7 should be connected", uf.connected(4, 7));

        // Corrected expected count from 3 to 2
        assertEquals("Count should be 2 after more unions", 2, uf.count());

        // Final unions to connect all
        uf.union(0, 4);
        uf.union(7, 8);

        assertEquals("All elements should be connected", 1, uf.count());
    }

    @Test
    public void testQuickFind() {
        UnionFind uf = new _1_QuickFind(10);
        performTests(uf);
    }

    @Test
    public void testQuickUnion() {
        UnionFind uf = new _2_QuickUnion(10);
        performTests(uf);
    }

    @Test
    public void testWeightedQuickUnion() {
        UnionFind uf = new _3_WeightedQuickUnionBySize(10);
        performTests(uf);
    }

    @Test
    public void testWeightedQuickUnionByRank() {
        UnionFind uf = new _4_WeightedQuickUnionByRank(10);
        performTests(uf);
    }

    @Test
    public void testQUWithPathCompression() {
        UnionFind uf = new _5_QUWithPathCompressionOnePass(10);
        performTests(uf);
    }

    @Test
    public void testQUWithPathCompressionTwoPass() {
        UnionFind uf = new _6_QUWithPathCompressionTwoPass(10);
        performTests(uf);
    }

    @Test
    public void testWQUWIthPathCompression() {
        UnionFind uf = new _7_WQUWIthPathCompression(10);
        performTests(uf);
    }

    /**
     * Additional Test Cases to cover edge scenarios
     */
    @Test
    public void testNoConnections() {
        List<UnionFind> implementations = Arrays.asList(
                new _1_QuickFind(5),
                new _2_QuickUnion(5),
                new _3_WeightedQuickUnionBySize(5),
                new _4_WeightedQuickUnionByRank(5),
                new _5_QUWithPathCompressionOnePass(5),
                new _6_QUWithPathCompressionTwoPass(5),
                new _7_WQUWIthPathCompression(5)
        );

        for (UnionFind uf : implementations) {
            assertEquals("Initial count should be 5", 5, uf.count());
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i == j) {
                        assertTrue("Element should be connected to itself", uf.connected(i, j));
                    } else {
                        assertFalse("Distinct elements should not be connected initially", uf.connected(i, j));
                    }
                }
            }
        }
    }

    @Test
    public void testAllConnected() {
        List<UnionFind> implementations = Arrays.asList(
                new _1_QuickFind(3),
                new _2_QuickUnion(3),
                new _3_WeightedQuickUnionBySize(3),
                new _4_WeightedQuickUnionByRank(3),
                new _5_QUWithPathCompressionOnePass(3),
                new _6_QUWithPathCompressionTwoPass(3),
                new _7_WQUWIthPathCompression(3)
        );

        for (UnionFind uf : implementations) {
            uf.union(0, 1);
            uf.union(1, 2);
            assertTrue("All elements should be connected", uf.connected(0, 2));
            assertEquals("Count should be 1", 1, uf.count());
        }
    }

    @Test
    public void testRedundantUnions() {
        List<UnionFind> implementations = Arrays.asList(
                new _1_QuickFind(4),
                new _2_QuickUnion(4),
                new _3_WeightedQuickUnionBySize(4),
                new _4_WeightedQuickUnionByRank(4),
                new _5_QUWithPathCompressionOnePass(4),
                new _6_QUWithPathCompressionTwoPass(4),
                new _7_WQUWIthPathCompression(4)
        );

        for (UnionFind uf : implementations) {
            uf.union(0, 1);
            uf.union(0, 1); // Redundant union
            assertTrue("0 and 1 should be connected", uf.connected(0, 1));
            assertEquals("Count should be 3", 3, uf.count());
        }
    }

    @Test
    public void testFindRoot() {
        List<UnionFind> implementations = Arrays.asList(
                new _1_QuickFind(5),
                new _2_QuickUnion(5),
                new _3_WeightedQuickUnionBySize(5),
                new _4_WeightedQuickUnionByRank(5),
                new _5_QUWithPathCompressionOnePass(5),
                new _6_QUWithPathCompressionTwoPass(5),
                new _7_WQUWIthPathCompression(5)
        );

        for (UnionFind uf : implementations) {
            uf.union(0, 1);
            uf.union(1, 2);
            uf.union(3, 4);

            int root0 = uf.find(0);
            int root2 = uf.find(2);
            int root4 = uf.find(4);

            assertEquals("Root of 0 and 2 should be the same", root0, root2);
            assertNotEquals("Root of 0 and 4 should be different", root0, root4);
        }
    }

    /**
     * Test invalid inputs to ensure robustness
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testUnionWithInvalidIndices() {
        UnionFind uf = new _1_QuickFind(5);
        uf.union(-1, 2);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testFindWithInvalidIndex() {
        UnionFind uf = new _2_QuickUnion(5);
        uf.find(5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testConnectedWithInvalidIndices() {
        UnionFind uf = new _3_WeightedQuickUnionBySize(5);
        uf.connected(1, 6);
    }

    /**
     * Test single element
     */
    @Test
    public void testSingleElement() {
        List<UnionFind> implementations = Arrays.asList(
                new _1_QuickFind(1),
                new _2_QuickUnion(1),
                new _3_WeightedQuickUnionBySize(1),
                new _4_WeightedQuickUnionByRank(1),
                new _5_QUWithPathCompressionOnePass(1),
                new _6_QUWithPathCompressionTwoPass(1),
                new _7_WQUWIthPathCompression(1)
        );

        for (UnionFind uf : implementations) {
            assertEquals("Initial count should be 1", 1, uf.count());
            assertTrue("Element should be connected to itself", uf.connected(0, 0));
            uf.union(0, 0);
            assertEquals("Count should remain 1", 1, uf.count());
        }
    }
}
