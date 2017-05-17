package com.azouz.trianglechallenge.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author mazouz
 */
public class TriangleTest {

    @Test
    public void createTriangle() {
        final Triangle triangle = Triangle.builder().
                withSide1(1).withSide2(2).withSide3(3).build();
        assertEquals(triangle.getSide1(), 1);
        assertEquals(triangle.getSide2(), 2);
        assertEquals(triangle.getSide3(), 3);
    }

    @Test
    public void createTriangleWithMissingValueShouldUseDefault() {
        final Triangle triangle = Triangle.builder().
                withSide1(1).withSide2(2).build();
        assertEquals(triangle.getSide1(), 1);
        assertEquals(triangle.getSide2(), 2);
        assertEquals(triangle.getSide3(), 0);
    }

    @Test
    public void twoTriangleShouldBeEqualContainsSameValues() {
        final Triangle triangle = Triangle.builder().
                withSide1(1).withSide2(2).withSide3(3).build();
        final Triangle triangle2 = Triangle.builder().
                withSide1(1).withSide2(2).withSide3(3).build();
        assertEquals(triangle, triangle2);
    }

    @Test
    public void twoTriangleShouldBeNotEqualContainsSameValues() {
        final Triangle triangle = Triangle.builder().
                withSide1(1).withSide2(2).withSide3(5).build();
        final Triangle triangle2 = Triangle.builder().
                withSide1(1).withSide2(2).withSide3(3).build();
        assertNotEquals(triangle, triangle2);
    }

}
