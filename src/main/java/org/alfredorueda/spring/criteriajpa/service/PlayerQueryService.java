package org.alfredorueda.spring.criteriajpa.service;

import java.util.List;
import javax.persistence.criteria.JoinType;
import org.alfredorueda.spring.criteriajpa.domain.*; // for static metamodels
import org.alfredorueda.spring.criteriajpa.domain.Player;
import org.alfredorueda.spring.criteriajpa.repository.PlayerRepository;
import org.alfredorueda.spring.criteriajpa.service.criteria.PlayerCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Player} entities in the database.
 * The main input is a {@link PlayerCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Player} or a {@link Page} of {@link Player} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PlayerQueryService extends QueryService<Player> {

    private final Logger log = LoggerFactory.getLogger(PlayerQueryService.class);

    private final PlayerRepository playerRepository;

    public PlayerQueryService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /**
     * Return a {@link List} of {@link Player} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Player> findByCriteria(PlayerCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Player> specification = createSpecification(criteria);
        return playerRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Player} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Player> findByCriteria(PlayerCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Player> specification = createSpecification(criteria);
        return playerRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PlayerCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Player> specification = createSpecification(criteria);
        return playerRepository.count(specification);
    }

    /**
     * Function to convert {@link PlayerCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Player> createSpecification(PlayerCriteria criteria) {
        Specification<Player> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Player_.id));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), Player_.name));
            }
            if (criteria.getBirthDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBirthDate(), Player_.birthDate));
            }
            if (criteria.getHeight() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getHeight(), Player_.height));
            }
            if (criteria.getWeight() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getWeight(), Player_.weight));
            }
            if (criteria.getBaskets() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBaskets(), Player_.baskets));
            }
            if (criteria.getAssists() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getAssists(), Player_.assists));
            }
            if (criteria.getTeamId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getTeamId(), root -> root.join(Player_.team, JoinType.LEFT).get(Team_.id))
                    );
            }
        }
        return specification;
    }
}
