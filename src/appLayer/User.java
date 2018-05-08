package appLayer;

public class User {

    public boolean isValidUser(String sUserName, String sUserPassword){
        if(sUserName.equals("nikos")&& sUserPassword.equals("123")){
            return true;
        }else{
            return false;
        }
    }

}
