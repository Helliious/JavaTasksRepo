package main.util;

import main.candidates.Education;

import java.util.Random;

public class Randomizator {
    public static int randomNumInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static Education randomEducation() {
        int educationType = randomNumInRange(0, 3);
        switch (educationType) {
            case 0:
                return Education.NONE;
            case 1:
                return Education.MIDDLE;
            default:
                return Education.UNIVERSITY;
        }
    }
}
