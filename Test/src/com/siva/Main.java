package com.siva;


import java.util.Random;

class RandomNumberGenerator implements Runnable {
    private int count;
    private Random random;

    public RandomNumberGenerator(int count) {
        this.count = count;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            int randomNumber = random.nextInt(10); // Generating a random number between 0 and 99
            System.out.println(Thread.currentThread().getName() + ": " + randomNumber);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int numberOfThreads = 5;
        int numbersPerThread = 10;

        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(new RandomNumberGenerator(numbersPerThread));
            thread.start();
        }
    }
}

