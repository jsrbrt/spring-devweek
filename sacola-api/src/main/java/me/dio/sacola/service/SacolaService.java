package me.dio.sacola.service;

import me.dio.sacola.resource.dto.ItemDto;
import me.dio.sacola.model.Item;
import me.dio.sacola.model.Sacola;

public interface SacolaService {
    Item incluirItemNaSacola(ItemDto itemDto);
    Sacola verSacola(Long id);
    Sacola fecharSacola(Long id, int formaPagamento);
    Item verItemDaSacola(Long sacolaId, Long id);
    void excluirTodosItens(Long id);
    void excluirItemDaSacola(Long sacolaId, Long itemId);
}
