# hw03 Interfaces (ADTs)

![Approved for: Spring 2023](https://img.shields.io/badge/Approved%20for-Spring%202023-magenta)

This homework is designed to get you acquainted with Interfaces in Java.
When a seasoned programmer or potential employer asks you if you know 
Object-Oriented Programming (OOP), they do not mean, "do you know classes and objects?" 
Instead, they mean, "do you know the pillars of OOP?" The pillars of OOP are interfaces, 
inheritance, and polymorphism. In this exercise, we continue the exploration of interfaces 
and interface-based polymorphism. 

## Prerequisite Knowledge

* A basic understanding of creating and implementing interfaces in Java.
* [CSCI 1302 Interfaces Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/alsi/interfaces/interfaces.md)

## Course-Specific Learning Outcomes

* **LO2.e:** (Partial) Utilize existing generic methods, interfaces, and classes in a software solution.
* **LO3.b:** Create class, interface, method, and inline documentation that satisfies a 
set of requirements.
* **LO3.c:** Generate user-facing API documentation for a software solution.
* **L04.b:** Utilize interface-based polymorphism in a software solution.
 
## Questions

In your notes, clearly answer the questions in the following exercise steps. All instructions assume that you are 
logged into the Odin server.

**NOTE:** For each step, please provide in your notes the full command that you typed to make the related 
action happen along with an explanation of why that command worked. Some commands require multiple options. 
It is important to not only recall what you typed but also why you typed each of them. If context is necessary 
(e.g., the command depends on your present working directory), then please note that context as well.
You won't need to submit your notes in your final submission. However, if done properly, your exercise notes 
will serve as a helpful study guide for the exam.

## Exercise Steps

### Checkpoint 1 Steps - Getting Started

1. Use Git to clone the repository for this exercise onto Odin into a subdirectory called `cs1302-savable`:

   ```
   $ git clone https://github.com/cs1302uga/cs1302-savable.git
   ```

1. Generate the API documentation website for all of the code in the `cs1302` package. 
   Host the documentation on Odin using `cs1302-savable-doc` as the name for your symbolic link.
   What is the URL to your hosted website?
   
1. Using the API documentation website you generated in the last step, look at the documentation for
   the class files provided in the starter code. For each Java file, fill out a row in a table similar to the 
   following in your notes:

   **Note:** If a class is not an interface and does not implement an interface, write `NA` in the second
   column. Also, the "Depends On" column should list any Java types in the `cs1302.hw03` package that the file
   is dependent upon. 

   | Name of the Java file | Interface or Implementing Class? | Fully Qualified Name (FQN) | Depends On |
   |-----------------------|----------------------------------|----------------------------|------------|
   |-----------------------|----------------------------------|----------------------------|------------|
   |-----------------------|----------------------------------|----------------------------|------------|
   |-----------------------|----------------------------------|----------------------------|------------|
   |-----------------------|----------------------------------|----------------------------|------------|

1. Read through the Javadoc comments for the `cs1302.hw03.contract.Savable` interface on the API website you generated or in the source
   code. Make a note of the method(s) contained in the interface. You may find it helpful to write the signature(s) in your notes.

1. Look at the `save` method in the `GameProgress.java` file. Compare the Javadoc comment for the
   method in that file to the documentation listed for that method in the API documentation
   website. Notice that the Javadoc website includes the comment from the interface as well as the additional comment on the `save` method in `GameProgress`. 
   The Javadoc comment in the method shows how you can inherit documentation from
   the interface your class implements.

1. Run the given code through `checkstyle` using the `check1302` command and fix any errors that it gives.
   Remember to use the [1302 Style Guide](https://github.com/cs1302uga/cs1302-styleguide) as a reference
   for the various types of errors that may pop up.
   
1. Before moving on, we highly recommend drawing out the UML diagram for the given classes to better understand their relationships. 
We also highly recommend and creating a 
   [compile script](https://github.com/cs1302uga/cs1302-tutorials/blob/alsi/scripts/scripts.md) for 
   quick and easy compilation.
   
<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-1-success?style=for-the-badge)

<hr/>

1. Take a close look at the source code in `GameProgress.java`. Notice that the class
has two instance variables and how the `save` method writes these instance variables to the file passed into the `save` method.

1. Now, take a look at the `Driver.java` file in the `cs1302.hw03` package. 
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
