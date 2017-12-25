package com.testsmirk

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.client.MongoDatabase
import com.testsmirk.model.ClassmateModel
import com.testsmirk.model.ErrorModel
import com.testsmirk.model.GiftListBean
import com.testsmirk.model.MessageModel
import com.testsmirk.model.friend.FriendModel
import com.testsmirk.model.friend.NewFriend
import com.testsmirk.model.room.CommentModel
import com.testsmirk.model.room.GroupDetailModel
import com.testsmirk.model.room.MemberModel
import com.testsmirk.model.room.RoomModel
import com.testsmirk.utils.Images
import com.testsmirk.utils.Strings
import com.testsmirk.utils.TextUtil
import com.testsmirk.utils.Utils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

import java.util.ArrayList
import java.util.Date
import java.util.Random

/**
 * Created by testsmirk on 17-1-27.
 */
@RestController
class HelloController {
    @Autowired
    private val girlProperties: GirlProperties? = null
    @Autowired
    private val userRepository: UserRepository? = null

    private val ObjId = "ObjectId(\"%s\")"

    private val logger = LoggerFactory.getLogger(this.javaClass)

    val message: Any
        @RequestMapping(value = *arrayOf("/getNews"), method = arrayOf(RequestMethod.GET))
        get() {
            val list = ArrayList<ClassmateModel>()
            for (i in 0..9) {

                val classmateModel = ClassmateModel()
                classmateModel.time = System.currentTimeMillis().toString() + ""
                val name = Utils.getName(Strings.CONTENTS)
                classmateModel.toppicTitle = name.substring(0, name.length / 2
                )
                classmateModel.name = Utils.getName(Strings.NAMES)
                classmateModel.comCount = 2
                classmateModel.gender = (Math.random() * 10).toInt() % 2
                classmateModel.headImage = Images.images[Utils.randomRound(0, Images.images.size)]
                classmateModel.content = Utils.getName(Strings.CONTENTS)
                val urls = ArrayList<String>()
                when (i) {
                    0 -> {
                        urls.add("http://i0.kym-cdn.com/photos/images/newsfeed/001/239/957/140.jpg")
                        urls.add("http://i3.kym-cdn.com/photos/images/masonry/001/009/437/5c7.jpg")
                        urls.add("https://cdn.suwalls.com/wallpapers/meme/dogecoin-31155-400x250.jpg")
                        urls.add("https://cdn.suwalls.com/wallpapers/computers/doge-windows-8-1-27993-400x250.jpg")
                        urls.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2812025359,799095506&fm=23&gp=0.jpg")
                        urls.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=947982974,538813931&fm=23&gp=0.jpg")
                        urls.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1255488850,1302294790&fm=23&gp=0.jpg")
                        urls.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4141222872,4082859514&fm=23&gp=0.jpg")
                        urls.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4141222872,4082859514&fm=23&gp=0.jpg")
                    }
                    1 -> {

                        urls.add("http://i1.kym-cdn.com/photos/images/newsfeed/001/239/941/d56.jpg")
                        urls.add("http://i0.kym-cdn.com/photos/images/masonry/000/954/349/a28.jpg")
                    }
                    2 -> urls.add("http://i2.kym-cdn.com/photos/images/newsfeed/001/236/052/f83.jpg")
                    3 -> urls.add("http://i0.kym-cdn.com/photos/images/newsfeed/001/231/591/f4a.jpg")
                    4 -> urls.add("http://i3.kym-cdn.com/photos/images/masonry/001/109/775/e75.jpg")
                    5 -> urls.add("http://i1.kym-cdn.com/photos/images/masonry/001/100/503/eb8.png")
                    6 ->

                        urls.add("http://i3.kym-cdn.com/photos/images/masonry/001/045/739/216.jpg")
                    7 -> urls.add("http://i1.kym-cdn.com/photos/images/masonry/001/026/682/528.jpg")
                }
                val commentModels = ArrayList<CommentModel>()
                for (j in 0..19) {
                    val e = CommentModel()
                    e.content = "评论问的额二位请问 " + i
                    e.fromName = "名字 " + i
                    commentModels.add(e)
                }
                classmateModel.commentModels = commentModels
                classmateModel.imageUrl = urls
                list.add(classmateModel)
            }
            return list

        }

    @RequestMapping(value = *arrayOf("/getGifts"))
    fun getGifts(): GiftListBean {
        val arrayListOf = arrayListOf<GiftListBean.Entities>()


        for (i in 0..30) {


            arrayListOf.add(GiftListBean.Entities("", "", "", "", "icon $i", "i $i", "i $i", "i $i", false, 10.0))

        }
        return GiftListBean("get", "funny", 200, "sd", "funny", true, true, System.currentTimeMillis().toInt(), "", arrayListOf)

    }

