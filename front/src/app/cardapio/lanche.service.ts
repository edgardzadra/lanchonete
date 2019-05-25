import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class LancheService {

  constructor(private http: HttpClient) { }

  getLanchesDefault(): Promise<any> {
    return this.http.get('api/burguer')
      .toPromise()
      .then(response => response);
  }

  getIngredients(): Promise<any> {
    return this.http.get('api/ingredients')
      .toPromise()
      .then(response => response);
  }

  cadastrarLanche(lanche: any): Promise<any> {
    return this.http.post('api/burguer', lanche)
      .toPromise()
      .then(response => response);
  }

  getLanchesCustom(): Promise<any> {
    return this.http.get('api/burguer/custom')
      .toPromise()
      .then(response => response);
  }
}
