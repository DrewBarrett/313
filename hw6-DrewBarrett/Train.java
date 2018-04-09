/**
 * Train
 */
import java.util.ArrayList;
public class Train {

    private int currSpeed;
    private int minSpeed;
    private int maxSpeed;
    private String origin;
    private String destination;
    private ArrayList<Boxcar> cars;
    private int maxCars;
    private boolean moving;

    public Train(String origin, int minSpeed, int maxSpeed, int maxCars) {
        this.origin = origin;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.maxCars = maxCars;
        cars = new ArrayList();
        this.currSpeed = 0;
        this.moving = false;
    }

    public void printStatus() {
        System.out.println("Train Status");
        System.out.println("------------");
        System.out.println("\tCurrent Speed: " + currSpeed);
        System.out.println("\tMinimum Speed: " + minSpeed);
        System.out.println("\tMaximum Speed: " + maxSpeed);
        String status;
        if (!moving) {
            status = "Stopped in " + origin;
        }
        else {
            status = "Traveling from " + origin + " to " + destination;
        }
        System.out.println("\tCurrent Position: " + status);
        System.out.println("\tCurrent Number of Boxcars: " + cars.size());
        System.out.println("\tMaximum Number of Boxcars: " + maxCars);
        int i = 0;
        for (Boxcar car : cars) {
            System.out.println("\tBoxcar: " + i);
            System.out.println("\t------------");
            System.out.println("\tContents:");
            car.printCargo();
            i++;
        }
    }

    public void addCar(Boxcar car) throws Exception { 
        if (moving == true) {
            throw new Exception("ERROR: Cannot remove car while moving");
        }
        // check if we are at capacity
        if (cars.size() == maxCars)
            throw new Exception("ERROR: Train cannot hold any more cars.");
        cars.add(car);
    }

    public void increaseSpeed(int mph) throws Exception {
        try {
            changeSpeed(mph);
        } catch (Exception e) {
            throw e;
        }
    }

    public void decreaseSpeed(int mph) throws Exception {
        try {
            changeSpeed(-1 * mph);
        } catch (Exception e) {
            throw e;
        }
    }

    public void changeSpeed(int mph) throws Exception {
        if (moving == false) {
            throw new Exception("ERROR: Train is not moving!");
        }
        int mod = currSpeed + mph;
        if (mod < minSpeed || mod > maxSpeed) {
            throw new Exception("ERROR: Speed cannot be changed to " + mod);
        }
        currSpeed = mod;
    }

    public void loadCar(int car, String type, Cargo cargo) throws Exception {
        if (moving == true) {
            throw new Exception("ERROR: Cannot remove car while moving");
        }
        // check for out of range car
        if (car < 0 || car >= cars.size()) {
            throw new Exception("ERROR: Invalid car ID");
        }
        // check for item with same id
        for (Boxcar boxcar : cars) {
            if (boxcar.isDuplicate(cargo)){
                throw new Exception("ERROR: Item with id \"" + cargo.getId() 
                    + "\" already exists.");
            }
        }
        try {
            cars.get(car).load(type, cargo);
        } catch (Exception e) {
            throw e;
        }
    }

    public void unloadCar(int car, String id) throws Exception {
        if (moving == true) {
            throw new Exception("ERROR: Cannot remove car while moving");
        }
        if (car < 0 || car >= cars.size()) {
            throw new Exception("ERROR: Invalid car ID");
        }
        try {
            cars.get(car).unload(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public void arrive() throws Exception {
        if (moving == false) {
            throw new Exception("ERROR: You cannot arrive without departing");
        }
        moving = false;
        currSpeed = 0;
        origin = destination;
    }

    public void depart(String destination) throws Exception {
        if (moving == true) {
            throw new Exception("ERROR: You cannot depart while moving");
        }
        this.destination = destination;
        currSpeed = minSpeed;
        moving = true;
    }

    public void removeCar(int carID) throws Exception {
        if (moving == true) {
            throw new Exception("ERROR: Cannot remove car while moving");
        }

        if (carID < 0 || carID >= cars.size()) {
            throw new Exception("ERROR: Invalid car ID");
        }

        if (!cars.get(carID).isEmpty()) {
            throw new Exception("ERROR: Car is not empty");
        }

        cars.remove(carID);
    }
    
}