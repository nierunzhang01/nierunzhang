package com.bw.nierunzhang1710a20200302.bean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.2<p>
 * <p>更改时间：2020.3.2<p>
 */
public class LouterBean  {
    //⑧　封装网络响应数据对应的Bean类，并把网络响应数据转换成Bean对象。
    /**
     * code : 200
     * listdata : [{"title":"\u201c一大会址\u201d又一年｜跟着馆长重走瞻仰之路，初心未变","content":"对于中共一大会址纪念馆副馆长徐明来说，今天和往常一样，是一个普通的工作日。但两年前，习近平总书记一行的来访，又让今天成为了一个值得纪念的日子。","type":"浦江头条","itemType":1,"imageurl":"http://image.thepaper.cn/www/image/35/994/715.jpg","publishedAt":"7分前"},{"title":"这届老年人卖房住进敬老院？把欢乐和尊严装进晚年生活","content":"全国老龄工作委员会办公室近日公布数据称，从1999年进入人口老龄化社会到2018年，中国老年人口净增1.18亿，成为目前世界上唯一老年人口超过2亿的国家。","type":"绿政公署","itemType":1,"imageurl":"https://image.thepaper.cn/image/35/994/855.jpg","publishedAt":"9分前"},{"title":"金正恩发唁电，深切哀悼文在寅母亲去世","content":"韩国青瓦台发言人高旼廷10月31日表示，朝鲜最高领导人金正恩30日向韩国总统文在寅发来唁电，哀悼其母亲姜韩玉女士。姜女士于29日去世，享年92岁。","type":"澎湃国际","itemType":2,"imageurl":"https://image1.thepaper.cn/image/35/994/838.jpg","publishedAt":"24分前"},{"title":"教育部：对挪用义务教育阶段寄宿生生活补助\u201c零容忍\u201d","content":"教育部对截留克扣义务教育阶段寄宿生生活补助专项整治态度坚决，对截留克扣挪用等违纪违法问题\u201c零容忍\u201d，坚持严查严惩严办，绝不姑息。","type":"教育家","itemType":1,"imageurl":"https://image.thepaper.cn/image/35/994/810.jpg","publishedAt":"29分前"},{"title":"山东：2020年主汛期前将修复946处水毁工程","content":"为补齐水利基础设施短板，山东将投资1323.38亿元加快重点水利工程建设，其中包括2020年主汛期前完成946处水毁工程修复任务。","type":"绿政公署","itemType":1,"imageurl":"http://image.thepaper.cn/www/image/35/994/730.png","publishedAt":"33分前"},{"title":"日防卫省：奥运前或在东京部署升级版爱国者-3导弹拦截器","content":"10月30日，日本防卫省的消息人士透露称，日本防卫省正考虑在2020年夏季奥运会之前，在东京市区部署升级版的爱国者先进能力-3型导弹拦截器。","type":"澎湃国际","itemType":2,"imageurl":"http://image.thepaper.cn/www/image/35/994/565.jpg","publishedAt":"55分前"}]
     */

    private String code;
    private List<ListdataBean> listdata;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ListdataBean> getListdata() {
        return listdata;
    }

    public void setListdata(List<ListdataBean> listdata) {
        this.listdata = listdata;
    }

    public static class ListdataBean {
        /**
         * title : “一大会址”又一年｜跟着馆长重走瞻仰之路，初心未变
         * content : 对于中共一大会址纪念馆副馆长徐明来说，今天和往常一样，是一个普通的工作日。但两年前，习近平总书记一行的来访，又让今天成为了一个值得纪念的日子。
         * type : 浦江头条
         * itemType : 1
         * imageurl : http://image.thepaper.cn/www/image/35/994/715.jpg
         * publishedAt : 7分前
         */

        private String title;
        private String content;
        private String type;
        private int itemType;
        private String imageurl;
        private String publishedAt;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getItemType() {
            return itemType;
        }

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }
    }
}
