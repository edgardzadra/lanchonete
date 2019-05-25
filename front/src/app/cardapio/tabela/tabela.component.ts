import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-tabela',
  templateUrl: './tabela.component.html',
  styleUrls: ['./tabela.component.css']
})
export class TabelaComponent implements OnInit {

  @Input() lanches = [];

  carrinho = [];

  valorTotal = 0.0;

  constructor() { }

  ngOnInit() {
  }

  adicionarAoPedido(lanche: any) {
    this.carrinho.push(lanche);

    this.valorTotal = this.valorTotal + Number(lanche.totalAmount);
  }

  remover(lanche: any) {
    this.carrinho.splice(this.carrinho.indexOf(lanche), 1);

    this.valorTotal = this.valorTotal - Number(lanche.totalAmount);
  }

}
