package com.mg.springjiemi.templatemethod;
public class Main {
    public static void main(String[] args) {
        Vehicle ziDongVehicle = new VehicleZiDong();
        ziDongVehicle.drive();

        Vehicle shouDongVehicle = new VeicleShouDong();

        shouDongVehicle.drive();

    }
}
