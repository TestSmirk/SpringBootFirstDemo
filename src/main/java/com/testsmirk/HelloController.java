package com.testsmirk;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.testsmirk.model.ClassmateModel;
import com.testsmirk.model.ErrorModel;
import com.testsmirk.model.GiftsModel;
import com.testsmirk.model.MessageModel;
import com.testsmirk.model.friend.FriendModel;
import com.testsmirk.model.friend.NewFriend;
import com.testsmirk.model.room.CommentModel;
import com.testsmirk.model.room.GroupDetailModel;
import com.testsmirk.model.room.MemberModel;
import com.testsmirk.model.room.RoomModel;
import com.testsmirk.queue.PrintTask;
import com.testsmirk.queue.TaskQueue;
import com.testsmirk.utils.Images;
import com.testsmirk.utils.Strings;
import com.testsmirk.utils.TextUtil;
import com.testsmirk.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by testsmirk on 17-1-27.
 */
@RestController
public class HelloController {
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if(ip.equals("127.0.0.1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip= inet.getHostAddress();
            }
        }
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ip != null && ip.length() > 15){
            if(ip.indexOf(",")>0){
                ip = ip.substring(0,ip.indexOf(","));
            }
        }
        return ip;
    }
    @Autowired
    private GirlProperties girlProperties;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"/hello", "/hi"}, method ={RequestMethod.POST,RequestMethod.GET})
    public User say(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age) {
        System.out.println("HelloController.say " + name + "   age " + age);
        User s = new User(name, age);
        userRepository.save(s);
        userRepository.findByUsername(name);

        TaskQueue taskQueue = new TaskQueue(1);
        taskQueue.start();

        for (int i = 0; i < 10; i++) {
            PrintTask printTask = new PrintTask(i);
            taskQueue.add(printTask);
        }
        return s;
    }

    @RequestMapping(value = "/statisic")
    public User statisic(){
        System.out.println("statisic " );


        return new User("smirk",-1);
    }
    @Configuration
    public class CORSConfiguration {
        @Bean
        public WebMvcConfigurer corsConfigurer() {

            //this is allow all remote client to access
            return new WebMvcConfigurerAdapter() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**")
                            .allowedHeaders("*")
                            .allowedMethods("*")

                            .allowedOrigins("*");
                }
            };
        }
    }

    //查询
    @RequestMapping(value = "getuser", method = RequestMethod.GET)
    public User getUser(@RequestParam(value = "id") String id) {
        System.out.println(id);
        return null;


    }
    //192.168.3.116

    private String ObjId = "ObjectId(\"%s\")";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = {"getGift"})
    public Object getGift() {
        GiftsModel giftsModel = new GiftsModel();
        giftsModel.setCode(200);
        giftsModel.setResult(true);
        ArrayList<GiftsModel.EntitiesBean> gifts = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            GiftsModel.EntitiesBean entities = new GiftsModel.EntitiesBean("", i, "", i, "icon $i", "i $i", "i $i", "i $i", 10.0);

            gifts.add(entities);
        }
        giftsModel.setEntities(gifts);
        return giftsModel;
    }

    @RequestMapping(value = {"del_hello"}, method = RequestMethod.DELETE)
    public User delHello(@RequestParam(value = "id") String id) {
        String _id = String.format(ObjId, id);
        userRepository.save(new User(id, id));

        return null;

    }

    @RequestMapping(value = {"/login"}, method = {RequestMethod.POST})
    private Object login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password

    )

    {
        logger.debug(username + "  " + password);

        return true;
    }

    @RequestMapping(value = {"/getNews"}, method = RequestMethod.GET)
    public Object getMessage() {
        ArrayList<ClassmateModel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            ClassmateModel classmateModel = new ClassmateModel();
            classmateModel.setTime(System.currentTimeMillis() + "");
            String name = Utils.getName(Strings.CONTENTS);
            classmateModel.setToppicTitle(name.substring(0, name.length() / 2
            ));
            classmateModel.setName(Utils.getName(Strings.NAMES));
            classmateModel.setComCount(2);
            classmateModel.setGender((((int) (Math.random() * 10)) % 2));
            classmateModel.setHeadImage(Images.images[Utils.randomRound(0, Images.images.length)]);
            classmateModel.setContent(Utils.getName(Strings.CONTENTS));
            ArrayList<String> urls = new ArrayList<>();
            switch (i) {
                case 0:
                    urls.add("http://i0.kym-cdn.com/photos/images/newsfeed/001/239/957/140.jpg");
                    urls.add("http://i3.kym-cdn.com/photos/images/masonry/001/009/437/5c7.jpg");
                    urls.add("https://cdn.suwalls.com/wallpapers/meme/dogecoin-31155-400x250.jpg");
                    urls.add("https://cdn.suwalls.com/wallpapers/computers/doge-windows-8-1-27993-400x250.jpg");
                    urls.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2812025359,799095506&fm=23&gp=0.jpg");
                    urls.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=947982974,538813931&fm=23&gp=0.jpg");
                    urls.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1255488850,1302294790&fm=23&gp=0.jpg");
                    urls.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4141222872,4082859514&fm=23&gp=0.jpg");
                    urls.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4141222872,4082859514&fm=23&gp=0.jpg");
                    break;
                case 1:

                    urls.add("http://i1.kym-cdn.com/photos/images/newsfeed/001/239/941/d56.jpg");
                    urls.add("http://i0.kym-cdn.com/photos/images/masonry/000/954/349/a28.jpg");
                    break;
                case 2:
                    urls.add("http://i2.kym-cdn.com/photos/images/newsfeed/001/236/052/f83.jpg");
                    break;
                case 3:
                    urls.add("http://i0.kym-cdn.com/photos/images/newsfeed/001/231/591/f4a.jpg");
                    break;
                case 4:
                    urls.add("http://i3.kym-cdn.com/photos/images/masonry/001/109/775/e75.jpg");
                    break;
                case 5:
                    urls.add("http://i1.kym-cdn.com/photos/images/masonry/001/100/503/eb8.png");
                    break;
                case 6:

                    urls.add("http://i3.kym-cdn.com/photos/images/masonry/001/045/739/216.jpg");
                    break;
                case 7:
                    urls.add("http://i1.kym-cdn.com/photos/images/masonry/001/026/682/528.jpg");
                    break;
            }
            List<CommentModel> commentModels = new ArrayList<>();
            for (int j = 0; j < 20; j++) {
                CommentModel e = new CommentModel();
                e.setContent("评论问的额二位请问 " + i);
                e.setFromName("名字 " + i);
                commentModels.add(e);
            }
            classmateModel.setCommentModels(commentModels);
            classmateModel.setImageUrl(urls);
            list.add(classmateModel);
        }
        return list;

    }

    @RequestMapping(value = {"/getFriend"}, method = RequestMethod.GET)
    public Object getFriend() {
        NewFriend newfriend = new NewFriend();
        List<FriendModel> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            FriendModel friendModel = new FriendModel();
            friendModel.setDate(System.currentTimeMillis() + "");
            friendModel.setHeadImage(Images.images[i]);
            friendModel.setFriendAddCouse(i % 3);
            friendModel.setName("this is name " + i);
            friendModel.setFromContent("早上啊是滴噢接啊温江区了拉我去" + i);
            friendModel.setFromName("from name " + i);
            friendModel.setUnReadMessage(i);
            list.add(friendModel);
        }

        newfriend.setFriendModel(list);
        newfriend.setNewFriend((int) (Math.random() * 100));
        return newfriend;
    }


    @RequestMapping(value = {"/regist"}, method = RequestMethod.POST)

    public Object regist(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {

        if (userRepository.findByUsername(username) != null) {
            return new ErrorModel("用户已存在", 2);


        } else {
            if (!TextUtil.isEmpty(username) && !TextUtil.isEmpty(password)) {
                User user = new User(username, password);
                userRepository.save(user);
                MessageModel messageModel = new MessageModel();
                messageModel.setMessage("success");
                messageModel.setCode(getCode());
                return messageModel;
            }
        }
        return new ErrorModel();

    }

    private int getCode() {
        return 0;
    }

    @RequestMapping(value = {"/getGroupDetail"})
    public Object getGroupDetail() {
        GroupDetailModel groupDetailModel = new GroupDetailModel();
        groupDetailModel.setGroupArea("河南省  洛阳市");
        groupDetailModel.setGroupGrade("四年级三班");
        groupDetailModel.setGroupIcon(Utils.getImages(Images.images));
        groupDetailModel.setGroupID("443965");
        groupDetailModel.setGroupMyName("张小花");
        groupDetailModel.setGroupSchool("洛阳外国语学院");
        ArrayList<MemberModel> memberModels = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            MemberModel memberModel = new MemberModel();
            memberModel.setId("1000" + 1);
            memberModel.setImagePic(Utils.getImages());
            memberModel.setLevel(i % 3);
            memberModel.setName(Utils.getName());
            memberModel.setSign(Utils.randomRound(0, 3) + "");
            memberModels.add(memberModel);
        }

        groupDetailModel.setMemberModel(memberModels);
        return groupDetailModel;

    }

    @RequestMapping(value = {"/getRoom"}, method = RequestMethod.GET)
    public Object getRoom() {


        ArrayList<RoomModel> rooms = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            RoomModel e = new RoomModel();
            e.setCount(i);
            e.setFromContent(Strings.CONTENTS[Utils.randomRound(0, Strings.CONTENTS.length)]);
            e.setFromName(Strings.NAMES[Utils.randomRound(0, Strings.NAMES.length)]);
            e.setImage(Images.images[Utils.randomRound(0, Images.images.length)]);
            e.setName(Strings.NAMES[Utils.randomRound(0, Strings.NAMES.length)]);
            e.setUnReadCount((int) (Math.random() * 10));
            rooms.add(e);
        }
        return rooms;
    }
}
