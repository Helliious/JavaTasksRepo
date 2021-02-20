package main.voters;

import main.candidates.Candidate;
import main.constants.Constants;
import main.util.Randomizator;

import java.util.HashSet;
import java.util.Objects;

public abstract class Voter {
    private static int counter = 0;
    private final String name;
    private final int id;
    private final Gender gender;
    private final String city;
    private Candidate candidate;
    private final boolean isBribed;

    Voter(Candidate candidate,
          boolean isBribed) {
        this.gender = Randomizator.randomNumInRange(0, 2) == 0 ?
                Gender.MALE
                :
                Gender.FEMALE;
        if (gender == Gender.MALE) {
            this.name = Constants.MALE_NAMES[Randomizator.randomNumInRange(
                    0,
                    Constants.MALE_NAMES.length
            )];
        } else {
            this.name = Constants.FEMALE_NAMES[Randomizator.randomNumInRange(
                    0,
                    Constants.FEMALE_NAMES.length
            )];
        }
        this.id = counter++;
        this.city = Constants.CITIES[Randomizator.randomNumInRange(
                0,
                Constants.CITIES.length
        )];
        this.candidate = candidate;
        this.isBribed = isBribed;
    }

    public abstract Class getVoterClass();
    public abstract boolean vote(HashSet<Candidate> candidates);

    public String getCity() {
        return city;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voter voter = (Voter) o;
        return id == voter.id &&
                Objects.equals(name, voter.name) &&
                gender == voter.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, gender);
    }

    @Override
    public String toString() {
        return "Voter{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                "}\n";
    }
}
