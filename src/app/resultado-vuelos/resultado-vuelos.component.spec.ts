import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultadoVuelosComponent } from './resultado-vuelos.component';

describe('ResultadoVuelosComponent', () => {
  let component: ResultadoVuelosComponent;
  let fixture: ComponentFixture<ResultadoVuelosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ResultadoVuelosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResultadoVuelosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
