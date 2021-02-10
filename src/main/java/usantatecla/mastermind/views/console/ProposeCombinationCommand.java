package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.MessageView;


public class ProposeCombinationCommand extends Command {

    public ProposeCombinationCommand(PlayController playController)
    {
        super(MessageView.PROPOSED_COMBINATION.getMessage(), playController);
    }

    @Override
    public void execute() {
        new ProposalView().interact(playController);
    }

    @Override
    public boolean isActive() {
        return true;
    }
    
}