#include<iostream>
using namespace std;

            /*(1.)OOPS class and objects , Empty class , Access Modifiers , Getter and Setters , padding and greedy alignment*/
/*
class Hero{
    //the size of class variable is defined by class datatype.if their is no datatype in class then the size of class is 1.
    //Access Modifiers => (public,private,protected) |||| [by default access modifier is private] |||| [private properties only accessable in class not out of the class] |||| [public properties accessable in class and also out of the class].
    
    //properties
    private:
    int health;

    public:
    char level;

    int gethealth(){
        return health;
    }
    char getlevel(){
        return level;
    }
    void sethealth(int h){
        health=h;
    }
    void setlevel(char l){
        level=l;
    }


};
int main() {
    //creation of object
    // Hero h1;
    // cout<<"size : "<< sizeof(h1) << endl;

    Hero ramesh;
    ramesh.level='A';
    cout<<ramesh.level<<endl;

    ramesh.sethealth(76);
    ramesh.setlevel('B');
    cout<<ramesh.gethealth() <<endl;
    cout<<ramesh.getlevel()  <<endl;

    return 0;
}
*/
                        /*(2.) static and dynamic allocation*/
/*
class Hero{
    private:
    int health;

    public:
    char level;

    int gethealth(){
        return health;
    }
    char getlevel(){
        return level;
    }
    void sethealth(int h){
        health=h;
    }
    void setlevel(char l){
        level=l;
    }


};
int main() {
    //static allocation
    Hero a;

    a.level='A';
    a.sethealth(100);

    cout<<" level is "<< a.level<<endl;
    cout<<"health is "<< a.gethealth()<<endl;

    //dynamic allocation
    Hero *b=new Hero;

    (*b).sethealth(200);
    (*b).level='B';

    cout<<" level is "<< (*b).level<<endl;
    cout<<"health is "<< (*b).gethealth()<<endl;

    b->sethealth(400);
    b->level='h';


    cout<<" level is "<< b->level<<endl;
    cout<<"health is "<< b->gethealth()<<endl;

    return 0;
}
*/
                        /*(3.) Constructor */
/*
(Constructor in C++):- is a special method that is invoked automatically at the time of object creation.
 It is used to initialize the data members of new objects generally. The constructor in C++ has the same name as the class or structure.
 It constructs the values i.e. provides data for the object which is why it is known as a constructor.

 --Constructor is a member function of a class, whose name is the same as the class name.
 --Constructor is a special type of member function that is used to initialize the data members for an object of a class automatically when an object of the same class is created.
 --Constructor is invoked at the time of object creation.
 --Constructors do not return value, (hence they do not have a return type).
 --A constructor gets called automatically when we create the object of the class.
 --Constructors can be overloaded(having two or more constructors in a class).
 --A constructor can not be declared virtual.(virtual function happens at run time and objects are created at run time then object requires a constructor.)
 
 Types of Constructors:-
 (i). (default constructor)        :-A default constructor is a constructor that doesn’t take any argument. It has no parameters. It is also called a zero-argument constructor.
 (ii).(Parameterized Constructors) :-make it possible to pass arguments to constructors. Typically, these arguments help initialize an object when it is created. 
 (iii).(Copy constructor)          :- takes a reference to an object of the same class as an argument.
                 Syntax:-
                        ClassName (ClassName &obj){
                        // body_containing_logic
                        }
 <<shallow and deep copy >>
 <<assignment operator>>
 
*/
/*
(this Keyword) :-Every object in C++ has access to its own address through an important pointer called this pointer.
 the this pointer is an implicit parameterr to all member functions.therefore,inside a member function,this may be used to refer to the invoking object.
 --this stores current object address and by using (this->object) we can access object.
 --friend function do not have a this pointer,because friends are not memders of a class.Only member functions have a this pointer.
 */

