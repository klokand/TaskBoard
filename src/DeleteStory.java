/**
 *
 * @author markxi
 * class for taking delete story command
 */
public class DeleteStory implements CommandChain {

     private CommandChain nextInChain;
     private Stories storyList;

    @Override
    public void setNextCommandChain(CommandChain nextCommandChain) {
        this.nextInChain = nextCommandChain;
    }

    @Override
    public void commandActing(Command request,Stories newStoryList) {
        if("delete story".equals(request.getCommandString())&&request.getCommandParameter1()!=null&&request.getCommandParameter2()==null&&request.getCommandParameter3()==null){
            this.storyList = newStoryList;
            this.storyList.deleteStory(new Story(request.getCommandParameter1(),"test"));
        }else{
            this.nextInChain.commandActing(request,newStoryList);
        }
    }
}
