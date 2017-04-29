    package com.testsmirk.model.friend;


    /**
     * Created by testsmirk on 2017/4/25.
     */

    public class FriendModel  {
        private String headImage;
        private String name;
        private String fromName;
        private String fromContent;
        private int unReadMessage;
        private String date;
        private int friendAddCouse;

        public int getFriendAddCouse() {
            return friendAddCouse;
        }

        public void setFriendAddCouse(int friendAddCouse) {
            this.friendAddCouse = friendAddCouse;
        }

        public String getHeadImage() {
            return headImage;
        }

        public void setHeadImage(String headImage) {
            this.headImage = headImage;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFromName() {
            return fromName;
        }

        public void setFromName(String fromName) {
            this.fromName = fromName;
        }

        public String getFromContent() {
            return fromContent;
        }

        public void setFromContent(String fromContent) {
            this.fromContent = fromContent;
        }

        public int getUnReadMessage() {
            return unReadMessage;
        }

        public void setUnReadMessage(int unReadMessage) {
            this.unReadMessage = unReadMessage;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
