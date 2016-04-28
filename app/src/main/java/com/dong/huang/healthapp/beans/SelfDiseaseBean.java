package com.dong.huang.healthapp.beans;

import java.util.List;

/**
 * @author dong {hwongrex@gmail.com}
 * @date 16/4/29
 * @time 上午12:20
 */

public class SelfDiseaseBean {

    /**
     * diseaseId : 22
     * disease : {"guidelines":"<p align=\"left\">\n\t本测评仅适合于普通感冒，即当有受凉、淋雨、过度疲劳等诱发因素，使全身或呼吸道局部防御功能降低时导致的上呼吸道感染。<\/p>\n<p align=\"left\">\n\t注意同肺炎及其它感染出现的症状进行区分。<\/p>\n","description":null,"name":"感冒","id":"22"}
     * questionList : [{"weightNo":"0","weightYes":"4","description":"<p>\n\t感冒来得快，一天就很严重了：（<\/p>\n","weightSevere":"5","name":"发病较急","id":"391"},{"weightNo":"0","weightYes":"4","description":"\n\t典型的流感或季节性感冒，身边一段时间内有很多人都感冒了~~\n","weightSevere":"5","name":"换季或被传染感冒","id":"392"},{"weightNo":"0","weightYes":"4","description":"\n\t感冒拖了好长时间，有些症状（咳嗽、痰黄）一直伴随，想彻底好了还真不容易╯﹏╰\n","weightSevere":"5","name":"感冒好不彻底","id":"393"},{"weightNo":"0","weightYes":"4","description":"\n\t感冒症状不太严重，但很容易复发（反复感冒）╯﹏╰\n","weightSevere":"5","name":"感冒反复发作","id":"394"},{"weightNo":"0","weightYes":"4","description":"\n\t鼻子不通气，有时一侧，有时两侧都不通气╯-╰\n","weightSevere":"5","name":"鼻子不通气","id":"395"},{"weightNo":"0","weightYes":"4","description":"\n\t老打喷嚏，一个接一个的x__x\n","weightSevere":"5","name":"打喷嚏","id":"396"},{"weightNo":"0","weightYes":"4","description":"\n\t流清鼻涕，一把一把的，一包纸巾根本不够用：（\n","weightSevere":"5","name":"流清鼻涕","id":"397"},{"weightNo":"0","weightYes":"4","description":"\n\t流浓鼻涕，稠乎乎的不太黄，多备点纸巾＞﹏＜\n","weightSevere":"5","name":"流浓鼻涕","id":"398"},{"weightNo":"0","weightYes":"4","description":"\n\t鼻涕又黄又稠，多醒醒鼻子╯﹏╰\n","weightSevere":"5","name":"流黄鼻涕","id":"399"},{"weightNo":"0","weightYes":"4","description":"\n\t感冒伴有咳嗽的情况：（\n","weightSevere":"5","name":"咳嗽","id":"400"},{"weightNo":"0","weightYes":"4","description":"\n\t咳嗽有痰，咳出的痰比较粘稠⊙_⊙\n","weightSevere":"5","name":"咳浓痰、粘痰","id":"401"},{"weightNo":"0","weightYes":"4","description":"\n\t感冒咳痰较多，痰比较稀，颜色发白~_~\n","weightSevere":"5","name":"痰多颜色白","id":"402"},{"weightNo":"0","weightYes":"4","description":"\n\t有痰，颜色黄：（\n","weightSevere":"5","name":"有黄痰","id":"3041"},{"weightNo":"0","weightYes":"4","description":"\n\t就是咳嗽，没有痰⊙﹏⊙\n","weightSevere":"5","name":"干咳","id":"3104"},{"weightNo":"0","weightYes":"4","description":"\n\t嗓子疼，咽口唾沫更疼了╯﹏╰\n","weightSevere":"5","name":"嗓子疼","id":"403"},{"weightNo":"0","weightYes":"4","description":"\n\t发烧超过38.5度就是高烧了，必须要降温了⊙﹏⊙\n","weightSevere":"5","name":"发烧","id":"404"},{"weightNo":"0","weightYes":"4","description":"\n\t浑身怕冷，感觉像掉进冰窖里，加多少衣服都还是冷⊙﹏⊙\n","weightSevere":"5","name":"浑身发冷","id":"405"},{"weightNo":"0","weightYes":"4","description":"\n\t头疼（为两侧太阳穴胀痛、间歇性、体位变化与震荡时明显）：（\n","weightSevere":"5","name":"头痛","id":"406"},{"weightNo":"0","weightYes":"4","description":"\n\t感冒容易出汗，有时出汗量还挺大╯﹏╰\n","weightSevere":"5","name":"出汗","id":"407"},{"weightNo":"0","weightYes":"4","description":"\n\t浑身发软，没有力气，能休息还是多休息吧~*.*~\n","weightSevere":"5","name":"浑身没劲","id":"719"},{"weightNo":"0","weightYes":"4","description":"\n\t口发干，容易口渴，总想喝水x__x\n","weightSevere":"5","name":"口渴","id":"3105"},{"weightNo":"0","weightYes":"4","description":"\n\t感冒了肚子还不舒服，有拉肚子或恶心呕吐的情况╯﹏╰\n","weightSevere":"5","name":"伴有胃肠症状","id":"3001"},{"weightNo":"0","weightYes":"4","description":"\n\t照镜子发现舌苔发黄、厚腻，想用勺子刮薄儿一点，着实不容易⊙_⊙\n","weightSevere":"5","name":"舌苔黄腻","id":"720"},{"weightNo":"0","weightYes":"4","description":"\n\t对着镜子看舌头的颜色比正常的淡红色还深，有点深红色了⊙_⊙\n","weightSevere":"5","name":"舌头发红","id":"721"},{"weightNo":"0","weightYes":"4","description":"<p>\n\t照镜子看舌苔颜色白，像一层白纸⊙_⊙<\/p>\n","weightSevere":"5","name":"舌苔白","id":"3106"}]
     */

