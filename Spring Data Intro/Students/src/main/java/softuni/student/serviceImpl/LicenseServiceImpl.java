package softuni.student.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.student.entities.License;
import softuni.student.repositories.LicenseRepository;
import softuni.student.services.LicenseService;

import java.util.List;

@Service
@Transactional
public class LicenseServiceImpl implements LicenseService<License, Long> {

    @Autowired
    private LicenseRepository licenseRepository;

    @Override
    public License findById(Long id) {
        return licenseRepository.findOne(id);
    }

    @Override
    public void remove(License object) {
        licenseRepository.delete(object);
    }

    @Override
    public List<License> findAll() {
        return licenseRepository.findAll();
    }

    @Override
    public void save(License object) {
        licenseRepository.save(object);
    }
}
