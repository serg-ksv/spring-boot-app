package mate.academy.springbootapp.service;

import mate.academy.springbootapp.model.Role;

public interface RoleService {
    Role add(Role role);

    Role findByName(Role.RoleName name);
}