/*
class Hero{
    private:
    int health;

    public:
    char level;

    //default constructor
    Hero(){
        cout<<"constructor called "<<endl;
    }

    //parameterised constructor
    Hero(int health){
        this->health = health;              //[this->health and (*this).health both are same. because this stores the address of current object.(&stark and this both have same address)]    
    }

    Hero(int health,char level){
        this->health = health;
        this->level = level;
    }
    //copy constructor
    Hero(Hero& temp){
        cout<<"copy constructor called "<< endl;               //[when we are not using & then the temp call copy construction again and again in loop.]
        this->health = temp.health;
        this->level =  temp.level;
    }

    void print(){
        cout<<" health is "<< health << endl;
        cout<<" level is "<< level << endl;
    }

    int gethealth(){
        return health;
    }
    char getlevel(){
        return level;
    }
    void sethealth(int h){
        health=h;
    }
    void setlevel(char l){
        level=l;
    }

 };

 int main() {
    //default constructor
        //object created statically
        Hero tony;
        tony.print();
        
        //object created dynamicaly
        Hero *stark= new Hero;
        (*stark).print();

    //parameterised constructor
        //object created statically
        Hero Bruce(68);
        Bruce.print();
        Hero captain(100,'C');
        captain.print();

        //object created dynamicaly
        Hero *Banner=new Hero(68);
        (*Banner).print();
   
    //copy constructor
        //object created statically
        Hero thor(200,'T');
        thor.print();
        Hero loki(thor);
        loki.print();

        //object created dynamicaly
        Hero* hulk= new Hero(300,'H');
        (*hulk).print();
        Hero* sis= new Hero(*hulk);
        (*sis).print();

    //copy using assignment operator

            Hero odin(488,'n');
            odin.print();
            Hero hela=odin;
            hela.print();


    return 0;
}
*/
                        /*(4.) Destructors */
/*
 Destructor is an instance member function that is invoked automatically whenever an object is going to be destroyed.
 destructor is the last function that is going to be called before an object is destroyed.
 
 --A destructor is also a special member function like a constructor. Destructor destroys the class objects created by the constructor. 
 --Destructor has the same name as their class name preceded by a tilde (~) symbol.
 --It is not possible to define more than one destructor. 
 --The destructor is only one way to destroy the object created by the constructor. Hence destructor can-not be overloaded.
 --Destructor neither requires any argument nor returns any value.
 --It is automatically called when an object goes out of scope. 
 --Destructor release memory space occupied by the objects created by the constructor.
 --In destructor, objects are destroyed in the reverse of an object creation.
*/
/*
class Hero{
    private:
    int health;

    public:
    char level;

    Hero(){
        cout<<"constructor called "<<endl;
    }

    Hero(int health){
        this->health = health;          
    }

    Hero(int health,char level){
        this->health = health;
        this->level = level;
    }

    void print(){
        cout<<" health is "<< health << endl;
        cout<<" level is "<< level << endl;
    }

    int gethealth(){
        return health;
    }
    char getlevel(){
        return level;
    }
    void sethealth(int h){
        health=h;
    }
    void setlevel(char l){
        level=l;
    }

    //Destructor
    ~Hero(){
        cout<<"Destructor called";
    }

 };

 int main() {
    //object created statically and distructor automatically called
    cout<<"============"<<endl;
        Hero tony(54,'T');
        tony.print();
    cout<<"============"<<endl;
    //object created dynamically and distructor called manually
    cout<<"============"<<endl;
        Hero* stark = new Hero(23,'S');
        stark->print();
        delete stark;
    cout<<"============"<<endl;
 
    return 0;
}
*/
                        /*(5.) Static data members and static member function */

/*(Static data members):- are class members that are declared using static keywords.
 --To access the static data member of any class we have to define it first.
 --It is initialized before any object of this class is created, even before the main starts.
 --It is visible only within the class, but its lifetime is the entire program.
 */     
