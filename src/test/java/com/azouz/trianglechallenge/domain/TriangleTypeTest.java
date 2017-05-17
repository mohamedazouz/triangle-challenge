package com.azouz.trianglechallenge.domain;

import com.azouz.trianglechallenge.exception.NoSuchTriangleTypeException;
import org.junit.Test;

import static com.azouz.trianglechallenge.domain.TriangleType.EQUILATERAL;
import static com.azouz.trianglechallenge.domain.TriangleType.ISOSCELES;
import static com.azouz.trianglechallenge.domain.TriangleType.SCALENE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author mazouz
 */
public class TriangleTypeTest {

    @Test
    public void equilateralType() throws NoSuchTriangleTypeException {
        final TriangleType triangleType = TriangleType.fromSides(1, 1, 1);
        assertEquals(triangleType, EQUILATERAL);
        assertNotEquals(triangleType, ISOSCELES);
        assertNotEquals(triangleType, SCALENE);
    }

    @Test
    public void isoscelesTypeWithEqualXZ() throws NoSuchTriangleTypeException {
        final TriangleType triangleType = TriangleType.fromSides(1, 2, 1);
        assertEquals(triangleType, ISOSCELES);
        assertNotEquals(triangleType, EQUILATERAL);
        assertNotEquals(triangleType, SCALENE);
    }

    @Test
    public void isoscelesTypeWithEqualXY() throws NoSuchTriangleTypeException {
        final TriangleType triangleType = TriangleType.fromSides(1, 1, 3);
        assertEquals(triangleType, ISOSCELES);
        assertNotEquals(triangleType, EQUILATERAL);
        assertNotEquals(triangleType, SCALENE);
    }

    @Test
    public void isoscelesTypeWithEqualZY() throws NoSuchTriangleTypeException {
        final TriangleType triangleType = TriangleType.fromSides(3, 2, 2);
        assertEquals(triangleType, ISOSCELES);
        assertNotEquals(triangleType, EQUILATERAL);
        assertNotEquals(triangleType, SCALENE);
    }


    @Test
    public void scaleneType() throws NoSuchTriangleTypeException {
        final TriangleType triangleType = TriangleType.fromSides(3, 5, 10);
        assertEquals(triangleType, SCALENE);
        assertNotEquals(triangleType, EQUILATERAL);
        assertNotEquals(triangleType, ISOSCELES);
    }

    @Test(expected = NoSuchTriangleTypeException.class)
    public void invalidSidesLengthsX() throws NoSuchTriangleTypeException {
        TriangleType.fromSides(-1, 2, 2);

    }
    @Test(expected = NoSuchTriangleTypeException.class)
    public void invalidSidesLengthsY() throws NoSuchTriangleTypeException {
        TriangleType.fromSides(1, -2, 2);
    }

    @Test(expected = NoSuchTriangleTypeException.class)
    public void invalidSidesLengthsZ() throws NoSuchTriangleTypeException {
        TriangleType.fromSides(1, 2, -2);
    }


    @Test(expected = NoSuchTriangleTypeException.class)
    public void invalidSidesLengthsXYZ() throws NoSuchTriangleTypeException {
        TriangleType.fromSides(-1, -2, -2);
    }

    @Test(expected = NoSuchTriangleTypeException.class)
    public void invalidSidesLengthsXY() throws NoSuchTriangleTypeException {
        TriangleType.fromSides(-1, -2, 3);
    }

    @Test(expected = NoSuchTriangleTypeException.class)
    public void invalidSidesLengthsXZ() throws NoSuchTriangleTypeException {
        TriangleType.fromSides(-1, 7, -5);
    }

    @Test(expected = NoSuchTriangleTypeException.class)
    public void invalidSidesLengthsYZ() throws NoSuchTriangleTypeException {
        TriangleType.fromSides(1, -7, -5);
    }
}
