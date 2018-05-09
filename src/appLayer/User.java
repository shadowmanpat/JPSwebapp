package appLayer;

import dataLayer.DB_user;

public class User {

    public boolean isValidUser(String sUserName, String sUserPassword){

//        if(sUserName.equals("nikos")&& sUserPassword.equals("123")){
//            return true;
//        }else{
//            return false;
//        }

            DB_user db_user=new DB_user();
          return   db_user.isValidUserLogin(sUserName,sUserPassword);

    }

}
