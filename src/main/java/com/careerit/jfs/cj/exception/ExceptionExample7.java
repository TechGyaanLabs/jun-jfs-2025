package com.careerit.jfs.cj.exception;

public class ExceptionExample7 {

    public static void main(String[] args) {
        try (CustomResource resource = new CustomResource()) {
            resource.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
