package main;

import main.candidates.Candidate;
import main.candidates.MugCandidate;
import main.candidates.PoliticianCandidate;
import main.candidates.ShowmanCandidate;
import main.util.Randomizator;

import java.util.HashSet;

public class ElectionsDemo {
    public static void main(String[] args) {
        HashSet<Candidate> candidates = new HashSet<>();
        int randomChance;
        int amountMoney;
        Candidate candidate;
        do {
            randomChance = Randomizator.randomNumInRange(0, 3);
            amountMoney = Randomizator.randomNumInRange(3000, 10000);
            switch (randomChance) {
                case 0:
                    candidate = new MugCandidate(amountMoney);
                    break;
                case 1:
                    candidate = new PoliticianCandidate(amountMoney);
                    break;
                default:
                    candidate = new ShowmanCandidate(amountMoney);
                    break;
            }
            candidates.add(candidate);
        } while (candidates.size() < 10);

        CIK cik = new CIK(candidates);
        cik.startCampaigns();
        cik.beginElections();
        cik.showElectionsResults();
//        cik.showWinner();
//        cik.showSecond();
//        cik.showOverallVoters();

        System.out.println("Overall Voting Activity: " + cik.votingActivity() + "%");
        cik.votingActivityByCities();
    }
}
