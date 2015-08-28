/**
 *
 * @author markxi
 * this is the main class.
 */
import java.util.Scanner;
public class Console {
    public static void main(String[] args){
        //initiallize each command chain which will do its job individually.
        CommandChain commandC1 = new CompleteStory();
        CommandChain commandC2 = new CompleteStory();
        CommandChain commandC3 = new CreateStory();
        CommandChain commandC4 = new CreateTask();
        CommandChain commandC5 = new DeleteStory();
        CommandChain commandC6 = new DeleteTask();
        CommandChain commandC7 = new ListStories();
        CommandChain commandC8 = new ListTasks();
        CommandChain commandC9 = new MoveTask();
        CommandChain commandC10 = new UpdateTask();
        CommandChain commandFinal = new Quit();
        //link them up with the command chain.
        commandC1.setNextCommandChain(commandC2);
        commandC2.setNextCommandChain(commandC3);
        commandC3.setNextCommandChain(commandC4);
        commandC4.setNextCommandChain(commandC5);
        commandC5.setNextCommandChain(commandC6);
        commandC6.setNextCommandChain(commandC7);
        commandC7.setNextCommandChain(commandC8);
        commandC8.setNextCommandChain(commandC9);
        commandC9.setNextCommandChain(commandC10);
        commandC10.setNextCommandChain(commandFinal);
       
        //create the test story data
        Story findJob = new Story("1","Finding a job");
        Story buyHouse = new Story("2","Buying a house");
        Stories storyList = Stories.getStories();
        //create the test tasks data and add them in different story data
        storyList.createStory(findJob);
        findJob.createTask(new Task("1","write resume."));
        findJob.createTask(new Task("2","search online."));
        findJob.createTask(new Task("3","apply job."));
        findJob.createTask(new Task("4","take interview."));
        storyList.createStory(buyHouse);
        buyHouse.createTask(new Task("1","get money"));
        
        
        //Command request = new Command("quit");
        //commandC1.commandActing(request);
        
        Scanner userInput = new Scanner(System.in);
        System.out.println("please type in your command");
        while(userInput.hasNextLine()){ //scan and taking input command ended with enter
            String inputString = userInput.nextLine().toString();
            InputRender inputRender = new InputRender(inputString);
            Command request = null;
            //decide which Command object shall be created according to the nubmer of parameters
           if(inputRender.getCheckCounter()==0){
              request = new Command(inputRender.getCommand());
           }else if(inputRender.getCheckCounter()==1){
              request = new Command(inputRender.getCommand(),inputRender.getParam1());
           }else if(inputRender.getCheckCounter()==2){
              request = new Command(inputRender.getCommand(),inputRender.getParam1(),inputRender.getParam2());
           }else if(inputRender.getCheckCounter()==3){
              request = new Command(inputRender.getCommand(),inputRender.getParam1(),inputRender.getParam2(),inputRender.getParam3());
           }
            commandC1.commandActing(request,storyList);
            System.out.println("please type in your command");
        }
    }
}
