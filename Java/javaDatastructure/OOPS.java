// import java.util.*;
package Java.javaDatastructure;
/* (1).basics of classes and objects */   /*class=> ["attributes(properties)", "functions(behavious)"] */
/*
public class OOPS {
    public static void main( String args[]){
        Pen p1 = new Pen();     //created a pen object called p1 , in the heap memory( all objects are created in heap memory)
        System.out.println(p1);
        System.out.println(p1.getColor());
        p1.setColor("blue");
        System.out.println(p1.getColor());
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());
        p1.color = "green";  //color is not private 
        System.out.println(p1.color);

        p1.setLength(55);
        System.out.println(p1.getLength());



        // BankAccount myAcc = new BankAccount();
        // myAcc.username = "Gaganshu yadav";
        // myAcc.setPassword("gagan");

        // myAcc.password = "hpass"         //not accessable gives an warning and error

        // System.out.println(myAcc.username);
        // System.out.println(myAcc.getPassword());



    }
}

class BankAccount{
    public String username;
    private String password;

    public void setPassword(String pwd){
        password = pwd;
    }
    public String getPassword(){
        return password;
    }
}

class Pen {
    String color;                                                 //by default they are package-private:- accessible with in the same package( Not any of them public, private, protected)
    private int tip;
    private int length;

    String getColor(){
        return this.color;
    }

    int getTip(){
        return tip;
    }

    int getLength(){
        return length;
    }

    void setColor(String newColor){
        this.color = newColor;             //this keyword is used to refer to the current object 
    }

    void setTip(int newTip){
        tip = newTip;
    }

    void setLength(int length){
        this.length = length;
    }
}

class Student {
    String name;
    int age;
    float percentage; //cgpa

    void calcPercentage(int phy, int chem, int math){
        percentage = ( phy+ chem+ math) / 3;
    }
}

*/

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

/*(2). 

=> getters :- to return a value
=> setters :- to modify the value
=> this :- this keyword is used to refer to current object

=> Encapsulation:- Encapsulation is defined as the wrapping up of data and methods under a single unit.
    it also implements data hiding.

=> Constructors:- invoked automatically at the time of object creation.
--same name as class name, 
--no return type, 
--constructors are only calls at once at object creation, 
--memory allocation happens when constructor is called.

=> Types of Constructors:- Non-parameterized constructor, parameterized constructor, Copy Constructor( shallow, deep and lazy copy)

=> constructor overloading :- when no. of constructors are made for each parameter( multiple constructors).

=> destructors:- to delete the object or destroyed it.
    java does not have destructors, but it does have a garbage collector and a finalize() method that helps clean up objects.
   --(Garbage collector): Automatically removes unused objects from memory to prevent memory leaks.
        when there are no more references to an object, the garbage collector marks it as unreachable and reclaims its space.
   --(Finalize): Called by the garbage collector before it removes an object from memory.
        the method can run zero or one time.
   --(Cleaner): Can be used to free up resources help by an object.

   --(process): no longer referenced-->mark phase-->sweep phase-->compact phase-->finalize(used to release resources)-->cleaner

*/

