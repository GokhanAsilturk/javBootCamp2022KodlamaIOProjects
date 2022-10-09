package entities;

import business.TranslateManager;

public class Category {

    private String categoryName;
    private String id;

    public Category(){

    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getId() {
        TranslateManager translate = new TranslateManager();
        return translate.TurkishToEnglish(categoryName.replaceAll("\\s","").toLowerCase());
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }



}