/*initialization:- datatype || classname || ::(scope resolution operator) || data member name || value*/
/*
(static member function):-
 --this keyword is not allowed because their is no object(no pointer).
 --don't need to create object
 --static function access only static members.
*/ 
/*
class Hero{
    private:
    int health;

    public:
    char level;
    static int timeToComplete;

    Hero(){
        cout<<"constructor called "<<endl;
    }

    Hero(int health){
        this->health = health;          
    }

    Hero(int health,char level){
        this->health = health;
        this->level = level;
    }

    //static member function
    static int randomsuit(){
        return timeToComplete;
    }

    void print(){
        cout<<" health is "<< health << endl;
        cout<<" level is "<< level << endl;
    }

    int gethealth(){
        return health;
    }
    char getlevel(){
        return level;
    }
    void sethealth(int h){
        health=h;
    }
    void setlevel(char l){
        level=l;
    }

 };
 int Hero::timeToComplete=49;
 int main() {
    Hero iron;
    cout<<Hero::timeToComplete<<endl;
    cout<<Hero::randomsuit()<<endl;
    cout<<iron.timeToComplete<<endl;
    cout<<iron.randomsuit()<<endl;

    Hero man;
    iron.timeToComplete=20;
    cout << iron.timeToComplete << endl;
    cout << man.timeToComplete << endl;
    cout << Hero::timeToComplete << endl;

    Hero::timeToComplete=100;
    cout<<Hero::timeToComplete<<endl;
    cout<<Hero::randomsuit()<<endl;

    return 0;
}
*/

/*Another example for static member*/
/*
class Student{
    public:
    //static member
    static int total;
    //constructor
    Student(){
        total +=1;
    }
 };

 int Student::total=0;

 int main(){

    Student s1;
    cout<< s1.total <<endl;

    Student s2;
    cout<< s2.total <<endl;

    Student s3;
    cout<< s3.total <<endl;
 }
*/

/*Another example for static function*/
/*
class Box 
 { 
	private: 
	static int length; 
	static int breadth; 
	static int height; 
	
	public:
	
	static void print() 
	{ 
		cout << "The value of the length is: " << length << endl; 
		cout << "The value of the breadth is: " << breadth << endl; 
		cout << "The value of the height is: " << height << endl; 
	}
 }; 

 // initialize the static data members 

 int Box :: length = 10; 
 int Box :: breadth = 20; 
 int Box :: height = 30; 

 int main() {
	Box b; 
	cout << "Static member function is called through Object name: \n" << endl; 
	b.print(); 
	
	cout << "\nStatic member function is called through Class name: \n" << endl; 
	Box::print(); 
	
	return 0; 
}
*/

                        /*(6.)Encapsulation */


/*basic definition:- Information hiding/data hiding. (or wrapping up data members and functions).


 Encapsulation:- The process of grouping data members and corresponding methods into a single unit is known as Encapsulation.
 It is an important part of object-oriented programming. We can create a fully encapsulated class by making all the data members private. 
 If the data members are private, it can only be accessible within the class; no other class can access that class’s data members. 
 
 Advantages of encapsulation:-
 --Encapsulation is a way to achieve data hiding because other classes will not be able to access the data through the private data members.
 --In Encapsulation, we can hide the data’s internal information, which is better for security concerns.
 --By encapsulation, we can make the class read-only. The code reusability is also an advantage of encapsulation.
 --Encapsulated code is better for unit testing.

*/
/*
class student{
    private:
    string name;
    int age;
    int height;
    public:
    int getAge(){
        return this->age;
    }
 };

 int main(){
    class first;
    cout<<"yahi encapsulation hai";
    return 0;
}
*/

                        /*(6.)Inheritance */

