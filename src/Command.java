/**
 *
 * @author markxi
 * This class is taking input commands.
 */
public class Command {
    private String commandString;// holding the action command.
    private String commandParameter1;// holding the first parameter.
    private String commandParameter2;//holding the second parameter.
    private String commandParameter3;//holding the third parameter.
    
    public Command(String newCommand){
        this.commandString = newCommand;
    }
    public Command(String newCommand, String newCP){
        this.commandParameter1 = newCP;
        this.commandString = newCommand;
    }
    public Command(String newCommand, String newCP1,String newCP2){
        this.commandParameter1 = newCP1;
        this.commandParameter2 = newCP2;
        this.commandString = newCommand;
    }
    public Command(String newCommand, String newCP1,String newCP2,String newCP3){
        this.commandParameter1 = newCP1;
        this.commandParameter2 = newCP2;
        this.commandParameter3 = newCP3;
        this.commandString = newCommand;
    }
    
    public String getCommandParameter1(){return this.commandParameter1;}
    public String getCommandParameter2(){return this.commandParameter2;}
    public String getCommandParameter3(){return this.commandParameter3;}
    public String getCommandString(){return this.commandString;}
    
}
