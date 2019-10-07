package com.trilogyed.tasker.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class Task {
    @Null
    private int id;
    @NotEmpty(message = "You must supply a value for Description.")
    @Size(max = 255, message = "Description maximum is 255 characters in length.")
    private String description;
    @NotEmpty(message = "You must supply a value for Create Date in the format of YYYY-MM-DD.")
    private LocalDate createDate;
    @NotEmpty(message = "You must supply a value for Due Date in the format of YYYY-MM-DD.")
    private LocalDate dueDate;
    @Size(max = 50, message = "Category maximum is 50 characters in length.")
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(description, task.description) &&
                Objects.equals(createDate, task.createDate) &&
                Objects.equals(dueDate, task.dueDate) &&
                Objects.equals(category, task.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, createDate, dueDate, category);
    }
}
