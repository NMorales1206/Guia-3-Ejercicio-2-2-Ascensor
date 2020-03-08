import java.util.Arrays;

public class Elevator {
    private int totalFloors, totalBasements, currentFloor, floorIndex;
    private int[] floorArray;

    public Elevator() {
        this(1,1);
    }

    public Elevator(int totalFloors, int totalBasements) {
        this.totalFloors = totalFloors;
        this.totalBasements = totalBasements;
        this.floorArray = new int[this.totalFloors+this.totalBasements];
        int floorCounter = this.totalBasements;
        for(int i = 0; i < this.totalBasements; i++) {
            this.floorArray[i] = floorCounter*(-1);
            floorCounter--;
        }
        floorCounter = 1;
        for(int i = this.totalBasements; i < floorArray.length; i++) {
            this.floorArray[i] = floorCounter;
            floorCounter++;
        }
        this.floorIndex = Arrays.binarySearch(this.floorArray, 1);;
        this.currentFloor = floorArray[floorIndex];
    }

    public int getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(int totalFloors) {
        this.totalFloors = totalFloors;
    }

    public int getTotalBasements() {
        return totalBasements;
    }

    public void setTotalBasements(int totalBasements) {
        this.totalBasements = totalBasements;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }
    // -- Make sure to pass the index for the desire floor --
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = floorArray[currentFloor];
    }

    public void setFloorArray() {
        this.floorArray = new int[this.totalFloors+this.totalBasements];
        int floorCounter = this.totalBasements;
        for(int i = 0; i < this.totalBasements; i++) {
            this.floorArray[i] = floorCounter*(-1);
            floorCounter--;
        }
        floorCounter = 1;
        for(int i = this.totalBasements; i < floorArray.length; i++) {
            this.floorArray[i] = floorCounter;
            floorCounter++;
        }
        this.floorIndex = Arrays.binarySearch(this.floorArray, 1);;
        this.currentFloor = floorArray[floorIndex];;
    }

    public int[] getFloorArray() {
        return this.floorArray;
    }

    public int findIndex(int floorNumber) {
        int index = Arrays.binarySearch(this.floorArray, floorNumber);
        return (index < 0) ? -1 : index;
    }

    public void elevatorUsage(int floor) throws InterruptedException {
        if(findIndex(floor) == -1) {
            System.out.println("That floor doesn't exist");
        } else {
            if(this.floorIndex < findIndex(floor)){
                for(int i = this.floorIndex; i < findIndex(floor); i++) {
                    System.out.println(floorArray[i]);
                    Thread.sleep(1500);
                }
            } else {
                for (int i = this.floorIndex; i > findIndex(floor); i--) {
                    System.out.println(floorArray[i]);
                    Thread.sleep(1500);
                }
            }
            this.floorIndex = findIndex(floor);
            setCurrentFloor(this.floorIndex);
        }
    }
}