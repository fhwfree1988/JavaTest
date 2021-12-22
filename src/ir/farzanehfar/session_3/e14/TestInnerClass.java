package ir.farzanehfar.session_3.e14;

import org.apache.log4j.Logger;

public class TestInnerClass {
    final static Logger logger = Logger.getLogger(TestInnerClass.class);

    public static void main(String[] args) {
        Shape.Color white = new Shape.Color(255, 255, 255);
        logger.info("White color has values:" + white);

        Circle c = new Circle(10, 10, 20);
        // can not initialized outside of class
//        Circle.Point p = new Circle.Point();
        Circle.Point p = c.getCenter();
        logger.info(p);

        Shape.Color descriptiveColor = StatusReporter.getDescriptiveColor(new Shape.Color(0, 0, 0));
        logger.info(descriptiveColor);

        Shape.Color anonymousDescriptiveColor = StatusReporter.getAnonymousDescriptiveColor(
                new Shape.Color(128, 128, 128));
        logger.info(anonymousDescriptiveColor);
    }
}

// static inner class
abstract class Shape {
    public static class Color {
        int red, green, blue;

        public Color() {
            this(0, 0, 0);
        }

        public Color(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        public String toString() {
            return " red = " + red + " green = " + green + " blue = " + blue;
        }
    }
}

// inner class
class Circle {
    class Point {
        private int xPos;
        private int yPos;

        public Point(int x, int y) {
            xPos = x;
            yPos = y;
        }

        public String toString() {
            return "(" + xPos + "," + yPos + ")";
        }
    }

    private Point center;
    private int radius;

    public Circle(int x, int y, int r) {
        center = this.new Point(x, y);
        radius = r;
    }

    public Point getCenter() {
        return center;
    }

    public String toString() {
        return "mid point = " + center + " and radius = " + radius;
    }
}

// local inner class and anonymous inner class
class StatusReporter {
    static Shape.Color getDescriptiveColor(final Shape.Color color) {

        // inner class is inside getDescriptiveColor method
        class DescriptiveColor extends Shape.Color {
            public String toString() {
                return "You selected a color with RGB values" + color;
            }
        }

        return new DescriptiveColor();
    }

    static Shape.Color getAnonymousDescriptiveColor(final Shape.Color color) {

        return new Shape.Color() {
            public String toString() {
                return "You selected a anonymous color with RGB values" + color;
            }
        };
    }
}