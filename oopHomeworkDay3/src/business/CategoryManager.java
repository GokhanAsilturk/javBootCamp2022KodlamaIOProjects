package business;

import core.logging.ILogger;
import dataAccess.Interface.ICategoryDao;
import entities.Category;

import java.util.List;

public class CategoryManager {

    private ICategoryDao iCategoryDao;
    private ILogger[] loggers;
    private List<Category> categories;
    private TranslateManager translate;

    public CategoryManager(ICategoryDao iCategoryDao, ILogger[] loggers, List<Category> categories) {
        this.iCategoryDao = iCategoryDao;
        this.loggers = loggers;
        this.categories = categories;
    }

    public void add(Category category) throws Exception {

        for (Category tempCategory : categories){
            if(translate.TurkishToEnglish(tempCategory.getCategoryName().toLowerCase())==translate.TurkishToEnglish(category.getCategoryName().toLowerCase())){ //String karşılaştırma için 'equals' mothodu da kullanılabilir.
                throw new Exception("There cannot be more than one category with the same name. : " + tempCategory.getCategoryName() + " = " + category.getCategoryName());
            }
        }

        iCategoryDao.add(category);
        categories.add(category);

        for(ILogger logger : loggers){
            logger.log(category.getCategoryName());
        }
    }


}
