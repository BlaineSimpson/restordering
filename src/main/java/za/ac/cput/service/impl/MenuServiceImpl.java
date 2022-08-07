package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.Menu;
import za.ac.cput.repository.IMenuRepository;
import za.ac.cput.service.IMenuService;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements IMenuService {
    private final IMenuRepository mrepository;

    public MenuServiceImpl(IMenuRepository mrepository) {
        this.mrepository = mrepository;
    }

    @Override
    public Menu save(Menu menu) {
        return null;
    }

    @Override
    public Optional<Menu> findById(String s) {
        return Optional.empty();
    }

    @Override
    public void delete(Menu menu) {

    }

    @Override
    public List<Menu> findAll() {
        return null;
    }

    @Override
    public void deleteById(String s) {

    }
}
