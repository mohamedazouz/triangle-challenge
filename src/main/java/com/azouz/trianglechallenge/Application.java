package com.azouz.trianglechallenge;

import com.azouz.trianglechallenge.domain.Triangle;
import com.azouz.trianglechallenge.domain.TriangleType;
import com.azouz.trianglechallenge.exception.NoSuchTriangleTypeException;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * @author mazouz
 */
public class Application {

    public static void main(final String[] args) {
        try {
            final Application app = new Application();
            app.startApplication(args);
        } catch (final RuntimeException ex) {
            System.err.println(MessageFormat.format("Invalid input: {0}", ex.getMessage()));
        } catch (final NoSuchTriangleTypeException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void startApplication(final String[] args) throws RuntimeException, NoSuchTriangleTypeException {
        final Triangle triangle = getTriangleFrom(args);
        final TriangleType typeOptional = TriangleType.fromSides(triangle);
        System.out.println(MessageFormat.format("{0} is {1} Triangle", triangle, typeOptional.getTypeName()));
    }


    public Triangle getTriangleFrom(final String[] args) throws RuntimeException {
        if (args == null || args.length < 3) {
            throw new RuntimeException(MessageFormat.format("Please check your input: {0}", Arrays.toString(args)));
        }
        return Triangle.builder().
                withSide1(getSideLengthFrom(args[0])).
                withSide2(getSideLengthFrom(args[1])).
                withSide3(getSideLengthFrom(args[2])).build();
    }

    public int getSideLengthFrom(final String input) throws RuntimeException {
        final int value = Integer.valueOf(input);
        if (value <= 0) {
            throw new RuntimeException(MessageFormat.format("Side length should be > 0: {0}", input));
        }
        return value;
    }
}
