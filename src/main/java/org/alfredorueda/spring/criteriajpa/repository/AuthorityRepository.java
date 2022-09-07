package org.alfredorueda.spring.criteriajpa.repository;

import org.alfredorueda.spring.criteriajpa.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
