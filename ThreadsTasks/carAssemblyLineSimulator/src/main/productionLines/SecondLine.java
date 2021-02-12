package main.productionLines;

import main.GlobalComponents;
import main.Type;
import main.components.Component;
import main.components.Frame;
import main.components.Tire;

public class SecondLine implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Component frame = new Frame();
                Thread.sleep(frame.getBuildTime());
                GlobalComponents.addType(Type.FRAME);
                GlobalComponents.components.get(Type.FRAME).offer(frame);
                frame.showComponent();
                for (int i = 0; i < 3; i++) {
                    Component tire = new Tire();
                    Thread.sleep(tire.getBuildTime());
                    GlobalComponents.addType(Type.TIRE);
                    GlobalComponents.components.get(Type.TIRE).offer(tire);
                    tire.showComponent();
                    GlobalComponents.checkPartsReadyForAssemble();
                }
            } catch (InterruptedException e) {
                System.out.println("Oooops!");
            }
        }
    }


}
