/**
 *
 * @author markxi
 * this is the interface for implementing Command chain design pattern.
 * if the current command can't handle the command request will pass it to the next command in the Chain.
 */
public interface CommandChain {
    public void setNextCommandChain(CommandChain nextCommandChain);
    public void commandActing(Command request,Stories storyList);
}
