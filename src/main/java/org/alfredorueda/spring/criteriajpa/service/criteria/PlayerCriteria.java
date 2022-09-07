package org.alfredorueda.spring.criteriajpa.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link org.alfredorueda.spring.criteriajpa.domain.Player} entity. This class is used
 * in {@link org.alfredorueda.spring.criteriajpa.web.rest.PlayerResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /players?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PlayerCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter name;

    private LocalDateFilter birthDate;

    private DoubleFilter height;

    private DoubleFilter weight;

    private IntegerFilter baskets;

    private IntegerFilter assists;

    private LongFilter teamId;

    private Boolean distinct;

    public PlayerCriteria() {}

    public PlayerCriteria(PlayerCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.name = other.name == null ? null : other.name.copy();
        this.birthDate = other.birthDate == null ? null : other.birthDate.copy();
        this.height = other.height == null ? null : other.height.copy();
        this.weight = other.weight == null ? null : other.weight.copy();
        this.baskets = other.baskets == null ? null : other.baskets.copy();
        this.assists = other.assists == null ? null : other.assists.copy();
        this.teamId = other.teamId == null ? null : other.teamId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public PlayerCriteria copy() {
        return new PlayerCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getName() {
        return name;
    }

    public StringFilter name() {
        if (name == null) {
            name = new StringFilter();
        }
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public LocalDateFilter getBirthDate() {
        return birthDate;
    }

    public LocalDateFilter birthDate() {
        if (birthDate == null) {
            birthDate = new LocalDateFilter();
        }
        return birthDate;
    }

    public void setBirthDate(LocalDateFilter birthDate) {
        this.birthDate = birthDate;
    }

    public DoubleFilter getHeight() {
        return height;
    }

    public DoubleFilter height() {
        if (height == null) {
            height = new DoubleFilter();
        }
        return height;
    }

    public void setHeight(DoubleFilter height) {
        this.height = height;
    }

    public DoubleFilter getWeight() {
        return weight;
    }

    public DoubleFilter weight() {
        if (weight == null) {
            weight = new DoubleFilter();
        }
        return weight;
    }

    public void setWeight(DoubleFilter weight) {
        this.weight = weight;
    }

    public IntegerFilter getBaskets() {
        return baskets;
    }

    public IntegerFilter baskets() {
        if (baskets == null) {
            baskets = new IntegerFilter();
        }
        return baskets;
    }

    public void setBaskets(IntegerFilter baskets) {
        this.baskets = baskets;
    }

    public IntegerFilter getAssists() {
        return assists;
    }

    public IntegerFilter assists() {
        if (assists == null) {
            assists = new IntegerFilter();
        }
        return assists;
    }

    public void setAssists(IntegerFilter assists) {
        this.assists = assists;
    }

    public LongFilter getTeamId() {
        return teamId;
    }

    public LongFilter teamId() {
        if (teamId == null) {
            teamId = new LongFilter();
        }
        return teamId;
    }

    public void setTeamId(LongFilter teamId) {
        this.teamId = teamId;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PlayerCriteria that = (PlayerCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(name, that.name) &&
            Objects.equals(birthDate, that.birthDate) &&
            Objects.equals(height, that.height) &&
            Objects.equals(weight, that.weight) &&
            Objects.equals(baskets, that.baskets) &&
            Objects.equals(assists, that.assists) &&
            Objects.equals(teamId, that.teamId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, height, weight, baskets, assists, teamId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PlayerCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (name != null ? "name=" + name + ", " : "") +
            (birthDate != null ? "birthDate=" + birthDate + ", " : "") +
            (height != null ? "height=" + height + ", " : "") +
            (weight != null ? "weight=" + weight + ", " : "") +
            (baskets != null ? "baskets=" + baskets + ", " : "") +
            (assists != null ? "assists=" + assists + ", " : "") +
            (teamId != null ? "teamId=" + teamId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
