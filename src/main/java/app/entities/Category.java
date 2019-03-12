package app.entities;

import java.util.Date;

public class Category {
    private int Id;
    private String Title;
    private Date UpdateDate;

    public Category(int id, String title, Date updatedate){
        this.Id = id;
        this.Title = title;
        this.UpdateDate = updatedate;
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

    public Date getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Date updateDate) {
        UpdateDate = updateDate;
    }
}
