import { LancheService } from './lanche.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LancheCustomizadoComponent } from './lanche-customizado/lanche-customizado.component';
import { LanchePadraoComponent } from './lanche-padrao/lanche-padrao.component';

import {TableModule} from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import {MultiSelectModule} from 'primeng/multiselect';
import { TabelaComponent } from './tabela/tabela.component';
import {CardModule} from 'primeng/card';
import {InputTextModule} from 'primeng/inputtext';
import { FormsModule } from '@angular/forms';
import { CustomizadoComponent } from './customizado/customizado.component';

@NgModule({
  declarations: [LancheCustomizadoComponent, LanchePadraoComponent, TabelaComponent, CustomizadoComponent],
  imports: [
    CommonModule,
    TableModule,
    ButtonModule,
    MultiSelectModule,
    CardModule,
    InputTextModule,
    FormsModule
  ],
  exports: [LancheCustomizadoComponent,
  LanchePadraoComponent, CustomizadoComponent],
  providers: [LancheService]
})
export class CardapioModule { }
