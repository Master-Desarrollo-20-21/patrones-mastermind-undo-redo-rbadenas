package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public abstract class Controller {

	protected Session session;
	protected boolean isNull;

	Controller(Session session) {
		this.isNull = false;
		this.session = session;
	}
	
	public boolean isNull(){
        return this.isNull;
    }

	public int getWidth() {
		return this.session.getWidth();
	}

	public abstract void accept(ControllersVisitor controllersVisitor);
}