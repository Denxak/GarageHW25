package ait.cars.dao;

import ait.cars.model.Car;

public class GarageImpl implements Garage {
    private Car[] cars;
    private int size;

    public GarageImpl(int capacity) {
        cars = new Car[capacity];
    }

    @Override
    public boolean addCar(Car car) {
        if (car == null || cars.length == size || findCarsByRegNumber(car.getRegNumber()) != null) {
            return false;
        }
        cars[size++] = car;
        return true;
    }

    @Override
    public Car removeCar(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber() == regNumber) {
                Car v = cars[i];
                cars[i] = cars[--size];
                cars[size] = null;
                return v;
            }
        }
        return null;
    }

    @Override
    public Car findCarsByRegNumber(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber().equals(regNumber)) {
                return cars[i];
            }
        }
        return null;
    }

    @Override
    public Car[] findCarsByModel(String model) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getModel().equals(model)) {
                count++;
            }
        }
        Car[] res = new Car[count];
        for (int i = 0, j = 0; j < count; i++) {
            if (cars[i].getModel().equals(model)) {
                res[j++] = cars[i];
            }
        }
        return res;
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getCompany().equals(company)) {
                count++;
            }
        }
        Car[] res = new Car[count];
        for (int i = 0, j = 0; j < count; i++) {
            if (cars[i].getCompany().equals(company)) {
                res[j++] = cars[i];
            }
        }
        return res;
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getEingine() >= min && cars[i].getEingine() < max) {
                count++;
            }
        }
        Car[] res = new Car[count];
        for (int i = 0, j = 0; j < count; i++) {
            if (cars[i].getEingine() >= min && cars[i].getEingine() < max) {
                res[j++] = cars[i];
            }
        }
        return res;
    }

    @Override
    public Car[] findCarsByColor(String color) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i].getColor().equals(color)) {
                count++;
            }
        }
        Car[] res = new Car[count];
        for (int i = 0, j = 0; j < count; i++) {
            if (cars[i].getColor().equals(color)) {
                res[j++] = cars[i];
            }
        }
        return res;
    }

    @Override
    public void printCars() {
        for (int i = 0; i < size; i++) {
            System.out.println(cars[i]);
        }
    }

    @Override
    public int quantity() {
        return size;
    }
}
