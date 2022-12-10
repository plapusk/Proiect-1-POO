package admin;

import input.Input;

public class CommandExecute {
    PageHandler pageHandler;
    Input input;
    public CommandExecute(Input input) {
        this.input = input;
        pageHandler = new PageHandler();
        UserDataBase.getInstance().newArray();
    }
}
