package usantatecla.mastermind.controllers;

public interface ControllersVisitor {
	
	void visit(StartController startController);

	void visit(PlayController playController);
	
	void visit(ResumeController continueController);

	void visit(NullController nullController);
}
