// *******************************************************************
// Object2.java By: Aiman Hanna (C) 1993 - 2017
// This program illustrates more of the "Object" class. That class 
// defines the equals() method, however, this method should always be 
// "overridden" (not only overloaded). This program focuses on that point. 
//
// Notice the addition of the equals() method to the different classes. while
// each of these classes has defined the equals() method, none of them has 
// overridden it. 
//
// Now does this program work properly? Would it always work properly? Why? or Why not?  
//
// Key Points:
// 1) The "Object" class
// 2) The equals() method - overriding vs. overloading
// *******************************************************************

// Some classes; notice that the implementation of these classes are not 
// given yet
class Book {}
class Painting{}
class Phones{}

// Vehicle Class
class Vehicle {

	// Attributes
	private int numOfDoors;
	private double price;
	protected static int i = 12;
	
	// Constructors
	public Vehicle()	// default constructor 
	{
		System.out.println("\nCreating a vehicle object using default constructor ....");
		
		numOfDoors = 4;
		price = 10000;
	}
	
	public Vehicle(int nd, double pr)	
	{
		System.out.println("\nCreating a vehicle object using parameterized constructor ....");
		
		numOfDoors = nd;
		price = pr;
	}
	
	
	public Vehicle(Vehicle vec)	// copy constructor 
	{
		System.out.println("\nCreating a vehicle object using copy constructor ....");
		
		numOfDoors = vec.numOfDoors;
		price = vec.price;
	}
	
	public int getNumOfDoors()
	{
		return numOfDoors;
	}
	
	public void setNumOfDoors(int nd)
	{
		numOfDoors = nd;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double pr)
	{
		price = pr;
	}
	
	public String toString()
	{
		return "This Vehicle has " + numOfDoors + 
		" doors and it price is " + price + "$.";
	}
	
	public boolean equals(Vehicle v)
	{
		return (this.numOfDoors == v.numOfDoors && this.price == v.price);
	}
} // end of Vehicle class




// Bus Class - This is a derived class from the Vehicle Class; that is it 
// inherits the Vehicle class 
class Bus extends Vehicle{

	// Attributes
	private int passengerCapacity;
	
	// Constructors
	public Bus()	// default constructor 
	{
		System.out.println("Creating a bus object using default constructor ....");
		
		passengerCapacity = 10;
	}
	
	public Bus(int pc)	
	{
		System.out.println("Creating a bus object using parameterized constructor ....");
		
		passengerCapacity = pc;
	}
	
	public Bus(Bus b)	
	{
		System.out.println("Creating a bus object using copy constructor ....");
		
		setNumOfDoors(b.getNumOfDoors());
		setPrice(b.getPrice());
		passengerCapacity = b.passengerCapacity;
	}
	
	
	// A constructor that would allow the setting of the price and the number of doors
	// and the passenger capacity
	public Bus(int nd, double pr, int pc)	
	{
		
		this(pc); 	// Call the constructor that sets the passenger capacity 
	
		System.out.println("Creating a bus object using parameterized constructor for full settings....\n");
		
		// Notice that we now cannot call super to set the other two attributes 
		// (i.e. super(nd, pr);) since either "this" or 'super" must be the first 
		// statement, and it is not possible to have both of them as such!
		setPrice(pr);		
		setNumOfDoors(nd); 
		
	}

	
	public int getPassangerCapacity()
	{
		return passengerCapacity;
	}
	
	public void setPassengerCapacity(int pc)
	{
		passengerCapacity = pc;;
	}
	
	public String toString()
	{
		return "This Bus has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
		"$. The passenger capacity of this bus is " + passengerCapacity + "."; 
	}
	
	// Override the setPrice() method
	public void setPrice(double pr)
	{
		if(pr < getPrice())
			System.out.println("The price of this bus will be reduced from " + getPrice() + "$ to " + pr + "$.");
		else if (pr > getPrice())
			System.out.println("The price of this bus will be increased from " + getPrice() + "$ to " + pr + "$.");
		else
			System.out.println("No change will be applied to this price of the bus.");
		
		super.setPrice(pr);		
		// Notice that you cannot access "price" directly  since it is private to the base class
		// i.e. price = pr; would be illegal
		
	}
	
	
	public boolean equals(Bus b)
	{
		return (this.getNumOfDoors() == b.getNumOfDoors() &&
				this.getPrice() == b.getPrice() &&
				this.passengerCapacity == b.passengerCapacity);
	}
}   // end of Bus class
	


//Car Class - This is a derived class from the Vehicle Class.
//For a Car object, we are interested in its number of seats
class Car extends Vehicle{

	// Attributes
	private int numOfSeats;
	
	// Constructors
	public Car()	// default constructor 
	{
		System.out.println("Creating a car object using default constructor ....");
		
		numOfSeats = 5;
	}
	
