package main;

import main.Constants.Constants;
import main.Vignette.*;
import main.util.Randomizator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class GasStation {
    private int dayMoney;
    private final HashMap<VignetteType, HashMap<VignetteKind, ArrayList<Vignette>>> vignettes;
    private final TreeSet<Vignette> sortedVignettes = new TreeSet<>((v1, v2) -> {
        if (Integer.compare(v1.getPrice(), v2.getPrice()) == 0) {
            return 1;
        }
        return Integer.compare(v1.getPrice(), v2.getPrice());
    });

    GasStation() {
        dayMoney = 0;
        vignettes = new HashMap<>();
        for (int i = 0; i < Constants.VIGNETTES_AMOUNT; i++) {
            int randomVignetteType = Randomizator.getRandomInRange(0, 3);
            int randomVignetteKind = Randomizator.getRandomInRange(0, 3);
            VignetteKind randomVignette = VignetteKind.values()[randomVignetteKind];
            Vignette vignette;
            switch (randomVignette) {
                case BUS:
                    vignette = new BusVignette(VignetteType.values()[randomVignetteType]);
                    break;
                case TRUCK:
                    vignette = new TruckVignette(VignetteType.values()[randomVignetteType]);
                    break;
                default:
                    vignette = new CarVignette(VignetteType.values()[randomVignetteType]);
                    break;
            }
            if (!vignettes.containsKey(vignette.getType())) {
                vignettes.put(vignette.getType(), new HashMap<>());
            }
            if (!vignettes.get(vignette.getType()).containsKey(vignette.getColor())) {
                vignettes.get(vignette.getType()).put(vignette.getColor(), new ArrayList<>());
            }
            vignettes.get(vignette.getType()).get(vignette.getColor()).add(vignette);
            sortedVignettes.add(vignette);
        }
    }

    //Method implementing business logic for selling a vignette
    Vignette sellVignette(VignetteType vignetteType, VignetteKind vignetteKind) {
        if (vignettes.containsKey(vignetteType) &&
                (vignettes.get(vignetteType).containsKey(vignetteKind)) &&
                !(vignettes.get(vignetteType).get(vignetteKind).isEmpty())) {
            Vignette vignette = vignettes.get(vignetteType).get(vignetteKind).remove(0);
            sortedVignettes.remove(vignette);
            dayMoney += vignette.getPrice();
            return vignette;
        } else {
            System.out.println("No more Vignettes of this kind!");
            return null;
        }
    }

    void returnVignette(Vignette vignette) {
        vignettes.get(vignette.getType()).get(vignette.getColor()).add(vignette);
    }

    //Showing all available vignettes in the current Gas Station
    void showVignettes() {
        System.out.println("----------------------------------------------");
        System.out.println("\t\t\tGenerated Vignettes");
        System.out.println("----------------------------------------------");
        System.out.println(sortedVignettes);
        System.out.println("----------------------------------------------");
    }

    public int getDayMoney() {
        return dayMoney;
    }
}
