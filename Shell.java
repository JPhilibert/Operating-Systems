import java.util.*;
import java.io.*;

public class Shell
{
    public static void main(String[] args)
    {
        Scanner keys = new Scanner(System.in);
        String command = "";
        String input = "";
        String name = "";
        Boolean run = true;
        String dir = "/home/ubuntu/workspace/";
        
        System.out.println("welcome to jonahshell");
        while(run)
        {
            System.out.print("jonahshell>");
            String[] full_command = keys.nextLine().split(" ");
            
            input = full_command[0];
            if(full_command.length == 2){
                name = full_command[1];
            }
            
            if(input.equals("l") || input.equals("list")) {
                list(dir); //lists contents of current directory
                
            }else if(input.equals("d") || input.equals("down")) 
            {
                Boolean exists = false;
                if(name.equals("")) {
                    System.out.println("don't forget to write the name of the directory");
                }else{
                    File f = new File(dir);
                    String[] path_names = f.list();
                    
                    for(String path:path_names) {
                        if(path.equals(name)) {
                            exists = true;
                        }
                    }
                    
                    if(exists) {
                        dir = dir + name + "/";
                    }else{
                        System.out.println("directory doesn't exist");
                    }                    
                }
                
            }else if(input.equals("u") || input.equals("up")) {
                
                String[] newDir = dir.split("/");
                dir = "";
                for(int i= 1; i < newDir.length-1; i++)
                {
                    dir = dir + "/" + newDir[i];
                }
                dir += "/";
                System.out.println(dir);
            
            }else if(input.equals("w") || input.equals("wai")) 
            {
                System.out.println(dir);
                
            }else if(input.equals("e") || input.equals("exit")) {
                run = false;
                
            }else{
                help();
            }
        }
    }
    public static void list(String directory)
    {
        File[] paths;
        String[] path_names;
        File f = null;
        
        try{
            f = new File(directory);
            
            paths = f.listFiles();
            path_names = f.list();
            
            for(int i=0; i < paths.length; i++) {
                if(paths[i].isFile()) {
                    System.out.print("(f) ");
                }
                if(paths[i].isDirectory()) {
                    System.out.print("(d) ");
                }
                System.out.println(path_names[i]);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void help()
    {
        System.out.println("(l)ist: lists contents of current directory \n(d)own [dir]: moves into the specified child directory \n(u)p: moves to the parent directory \n(w)ai: prints the current directory \n(e)xit: exits the shell \n(h)elp: prints a list of the supported commands");
    }
}