package app.entities;

import java.util.Date;

public class Article {
    private int Id;
    private String Title;
    private String Content;
    private Date PublicationDate;
    private int UserId;

    public Article(String title, String content, Date publicationDate, int userId){
        this.Title = title;
        this.Content = content;
        this.PublicationDate = publicationDate;
        this.UserId = userId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getPublicationDate() {
        return PublicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        PublicationDate = publicationDate;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }
}
