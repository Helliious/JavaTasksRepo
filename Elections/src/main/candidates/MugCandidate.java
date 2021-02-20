package main.candidates;

import main.campaigns.Campaign;
import main.campaigns.CriminalCampaign;
import main.util.Randomizator;

import java.time.LocalDate;

public class MugCandidate extends Candidate {
    private final CriminalCampaign criminalCampaign;

    public MugCandidate(double campaignMoney) {
        super(
                Randomizator.randomNumInRange(0, 2) == 0 ?
                        Education.NONE
                        :
                        Education.MIDDLE,
                campaignMoney
        );
        criminalCampaign = new CriminalCampaign(
                LocalDate.now(),
                LocalDate.now().plusWeeks(4),
                campaignMoney
        );
    }

    @Override
    public void startCampaign() {
        criminalCampaign.generateVoters(this);
    }

    @Override
    public Campaign getCampaign() {
        return criminalCampaign;
    }
}
