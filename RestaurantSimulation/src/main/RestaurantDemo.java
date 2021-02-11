package main;

import main.clients.Client;
import main.clients.Mug;
import main.clients.Student;
import main.clients.Vegan;
import main.util.Randomizator;

import java.util.ArrayList;
import java.util.TreeSet;

public class RestaurantDemo {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        ArrayList<Client> clients = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            restaurant.addWaiter(new Waiter());
        }

        for (int i = 0; i < 15; i++) {
            int clientTypeChance = Randomizator.randomNumInRange(0, 101);
            if (clientTypeChance < 20) {
                clients.add(new Student());
            } else if (clientTypeChance > 20 && clientTypeChance < 50) {
                clients.add(new Vegan());
            } else {
                clients.add(new Mug());
            }
        }

        restaurantWorkFlow(restaurant, clients);
        System.out.println("Restaurant balance: " + restaurant.getBalance() + "$");

        TreeSet<Waiter> sortedWaiters = new TreeSet<>((w1, w2) -> Double.compare(w2.getTipsAmount(), w1.getTipsAmount()));
        sortedWaiters.addAll(restaurant.getWaiters());

        System.out.println("\nMost tipped waiter:");
        System.out.println(sortedWaiters.first().getName() + " : " + sortedWaiters.first().getTipsAmount() + "$");

        System.out.println("\nAll waiters tips:");
        for (Waiter w : sortedWaiters) {
            System.out.println(w.getName() + " : " + w.getTipsAmount() + "$");
        }

        System.out.println("\nProducts after dinner:");
        restaurant.showMenu();
    }

    static void restaurantWorkFlow(Restaurant restaurant, ArrayList<Client> clients) {
        restaurant.addClients(clients);
        restaurant.clientsOrders();
        restaurant.clientsAskForBills();
        restaurant.payingBills();
    }
}
