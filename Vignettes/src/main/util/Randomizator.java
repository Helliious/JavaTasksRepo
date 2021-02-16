package main.util;

import java.util.Random;

public class Randomizator {
    //Method returning random integer in range -> min inclusive, max exclusive
    public static int getRandomInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
