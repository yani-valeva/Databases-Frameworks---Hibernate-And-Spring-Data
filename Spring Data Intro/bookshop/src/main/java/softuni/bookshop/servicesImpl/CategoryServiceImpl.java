package softuni.bookshop.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.bookshop.entities.Category;
import softuni.bookshop.repositories.CategoryRepository;
import softuni.bookshop.services.CategoryService;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService<Category, Long> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void remove(Category object) {
        categoryRepository.delete(object);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category object) {
        categoryRepository.save(object);
    }
}
