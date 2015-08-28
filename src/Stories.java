
import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author markxi
 * class the father of the data structure of this program which uses a Arraylist to take all the stories.
 */
public class Stories {
    private static Stories stories = null;
    
    ArrayList storyList = new ArrayList();//arraylist for holding all the stories.
    
    private Stories(){}
    
    //this class is a singleton patten and only one class can be created.
    public static Stories getStories(){
        if(stories == null){
            stories = new Stories();
        }
        return stories;
    }
    public ArrayList getStoryList(){
        return this.storyList;
    }
    private void addStory(Story newStory){
        this.storyList.add(newStory);
    }
    private void removeStory(Story newStory){
        Story temp = this.getStory(newStory);
        this.storyList.remove(temp);
    }
    
    //check whether or not contains the story
    private boolean checkStory(Story newStory){
        boolean temp = false;
        Iterator storyIterator = this.storyList.iterator();
        while(storyIterator.hasNext()){
            Story storyInfo =(Story)storyIterator.next();
            if(storyInfo.getStoryId().equals(newStory.getStoryId())){
               temp = true;
            }
        }
        return temp;
    }
    //create task under particular story, if story didn't be find, return error message
    public void createTask(Story newStory,Task newTask){
        if(checkStory(newStory)){
            this.getStory(newStory).createTask(newTask);
        }else{
            System.out.println("Story doesn't exist at all");
        }
    }
    
    //delete Task under particualr story
    public void deleteTask(Story newStory,Task newTask){
        if(checkStory(newStory)){
            this.getStory(newStory).deleteTask(newTask);
        }else{
            System.out.println("Story doesn't exist at all");
        }
    }
    //update task under particular story
        public void updateTask(Story newStory,Task newTask){
        if(checkStory(newStory)){
            this.getStory(newStory).updateTask(newTask);
        }else{
            System.out.println("Story doesn't exist at all");
        }
    }
    //get the story from the arraylist 
    private Story getStory(Story newStory){
        Story temp = null;
        Iterator storyIterator = this.storyList.iterator();
        while(storyIterator.hasNext()){
            Story storyInfo =(Story)storyIterator.next();
            if(storyInfo.getStoryId().equals(newStory.getStoryId())){
               temp = storyInfo;
            }
        }
        return temp;
    }
    //create story if it hasn't been created
    public void createStory(Story newStory){
        if(checkStory(newStory)){
            System.out.println("Story has existed already");
        }else{
            this.addStory(newStory);
            System.out.println("Create successfully");
        }
    }
    //delete story
    public void deleteStory(Story newStory){
        if(checkStory(newStory)){
            this.removeStory(newStory);
            System.out.println("Deleted successfully");
        }else{
            System.out.println("Story doesn't exist at all");
        }
    }
    //get the required story then move the particular task's column
    public void moveTask(Story newStory,Task newTask, String newColumn){
        if(checkStory(newStory)){
            this.getStory(newStory).moveTask(newTask, newColumn);    
        }else{
            System.out.println("Story doesn't exist at all");
        }
    }
    //complete the particlar story
    public void completeStory(Story newStory){
         if(checkStory(newStory)){
            this.getStory(newStory).completeStory();
        }else{
            System.out.println("Story doesn't exist at all");
        }
    }
    //display all the information
    public void displayTaskBorad(){
        Iterator storyIterator = this.storyList.iterator();
        while(storyIterator.hasNext()){
            Story storyInfo = (Story)storyIterator.next();
            storyInfo.displayStoryInfo();
        }
    }
    //list all the task information under particular story
    public void listTask(Story newStory) {
        if (checkStory(newStory)) {
            for (int i = 0; i < this.storyList.size(); i++) {
                Story storyTemp = (Story) this.storyList.get(i);
                if (storyTemp.getStoryId().equals(newStory.getStoryId())) {
                    storyTemp.displayStoryInfo();
                }
            }
        } else {
            System.out.println("Story has existed already");
        }
    }
    
}
