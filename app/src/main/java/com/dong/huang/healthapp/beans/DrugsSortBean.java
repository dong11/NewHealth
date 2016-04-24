package com.dong.huang.healthapp.beans;

import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/4/24
 * @time 下午5:21
 */

public class DrugsSortBean {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 家中常备药品
         * content : 感冒、退热、止痛、腹泻
         * tags_str : 布洛芬,泰诺林,百服宁,必理通,芬必得,思密达,口服补液盐,妈咪爱,新康泰克
         */

        private List<ItemsBean> items;

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            private String title;
            private String content;
            private String tags_str;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getTags_str() {
                return tags_str;
            }

            public void setTags_str(String tags_str) {
                this.tags_str = tags_str;
            }
        }
    }
}
