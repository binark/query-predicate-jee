package com.binark.querypredicate.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.binark.querypredicate.filter.LocalDateFilter;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.expression.LiteralExpression;
import org.hibernate.query.criteria.internal.predicate.BetweenPredicate;
import org.hibernate.query.criteria.internal.predicate.NegatedPredicateWrapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LocalDateFilterPredicateBuilderTest {

  @Mock(answer = Answers.RETURNS_SELF)
  private Path path;

  @Mock(answer = Answers.RETURNS_MOCKS)
  private SessionFactoryImpl sessionFactory;

  private CriteriaBuilder criteriaBuilder = new CriteriaBuilderImpl(sessionFactory);

  private LocalDateFilterPredicateBuilder predicateBuilder = new LocalDateFilterPredicateBuilder();

  @Test
  void buildPredicate_for_today() {
    LocalDateFilter localDateFilter = new LocalDateFilter();
    localDateFilter.setIsToday(true);

    Predicate predicate = predicateBuilder.buildPredicate(path, criteriaBuilder, localDateFilter,
        "today");

    assertNotNull(predicate);
    assertInstanceOf(BetweenPredicate.class, predicate);

    BetweenPredicate betweenPredicate = (BetweenPredicate) predicate;

    LiteralExpression<LocalDate> lowerBound = (LiteralExpression<LocalDate>) betweenPredicate.getLowerBound();
    LiteralExpression<LocalDate> upperBound = (LiteralExpression<LocalDate>) betweenPredicate.getUpperBound();

    assertEquals(LocalDate.now().atStartOfDay().toLocalDate(), lowerBound.getLiteral());
    assertEquals(LocalDate.now().atTime(LocalTime.MAX).toLocalDate(), upperBound.getLiteral());
  }

  @Test
  void buildPredicate_not_for_today() {
    LocalDateFilter localDateFilter = new LocalDateFilter();
    localDateFilter.setIsToday(false);

    Predicate predicate = predicateBuilder.buildPredicate(path, criteriaBuilder, localDateFilter,
        "today");

    assertNotNull(predicate);
    assertInstanceOf(NegatedPredicateWrapper.class, predicate);

    NegatedPredicateWrapper negatedPredicateWrapper = (NegatedPredicateWrapper) predicate;

    assertNotNull(negatedPredicateWrapper);
  }

  @Test
  void buildPredicate_for_tomorrow() {
    LocalDateFilter localDateFilter = new LocalDateFilter();
    localDateFilter.setIsTomorrow(true);

    Predicate predicate = predicateBuilder.buildPredicate(path, criteriaBuilder, localDateFilter,
        "tomorrow");

    assertNotNull(predicate);
    assertInstanceOf(BetweenPredicate.class, predicate);

    BetweenPredicate betweenPredicate = (BetweenPredicate) predicate;

    LiteralExpression<LocalDate> lowerBound = (LiteralExpression<LocalDate>) betweenPredicate.getLowerBound();
    LiteralExpression<LocalDate> upperBound = (LiteralExpression<LocalDate>) betweenPredicate.getUpperBound();

    assertEquals(LocalDate.now().plusDays(1).atStartOfDay().toLocalDate(), lowerBound.getLiteral());
    assertEquals(LocalDate.now().plusDays(1).atTime(LocalTime.MAX).toLocalDate(), upperBound.getLiteral());
  }

  @Test
  void buildPredicate_not_for_tomorrow() {
    LocalDateFilter localDateFilter = new LocalDateFilter();
    localDateFilter.setIsTomorrow(false);

    Predicate predicate = predicateBuilder.buildPredicate(path, criteriaBuilder, localDateFilter,
        "tomorrow");

    assertNotNull(predicate);
    assertInstanceOf(NegatedPredicateWrapper.class, predicate);

    NegatedPredicateWrapper negatedPredicateWrapper = (NegatedPredicateWrapper) predicate;

    assertNotNull(negatedPredicateWrapper);
  }

  @Test
  void buildPredicate_for_yesterday() {
    LocalDateFilter localDateFilter = new LocalDateFilter();
    localDateFilter.setIsYesterday(true);

    Predicate predicate = predicateBuilder.buildPredicate(path, criteriaBuilder, localDateFilter,
        "yesterday");

    assertNotNull(predicate);
    assertInstanceOf(BetweenPredicate.class, predicate);

    BetweenPredicate betweenPredicate = (BetweenPredicate) predicate;

    assertNotNull(betweenPredicate);

    LiteralExpression<LocalDate> lowerBound = (LiteralExpression<LocalDate>) betweenPredicate.getLowerBound();
    LiteralExpression<LocalDate> upperBound = (LiteralExpression<LocalDate>) betweenPredicate.getUpperBound();

    assertEquals(LocalDate.now().minusDays(1).atStartOfDay().toLocalDate(), lowerBound.getLiteral());
    assertEquals(LocalDate.now().minusDays(1).atTime(LocalTime.MAX).toLocalDate(), upperBound.getLiteral());
  }

  @Test
  void buildPredicate_not_for_yesterday() {
    LocalDateFilter localDateFilter = new LocalDateFilter();
    localDateFilter.setIsYesterday(false);

    Predicate predicate = predicateBuilder.buildPredicate(path, criteriaBuilder, localDateFilter,
        "yesterday");

    assertNotNull(predicate);
    assertInstanceOf(NegatedPredicateWrapper.class, predicate);

    NegatedPredicateWrapper negatedPredicateWrapper = (NegatedPredicateWrapper) predicate;

    assertNotNull(negatedPredicateWrapper);
  }
}