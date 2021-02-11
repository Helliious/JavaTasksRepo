package main;

import main.clients.Client;
import main.constants.Constants;
import main.util.Randomizator;

import java.util.HashMap;

public class Waiter {
    private final String name;
    private double tipsAmount;
    private final HashMap<Client, Double> orders;

    Waiter() {
        this.name = Constants.NAMES[Randomizator.randomNumInRange(
                0,
                Constants.NAMES.length
        )];
        tipsAmount = 0;
        orders = new HashMap<>();
    }

    public double getTipsAmount() {
        return Randomizator.roundNum(tipsAmount);
    }

    public String getName() {
        return name;
    }

    public void assignClient(Client client) {
        orders.put(client, 0.0);
    }

    public void addToOrder(Client client, double price) {
        orders.put(client, orders.get(client) + price);
    }

    public double giveOrder(Client client) {
        return orders.remove(client);
    }

    public void getTipped(double amount) {
        tipsAmount += amount;
    }
}
