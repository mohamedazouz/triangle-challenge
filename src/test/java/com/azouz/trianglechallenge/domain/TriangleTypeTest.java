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
        final Triangle triangle = Triangle.builder().
                withSide1(1).withSide2(1).withSide3(1).build();
        final TriangleType triangleType = TriangleType.fromSides(triangle);
        assertEquals(triangleType, EQUILATERAL);
        assertNotEquals(triangleType, ISOSCELES);
        assertNotEquals(triangleType, SCALENE);
    }

    @Test
    public void isoscelesTypeWithEqualXZ() throws NoSuchTriangleTypeException {
        final Triangle triangle = Triangle.builder().
                withSide1(1).withSide2(2).withSide3(1).build();
        final TriangleType triangleType = TriangleType.fromSides(triangle);
        assertEquals(triangleType, ISOSCELES);
        assertNotEquals(triangleType, EQUILATERAL);
        assertNotEquals(triangleType, SCALENE);
    }

    @Test
    public void isoscelesTypeWithEqualXY() throws NoSuchTriangleTypeException {
        final Triangle triangle = Triangle.builder().
                withSide1(1).withSide2(1).withSide3(3).build();
        final TriangleType triangleType = TriangleType.fromSides(triangle);
        assertEquals(triangleType, ISOSCELES);
        assertNotEquals(triangleType, EQUILATERAL);
        assertNotEquals(triangleType, SCALENE);
    }

    @Test
    public void isoscelesTypeWithEqualZY() throws NoSuchTriangleTypeException {
        final Triangle triangle = Triangle.builder().
                withSide1(3).withSide2(2).withSide3(2).build();
        final TriangleType triangleType = TriangleType.fromSides(triangle);
        assertEquals(triangleType, ISOSCELES);
        assertNotEquals(triangleType, EQUILATERAL);
        assertNotEquals(triangleType, SCALENE);
    }


    @Test
    public void scaleneType() throws NoSuchTriangleTypeException {
        final Triangle triangle = Triangle.builder().
                withSide1(3).withSide2(5).withSide3(10).build();
        final TriangleType triangleType = TriangleType.fromSides(triangle);
        assertEquals(triangleType, SCALENE);
        assertNotEquals(triangleType, EQUILATERAL);
        assertNotEquals(triangleType, ISOSCELES);
    }

    @Test(expected = NoSuchTriangleTypeException.class)
    public void invalidSidesLengthsX() throws NoSuchTriangleTypeException {
        final Triangle triangle = Triangle.builder().
                withSide1(-1).withSide2(2).withSide3(2).build();
        TriangleType.fromSides(triangle);

    }
    @Test(expected = NoSuchTriangleTypeException.class)
    public void invalidSidesLengthsY() throws NoSuchTriangleTypeException {
        final Triangle triangle = Triangle.builder().
                withSide1(1).withSide2(-2).withSide3(2).build();
        TriangleType.fromSides(triangle);
    }

    @Test(expected = NoSuchTriangleTypeException.class)
    public void invalidSidesLengthsZ() throws NoSuchTriangleTypeException {
        final Triangle triangle = Triangle.builder().
                withSide1(1).withSide2(2).withSide3(-2).build();
        TriangleType.fromSides(triangle);
    }


    @Test(expected = NoSuchTriangleTypeException.class)
    public void invalidSidesLengthsXYZ() throws NoSuchTriangleTypeException {
        final Triangle triangle = Triangle.builder().
                withSide1(-1).withSide2(-2).withSide3(-2).build();
        TriangleType.fromSides(triangle);
    }

    @Test(expected = NoSuchTriangleTypeException.class)
    public void invalidSidesLengthsXY() throws NoSuchTriangleTypeException {
        final Triangle triangle = Triangle.builder().
                withSide1(-1).withSide2(-2).withSide3(2).build();
        TriangleType.fromSides(triangle);
    }

    @Test(expected = NoSuchTriangleTypeException.class)
    public void invalidSidesLengthsXZ() throws NoSuchTriangleTypeException {
        final Triangle triangle = Triangle.builder().
                withSide1(-1).withSide2(2).withSide3(-1).build();
        TriangleType.fromSides(triangle);
    }

    @Test(expected = NoSuchTriangleTypeException.class)
    public void invalidSidesLengthsYZ() throws NoSuchTriangleTypeException {
        final Triangle triangle = Triangle.builder().
                withSide1(1).withSide2(-7).withSide3(-5).build();
        TriangleType.fromSides(triangle);
    }

    @Test(expected = NoSuchTriangleTypeException.class)
    public void invalidSidesLengthsWithNoInput() throws NoSuchTriangleTypeException {
        final Triangle triangle = Triangle.builder().build();
        TriangleType.fromSides(triangle);
    }

    @Test(expected = NoSuchTriangleTypeException.class)
    public void invalidSidesLengthsWithNoXInput() throws NoSuchTriangleTypeException {
        final Triangle triangle = Triangle.builder().withSide2(2).withSide3(3).build();
        TriangleType.fromSides(triangle);
    }
}
