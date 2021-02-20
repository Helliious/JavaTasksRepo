package main.candidates;

import main.campaigns.Campaign;
import main.campaigns.CriminalCampaign;
import main.campaigns.NormalCampaign;
import main.util.Randomizator;

import java.time.LocalDate;

public class PoliticianCandidate extends Candidate {
    private final Campaign campaign;

    public PoliticianCandidate(double campaignMoney) {
        super(
                Randomizator.randomNumInRange(0, 2) == 0 ?
                        Education.MIDDLE
                        :
                        Education.UNIVERSITY,
                campaignMoney
        );

        int campaignType = Randomizator.randomNumInRange(0, 2);
        if (campaignType == 0) {
            campaign = new NormalCampaign(
                    LocalDate.now(),
                    LocalDate.now().plusWeeks(4),
                    campaignMoney
            );
        } else {
            campaign = new CriminalCampaign(
                    LocalDate.now(),
                    LocalDate.now().plusWeeks(4),
                    campaignMoney
            );
        }
    }

    @Override
    public void startCampaign() {
        campaign.generateVoters(this);
    }

    @Override
    public Campaign getCampaign() {
        return campaign;
    }
}
