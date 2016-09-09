package bean;

import com.alibaba.fastjson.JSON;
import org.bson.Document;

import java.io.Serializable;

/**
 * Created by dell_2 on 2016/9/9.
 */
public class User extends Document implements Serializable {

    private String userName;
    private String password;
    private int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
