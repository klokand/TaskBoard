

/**
 *
 * @author markxi
 * class for taking list tasks command to present all the tasks under particular story
 */
public class ListTasks implements CommandChain {

     private CommandChain nextInChain;
     private Stories storyList;

    @Override
    public void setNextCommandChain(CommandChain nextCommandChain) {
        this.nextInChain = nextCommandChain;
    }

    @Override
    public void commandActing(Command request,Stories newStoryList) {
        if("list tasks".equals(request.getCommandString())&&request.getCommandParameter1()!=null&&request.getCommandParameter2()==null&&request.getCommandParameter3()==null){
            this.storyList = newStoryList;
            this.storyList.listTask(new Story(request.getCommandParameter1(),"data"));
        }else{
            this.nextInChain.commandActing(request,newStoryList);
        }
    }
    
}
