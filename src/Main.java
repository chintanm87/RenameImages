import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String toReplace1 = " "; // default space
        String toReplace2 = "_"; // default space
        String replacedBy = "-"; // replaced by
        String[] extensions = {"jpg", "jpeg", "png"};
        //String destDir = ''
        String currentWorkingDir = System.getProperty("user.dir");

        System.out.println(currentWorkingDir);
        File folder = new File(currentWorkingDir);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            String currentFileName = listOfFiles[i].getName();
            if (listOfFiles[i].isFile() && stringContainsItemFromList(currentFileName, extensions)) {
                //System.out.println(currentWorkingDir + currentFileName);
                File f = new File(currentWorkingDir+ File.separator + currentFileName);
                //System.out.println(listOfFiles[i].getName());
                String newName = currentFileName.replaceAll(toReplace1, replacedBy);
                newName = newName.replaceAll(toReplace2, replacedBy);
                newName = newName.toLowerCase();

                f.renameTo(new File(currentWorkingDir + File.separator + newName));
            }
        }

        System.out.println("Done");

    }

    public static boolean stringContainsItemFromList(String inputStr, String[] items) {
        for (int i = 0; i < items.length; i++) {
            if (inputStr.contains(items[i])) {
                return true;
            }
        }
        return false;
    }

}
