import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlojamientoResultadosComponent } from './alojamiento-resultados.component';

describe('AlojamientoResultadosComponent', () => {
  let component: AlojamientoResultadosComponent;
  let fixture: ComponentFixture<AlojamientoResultadosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AlojamientoResultadosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlojamientoResultadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
