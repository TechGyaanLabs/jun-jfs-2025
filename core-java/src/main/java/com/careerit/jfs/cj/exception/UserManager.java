package com.careerit.jfs.cj.exception;

public class UserManager {

    public static void main(String[] args) {

            UserService service = new UserService();
            try {
                String result = service.loginUser("charan@careerit.com", "charan@123");
                System.out.println(result);
            }catch (UserNotFoundException e) {
                System.out.println(e.getMessage());
            }catch (BadCredentitalException e){
                // Send unauthorized response to the client via email or sms
                System.out.println(e.getMessage());
            }

    }
}
