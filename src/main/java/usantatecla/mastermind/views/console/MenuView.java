package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.utils.WithConsoleView;

class MenuView extends WithConsoleView {

        void interact(PlayController playController) {

                ConsoleMenu menu = new ConsoleMenu(playController);
                menu.execute();
        }
}