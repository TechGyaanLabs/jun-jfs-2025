package com.careerit.jfs.cj.day22;

@FunctionalInterface
interface SystemInfoService{
    String getSystemInfo();
}
@FunctionalInterface
interface UserInfoService{
    String getUserInfo();
}

@FunctionalInterface
interface  I1{
    void m1();
    default  void m2(){
        System.out.println("I1 m2");
        m3();
    }
    private void m3(){
        System.out.println("I1 m3");
    }
    static void m4(){
        System.out.println("I1 m4");
        m5();
    }
    private static void m5(){
        System.out.println("I1 m5");
    }
}

@FunctionalInterface
interface  I2{
    void m1();
    default void m2(){
        System.out.println("I2 m2");
        m3();
    }
    default void m3(){
        System.out.println("I2 m3");
    }
}

class SystemDetails{

        public void showSystemInfo(SystemInfoService systemInfoService,UserInfoService userInfoService){
            System.out.println(systemInfoService.getSystemInfo());
            System.out.println(userInfoService.getUserInfo());
        }
}


public class InnerClassDemo {

    public static void main(String[] args) {

        SystemInfoService systemInfoService = new SystemInfoService() {
            @Override
            public String getSystemInfo() {
                String osName = System.getProperty("os.name");
                String osVersion = System.getProperty("os.version");
                return osName + " " + osVersion;
            }
        };
        UserInfoService userInfoService = new UserInfoService() {
            @Override
            public String getUserInfo() {
                String userName = System.getProperty("user.name");
                String userHome = System.getProperty("user.home");
                return userName + " " + userHome;
            }
        };
        SystemDetails systemDetails = new SystemDetails();
        systemDetails.showSystemInfo(systemInfoService, userInfoService);
    }
}
