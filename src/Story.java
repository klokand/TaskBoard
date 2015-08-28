
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author markxi
 * class of the second lever of data structure. 
 */
public class Story {
    ArrayList taskList = new ArrayList();//array list holding all the tasks
    
    String storyId;
    String storyDesp;
    boolean storyState = false;//the story has been completed.
    
    public Story(String newId, String newDesp){
        this.storyId = newId;
        this.storyDesp = newDesp;
    }
    public String getStoryId(){return this.storyId;}
    public String getStoryDesp(){return this.storyDesp;}
    public boolean getStoryState(){return this.storyState;}
    public ArrayList getTaskList(){return this.taskList;}
    //displaying the story state accordingly
    public String printStoryState(){
        if(!this.getStoryState()){
            return "incomplete";
        }else{
            return "complete";
        }
    }
    //complete story if is hasn't been completed
    public void completeStory(){
        if(this.storyState == true){
            System.out.println("Invalide action, Story was completed");
        }else if(!this.checkHasTask()){
            System.out.println("Please add and finish Task first, before you can complete the task.");
        }else if(this.checkTasksAllDone()){
            this.storyState = true;
            System.out.println("Story is completed now");
        }else{
            System.out.println("Please finish all the Tasks, then you can complete the task.");
        }
        
    }
    //caculate the numbers of finished tasks
    private int getDoneTaskNumber(){
        int temp =0;
        Iterator taskIterator = this.taskList.iterator();
        while(taskIterator.hasNext()){
            Task taskInfo = (Task)taskIterator.next();
            if(taskInfo.getTaskColumn().equals("Done")){
                temp++;
            }
        }
        return temp;
    }
    //check whether all the sub tasks have been finished.
    private boolean checkTasksAllDone(){
        boolean temp = false;
        if(this.getDoneTaskNumber()==this.getTaskList().size()){
            temp = true;
        }
        return temp;
    }
    
    //check whether story has task.
    private boolean checkHasTask(){
        boolean temp = false;
        if(this.getTaskList().size()>0){
            temp = true;
        }
        return temp;
    }
    
    private void addTask(Task newTask){
        if(this.getStoryState()){
            this.storyState = false;
        }
        this.taskList.add(newTask);
    }
    private void removeTask(Task newTask){
        Task temp = this.getTask(newTask);
        this.taskList.remove(temp);
    }
    //update task assuming it has the task
    public void updateTask(Task newTask){
        if(this.checkTask(newTask)){
            this.getTask(newTask).updateTask(newTask.getTaskDesp());
        }else{
            System.out.println("Task doesn't exist at all");
        }
    }
    
    public void moveTask(Task newTask,String newColumn){
        if(this.checkTask(newTask)){
            Task temp = this.getTask(newTask);
            temp.moveTask(newColumn);
           //System.out.println("Updated successfully");
        }else{
            System.out.println("Task doesn't exist at all");
        }
    }
    
    public Task getTask(int taskIndex){
        return (Task)this.taskList.get(taskIndex);
    }
    //the newTask is actually a fack class which only has correct taskId, and return the correspondented Task instance.
    private Task getTask(Task newTask){
        Iterator taskIterator = this.taskList.iterator();
        Task temp = null;
        while(taskIterator.hasNext()){
            Task taskInfo =(Task)taskIterator.next();
            if(taskInfo.getTaskId().equals(newTask.getTaskId())){
              temp = taskInfo;
            }
        }
        return temp;
    }
    public void displayStoryInfo(){
        System.out.println(this.getStoryId()+": "+this.getStoryDesp()+" "+this.printStoryState());
        Iterator taskIterator = this.taskList.iterator();
        while(taskIterator.hasNext()){
            Task taskInfo = (Task)taskIterator.next();
            taskInfo.displayTaskInfo();
        }
    }
    
    //check whether or not has this task
    private boolean checkTask(Task newTask){
        boolean temp = false;
        Iterator taskIterator = this.taskList.iterator();
        while(taskIterator.hasNext()){
            Task taskInfo =(Task)taskIterator.next();
            if(taskInfo.getTaskId().equals(newTask.getTaskId())){
               temp = true;
            }
        }
        return temp;
    }
    public void createTask(Task newTask){
        if(this.checkTask(newTask)){
            System.out.println("Task has existed already");
        }else{
            this.addTask(newTask);
             System.out.println("Create successfully");
        }
    }
    
    public void deleteTask(Task newTask){
        if(this.checkTask(newTask)){
            this.removeTask(newTask);
            System.out.println("Deleted successfully");
        }else{
            System.out.println("Task doesn't exist at all");
        }
    }
}
