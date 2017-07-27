package softuni.users.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.users.entities.Town;
import softuni.users.repositories.TownRepository;
import softuni.users.services.TownService;

@Service
@Transactional
public class TownServiceImpl implements TownService{

    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public void persist(Town town) {
        this.townRepository.save(town);
    }
}
