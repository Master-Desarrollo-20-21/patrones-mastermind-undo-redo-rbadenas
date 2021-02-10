package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.MessageView;

public class UndoCommand extends Command {

    protected UndoCommand(PlayController playController) {
        super(MessageView.UNDO_COMMAND.getMessage(), playController);
    }

    @Override
    public void execute() {
        this.playController.undo();
    }

    @Override
    public boolean isActive() {
        return this.playController.isUndoable();
    }
}