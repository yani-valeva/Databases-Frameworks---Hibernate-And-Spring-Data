package softuni.student.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.student.entities.Resource;
import softuni.student.repositories.ResourceRepository;
import softuni.student.services.ResourceService;

import java.util.List;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService<Resource, Long> {

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public Resource findById(Long id) {
        return resourceRepository.findOne(id);
    }

    @Override
    public void remove(Resource object) {
        resourceRepository.delete(object);
    }

    @Override
    public List<Resource> findAll() {
        return resourceRepository.findAll();
    }

    @Override
    public void save(Resource object) {
        resourceRepository.save(object);
    }
}
