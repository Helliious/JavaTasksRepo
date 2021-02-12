package main;

import main.productionLines.FirstLine;
import main.productionLines.SecondLine;
import main.productionLines.ThirdLine;

public class Demo {
    public static void main(String[] args) {
        FirstLine firstLine = new FirstLine();
        SecondLine secondLine = new SecondLine();
        ThirdLine thirdLine = new ThirdLine();
        Thread f = new Thread(firstLine);
        Thread s = new Thread(secondLine);
        Thread t = new Thread(thirdLine);

        f.start();
        s.start();
        t.start();
    }
}
