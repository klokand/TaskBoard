

/**
 *
 * @author markxi
 * class for taing quit command and stop the program
 */
public class Quit implements CommandChain {

     private CommandChain nextInChain;
     private Stories storyList;

    @Override
    public void setNextCommandChain(CommandChain nextCommandChain) {
        this.nextInChain = nextCommandChain;
    }

    @Override
    public void commandActing(Command request,Stories newStoryList) {
        if("quit".equals(request.getCommandString())&&request.getCommandParameter1()==null &&request.getCommandParameter2()==null&&request.getCommandParameter3()==null){
            this.storyList = newStoryList;
            System.out.println("Will quit program. ");
            System.exit(0);
        }else{
            System.out.println("invalide command");
        }
    }
}
