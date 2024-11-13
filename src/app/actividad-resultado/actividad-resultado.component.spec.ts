import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActividadResultadoComponent } from './actividad-resultado.component';

describe('ActividadResultadoComponent', () => {
  let component: ActividadResultadoComponent;
  let fixture: ComponentFixture<ActividadResultadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActividadResultadoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ActividadResultadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
