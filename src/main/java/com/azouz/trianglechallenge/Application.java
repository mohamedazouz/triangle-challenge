package com.azouz.trianglechallenge;

import com.azouz.trianglechallenge.domain.Triangle;
import com.azouz.trianglechallenge.domain.TriangleType;
import com.azouz.trianglechallenge.exception.NoSuchTriangleTypeException;

import java.text.MessageFormat;

/**
 * @author mazouz
 */
public class Application {

    public static void main(final String[] args) throws NoSuchTriangleTypeException {
        final Triangle triangle = Triangle.builder().
                withSide1(2).withSide2(3).withSide3(4).build();
        final TriangleType typeOptional = TriangleType.fromSides(triangle);
        System.out.println(MessageFormat.format("{0} -> {3}", triangle, typeOptional.getTypeName()));
    }
}
