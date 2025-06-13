public class EarthVolume {
    public static void main(String[] args) {
        
        double radiusKm = 6378.0;

        
        double volumeKm3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusKm, 3);

        
        double volumeMiles3 = volumeKm3 * 0.239913;

        
        System.out.println("The volume of Earth in cubic kilometers is " + volumeKm3);
        System.out.println("The volume of Earth in cubic miles is " + volumeMiles3);
    }
}
   
    