/*Inheritance:- The capability of a class to derive properties and characteristics from another class is called Inheritance. 
 Inheritance is one of the most important features of Object-Oriented Programming.
 Inheritance is a feature or a process in which, new classes are created from the existing classes.
 The new class created is called “derived class” or “child class” or "subclass" and the existing class is known as the “base class” or “parent class” or "super class".
 The derived class now is said to be inherited from the base class.

 Sub Class: The class that inherits properties from another class is called Subclass or Derived Class. 
 Super Class: The class whose properties are inherited by a subclass is called Base Class or Superclass. 
 
 Advantages of inheritance:-

 --The time it takes to design an application is reduced.
 --The application uses less memory.
 --The time it takes for an application to run is reduced.
 --The performance of the application has been improved (improved).
 --The code's redundancy (repetition) is decreased or eliminated, resulting in more consistent outputs and lower storage costs.
 
 (Syntax):-
 class derived_class_name : access_mode base_class_name
 {
     //body of the derived class
 };

*/
/*
class Human{
    public:
    int height;
    int weight;
    int age=767;
    
    public:
    int getAge(){
        return this->age;
    }
    void setWeight(int w){
        this->weight=w;
    }
 };

 class Male: public Human{
    public:
    string color;
    void sleep(){
        cout<<"Male sleeping"<<endl;
    }
 };

 int main(){

    Male obj1;

    obj1.setWeight(78);
    cout<<obj1.getAge()<<endl;

    cout<<obj1.height<<endl;
    cout<<obj1.weight<<endl;
    cout<<obj1.age<<endl;
    cout<<obj1.color<<endl;

    obj1.sleep();

    return 0;
}
*/
/*Access Specifiers:-
 Access specifiers are the keywords used to control the accessibility of classes, methods, and other class members.
 It also ensures what functions and properties are inherited when a class is derived from another class. 

 In C++, we have three access specifiers:-

 Public: The members that are public in the base class are derived as public in the derived class if derived publicly. These are accessible from anywhere outside the class.
 Private: Public or protected members of the base class become private members of the derived class when inherited privately. Private members are never inherited.
 Protected: The protected members cannot be accessed outside the class, but they can be inherited.
  
 the main chart:-
                    -------------------------------------------------------------------------------------
                    |                  | public derivation | private derivation | protected derivations |
                    -------------------------------------------------------------------------------------
                    | public member    | public            |  private           |  protected            |
                    -------------------------------------------------------------------------------------
                    | private member   | Not inherited     | Not inherited      |  Not inherited        |
                    -------------------------------------------------------------------------------------                    
                    | protected member | protected         |  private           |  protected            |
                    -------------------------------------------------------------------------------------                    


*/
/*
class Human{
    public:
    int height=6;
    int weight=70;
    int age=767;
    
    public:
    int getheightH(){
        return this->height;
    }
    void setWeightH(int w){
        this->weight=w;
    }
 };

 class Male: public Human{               //we can take public,protected and private
    public:
    int colour=54;
    
    void sleepM(){
        cout<<"Male sleeping"<<endl;
    }
    int getwepM(){
        return this->weight;
    }
 };

 class child: public Male{
    public:
    int babyWeight=20;
    void cryC(){
        cout<<"child crying"<<endl;
    }
    int getageC(){
        // return this->age;            // not for public to private
    }
    int getcolorC(){
        return this->colour;
    }
 };
*/
/*public to public*/
/*
 int main()
 {
    Human h1;                            
    Male m1;        
    child c1;             

    cout<<c1.babyWeight<<endl;                     // yes
    cout<<c1.getageC()<<endl;                      // yes
    cout<<c1.getcolorC()<<endl;                    // yes
    c1.cryC();                                     // yes
    cout<<c1.colour<<endl;                         // yes
    cout<<c1.getwepM()<<endl;                      // yes
    c1.sleepM();                                   // yes
    cout<<c1.weight<<endl;                         // yes
    cout<<c1.getheightH()<<endl;                   // yes

    cout<<m1.colour<<endl;                         // yes
    cout<<m1.getwepM()<<endl;                      // yes
    m1.sleepM();                                   // yes
    cout<<m1.weight<<endl;                         // yes
    cout<<m1.getheightH()<<endl;                   // yes

    cout<<h1.weight<<endl;                         // yes
    cout<<h1.getheightH()<<endl;                   // yes

    return 0;
}
*/
/*public to protected*/
/*
 int main()
 {
    Human h1;                            
    Male m1;        
    child c1;             

    cout<<c1.babyWeight<<endl;                     // yes
    cout<<c1.getageC()<<endl;                      // yes
    cout<<c1.getcolorC()<<endl;                    // yes
    c1.cryC();                                     // yes
    cout<<c1.colour<<endl;                         // yes
    cout<<c1.getwepM()<<endl;                      // yes
    c1.sleepM();                                   // yes
    // cout<<c1.weight<<endl;                         // NO
    // cout<<c1.getheightH()<<endl;                   // NO

    cout<<m1.colour<<endl;                         // yes
    cout<<m1.getwepM()<<endl;                      // yes
    m1.sleepM();                                   // yes
    // cout<<m1.weight<<endl;                         // NO
    // cout<<m1.getheightH()<<endl;                   // NO

    cout<<h1.weight<<endl;                         // yes
    cout<<h1.getheightH()<<endl;                   // yes

    return 0;
}
*/
/*public to private*/
/*
 int main()
 {
    Human h1;                            
    Male m1;        
    child c1;             

    cout<<c1.babyWeight<<endl;                     // yes
    // cout<<c1.getageC()<<endl;                      // NO
    cout<<c1.getcolorC()<<endl;                    // yes
    c1.cryC();                                     // yes
    cout<<c1.colour<<endl;                         // yes
    cout<<c1.getwepM()<<endl;                      // yes
    c1.sleepM();                                   // yes
    // cout<<c1.weight<<endl;                         // NO
    // cout<<c1.getheightH()<<endl;                   // NO

    cout<<m1.colour<<endl;                         // yes
    cout<<m1.getwepM()<<endl;                      // yes
    m1.sleepM();                                   // yes
    // cout<<m1.weight<<endl;                         // NO
    // cout<<m1.getheightH()<<endl;                   // NO

    cout<<h1.weight<<endl;                         // yes
    cout<<h1.getheightH()<<endl;                   // yes

    return 0;
}
*/
                        /*(7.) Types of Inheritance */
