import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class LancheService {

  constructor(private http: HttpClient) { }

  getLanchesDefault(): Promise<any> {
    return this.http.get('http://localhost:8080/burguer')
      .toPromise()
      .then(response => response);
  }

  getIngredients(): Promise<any> {
    return this.http.get('http://localhost:8080/ingredients')
      .toPromise()
      .then(response => response);
  }

  cadastrarLanche(lanche: any): Promise<any> {
    return this.http.post('http://localhost:8080/burguer', lanche)
      .toPromise()
      .then(response => response);
  }

  getLanchesCustom(): Promise<any> {
    return this.http.get('http://localhost:8080/burguer/custom')
      .toPromise()
      .then(response => response);
  }
}
