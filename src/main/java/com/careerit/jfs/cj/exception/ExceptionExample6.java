package com.careerit.jfs.cj.exception;

public class ExceptionExample6 {

    public static void main(String[] args) {

        try(MyOwnResource resource = new MyOwnResource("/sampledata.txt")) {
            resource.showFileContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
