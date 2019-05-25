import { LancheService } from './../lanche.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lanche-padrao',
  templateUrl: './lanche-padrao.component.html',
  styleUrls: ['./lanche-padrao.component.css']
})
export class LanchePadraoComponent implements OnInit {

  constructor(private service: LancheService) { }

  lanches = [];

  ngOnInit() {
    this.pesquisar();
  }

  pesquisar() {
    this.service.getLanchesDefault()
      .then(response => {
        this.lanches = response;
      });
  }
}
