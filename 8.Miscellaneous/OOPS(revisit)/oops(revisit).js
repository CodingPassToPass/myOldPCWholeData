/*if we make objects individually then it takes so much time and memory */

// const stu1 = {
//     name: "adam",
//     age: 25,
//     marks: 95,
//     getMarks: function (){
//         return this.marks;
//     }
// };
// const stu2 = {
//     name: "eve",
//     age: 25,
//     marks: 94,
//     getMarks: function (){
//         return this.marks;
//     }
// };
// const stu3 = {
//     name: "casey",
//     age: 23,
//     marks: 85,
//     getMarks: function (){
//         return this.marks;
//     }
// };


//-----------------------( Object Prototypes )------------------------//
/*

Prototypes are the mechanism by which javascript  objects inherit features from one another.
it is like a single template object that all objects inherit methods and properties from without having own copy.

arr._proto_(reference)
Array.prototype(actual object)
String.prototype

Every object in javascript has a built-in property, which is called prototype.
The prototype is itself an object, so the prototype will have its own prototype, making what's called a prototype chain. 
the chain ends when we reach a prototype that has null for its own prototype. 

//we can change the method of array using:-

arr._proto_.push = (n) => {console.log("pushing number : ",n);}
arr.__proto__.pop=(n)=>{console.log("bhai mera maan na hai delete karna ka")};


----------------------

if("dsa".toUpperCase=="das".toUpperCase)
true 
it is because both use same prototype functions and making copies for differnet strings.


*/

//-----------------------( Factory functions)------------------------//


// function PersonMaker(name, age) {
//     const person = {
//         name: name,
//         age: age,
//         talk() {
//             console.log(`Hi, my name is ${this.name}`);
//         },
//     }

//         return person;
//     };

// let p1 = PersonMaker("adam", 25);   //copy
// let p2 = PersonMaker("eve",25);     //copy

/*if we write p1.talk==p2.talk then get false because both copies are different and memory is made for each object functions .*/



//-----------------------( New operator)------------------------//

/*the new operator lets developers create an instance(like p1,p2) of a user-defined object type or of one of the built-in object types that has a constructor functions */


// Constructors - doesn't return anything and start with capital Letters
// function Person(name, age) {
//     this.name = name;
//     this.age = age; 
//     console.log(this);            //this is a window object
//     console.log(this.name);       // this referses as a new instance of object or person object
// } 

// Person.prototype.talk = function () {
//   console.log(`HI, my name is ${this.name}`);  
// };
  
// let p1 = new Person("adam", 25);  
// let p2 = new Person("eve",25);       

/*if we write p1.talk==p2.talk then get true because both use same copy(or refer same instance) and memory is not made for each object functions as local variables .*/



//-----------------------( Classes)------------------------//
/*same method as New operator but easier syntax*/

/*classes are a template for creating objects.
The constructor method is a special method of a class for creating and initializing an object instance of that class.

*/

// class Person{
//     constructor( name , age ) {
//         this.name = name;
//         this.age = age;
//     } 
//     talk() {
//         console.log(`Hi, my anme is ${this.name}`);
//     }
// }

// let p1 = new Person("adam", 25);
// let p2 = new Person("eve",  25);

/*if we write p1.talk==p2.talk then get true because both use same copy(or refer same instance) and memory is not made for each object functions as local variables .*/


//-----------------------( Inheritance)------------------------//

/*Inheritance is a mechanism that allows us to create new classes on the basis of already existing classes. */


/*Example1 ---------------*/

// class Person {
//     constructor(name,age) {
//         console.log("Person class constructor");
//         this.name = name;
//         this.age = age;
//     }
//     talk() { 
//         console.log(`Hi, I am ${this.name}`);
//     }
// }
// class Student extends Person {
//     constructor(name,age,marks) {
//         console.log("Student class constructor");
//         super(name,age);
//         this.marks = marks;
//     }
// }
// class Teacher extends Person {
//     constructor(name,age,subject) {
//     console.log("Teacher class constructor");
//         super(name,age);
//         this.subject = subject;
//     }
// }

// let p1 = new Student("aman",23,98);  
// let p2 = new Teacher("deepak",21,98);  


/*Example2 ---------------*/

class Mammal {
    constructor(name) {
        this.name = name;
        this.type = "warm-blooded";
    }
    eat() {
        console.log("I am eating ");
    }
}

class Dog extends Mammal {
    constructor(name) {
        super(name);
    }
    bark() {
        console.log("wooff....")
    }
    eat() {
        console.log( "i am Dog and eat anything");
    }
}

class Cat extends Mammal {
    constructor(name) {
        super(name);
    }
    meow() {
        console.log("meow....");
    }
}

let d1 = new Dog("tommy");
let c1 = new Cat("lilly"); 


















