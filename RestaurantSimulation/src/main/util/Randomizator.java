package main.util;

import java.util.Map;
import java.util.Random;

public class Randomizator {
    public static int randomNumInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static double roundNum(double number) {
        return Math.round(number * 100.0) / 100.0;
    }
}
