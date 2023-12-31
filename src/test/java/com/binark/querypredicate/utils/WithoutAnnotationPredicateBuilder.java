package com.binark.querypredicate.utils;

import com.binark.querypredicate.builder.PredicateBuilder;
import com.binark.querypredicate.filter.Filter;
import java.lang.reflect.Field;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

public class WithoutAnnotationPredicateBuilder implements PredicateBuilder {

  @Override
  public Predicate buildPredicate(Path path, CriteriaBuilder builder, Filter filter,
      String fieldName) {
    return null;
  }

  @Override
  public String getFieldNameFromAnnotation(Field field) {
    return null;
  }
}
