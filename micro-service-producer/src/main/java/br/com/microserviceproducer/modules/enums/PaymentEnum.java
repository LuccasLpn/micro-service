package br.com.microserviceproducer.modules.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum PaymentEnum {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int cod;
    private String description;


    public static PaymentEnum toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }
        for(PaymentEnum x : PaymentEnum.values()){
            if(cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("ID invalido: " + cod);
    }
}
