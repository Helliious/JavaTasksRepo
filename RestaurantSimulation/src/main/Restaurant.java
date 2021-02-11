package main;

import main.clients.Client;
import main.util.Randomizator;

import java.util.ArrayList;

public class Restaurant {
    private final String name = "Pri pesho";
    private final String address = "Dolni Bogorov";
    private double startingMoney;
    private final Menu menu;
    private final ArrayList<Waiter> waiters;
    private final ArrayList<Client> clients;

    Restaurant() {
        startingMoney = 1000;
        menu = new Menu();
        menu.generateMenu();
        waiters = new ArrayList<>();
        clients = new ArrayList<>();
    }

    void addWaiter(Waiter waiter) {
        waiters.add(waiter);
    }

    public ArrayList<Waiter> getWaiters() {
        return waiters;
    }

    public void showMenu() {
        menu.showMenu();
    }

    void addClients(ArrayList<Client> clients) {
        this.clients.addAll(clients);
    }

    void addMoneyToCashDesk(double amount) {
        startingMoney += amount;
    }

    void clientsOrders() {
        for (Client c : clients) {
            Waiter waiter = waiters.get(Randomizator.randomNumInRange(
                    0,
                    waiters.size()
            ));
            c.makeOrder(waiter, menu);
        }
    }

    void clientsAskForBills() {
        for (Client c : clients) {
            c.askForBill();
        }
    }

    void payingBills() {
        for (Client c : clients) {
            addMoneyToCashDesk(c.payBill());
        }
    }

    public double getBalance() {
        return Randomizator.roundNum(startingMoney);
    }
}
