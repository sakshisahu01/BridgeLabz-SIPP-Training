package Inheritance;

class Device{
    int deviceId;
    String status;

    Device(int deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
    void displayinfo(){
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }

    

}
class Thermostat extends Device{
    String temperatureSetting;

    Thermostat(int deviceId, String status, String temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    void displayinfo() {
        super.displayinfo();
        System.out.println("Temperature Setting: " + temperatureSetting);
    }
}



public class SmartHomeDevices {
    public static void main(String[] args){
        Thermostat thermostat = new Thermostat(101, "On", "22°C");
        thermostat.displayinfo();   
    }
    
}
