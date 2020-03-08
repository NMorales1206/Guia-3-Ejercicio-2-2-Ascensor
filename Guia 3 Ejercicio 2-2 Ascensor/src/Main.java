import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        boolean exit = false;
        System.out.println();
        System.out.println("#################################");
        System.out.println("Welcome to the EAN Guide 3 Act. 2");
        System.out.println("#################################");
        System.out.println("------------Elevator-------------");
        System.out.println();
        Elevator newElevator = initInstance();
        do {
            int option = menu();
            switch (option) {
                case 1:
                    boolean intChecker;
                    do {
                        System.out.println("Enter the number of upper floors:");
                        intChecker = input.hasNextInt();
                        if(intChecker) {
                            newElevator.setTotalFloors(input.nextInt());
                            break;
                        } else {
                            System.out.println("ERROR: Invalid input. Please use Integers");
                            System.out.println();
                        }
                        input.nextLine();
                    } while(true);
                    input.nextLine();
                    do {
                        System.out.println("Enter the number of basements or lower floors:");
                        intChecker = input.hasNextInt();
                        if(intChecker) {
                            newElevator.setTotalBasements(input.nextInt());
                            break;
                        } else {
                            System.out.println("ERROR: Invalid input. Please use Integers");
                        }
                        input.nextLine();
                    } while(true);
                    input.nextLine();
                    newElevator.setFloorArray();
                    System.out.println();
                    System.out.println("This is the new floor schema: ");
                    System.out.println(Arrays.toString(newElevator.getFloorArray()));
                    System.out.println();
                    break;
                case 2:
                    System.out.println("This is the floor schema: ");
                    System.out.println(Arrays.toString(newElevator.getFloorArray()));
                    System.out.println();
                    break;
                case 3:
                    System.out.println("You are currently in the floor: " + newElevator.getCurrentFloor());
                    System.out.println();
                    Thread.sleep(1500);
                    break;
                case 4:
                    System.out.println(Arrays.toString(newElevator.getFloorArray()));
                    do {
                        System.out.println("Please enter the floor you want to move to.");
                        intChecker = input.hasNextInt();
                        if(intChecker) {
                            int floor = input.nextInt();
                            newElevator.elevatorUsage(floor);
                            if(newElevator.findIndex(floor) == -1) {
                                System.out.println("You are currently in the floor: " + newElevator.getCurrentFloor());
                            } else {
                                System.out.println("We have arrive to the floor: " + newElevator.getCurrentFloor());
                            }
                            System.out.println();
                            Thread.sleep(1500);
                            break;
                        } else {
                            System.out.println("ERROR: Invalid input. Please use Integers");
                            System.out.println();
                            input.nextLine();
                        }
                        input.nextLine();
                    } while(true);
                    input.nextLine();
                    break;
                case 0:
                    System.out.println("Exiting app.");
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    public static Elevator initInstance() {
        boolean intChecker;
        int upFloor;
        int baseFloor;
        do {
            System.out.println("Enter the number of upper floors:");
            intChecker = input.hasNextInt();
            if(intChecker) {
                upFloor = input.nextInt();
                break;
            } else {
                System.out.println("ERROR: Invalid input. Please use Integers");
                System.out.println();
            }
            input.nextLine();
        } while(true);
        input.nextLine();
        do {
            System.out.println("Enter the number of basements or lower floors:");
            intChecker = input.hasNextInt();
            if(intChecker) {
                baseFloor = input.nextInt();
                break;
            } else {
                System.out.println("ERROR: Invalid input. Please use Integers");
            }
            input.nextLine();
        } while(true);
        input.nextLine();
        Elevator newElevator = new Elevator(upFloor, baseFloor);
        System.out.println();
        System.out.println("This is the new floor schema: ");
        System.out.println(Arrays.toString(newElevator.getFloorArray()));
        System.out.println();
        return newElevator;
    }

    public static int menu() throws InterruptedException {

        int option;
        do {
            System.out.println("What do you want to do?");
            System.out.println();
            System.out.println("1. add the number of floors and basement floors.");
            System.out.println("2. Check the floor schema.(Displays the floors in the building)");
            System.out.println("3. Check the current floor.");
            System.out.println("4. Use the elevator.");
            System.out.println("0. To exit the app.");
            System.out.println();
            System.out.println("Please enter the number of what you want to execute: ");
            boolean optionChecker = input.hasNextInt();
            if(optionChecker) {
                option = input.nextInt();
                switch (option) {
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
                    case 4:
                        return 4;
                    case 0:
                        return 0;
                    default:
                        System.out.println("ERROR: Invalid Option.");
                        System.out.println("ERROR: Please enter a number between 1 and 4. Or 0 to exit.");
                        Thread.sleep(3500);
                        break;
                }
            } else {
                System.out.println("ERROR: Invalid option.");
                System.out.println("ERROR: Letters are not allowed.");
                System.out.println("ERROR: Please enter a number between 1 and 4. Or 0 to exit.");
                Thread.sleep(3500);
            }
            input.nextLine();
        } while (true);
    }
}