import { Component, OnInit } from '@angular/core';
import { LancheService } from '../lanche.service';

@Component({
  selector: 'app-lanche-customizado',
  templateUrl: './lanche-customizado.component.html',
  styleUrls: ['./lanche-customizado.component.css']
})
export class LancheCustomizadoComponent implements OnInit {

  constructor(private service: LancheService) { }

  ingredientes = [];
  lancheCustomizado = [];
  descricao: string;

  ngOnInit() {
    this.pesquisarIngredientes();
  }

  pesquisarIngredientes() {
    this.service.getIngredients()
      .then(response => {
        this.ingredientes = response;
      });
  }

  adicionarIngrediente(ingrediente: any) {
    this.lancheCustomizado.push(ingrediente);
  }

  removerIngrediente(ingrediente: any) {
    this.lancheCustomizado.splice(this.lancheCustomizado.indexOf(ingrediente), 1);
  }

  cadastrar() {
    const lanche = {description: this.descricao, ingredients: this.lancheCustomizado};

    this.service.cadastrarLanche(lanche)
    .then(response => {
      this.descricao = '';
      this.lancheCustomizado = [];
      console.log(response);
    }).catch(err => {
      alert(err.error.message);
    });
  }

  validarPromoQueijoCarne(ingrediente: string) {

    return this.lancheCustomizado.filter(i => i.description === ingrediente).length >= 3;
  }

  validaPromoLight() {
    const temBacon = this.lancheCustomizado.filter(i => i.description === 'Bacon').length >= 1;
    const temAlface = this.lancheCustomizado.filter(i => i.description === 'Alface').length >= 1;

    if (temAlface && !temBacon) {
      return true;
    }

    if (temBacon) {
      return false;
    }

    return false;
  }
}
