package arrays.easy;

// https://leetcode.com/problems/design-parking-system/description/
// 1603. Design Parking System
class ParkingSystem {

    int[] parking;

    public ParkingSystem(int big, int medium, int small) {
        this.parking = new int[3];
        this.parking[2] = small;
        this.parking[1] = medium;
        this.parking[0] = big;
    }

    public boolean addCar(int carType) {
        int idx = carType - 1;
        if (parking[idx] > 0) {
            parking[idx]--;
            return true;
        }
        return false;
    }
}
