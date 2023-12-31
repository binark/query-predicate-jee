package com.binark.querypredicate.management;

import com.binark.querypredicate.builder.BaseFilterPredicateBuilder;
import com.binark.querypredicate.builder.BooleanFilterPredicateBuilder;
import com.binark.querypredicate.builder.DateFilterPredicateBuilder;
import com.binark.querypredicate.builder.DoubleFilterPredicateBuilder;
import com.binark.querypredicate.builder.FloatFilterPredicateBuilder;
import com.binark.querypredicate.builder.IntegerFilterPredicateBuilder;
import com.binark.querypredicate.builder.LocalDateFilterPredicateBuilder;
import com.binark.querypredicate.builder.LongFilterPredicateBuilder;
import com.binark.querypredicate.builder.PredicateBuilder;
import com.binark.querypredicate.builder.StringFilterPredicateBuilder;
import com.binark.querypredicate.filter.BaseFilter;
import com.binark.querypredicate.filter.BooleanFilter;
import com.binark.querypredicate.filter.DateFilter;
import com.binark.querypredicate.filter.DoubleFilter;
import com.binark.querypredicate.filter.FloatFilter;
import com.binark.querypredicate.filter.IntegerFilter;
import com.binark.querypredicate.filter.LocalDateFilter;
import com.binark.querypredicate.filter.LongFilter;
import com.binark.querypredicate.filter.StringFilter;
import java.util.HashMap;
import java.util.Map;

/**
 * The base predicate builder storage.
 *
 * Stores a predicate builder with the key that could be one of:
 * <li>The filter class name</li>
 * <>The filter class annotation value</>
 * @see com.binark.querypredicate.annotation.FilterClass
 * @see PredicateBuilderRegistry
 *
 * Used to resolver predicate builders from a key
 * @see BasePredicateBuilderResolver
 *
 * @author kenany (armelknyobe@gmail.com)
 */
final class BasePredicateBuilderStorage implements PredicateBuilderStorage {

    private final Map<String, PredicateBuilder> predicateBuilderMap = new HashMap<>();

    private static BasePredicateBuilderStorage INSTANCE;

    private BasePredicateBuilderStorage() {
        initializeStorage();
    }

    static BasePredicateBuilderStorage getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BasePredicateBuilderStorage();
        }
        return INSTANCE;
    }

    public PredicateBuilder getPredicateBuilder(String key) {
        return predicateBuilderMap.get(key);
    }

    public void addPredicateBuilder(String key, PredicateBuilder predicateBuilder) {
        predicateBuilderMap.put(key, predicateBuilder);
    }

    public void initializeStorage() {
        predicateBuilderMap.put(BaseFilter.class.getSimpleName(), new BaseFilterPredicateBuilder());
        predicateBuilderMap.put(StringFilter.class.getSimpleName(), new StringFilterPredicateBuilder());
        predicateBuilderMap.put(BooleanFilter.class.getSimpleName(), new BooleanFilterPredicateBuilder());
        predicateBuilderMap.put(DateFilter.class.getSimpleName(), new DateFilterPredicateBuilder());
        predicateBuilderMap.put(LocalDateFilter.class.getSimpleName(), new LocalDateFilterPredicateBuilder());
        predicateBuilderMap.put(IntegerFilter.class.getSimpleName(), new IntegerFilterPredicateBuilder());
        predicateBuilderMap.put(LongFilter.class.getSimpleName(), new LongFilterPredicateBuilder());
        predicateBuilderMap.put(FloatFilter.class.getSimpleName(), new FloatFilterPredicateBuilder());
        predicateBuilderMap.put(DoubleFilter.class.getSimpleName(), new DoubleFilterPredicateBuilder());
    }
}
