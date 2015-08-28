

/**
 *
 * @author markxi
 * class for taking move task column command, and move the task column into different columns 
 */
public class MoveTask implements CommandChain {

     private CommandChain nextInChain;
     private Stories storyList;

    @Override
    public void setNextCommandChain(CommandChain nextCommandChain) {
        this.nextInChain = nextCommandChain;
    }

    @Override
    public void commandActing(Command request,Stories newStoryList) {
        if("move task".equals(request.getCommandString())&&request.getCommandParameter1()!=null&&request.getCommandParameter2()!=null&&request.getCommandParameter3()!=null){
            this.storyList = newStoryList;
            this.storyList.moveTask(new Story(request.getCommandParameter1(),"data"), new Task(request.getCommandParameter2(),"data"), request.getCommandParameter3());
        }else{
            this.nextInChain.commandActing(request,newStoryList);
        }
    }
}
