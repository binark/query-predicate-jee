package com.binark.querypredicate.builder;

import com.binark.querypredicate.filter.BooleanFilter;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

/**
 * @author kenany (armelknyobe@gmail.com)
 *
 * The predicate builder for the {@link BooleanFilter} type
 */
public class BooleanFilterPredicateBuilder extends ComparableFilterPredicateBuilder<BooleanFilter>{

  @Override
  public Predicate buildPredicate(Path path, CriteriaBuilder builder, BooleanFilter filter, String fieldName) {
    List<Predicate> predicates = buildComparablePredicate(path, builder, filter, fieldName);

    if (filter.getTrue() != null) {
      predicates.add(builder.isTrue(path.get(fieldName)));
    }

    if (filter.getFalse() != null) {
      predicates.add(builder.isFalse(path.get(fieldName)));
    }

    return predicates.size() == 1 ? predicates.get(0) : builder.or(predicates.toArray(new Predicate[0]));
  }
}
