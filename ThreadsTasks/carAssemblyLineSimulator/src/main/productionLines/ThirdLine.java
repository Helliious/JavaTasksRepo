package main.productionLines;

import main.GlobalComponents;
import main.Type;
import main.components.Component;
import main.components.Seat;

public class ThirdLine implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                for (int i = 0; i < 4; i++) {
                    Component seat = new Seat();
                    Thread.sleep(seat.getBuildTime());
                    GlobalComponents.addType(Type.SEAT);
                    GlobalComponents.components.get(Type.SEAT).offer(seat);
                    seat.showComponent();
                    GlobalComponents.checkPartsReadyForAssemble();
                }
            } catch (InterruptedException e) {
                System.out.println("Oooops!");
            }
        }
    }
}
