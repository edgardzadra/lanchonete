import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LancheCustomizadoComponent } from './lanche-customizado.component';

describe('LancheCustomizadoComponent', () => {
  let component: LancheCustomizadoComponent;
  let fixture: ComponentFixture<LancheCustomizadoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LancheCustomizadoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LancheCustomizadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
