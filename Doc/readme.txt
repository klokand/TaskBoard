Version:1.0
Date:08/27/2015
Author:Mark Xi 
Email:xjz520223@gmail.com
---------------------------------all rights reserved for this program--------------------------------------
---------------------------------Folder structure----------------------------------------------------------
|--Doc|---|--readme.txt
|	  |--TestingOutlines.pdf	
|
|--src|---|--Command.java
	  |--CommandChain.java
	  |--CompleteStory.java
	  |--Console.java
	  |--CreateStory.java
	  |--CreateTask.java
	  |--DeleteStory.java
	  |--DeleteTask.java
	  |--InputRender.java
	  |--ListStories.java
	  |--ListTasks.java
	  |--MoveTask.java
	  |--Quit.java
	  |--Stories.java
	  |--Story.java
	  |--Task.java
	  |--UpdateTask.java
	  
---------------------------------Folder structure end------------------------------------------------------
---------------------------------Summary------------------------------------------------------------------
This program is a terminal program written in Java. There is some sample data has been initialized in the 
main class which is named as Console.java.
To run the program, just copy it into the source code folder of a new java program under any IDEs such as 
NetBeans or Eclipse, or you can compile all the java files and run the Console in any environment which 
supports java.
All the interactions within this program through commands.

Each command is case sensitive for the action command, while the first, second, and third parameters are 
surrounded by  <>, among the parameters there is no format requirements which means white-space between 
parameters is error-free.

Any action related to non-existed story and tasks is error-free.
The rules of moving a task: Done task can't be moved; only can move task column to the next column 
forward or backward.
The rules of complete a story: Story without task can't be completed; Story has any incompleted task 
can't be completed; adding new task to completed story will change the story state to incompleted.


---------------------------------Summary End--------------------------------------------------------------
---------------------------------Project Solution---------------------------------------------------------
Chain of Responsibility Design Pattern to handle different command sentences.(interface CommandChain.java) 
Singleton Design Pattern to hold the data Structure (Stories)
Data Structure( Stories-->Story-->Task)
---------------------------------Project Solution End-----------------------------------------------------
---------------------------------Commands references------------------------------------------------------
create story <id> <description>
list stories
delete story <id>
complete story <id>
create task <storyId> <id> <description>
list tasks <storyId>
delete task <storyId> <id>
move task <storyId> <id> <new column>
update task <storyId> <id> <new description>
quit
----------------------------------Commands references end-------------------------------------------------
--------------------------------Columns value references-Case Sensitive--------------------------------------------------
"To Do","In Process","To Verify","Done"
---------------------------------Columns value references end---------------------------------------------