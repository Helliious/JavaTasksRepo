package main;

import main.candidates.Candidate;
import main.voters.Class;
import main.voters.Voter;

import java.util.*;

public class CIK {
    private final HashSet<Candidate> candidates;
    private final HashMap<String, HashSet<Voter>> voters;
    private final HashMap<Candidate, HashMap<String, Integer>> bulletins;
    private final TreeMap<Candidate, HashMap<String, Integer>> stats;
    private final TreeMap<String, Integer> votersSkippedVoting;
    private final HashMap<Candidate, HashMap<Class, Integer>> favoritePerClass;

    CIK(HashSet<Candidate> candidates) {
        this.candidates = candidates;
        this.voters = new HashMap<>();
        this.bulletins = new HashMap<>();
        this.favoritePerClass = new HashMap<>();
        this.votersSkippedVoting = new TreeMap<>((s1, s2) -> s2.compareTo(s1));
        this.stats = new TreeMap<>((c1, c2) -> c2.getAccumulatedVoters() - c1.getAccumulatedVoters());
    }

    void startCampaigns() {
        for (Candidate c : candidates) {
            c.startCampaign();
            for (Voter v : c.getCampaign().getVoters()) {
                if (!voters.containsKey(v.getCity())) {
                    voters.put(v.getCity(), new HashSet<>());
                }
                voters.get(v.getCity()).add(v);
            }
        }
    }

    void beginElections() {
        for (HashSet<Voter> vot : voters.values()) {
            for (Voter v : vot) {
                if (v.vote(candidates)) {
                    if (!bulletins.containsKey(v.getCandidate())) {
                        bulletins.put(v.getCandidate(), new HashMap<>());
                    }
                    if (!bulletins.get(v.getCandidate()).containsKey(v.getCity())) {
                        bulletins.get(v.getCandidate()).put(v.getCity(), 1);
                    }
                    bulletins.get(v.getCandidate()).put(v.getCity(),
                            bulletins.get(v.getCandidate()).get(v.getCity()) + 1);
                    if (!favoritePerClass.containsKey(v.getCandidate())) {
                        favoritePerClass.put(v.getCandidate(), new HashMap<>());
                    }
                    if (!favoritePerClass.get(v.getCandidate()).containsKey(v.getVoterClass())) {
                        favoritePerClass.get(v.getCandidate()).put(v.getVoterClass(), 1);
                    }
                    favoritePerClass.get(v.getCandidate()).put(v.getVoterClass(),
                            favoritePerClass.get(v.getCandidate()).get(v.getVoterClass()) + 1);
                } else {
                    if(!votersSkippedVoting.containsKey(v.getCity())) {
                        votersSkippedVoting.put(v.getCity(), 1);
                    }
                    votersSkippedVoting.put(v.getCity(),
                            votersSkippedVoting.get(v.getCity()) + 1);
                }
            }
        }
    }

    void showElectionsResults() {
        for (Map.Entry<Candidate, HashMap<String, Integer>> b : bulletins.entrySet()) {
            if (!stats.containsKey(b.getKey())) {
                stats.put(b.getKey(), new HashMap<>());
            }
            stats.get(b.getKey()).putAll(b.getValue());
        }

        for (Map.Entry<Candidate, HashMap<String, Integer>> b : stats.entrySet()) {
            System.out.println(b.getKey());
            for (Map.Entry<String, Integer> v : b.getValue().entrySet()) {
                System.out.println(v.getKey() + " - " + v.getValue());
            }
            System.out.println("Overall votes: " + b.getKey().getAccumulatedVoters());
        }
    }

    void showWinner() {
        System.out.println(stats.firstEntry().getKey());
    }

    void showSecond() {
        int idx = 0;
        for (Map.Entry<Candidate, HashMap<String, Integer>> e : stats.entrySet()) {
            if (idx == 1) {
                System.out.println(e.getKey());
                break;
            }
            idx++;
        }
    }

    void showOverallVoters() {
        int overallVoters = 0;
        for (Map.Entry<Candidate, HashMap<String, Integer>> b : stats.entrySet()) {
            overallVoters += b.getKey().getAccumulatedVoters();
        }
        for (Integer i : votersSkippedVoting.values()) {
            overallVoters += i;
        }
        System.out.println("Overall Voters: " + overallVoters);
    }

    double votingActivity() {
        int votedVoters = 0;
        for (Map.Entry<Candidate, HashMap<String, Integer>> b : stats.entrySet()) {
            votedVoters += b.getKey().getAccumulatedVoters();
        }
        int overallVoters = votedVoters;
        for (Integer i : votersSkippedVoting.values()) {
            overallVoters += i;
        }
        return (votedVoters * 100) / overallVoters;
    }

    void votingActivityByCities() {
        int votedVoters = 0;
        int overallVoters = 0;
        double votingActivity;
        TreeMap<String, Integer> votersVoted = new TreeMap<>((s1, s2) -> s2.compareTo(s1));
        for (Map.Entry<Candidate, HashMap<String, Integer>> b : stats.entrySet()) {
            for (Map.Entry<String, Integer> cityVote : b.getValue().entrySet()) {
                if (!votersVoted.containsKey(cityVote.getKey())) {
                    votersVoted.put(cityVote.getKey(), cityVote.getValue());
                }
                votersVoted.put(cityVote.getKey(),
                        votersVoted.get(cityVote.getKey()) + cityVote.getValue());
            }
        }

        for (Map.Entry<String, Integer> vote: votersVoted.entrySet()) {
            System.out.println("VOTE: " + vote.getValue());
            votedVoters = vote.getValue();
            overallVoters = votedVoters + votersSkippedVoting.get(vote.getKey());
            System.out.println("OVERALL: " + overallVoters);
            votingActivity = (votedVoters * 100) / overallVoters;
            System.out.println("Voting Activity in " +
                    vote.getKey() + ": " +
                    votingActivity + "%");
        }
    }

    void findFavorites() {
        Map.Entry<Candidate, HashMap<Class, Integer>> entry = favoritePerClass.entrySet().iterator().next();
        Candidate favoriteUneducatedCandidate = entry.getKey();
        Candidate favoriteMidTearCandidate = entry.getKey();
        Candidate favoriteWealthyCandidate = entry.getKey();

        for (Map.Entry<Candidate, HashMap<Class, Integer>> e : favoritePerClass.entrySet()) {
            for (Map.Entry<Class, Integer> p : e.getValue().entrySet()) {
                switch (p.getKey()) {
                    case UNEDUCATED:
                        if (favoriteUneducatedCandidate.getAccumulatedVoters() <
                                p.getValue()) {
                            favoriteUneducatedCandidate = e.getKey();
                        }
                }
            }
        }
    }
}
