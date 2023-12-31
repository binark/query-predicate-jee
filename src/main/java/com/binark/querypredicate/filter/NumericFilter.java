package com.binark.querypredicate.filter;

/**
 * The numeric filter type class. extends {@link ComparableFilter}
 * @see ComparableFilter
 *
 * @param <T> The numeric type, must extends {@link Number} and {@link Comparable}
 *
 * @author kenany (armelknyobe@gmail.com)
 */
public abstract class NumericFilter<T extends Number & Comparable> extends ComparableFilter<T>{

}
