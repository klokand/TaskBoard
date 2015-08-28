/**
 *
 * @author markxi
 * this class is taking Create story command
 */
public class CreateStory implements CommandChain {

     private CommandChain nextInChain;
     private Stories storyList;

    @Override
    public void setNextCommandChain(CommandChain nextCommandChain) {
        this.nextInChain = nextCommandChain;
    }

    @Override
    public void commandActing(Command request,Stories newStoryList) {
        if("create story".equals(request.getCommandString())&&request.getCommandParameter1()!=null &&request.getCommandParameter2()!=null&&request.getCommandParameter3()==null){
            this.storyList = newStoryList;
            this.storyList.createStory(new Story(request.getCommandParameter1(),request.getCommandParameter2()));
        }else{
            this.nextInChain.commandActing(request,newStoryList);
        }
    }
}
