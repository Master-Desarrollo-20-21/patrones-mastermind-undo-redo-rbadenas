package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.NullController;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.View;

public class ConsoleView extends View {

	private StartView startView;
	private PlayView playView;
	private ResumeView resumeView;
	private NoControllerView noControllerView;

	public ConsoleView() {
		this.startView = new StartView();
		this.playView = new PlayView();
		this.resumeView = new ResumeView();
		this.noControllerView = new NoControllerView();
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);
	}

	@Override
	public void visit(PlayController playController) {
		this.playView.interact(playController);
	}

	@Override
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}

	@Override
	public void visit(NullController nullController) {
		this.noControllerView.interact(nullController);
	}

}