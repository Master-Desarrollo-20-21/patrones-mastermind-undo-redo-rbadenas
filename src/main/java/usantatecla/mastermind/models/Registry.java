package usantatecla.mastermind.models;

import java.util.ArrayList;

public class Registry {
    
	private Game game;
    private ArrayList<Memento> mementos;
	private int firstPrevious;
	
	public Registry(Game game) {
		this.game = game;
		this.mementos = new ArrayList<Memento>();
		this.firstPrevious = 0;
		this.register();
	}

	public void register() {
		for (int i = 0; i < this.firstPrevious; i++) {
			this.mementos.remove(0);
			this.firstPrevious--;
		}
		this.mementos.add(this.firstPrevious, this.game.createMemento());
	}

	public void undo() {
		this.firstPrevious++;
		this.game.set(this.getFirstPreviousMemento());
	}

	public void redo() {
		this.firstPrevious--;
		this.game.set(this.getFirstPreviousMemento());
	}

	public boolean isUndoable() {

		return this.firstPrevious < this.mementos.size() - 1;
	}

	public boolean isRedoable() {
		return this.firstPrevious > 0;
	}

	private Memento getFirstPreviousMemento(){
		return this.mementos.get(this.firstPrevious);
	}

}