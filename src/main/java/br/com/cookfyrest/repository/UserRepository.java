package br.com.cookfyrest.repository;

import br.com.cookfyrest.model.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Andrei Andrade on 24/10/2016.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    //"SELECT c.nome FROM Cliente c where c.id = :id"
    User findByUsernameOrEmail(String username, String email);
}
