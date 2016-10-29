package br.com.cookfyrest.repository;

import br.com.cookfyrest.model.React;
import br.com.cookfyrest.model.User;
import br.com.cookfyrest.model.domain.ReactDomain;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Andrei Andrade on 28/10/2016.
 */
public interface ReactRepository extends PagingAndSortingRepository<React, Long> {

    List<React> findByUser(User user);

    List<React> findByReactAndUser(ReactDomain react, User users);

}