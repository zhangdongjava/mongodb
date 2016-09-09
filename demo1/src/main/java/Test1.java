import bean.User;
import util.MongoDBUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试
 * Created by dell_2 on 2016/9/9.
 */
public class Test1 {
    public static void main(String[] args) {

        MongoDBUtil<User> dbUtil = new MongoDBUtil<>("test","user");
        update(dbUtil);
        dbUtil.list(User.class);
    }

    public static void update(MongoDBUtil<User> dbUtil){
        User user = new User();
        user.setUserName("zhangsan222");
        user.setAge(18);
        user.setPassword("6666");
        Map<String,String> param = new HashMap<>();
        param.put("userName","zhangsan");
        dbUtil.update(param,user);
    }
}
