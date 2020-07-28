package mate.academy.springbootapp.service.impl;

import lombok.AllArgsConstructor;
import mate.academy.springbootapp.model.Role;
import mate.academy.springbootapp.repository.RoleRepository;
import mate.academy.springbootapp.service.RoleService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public Role add(Role role) {
        return repository.save(role);
    }

    @Override
    public Role findByName(Role.RoleName name) {
        return repository.findByName(name);
    }
}
