package usantatecla.utils;

import java.util.ArrayList;

public abstract class Menu
{
    private static final String OPTION = "----- Choose one option -----";

    private String tittle;
    private ArrayList<Command> commands;
    private Console console;

    protected Menu(String title)
    {
        this.tittle = title;
        this.commands = new ArrayList<Command>();
        this.console = new Console();
    }

    public String getTitle(){
        return this.tittle;
    }

    protected void addCommand(Command command)
    {
        this.commands.add(command);
    }

    public void execute()
    {
        ArrayList<Command> activeCommands = getActiveCommands();

        int option = getValidOptionFrom(activeCommands);

        activeCommands.get(option).execute();
    }

    private ArrayList<Command> getActiveCommands()
    {
        ArrayList<Command> activeCommands = new ArrayList<Command>();
        for (int i = 0; i < this.commands.size(); i++)
        {
            if (this.commands.get(i).isActive())
            {
                activeCommands.add(this.commands.get(i));
            }
        }

        return activeCommands;
    }

    private int getValidOptionFrom(ArrayList<Command> activeCommands)
    {
        int option;
        boolean error;
        do
        {
            error = false;
            this.console.writeln();
            this.console.writeln(Menu.OPTION);
            for (int i = 0; i < activeCommands.size(); i++)
            {
                this.console.writeln((i + 1) + ") " + activeCommands.get(i).getTitle());
            }
            option = this.console.readInt("") - 1;
            error = !isInsideInterval(option, activeCommands);
        } while (error);

        return option;
    }

    private boolean isInsideInterval(int option, ArrayList<Command> activeCommands) {
        return new ClosedInterval(0, activeCommands.size()-1).includes(option);
    }
}
