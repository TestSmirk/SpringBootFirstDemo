package com.testsmirk.model;

import java.util.List;

public class GiftsModel {

    /**
     * action : GET
     * application : funny_video
     * code : 200
     * description : null
     * entities : [{"animation":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514024477504497.gif","coin":6,"effect":"1#1#1000#1000#5000","gid":6,"icon":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514024485198916.png","name_en":"棒棒糖","name_sc":"棒棒糖","name_tc":"棒棒糖","price":0.6},{"animation":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025433160314.gif","coin":18,"effect":"1#1#1000#1000#5000","gid":7,"icon":"http://vm-media-test.b0.upaiyun.com/chatting/gift/15140254255532.png","name_en":"么么哒","name_sc":"么么哒","name_tc":"么么哒","price":1.8},{"animation":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025584128449.gif","coin":28,"effect":"1#1#1000#1000#5000","gid":8,"icon":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025577477588.png","name_en":"玫瑰","name_sc":"玫瑰","name_tc":"玫瑰","price":2.8},{"animation":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025672671763.gif","coin":98,"effect":"1#1#1000#1000#5000","gid":9,"icon":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025667158062.png","name_en":"口红","name_sc":"口红","name_tc":"口红","price":9.8},{"animation":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025719285157.gif","coin":288,"effect":"1#1#1000#1000#5000","gid":10,"icon":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025713719795.png","name_en":"高跟鞋","name_sc":"高跟鞋","name_tc":"高跟鞋","price":28.8},{"animation":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025755660768.gif","coin":688,"effect":"1#1#1000#1000#5000","gid":11,"icon":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025749678372.png","name_en":"包包","name_sc":"包包","name_tc":"包包","price":68.8},{"animation":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025797663498.gif","coin":8888,"effect":"1#1#1000#1000#5000","gid":12,"icon":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025783087825.png","name_en":"跑车","name_sc":"跑车","name_tc":"跑车","price":888.8},{"animation":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025858431267.gif","coin":18888,"effect":"1#1#1000#1000#5000","gid":13,"icon":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025851134684.png","name_en":"游艇","name_sc":"游艇","name_tc":"游艇","price":1888.8},{"animation":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025898780612.gif","coin":6,"effect":"1#1#1000#1000#5000","gid":14,"icon":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025892730712.png","name_en":"蜜桃","name_sc":"蜜桃","name_tc":"蜜桃","price":0.6},{"animation":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025940280653.gif","coin":66,"effect":"1#1#1000#1000#5000","gid":15,"icon":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025933892941.png","name_en":"手铐","name_sc":"手铐","name_tc":"手铐","price":6.6},{"animation":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025976319415.gif","coin":88,"effect":"1#1#1000#1000#5000","gid":16,"icon":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514025969591503.png","name_en":"滴蜡","name_sc":"滴蜡","name_tc":"滴蜡","price":8.8},{"animation":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514026014849635.gif","coin":188,"effect":"1#1#1000#1000#5000","gid":17,"icon":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514026007964991.png","name_en":"皮鞭","name_sc":"皮鞭","name_tc":"皮鞭","price":18.8},{"animation":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514026058419502.gif","coin":666,"effect":"1#1#1000#1000#5000","gid":18,"icon":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514026051667211.png","name_en":"钻石","name_sc":"钻石","name_tc":"钻石","price":66.6},{"animation":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514026211434727.gif","coin":1688,"effect":"1#1#1000#1000#5000","gid":19,"icon":"http://vm-media-test.b0.upaiyun.com/chatting/gift/151402620430093.png","name_en":"水晶鞋","name_sc":"水晶鞋","name_tc":"水晶鞋","price":168.8},{"animation":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514026254858442.gif","coin":2888,"effect":"1#1#1000#1000#5000","gid":20,"icon":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514026245767847.png","name_en":"飞机","name_sc":"飞机","name_tc":"飞机","price":288.8},{"animation":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514026290691923.gif","coin":28888,"effect":"1#1#1000#1000#5000","gid":21,"icon":"http://vm-media-test.b0.upaiyun.com/chatting/gift/1514026284683949.png","name_en":"城堡","name_sc":"城堡","name_tc":"城堡","price":2888.8}]
     * organization : funny
     * result : true
     * status : true
     * timestamp : 1514167799
     * uri : http://api.test.gotuvideo.com/v1.0/chatting/gifs
     */

    private String action;
    private String application;
    private int code;
    private Object description;
    private String organization;
    private boolean result;
    private boolean status;
    private int timestamp;
    private String uri;
    private List<EntitiesBean> entities;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<EntitiesBean> getEntities() {
        return entities;
    }

    public void setEntities(List<EntitiesBean> entities) {
        this.entities = entities;
    }

    public static class EntitiesBean {

        public EntitiesBean(String animation, int coin, String effect, int gid, String icon, String name_en, String name_sc, String name_tc, double price) {
            this.animation = animation;
            this.coin = coin;
            this.effect = effect;
            this.gid = gid;
            this.icon = icon;
            this.name_en = name_en;
            this.name_sc = name_sc;
            this.name_tc = name_tc;
            this.price = price;
        }

        /**
         * animation : http://vm-media-test.b0.upaiyun.com/chatting/gift/1514024477504497.gif
         * coin : 6
         * effect : 1#1#1000#1000#5000
         * gid : 6
         * icon : http://vm-media-test.b0.upaiyun.com/chatting/gift/1514024485198916.png
         * name_en : 棒棒糖
         * name_sc : 棒棒糖
         * name_tc : 棒棒糖
         * price : 0.6
         */

        private String animation;
        private int coin;
        private String effect;
        private int gid;
        private String icon;
        private String name_en;
        private String name_sc;
        private String name_tc;
        private double price;

        public String getAnimation() {
            return animation;
        }

        public void setAnimation(String animation) {
            this.animation = animation;
        }

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public String getEffect() {
            return effect;
        }

        public void setEffect(String effect) {
            this.effect = effect;
        }

        public int getGid() {
            return gid;
        }

        public void setGid(int gid) {
            this.gid = gid;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName_sc() {
            return name_sc;
        }

        public void setName_sc(String name_sc) {
            this.name_sc = name_sc;
        }

        public String getName_tc() {
            return name_tc;
        }

        public void setName_tc(String name_tc) {
            this.name_tc = name_tc;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
