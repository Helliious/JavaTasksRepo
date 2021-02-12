package main.productionLines;

import main.GlobalComponents;
import main.Type;
import main.components.Component;
import main.components.Engine;
import main.components.Seat;
import main.components.Tire;

public class FirstLine implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Component engine = new Engine();
                Thread.sleep(engine.getBuildTime());
                GlobalComponents.addType(Type.ENGINE);
                GlobalComponents.components.get(Type.ENGINE).offer(engine);
                engine.showComponent();

                Component tire = new Tire();
                Thread.sleep(tire.getBuildTime());
                GlobalComponents.addType(Type.TIRE);
                GlobalComponents.components.get(Type.TIRE).offer(tire);
                tire.showComponent();

                Component seat = new Seat();
                Thread.sleep(seat.getBuildTime());
                GlobalComponents.addType(Type.SEAT);
                GlobalComponents.components.get(Type.SEAT).offer(seat);
                seat.showComponent();
                GlobalComponents.checkPartsReadyForAssemble();
            } catch (InterruptedException e) {
                System.out.println("Oooops!");
            }
        }
    }
}
