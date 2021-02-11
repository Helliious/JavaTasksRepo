package main.clients;

import main.Menu;
import main.Waiter;
import main.constants.Constants;
import main.util.Randomizator;

import java.util.Objects;

public abstract class Client {
    private static int id = 0;
    private final String name;
    private double money;
    private double orderPrice;
    private Waiter waiter;
    private final int clientId;

    Client(double money) {
        this.name = Constants.NAMES[Randomizator.randomNumInRange(
                0,
                Constants.NAMES.length
        )];
        if (money > 0) {
            this.money = money;
        }
        this.orderPrice = 0;
        this.clientId = id++;
    }

    public double getMoney() {
        return money;
    }

    void reduceMoney(double amount) {
        if (amount <= money) {
            money -= amount;
        }
    }

    public abstract void makeOrder(Waiter waiter, Menu menu);

    void assignWaiter(Waiter waiter) {
        this.waiter = waiter;
        waiter.assignClient(this);
    }

    public void askForBill() {
        orderPrice = waiter.giveOrder(this);
    }

    public double payBill() {
        if (Randomizator.randomNumInRange(1, 81) <= 80) {
            double tip = (orderPrice * Randomizator.randomNumInRange(5, 11)) / 100;
            orderPrice -= tip;
            waiter.getTipped(tip);
        }
        return orderPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientId == client.clientId && Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, clientId);
    }
}
