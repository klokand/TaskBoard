/**
 *
 * @author markxi
 * the lowest lever of data structure. 
 */
public class Task{
    String[]taskColumns ={"To Do","In Process","To Verify","Done"};// all the columns strings
    String taskId;
    String taskDesp;
    String taskColumn =taskColumns[0];
    
    
    
    public Task(String newTaskId, String newTaskDesp){
        this.taskId = newTaskId;
        this.taskDesp = newTaskDesp;
    }
    public String getTaskId(){return this.taskId;}
    public String getTaskDesp(){return this.taskDesp;}
    public String getTaskColumn(){return this.taskColumn;}
    
    //update the task's description.
    public void updateTask(String newDesp){
        this.taskDesp = newDesp;
        System.out.println("Updated successfully");
    }
    //the mechanism for deciding the rules of column moveing. 
    public void moveTask(String newColumn){
         if(checkNewColumn(newColumn)){
             int newIndex = this.getColumnIndex(newColumn);
             int currentIndex = this.getColumnIndex(this.taskColumn);
             int distance = Math.abs(newIndex-currentIndex);
             if(currentIndex ==newIndex){//if new column equals to current one, error message
                 System.out.println("Can't move the column, as the current column equals to new column.");
             }else if(currentIndex==3){//if the current column is done, error message.
                 System.out.println("Can't move column, as the task has been finished.");
             }else if(distance==1){//if only move to next column forward or backword.
                 this.setColumn(newColumn);
                 System.out.println("Move successful");
             }else {
                 System.out.println("Invalide move");
             }
             
         }else{
             System.out.println("The new column name is invalide");
         }  
    }
    //check if the input column is contained in the column array
    private boolean checkNewColumn(String newColumn){
        boolean temp=false;
        for(int i=0;i<4;i++){
            if(this.taskColumns[i].equals(newColumn)){
                temp = true;
            }
        }
        return temp;
    }
    private void setColumn(String newColumn){
        this.taskColumn = newColumn;
    }
    private int getColumnIndex(String newColumn){
        int temp = 0;
        for(int i=0;i<4;i++){
            if(this.taskColumns[i].equals(newColumn)){
                temp = i;
            }
        }
        return temp;
    }
    
    public void displayTaskInfo(){
        System.out.println("  "+getTaskId()+": "+getTaskDesp()+" "+getTaskColumn());
    }
  
}
