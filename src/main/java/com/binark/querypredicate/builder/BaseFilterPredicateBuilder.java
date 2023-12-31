package com.binark.querypredicate.builder;


import com.binark.querypredicate.filter.BaseFilter;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

/**
 * @author kenany (armelknyobe@gmail.com)
 *
 * The predicate builder for the {@link BaseFilter} type
 */
public class BaseFilterPredicateBuilder extends AbstractPredicateBuilder<BaseFilter>{

    @Override
    public Predicate buildPredicate(Path path, CriteriaBuilder builder, BaseFilter filter, String fieldName) {
        List<Predicate> predicates = buildBaseFilterPredicate(path, builder, filter, fieldName);
        return predicates.size() == 1 ? predicates.get(0) : builder.or(predicates.toArray(new Predicate[0]));
    }
}
