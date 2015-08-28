/**
 *
 * @author markxi
 * class for taking Create task command
 */
public class CreateTask implements CommandChain {

     private CommandChain nextInChain;
     private Stories storyList;

    @Override
    public void setNextCommandChain(CommandChain nextCommandChain) {
        this.nextInChain = nextCommandChain;
    }

    @Override
    public void commandActing(Command request,Stories newStoryList) {
        if("create task".equals(request.getCommandString())&&request.getCommandParameter1()!=null&&request.getCommandParameter2()!=null&&request.getCommandParameter3()!=null){
            this.storyList = newStoryList;
            this.storyList.createTask(new Story(request.getCommandParameter1(),"data"), new Task(request.getCommandParameter2(),request.getCommandParameter3()));
        }else{
            this.nextInChain.commandActing(request,newStoryList);
        }
    }
}
