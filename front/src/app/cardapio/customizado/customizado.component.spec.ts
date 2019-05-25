import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomizadoComponent } from './customizado.component';

describe('CustomizadoComponent', () => {
  let component: CustomizadoComponent;
  let fixture: ComponentFixture<CustomizadoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomizadoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomizadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
