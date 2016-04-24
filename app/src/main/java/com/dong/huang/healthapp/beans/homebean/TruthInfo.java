package com.dong.huang.healthapp.beans.homebean;

import java.util.List;

/**
 * Created by dong on 16/4/7.
 */
public class TruthInfo {

    /**
     * total_items : 145
     * items_per_page : 10
     * current_item_count : 10
     * total_pages : 15
     * page_index : 1
     * start_index : 1
     * items : [{"id":5068,"title":"突发胸痛！心梗袭来到底应该怎么办？","cover":"http://img.dxycdn.com/dotcom/2016/01/27/31/r3zsdm4h.jpg","cover_small":"http://img.dxycdn.com/dotcom/2016/01/27/30/djkxzwy8.jpg","special_id":0},{"id":4717,"title":"晚吃姜，似砒霜？安啦，没那么可怕！","cover":"http://img.dxycdn.com/dotcom/2015/12/23/23/lgotka3i.jpg","cover_small":"http://img.dxycdn.com/dotcom/2015/12/23/23/qz94tq3o.jpg","special_id":0},{"id":4152,"title":"可乐从什么时候掌握了杀精子的技能？","cover":"http://img.dxycdn.com/dotcom/2015/10/19/35/jdzegifb.jpg","cover_small":"http://img.dxycdn.com/dotcom/2015/10/19/35/g1n1rmyq.jpg","special_id":0},{"id":4655,"title":"酵素减肥、碱性体质、排毒养颜、「珍珠」有害，这些谣言你都遇到过吗？","cover":"http://img.dxycdn.com/dotcom/2016/01/22/49/z1qhql56.gif","cover_small":"http://img.dxycdn.com/dotcom/2015/12/16/56/rfagmo77.jpg","special_id":0},{"id":2232,"title":"权衡利弊，小心防范：医疗辐射没那么可怕","cover":"http://img.dxycdn.com/dotcom/2014/12/25/04/rworlmrk.jpg","cover_small":"http://img.dxycdn.com/dotcom/2014/12/25/03/qzafhmgv.jpg","special_id":154},{"id":3826,"title":"朋友圈「健康食品」的五大宣传陷阱，你中招了吗？","cover":"http://img.dxycdn.com/dotcom/2015/10/23/37/gaov1hnz.jpg","cover_small":"http://img.dxycdn.com/dotcom/2015/10/23/37/1hjpluo4.jpg","special_id":0},{"id":2648,"title":"烫伤了不能乱抹东西！这 5 个急救动作千万要记牢","cover":"http://img.dxycdn.com/dotcom/2015/04/01/55/claxnl3s.jpg","cover_small":"http://img.dxycdn.com/dotcom/2015/04/01/55/pdt8lqwi.jpg","special_id":109},{"id":1920,"title":"烧心、反酸怎么治？馒头可以当药吃？ ","cover":"http://img.dxycdn.com/dotcom/2015/08/27/03/5kvmooaw.jpg","cover_small":"http://img.dxycdn.com/dotcom/2015/08/27/03/mira4i9g.jpg","special_id":12},{"id":3626,"title":"流传于朋友圈的 13 大谣言，你信过几个？","cover":"http://img.dxycdn.com/dotcom/2015/08/18/22/1mxm86o7.jpg","cover_small":"http://img.dxycdn.com/dotcom/2015/08/18/22/bxoyrabr.jpg","special_id":0},{"id":3468,"title":"一图读懂 · 乙肝的七个真相","cover":"http://img.dxycdn.com/dotcom/2016/01/19/45/zovayjam.gif","cover_small":"http://img.dxycdn.com/dotcom/2016/01/19/45/aa2vetbd.gif","special_id":0}]
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
         * id : 5068
         * title : 突发胸痛！心梗袭来到底应该怎么办？
         * cover : http://img.dxycdn.com/dotcom/2016/01/27/31/r3zsdm4h.jpg
         * cover_small : http://img.dxycdn.com/dotcom/2016/01/27/30/djkxzwy8.jpg
         * special_id : 0
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
            private int special_id;

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

            public int getSpecial_id() {
                return special_id;
            }

            public void setSpecial_id(int special_id) {
                this.special_id = special_id;
            }
        }
    }
}
