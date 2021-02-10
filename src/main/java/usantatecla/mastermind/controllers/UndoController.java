package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public class UndoController {

	private Session session;

	UndoController(Session session) {
		this.session = session;
	}

	public boolean isUndoable() {
		return this.session.isUndoable();
	}

	public void undo() {
		this.session.undo();
	}

}
