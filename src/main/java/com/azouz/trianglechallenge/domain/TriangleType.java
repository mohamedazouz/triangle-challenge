package com.azouz.trianglechallenge.domain;

import com.azouz.trianglechallenge.exception.NoSuchTriangleTypeException;

import java.text.MessageFormat;

/**
 * @author mazouz
 */
public enum TriangleType {

    EQUILATERAL("Equilateral") {
        protected boolean isValidSides(final int side1, final int side2, final int side3) {
            if (side1 == side2 && side2 == side3) return true;
            return false;
        }
    }, ISOSCELES("Isosceles") {
        protected boolean isValidSides(final int side1, final int side2, final int side3) {
            if (side1 == side2 || side1 == side3 || side2 == side3) return true;
            return false;
        }
    }, SCALENE("Scalene") {
        protected boolean isValidSides(final int side1, final int side2, final int side3) {
            if (side1 != side2 && side1 != side3 && side2 != side3) return true;
            return false;
        }
    };

    private final String typeName;

    TriangleType(final String typeName) {
        this.typeName = typeName;
    }

    public static TriangleType fromSides(final Triangle triangle) throws NoSuchTriangleTypeException {
        for (final TriangleType triangleType : TriangleType.values()) {
            if (triangleType.isValid(triangle)) {
                return triangleType;
            }
        }
        throw new NoSuchTriangleTypeException(
                MessageFormat.format("No type with following values Triangle: {0}", triangle));
    }

    public String getTypeName() {
        return typeName;
    }

    protected abstract boolean isValidSides(final int side1, final int side2, int side3);

    private boolean isValid(final Triangle triangle) {
        if (triangle.getSide1() <= 0 || triangle.getSide2() <= 0 || triangle.getSide3() <= 0) return false;
        return isValidSides(triangle.getSide1(), triangle.getSide2(), triangle.getSide3());

    }
}
