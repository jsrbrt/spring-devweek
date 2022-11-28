package me.dio.sacola.resource.dto;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import me.dio.sacola.model.Item;
import me.dio.sacola.model.Sacola;
import me.dio.sacola.service.SacolaService;
import org.springframework.web.bind.annotation.*;

@Api(value="/devweek/sacola")
@RestController
@RequestMapping("/devweek/sacola")
@RequiredArgsConstructor
public class SacolaResource {
    private final SacolaService sacolaService;
    /*public SacolaResource(SacolaService sacolaService) {
        this.sacolaService = sacolaService;
    }*/
    @PostMapping
    public Item incluirItemNaSacola(@RequestBody ItemDto itemDto){
        return sacolaService.incluirItemNaSacola(itemDto);
    }
    @GetMapping("/{sacolaId}")
    public Sacola verSacola(@PathVariable("sacolaId") Long sacolaId){
        return sacolaService.verSacola(sacolaId);
    }
    @GetMapping("/item/{sacolaId}/{itemId}")
    public Item verItem(@PathVariable("sacolaId")Long sacolaId,
                        @PathVariable("itemId")Long itemId)  {
        return sacolaService.verItemDaSacola(sacolaId, itemId);
    }
    //patch pra poucas mudanças
    @PatchMapping("/fecharSacola/{sacolaId}")
    public Sacola fecharSacola(@PathVariable("sacolaId")Long sacolaId,
                               @RequestParam int formaPagamento)  {
        return sacolaService.fecharSacola(sacolaId, formaPagamento);
    }
    @DeleteMapping("/excluir/{sacolaId}")
    public void excluirSacola(@PathVariable("sacolaId")Long sacolaId){
        sacolaService.excluirTodosItens(sacolaId);
    }
    @DeleteMapping("/excluir/{sacolaId}/{itemId}")
    public void excluirItem(@PathVariable("sacolaId")Long sacolaId,
                            @PathVariable("itemId")Long itemId){
        sacolaService.excluirItemDaSacola(sacolaId, itemId);
    }
}
