package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public class NullController extends Controller {
    
    public NullController(Session session) {
        super(session);
        this.isNull = true;
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}