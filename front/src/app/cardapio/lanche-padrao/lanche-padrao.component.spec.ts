import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LanchePadraoComponent } from './lanche-padrao.component';

describe('LanchePadraoComponent', () => {
  let component: LanchePadraoComponent;
  let fixture: ComponentFixture<LanchePadraoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LanchePadraoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LanchePadraoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