/*

public class OOPS{
    public static void main( String args[]){

        //default constructor
        Student s = new Student();     

        //parameterized constructor
        Student s1 = new Student("gagan");  
        System.out.println(s1.name);
        Student s2 = new Student(123);
        System.out.println(s2.roll);

        //copy constructor
        Student scopy = new Student();
        scopy.name = "gagan";
        scopy.roll = 3232;
        scopy.password = "pass" ;
        System.out.println("scopy :- " + scopy.name + "  " + scopy.roll + "  " + scopy.password);
        scopy.marks[0] = 100;
        scopy.marks[1] = 40;
        scopy.marks[2] = 70;

        //copy
        Student s3 = new Student( scopy);
        s3.password = "fail";
        System.out.println("s3 :- " + s3.name + "  " + s3.roll + "  " + s3.password);

        //print marks of s3 after copy from scopy
        System.out.println("------s3 before change of scopy------");
        for(int i=0; i<3; i++){
            System.out.println( s3.marks[i]);
        }

        //change in scopy
        scopy.marks[1] = 1000;
        scopy.name="vishu"; //this cannot be changed only for array due to address of array

        //print marks of s3 after change in scopy
        System.out.println("------s3 after change of scopy------");
        System.out.println("s3 :- " + s3.name + "  " + s3.roll + "  " + s3.password);
        for(int i=0; i<3; i++){
            System.out.println( s3.marks[i]);
        }

        
        
    }
}

class Student {
    String name;
    int roll;
    String password;
    int marks[] = new int[3];

    //non-parameterized constructor
    Student(){
        System.out.println("constructor is called...");
    }

    //parameterized constructor
    Student(String name){
        this.name = name;
    }
    Student(int roll){
        this.roll = roll;
    }

    //copy constructor ( shallow copy constructor)
    // Student(Student anyObj){
    //     this.name = anyObj.name;
    //     this.roll = anyObj.roll;
    //     this.marks = anyObj.marks;
    // }

     //copy constructor ( deep copy constructor)
     Student(Student anyObj){
        this.name = anyObj.name;
        this.roll = anyObj.roll;
        for(int i=0; i < anyObj.marks.length ; i++){
            this.marks[i] = anyObj.marks[i];
        }
    }

    //copy constructor ( lazy copy constructor)[done after all tops in this]
}

*/




/*(3). Inheritance:-
    inheritance is when properties and methods of base class(parent class) are passed on to a derived class(child class).

Types of Inheritance:- Single-Level Inheritance, Multi-Level Inheritance,  

*/

/*Single-level Inheritance */

/*
class OOPS{
    public static void main(String args[]){
        
        Fish shark = new Fish();
        shark.color = "red";
        System.out.println(shark.color);
        shark.eat();
        shark.swim();
    }

}

 //base class
 class Animal{
    String color;

    void eat(){
        System.out.println("eats");
    }
    void breathe() {
        System.out.println("breathes");
    }
}

//derived class
class Fish extends Animal{
    int fins;

    void swim(){
        System.out.println("swims in water");
    }
}

*/

/*Multi-level Inheritance */

/* 
class OOPS{
    public static void main(String args[]){
        
        Dog puppy = new Dog();
        puppy.breed = "cute";
        puppy.color = "white";
        puppy.legs = 4;
        System.out.println(puppy.breed);
        System.out.println(puppy.color);
        System.out.println(puppy.legs);
        puppy.walk();
        puppy.sleep();
        puppy.eat();
        puppy.breathe();

    }

}

 //base class
 class Animal{
    String color;

    void eat(){
        System.out.println("eats");
    }
    void breathe() {
        System.out.println("breathes");
    }
}

//derived class
class Mammal extends Animal{
    int legs;

    void sleep(){
        System.out.println("mostly not sleep so much");
    }
}

class Dog extends Mammal{
    String breed;

    void walk(){
        System.out.println("walking always");
    }
}
*/

/*Hierarchial Inheritance */

/* 
class OOPS{
    public static void main(String args[]){

        Fish shark = new Fish();
        Bird parrot = new Bird();
        Mammals dog = new Mammals();
        shark.eat();
        parrot.eat();
        dog.eat();
    }

}

 //base class
 class Animal{
    String color;

    void eat(){
        System.out.println("eats");
    }
    void breathe() {
        System.out.println("breathes");
    }
}

//derived class-1
class Fish extends Animal{
    int fins;

    void swim(){
        System.out.println("swim always");
    }
}

//derived class-2
class Bird extends Animal{
    String wings;

    void fly(){
        System.out.println("fly always");
    }
}

//derived class-3
class Mammals extends Animal{
    String breed;

    void walk(){
        System.out.println("walking always");
    }
}

*/

/*Hybrid Inheritance */

/*multiple inheritance  */ /* they are in cpp but not in java */
                           /*to avoid ambiguity or complexity or difficult to understand or diamond problem*/
                           /*can be achieved by interfaces because it cannot make a diamond */ 



/*(4). Polymorphism 
     --compile time ( method overloading)
     --run time ( method overriding)

       method overloading:- multiple functions with the same name but different parameters
       method overriding:- parent and child classes both contain the same function with a differnet definition. (child class function executes ,if both functions are same of parent and child class).
*/

