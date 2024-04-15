package utilities;

public final class Vector2D {
    public double x, y;

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector2D v) {
        this.x = v.x;
        this.y = v.y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector2D v) {
            return this.x == v.x && this.y == v.y;
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }

    public static Vector2D polar(double angle, double magnitude) {
        return new Vector2D(
                magnitude * Math.cos(angle),
                magnitude * Math.sin(angle)
        );
    }

    public Vector2D add(double x, double y) {
        this.x += x;
        this.y += y;

        return this;
    }

    public Vector2D add(Vector2D v) {
        this.x += v.x;
        this.y += v.y;

        return this;
    }

    public Vector2D addScaled(Vector2D v, double factor) {
        this.x += v.x * factor;
        this.y += v.y * factor;

        return this;
    }

    public double angle() {
        return Math.atan2(y, x);
    }

//    public double angle(Vector2D v) {
//
//    }

    public double distant(Vector2D v) {
        return Math.sqrt(Math.pow(x - v.x, 2) + Math.pow(y - v.y, 2));
    }

    public double dotProduct(Vector2D v) {
        return this.x * v.x + this.y * v.y;
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public Vector2D multiply(double factor) {
        this.x *= factor;
        this.y *= factor;

        return this;
    }

    public Vector2D normalise() {
        double magnitude = this.magnitude();

        this.x /= magnitude;
        this.y /= magnitude;

        return this;
    }

    public Vector2D set(double x, double y) {
        this.x = x;
        this.y = y;

        return this;
    }

    public Vector2D set(Vector2D v) {
        this.x = v.x;
        this.y = v.y;

        return this;
    }

    public Vector2D rotate(double angle) {
        
    }

    public Vector2D subtract(double x, double y) {
        this.x -= x;
        this.y -= y;

        return this;
    }

    public Vector2D subtract(Vector2D v) {
        this.x -= v.x;
        this.y -= v.y;

        return this;
    }

    public Vector2D wrap(double width, double height) {
        if (this.x < 0) {
            this.x += width;
        } else if (this.x > width) {
            this.x -= width;
        }

        if (this.y < 0) {
            this.y += height;
        } else if (this.y > height) {
            this.y -= height;
        }

        return this;
    }
}