    private DataBean data;
    /**
     * data : {"diseaseId":22,"disease":{"guidelines":"<p align=\"left\">\n\t本测评仅适合于普通感冒，即当有受凉、淋雨、过度疲劳等诱发因素，使全身或呼吸道局部防御功能降低时导致的上呼吸道感染。<\/p>\n<p align=\"left\">\n\t注意同肺炎及其它感染出现的症状进行区分。<\/p>\n","description":null,"name":"感冒","id":"22"},"questionList":[{"weightNo":"0","weightYes":"4","description":"<p>\n\t感冒来得快，一天就很严重了：（<\/p>\n","weightSevere":"5","name":"发病较急","id":"391"},{"weightNo":"0","weightYes":"4","description":"\n\t典型的流感或季节性感冒，身边一段时间内有很多人都感冒了~~\n","weightSevere":"5","name":"换季或被传染感冒","id":"392"},{"weightNo":"0","weightYes":"4","description":"\n\t感冒拖了好长时间，有些症状（咳嗽、痰黄）一直伴随，想彻底好了还真不容易╯﹏╰\n","weightSevere":"5","name":"感冒好不彻底","id":"393"},{"weightNo":"0","weightYes":"4","description":"\n\t感冒症状不太严重，但很容易复发（反复感冒）╯﹏╰\n","weightSevere":"5","name":"感冒反复发作","id":"394"},{"weightNo":"0","weightYes":"4","description":"\n\t鼻子不通气，有时一侧，有时两侧都不通气╯-╰\n","weightSevere":"5","name":"鼻子不通气","id":"395"},{"weightNo":"0","weightYes":"4","description":"\n\t老打喷嚏，一个接一个的x__x\n","weightSevere":"5","name":"打喷嚏","id":"396"},{"weightNo":"0","weightYes":"4","description":"\n\t流清鼻涕，一把一把的，一包纸巾根本不够用：（\n","weightSevere":"5","name":"流清鼻涕","id":"397"},{"weightNo":"0","weightYes":"4","description":"\n\t流浓鼻涕，稠乎乎的不太黄，多备点纸巾＞﹏＜\n","weightSevere":"5","name":"流浓鼻涕","id":"398"},{"weightNo":"0","weightYes":"4","description":"\n\t鼻涕又黄又稠，多醒醒鼻子╯﹏╰\n","weightSevere":"5","name":"流黄鼻涕","id":"399"},{"weightNo":"0","weightYes":"4","description":"\n\t感冒伴有咳嗽的情况：（\n","weightSevere":"5","name":"咳嗽","id":"400"},{"weightNo":"0","weightYes":"4","description":"\n\t咳嗽有痰，咳出的痰比较粘稠⊙_⊙\n","weightSevere":"5","name":"咳浓痰、粘痰","id":"401"},{"weightNo":"0","weightYes":"4","description":"\n\t感冒咳痰较多，痰比较稀，颜色发白~_~\n","weightSevere":"5","name":"痰多颜色白","id":"402"},{"weightNo":"0","weightYes":"4","description":"\n\t有痰，颜色黄：（\n","weightSevere":"5","name":"有黄痰","id":"3041"},{"weightNo":"0","weightYes":"4","description":"\n\t就是咳嗽，没有痰⊙﹏⊙\n","weightSevere":"5","name":"干咳","id":"3104"},{"weightNo":"0","weightYes":"4","description":"\n\t嗓子疼，咽口唾沫更疼了╯﹏╰\n","weightSevere":"5","name":"嗓子疼","id":"403"},{"weightNo":"0","weightYes":"4","description":"\n\t发烧超过38.5度就是高烧了，必须要降温了⊙﹏⊙\n","weightSevere":"5","name":"发烧","id":"404"},{"weightNo":"0","weightYes":"4","description":"\n\t浑身怕冷，感觉像掉进冰窖里，加多少衣服都还是冷⊙﹏⊙\n","weightSevere":"5","name":"浑身发冷","id":"405"},{"weightNo":"0","weightYes":"4","description":"\n\t头疼（为两侧太阳穴胀痛、间歇性、体位变化与震荡时明显）：（\n","weightSevere":"5","name":"头痛","id":"406"},{"weightNo":"0","weightYes":"4","description":"\n\t感冒容易出汗，有时出汗量还挺大╯﹏╰\n","weightSevere":"5","name":"出汗","id":"407"},{"weightNo":"0","weightYes":"4","description":"\n\t浑身发软，没有力气，能休息还是多休息吧~*.*~\n","weightSevere":"5","name":"浑身没劲","id":"719"},{"weightNo":"0","weightYes":"4","description":"\n\t口发干，容易口渴，总想喝水x__x\n","weightSevere":"5","name":"口渴","id":"3105"},{"weightNo":"0","weightYes":"4","description":"\n\t感冒了肚子还不舒服，有拉肚子或恶心呕吐的情况╯﹏╰\n","weightSevere":"5","name":"伴有胃肠症状","id":"3001"},{"weightNo":"0","weightYes":"4","description":"\n\t照镜子发现舌苔发黄、厚腻，想用勺子刮薄儿一点，着实不容易⊙_⊙\n","weightSevere":"5","name":"舌苔黄腻","id":"720"},{"weightNo":"0","weightYes":"4","description":"\n\t对着镜子看舌头的颜色比正常的淡红色还深，有点深红色了⊙_⊙\n","weightSevere":"5","name":"舌头发红","id":"721"},{"weightNo":"0","weightYes":"4","description":"<p>\n\t照镜子看舌苔颜色白，像一层白纸⊙_⊙<\/p>\n","weightSevere":"5","name":"舌苔白","id":"3106"}]}
     * fieldError : null
     * msg : null
     * status : 0
     */

