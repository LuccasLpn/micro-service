package br.com.lib.modules.request;

import br.com.lib.modules.dto.Product;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest implements Serializable {
    private Long id;
    private Product product;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}

