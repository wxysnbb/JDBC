package wd.service;

import wd.service.user.UserServiceImpl;

/**
 * 什么时候需要工厂模式？
 * 01.须要实例化很多对象
 * 02.这些对象有共同的父类或者接口
 */
public class ServiceFactory {
    //创建本类的静态对象
   private static ServiceFactory factory;

   //私有化构造
   private ServiceFactory(){}

   //静态代码块
    static{
       if(factory==null){
           synchronized (ServiceFactory.class){
               if(factory==null){
                   factory=new ServiceFactory();
               }
           }
       }
   }

   public static IBaseService getServiceImpl(String serviceName){
       IBaseService service=null;
       switch (serviceName){
           case "userService":
               service= new UserServiceImpl();
           default:
                break;
       }
        return  service;
   }
}
