import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultadoVuelosRegresoComponent } from './resultado-vuelos-regreso.component';

describe('ResultadoVuelosRegresoComponent', () => {
  let component: ResultadoVuelosRegresoComponent;
  let fixture: ComponentFixture<ResultadoVuelosRegresoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ResultadoVuelosRegresoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResultadoVuelosRegresoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
