package main.voters;

import main.candidates.Candidate;
import main.util.Randomizator;

import java.util.ArrayList;
import java.util.HashSet;

public class WealthyVoter extends Voter {
    public WealthyVoter(Candidate candidate,
                 boolean isBribed) {
        super(candidate, isBribed);
    }

    @Override
    public Class getVoterClass() {
        return Class.WEALTHY;
    }

    @Override
    public boolean vote(HashSet<Candidate> candidates) {
        ArrayList<Candidate> candidatesList = new ArrayList<>(candidates);
        if (Randomizator.randomNumInRange(0, 101) > 50) {
            if (Randomizator.randomNumInRange(0, 101) <= 50) {
                int randomIdx = Randomizator.randomNumInRange(
                        0,
                        candidatesList.size()
                );
                setCandidate(candidatesList.get(randomIdx));
            }
            getCandidate().incrementAccumulatedVoters();
            return true;
        } else {
            return false;
        }
    }
}
