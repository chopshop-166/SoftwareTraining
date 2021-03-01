---
name: Shapes
practices: input, classes, inheritance
...

Start with this code in Shapes.java:

```java
public class Shapes {

    public static class Shape {
        public double area() {
            return 0;
        }

        public double perimeter() {
            return 0;
        }
    }
}
```

- Create a class `Circle` that extends Shape and implements the given functions
- Make a class for `RegularPolygon` that extends Shape
    - Has number of sides as a member
    - Has length of each side as a member
- Make a class for Triangle that extends `RegularPolygon`
- Make a class for Square that extends `RegularPolygon`
- Make a class for Hexagon that extends `RegularPolygon`
    - Area of a regular hexagon = `(3√3 * s^2)/ 2`

Hint:

- Look up `Math.sqrt` and `Math.pow`

Bonus:

- Make a class `Annulus` (ring-shape) that contains two Circles
- The area of a regular polygon of n sides and side length a is:
    `(1.0/4)na^2 cot(pi/n)`
