package main;

import main.components.Component;
import main.productionLines.ProductionLine;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Demo {
    public static void main(String[] args) {
        HashMap<Type, Queue<Component>> components = new HashMap<>();
        Queue<Type> firstLineList = new LinkedList<>();
        firstLineList.offer(Type.ENGINE);
        firstLineList.offer(Type.TIRE);
        firstLineList.offer(Type.SEAT);
        Queue<Type> secondLineList = new LinkedList<>();
        secondLineList.offer(Type.FRAME);
        secondLineList.offer(Type.TIRE);
        secondLineList.offer(Type.TIRE);
        secondLineList.offer(Type.TIRE);
        Queue<Type> thirdLineList = new LinkedList<>();
        thirdLineList.offer(Type.SEAT);
        thirdLineList.offer(Type.SEAT);
        thirdLineList.offer(Type.SEAT);
        thirdLineList.offer(Type.SEAT);
        ProductionLine firstLine = new ProductionLine(firstLineList, components);
        ProductionLine secondLine = new ProductionLine(secondLineList, components);
        ProductionLine thirdLine = new ProductionLine(thirdLineList, components);
        Thread f = new Thread(firstLine);
        Thread s = new Thread(secondLine);
        Thread t = new Thread(thirdLine);

        f.start();
        s.start();
        t.start();
    }
}
