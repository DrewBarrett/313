import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class hw6
{
    public static void main(String[] args) throws FileNotFoundException {
        Train train = new Train("New York", 10, 50, 3);
        Scanner input = 
            new Scanner(new FileInputStream("train_commands.txt"));
        while(input.hasNextLine())
        {
            String command = input.nextLine();
            System.out.print(command);
            try {
                switch(command)
                {
                    case "PRINT":
                        System.out.println();
                        train.printStatus();
                        break;
                    case "ARRIVE":
                        train.arrive();
                        break;
                    case "DEPART":
                        String dest = input.nextLine();
                        System.out.print(" " + dest);
                        train.depart(dest);
                        break;
                    case "SPEEDUP": {
                        int mph = Integer.parseInt(input.nextLine());
                        System.out.print(" " + mph);
                        train.increaseSpeed(mph);
                        break;
                    }
                    case "SLOWDOWN": {
                        int mph = Integer.parseInt(input.nextLine());
                        System.out.print(" " + mph);
                        train.decreaseSpeed(mph);
                        break;
                    }
                    case "ADDCAR": {
                        String type = input.nextLine();
                        int capacity = Integer.parseInt(input.nextLine());
                        System.out.print(" " + type + " " + capacity);
                        switch(type) {
                            case "PERSON":
                                train.addCar(new Boxcar<Person>(capacity,type));
                                break;
                            case "CARGO":
                                train.addCar(new Boxcar<CargoItem>(capacity,type));
                                break;
                            default:
                                throw new Exception("Invalid item type");
                        }
                        //train.addCar(new Boxcar(capacity, type));
                        break;
                    }
                    case "REMOVECAR":
                        int id = Integer.parseInt(input.nextLine());
                        System.out.print(" " + id);
                        train.removeCar(id);
                        break;
                    case "QUIT":
                        break;
                    case "LOAD": {
                        String type = input.nextLine();
                        System.out.print(" " + type);
                        int carId = Integer.parseInt(input.nextLine());
                        System.out.print(" " + carId);
                        String cargoId = input.nextLine();
                        System.out.print(" " + cargoId);
                        Cargo item;
                        switch (type) {
                            case "CARGO":
                                int weight = Integer.parseInt(input.nextLine());
                                System.out.print(" " + weight);
                                int height = Integer.parseInt(input.nextLine());
                                System.out.print(" " + height);
                                item = new CargoItem(cargoId, weight, height);
                                break;
                            case "PERSON":
                                String name = input.nextLine();
                                System.out.print(" " + name);
                                int age = Integer.parseInt(input.nextLine());
                                System.out.print(" " + age);
                                item = new Person(cargoId, name, age);
                                break;
                            default:
                                throw new Exception("ERROR: Invalid cargo type.");
                        }
                        train.loadCar(carId, type, item);
                        break;
                    }
                    case "UNLOAD":
                        int carId = Integer.parseInt(input.nextLine());
                        System.out.print(" " + carId);
                        String cargoId = input.nextLine();
                        System.out.print(" " + cargoId);
                        train.unloadCar(carId, cargoId);
                        break;
                    default:
                        throw new Exception("ERROR: Invalid command");
                }
            } catch (Exception e) {
                System.out.println();
                System.out.print("\t" + e.getMessage());
            }
            
            System.out.println();
        }
    }
}
