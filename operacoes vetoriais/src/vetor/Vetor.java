package vetor;

public class Vetor {
	private double x;
	private double y;
	private double z;
	
	public Vetor(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return "Vetor (X= " + x + ", Y= " + y + ", Z= " + z + " )";
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}
}
