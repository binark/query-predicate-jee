package com.binark.querypredicate.utils;

import com.binark.querypredicate.annotation.FilterClass;
import com.binark.querypredicate.builder.PredicateBuilder;
import java.lang.reflect.Field;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

@FilterClass(TestFilter.class)
public class TestFilterPredicateBuilder implements PredicateBuilder<TestFilter> {

  @Override
  public Predicate buildPredicate(Path path, CriteriaBuilder builder, TestFilter filter,
      String fieldName) {
    return null;
  }

  @Override
  public String getFieldNameFromAnnotation(Field field) {
    return null;
  }
}
