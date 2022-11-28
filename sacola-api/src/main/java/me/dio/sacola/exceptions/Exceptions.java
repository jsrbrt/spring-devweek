package me.dio.sacola.exceptions;

import me.dio.sacola.model.Item;
import me.dio.sacola.model.Restaurante;
import me.dio.sacola.model.Sacola;

import javax.swing.*;
import java.util.List;

public class Exceptions {
    public void quantidadeMenorQueUm(Item itemParaSerInserido){
        int quantidade = itemParaSerInserido.getQuantidade();
        if (quantidade < 1) throw new ArithmeticException("A quantidade precisa ser maior que 0.");
    }
    public void restauranteDiferente(Restaurante restauranteAtual, Restaurante restauranteDoItem){
        if(restauranteAtual.equals(restauranteDoItem)) return;
        else
            throw new RuntimeException("Não é possível adicionar produtos de restaurantes diferentes. Feche a sacola ou esvazie.");
    }
    public void sacolaVazia(Sacola sacola){
        if(sacola.getItens().isEmpty()) throw new RuntimeException("Inclua itens na sacola.");
    }
    public void sacolaFechada(Sacola sacola){
        if (sacola.isFechada())
            throw new RuntimeException("Esta sacola já está fechada.");
    }
    public Item itemNaoExiste(Sacola sacola, Long id){
        List<Item> itens = sacola.getItens();
        for (Item item : itens){
            if (item.getId().equals(id)) return item;
        }
        throw new NullPointerException("Este item não existe.");
    }
}
