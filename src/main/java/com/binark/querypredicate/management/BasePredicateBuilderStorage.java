package com.binark.querypredicate.management;

import com.binark.querypredicate.builder.BaseFilterPredicateBuilder;
import com.binark.querypredicate.builder.BooleanFilterPredicateBuilder;
import com.binark.querypredicate.builder.ComparableFilterPredicateBuilder;
import com.binark.querypredicate.builder.NumericFilterPredicateBuilder;
import com.binark.querypredicate.builder.PredicateBuilder;
import com.binark.querypredicate.builder.StringFilterPredicateBuilder;
import com.binark.querypredicate.filter.BaseFilter;
import com.binark.querypredicate.filter.BooleanFilter;
import com.binark.querypredicate.filter.ComparableFilter;
import com.binark.querypredicate.filter.NumericFilter;
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
 * @see PredicateBuilderResolver
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

    /**
     * Initialize the storage with the built-in predicate builder
     */
    private void initializeStorage() {
        predicateBuilderMap.put(BaseFilter.class.getSimpleName(), new BaseFilterPredicateBuilder());
        predicateBuilderMap.put(StringFilter.class.getSimpleName(), new StringFilterPredicateBuilder());
        predicateBuilderMap.put(BooleanFilter.class.getSimpleName(), new BooleanFilterPredicateBuilder());
        predicateBuilderMap.put(ComparableFilter.class.getSimpleName(), new ComparableFilterPredicateBuilder());
        predicateBuilderMap.put(NumericFilter.class.getSimpleName(), new NumericFilterPredicateBuilder());
    }
}
