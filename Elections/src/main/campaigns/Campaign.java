package main.campaigns;

import main.candidates.Candidate;
import main.util.Randomizator;
import main.util.Validator;
import main.voters.Voter;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;

public abstract class Campaign {
    private final LocalDate startDate;
    private LocalDate endDate;
    private double budget;
    private final HashSet<Voter> voters;

    public Campaign(LocalDate startDate,
             LocalDate endDate,
             double budget) {
        this.startDate = startDate;
        if (Validator.isValidDateRange(startDate, endDate)) {
            this.endDate = endDate;
        }
        if (budget > 0) {
            this.budget = budget;
        }
        voters = new HashSet<>();
    }

    public abstract void generateVoters(Candidate candidate);

    void addVoter(Voter voter) {
        voters.add(voter);
    }

    public HashSet<Voter> getVoters() {
        return voters;
    }

    void reduceBudget() {
        budget -= Randomizator.randomNumInRange(30, 51);
    }

    public double getBudget() {
        return budget;
    }

    long getDuration() {
        return Period.between(startDate, endDate).getDays();
    }
}
