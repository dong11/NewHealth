package com.dong.huang.healthapp.beans.homebean;

import java.util.List;

/**
 * Created by dong on 16/4/18.
 */
public class SubjectItemInfo {

    /**
     * total_items : 3
     * items_per_page : 10
     * current_item_count : 3
     * total_pages : 1
     * page_index : 1
     * start_index : 1
     * items : [{"id":5535,"title":"减肥答疑 · 早晨空腹锻炼更减肥，是真的吗？该锻炼多久呢？","cover":"http://img.dxycdn.com/dotcom/2016/03/29/21/rj0zy2zn.png","cover_small":"http://img.dxycdn.com/dotcom/2016/03/29/30/gacpvxdu.jpg","author_id":430,"author":"王辘","author_url":"wanglu","author_avatar":"http://img.dxycdn.com/dotcom/2016/03/02/13/dazevqay.jpg","author_remarks":"营养与食品安全硕士","special_id":231,"special_name":"减肥答疑","publish_time":"2016-03-30 07:00:00","editors":[{"id":793461,"nick_name":"海刃","avatar":"2016/01/29/29/U3cO74eU.jpg"}]},{"id":5534,"title":"减肥答疑 · 只有小腹和肚子很胖，不知道怎么办，这让我很苦恼","cover":"http://img.dxycdn.com/dotcom/2016/03/29/21/rj0zy2zn.png","cover_small":"http://img.dxycdn.com/dotcom/2016/03/29/30/gacpvxdu.jpg","author_id":430,"author":"王辘","author_url":"wanglu","author_avatar":"http://img.dxycdn.com/dotcom/2016/03/02/13/dazevqay.jpg","author_remarks":"营养与食品安全硕士","special_id":231,"special_name":"减肥答疑","publish_time":"2016-03-29 19:00:00","editors":[{"id":793461,"nick_name":"海刃","avatar":"2016/01/29/29/U3cO74eU.jpg"}]},{"id":5533,"title":"减肥答疑 · 有没有什么能减腹部脂肪的好方法和食物？","cover":"http://img.dxycdn.com/dotcom/2016/03/29/21/rj0zy2zn.png","cover_small":"http://img.dxycdn.com/dotcom/2016/03/29/30/gacpvxdu.jpg","author_id":430,"author":"王辘","author_url":"wanglu","author_avatar":"http://img.dxycdn.com/dotcom/2016/03/02/13/dazevqay.jpg","author_remarks":"营养与食品安全硕士","publish_time":"2016-03-29 14:00:00","editors":[{"id":793461,"nick_name":"海刃","avatar":"2016/01/29/29/U3cO74eU.jpg"}]}]
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
         * id : 5535
         * title : 减肥答疑 · 早晨空腹锻炼更减肥，是真的吗？该锻炼多久呢？
         * cover : http://img.dxycdn.com/dotcom/2016/03/29/21/rj0zy2zn.png
         * cover_small : http://img.dxycdn.com/dotcom/2016/03/29/30/gacpvxdu.jpg
         * author_id : 430
         * author : 王辘
         * author_url : wanglu
         * author_avatar : http://img.dxycdn.com/dotcom/2016/03/02/13/dazevqay.jpg
         * author_remarks : 营养与食品安全硕士
         * special_id : 231
         * special_name : 减肥答疑
         * publish_time : 2016-03-30 07:00:00
         * editors : [{"id":793461,"nick_name":"海刃","avatar":"2016/01/29/29/U3cO74eU.jpg"}]
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
            private String title;
            private String cover;
            private String cover_small;
            private int author_id;
            private String author;
            private String author_url;
            private String author_avatar;
            private String author_remarks;
            private int special_id;
            private String special_name;
            private String publish_time;
            /**
             * id : 793461
             * nick_name : 海刃
             * avatar : 2016/01/29/29/U3cO74eU.jpg
             */

            private List<EditorsBean> editors;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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

            public int getAuthor_id() {
                return author_id;
            }

            public void setAuthor_id(int author_id) {
                this.author_id = author_id;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getAuthor_url() {
                return author_url;
            }

            public void setAuthor_url(String author_url) {
                this.author_url = author_url;
            }

            public String getAuthor_avatar() {
                return author_avatar;
            }

            public void setAuthor_avatar(String author_avatar) {
                this.author_avatar = author_avatar;
            }

            public String getAuthor_remarks() {
                return author_remarks;
            }

            public void setAuthor_remarks(String author_remarks) {
                this.author_remarks = author_remarks;
            }

            public int getSpecial_id() {
                return special_id;
            }

            public void setSpecial_id(int special_id) {
                this.special_id = special_id;
            }

            public String getSpecial_name() {
                return special_name;
            }

            public void setSpecial_name(String special_name) {
                this.special_name = special_name;
            }

            public String getPublish_time() {
                return publish_time;
            }

            public void setPublish_time(String publish_time) {
                this.publish_time = publish_time;
            }

            public List<EditorsBean> getEditors() {
                return editors;
            }

            public void setEditors(List<EditorsBean> editors) {
                this.editors = editors;
            }

            public static class EditorsBean {
                private int id;
                private String nick_name;
                private String avatar;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getNick_name() {
                    return nick_name;
                }

                public void setNick_name(String nick_name) {
                    this.nick_name = nick_name;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }
            }
        }
    }
}
