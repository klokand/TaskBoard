
/**
 *
 * @author markxi
 * class for presenting all the stories and the tasks under it.
 */
public class ListStories implements CommandChain {
    
    private CommandChain nextInChain;
    private Stories storyList;

    @Override
    public void setNextCommandChain(CommandChain nextCommandChain) {
        this.nextInChain = nextCommandChain;
    }

    @Override
    public void commandActing(Command request,Stories newStoryList) {
        if("list stories".equals(request.getCommandString())&&request.getCommandParameter1()==null&&request.getCommandParameter2()==null&&request.getCommandParameter3()==null){
            this.storyList = newStoryList;
            storyList.displayTaskBorad();
        }else{
            this.nextInChain.commandActing(request,newStoryList);
        }
    }
    
}
