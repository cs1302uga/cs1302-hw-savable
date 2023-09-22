# hw03 Interfaces (ADTs)

![Approved for: Fall 2023](https://img.shields.io/badge/Approved%20for-Fall%202023-green)

When a seasoned programmer or potential employer asks you if you know
Object-Oriented Programming (OOP), they are NOT asking, "do you know
classes and objects?" Instead, what they are really asking is, "do
you know how to apply the pillars of OOP?"  The pillars of OOP are:
_encapsulation_, _abstraction_ / _interfaces_, _inheritance_, and
_polymorphism_. **This homework is designed to help you understand
interfaces and interface-based polymorphism in Java.**

## Prerequisite Knowledge

* A basic understanding of creating and implementing interfaces in Java.
* [CSCI 1302 Interfaces Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/alsi/interfaces/interfaces.md)

## Course-Specific Learning Outcomes

* **LO2.e:** (Partial) Utilize existing generic methods, interfaces,
  and classes in a software solution.
* **LO3.b:** Create class, interface, method, and inline documentation
  that satisfies a set of requirements.
* **LO3.c:** Generate user-facing API documentation for a software solution.
* **LO4.b:** Utilize interface-based polymorphism in a software solution.

## Questions

In your notes, clearly answer the questions in the following exercise
steps. All instructions assume that you are logged into the Odin
server.

**NOTE:** For each step, please provide in your notes the full command
that you typed to make the related action happen along with an
explanation of why that command worked. Some commands require multiple
options.  It is important to not only recall what you typed but also
why you typed each of them. If context is necessary (e.g., the command
depends on your present working directory), then please note that
context as well.  You won't need to submit your notes in your final
submission. However, if done properly, your exercise notes will serve
as a helpful study guide for the exam.

## Exercise Steps

### Checkpoint 1 Steps - Getting Started

1. Use Git to clone the repository for this exercise onto Odin into a
   subdirectory called `cs1302-hw-savable`:

   ```
   $ git clone https://github.com/cs1302uga/cs1302-hw-savable.git
   ```

1. Generate the API documentation website for the `cs1302` package and
   sub-packages. Host the documentation on Odin using
   `cs1302-hw-savable-doc` as the name for your symbolic link.
   **What is the URL to your hosted website?**

1. In your browser of choice, navigate to the API documentation
   website you generated in the previous step and click on the
   **TREE** link at the top of the page. This will show you the
   hierarchy of the classes and the interface included in the starter
   code. Look at the documentation for the three class files
   (`Driver`, `GameProgress` and `TextBook`) and the interface
   (`Savable`) provided in the starter code (you should ignore the
   `java.lang.Object` class for now).

   1. **Create a copy of the table below in your notes:**

      | FQN                           | Keyword | Implements | Dependencies |
      |-------------------------------|---------|------------|--------------|
      | `cs1302.hw.contract.Savable`  |---------|------------|--------------|
      | `cs1302.hw.impl.TextBook`     |---------|------------|--------------|
      | `cs1302.hw.impl.GameProgress` |---------|------------|--------------|
      | `cs1302.hw.Driver`            |---------|------------|--------------|

   1. Each row should include information about the reference type
      named in the FQN column. With that in mind, **fill in the blanks
      according to the following column descriptions**. Use the API
      website you created to get the information that you need:

      * FQN - the fully qualified name of a reference type (e.g., the
        name of a class, interface, or enum);

      * Keyword - the keyword used to declare the type (e.g., `class`,
        `interface`, or `enum`);

      * Implements - the list of interfaces from the FQN column that
        the type implements (use NA if the type itself is an interface
        or if it's a class that does not implement any interfaces);

      * Dependencies - the list of other reference types from the FQN
        column that this type depends on.

      **NOTE:** If a class implements an interface, then the
      interface name should be listed in Implements column and
      the Dependencies column. If a class uses an interface without
      implementing it, then the interface name should only be
      listed in the Dependencies column.

1. Read the Javadoc comments for the `cs1302.hw.contract.Savable`
   interface, either using the API website that you generated or by
   looking inside `Savable.java`.  As you do this, keep in mind the
   names of the abstract methods declared in the interface — the
   classes that implement `Savable` are contractually obligated to
   provide implementations (i.e., method definitions with bodies) for
   all of those abstract methods.

1. The `GameProgress` class already properly implements the `Savable`
   interface. For this step, rearrange what is on your screen so that
   you can see the source code in `GameProgress.java` and its page
   on the API website at the same time. Once you can see both:

   1. Look at the Javadoc comment above the `save` method in the
      `GameProgress.java` file.

   1. Compare the Javadoc comment in the `.java` file to the
      documentation shown for that method on the API documentation
      website.

   1. Notice that the Javadoc website includes the comment from the
      interface as well as the additional comment above the `save`
      method in `GameProgress.java`.

   1. The Javadoc comment in the method demonstrates how you can
      inherit documentation from the interface your class
      implements. The `@inheritDoc` tag pulls the documentation from
      the `save` method written in the `Savable` interface.

1. Draw out the
   [UML diagram](https://github.com/cs1302uga/cs1302-tutorials/blob/alsi/uml/uml.md)
   for the given classes and interface to better understand their
   relationships.

1. Create a single
   [script](https://github.com/cs1302uga/cs1302-tutorials/blob/alsi/scripts/scripts.md)
   that compiles each file using a separate `javac` command. Your script
   should be located directly in your `cs1302-hw-savable` directory. You will
   need to take care when ordering the commands since dependencies
   exists between some of the files. We recommend using the shebang below so
   that your script prints out what it's doing and exits early if
   a command fails:

   ```bash
   #!/bin/bash -ex
   ```

   Once your script is setup correctly, you can run it to recompile
   everything instead of typing the compilation commands again or finding
   them in your shell history!

1. Make sure that your script works properly before continuing to the
   next checkpoint. You can check this by running `tree bin` and
   comparing its output to the expected output below:

   ```
   bin
   └── cs1302
       └── hw
           ├── contract
           │   └── Savable.class
           ├── Driver.class
           └── impl
               ├── GameProgress.class
               └── TextBook.class
   ```

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-1-success?style=for-the-badge)

<hr/>

### Checkpoint 2 Steps

1. Take a close look at the source code in `GameProgress.java`. Notice
   that the class has two instance variables (`score` and `level`) and
   that the `save` method writes (saves) these instance variables to
   the file passed into the `save` method as a parameter. The Javadoc
   comment above the `save` method describes how the instance
   variables will be written to the file.

   **NOTE:** `PrintWriter` objects allow you to print data to a file
   using method names that are similar (in name) to the methods you
   are used to using to print data to the screen. In the `save`
   method, we create a `PrintWriter` object and then use `println` to
   print variables to the file that's passed in as a parameter.

1. Now, take a look at the `Driver.java` file in the `cs1302.hw`
   package. In the `main` method you will see instructions to accomplish
   the following tasks:
   1. Create two `GameProgress` objects and reference them with 
      `GameProgress` variables named `game1` and `game2`.
   1. Write the instance variables of the object reference by
      `game1` to a file called `progressInfo.txt` using the
      `writeToFile` method of the `Driver` class.
   1. Add `game1` and `game2` to an array called `gpArray`.
   1. Write the contents of both `GameProgress` objects to
      two separate files that start with `progress` using
      the `writeAllToFile` method of the `Driver` class.
   1. You can ignore the rest of the `main` method for now.

1. Before you run the code, take a minute to write down what
   you expect to happen after the calls to `writeToFile` and
   `writeAllToFile` are executed. Ignore any code below the
   call to `writeAllToFile` for now. That code involves the
   `TextBook` class which we aren't worried about for now.

1. Modify the script that you created in the previous checkpoint
   to include the `java` command to run `cs1302.hw.Driver`
   after all of the `javac` commands. Since the `Driver` program
   is expected to create some files in current directory, add
   the `ls -lh` command to the script both before and after the 
   `java` command to make it easier to see if the program works 
   as intended.

1. Run your modified script to recompile the source code, list the
   files in the current directory, run the `Driver`, then list
   files in the current directory again — all in a single command!

   You should now see three new files named `progressInfo.txt`, 
   `progress0.txt` and `progress1.txt` that contain the instance 
   variables for the two `GameProgess` objects created by `Driver`. 
   Look inside them to confirm this. Cool, huh?!? Note that two of the
   files will contain the same data. Take a look at the code to make
   sure you understand why this happened.

   **NOTE:** You can add the `rm` command(s) to delete the `.txt` files 
   that were just created. If you want to do this, add the appropriate
   `rm` command(s) before the first `ls -lh` command in your script 
   so that they never appear in your script's output before the `Driver` 
   is run.

1. Now, modify the `TextBook.java` file so that it properly implements
   the `Savable` interface. Please note that you are adding a dependency
   to `TextBook.java`. It is now dependent on `Savable`. You may have to 
   change how you compile `TextBook.java` and you may need to add an 
   import statement for `Savable` if it is in a different package.
   You will also need to add a `save` method that
   works similarly to the `save` method in `GameProgress`. However,
   your `save` method should write the instance variables of the
   calling object (of type `TextBook`) to a file. The format for these
   files should be:
   
   ```
   TextBook:
   "TITLE" is published by PUBLISHER
   ```
   
   Where TITLE and PUBLISHER are replaced by the instance variables
   of the `TextBook` class, `title` and `publisher`. The first line
   containing "TextBook:" should be there regardless of the values
   of the instance variables.
   
1. Remember to provide an appropriate Javadoc comment above the `save`
   method in `TextBook` outlining the format of the file the method will 
   create. You can use the comment in `GameProgress` as a template.

1. Use your compile script to recompile your code and run `check1302`. At this
   point, you shouldn't see any additional `.txt` files created. We will
   update the driver program to write `TextBook` objects in the next
   checkpoint.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-2-success?style=for-the-badge)

<hr/>

### Checkpoint 3 Steps

1. Modify the `writeToFile` method in `Driver.java` file so that it
   also accepts `TextBook` references as input. **Note:** You should
   not create any new methods or add new parameters to existing
   methods to accomplish this. You should only need to modify the
   input parameter(s) of the existing methods. You may also need
   to modify your import statements.
   
   **Hint:** If you're stuck on this step, it is similar to the 
   `gatherTotalDonations` method in the 
   [video](https://www.youtube.com/watch?v=kcBV6tlg44I) on Interfaces 
   provided in the 
   [1302 Interfaces Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/alsi/interfaces/interfaces.md).

1. Uncomment the call to `writeToFile` in the `main` method of
   `Driver.java` that takes `compilers` as input. The line is already
   there — it is just commented out. Compile and run the
   code. You should now see a file called `compilersInfo.txt` that
   contains the instance variables of the `TextBook` object referred
   to by variable `compilers`. The contents of `compilersInfo.txt`
   should contain the following information (you can verify by opening
   the file with Emacs):

   ```
   TextBook:
   "Compilers" is published by Addison Wesley
   ```

1. Compare the contents of `compilersInfo.txt` to the contents of
   `progressInfo.txt`. These two files were created by the **same
   method** but the format is different! The `writeToFile` method behaves very
   differently depending on the type of object its parameter `object`
   refers to! This is **polymorphism** in action. The method behaves
   differently depending on the type of object its parameter refers to!
   
1. In the `main` method of `Driver.java`, update the `writeAllToFile` method
   in the same way you did `writeToFile`. Then, uncomment the call to 
   `writeAllToFile` that takes `tbArray` as the first input. What do
   you expect to happen when you run the code? Go ahead and run it to
   verify that it works as expected.

1. Add your own class to the `cs1302.hw.impl` package. It can be a 
   simple class with as few as two instance variables. Have this 
   class implement the `Savable` interface. You can have the `save` method
   write the instance variables to the file in any format you wish, as long as
   it is different from how it is done in `GameProgress` and `TextBook`. 
   Compare the contents of `compilersInfo.txt` to the contents of
   `progressInfo.txt` — notice how they are both formatted differently. The
   file created by your new class should be look different from both of these.
   
1. If the previous step was done properly, your new class will work with 
   the `writeToFile` and `writeAllToFile` methods now that those methods 
   work with any object that implements the `Savable` interface!
   
1. Test your new class by creating a couple objects in the `Driver` class
   and making calls to both `writeToFile` and `writeAllToFile` using your
   new class.
   
1. Once you are confident that the code is running as expected, verify that 
   your code passes the `checkstyle` audit using the command `check1302 src`.

1. Generate the API documentation website for all of the code in the
   `cs1302` package. Host the documentation on Odin using `cs1302-hw-savable-doc`
   as the name of your symbolic link.

1. Take a minute to reflect on what you did in this homework assignment. You were
   able to modify a method called `writeToFile` that was originally designed to
   work for only one type, `GameProgress`, so that it could work with many different
   types. Specifically, any class that implements the `Savable` interface. That's
   an extremely powerful tool in software development!

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-3-success?style=for-the-badge)

<hr/>

### Submission Steps

**Each student needs to individually submit their own work.**

1. Create a plain text file called `SUBMISSION.md` directly inside the `cs1302-hw-savable`
   directory with the following information:

   1. Your name and UGA ID number;
   1. Full URL for your hosted API website; and
   1. A short description of the new class that you added to the `cs1302.hw.impl` package in checkpoint 3.

   Here is an example of the contents of `SUBMISSION.md`.

   ```
   Sally Smith (811-000-999)
   https://webwork.cs.uga.edu/~your_username/cs1302-hw-savable-doc/
   I created a class called Turtle because I am a huge fan of turtles.
   The class has three instance variables (genus, species, and weight).
   ```

1. Change directories to the parent of `cs1302-hw-savable` (e.g., `cd
   ..` from `cs1302-hw-savable`). If you would like to make a backup
   tar file, the instructions are in the submissions steps for
   [hw01](https://github.com/cs1302uga/cs1302-hw01).  We won't repeat
   those steps here and you can view them as optional.

1. Use the `submit` command to submit this exercise to `csci-1302`:

   ```
   $ submit cs1302-hw-savable csci-1302
   ```

   Read the output of the submit command very carefully. If there is
   an error while submitting, then it will displayed in that
   output. Additionally, if successful, the submit command creates a
   new receipt file in the directory you submitted. The receipt file
   begins with rec and contains a detailed list of all files that were
   successfully submitted.  Look through the contents of the rec file
   and always remember to keep that file in case there is an issue
   with your submission.

   **Note:** You must be on Odin to submit.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished-Submission-success?style=for-the-badge)

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/) [![License: CC BY-NC 4.0](https://img.shields.io/badge/Instructor%20License-CC%20BY--NC%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc/4.0/)

<small>
Copyright &copy; Michael E. Cotterell, Bradley J. Barnes, and the University of Georgia.
This work is licensed under
a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public and licensed under
a <a rel="license" href="http://creativecommons.org/licenses/by-nc/4.0/">Creative Commons Attribution-NonCommercial 4.0 International License</a> to instructors at institutions of higher education.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>
