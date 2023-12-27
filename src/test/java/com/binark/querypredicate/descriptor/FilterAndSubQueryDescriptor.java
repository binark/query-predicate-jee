package com.binark.querypredicate.descriptor;

import com.binark.querypredicate.filter.StringFilter;

public class FilterAndSubQueryDescriptor implements QueryDescriptor{

    private StringFilter firstName;

    private SimpleQueryDescriptor subField;

    public StringFilter getFirstName() {
        return firstName;
    }

    public void setFirstName(StringFilter firstName) {
        this.firstName = firstName;
    }

    public SimpleQueryDescriptor getSubField() {
        return subField;
    }

    public void setSubField(SimpleQueryDescriptor subField) {
        this.subField = subField;
    }
}