/*(i).Single inheritance*/
/*
 class A{
    public:
    int Apower=100;
    int Aspeed=100;
    public:
    void speak(){
        cout<<"i am speak hindi"<<endl;
    }
 };
 class B : public A{
    public:
    int Bpower=50;
    int Bspeed=50;
 };
 int main(){
    B b1;
    b1.speak();
    cout<<b1.Bpower<<endl;
    cout<<b1.Apower<<endl;
    return 0;
 }
*/
/*(ii).Multi-level inheritance*/
/*
 class A{
    public:
    int Apower=100;
    int Aspeed=100;
    public:
    void speak(){
        cout<<"i am speak hindi"<<endl;
    }
 };
 class B : public A{
    public:
    int Bpower=50;
    int Bspeed=50;
 };
 class C : public B{
    public:
    int Cpower=25;
    int Cspeed=25;
 };
 class D : public C{
    public:
    int Dpower=12;
    int Dspeed=12;
 };
 int main(){
    D d1;
    d1.speak();
    cout<<d1.Apower<<endl;
    cout<<d1.Cpower<<endl;
    return 0;
 }
*/
/*(iii).Multiple inheritance*/
/*
 class A{
    public:
    int Apower=100;
    int Aspeed=100;
    public:
    void speakA(){
        cout<<"i am speak hindi"<<endl;
    }
 };
 class B{
    public:
    int Bpower=90;
    int Bspeed=90;
    public:
    void speakB(){
        cout<<"i am speak english"<<endl;
    }
 };
 class C : public A,public B{
    public:
    int Cpower=50;
    int Cspeed=50;
 };
 int main(){
    C c1;
    c1.speakA();
    c1.speakB();
    cout<<c1.Bpower<<endl;
    cout<<c1.Apower<<endl;
    cout<<c1.Cpower<<endl;
    return 0;
 }
*/
/*(iv).Hierarchical inheritance*/
/*
 class A{
    public:
    int Apower=100;
    int Aspeed=100;
    public:
    void speakA(){
        cout<<"i am speak hindi"<<endl;
    }
 };
 class B : public A{
    public:
    int Bpower=90;
    int Bspeed=90;
    public:
    void speakB(){
        cout<<"i am speak hindiB"<<endl;
    }
 };
 class C : public A{
    public:
    int Cpower=90;
    int Cspeed=90;
     void speakC(){
        cout<<"i am speak hindiC"<<endl;
    }
 };
  class D : public B{
    public:
    int Dpower=50;
    int Dspeed=50;
 };
 class E : public B{
    public:
    int Epower=50;
    int Espeed=50;
 };
   class F : public C{
    public:
    int Fpower=50;
    int Fspeed=50;
 };
 class G : public C{
    public:
    int Gpower=50;
    int Gspeed=50;
 };
 int main(){
    D d1;
    F f1;
    B b1;
    G g1;
    d1.speakA();
    d1.speakB();
    f1.speakC();
    f1.speakA();
    cout<<b1.Apower<<endl;
    cout<<d1.Bpower<<endl;
    cout<<g1.Cpower<<endl;
    return 0;
 }
*/
/*(v).Hybrid inheritance*/
/*
 class A{
    public:
    int Apower=100;
    int Aspeed=100;
    public:
    void speakA(){
        cout<<"i am speak hindiA"<<endl;
    }
 };
 class F{
    public:
    int Fpower=100;
    int Fspeed=100;
    public:
    void speakF(){
        cout<<"i am speak hindiF"<<endl;
    }
 };
 class C : public A,public F{
    public:
    int Cpower=90;
    int Cspeed=90;
    public:
    void speakC(){
        cout<<"i am speak hindiC"<<endl;
    }
 };
 class B : public A{
    public:
    int Bpower=90;
    int Bspeed=90;
     void speakB(){
        cout<<"i am speak hindiB"<<endl;
    }
 };
  class D : public B{
    public:
    int Dpower=50;
    int Dspeed=50;
 };
 class E : public B{
    public:
    int Epower=50;
    int Espeed=50;
 };
 int main(){
    D d1;
    E e1;
    B b1;
    C c1;

    d1.speakA();
    d1.speakB();
    e1.speakA();
    b1.speakA();
    c1.speakF();
    c1.speakC();
    cout<<d1.Apower<<endl;
    cout<<d1.Bpower<<endl;
    cout<<c1.Fpower<<endl;
    return 0;
 }
*/
/*Inheritance Ambiguity:- 
The ambiguity problem arises when a single class is derived from two or more parent class having the same-named member functions. 
the ambiguity is shown by the derived class object which involves one of the same-named functions.
*/
/*
 class A{
    public:
    int Apower=100;
    int Aspeed=100;
    public:
    void speak(){
        cout<<"i am speak hindi"<<endl;
    }
 };
 class B{
    public:
    int Bpower=90;
    int Bspeed=90;
    public:
    void speak(){
        cout<<"i am speak english"<<endl;
    }
 };
 class C : public A,public B{
    public:
    int Cpower=50;
    int Cspeed=50;
 };
 int main(){
    C c1;
    c1.A::speak();
    c1.B::speak();
    return 0;
 }
*/
                        /*(7.) Polymorphism */
