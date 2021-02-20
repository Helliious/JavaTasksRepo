package main.campaigns;

import main.candidates.Candidate;
import main.constants.Constants;
import main.util.Randomizator;
import main.voters.MidTearVoter;
import main.voters.UneducatedVoter;
import main.voters.Voter;
import main.voters.WealthyVoter;

import java.time.LocalDate;

public class NormalCampaign extends Campaign {
    public NormalCampaign(LocalDate startDate,
                   LocalDate endDate,
                   double budget) {
        super(startDate, endDate, budget);
    }

    @Override
    public void generateVoters(Candidate candidate) {
        long duration = getDuration();
        int voterType;
        Voter v;
        for (int i = 1; i <= duration; i++) {
            do {
                voterType = Randomizator.randomNumInRange(0, 3);
                switch (voterType) {
                    case 0:
                        v = new UneducatedVoter(candidate, false);
                        break;
                    case 1:
                        v = new MidTearVoter(candidate, false);
                        break;
                    default:
                        v = new WealthyVoter(candidate, false);
                        break;
                }
                addVoter(v);
            } while (getVoters().size() < Constants.NORMAL_CAMP_VOTERS_PER_DAY * i);
        }
    }
}
