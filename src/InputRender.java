import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author markxi
 * this class is handling all the input command, and convert them into system understandable formates.
 */
public class InputRender {

    private String input;
    private String command, param1, param2, param3;
    private int checkCounter = 0;//counter for recording the number of paramenters inlcuded in the input string.

    public InputRender(String input) {
        this.input = input;
        render();
        //System.out.println(this.getParam1());
        //System.out.println(this.getParam2());
        //System.out.println(this.getParam3());
    }
    
    public String getCommand(){return this.command;}
    public String getParam1(){return this.param1;}
    public String getParam2(){return this.param2;}
    public String getParam3(){return this.param3;}
    public int getCheckCounter(){return this.checkCounter;}

    @SuppressWarnings("empty-statement")
    private void render() {
        if (input.contains("<")) {
            this.command = input.substring(0, input.indexOf("<")).trim();//get the action command
            String regex = ".*?<(.+?)>.*?";//".*\\<(.+?)\\.*>";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            List<String> temp = new ArrayList();//using regular expression to put all the paramenters inside <> into the ArrayList
            if (matcher.find()) {//loop through all the patten and render all the parameters.
                checkCounter++;
                temp.add(matcher.group(1));
                //System.out.println(temp.get(temp.size()-1));
                while (matcher.find()) {
                    temp.add(matcher.group(1));
                   // System.out.println(temp.get(temp.size()-1));
                    checkCounter++;
                }
                if(checkCounter ==1){
                    this.param1 = temp.get(0).trim();
                }else if(checkCounter ==2){
                    this.param1 = temp.get(0).trim();
                    this.param2 = temp.get(1).trim();
                }else if(checkCounter ==3){
                    this.param1 = temp.get(0).trim();
                    this.param2 = temp.get(1).trim();
                    this.param3 = temp.get(2).trim();
                }
       
            } else {
                System.out.println("not match");
            }

            //System.out.println(checkCounter);
            if (checkCounter > 3) {
                command = "invalide input";
                checkCounter = 0;
            }
            //System.out.println(command);
        } else {
            command = input.trim();
        }

    }
}