/*
 The word “polymorphism” means having many forms. In simple words, we can define polymorphism as the ability of a message to be displayed in more than one form. 
 A real-life example of polymorphism is a person who at the same time can have different characteristics. 
 A man at the same time is a father, a husband, and an employee. So the same person exhibits different behavior in different situations. 
 This is called polymorphism. Polymorphism is considered one of the important features of Object-Oriented Programming.

 Types of Polymorphism:-
 (1).Compile-time Polymorphism
 (2).Runtime Polymorphism

 (1.)Compile time polymorphism :- 
 Compile time polymorphism is also known as static polymorphism. 
 This type of polymorphism can be achieved through function overloading or operator overloading.

    (a). Function overloading:- 
    When there are multiple functions in a class with the same name but different parameters, these functions are overloaded. 
    The main advantage of function overloading is it increases the readability of the program. 
    Functions can be overloaded by using different numbers of arguments and by using different types of arguments.

        (i.) Function overloading with different numbers of arguments:-
        (ii.) Function overloading with different types of arguments:-
                Default Arguments: A default argument is a value provided in a function declaration automatically assigned by the compiler 
                if the function’s caller doesn’t provide a value for the argument with a default value. However, 
                if arguments are passed while calling the function, the default arguments are ignored
    
    (b). Operator Overloading:- 
    C++ also provides options to overload operators. For example, we can make the operator (‘+’) for the string class to concatenate two strings. 
    We know that this is the addition operator whose task is to add two operands. 
    A single operator, ‘+,’ when placed between integer operands, adds them and concatenates them when placed between string operands.
    
    (list of operators that can be overloaded in C++):-[+,-,*,/,%,^,&,|,~,!,=,<,>,<=,>=,++,--,<<,>>,==,!=,&&,||,+=,-=,/=,%=,^=,&=,|=,*=,<<=,>>=,[],(),->,->*,new,new[],delete,delete[],,]
    (List of operators that cannot be  overloaded in C++):-[ :: , .* , . , ?:]

    (Points to remember while overloading an operator):-
    --It can be used only for user-defined operators(objects, structures) but cannot be used for in-built operators(int, char, float, etc.).    
    --Operators = and & are already overloaded in C++, so we can avoid overloading them.     
    --Precedence and associativity of operators remain intact.
 
 (2.).Runtime polymorphism:-
 Runtime polymorphism is also known as dynamic polymorphism. Method overriding is a way to implement runtime polymorphism.

    (a.) Method overriding:-
    Method overriding is a feature that allows you to redefine the parent class method in the child class based on its requirement. 
    In other words, whatever methods the parent class has by default are available in the child class. 
    But, sometimes, a child class may not be satisfied with parent class method implementation. 
    The child class is allowed to redefine that method based on its requirement. This process is called method overriding. 
 
    (Rules for method overriding):-
    --The method of the parent class and the method of the child class must have the same name.
    --The method of the parent class and the method of the child class must have the same parameters.
    --It is possible through inheritance only.
*/
/*(i.) Compile time polymorphism function overloading with different numbers of arguments example*/
/*
 class A{
    public:
    void sayHello(){
        cout<<"Hello gaganshu"<<endl;
    }
    void sayHello(string name){
        cout<<"Hello "<< name<<endl;
    }
    void sayHello(string name,int rollno){
        cout<<"Hello "<<name<<" roll no. "<<rollno<<endl;
    }
 };
 int main(){
    A obj;
    obj.sayHello();
    obj.sayHello("gaganshu");
    obj.sayHello("gaganshu",16);
 } 
*/
/*(ii.) Compile time polymorphism function overloading with different types of arguments example*/
/*
 class A{
    public:
    void say(){
        cout<<"Hello gaganshu"<<endl;
    }
    void say(int rollno){
        cout<<"Roll no. "<< rollno<<endl;
    }
    void say(string name){
        cout<<"Hello "<< name << endl;
    }
    void say(char x){
        cout<<"my grade is "<< x <<endl;
    }
 };

 class B{
    public:
    int add(int x=0,int y=0,int z=0,int o=0){
        return x+y+z+o;
    }
 };
 int main(){
    A obj1;
    obj1.say();
    obj1.say(45);
    obj1.say("gaganshu");
    obj1.say("A");

    B obj2;
    cout<<obj2.add() << endl;
    cout<<obj2.add(23) << endl;
    cout<<obj2.add(2,42) << endl;
    cout<<obj2.add(7,2,23) << endl;
    cout<<obj2.add(43,54,34,23) << endl;
    return 0;
 } 
*/
/*Compile time  polymorphism operator overloading example*/
/*
 class A{
    public:
    int a;
    int b;

    public:
    int add(){
        return a+b;
    }

    void operator+ (A &obj){                      //Syntax:- returnType operator+ (input)
        int value1 = this->a;
        int value2 = obj.a;
        cout<<"output "<< value2-value1 <<endl;
    }
 };

 class B{
    public:
    int c=67;
    int d; 
     
    public:
    void operator() (){
        cout<<"i am bracket and i am a "<< this->c << endl;
    } 
 };

 class C{
    public:
    int e;
    int f;
    public:
    void operator* (C &obj){
        int val1=this->e;
        int val2= obj.e;
         cout <<"i am multiply operator and answer is " << val1 * val2 << endl;
    }
 };

 int main(){
    A obj1,obj2;
    obj1.a=3;
    obj2.a=7;
    obj1 + obj2 ;

    B obj;
    obj();

    C obj3,obj4 ;
    obj3.e=6;
    obj4.e=9;
    obj3 * obj4 ;

    return 0;
 }
*/
/*Runtime polymorphism method overriding example*/
/*
 class parent{
    public:
    void speak(){
        cout<<"i am parent"<<endl;
    }
 };
 class child1:public parent{
    public:
    void speak(){
        cout<<"i am child 1"<<endl;
    }
 };
 class child2:public parent{
    public:
    void speak(){
        cout<<"i am child 2"<<endl;
    }
 };

 int main(){
    parent p;
    child1 c1;
    child2 c2;
    p.speak();
    c1.speak();
    c2.speak();
    return 0;
 }
*/ 
                        /*(6.)Abstraction */
