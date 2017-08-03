package softuni.bookshop.services;

import java.util.List;

public interface CategoryService<Category, Long> extends InterfaceService<Category, Long>{
    List<Category> findByNameIn(String[] names);
    List<Object[]> findTotalProfitOfBooksByCategory();
}
