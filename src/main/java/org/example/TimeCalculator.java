package org.example;

public class TimeCalculator {
    public enum Unit {
        KILOMETERS(1.0),
        MILES(1.60934),   // 1 mile = 1.60934 kilometers
        FEET(0.0003048);  // 1 foot = 0.0003048 kilometers

        private final double toKilometersFactor;

        Unit(double toKilometersFactor) {
            this.toKilometersFactor = toKilometersFactor;
        }

        /**
         * Converts a value to kilometers using the unit's conversion factor.
         *
         * @param value the value in the current unit
         * @return the value converted to kilometers
         */
        public double toKilometers(double value) {
            return value * toKilometersFactor;
        }
    }

    public double calculateTime(double distance, double speed) {
        if (speed <= 0) {
            throw new IllegalArgumentException("Speed must be greater than zero.");
        }
        return distance / speed;
    }

    public double calculateTimeDifUnits(double distance, double speed, Unit distanceUnit, Unit speedUnit) {
        if (distanceUnit == Unit.FEET) {
            distance = distance * 0.0003048;
        } else if (distanceUnit == Unit.MILES) {
            distance = distance * 1.60934;
        }
        if (speedUnit == Unit.MILES) {
            speed = speed * 1.60934;
        } else if (speedUnit == Unit.FEET) {
            speed = speed * 0.0003048;
        }

        if (speed <= 0) {
            throw new IllegalArgumentException("Speed must be greater than zero.");
        }
        return distance / speed;

    }
    public static void main(String[]args){
        TimeCalculator calculator = new TimeCalculator();
        System.out.println(calculator.calculateTime(20.0,19.0));
    }
}

