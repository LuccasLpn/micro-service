package br.com.microserviceproducer.modules.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ShippingEnum {

    ENVIADO(1, "Enviado"),
    CANCELADO(2, "Cancelado");

    private int cod;
    private String description;

    public static ShippingEnum toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }
        for(ShippingEnum x : ShippingEnum.values()){
            if(cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("ID invalido: " + cod);
    }
}
