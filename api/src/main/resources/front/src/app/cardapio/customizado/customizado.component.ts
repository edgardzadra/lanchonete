import { LancheService } from './../lanche.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customizado',
  templateUrl: './customizado.component.html',
  styleUrls: ['./customizado.component.css']
})
export class CustomizadoComponent implements OnInit {

  constructor(private service: LancheService) { }

  lanches = [];

  ngOnInit() {
    this.pesquisar();
  }

  pesquisar() {
    this.service.getLanchesCustom()
      .then(response => {
        this.lanches = response;
      });
  }
}
