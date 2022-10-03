package za.ac.cput.service.impl;
/* MenuServiceImpl.java
 Entity for the Menu
 Author: Blaine Simpson (218020171)


 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Item;
import za.ac.cput.entity.Menu;
import za.ac.cput.repository.IMenuRepository;
import za.ac.cput.service.IMenuService;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements IMenuService {
    private final IMenuRepository repository;

    @Autowired
    public MenuServiceImpl(IMenuRepository repository) {
        this.repository = repository;
    }

    @Override
    public Menu save(Menu menu) {
        return this.repository.save(menu);
    }

    @Override
    public Optional<Menu> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Menu menu) {
        this.repository.delete(menu);
    }

    @Override
    public List<Menu> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Menu> menu = findById(id);
        if (menu.isPresent()){
            delete(menu.get());
        }

    }
}
