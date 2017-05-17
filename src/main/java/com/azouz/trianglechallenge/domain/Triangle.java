package com.azouz.trianglechallenge.domain;

/**
 * @author mazouz
 */
public class Triangle {

    private final int side1;
    private final int side2;
    private final int side3;

    public Triangle(final Builder builder) {
        this.side1 = builder.side1;
        this.side2 = builder.side2;
        this.side3 = builder.side3;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getSide1() {
        return side1;
    }

    public int getSide2() {
        return side2;
    }

    public int getSide3() {
        return side3;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;

        final Triangle triangle = (Triangle) o;

        if (getSide1() != triangle.getSide1()) return false;
        if (getSide2() != triangle.getSide2()) return false;
        if (getSide3() != triangle.getSide3()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getSide1();
        result = 31 * result + getSide2();
        result = 31 * result + getSide3();
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }

    public static class Builder {
        private int side1;
        private int side2;
        private int side3;

        public Builder withSide1(final int side1) {
            this.side1 = side1;
            return this;
        }

        public Builder withSide2(final int side2) {
            this.side2 = side2;
            return this;
        }

        public Builder withSide3(final int side3) {
            this.side3 = side3;
            return this;
        }

        public Triangle build() {
            return new Triangle(this);
        }
    }
}