	public Car(int nd, double pr, int ns)	
	{
		super(nd, pr);
		System.out.println("Creating a car object using parameterized constructor ....");
		
		numOfSeats = ns;
	}
	
	public Car(Car c)	
	{
		System.out.println("Creating a car object using copy constructor ....");
		setNumOfDoors(c.getNumOfDoors());
		setPrice(c.getPrice());
		numOfSeats = c.numOfSeats;
	}
	
	
	public int getNumOfSeats()
	{
		return numOfSeats;
	}
	
	public void setNumOfSeats(int ns)
	{
		numOfSeats = ns;;
	}
	
	public String toString()
	{
		return "This Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
		"$. The number of seats of this car is " + numOfSeats + "."; 
	}
		
	public boolean equals(Car c)
	{
		return (this.getNumOfDoors() == c.getNumOfDoors() &&
				this.getPrice() == c.getPrice() &&
				this.numOfSeats == c.numOfSeats);
	}
}   // end of Car class



//SportCar Class - This is a derived class from the Car Class
//For a SportCar object, we are interested in its gas consumption 
// as gallon per 100 miles
class SportCar extends Car{

	// Attributes
	private double gasConsumption;
	
	// Constructors
	public SportCar()	// default constructor 
	{
		System.out.println("Creating a sport car object using default constructor ....");
		
		gasConsumption = 4;
	}
	
	public SportCar(int nd, double pr, int ns, double gc)	
	{
		super(nd, pr, ns);
		System.out.println("Creating a sport car object using parameterized constructor ....");
		gasConsumption = gc;
	}
	
	public SportCar(SportCar sc)	
	{
		System.out.println("Creating a sport car object using copy constructor ....");
		
		setNumOfDoors(sc.getNumOfDoors());
		setPrice(sc.getPrice());
		setNumOfSeats(sc.getNumOfSeats());
		
		gasConsumption = sc.gasConsumption;
	}
	
	
	public double getGasConsumption()
	{
		return gasConsumption;
	}
	
	public void setGasConsumption(double gc)
	{
		gasConsumption = gc;;
	}
	
	public String toString()
	{
		return "This Sport Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
		"$. The number of seats of this Sport Car is " + getNumOfSeats() + 
		"\nand its gas consumption is " + gasConsumption + " gallons/100-mile."; 
	}
		
		public boolean equals(SportCar sc)
	{
			System.out.println("Executing equals() from the SportCar Class");
			return (this.getNumOfDoors() == sc.getNumOfDoors() &&
					this.getPrice() == sc.getPrice() &&
					this.getNumOfSeats() == sc.getNumOfSeats() &&
					this.gasConsumption == sc.gasConsumption);
	}
}   // end of Sport Car class



//RaceCar Class - This is a derived class from the SportCar Class
//For a RaceCar object, we are interested in its horse power
class RaceCar extends SportCar{

	// Attributes
	private int horsePower;
	
	// Constructors
	public RaceCar()	// default constructor 
	{
		System.out.println("Creating a race car object using default constructor ....");
		
		horsePower = 400;
	}
	
	public RaceCar(int nd, double pr, int ns, double gc, int hp)	
	{
		super(nd, pr, ns, gc);
		System.out.println("Creating a race car object using parameterized constructor ....");
		horsePower = hp;
	}
	
	public RaceCar(RaceCar rc)	
	{
		System.out.println("Creating a race car object using copy constructor ....");
		
		setNumOfDoors(rc.getNumOfDoors());
		setPrice(rc.getPrice());
		setNumOfSeats(rc.getNumOfSeats());
		setGasConsumption(rc.getGasConsumption());
		
		horsePower = rc.horsePower;
	}
	
	
	public int getHorsePower()
	{
		return horsePower;
	}
	
	public void setHorsePower(int hp)
	{
		horsePower = hp;
	}
	
	public String toString()
	{
		return "This Race Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
		"$. The number of seats of this Race Car is " + getNumOfSeats() + 
		"\nand its gas consumption is " + getGasConsumption() + " gallons/100-mile." +
		"The horse power of this Race Car is: " + horsePower + "."; 
	}
		
	public boolean equals(RaceCar rc)
	{
		System.out.println("Executing equals() from the RaceCar Class");
		return (this.getNumOfDoors() == rc.getNumOfDoors() &&
				this.getPrice() == rc.getPrice() &&
				this.getNumOfSeats() == rc.getNumOfSeats() &&
				this.getGasConsumption() == rc.getGasConsumption() &&
				this.horsePower == rc.horsePower);
	}
}   // end of Race Car class

