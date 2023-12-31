package com.binark.querypredicate.builder;

import com.binark.querypredicate.filter.FloatFilter;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

/**
 * <p>The predicate builder for the {@link FloatFilter} type. Extends all features from {@link NumericFilterPredicateBuilder}</p>
 *
 * @author kenany (armelknyobe@gmail.com)
 */
public class FloatFilterPredicateBuilder extends NumericFilterPredicateBuilder<FloatFilter>{

  @Override
  public Predicate buildPredicate(Path path, CriteriaBuilder builder, FloatFilter filter,
      String fieldName) {
    List<Predicate> predicates = buildNumericPredicate(path, builder, filter, fieldName);
    return predicates.size() == 1 ? predicates.get(0) : builder.or(predicates.toArray(new Predicate[0]));
  }
}
