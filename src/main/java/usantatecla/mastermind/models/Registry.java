package usantatecla.mastermind.models;

import java.util.ArrayList;

public class Registry {
    
	private Game game;
    private ArrayList<Memento> mementos;
	private int currentMementoIndex;
	
	public Registry(Game game) {
		this.game = game;
		this.mementos = new ArrayList<Memento>();
		this.currentMementoIndex = 0;
		this.register();
	}

	public void register() {
		for (int i = 0; i < this.currentMementoIndex; i++) {
			this.mementos.remove(0);
		}
		this.currentMementoIndex = 0;
		this.mementos.add(this.currentMementoIndex, this.game.createMemento());
	}

	public void undo() {
		this.currentMementoIndex++;
		this.game.set(this.getCurrentMemento());
	}

	public void redo() {
		this.currentMementoIndex--;
		this.game.set(this.getCurrentMemento());
	}

	public boolean isUndoable() {
		return this.currentMementoIndex < this.mementos.size() - 1;
	}

	public boolean isRedoable() {
		return this.currentMementoIndex > 0;
	}

	public void reset() {
		this.mementos = new ArrayList<Memento>();
		this.currentMementoIndex = 0;
    }

	private Memento getCurrentMemento(){
		return this.mementos.get(this.currentMementoIndex);
	}

}