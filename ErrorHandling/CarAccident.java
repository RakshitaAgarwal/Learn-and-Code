package ErrorHandling;

import ErrorHandling.CustomExceptions.*;

public class CarAccident {
    public static void main(String[] args) {
        try {
            driveSafely();
        } catch (MajorCarAccidentException e) {
            handleMajorCarAccident();
        } catch (MinorCarAccidentException e) {
            handleMinorCarAccident();
        } finally {
            cleanUpAfterAccident();
        }
    }

    private static void driveSafely() throws MajorCarAccidentException, MinorCarAccidentException {
        boolean isMajorAccident = true;
        if (isMajorAccident) {
            throw new MajorCarAccidentException("Major Car Accident Occured");
        } else {
            throw new MinorCarAccidentException("Minor Car Accident Occured");
        }
    }

    private static void handleMajorCarAccident() {
        callAmbulanceService();
        boolean fireAfterAccident = false;
        if (fireAfterAccident) {
            callFireExtinguishers();
        }
    }

    public static void callAmbulanceService() {
        System.out.println("MajorAccident: Ambulance service called for medical assistance.");
    }

    private static void callFireExtinguishers() {
        System.out.println("Fire broke out after the crash. Firefighters are needed.");
    }

    private static void handleMinorCarAccident() {
        System.out.println("Minor Accident Occurred: no need to call ambulance");
    }

    private static void cleanUpAfterAccident() {
        takePassengersOutOfVehicle();
        provideWaterAndFirstAid();
        callInjuredPeopleFamily();
        clearRoad();
    }

    public static void takePassengersOutOfVehicle() {
        System.out.println("Passengers are being taken out of the vehicle.");
    }

    public static void provideWaterAndFirstAid() {
        System.out.println("Water and first aid provided to passengers.");
    }

    public static void callInjuredPeopleFamily() {
        System.out.println("Family of injured people has been notified.");
    }

    public static void clearRoad() {
        System.out.println("Road is being cleared after the accident.");
    }
}