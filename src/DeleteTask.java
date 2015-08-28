/**
 *
 * @author markxi
 * class for taking delete task
 */
public class DeleteTask implements CommandChain {

     private CommandChain nextInChain;
     private Stories storyList;

    @Override
    public void setNextCommandChain(CommandChain nextCommandChain) {
        this.nextInChain = nextCommandChain;
    }

    @Override
    public void commandActing(Command request,Stories newStoryList) {
        if("delete task".equals(request.getCommandString())&&request.getCommandParameter1()!=null&&request.getCommandParameter2()!=null&&request.getCommandParameter3()==null){
            this.storyList = newStoryList;
            this.storyList.deleteTask(new Story(request.getCommandParameter1(),"data"), new Task(request.getCommandParameter2(),"data"));
            //System.out.println("Task: "+request.getCommandParameter1()+" under story "+request.getCommandParameter2()+" has been deleted");
        }else{
            this.nextInChain.commandActing(request,newStoryList);
        }
    }
}