public class Object2 {
	public static void main(String[] args) {
		System.out.println("Will create two Vehicle objects");

		Vehicle v1 = new Vehicle(), v2 = new Vehicle(4, 5000);
		v1.setPrice(22000);
		v2.setPrice(16700);
		
		System.out.println();
		System.out.println("Will create three Bus objects");

		Bus b1 = new Bus(2, 55000, 37), b2 = new Bus(3, 62000, 55), b3 = new Bus(b1);
		
		
		System.out.println();
		System.out.println("Will create two Car objects");

		Car c1 = new Car(4, 12000, 5), c2 = new Car(2, 26000, 2);
		
		System.out.println();
		System.out.println("Will create two Sport Car objects");

		SportCar sc1 = new SportCar(4, 12000, 5, 3), sc2 = new SportCar(3, 12000, 5, 3);
	
		
		System.out.println();
		System.out.println("Will create two Race Car objects");

		RaceCar rc1 = new RaceCar(4, 67000, 2, 4, 400), rc2 = new RaceCar(3, 85000, 4, 4, 450);
	
		System.out.println("\nComparing some of the vehicles");
		System.out.println("==============================");

		
		if(b1.equals(b2))
			System.out.println("The two bus objects (b1 & b2) are equal");
		else
			System.out.println("The two bus objects (b1 & b2) are not equal");
		

		if(b1.equals(b3))
			System.out.println("The two bus objects (b1 & b3) are equal");
		else
			System.out.println("The two bus objects (b1 & b3) are not equal");
		
		if(sc1.equals(sc2))
			System.out.println("The two sport car objects (sc1 & sc2) are equal");
		else
			System.out.println("The two sport car objects (sc1 & sc2) are not equal");
		
		if(rc1.equals(rc2))
			System.out.println("The two race car objects (rc1 & rc2) are equal");
		else
			System.out.println("The two race car objects (rc1 & rc2) are not equal");
		

		System.out.println("\nComparing some vehicles from different classes");
		System.out.println("==============================================");

		// Now notice the following statements 
		rc1.setPrice(6000);
		sc1.setPrice(6000);
		
		rc1.setNumOfDoors(2);
		sc1.setNumOfDoors(2);
		
		rc1.setNumOfSeats(2);
		sc1.setNumOfSeats(2);
		
		rc1.setGasConsumption(5);
		sc1.setGasConsumption(5);
		
		rc1.setHorsePower(300);
		
		
		if(rc1.equals(sc1))
			System.out.println("Race car rc1 & sport car sc1 are equal");
		else
			System.out.println("Race car rc1 & sport car sc1 are not equal");

		
		if(sc1.equals(rc1))
			System.out.println("Race car rc1 & sport car sc1 are equal");
		else
			System.out.println("Race car rc1 & sport car sc1 are not equal");
	
		// Worst, the following statements will simply crash that program
		// Create another Bus 
		Bus b4 = null;		// Is that really a bus object? is that object initialized!
		
		if(b1.equals(b4))
			System.out.println("The two bus objects (b1 & b4) are equal");
		else
			System.out.println("The two bus objects (b1 & b4) are not equal");

		
	}

}

/* The Output (NOTICE THE PROGRAM CRASH AT THE END)
Will create two Vehicle objects

Creating a vehicle object using default constructor ....

Creating a vehicle object using parameterized constructor ....

Will create three Bus objects

Creating a vehicle object using default constructor ....
Creating a bus object using parameterized constructor ....
Creating a bus object using parameterized constructor for full settings....

The price of this bus will be increased from 10000.0$ to 55000.0$.

Creating a vehicle object using default constructor ....
Creating a bus object using parameterized constructor ....
Creating a bus object using parameterized constructor for full settings....

The price of this bus will be increased from 10000.0$ to 62000.0$.

Creating a vehicle object using default constructor ....
Creating a bus object using copy constructor ....
The price of this bus will be increased from 10000.0$ to 55000.0$.

Will create two Car objects

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....

Will create two Sport Car objects

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....
Creating a sport car object using parameterized constructor ....

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....
Creating a sport car object using parameterized constructor ....

Will create two Race Car objects

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....
Creating a sport car object using parameterized constructor ....
Creating a race car object using parameterized constructor ....

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....
Creating a sport car object using parameterized constructor ....
Creating a race car object using parameterized constructor ....

Comparing some of the vehicles
==============================
The two bus objects (b1 & b2) are not equal
The two bus objects (b1 & b3) are equal
Executing equals() from the SportCar Class
The two sport car objects (sc1 & sc2) are not equal
Executing equals() from the RaceCar Class
The two race car objects (rc1 & rc2) are not equal

Comparing some vehicles from different classes
==============================================
Executing equals() from the SportCar Class
Race car rc1 & sport car sc1 are equal
Executing equals() from the SportCar Class
Race car rc1 & sport car sc1 are equal
Exception in thread "main" java.lang.NullPointerException
	at Bus.equals(Object2.java:178)
	at Object2.main(Object2.java:462)
*/
	