    val friend: Any
        @RequestMapping(value = *arrayOf("/getFriend"), method = arrayOf(RequestMethod.GET))
        get() {
            val newfriend = NewFriend()
            val list = ArrayList<FriendModel>()
            for (i in 0..19) {
                val friendModel = FriendModel()
                friendModel.date = System.currentTimeMillis().toString() + ""
                friendModel.headImage = Images.images[i]
                friendModel.friendAddCouse = i % 3
                friendModel.name = "this is name " + i
                friendModel.fromContent = "早上啊是滴噢接啊温江区了拉我去" + i
                friendModel.fromName = "from name " + i
                friendModel.unReadMessage = i
                list.add(friendModel)
            }

            newfriend.friendModel = list
            newfriend.newFriend = (Math.random() * 100).toInt()
            return newfriend
        }

    private val code: Int
        get() = 0

    val groupDetail: Any
        @RequestMapping(value = *arrayOf("/getGroupDetail"))
        get() {
            val groupDetailModel = GroupDetailModel()
            groupDetailModel.groupArea = "河南省  洛阳市"
            groupDetailModel.groupGrade = "四年级三班"
            groupDetailModel.groupIcon = Utils.getImages(Images.images)
            groupDetailModel.groupID = "443965"
            groupDetailModel.groupMyName = "张小花"
            groupDetailModel.groupSchool = "洛阳外国语学院"
            val memberModels = ArrayList<MemberModel>()
            for (i in 0..39) {
                val memberModel = MemberModel()
                memberModel.id = "1000" + 1
                memberModel.imagePic = Utils.getImages()
                memberModel.level = i % 3
                memberModel.name = Utils.getName()
                memberModel.sign = Utils.randomRound(0, 3).toString() + ""
                memberModels.add(memberModel)
            }

            groupDetailModel.memberModel = memberModels
            return groupDetailModel

        }

    val room: Any
        @RequestMapping(value = *arrayOf("/getRoom"), method = arrayOf(RequestMethod.GET))
        get() {


            val rooms = ArrayList<RoomModel>()
            for (i in 0..19) {
                val e = RoomModel()
                e.count = i
                e.fromContent = Strings.CONTENTS[Utils.randomRound(0, Strings.CONTENTS.size)]
                e.fromName = Strings.NAMES[Utils.randomRound(0, Strings.NAMES.size)]
                e.image = Images.images[Utils.randomRound(0, Images.images.size)]
                e.name = Strings.NAMES[Utils.randomRound(0, Strings.NAMES.size)]
                e.unReadCount = (Math.random() * 10).toInt()
                rooms.add(e)
            }
            return rooms
        }

    @RequestMapping(value = *arrayOf("/hello", "/hi"), method = arrayOf(RequestMethod.POST))
    fun say(@RequestParam(value = "name") name: String, @RequestParam(value = "age") age: Int): User? {
        userRepository!!.save(User(name, age))
        userRepository.findByUsername(name)
        return null
    }

    @Configuration open
    inner class CORSConfiguration {
        @Bean
        open fun corsConfigurer(): WebMvcConfigurer {

            //this is allow all remote client to access
            return object : WebMvcConfigurerAdapter() {
                override fun addCorsMappings(registry: CorsRegistry?) {
                    registry!!.addMapping("/**")
                            .allowedHeaders("*")
                            .allowedMethods("*")

                            .allowedOrigins("*")
                }
            }
        }
    }

    //查询
    @RequestMapping(value = "getuser", method = arrayOf(RequestMethod.GET))
    fun getUser(@RequestParam(value = "id") id: String): User? {
        return null


    }

    @RequestMapping(value = *arrayOf("del_hello"), method = arrayOf(RequestMethod.DELETE))
    fun delHello(@RequestParam(value = "id") id: String): User? {
//        val _id = String.format(ObjId, id)

        userRepository!!.save(User(id, id))

        return null

    }

    @RequestMapping(value = *arrayOf("/login"), method = arrayOf(RequestMethod.POST))
    private fun login(
            @RequestParam(name = "username") username: String,
            @RequestParam(name = "password") password: String

    ): Any {
        logger.debug(username + "  " + password)

        return true
    }


    @RequestMapping(value = *arrayOf("/regist"), method = arrayOf(RequestMethod.POST))
    fun regist(@RequestParam(name = "username") username: String, @RequestParam(name = "password") password: String): Any {

        if (userRepository!!.findByUsername(username) != null) {
            return ErrorModel("用户已存在", 2)


        } else {
            if (!TextUtil.isEmpty(username) && !TextUtil.isEmpty(password)) {
                val user = User(username, password)
                userRepository.save(user)
                val messageModel = MessageModel()
                messageModel.message = "success"
                messageModel.code = code
                return messageModel
            }
        }
        return ErrorModel()

    }
}
