package com.example.oskin.lesson7.Data;

public enum ItemTypes {
    CALL(0),
    SMS(1),
    SBOL(2),
    OTHER_ITEM(3);

    private int type;

    ItemTypes(int type){
        this.type = type;
    }

    public int getType(){
        return type;
    }
}
