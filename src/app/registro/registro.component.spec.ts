import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RegisterComponent } from './registro.component'; // Cambia RegistroComponent a RegisterComponent

describe('RegisterComponent', () => {  // Cambia RegistroComponent a RegisterComponent
  let component: RegisterComponent;
  let fixture: ComponentFixture<RegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegisterComponent]  // Cambia RegistroComponent a RegisterComponent
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
