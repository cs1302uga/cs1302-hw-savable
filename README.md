# Basic Interfaces

Reminder of deadlines. Then jump right in to code.

## Introduction

Interfaces tutorial assigned for last night. How did that go?

Most mistakes I'm seeing are very minor. Doing a great job overall. If a bug occurs, remember to add print statements to help you follow
the flow of control of the application. Print "In the loop", print variables, etc.

Discuss the project?

## TODO

1. Do the poll on eLC.

1. Define interface and general terminology while going over the poll.

   * In its simplest form, a Java interface is a reference type composed of abstract methods and constants. An
     abstract method is a non-static method without an implementation (body). Constants are variables (static or not)
     that are declared using the final keyword.

   * Interfaces are used to specify that a type **can do** a set of things specified by its abstract methods and constants. An
     interface serves as a **contract** for the classes that claim to implement the interface. Multiple classes can implement
     the same interface, each providing their own implementation of the contracted functionality. For this reason, it is
     important that the documentation for an interface describe what a method does and not necessarily how it should do it.
     Such documentation is usually written using Javadoc comments in the interface.

1. In office hours, a student asked "why do we need interfaces?". I answered by drawing the `Athlete` UML diagram. This description
   really helped the student so I ended up doing it at the start of class. The basic idea was:
   * The `Athlete` interface had three methods: `compete`, `train`, `rest`.
   * I drew the UML for `Athlete` and two implementing classes and discussed how the methods were only implemented in the implementing
     classes. This made sense intuitively to the student (you can't define `compete` at the `Athlete` level).
   * Then, we wrote a method called `doRoutine` that looked like this:

   ```java
   public static void doRoutine(TrackAthlete a) {
       while (true) {
           a.train();
           a.rest();
           a.compete();
       } // while
   } // doRoutine
   ```
   * Then, we discussed what would be needed to have a `doRoutine` method that works on a `FootballPlayer`, for example. They said we would
     have to copy/paste the method. Then, we discussed how using the interface type allows us to have only one method.
   * Finally, we showed what a call to this would look like from a `main` method.
   * This flowed nicely in the class after doing the poll. They already understood compatibility at a basic level.
 
1. Before class: Download the code for the `cs1302-interfaces` tutorial. Here is the download command:

   ```
   $ curl -s -L https://git.io/fhgce | bash
   ```
   
   * In `StyleDriver.java`, remove the `test` method and replace the body of the `main` method with:

     ```java
     Fancy f0 = null;
     f0 = new Fancy("Hello");
     
     System.out.println(f0);
     f0.style();
     System.out.println(f0);
     f0.unstyle();
     System.out.println(f0);
     
     SuperFancy f1 = new SuperFancy("hello, fancier world!");
     ```

1. Use a UML diagram to review the `Styleable` hierarchy. 
   Show the methods in each class and how they connect with the interface.

1. Work through some code in the `StyleDriver` class to demonstrate the types of things 
   you can do with `Styleable` references and objects then talk about compatibility.

1. Walk through some compatibility examples:
   
   ```
   Fancy f0 = new Fancy("Hello");
   ```
   
   ```
   Fancy +------+             /-----------------------------------\
      f0 | x32--|------------>| title -> "Hello"; styled -> false |
         +------+             \-----------------------------------/
   ```
   
   **Once the object is created, its type never changes!** However, it's reference can!
   
   ```
   Styleable s0 = f0;
   ```
   
   ```
    Fancy +------+               /-----------------------------------\
       f0 | x32--|-------------->| title -> "Hello"; styled -> false |
          +------+          /    \-----------------------------------/
                           /
    Styleable +------+    /
           s0 | x32--|---/
              +------+
   ```
   
   **The object type never changes, but its reference is one type in `f0` (`Fancy`) and
   another type in `s0` (`Styleable`).**
   
   ----
   
   Passing an object reference to a method parameter by value is the same as assigning that
   reference to the parameter:
   
   ```java
   private void print(Styleable object) {
       System.out.println(object.toString());
       // Ask: could we do this:
       // System.out.println(object.getAbout());
       // I used this opportunity to discuss polymorphism (object takes many forms) and how the variable determines what you can do and the object
       // determines how it is done (code that runs).
   } // print
   ```
   
   ```java
   Fancy f0 = new Fancy("Hello");
   print(f0);
   ```
   
   ```
    Fancy +------+              /-----------------------------------\
       f0 | x32--|------------->| title -> "Hello"; styled -> false |
          +------+         /    \-----------------------------------/
                          /
    Styleable +------+   /      
       object | x32--|--/       
              +------+          
   ```
   
   **Brad: got here after a Thursday class period.**
   
   1. I didn't compile yesterday since this was mostly high level discussion. Make a compile script and use it in class to finish the lesson. 
      This will speed up the discussion and motivate them to read the scripts tutorial (assigned the following night).
   
   1. Instead of giving them the method below, maybe ask them to write it with their neighbors.
      * Put the UML diagram of `Styleable`, `Fancy`, and `SuperFancy` on the board.
      * Have them take five minutes and write a method called `getStyleable`.
         * The method takes two `String` parameters: the first represents how the caller is feeling the other contains a message. 
         * If the caller is feeling "fancy" (any capitalization), the method returns a new `Fancy` object 
         * If the caller is feeling "super fancy" (any capitalization), the method returns a new `Super Fancy` object 
         * The returned object should be styled and should contain the given message.
   ----
   
   Something similar happens when an object reference is the return value of a method:
   
   ```java
   private static Styleable getStyleable(String feeling, String message) {
       Styleable f0 = null;
       // if i'm feeling fancy...
       if (feeling.equalsIgnoreCase("fancy") {
          f0 = new Fancy(message);
          f0.style();
       } else if (feeling.equalsIgnoreCase("super fancy") {
          f0 = new SuperFancy(message);
          f0.style();
       } // if
       return f0; // think: Styleable ret = f0
   } // getSavable
   ```
   
   ```java
   Styleable object = getStyleable(); // think: Styleable object = ret = tb0
   ```
   
   ```
    Fancy +------+              /-----------------------------------\
       f0 | x32--|------------->| title -> "Hello"; styled -> false |
          +------+         /    \-----------------------------------/
                          /
    Styleable +------+   /      
       object | x32--|--/       
              +------+            
   ```
   
   **Remember, an object's type never changes once its been constructed.**

1. Getting a class to implement an interface is a **three-step process**:
   1. **Sign the contract** using an `implements` clause in the class declaration.
   2. **Meet the minimum requirements** by overloading the abstract methods defined in the interface.
   3. **Meet the full requirements** by making sure the overloads are documented and do what the interface documentation says they should do.
   
1. Add another class that implements `Styleable`. One that changes the color using ANSI codes.
   * https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
   
   To do this, start with an escape sequence instead of "*** " and a reset sequence at the end.
   ```java
       /**
     * Returns a {@code String} representation of this {@code Fancy}
     * object, consistent with {@link cs1302.interfaces.contract.Styleable}.
     * @return the {@code String} value of this object
     */
    public String toString() {
        String content;
        if (styled) {
            content = "*** " + message + " ***";
        } else {
            content = message;
        } // if
        return String.format("Fancy(%s)", content);
    } // toString
    ```
    
1. Add a `getDescription` method that returns a `String` to the `Styleable` interface. Discuss 
   how this will impact the implementing classes. Those have to be updated as well.
   * For Fancy, this might return "Fancy: with asterisks"
   * For SuperFancy, this might return "Super Fancy: alternating capitalizations"
   * For FancyColor, this might return "Fancy Color: colored text in the terminal. Wait, What?!?"
   
1. Add a method in the driver program to show the benefits of using `Styleable` as the type. Name the method
   `void previewStyle(Styleable style)` -- if we are short on time, we can just modify the `print` method we
   wrote earlier. This method should:
   * call the `getDescription` method
   * output a styled, hard-coded sentence "the quick brown fox jumps over the lazy dawg".
   * Talk about compatibility with the interface type.   
   * This is an example of polymorphism
   * Maybe use a single `Styleable` reference as the formal parameter to start then modify to be an array.
   
<!--
1. Do basic compilation runthrough and checkstyle/javadoc discussion using `Styleable` example?
   * Run checkstyle
   * Generate Javadoc website incorrectly. Show the broken link then fix it.
   * Show the Javadoc website side-by-side with the source code.
-->
1. **DISCUSSION:** Show a UML diagram with two different/disparate classes (e.g., `GameProgress` and `TextBook`)
   where both classes have two common instance methods (e.g., `save` and `getName` -- see below), then have a 
   discussion with the students:
   
   * Suppose we have several objects of each class. What are some things you might want to be able to do with 
     either or both? 
   * Can an interface help us out in any way?
   * What might that interface looks like? 
     - one interface with all the methods -- discuss pros/cons
     - two interfaces, one for each method (e.g., `Saveable` for `save` and `MachineNameable` for `getMachineName`) -- discuss pros/cons
     - one interface with both methods (e.g., `Saveable` has both `save` and `getMachineName`) -- discuss pros/cons
     - here are some examples/ideas -- don't need to show the students these:
     
       ```java
       // TWO INTERFACES
       
       public interface Saveable {
           public void save(String filename) throws FileNotFoundException;
       } // Saveable
       
       public interface MachineNameable {
       
           /**
            * Return the <em>machine name</em> string for this object. A valid <em>machine name</em> may only
            * contain lowercase alphanumeric characters and underscores -- whitespace is not allowed.
            * 
            * @return the <em>machine name</em> for this object
            */
           public String getMachineName();
           
       } // MachineNameable
       
       public class GameProgress implements MachineNameable, Saveable {

           private String playerName; // assume no newlines or carriage returns
           private int level;
           private int score;
           
           ...
           
           public String getMachineName() {
               return playerName.strip().trim().replaceAll(" ", "_");
           } // getMachineName
           
           public void save(String filename) throws FileNotFoundException {
               PrintWriter fileOut = new PrintWriter(filename);
               fileOut.println("machineName: " + getMachineName());
               fileOut.println("playerName: " + playerName);
               fileOut.println("level: " + level);
               fileOut.println("score: " + score);
           } // save
           
       } // GameProgress
       
       public class Driver {
       
           public static void saveAll(Saveable[] objects) {
               String time = Long.toString(System.currentTimeMillis());
               for (Saveable obj: objects) {
                   String filename = time + ".sav";
                   obj.save(filename)
               } // for
           } // saveAll
       
           public static void main(String[] args) {
               ....
           } // main
       
       } // Driver
       ```
       
       ```java
       // ONE INTERFACE
       
       public interface Saveable {
       
           public void save(String filename) throws FileNotFoundException;

           /**
            * Return the <em>machine name</em> string for this object. A valid <em>machine name</em> may only
            * contain lowercase alphanumeric characters and underscores -- whitespace is not allowed.
            * 
            * @return the <em>machine name</em> for this object
            */
           public String getName();
           
       } // MachineNameable
       
       public class GameProgress implements MachineNameable, Saveable {

           private String playerName; // assume no newlines or carriage returns
           private int level;
           private int score;
           
           ...
           
           public String getMachineName() {
               return playerName.strip().trim().replaceAll(" ", "_");
           } // getMachineName
           
           public void save(String filename) throws FileNotFoundException {
               PrintWriter fileOut = new PrintWriter(filename);
               fileOut.println("playerName: " + playerName);
               fileOut.println("level: " + level);
               fileOut.println("score: " + score);
           } // save
           
       } // GameProgress
       
       public class Driver {
       
           public static void saveAll(Saveable[] objects) {
               String time = Long.toString(System.currentTimeMillis());
               for (Saveable obj: objects) {
                   String machineName = obj.getMachineName();
                   String filename = time + "_" + machineName + ".sav";
                   obj.save(filename)
               } // for
           } // saveAll
       
           public static void main(String[] args) {
               ....
           } // main
       
       } // Driver
       ```
   
**Bonus Content (if time):**
   
1. Discuss `@Override`. Why do we have it on the `style` and `unstyle` methods? This is not discussed in the tutorial or the homework (HW02).
   We could consider adding a short paragraph to the homework assignment.

1. Discuss `{@inheritDoc}`. This is in the project description (I believe).
   * What does `{@inheritDoc}` do?
