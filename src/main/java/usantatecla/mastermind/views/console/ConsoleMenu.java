package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.Menu;

public class ConsoleMenu extends Menu
{
    public ConsoleMenu(PlayController playController) {
        super(MessageView.MENU_TITLE.getMessage());
		this.addCommand(new ProposeCombinationCommand(playController));
		this.addCommand(new UndoCommand(playController));
		this.addCommand(new RedoCommand(playController));
	}
}