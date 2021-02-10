package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public class RedoController {

	private Session session;

	RedoController(Session session) {
		this.session = session;
	}

	public boolean isRedoable() {
		return this.session.isRedoable();
	}

	public void redo() {
		this.session.redo();
	}

}