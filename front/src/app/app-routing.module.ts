import { LanchePadraoComponent } from './cardapio/lanche-padrao/lanche-padrao.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomizadoComponent } from './cardapio/customizado/customizado.component';
import { LancheCustomizadoComponent } from './cardapio/lanche-customizado/lanche-customizado.component';

const routes: Routes = [
  {path: 'cardapio', component: LanchePadraoComponent},
  {path: 'customizados', component: CustomizadoComponent},
  {path: 'criar', component: LancheCustomizadoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
