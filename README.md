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

### Checkpoint 2 Steps

1. Take a close look at the source code in `GameProgress.java`. Notice that the class
has two instance variables and how the `save` method writes these instance variables to the file passed into the `save` method.

1. Now, take a look at the `Driver.java` file in the `cs1302.hw03` package. In this file, we create two `GameProgress` objects
   and reference them with variables of the same type. We then save these objects to files on the disk.
   
1. Compile `Savable.java`, `GameProgress.java`, and `Driver.java`. We recommend creating a compile script so you don't have to type
   the compilation lines each time you want to compile.

1. Run `Driver`. Now, run `ls` in your current directory. You should see two new files named `progress0.txt` and `progress`.txt` that
   contain the instance variables for the two `GameProgess` objects created in `Driver.java`. Cool, huh?!?
   
1. Now, modfy the `TextBook.java` file so that it properly implements the `Savable` interface. You will need to add a `save` method
   that works similarly to the `save` method in `GameProgress`. However, your `save` method should write the instance variables of
   the calling object (of type `TextBook`) to a file. Remember to provide an appropriate Javadoc comment outlining the format of the
   file this method will create.

1. Compile your code and run `check1302`.

<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-2-success?style=for-the-badge)

<hr/>

### Checkpoint 3 Steps

1. Modify the `Driver.java` file. Create 3 textbook objects. Put those objects into an array. Call the `saveAll` method on this array.
   Your code should create 3 new textfiles with a `textbook` prefix ending with `.txt`.
   **NOTE:** you cannot create any new methods to accomplish this. You can, however, modify the input parameters to the existing methods.

1. Add your own class. It can be a simple class with as few as two instance variables. Have this class implement the `Savable` interface.
   If done properly, your new class will work with the `writeAll
<hr/>

![CP](https://img.shields.io/badge/Just%20Finished%20Checkpoint-3-success?style=for-the-badge)

<hr/>

### Submission Steps

**Each student needs to individually submit their own work.**

1. Create a plain text file called `SUBMISSION.md` directly inside the `cs1302-savable`
   directory with the following information:

   1. Your name and UGA ID number; and
   1. Full URL for your hosted API website 
   
   Here is an example of the contents of `SUBMISSION.md`.
   
   ```
   Sally Smith (811-000-999)
   https://webwork.cs.uga.edu/~your_username/cs1302-savable-doc/
   ```

1. Change directories to the parent of `cs1302-savable` (e.g., `cd ..` from `cs1302-savable`). If you would like
   to make a backup tar file, the instructions are in the submissions steps for [hw01](https://github.com/cs1302uga/cs1302-hw01).
   We won't repeat those steps here and you can view them as optional.
   
1. Use the `submit` command to submit this exercise to `csci-1302`:
   
   ```
   $ submit cs1302-savable csci-1302
   ```
   
   Read the output of the submit command very carefully. If there is an error while submitting, then it will displayed 
   in that output. Additionally, if successful, the submit command creates a new receipt file in the directory you 
   submitted. The receipt file begins with rec and contains a detailed list of all files that were successfully submitted. 
   Look through the contents of the rec file and always remember to keep that file in case there is an issue with your submission.

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
