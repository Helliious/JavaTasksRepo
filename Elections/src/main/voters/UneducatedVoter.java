package main.voters;

import main.candidates.Candidate;
import main.util.Randomizator;

import java.util.HashSet;

public class UneducatedVoter extends Voter {
    public UneducatedVoter(Candidate candidate,
                    boolean isBribed) {
        super(candidate, isBribed);
    }

    @Override
    public Class getVoterClass() {
        return Class.UNEDUCATED;
    }

    @Override
    public boolean vote(HashSet<Candidate> candidates) {
        boolean isGoingToVote = Randomizator.randomNumInRange(0, 101) > 10;
        if (isGoingToVote) {
            getCandidate().incrementAccumulatedVoters();
        }
        return isGoingToVote;
    }
}
