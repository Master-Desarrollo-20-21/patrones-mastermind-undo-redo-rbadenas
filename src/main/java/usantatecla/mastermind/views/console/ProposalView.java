package usantatecla.mastermind.views.console;

import java.util.List;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.WithConsoleView;
import usantatecla.mastermind.views.MessageView;

class ProposalView extends WithConsoleView {

	public void interact(PlayController playController) {
		this.addAttempt(playController);
		this.printAllAttempts(playController);
		this.notifyIfGameOver(playController);
	}

	private void addAttempt(PlayController playController) {
		Error error;
		do {
			List<Color> colors = new ProposedCombinationView(playController).read();
			error = playController.addProposedCombination(colors);
			new ErrorView(error).writeln();
		} while (error != Error.NO_ERROR);
	}

	private void printAllAttempts(PlayController playController) {
		this.console.writeln();
		new AttemptsView(playController).writeln();
		new SecretCombinationView(playController).writeln();
		for (int i = 0; i < playController.getAttempts(); i++) {
			new ProposedCombinationView(playController).write(i);
			new ResultView(playController).writeln(i);
		}
	}

	private void notifyIfGameOver(PlayController playController){
		if (playController.isWinner()) {
			this.console.writeln(MessageView.WINNER.getMessage());
		} else if (playController.isLooser()) {
			this.console.writeln(MessageView.LOOSER.getMessage());
		}
	}

}