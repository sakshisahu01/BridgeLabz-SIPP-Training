class TrigonometricCalculator
{
    public double[] calculateTrigonometricFunctions(double angle)
	{
        double radians = Math.toRadians(angle);
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
        return new double[]{sine, cosine, tangent};
        }

    public static void main(String[] args)
	{
        TrigonometricCalculator calculator = new TrigonometricCalculator();
        double angle = 45.0;
        double[] results = calculator.calculateTrigonometricFunctions(angle);
        System.out.println("Sine: " + results[0]);
        System.out.println("Cosine: " + results[1]);
        System.out.println("Tangent: " + results[2]);
        }
}
