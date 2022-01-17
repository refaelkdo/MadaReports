enum indexes {
    IDNum(0),
    IDType(1),
    FIRST_NAME(2),
    LAST_NAME(3),
    CITY(5),
    STREET(6),
    BUILDING_NUMBER(7),
    BARCODE(8),
    BIRTH_DATE(5),
    LABCODE(7),
    RESULT_DATE(11),
    TAKE_DATE(10),
    STICKER_NUMBER(7),
    RESULT_TEST_CORONA(8),
    VARIANT(9),
    TEST_TYPE(10);

    public int value;

    indexes(int value) {
        this.value = value;
    }
}