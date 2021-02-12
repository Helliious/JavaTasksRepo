package main.productionLines;

import main.Type;
import main.components.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ProductionLine implements Runnable {
    Queue<Type> componentsType;
    HashMap<Type, Queue<Component>> componentsWarehouse;

    public ProductionLine(Queue<Type> componentsType,
                          HashMap<Type, Queue<Component>> componentsWarehouse) {
        this.componentsType = componentsType;
        this.componentsWarehouse = componentsWarehouse;
    }

    void addType(Type type) {
        if (!componentsWarehouse.containsKey(type)) {
            componentsWarehouse.put(type, new LinkedList<>());
        }
    }

    void checkPartsReadyForAssemble() {
        boolean isAssembled = false;
        if (componentsWarehouse.containsKey(Type.ENGINE) &&
                componentsWarehouse.containsKey(Type.FRAME) &&
                componentsWarehouse.containsKey(Type.SEAT) &&
                componentsWarehouse.containsKey(Type.TIRE)) {
            if (!componentsWarehouse.get(Type.ENGINE).isEmpty() &&
                    !componentsWarehouse.get(Type.FRAME).isEmpty()) {
                if (componentsWarehouse.get(Type.SEAT).size() >= 5 &&
                        componentsWarehouse.get(Type.TIRE).size() >= 4) {
                    componentsWarehouse.get(Type.ENGINE).remove();
                    componentsWarehouse.get(Type.FRAME).remove();
                    for (int i = 0; i < 4; i++) {
                        componentsWarehouse.get(Type.TIRE).remove();
                    }
                    for (int i = 0; i < 5; i++) {
                        componentsWarehouse.get(Type.SEAT).remove();
                    }
                    isAssembled = true;
                }
            }
        }

        if (isAssembled) {
            System.out.println("\n\nNew car is assembled!\n\n");
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Type type = componentsType.remove();
                Component component;
                switch (type) {
                    case SEAT:
                        component = new Seat();
                        break;
                    case ENGINE:
                        component = new Engine();
                        break;
                    case TIRE:
                        component = new Tire();
                        break;
                    default:
                        component = new Frame();
                        break;
                }
                Thread.sleep(component.getBuildTime());
                addType(type);
                componentsWarehouse.get(type).offer(component);
                component.showComponent();
                checkPartsReadyForAssemble();
                componentsType.offer(type);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception Caught!");
            }
        }
    }
}
