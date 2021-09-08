# test-multithreaded-counter-accuracy-no-sync
My solution for Chapter 12 Exercise 1 of “Introduction to Programming Using Java”.

Problem Description:
Subsection 12.1.3 discusses the need for synchronization in multithreaded programs, and
it defines a ThreadSafeCounter class with the necessary synchronization. Is this really
important? Can you really get errors by using an unsynchronized counter with multiple
threads? Write a program to find out. Use the following unsynchronized counter class,
which you can include as a nested class in your program:
static class Counter {
int count;
void inc() {
count = count+1;
}
int getCount() {
return count;
}
}
Write a thread class that will repeatedly call the inc() method in an object of type
Counter. The object should be a shared global variable. Create several threads, start
them all, and wait for all the threads to terminate. Print the final value of the counter,
and see whether it is correct.
Let the user enter the number of threads and the number of times that each thread
will increment the counter. You might need a fairly large number of increments to see
an error. And of course there can never be any error if you use just one thread. Your
program can use join() to wait for a thread to terminate (see Subsection 12.1.2).
