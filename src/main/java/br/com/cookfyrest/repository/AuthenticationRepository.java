package br.com.cookfyrest.repository;

import br.com.cookfyrest.model.entity.Authentication;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Andrei Andrade on 24/10/2016.
 */
public interface AuthenticationRepository extends PagingAndSortingRepository<Authentication, Long> {
}
