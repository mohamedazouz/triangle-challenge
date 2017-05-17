package com.azouz.trianglechallenge;

import com.azouz.trianglechallenge.domain.TriangleType;
import com.azouz.trianglechallenge.exception.NoSuchTriangleTypeException;

import java.text.MessageFormat;

/**
 * @author mazouz
 */
public class Application {

    public static void main(final String[] args) throws NoSuchTriangleTypeException {
        final int x = 2;
        final int y = 3;
        final int z = 4;
        final TriangleType typeOptional = TriangleType.fromSides(x, y, z);
        System.out.println(MessageFormat.format("{0}, {1}, {2} -> {3}", x, y, z, typeOptional.getTypeName()));
    }
}
