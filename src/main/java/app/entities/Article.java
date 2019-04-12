package app.entities;

import java.util.Date;

public class Article {
    private int Id;
    private String Title;
    private String Content;
    private String Description;
    private Date PublicationDate;
    private int UserId;
    private int CategoryId;
    private Category Category;

    public Article() {
        Category = new Category();
    }

    public Article(int id, String title, String content,
                   Date publicationDate, int userId, int categoryId, String description){
        this.Id = id;
        this.Title = title;
        this.Content = content;
        this.PublicationDate = publicationDate;
        this.UserId = userId;
        this.CategoryId = categoryId;
        this.Description = description;
        Category = new Category();
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public app.entities.Category getCategory() {
        return Category;
    }

    public void setCategory(app.entities.Category category) {
        Category = category;
    }

}
