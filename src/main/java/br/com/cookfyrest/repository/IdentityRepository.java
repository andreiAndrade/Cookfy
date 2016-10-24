package br.com.cookfyrest.repository;

import br.com.cookfyrest.model.Identity;
import br.com.cookfyrest.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Andrei Andrade on 24/10/2016.
 */
public interface IdentityRepository extends PagingAndSortingRepository<Identity, Long> {

    Identity findByUser(User user);
}
