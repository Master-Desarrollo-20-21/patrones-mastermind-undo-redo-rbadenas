package usantatecla.mastermind.models;

import java.util.List;

public class Memento {

    private List<ProposedCombination> proposedCombinations;

    public Memento(List<ProposedCombination> proposedCombinations) {
        this.proposedCombinations = proposedCombinations;
    }

    List<ProposedCombination> getProposedCombinations() {
        return this.proposedCombinations;
    }

}