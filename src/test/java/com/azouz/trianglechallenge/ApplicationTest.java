package com.azouz.trianglechallenge;

import com.azouz.trianglechallenge.domain.Triangle;
import com.azouz.trianglechallenge.exception.NoSuchTriangleTypeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author mazouz
 */
public class ApplicationTest {
    private Application app;

    @Test
    public void getTriangleFromWithValidInput() {
        final String[] args = new String[]{"1", "2", "3"};
        final Triangle triangle = app.getTriangleFrom(args);
        assertEquals(triangle.getSide1(), 1);
        assertEquals(triangle.getSide2(), 2);
        assertEquals(triangle.getSide3(), 3);
    }

    @Test(expected = RuntimeException.class)
    public void getTriangleFromWithNullInput() {
        app.getTriangleFrom(null);
    }

    @Test(expected = RuntimeException.class)
    public void getTriangleFromWithLessInput() {
        final String[] args = new String[]{"1", "2"};
        app.getTriangleFrom(args);
    }

    @Test(expected = RuntimeException.class)
    public void getTriangleFromWithInvalidInputLessInput() {
        final String[] args = new String[]{"1", "2"};
        app.getTriangleFrom(args);
    }

    @Test(expected = RuntimeException.class)
    public void getInputWithInvalidInputWithInvalidZeroSideLength() {
        final String[] args = new String[]{"0", "1", "3"};
        app.getTriangleFrom(args);
    }

    @Test(expected = RuntimeException.class)
    public void getInputWithInvalidInputWithInvalidLessThanZeroSideLength() {
        final String[] args = new String[]{"1", "1", "-3"};
        app.getTriangleFrom(args);
    }

    @Test(expected = RuntimeException.class)
    public void getTriangleFromWithInvalidInputWithCharacterSideLength() {
        final String[] args = new String[]{"aa", "1", "-3"};
        app.getTriangleFrom(args);
    }

    @Before
    public void setup() {
        app = new Application();
    }


    @Test(expected = RuntimeException.class)
    public void getSideLengthFromInvalidValueShouldThrowException() {
        app.getSideLengthFrom("0");
    }

    @Test(expected = RuntimeException.class)
    public void getSideLengthFromInvalidCharacterValueShouldThrowException() {
        app.getSideLengthFrom("11asdwewe1");
    }

    @Test
    public void getSideLengthFromValidInput() {
        int value = app.getSideLengthFrom("1");
        assertEquals(value, 1);
        value = app.getSideLengthFrom("22");
        assertEquals(value, 22);
        value = app.getSideLengthFrom("989898");
        assertEquals(value, 989898);
    }

    @Test
    public void startApplicationWithValidInputShouldNotThrowwExceptions() throws NoSuchTriangleTypeException {
        final String[] args = new String[]{"1", "1", "1"};
        app.startApplication(args);
    }

    @Test(expected = RuntimeException.class)
    public void startApplicationWithInValidInputShouldThrowwException() throws NoSuchTriangleTypeException {
        final String[] args = new String[]{"1", "1", "-1"};
        app.startApplication(args);
    }

    @Test(expected = RuntimeException.class)
    public void startApplicationWithInValidInput1ShouldThrowwException() throws NoSuchTriangleTypeException {
        final String[] args = new String[]{"1asd1", "1", "1"};
        app.startApplication(args);
    }
}
