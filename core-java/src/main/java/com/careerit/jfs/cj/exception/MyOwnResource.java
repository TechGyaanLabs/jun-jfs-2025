package com.careerit.jfs.cj.exception;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;

public class MyOwnResource implements Closeable {

    private BufferedReader reader;
    private FileReader fileReader;

    public MyOwnResource(String filePath) throws IOException {
        filePath = MyOwnResource.class.getResource(filePath).getPath();
        fileReader = new FileReader(filePath);
        reader = new BufferedReader(fileReader);
    }

    public void showFileContent() throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    @Override
    public void close() throws IOException {
        System.out.println("Trying to close the resources");
        try{
            if(reader != null)
                reader.close();
            if(fileReader != null)
                fileReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Successfully closed the resources");
    }
}
