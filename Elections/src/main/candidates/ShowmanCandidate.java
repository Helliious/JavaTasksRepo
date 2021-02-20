package main.candidates;

import main.campaigns.Campaign;
import main.campaigns.NormalCampaign;
import main.util.Randomizator;

import java.time.LocalDate;

public class ShowmanCandidate extends Candidate {
    private final NormalCampaign normalCampaign;

    public ShowmanCandidate(double campaignMoney) {
        super(
                Randomizator.randomEducation(),
                campaignMoney
        );
        normalCampaign = new NormalCampaign(
                LocalDate.now(),
                LocalDate.now().plusWeeks(4),
                campaignMoney
        );
    }

    @Override
    public void startCampaign() {
        normalCampaign.generateVoters(this);
    }

    @Override
    public Campaign getCampaign() {
        return normalCampaign;
    }
}
