package me.dio.sacola.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.sacola.exceptions.Exceptions;
import me.dio.sacola.resource.dto.ItemDto;
import me.dio.sacola.enumeration.FormaPagamento;
import me.dio.sacola.model.Item;
import me.dio.sacola.model.Restaurante;
import me.dio.sacola.model.Sacola;
//import me.dio.sacola.repository.ItemRepository;
import me.dio.sacola.repository.ProdutoRepository;
import me.dio.sacola.repository.SacolaRepository;
import me.dio.sacola.service.SacolaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SacolaServiceImpl implements SacolaService {
    private final SacolaRepository sacolaRepository;
    private final ProdutoRepository produtoRepository;
    //private final ItemRepository itemRepository;
    Exceptions exceptions = new Exceptions();
    @Override
    public Item incluirItemNaSacola(ItemDto itemDto) {
        Sacola sacola = verSacola(itemDto.getSacolaId());
            exceptions.sacolaFechada(sacola);
            Item itemParaSerInserido = Item
                    .builder()
                    .quantidade(itemDto.getQuantidade())
                    .sacola(sacola)
                    .produto(produtoRepository.findById(itemDto.getProdutoId()).orElseThrow(()
                            -> new NullPointerException("Esse produto não existe.")))
                    .build();

        exceptions.quantidadeMenorQueUm(itemParaSerInserido);

        List<Item> itens = sacola.getItens();
            if(itens.isEmpty())
                itens.add(itemParaSerInserido);
            else {
                Restaurante restauranteAtual = itens.get(0).getProduto().getRestaurante();
                Restaurante restauranteDoItem = itemParaSerInserido.getProduto().getRestaurante();
                exceptions.restauranteDiferente(restauranteAtual, restauranteDoItem);
                itens.add(itemParaSerInserido);
            }
        List<Double> valorTotalItens = new ArrayList<>();
            for (Item itemDaSacola : itens){
                double valorItem =
                   itemDaSacola.getProduto().getValorUnitario() * itemDaSacola.getQuantidade();
                valorTotalItens.add(valorItem);
            }
        Double valorTotalSacola = 0d;
            for (Double valorDeCadaItem : valorTotalItens){
                valorTotalSacola += valorDeCadaItem;
            }
        /*double valorTotalSacolaa =
                valorTotalItens.stream()
                               .mapToDouble(valorDeCadaItem -> valorDeCadaItem)
                               .sum();

        sacola.setValorTotal(valorTotalSacolaa);*/
        sacola.setValorTotal(valorTotalSacola);
        sacolaRepository.save(sacola);
        return itemParaSerInserido;
    }
    @Override
    public Sacola verSacola(Long id) {
        return sacolaRepository.findById(id).orElseThrow(()
            -> new RuntimeException("Essa sacola não existe!"));
    }
    @Override
    public Sacola fecharSacola(Long id, int numeroFormaPagamento) {
        Sacola sacola = verSacola(id);
        exceptions.sacolaFechada(sacola);
        exceptions.sacolaVazia(sacola);
        FormaPagamento formaPagamento =
            numeroFormaPagamento == 0 ? FormaPagamento.DINHEIRO : FormaPagamento.MAQUINETA;
        sacola.setFormaPagamento(formaPagamento);
        sacola.setFechada(true);
        return sacolaRepository.save(sacola);
    }
    @Override
    public Item verItemDaSacola(Long sacolaId, Long id) {
        Sacola sacola = verSacola(sacolaId);
        return exceptions.itemNaoExiste(sacola, id);
    }
    @Override
    public void excluirItemDaSacola(Long sacolaId, Long itemId){
        Sacola sacola = verSacola(sacolaId);
        exceptions.sacolaFechada(sacola);
        List<Item> itens = sacola.getItens();
        Item itemDeletado = verItemDaSacola(sacolaId, itemId);

        double valorItemDeletado = itemDeletado.getProduto().getValorUnitario() * itemDeletado.getQuantidade();
        double valorNovo = sacola.getValorTotal() - valorItemDeletado;
            sacola.setValorTotal(valorNovo);
            itens.remove(itemDeletado);

        sacolaRepository.save(sacola);
    }
    @Override
    public void excluirTodosItens(Long id){
        Sacola sacola = verSacola(id);
        List<Item> itens = sacola.getItens();
        itens.clear();
    }
}
