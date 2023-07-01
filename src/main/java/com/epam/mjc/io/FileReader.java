package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (FileInputStream fis = new FileInputStream(file)){
            String fileContent = "";
            int c;
            while ((c = fis.read()) != -1){
                fileContent += (char)c;
            }
            String[] fileContentSplit = fileContent.split("\n");
            /*
            NOTE: Doesn't work with String[] fileContentSplit = fileContent.split(" ");
            Does print out the content just fine when in a loop:
                for (String element : fileContentSplit) {
                    System.out.println(element);
                }
            But fileContentSplit[i] doesn't print out the correct value
            dunno why
            */
            String name = fileContentSplit[0].split(":")[1].trim();
            Integer age = Integer.parseInt(fileContentSplit[1].split(":")[1].trim());
            String email = fileContentSplit[2].split(":")[1].trim();
            Long phone = Long.parseLong(fileContentSplit[3].split(":")[1].trim());

            return new Profile(name, age, email, phone);
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
        return new Profile();
    }
}
