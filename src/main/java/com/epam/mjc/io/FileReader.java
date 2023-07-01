package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (FileInputStream fis = new FileInputStream(file)){
            String file_content = "";
            int c;
            while ((c = fis.read()) != -1){
                file_content += (char)c;
            }
            String[] file_content_split = file_content.split("\n");
            /*
            NOTE: Doesn't work with String[] file_content_split = file_content.split(" ");
            Does print out the content just fine when in a loop:
                for (String element : file_content_split) {
                    System.out.println(element);
                }
            But file_content_split[i] doesn't print out the correct value
            dunno why
            */
            String name = file_content_split[0].split(":")[1].trim();
            Integer age = Integer.parseInt(file_content_split[1].split(":")[1].trim());
            String email = file_content_split[2].split(":")[1].trim();
            Long phone = Long.parseLong(file_content_split[3].split(":")[1].trim());

            Profile profile = new Profile(name, age, email, phone);

            return profile;
        }
        catch(FileNotFoundException fnfe){
            System.out.println("File not found\n");
        }
        catch (IOException ioe){
            System.out.print(ioe.getMessage());
        }
        return new Profile();
    }
}
