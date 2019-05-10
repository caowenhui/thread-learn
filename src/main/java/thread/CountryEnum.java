package thread;


import lombok.Getter;

public enum CountryEnum {
    ONE(1,"齐国"),TWO(2,"楚国"),THREE(3,"燕国"),FOUR(4,"赵国"),FIVE(5,"魏国"),SIX(6,"韩国");
    @Getter private Integer retCode;
    @Getter private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static CountryEnum forEachCountryEnum(int index){
        for (CountryEnum element : CountryEnum.values()) {
            if(index == element.getRetCode()){
                return element;
            }
        }
        return null;
    }

}