/*(5). Packages in java:- package is a group of similar types of classes, interfaces and sub-packages */

/*(6). Abstraction:- Hiding all the unnecessary details and showing only the important parts to the user
 
* Abstract Classes:-
    --Cannot create an instance(means object) of abstract class        (abstrct classes main hum object nhi bana sakta)
    --can have abstract/non-abstract methods
    --can have constructors
*/

/*
public class OOPS{

    public static void main(String args[]){
        Horse h = new Horse();
        h.eat();
        h.walk();
        System.out.println(h.color);

        Fish f = new Fish();
        f.eat();
        f.walk();
        f.changeColor();
        System.out.println(f.color);

        // Animal -> Horse -> mustang [constructor called]
        Mustang m = new Mustang();
    }
}

abstract class Animal{

    String color;
      
    //constructor is used to initialize the color by default, if we not giving the property 
    Animal(){
        color = "brown";
        System.out.println("Animal contructor called");
    }

    void eat(){
        System.out.println("animal eats");
    }

    abstract void walk();
}

class Horse extends Animal{

    Horse(){
        System.out.println("Horse constructor called");
    }

    void walk(){
        System.out.println("walks on 4 legs");
    }

    void changeColor(){
        color = "dark brown";
    }
}

class Fish extends Animal{


    void walk(){
        System.out.println("dive with no legs");
    }

    void changeColor(){
        color = "red";
    }
}

class Mustang extends Horse{
    Mustang(){
        System.out.println("Mustang constructor called");
    }
}

*/

/*(7). 
   Class:- class is a blue print of object ( implement with extends)

   Interfaces:- interface is a blue print of class
       --it is used to implement multiple inheritance. 
       --total abstraction(interfaces)[100%]                    not like abstract class which have abs/non-abs[0-100%]

    Interfaces:- ( implement with implements)
        --All methods are public, abstract, and without implementation
        --Used to achieve total abstraction
        --Variables in the interface are final, public and static

 */

 /*
public class OOPS{
    public static void main(String args[]){

        Queen q = new  Queen();
        q.moves();

        King k = new  King();
        k.moves();

    }
}

interface ChessPlayer{
    void moves();
}

class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right, diagonal");
    }
} 

class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right");
    }
}

class King implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right, diagonal(by 1 step)");
    }
} 

*/

/*multiple-inheritance example */

/*
public class OOPS{
    public static void main(String args[]){

        Bear b = new Bear();

    }
}

interface Harbivore{
    void h();
}

interface Carnivore{
    void c();
}

class Bear implements Harbivore, Carnivore{
    public void h(){
        System.out.println("harbi");
    }
    public void c(){
        System.out.println("carni");
    }
}
*/

/*(8). (Static Keyword):- static keyword in java is used to share the same variable or method of a given class.
          --properties
          --functions
          --blocks
          --Nested Classes

        ( super keyword):- super keyword is used to refer immediate parent class object.
          --to access parent's properties
          --to access parent's functions
          --to access parent's constructor
*/

/*
class OOPS{
    public static void main(String args[]){                 //our main function is a static function
        Student s1 = new Student();
        s1.schoolName = "ssc";

        Student s2 = new Student();
        System.out.println(s2.schoolName);
        //schoolName define for all, means all objects points to the same schoolName memeory
    }
}

class Student{
    String name;
    int roll;
    static String schoolName;   //static variable

    static int returnPercentage( int math, int phy, int chem){      //static function
        return ( math + phy + chem);
    }

    void setName( String name){
        this.name = name; 
    }

    String getName(){
        return this.name;
    }
}

*/

class OOPS{
    public static void main(String args[]){                
        Horse h = new Horse();
        System.out.println(h.color);
    }
}

class Animal{
    String color;
    Animal(){
        System.out.println("animal constructor called");
    }
}

class Horse extends Animal{
    Horse(){
        super();        //super constructor called by default, but here we are just call it by ourself, so first parent constructor called then child constructor called
        super.color = "brown";   //we can setup our parent color by child
        System.out.println("horse constructor called");
    }
}




/*constructor chaining */














































