
package edu.umb.cs681.hw02;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class Car {

	private String model, make;
	private int mileage, year;
	private float price;
	private int dominationCount;

	public Car(String make, String model, int mileage, int year, float price) {
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public String getMake() {
		return make;
	}

	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}

	public float getPrice() {
		return price;
	}

	public int getDominationCount() {
		return this.dominationCount;
	}

	public void setDominationCount(ArrayList<Car> cars) {
		
		for (Car car : cars) {
			if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage())
					&& (car.getYear() <= this.getYear())) {
				this.dominationCount++;
			}
		}
		this.dominationCount--; 	
	}
	
          @Override
        public String toString() {
        	
        	return this.make +" "+ this.model+" "+ this.mileage+" "+this.year+" "+this.price;
        }

	public static void main(String[] args) {
		
		
		

		
		List<Car> list=new ArrayList<Car>();
		list.add(new Car("Tesla", "S", 25, 2018, 100000));
		list.add(new Car("Toyota", "Corolla", 9, 2002, 35000));
		list.add(new Car("Honda", "Civic", 12, 2012, 40000));
		list.add(new Car("Ford", "Fiesta", 10, 2009, 38000));
		
	
		System.out.println("List sorted by Year:");
		List<Car> sortedByYear=list.stream().sorted(Comparator.comparingInt(Car::getYear)).collect(Collectors.toList());
		sortedByYear.forEach(System.out::println);
		
		System.out.println("List sorted by Mileage:");
		List<Car> sortedByMileage=list.stream().sorted(Comparator.comparingInt(Car::getMileage)).collect(Collectors.toList());
		sortedByMileage.forEach(System.out::println);
		
		System.out.println("List sorted by Price:");
		List<Car> sortedByPrice=list.stream().sorted(Comparator.comparingDouble(Car::getPrice)).collect(Collectors.toList());
		sortedByPrice.forEach(System.out::println);
		
		System.out.println("List sorted by Domination Count:");
		List<Car> sortedByDomCount=list.stream().sorted(Comparator.comparingInt(Car::getDominationCount)).collect(Collectors.toList());
		sortedByDomCount.forEach(System.out::println);
		

	}
}