    private Object fieldError;
    private Object msg;
    private int status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public Object getFieldError() {
        return fieldError;
    }

    public void setFieldError(Object fieldError) {
        this.fieldError = fieldError;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class DataBean {
        private int diseaseId;
        /**
         * guidelines : <p align="left">
         本测评仅适合于普通感冒，即当有受凉、淋雨、过度疲劳等诱发因素，使全身或呼吸道局部防御功能降低时导致的上呼吸道感染。</p>
         <p align="left">
         注意同肺炎及其它感染出现的症状进行区分。</p>

         * description : null
         * name : 感冒
         * id : 22
         */

        private DiseaseBean disease;
        /**
         * weightNo : 0
         * weightYes : 4
         * description : <p>
         感冒来得快，一天就很严重了：（</p>

         * weightSevere : 5
         * name : 发病较急
         * id : 391
         */

        private List<QuestionListBean> questionList;

        public int getDiseaseId() {
            return diseaseId;
        }

        public void setDiseaseId(int diseaseId) {
            this.diseaseId = diseaseId;
        }

        public DiseaseBean getDisease() {
            return disease;
        }

        public void setDisease(DiseaseBean disease) {
            this.disease = disease;
        }

        public List<QuestionListBean> getQuestionList() {
            return questionList;
        }

        public void setQuestionList(List<QuestionListBean> questionList) {
            this.questionList = questionList;
        }

        public static class DiseaseBean {
            private String guidelines;
            private Object description;
            private String name;
            private String id;

            public String getGuidelines() {
                return guidelines;
            }

            public void setGuidelines(String guidelines) {
                this.guidelines = guidelines;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class QuestionListBean {
            private String weightNo;
            private String weightYes;
            private String description;
            private String weightSevere;
            private String name;
            private String id;

            public String getWeightNo() {
                return weightNo;
            }

            public void setWeightNo(String weightNo) {
                this.weightNo = weightNo;
            }

            public String getWeightYes() {
                return weightYes;
            }

            public void setWeightYes(String weightYes) {
                this.weightYes = weightYes;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getWeightSevere() {
                return weightSevere;
            }

            public void setWeightSevere(String weightSevere) {
                this.weightSevere = weightSevere;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
