package com.sanweibook.jhook.generator;

/**
 * Created by twg on 17/3/23.
 */
public enum FileTypeEnum {
    ENTITY(0, "entity.ftl"),
    SERVICE(1, "service.ftl"),
    DAO(2, "dao.ftl"),
    MAPPER(3, "mapper.ftl"),
    SERVICEIMPL(4, "serviceImpl.ftl");

    private final int typeCode;
    private final String typeCodeName;

    private FileTypeEnum(int i, String s) {
        typeCode = i;
        typeCodeName = s;
    }

    public static String fileTypeName(int typeCode){
        FileTypeEnum[] type = FileTypeEnum.values();
        for (FileTypeEnum fileTypeEnum : type) {
            if (typeCode == fileTypeEnum.getTypeCode()){
                return fileTypeEnum.getTypeCodeName();
            }
        }
        return "";
    }

    public int getTypeCode() {
        return typeCode;
    }

    public String getTypeCodeName() {
        return typeCodeName;
    }

}
