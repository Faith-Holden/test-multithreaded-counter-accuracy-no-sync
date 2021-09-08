package solution;

import java.util.Scanner;

public class TestThreadCountAccuracy {
    static Counter counter = new Counter();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int threadNum = -1;
        int iterationNum = -1;
        while(threadNum<1){
            System.out.println("How many threads would you like? Please choose a number greater than 1;");
            threadNum = scanner.nextInt();
            scanner.nextLine();
        }
        while(iterationNum<1){
            System.out.println("How many times would you like each thread to increment the counter?");
            iterationNum = scanner.nextInt();
            scanner.nextLine();
        }

        Thread[] threadArray = new CountIncrementerThread[threadNum];
        for(int i = 0; i<threadNum; i++){
            threadArray[i] = new CountIncrementerThread(iterationNum);
            threadArray[i].start();
        }
        for (Thread thread : threadArray) {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("The counter total is " + counter.getCount() + ".");
        System.out.println("The expected count is " + threadNum*iterationNum + ".");



    }


    private static class CountIncrementerThread extends Thread{
        int numberOfIterations;
        CountIncrementerThread(int numberOfIterations){
            this.numberOfIterations = numberOfIterations;
        }
        public void run() {
            int countTimes = 0;
            while(countTimes<numberOfIterations){
                counter.inc();
                countTimes++;
            }

        }
    }


    private static class Counter {
        int count;
        void inc() {
            count = count+1;
        }
        int getCount() {
            return count;
        }
    }
}
