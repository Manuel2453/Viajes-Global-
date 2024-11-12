import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrasladoResultadoComponent } from './traslado-resultado.component';

describe('TrasladoResultadoComponent', () => {
  let component: TrasladoResultadoComponent;
  let fixture: ComponentFixture<TrasladoResultadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TrasladoResultadoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TrasladoResultadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
