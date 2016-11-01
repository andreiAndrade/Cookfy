package br.com.cookfyrest.repository;

import br.com.cookfyrest.model.entity.Identity;
import br.com.cookfyrest.model.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Andrei Andrade on 24/10/2016.
 */
public interface IdentityRepository extends PagingAndSortingRepository<Identity, Long> {

    Identity findByUser(User user);
}
