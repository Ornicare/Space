package gameEngine;


/**
 * Bukkit adaptation
 */
public class Location implements Cloneable {
    private double x;
    private double y;

/**
     * Constructs a new Location with the given coordinates
     *
     * @param x The x-coordinate of this new location
     * @param y The y-coordinate of this new location
     */
    public Location(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the x-coordinate of this location
     *
     * @param x X-coordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Gets the x-coordinate of this location
     *
     * @return x-coordinate
     */
    public double getX() {
        return x;
    }



    /**
     * Sets the y-coordinate of this location
     *
     * @param y y-coordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Gets the y-coordinate of this location
     *
     * @return y-coordinate
     */
    public double getY() {
        return y;
    }


    /**
     * Adds the location by another.
     *
     * @see Vector
     * @param vec The other location
     * @return the same location
     * @throws IllegalArgumentException for null location
     */
    public Location add(Location vec) {
        if (vec == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }

        x += vec.x;
        y += vec.y;
        return this;
    }

    /**
     * Adds the location by a vector.
     *
     * @see Vector
     * @param vec Vector to use
     * @return the same location
     */
    public Location add(Vector vec) {
        this.x += vec.getX();
        this.y += vec.getY();
        return this;
    }

    /**
     * Adds the location by another.
     *
     * @see Vector
     * @param x X coordinate
     * @param y Y coordinate
     * @return the same location
     */
    public Location add(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }

    /**
     * Subtracts the location by another.
     *
     * @see Vector
     * @param vec The other location
     * @throws IllegalArgumentException for null location
     */
    public Location subtract(Location vec) {
        if (vec == null) {
        	throw new IllegalArgumentException("Location cannot be null");
        }

        x -= vec.x;
        y -= vec.y;
        return this;
    }

    /**
     * Subtracts the location by a vector.
     *
     * @see Vector
     * @param vec The vector to use
     * @return the same location
     */
    public Location subtract(Vector vec) {
        this.x -= vec.getX();
        this.y -= vec.getY();
        return this;
    }

    /**
     * Subtracts the location by another.
     *
     * @see Vector
     * @param x X coordinate
     * @param y Y coordinate
     * @return the same location
     */
    public Location subtract(double x, double y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    /**
     * Gets the magnitude of the location, defined as sqrt(x^2+y^2). The value
     * of this method is not cached and uses a costly square-root function, so
     * do not repeatedly call this method to get the location's magnitude. NaN
     * will be returned if the inner result of the sqrt() function overflows,
     * which will be caused if the length is too long. Not world-aware and
     * orientation independent.
     *
     * @see Vector
     * @return the magnitude
     */
    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    /**
     * Gets the magnitude of the location squared. Not world-aware and
     * orientation independent.
     *
     * @see Vector
     * @return the magnitude
     */
    public double lengthSquared() {
        return Math.pow(x, 2) + Math.pow(y, 2);
    }

    /**
     * Get the distance between this location and another. The value
     * of this method is not cached and uses a costly square-root function, so
     * do not repeatedly call this method to get the location's magnitude. NaN
     * will be returned if the inner result of the sqrt() function overflows,
     * which will be caused if the distance is too long.
     *
     * @see Vector
     * @param o The other location
     * @return the distance
     * @throws IllegalArgumentException for null location
     */
    public double distance(Location o) {
        return Math.sqrt(distanceSquared(o));
    }

    /**
     * Get the squared distance between this location and another.
     *
     * @see Vector
     * @param o The other location
     * @return the distance
     * @throws IllegalArgumentException for null location
     */
    public double distanceSquared(Location o) {
        if (o == null) {
            throw new IllegalArgumentException("Cannot measure distance to a null location");
        }

        return Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2);
    }

    /**
     * Performs scalar multiplication, multiplying all components with a scalar.
     * Not world-aware.
     *
     * @param m The factor
     * @see Vector
     * @return the same location
     */
    public Location multiply(double m) {
        x *= m;
        y *= m;
        return this;
    }

    /**
     * Zero this location's components. Not world-aware.
     *
     * @see Vector
     * @return the same location
     */
    public Location zero() {
        x = 0;
        y = 0;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;

        
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Location{x=" + x + ",y=" + y +'}';
    }

    /**
     * Constructs a new {@link Vector} based on this Location
     *
     * @return New Vector containing the coordinates represented by this Location
     */
    public Vector toVector() {
        return new Vector(x, y);
    }

    @Override
    public Location clone() {
        try {
            return (Location) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }
}
