package br.com.cookfyrest.service;

import br.com.cookfyrest.entity.Authentication;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AuthenticationRepository extends PagingAndSortingRepository<Authentication, Long> {

}
