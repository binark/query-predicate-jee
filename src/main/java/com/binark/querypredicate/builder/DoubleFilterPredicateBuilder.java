package com.binark.querypredicate.builder;

import com.binark.querypredicate.filter.DoubleFilter;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

/**
 * <p>The predicate builder for the {@link DoubleFilter} type. Extends all features from {@link NumericFilterPredicateBuilder}</p>
 *
 * @author kenany (armelknyobe@gmail.com)
 */
public class DoubleFilterPredicateBuilder extends NumericFilterPredicateBuilder<DoubleFilter>{

  @Override
  public Predicate buildPredicate(Path path, CriteriaBuilder builder, DoubleFilter filter,
      String fieldName) {
    List<Predicate> predicates = buildNumericPredicate(path, builder, filter, fieldName);
    return predicates.size() == 1 ? predicates.get(0) : builder.or(predicates.toArray(new Predicate[0]));
  }
}
