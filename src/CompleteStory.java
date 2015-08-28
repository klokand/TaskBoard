/**
 *
 * @author markxi
 * Class for implement Complete story command
 */
public class CompleteStory implements CommandChain {

     private CommandChain nextInChain;
     private Stories storyList;

    @Override
    public void setNextCommandChain(CommandChain nextCommandChain) {
        this.nextInChain = nextCommandChain;
    }

    @Override
    public void commandActing(Command request, Stories newStoryList) {
        if("complete story".equals(request.getCommandString()) &&request.getCommandParameter1()!=null&&request.getCommandParameter2()==null&&request.getCommandParameter3()==null){
            this.storyList = newStoryList;
            this.storyList.completeStory(new Story(request.getCommandParameter1(),"data"));
            //System.out.println("Story "+request.getCommandParameter1()+"has been completed");
        }else{
            this.nextInChain.commandActing(request,newStoryList);
        }
    }
}
