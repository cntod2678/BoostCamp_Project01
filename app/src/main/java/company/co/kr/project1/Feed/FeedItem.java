package company.co.kr.project1.Feed;

/**
 * Created by Dongjin on 2017. 7. 4..
 */

public class FeedItem {
    String type;
    String user_id;
    String title;
    String content;
    int profileImg;
    int imgSrc;
    int like;
    int comment;

    public FeedItem(String type, String user_id, String title, String content, int profileImg, int imgSrc, int like, int comment) {
        this.type = type;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.profileImg = profileImg;
        this.imgSrc = imgSrc;
        this.like = like;
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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


    public int getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(int profileImg) {
        this.profileImg = profileImg;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "FeedItem{" +
                "type='" + type + '\'' +
                ", user_id='" + user_id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgSrc=" + imgSrc +
                ", like=" + like +
                ", comment=" + comment +
                '}';
    }
}
