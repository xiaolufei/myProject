package com.testssm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * article
 * @author 
 */
public class Article implements Serializable {
    private Integer id;

    /**
     * 内容ID
     */
    private Integer contentid;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String abstr;

    /**
     * 类别
     */
    private String categoryid;

    private String categoryvalue;

    /**
     * 图片地址
     */
    private String imgurl;

    /**
     * 创建日期
     */
    private Date createdate;

    /**
     * 1为热门文章
     */
    private String top;

    /**
     * 关键字
     */
    private String key;

    private String keyvalue;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContentid() {
        return contentid;
    }

    public void setContentid(Integer contentid) {
        this.contentid = contentid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstr() {
        return abstr;
    }

    public void setAbstr(String abstr) {
        this.abstr = abstr;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryvalue() {
        return categoryvalue;
    }

    public void setCategoryvalue(String categoryvalue) {
        this.categoryvalue = categoryvalue;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyvalue() {
        return keyvalue;
    }

    public void setKeyvalue(String keyvalue) {
        this.keyvalue = keyvalue;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Article other = (Article) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getContentid() == null ? other.getContentid() == null : this.getContentid().equals(other.getContentid()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getAbstr() == null ? other.getAbstr() == null : this.getAbstr().equals(other.getAbstr()))
            && (this.getCategoryid() == null ? other.getCategoryid() == null : this.getCategoryid().equals(other.getCategoryid()))
            && (this.getCategoryvalue() == null ? other.getCategoryvalue() == null : this.getCategoryvalue().equals(other.getCategoryvalue()))
            && (this.getImgurl() == null ? other.getImgurl() == null : this.getImgurl().equals(other.getImgurl()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getTop() == null ? other.getTop() == null : this.getTop().equals(other.getTop()))
            && (this.getKey() == null ? other.getKey() == null : this.getKey().equals(other.getKey()))
            && (this.getKeyvalue() == null ? other.getKeyvalue() == null : this.getKeyvalue().equals(other.getKeyvalue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getContentid() == null) ? 0 : getContentid().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getAbstr() == null) ? 0 : getAbstr().hashCode());
        result = prime * result + ((getCategoryid() == null) ? 0 : getCategoryid().hashCode());
        result = prime * result + ((getCategoryvalue() == null) ? 0 : getCategoryvalue().hashCode());
        result = prime * result + ((getImgurl() == null) ? 0 : getImgurl().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getTop() == null) ? 0 : getTop().hashCode());
        result = prime * result + ((getKey() == null) ? 0 : getKey().hashCode());
        result = prime * result + ((getKeyvalue() == null) ? 0 : getKeyvalue().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", contentid=").append(contentid);
        sb.append(", title=").append(title);
        sb.append(", abstr=").append(abstr);
        sb.append(", categoryid=").append(categoryid);
        sb.append(", categoryvalue=").append(categoryvalue);
        sb.append(", imgurl=").append(imgurl);
        sb.append(", createdate=").append(createdate);
        sb.append(", top=").append(top);
        sb.append(", key=").append(key);
        sb.append(", keyvalue=").append(keyvalue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}