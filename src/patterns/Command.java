package patterns;

import java.util.HashMap;
import java.util.Map;

public interface Command {
    void excute();

    void undo();
}

class LightOnCommand implements Command {

    LightReciver lightReciver;

    public LightOnCommand(LightReciver lightReciver) {
        this.lightReciver = lightReciver;
    }

    @Override
    public void excute() {
        lightReciver.on();
    }

    @Override
    public void undo() {
        lightReciver.off();
    }
}

class LightOffCommand implements Command {

    LightReciver lightReciver;

    public LightOffCommand(LightReciver lightReciver) {
        this.lightReciver = lightReciver;
    }

    @Override
    public void excute() {
        lightReciver.off();
    }

    @Override
    public void undo() {
        lightReciver.on();
    }
}

class NoCommand implements Command {

    @Override
    public void excute() {

    }

    @Override
    public void undo() {

    }
}


class LightReciver {

    public void on() {
        System.out.println("电灯打开了");
    }

    public void off() {
        System.out.println("电灯关闭了");
    }

}

class RemoteController {

    //打开的命令
    Map<String, Command> onCommands;
    //关闭的命令
    Map<String, Command> offCommands;
    //当前的命令
    Command undoCommand;

    public RemoteController() {
        if (offCommands == null) {
            offCommands = new HashMap<>();
        }
        if (onCommands == null) {
            onCommands = new HashMap<>();
        }
        if (undoCommand == null) {
            undoCommand = new NoCommand();
        }
    }

    public void initCommand(String index, Command onCommand, Command offCommand) {
        onCommands.put(index, onCommand);
        offCommands.put(index, offCommand);
    }

    public void on(String index) {
        onCommands.get(index).excute();
        undoCommand = onCommands.get(index);
    }

    public void off(String index) {
        offCommands.get(index).excute();
        undoCommand = offCommands.get(index);
    }

    public void undo() {
        undoCommand.undo();
    }

}

class TestCommand{
    public static void main(String[] args) {

        LightReciver lightReciver = new LightReciver();
        LightOnCommand lightOnCommand = new LightOnCommand(lightReciver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReciver);

        RemoteController remoteController = new RemoteController();
        remoteController.initCommand("电灯",lightOnCommand,lightOffCommand);

        remoteController.on("电灯");
        remoteController.off("电灯");
        remoteController.undo();
    }
}