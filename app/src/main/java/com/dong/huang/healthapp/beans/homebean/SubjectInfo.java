package com.dong.huang.healthapp.beans.homebean;

import java.util.List;

/**
 * Created by dong on 16/4/18.
 */
public class SubjectInfo {

    /**
     * total_items : 144
     * items_per_page : 10
     * current_item_count : 10
     * total_pages : 15
     * page_index : 2
     * start_index : 11
     * items : [{"id":220,"name":"儿童急救手册","desc":"小朋友柔弱、好动又好奇，受伤在所难免。发生意外，家长第一时间怎么做？","cover":"http://img.dxycdn.com/dotcom/2016/02/18/24/jhabfhe0.jpg","cover_small":"http://img.dxycdn.com/dotcom/2016/02/18/24/jhabfhe0.jpg","type":5,"type_name":"母婴","create_time":"2016-01-21 12:58:54","modify_time":"2016-03-01 13:40:14"},{"id":219,"name":"你害怕甲状腺结节吗？","desc":"越来越多人的体检报告上出现甲状腺结节，你害怕吗？是不是担心会癌变？需要手术吗？","cover":"http://img.dxycdn.com/dotcom/2016/01/04/28/ybyxcdto.jpg","cover_small":"http://img.dxycdn.com/dotcom/2016/01/04/28/ybyxcdto.jpg","type":11,"type_name":"无频道专辑2","create_time":"2016-01-12 18:16:05","modify_time":"2016-01-21 13:47:19"},{"id":218,"name":"健康吃零食","desc":"想吃，管不住嘴怎么办？想吃，怎样健康吃零食？想吃，还不想胖？丁香医生都满足你。","cover":"http://img.dxycdn.com/dotcom/2016/03/30/19/ewdn8tvh.jpg","cover_small":"http://img.dxycdn.com/dotcom/2016/03/30/19/ewdn8tvh.jpg","type":6,"type_name":"营养","create_time":"2016-01-04 11:55:03","modify_time":"2016-01-04 11:55:03"},{"id":217,"name":"有时候一张图你就能懂","desc":"2015 年，丁香医生推出了一图读懂，做了科普海报。这里是大家最爱的十张。","cover":"http://img.dxycdn.com/dotcom/2015/10/21/15/pw5t4zad.gif","cover_small":"http://img.dxycdn.com/dotcom/2015/10/21/15/pw5t4zad.gif","type":11,"type_name":"无频道专辑2","create_time":"2015-12-31 19:45:14","modify_time":"2015-12-31 19:45:14"},{"id":216,"name":"年度十大谣言骗不到我","desc":"2015 年，丁香医生辟谣无数，你的分享能让被骗的人再少一个。","cover":"http://img.dxycdn.com/dotcom/2015/10/23/23/kfe8rhyd.jpg","cover_small":"http://img.dxycdn.com/dotcom/2015/10/23/23/kfe8rhyd.jpg","type":11,"type_name":"无频道专辑2","create_time":"2015-12-31 19:41:06","modify_time":"2015-12-31 19:41:06"},{"id":215,"name":"有用就大胆向别人分享","desc":"2015 年丁香医生分享数最高的文章，看看你有没有分享？你的分享可以帮助很多人。","cover":"http://img.dxycdn.com/dotcom/2015/11/04/56/9j2zuhtk.jpg","cover_small":"http://img.dxycdn.com/dotcom/2015/11/04/56/9j2zuhtk.jpg","type":11,"type_name":"无频道专辑2","create_time":"2015-12-31 19:34:56","modify_time":"2015-12-31 19:35:50"},{"id":214,"name":"喜欢就一个人偷偷收藏","desc":"2015 年丁香医生里收藏率最高的文章，看了之后只觉父母爱之深。","cover":"http://img.dxycdn.com/dotcom/2015/12/17/13/7yxreujc.gif","cover_small":"http://img.dxycdn.com/dotcom/2015/12/17/13/7yxreujc.gif","type":11,"type_name":"无频道专辑2","create_time":"2015-12-31 19:28:38","modify_time":"2015-12-31 19:30:48"},{"id":213,"name":"大家都爱读什么？","desc":"2015 年大家最爱看的丁香医生文章。还没看过就赶紧看，为了健康。","cover":"http://img.dxycdn.com/dotcom/2015/09/01/31/d0kbdfv1.jpg","cover_small":"http://img.dxycdn.com/dotcom/2015/09/01/31/d0kbdfv1.jpg","type":11,"type_name":"无频道专辑2","create_time":"2015-12-31 19:23:29","modify_time":"2015-12-31 19:51:59"},{"id":212,"name":"泡个热水澡也有讲究","desc":"洗澡水温度多少合适？浴霸会不会致盲？冬天洗个热水澡，也有很多讲究。","cover":"http://img.dxycdn.com/dotcom/2015/10/26/48/gvsqplvo.jpg","cover_small":"http://img.dxycdn.com/dotcom/2015/10/26/48/gvsqplvo.jpg","type":11,"type_name":"无频道专辑2","create_time":"2015-12-22 17:06:39","modify_time":"2015-12-22 17:10:12"},{"id":211,"name":"适合宝宝的圣诞礼物","desc":"贵的不一定就好，这些推荐都是最实用、最适合宝宝发育情况的。","cover":"http://img.dxycdn.com/dotcom/2016/01/27/05/z82qrazf.jpg","cover_small":"http://img.dxycdn.com/dotcom/2016/01/27/05/z82qrazf.jpg","type":5,"type_name":"母婴","create_time":"2015-12-21 18:32:53","modify_time":"2015-12-21 18:32:53"}]
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int total_items;
        private int items_per_page;
        private int current_item_count;
        private int total_pages;
        private int page_index;
        private int start_index;
        /**
         * id : 220
         * name : 儿童急救手册
         * desc : 小朋友柔弱、好动又好奇，受伤在所难免。发生意外，家长第一时间怎么做？
         * cover : http://img.dxycdn.com/dotcom/2016/02/18/24/jhabfhe0.jpg
         * cover_small : http://img.dxycdn.com/dotcom/2016/02/18/24/jhabfhe0.jpg
         * type : 5
         * type_name : 母婴
         * create_time : 2016-01-21 12:58:54
         * modify_time : 2016-03-01 13:40:14
         */

        private List<ItemsBean> items;

        public int getTotal_items() {
            return total_items;
        }

        public void setTotal_items(int total_items) {
            this.total_items = total_items;
        }

        public int getItems_per_page() {
            return items_per_page;
        }

        public void setItems_per_page(int items_per_page) {
            this.items_per_page = items_per_page;
        }

        public int getCurrent_item_count() {
            return current_item_count;
        }

        public void setCurrent_item_count(int current_item_count) {
            this.current_item_count = current_item_count;
        }

        public int getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(int total_pages) {
            this.total_pages = total_pages;
        }

        public int getPage_index() {
            return page_index;
        }

        public void setPage_index(int page_index) {
            this.page_index = page_index;
        }

        public int getStart_index() {
            return start_index;
        }

        public void setStart_index(int start_index) {
            this.start_index = start_index;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            private int id;
            private String name;
            private String desc;
            private String cover;
            private String cover_small;
            private int type;
            private String type_name;
            private String create_time;
            private String modify_time;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getCover_small() {
                return cover_small;
            }

            public void setCover_small(String cover_small) {
                this.cover_small = cover_small;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getType_name() {
                return type_name;
            }

            public void setType_name(String type_name) {
                this.type_name = type_name;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getModify_time() {
                return modify_time;
            }

            public void setModify_time(String modify_time) {
                this.modify_time = modify_time;
            }
        }
    }
}
