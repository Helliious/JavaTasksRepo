package main.candidates;

import main.campaigns.Campaign;
import main.constants.Constants;
import main.util.Randomizator;

import java.util.Objects;

public abstract class Candidate {
    private static int counter = 0;
    private final String name;
    private final int candidateId;
    private final Education education;
    private double campaignMoney;
    private int accumulatedVoters;

    Candidate(Education education,
              double campaignMoney) {
        this.name = Constants.CANDIDATES_NAMES[Randomizator.randomNumInRange(
                0,
                Constants.CANDIDATES_NAMES.length
        )];
        this.education = education;
        this.candidateId = counter++;
        if (campaignMoney > 0) {
            this.campaignMoney = campaignMoney;
        }
        this.accumulatedVoters = 0;
    }

    public abstract void startCampaign();
    public abstract Campaign getCampaign();

    public String getName() {
        return name;
    }

    public double getCampaignMoney() {
        return campaignMoney;
    }

    public Education getEducation() {
        return education;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void incrementAccumulatedVoters() {
        accumulatedVoters++;
    }

    public int getAccumulatedVoters() {
        return accumulatedVoters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return candidateId == candidate.candidateId &&
                Objects.equals(name, candidate.name) &&
                education == candidate.education;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, candidateId, education);
    }

    @Override
    public String toString() {
        return "\nCandidate Name: " + name + '\n';
    }
}
