package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.MessageView;

public class RedoCommand extends Command {

    protected RedoCommand(PlayController playController) {
        super(MessageView.REDO_COMMAND.getMessage(), playController);
    }

    @Override
    public void execute() {
        this.playController.redo();
    }

    @Override
    public boolean isActive() {
        return this.playController.isRedoable();
    }
}