/*                        
 Abstraction:-
 Data abstraction is one of the most essential and important features of object-oriented programming in C++.
 Abstraction means displaying only essential information and hiding the details. 
 Data abstraction refers to providing only necessary information about the outside world’s data, hiding the background details or implementation. 
 ===============
 Let’s understand abstraction with a real-life example:-
 Real-life example: When you send an email to someone, you just click send, and you get the success message; what happens when you click send, 
 how data is transmitted over the network to the recipient is hidden from you (because it is irrelevant to you).
 ===============
 Abstraction using Classes:--
 We can implement Abstraction in C++ using classes. The class helps us to group data members and member functions using available access specifiers. 
 A Class can decide which data members will be visible to the outside world and which is not.
 ===============
 Abstraction in Header files:--
 One more type of abstraction in C++ can be header files. For example, the pow() method present in the math.h header file. 
 To calculate the power of a number, we can simply call the function pow() present in the math.h header file and pass the numbers as arguments 
 without knowing the underlying algorithm according to which the function is calculating the power of numbers.
 ===============
 Abstraction using Access specifier:--
 Access specifiers are the main pillar of implementing abstraction in C++. We can use access specifiers to enforce restrictions on class members. 
 For example:-
 
 --Members declared as public in a class can be accessed from anywhere in the program.
 --Members declared as private in a class can be accessed only from within the class. They are not allowed to be accessed from any part of code outside the class.
 --Members declared as protected in a class are a special kind of access specifier; it works similarly to private and can access it.
 ===============
 
 Advantages Of Abstraction:-
 --Only you can make changes to your data or function, and no one else can.
 --It makes the application secure by not allowing anyone else to see the background details.
 --Increases the reusability of the code.
 --Avoids duplication of your code.
*/