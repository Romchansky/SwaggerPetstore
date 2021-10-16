package service.commands;

import view.View;

import java.util.Map;

public abstract class RetrofitCommand implements Command {

    protected final View view;
    protected final Map<String, Command> commands;

    public RetrofitCommand(View view, Map<String, Command> commands) {
        this.view = view;
        this.commands = commands;
    }
}
