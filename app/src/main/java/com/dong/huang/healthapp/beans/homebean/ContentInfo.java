package com.dong.huang.healthapp.beans.homebean;

import java.util.List;

/**
 * Created by dong on 16/4/9.
 */
public class ContentInfo {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 4998
         * title : 每逢佳节胖三圈，教您八招解油腻
         * content : <p style="text-align: center;"><img src="http://img.dxycdn.com/dotcom/2016/01/21/27/h4gmluh6.jpg" title="题图-900.jpg" alt="题图-900.jpg"/></p><p>吃团年饭，是春节过年家家户户最热闹愉快的时候。看着丰盛的美味佳肴摆满一桌，阖家团聚，一边说笑，一边吃饭，心头的满足和喜悦最是让人放松。</p><p>吃是咱们中国人的头等大事，除了美味，健康也很重要。这团年饭好吃，也不能贪多，否则吃了不消化，肠胃也不舒服。</p><p>下面健康头条就给您介绍八个解油腻的饮食方式，让您过年吃得美味与健康兼顾。</p><p style="text-align: center;"><img src="http://img.dxycdn.com/dotcom/2016/01/21/58/rrhmakf5.gif" title="01.gif" alt="01.gif"/><img src="http://img.dxycdn.com/dotcom/2016/01/21/58/8taviiha.gif" title="02.gif" alt="02.gif"/><img src="http://img.dxycdn.com/dotcom/2016/01/21/58/mhaxhlic.gif" title="03.gif" alt="03.gif"/><img src="http://img.dxycdn.com/dotcom/2016/01/21/58/fm35vkya.gif" title="04.gif" alt="04.gif"/><img src="http://img.dxycdn.com/dotcom/2016/01/21/58/lo3bsb2a.gif" title="05.gif" alt="05.gif"/><img src="http://img.dxycdn.com/dotcom/2016/01/21/58/yzipi2tw.gif" title="06.gif" alt="06.gif"/><img src="http://img.dxycdn.com/dotcom/2016/02/01/33/b0rg1m28.gif" title="07.gif" alt="07.gif"/><img src="http://img.dxycdn.com/dotcom/2016/01/21/11/feae1w2k.gif" title="08.gif" alt="08.gif"/></p><p><br/></p><p><strong><span style="color: rgb(153, 153, 153);">丁香园版权所有，未经许可不得转载。</span></strong></p><p><span style="color: rgb(153, 153, 153);">图片来源：Shutterstock.com</span></p>
         * cover : http://img.dxycdn.com/dotcom/2016/01/21/27/h4gmluh6.jpg
         * cover_small : http://img.dxycdn.com/dotcom/2016/01/21/26/epavrnf5.jpg
         * author_id : 77
         * author : 顾中一
         * author_url : guzhongyi
         * author_avatar : http://img.dxycdn.com/dotcom/2015/03/25/43/mlikxikl.jpg
         * author_remarks : 北京友谊医院营养师、北京市营养学会理事
         * publish_time : 2016-02-12 07:00:00
         * tags : [{"tag_id":217,"tag_name":"营养","tag_type":4,"tag_type_name":"article"},{"tag_id":6135,"tag_name":"不消化","tag_type":4,"tag_type_name":"article"},{"tag_id":6136,"tag_name":"肠胃不适","tag_type":4,"tag_type_name":"article"}]
         * editors : [{"id":403552,"nick_name":"yidan","avatar":"2016/01/27/47/OTc8Tlgi.jpg"}]
         */

        private List<ItemsBean> items;

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            private int id;
            private String title;
            private String content;
            private String cover;
            private String cover_small;
            private int author_id;
            private String author;
            private String author_url;
            private String author_avatar;
            private String author_remarks;
            private String publish_time;
            /**
             * tag_id : 217
             * tag_name : 营养
             * tag_type : 4
             * tag_type_name : article
             */

            private List<TagsBean> tags;
            /**
             * id : 403552
             * nick_name : yidan
             * avatar : 2016/01/27/47/OTc8Tlgi.jpg
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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
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

            public String getPublish_time() {
                return publish_time;
            }

            public void setPublish_time(String publish_time) {
                this.publish_time = publish_time;
            }

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public List<EditorsBean> getEditors() {
                return editors;
            }

            public void setEditors(List<EditorsBean> editors) {
                this.editors = editors;
            }

            public static class TagsBean {
                private int tag_id;
                private String tag_name;
                private int tag_type;
                private String tag_type_name;

                public int getTag_id() {
                    return tag_id;
                }

                public void setTag_id(int tag_id) {
                    this.tag_id = tag_id;
                }

                public String getTag_name() {
                    return tag_name;
                }

                public void setTag_name(String tag_name) {
                    this.tag_name = tag_name;
                }

                public int getTag_type() {
                    return tag_type;
                }

                public void setTag_type(int tag_type) {
                    this.tag_type = tag_type;
                }

                public String getTag_type_name() {
                    return tag_type_name;
                }

                public void setTag_type_name(String tag_type_name) {
                    this.tag_type_name = tag_type_name;
                }
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
