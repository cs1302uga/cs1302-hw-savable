# hw03 Interfaces (ADTs)

![Approved for: Spring 2023](https://img.shields.io/badge/Approved%20for-Spring%202023-magenta)

When a seasoned programmer or potential employer asks you if you know
Object-Oriented Programming (OOP), they are NOT asking, "do you know
classes and objects?"  Instead, what they are really asking is , "do
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
* **L04.b:** Utilize interface-based polymorphism in a software solution.

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
      according to the following column descriptions** -- use the API
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
   names of the abstract methods declared in the interface -- the
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
   that compiles each file using a separate `javac` command. You will
   need to take care when ordering the commands since dependencies
   exists between some of the files. We recommend using the shebang below so
   that your script prints out what it's doing and exits early if
   a command fails:

   ```bash
   #!/bin/bash -ex
   ```

   One your script is setup correctly, you can run it to recompile
   everything instead of typing the compilation commands again or finding
   them in your shell history!

1. Make sure that your script works properly before continuing to the
   next checkpoint. You can check this by running `tree bin` and
   comparing its output to the expected output below:

   ```
   bin
   └── cs1302
       └── hw03
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
   print variables to the file.

1. Now, take a look at the `Driver.java` file in the `cs1302.hw`
   package. In this file, we create two `GameProgress` objects and
   reference them with variables of the same type. We then save these
   objects to files on the disk.

1. Modify the script that you created in the previous checkpoint
   to include the `java` command to run `cs1302.hw.Driver`
   after all of the `javac` commands. Since the `Driver` program
   is expected to create some files in current directory, add
   the `ls -lh` command both before and after the `java` command
   to make it easier to see if the program works as intended.

1. Run your modified script to recompile source code, list the
   files in the current directory, run the `Driver`, then list
   files in the current directory again -- all in a single command!

   You should now see two new files named `progress0.txt` and
   `progress1.txt` that contain the instance variables for the two
   `GameProgess` objects created by `Driver`. Look inside them to
   confirm this. Cool, huh?!?

   **NOTE** You can add the `rm` commands to delete these files before
   the first `ls -lh` command in your script so that they never
   appear in your script's output before the `Driver` is run.

1. Now, modify the `TextBook.java` file so that it properly implements
   the `Savable` interface. You will need to add a `save` method that
   works similarly to the `save` method in `GameProgress`. However,
   your `save` method should write the instance variables of the
   calling object (of type `TextBook`) to a file. Remember to provide
   an appropriate Javadoc comment outlining the format of the file
   this method will create.

1. Use your compile script to recompile your code and run `check1302`.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-2-success?style=for-the-badge)

<hr/>

### Checkpoint 3 Steps

1. Modify the `writeToFile` method in `Driver.java` file so that it
   also accepts `TextBook` references as input. **Note:** You should
   not create any new methods or add new parameters to existing
   methods to accomplish this. You should only need to modify the
   input parameter(s) of the existing methods.

1. Uncomment the call to `writeToFile` in the `main` method of
   `Driver.java` that takes `compilers` as input. Compile and run the
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
   method**! Notice how the `writeToFile` method behaves very
   differently depending on the type of object its parameter `object`
   refers to! This is **polymorphism** in action. The method behaves
   differently depending on its input.

1. Add your own class. It can be a simple class with as few as two
   instance variables. Have this class implement the `Savable`
   interface.  If done properly, your new class will work with the
   `writeAll

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-3-success?style=for-the-badge)

<hr/>

### Submission Steps

**Each student needs to individually submit their own work.**

1. Create a plain text file called `SUBMISSION.md` directly inside the `cs1302-hw-savable`
   directory with the following information:

   1. Your name and UGA ID number; and
   1. Full URL for your hosted API website

   Here is an example of the contents of `SUBMISSION.md`.

   ```
   Sally Smith (811-000-999)
   https://webwork.cs.uga.edu/~your_username/cs1302-hw-savable-doc/
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
