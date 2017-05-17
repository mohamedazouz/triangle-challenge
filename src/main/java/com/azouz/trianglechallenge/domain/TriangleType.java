package com.azouz.trianglechallenge.domain;

import com.azouz.trianglechallenge.exception.NoSuchTriangleTypeException;

import java.text.MessageFormat;

/**
 * @author mazouz
 */
public enum TriangleType {

    EQUILATERAL("Equilateral") {
        protected boolean isValidSides(final int x, final int y, final int z) {
            if (x == y && y == z) return true;
            return false;
        }
    }, ISOSCELES("Isosceles") {
        protected boolean isValidSides(final int x, final int y, final int z) {
            if (x == y || x == z || y == z) return true;
            return false;
        }
    }, SCALENE("Scalene") {
        protected boolean isValidSides(final int x, final int y, final int z) {
            if (x != y && x != z && y != z) return true;
            return false;
        }
    };

    private final String typeName;

    TriangleType(final String typeName) {
        this.typeName = typeName;
    }

    public static TriangleType fromSides(final int x, final int y, final int z) throws NoSuchTriangleTypeException {
        for (final TriangleType triangleType : TriangleType.values()) {
            if (triangleType.isValid(x, y, z)) {
                return triangleType;
            }
        }
        throw new NoSuchTriangleTypeException(
                MessageFormat.format("No type with following values x:{0}, y:{1}, z:{2}", x, y, z));
    }

    public String getTypeName() {
        return typeName;
    }

    protected abstract boolean isValidSides(final int x, final int y, int z);

    private boolean isValid(final int x, final int y, int z) {
        if (x <= 0 || y <= 0 || z <= 0) return false;
        return isValidSides(x, y, z);

    }
}
