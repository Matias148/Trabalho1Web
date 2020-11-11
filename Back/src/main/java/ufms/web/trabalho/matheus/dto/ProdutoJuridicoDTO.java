package ufms.web.trabalho.matheus.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ufms.web.trabalho.matheus.entity.Produto;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ProdutoJuridicoDTO {

    private Long id;
    private String descricao;
    private Long quantidadeEstoque;
    private BigDecimal precoCompra;
    private BigDecimal precoVenda;

    public static ProdutoJuridicoDTO transformaEmDTO(Produto produto) {
        return new ProdutoJuridicoDTO(produto.getId(), produto.getDescricao(), produto.getQuantidadeEstoque(),
                produto.getPrecoCompra(), produto.getPrecoVendaJuridica());
    }
}
