package br.com.itb.miniprojetospring.service;

import br.com.itb.miniprojetospring.model.Produto;
import br.com.itb.miniprojetospring.model.ProdutoRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;
    @Mock
    private ProdutoService produtoService;

    @BeforeEach
    void setup() {
        produtoRepository = Mockito.mock(ProdutoRepository.class);
        produtoService = new ProdutoService(produtoRepository);
    }

    @Test
    public void saveTest(){
        Produto produto = new Produto(1, "bolacha");
        when(produtoRepository.save(produto)).thenReturn(produto);

        assertEquals(produto.getId(), 1);
    }

    @Test
    public void findAllByIdTest(){
        Produto produto = new Produto(1, "bolacha");
        when(produtoRepository.findAllById(produto.getId())).thenReturn(produto);
        Produto produtoRetornado = this.produtoService.findAllById(1L);

        assertEquals(produto, produtoRetornado);
        verify(this.produtoRepository).findAllById(1L);
    }

    @Test
    public void findAllTest(){
        Produto produto = new Produto(1, "bolacha");
        List<Produto> listaProdutos = new ArrayList();
        listaProdutos.add(produto);
        when(produtoRepository.findAll()).thenReturn(listaProdutos);
        List<Produto> listaProdutosRetornados = this.produtoService.findAll();

        assertEquals(listaProdutos, listaProdutosRetornados);
        verify(this.produtoRepository).findAll();
    }



}
