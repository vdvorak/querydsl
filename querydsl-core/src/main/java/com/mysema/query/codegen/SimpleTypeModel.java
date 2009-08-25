/*
 * Copyright (c) 2009 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.codegen;

import javax.annotation.Nullable;

import com.mysema.commons.lang.Assert;

/**
 * SimpleTypeModel is a minimal implementation of the TypeModel interface
 * 
 * @author tiwe
 *
 */
public class SimpleTypeModel implements TypeModel {

    protected TypeCategory typeCategory = TypeCategory.ENTITY;

    protected String name, packageName, simpleName, localName;

    @Nullable
    protected TypeModel keyType, valueType;

    protected SimpleTypeModel(){}
    
    public SimpleTypeModel(
            TypeCategory typeCategory, 
            String fullName,
            String packageName, 
            String simpleName, 
            @Nullable TypeModel keyType,
            @Nullable TypeModel valueType) {
        this.typeCategory = Assert.notNull(typeCategory,"typeCategory is null");
        this.name = Assert.notNull(fullName,"fullName is null");
        this.packageName = Assert.notNull(packageName,"packageName is null");
        this.simpleName = Assert.notNull(simpleName,"simpleName is null");
        this.keyType = keyType;
        this.valueType = valueType;
    }

    @Override
    public TypeCategory getTypeCategory() {
        return typeCategory;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public TypeModel getKeyType() {
        return keyType;
    }

    @Override
    public String getPackageName() {
        return packageName;
    }

    @Override
    public String getSimpleName() {
        return simpleName;
    }
    
    public String getLocalName(){
        if (localName == null){
            localName = name.substring(packageName.length()+1);
        }
        return localName;
    }

    @Override
    public TypeModel getValueType() {
        return valueType;
    }
    
    public String toString() {
        return name;
    }


}
