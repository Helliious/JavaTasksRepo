package main;

import main.components.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GlobalComponents {
    public static HashMap<Type, Queue<Component>> components = new HashMap<>();

    public static void addType(Type type) {
        if (!components.containsKey(type)) {
            components.put(type, new LinkedList<>());
        }
    }

    public static void checkPartsReadyForAssemble() {
        boolean isAssembled = false;
        if (components.containsKey(Type.ENGINE) &&
                components.containsKey(Type.FRAME) &&
                components.containsKey(Type.SEAT) &&
                components.containsKey(Type.TIRE)) {
            if (!components.get(Type.ENGINE).isEmpty() &&
                    !components.get(Type.FRAME).isEmpty()) {
                if (components.get(Type.SEAT).size() >= 5 &&
                        components.get(Type.TIRE).size() >= 4) {
                    components.get(Type.ENGINE).remove();
                    components.get(Type.FRAME).remove();
                    for (int i = 0; i < 4; i++) {
                        components.get(Type.TIRE).remove();
                    }
                    for (int i = 0; i < 5; i++) {
                        components.get(Type.SEAT).remove();
                    }
                    isAssembled = true;
                }
            }
        }

        if (isAssembled) {
            System.out.println("\n\nNew car is assembled!\n\n");
        }
    }
}
