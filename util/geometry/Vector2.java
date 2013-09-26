package util.geometry;

import static java.lang.Math.*;

import java.io.Serializable;

public final class Vector2 implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final Vector2 NULL = new Vector2(0, 0);
	public static final Vector2 X = new Vector2(1, 0);
	public static final Vector2 Y = new Vector2(0, 1);

	public final double x;
	public final double y;

	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector2 add(Vector2 a) {
		return new Vector2(x + a.x, y + a.y);
	}

	public Vector2 sub(Vector2 a) {
		return new Vector2(x - a.x, y - a.y);
	}

	public Vector2 neg() {
		return new Vector2(-x, -y);
	}

	public Vector2 scale(double a) {
		return new Vector2(a * x, a * y);
	}

	public double dot(Vector2 a) {
		return x * a.x + y * a.y;
	}

	public double modSquared() {
		return dot(this);
	}

	public double mod() {
		return sqrt(modSquared());
	}

	public Vector2 normalize() {
		return scale(1 / mod());
	}

	public Vector2 rotPlus90() {
		return new Vector2(-y, x);
	}

	public Vector2 rotMinus90() {
		return new Vector2(y, -x);
	}

	public double angle() {
		return atan2(y, x);
	}

	public static Vector2 fromAngle(double ang) {
		return new Vector2(cos(ang), sin(ang));
	}

	public static Vector2 fromPolar(double ang, double mod) {
		return new Vector2(mod * cos(ang), mod * sin(ang));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector2 other = (Vector2) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + x + ", " + y + ")";
	}

}
