package main.campaigns;

import main.candidates.Candidate;
import main.constants.Constants;
import main.util.Randomizator;
import main.voters.MidTearVoter;
import main.voters.UneducatedVoter;
import main.voters.Voter;
import main.voters.WealthyVoter;

import java.time.LocalDate;

public class CriminalCampaign extends Campaign {
    public CriminalCampaign(LocalDate startDate,
                     LocalDate endDate,
                     double budget) {
        super(startDate, endDate, budget);
    }

    @Override
    public void generateVoters(Candidate candidate) {
        long duration = getDuration();
        int voterType;
        boolean bribable;
        Voter v;
        for (int i = 0; i < duration; i++) {
            for (int j = 0; j < Constants.CRIMINAL_CAMP_VOTERS_PER_DAY; j++) {
                voterType = Randomizator.randomNumInRange(0, 3);
                if (getBudget() == 0) {
                    if (j > Constants.CRIMINAL_CAMP_VOTERS_PER_DAY / 2) {
                        break;
                    } else {
                        bribable = false;
                    }
                } else {
                    bribable = Randomizator.randomNumInRange(0, 2) == 0;
                }
                switch (voterType) {
                    case 0:
                        v = new UneducatedVoter(candidate, bribable);
                        break;
                    case 1:
                        v = new MidTearVoter(candidate, bribable);
                        break;
                    default:
                        v = new WealthyVoter(candidate, bribable);
                        break;
                }
                if (bribable) {
                    reduceBudget();
                }
                addVoter(v);
            }
        }
    }
}
